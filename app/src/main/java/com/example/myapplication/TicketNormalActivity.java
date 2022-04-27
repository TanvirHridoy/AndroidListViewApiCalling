package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TicketNormalActivity extends AppCompatActivity {

    private TextView IssuedBy;
    private TextView IssueDate;
    private TextView PModule;
    private TextView PPage;
    private EditText PDesc;
    private EditText SDesc;
    private TextView PStatus;
    private TextView PPriority;
    private ImageView PImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_normal);
        IssuedBy=findViewById(R.id.IssuedBy);
        IssueDate=findViewById(R.id.IssueDate);
        PModule=findViewById(R.id.PModule);
        PPage=findViewById(R.id.PPage);
        PDesc=findViewById(R.id.PDesc);
        SDesc=findViewById(R.id.SDesc);
        PStatus=findViewById(R.id.PStatus);
        PPriority=findViewById(R.id.PPriority);
        PImage=findViewById(R.id.PImage);
        Intent intent = getIntent();
        int TicketId=intent.getIntExtra("TicketId",0);
        populateTicketinfo(TicketId);
    }



    public void populateTicketinfo(int tId){
        Repository repo2= RetrofitClient.getRetrofitInstance()
                .create(Repository.class);
        Call<Ticket> call2= repo2.getTicketById(tId);
        call2.enqueue(new Callback<Ticket>(){
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onResponse(Call<Ticket> call2, Response<Ticket> response) {
                Log.e("Hridoy","onResponse: code :"+response.code());

                Ticket t= response.body();
                InitJinfo ud=t.getUserinfo().getUserdata();
                IssuedBy.setText(t.getUserinfo().getUserdata().getFullname()+" " +t.getUserinfo().getLoginid()+","+t.getUserinfo().getUserdata().getDesignation());
                IssueDate.setText(t.getBegintime());
                PModule.setText(t.getModule());
                PPage.setText(t.getPage());
                PDesc.setText(t.getTicketdes());
                SDesc.setText(t.getStatusdesc());
                PStatus.setText(t.getStatuscodeD());
                PPriority.setText(t.getPriorityD());
                Log.e("fileur", t.getFileurlD() );
                Picasso.get().load(t.getFileurlD()).into(PImage);
            }
            @Override
            public void onFailure(Call<Ticket> call, Throwable t) {
                Log.e("Hridoy",t.getMessage());
            }
        });
    }
}