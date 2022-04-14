package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity {
    private EditText LoginId;
    private EditText Password;
    private Button button ;
    private boolean IsSuccess=false;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LoginId= findViewById(R.id.editTextEmail);
        Password= findViewById(R.id.editTextPassword);
        button= (Button) findViewById(R.id.cirLoginButton);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String loginid=LoginId.getText().toString();
                String password=Password.getText().toString();
                if(loginid !="" && password!=""){
                    String HashPass=AppConst.getMd5(password);
                    Login(loginid,HashPass);
                    if(IsSucceed()){
                        Intent switchActivityIntent = new Intent(LoginActivity.this, MenuActivity.class);
                        startActivity(switchActivityIntent);
                        overridePendingTransition(R.anim.slide_in_right,R.anim.stay);
                    }
                    else{
                        Toast.makeText(LoginActivity.this,"Failed To Login",Toast.LENGTH_SHORT).show();
                    }

                }
                else{
                    Toast.makeText(LoginActivity.this,"Please Enter your Credentials",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private boolean IsSucceed(){
        return IsSuccess;
    }
    private void LogInSucceed(){
        IsSuccess=true;
    }
    private void LogInFailed(){
        IsSuccess=false;
    }


    public void onRegisterClick(View View){
        Intent switchActivityIntent = new Intent(this, RegisterActivity.class);
        startActivity(switchActivityIntent);
        overridePendingTransition(R.anim.slide_in_right,R.anim.stay);
    }
    public void Login(String LogInID,String md5Password){


        Repository repo2= RetrofitClient.getRetrofitInstance()
                .create(Repository.class);
        Call<ArrayList<Userinfo>> call2= repo2.tryLogin(LogInID,md5Password);
        try{
            call2.enqueue(new Callback<ArrayList<Userinfo>>() {
                @Override
                public void onResponse(Call<ArrayList<Userinfo>> call2, Response<ArrayList<Userinfo>> response) {
                    Gson gson = new Gson();
                    Log.e("Hridoy","onResponse: code :"+response);
                    ArrayList<Userinfo> arrUserInfo= response.body();
                    AppConst.setUser(arrUserInfo.get(0));
                    if(arrUserInfo.get(0).getRescode()=="0"){LogInFailed();}
                    else{LogInSucceed();}
                    Log.e("resp","onResponse: code :"+arrUserInfo.get(0).getLoginid());
                }

                @Override
                public void onFailure(Call<ArrayList<Userinfo>> call, Throwable t) {
                    Log.e("HridoyError",t.getMessage());
                    LogInFailed();
                }
            });
        }
        catch (Exception ex){
            LogInFailed();
            Log.e("Hridoy",ex.getMessage());
        }
    }
}
