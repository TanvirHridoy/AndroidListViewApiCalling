package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.opengl.Visibility;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserInfoActivity extends AppCompatActivity {

    private TextView Application;
    private TextView LoginId;
    private TextView FullName;
    private TextView Email;
    private TextView PhoneNo;
    private TextView Designation;
    private ImageView UserPhoto;
    private Button BtnActivate;
    private Button BtnDeActivate;
    private Button BtnDelete;
    private Userinfo u;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        Application=findViewById(R.id.Application);
        LoginId=findViewById(R.id.LogInID);
        FullName=findViewById(R.id.FullName);
        Email=findViewById(R.id.Email);
        PhoneNo=findViewById(R.id.Phone);
        Designation=findViewById(R.id.Designation);
        UserPhoto=findViewById(R.id.UserPhoto);
        BtnActivate=findViewById(R.id.btnActivate);
        BtnDeActivate=findViewById(R.id.btnDeactivate);
        BtnDelete=findViewById(R.id.btnDelete);
        Intent intent = getIntent();
        int position=intent.getIntExtra("UserInfoId",0);
        PopulateData(position);


        //button click event
        BtnDeActivate.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.e("Clicked", "BtnDeActivate: " );
                DeactivateUser();
            }
        });

        BtnActivate.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.e("Clicked", "BtnActivate: " );
                ActivateUser();
            }
        });

        BtnDelete.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.e("Clicked", "BtnDelete: " );
                DeleteUser();
            }
        });

    }

    private void UserIsActive(){
        BtnActivate.setVisibility(View.GONE);
        BtnDeActivate.setVisibility(View.VISIBLE);
    }
    private void UserIsInActive(){
        BtnDeActivate.setVisibility(View.GONE);
        BtnActivate.setVisibility(View.VISIBLE);
    }

    private  void PopulateData(int p){
         u= AppConst.getUserLists().get(p);
        if(u.isIsactive())
            {UserIsActive();}
        else
            {UserIsInActive();}
        Application.setText("Demo ERP PROJECT");
        LoginId.setText(u.getLoginid());
        FullName.setText(u.getUserdata().getFullname());
        Email.setText(u.getUserdata().getEmail());
        PhoneNo.setText(u.getUserdata().getPhoneNo());
        Designation.setText(u.getUserdata().getDesignation());
        Picasso.get().load(u.getImageurl()).into(UserPhoto);

    }

    private void DeactivateUser(){
        Repository repo2= RetrofitClient.getRetrofitInstance()
                .create(Repository.class);
        u.setIsactive(false);
        File file = new File(u.getImageurl());
        u.setImageurl(file.getName());
        Call<Boolean> call2= repo2.updateUserInfo(u);
        call2.enqueue(new Callback<Boolean>(){
            @Override
            public void onResponse(Call<Boolean> call2, Response<Boolean> response) {
               Boolean r=response.body();
                if(r){
                    Toast.makeText(UserInfoActivity.this, "User Deactivated Successfully", Toast.LENGTH_SHORT).show();
                    UserIsInActive();
                }
                Log.e("Method Deactivate user",r.toString());
            }
            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                Log.e("Method Deactivate user",t.getMessage());
            }
        });
    }
    private void ActivateUser(){
        Repository repo2= RetrofitClient.getRetrofitInstance()
                .create(Repository.class);
        u.setIsactive(true);
        File file = new File(u.getImageurl());
        u.setImageurl(file.getName());
        Call<Boolean> call2= repo2.updateUserInfo(u);
        call2.enqueue(new Callback<Boolean>(){
            @Override
            public void onResponse(Call<Boolean> call2, Response<Boolean> response) {
                Boolean r=response.body();
                if(r){
                    Toast.makeText(UserInfoActivity.this, "User Activated Successfully", Toast.LENGTH_SHORT).show();
                    UserIsActive();
                }
                Log.e("Method Activate user",r.toString());
            }
            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                Log.e("Method Activate user",t.getMessage());
            }
        });
    }
    private void DeleteUser(){
        Repository repo2= RetrofitClient.getRetrofitInstance()
                .create(Repository.class);

        Call<Boolean> call2= repo2.deleteUserInfo(u.getRescode());
        call2.enqueue(new Callback<Boolean>(){
            @Override
            public void onResponse(Call<Boolean> call2, Response<Boolean> response) {
                Boolean r=response.body();
                if(r){
                    Toast.makeText(UserInfoActivity.this, "User Deleted Successfully", Toast.LENGTH_SHORT).show();
                }
                Log.e("Method Delete user",r.toString());
            }
            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                Log.e("Method Delete user",t.getMessage());
            }
        });
    }
}