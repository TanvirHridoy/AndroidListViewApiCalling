package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    private Button CreateToken;
    private Button TicketList;
    private Button MyTicketList;
    private Button UserList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        CreateToken= findViewById(R.id.btnCreateTicket);
        TicketList= findViewById(R.id.btnTicketList);
        MyTicketList=findViewById(R.id.btnMyTickets);
        UserList=findViewById(R.id.btnUserList);

        if(AppConst.getUser()!=null){
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
    }

    private void activateUserMode(){
        TicketList.setVisibility(View.GONE);
        UserList.setVisibility(View.GONE);
        MyTicketList.setVisibility(View.VISIBLE);
    }
    public void onBtnTicketListClick(View View){

        Intent switchActivityIntent = new Intent(this, MainActivity.class);
        startActivity(switchActivityIntent);
        overridePendingTransition(R.anim.slide_in_right,R.anim.stay);

    }
    public void onBtnUserListClick(View View){



    }
    public void onBtnMyTicketListClick(View View){



    }
    public void onBtnCreateTokenClick(View View){



    }

}