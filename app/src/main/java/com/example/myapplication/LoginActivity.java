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
                }
                else{
                    Toast.makeText(LoginActivity.this,"Please Enter your Credentials",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    public void onRegisterClick(View View){
        Intent switchActivityIntent = new Intent(this, RegisterActivity.class);
        startActivity(switchActivityIntent);
        overridePendingTransition(R.anim.slide_in_right,R.anim.stay);
    }
    public void Login(String LogInID,String md5Password){
        Repository repo2= RetrofitClient.getRetrofitInstance()
                .create(Repository.class);
        Call<LoggedInUser> call2= repo2.tryLogin(LogInID,md5Password);
        try{
            call2.enqueue(new Callback<LoggedInUser>() {
                @Override
                public void onResponse(Call<LoggedInUser> call2, Response<LoggedInUser> response) {
                    Gson gson = new Gson();
                    Log.e("Hridoy","onResponse: code :"+response);
                    LoggedInUser arrUserInfo= response.body();
                    AppConst.setUser(arrUserInfo);
                    LoggedInUser l= AppConst.getUser();
                    if(arrUserInfo.getRescode()=="0" ||arrUserInfo.getRescode()== null){
                        Toast.makeText(LoginActivity.this,"Failed To Login",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Intent switchActivityIntent = new Intent(LoginActivity.this, MenuActivity.class);
                        startActivity(switchActivityIntent);
                        overridePendingTransition(R.anim.slide_in_right,R.anim.stay);
                    }
                    Log.e("resp","onResponse:"+arrUserInfo.getLoginid());
                }

                @Override
                public void onFailure(Call<LoggedInUser> call, Throwable t) {
                    Log.e("HridoyError",t.getMessage());
                    Toast.makeText(LoginActivity.this,"Failed To Login",Toast.LENGTH_SHORT).show();
                }
            });
        }
        catch (Exception ex){
            Toast.makeText(LoginActivity.this,"Failed To Login",Toast.LENGTH_SHORT).show();
            Log.e("Hridoy",ex.getMessage());
        }
    }
}
