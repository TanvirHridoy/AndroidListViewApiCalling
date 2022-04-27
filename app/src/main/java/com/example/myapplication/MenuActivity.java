package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MenuActivity extends AppCompatActivity {

    private Button CreateToken;
    private Button TicketList;
    private Button MyTicketList;
    private Button UserList;
    private ImageView UserPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        CreateToken= findViewById(R.id.btnCreateTicket);
        TicketList= findViewById(R.id.btnTicketList);
        MyTicketList=findViewById(R.id.btnMyTickets);
        UserList=findViewById(R.id.btnUserList);
        UserPhoto=findViewById(R.id.LoggedUserPhoto);

        setTitle("Main Menu");
        if(AppConst.getUser()!=null){
            LoggedInUser l=AppConst.getUser();
            if(AppConst.getUser().getRescode().startsWith("95010020") || AppConst.getUser().getRescode().startsWith("95010010")){
                activateAdminMode();
            }
            else if(AppConst.getUser().getRescode().startsWith("957300")){
                activateUserMode();
            }
            else{
                Intent switchActivityIntent = new Intent(this, LoginActivity.class);
                startActivity(switchActivityIntent);
            }
        }
    }

    private void activateAdminMode(){
        TicketList.setVisibility(View.VISIBLE);
        UserList.setVisibility(View.VISIBLE);
        MyTicketList.setVisibility(View.GONE);
        Picasso.get().load(AppConst.getUser().getImageurl()).into(UserPhoto);
    }

    private void activateUserMode(){
        TicketList.setVisibility(View.GONE);
        UserList.setVisibility(View.GONE);
        MyTicketList.setVisibility(View.VISIBLE);
        Picasso.get().load(AppConst.getUser().getImageurl()).into(UserPhoto);
    }
    public void onBtnTicketListClick(View View){

        Intent switchActivityIntent = new Intent(this, MainActivity.class);
        startActivity(switchActivityIntent);
       // overridePendingTransition(R.anim.slide_in_right,R.anim.stay);

    }
    public void onBtnUserListClick(View View){

        Intent switchActivityIntent = new Intent(this, UsersActivity.class);
        startActivity(switchActivityIntent);


    }
    public void onBtnMyTicketListClick(View View){

        Intent switchActivityIntent = new Intent(this, MyTickets.class);
        startActivity(switchActivityIntent);

    }
    public void onBtnLogoutClick(View View){

        AppConst.setUser(null);
        Intent switchActivityIntent = new Intent(this, LoginActivity.class);
        startActivity(switchActivityIntent);

    }
    public void onBtnCreateTokenClick(View View){
        Intent switchActivityIntent = new Intent(this, CreateActivity.class);
        startActivity(switchActivityIntent);


    }



}