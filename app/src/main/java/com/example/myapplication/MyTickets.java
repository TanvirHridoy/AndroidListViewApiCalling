package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyTickets extends AppCompatActivity {
    private ListView dataListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_tickets);
        dataListView= findViewById(R.id.dataListView2);
        getData();

        dataListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e("ListClick", "position"+position+"id"+id);
                Intent switchActivityIntent = new Intent(MyTickets.this, TicketNormalActivity.class);
                switchActivityIntent.putExtra("TicketId",AppConst.getUserTickets().get(position).getTicketid());
                startActivity(switchActivityIntent);
            }
        });
    }

    private void getData(){
        Repository repo2= RetrofitClient.getRetrofitInstance()
                .create(Repository.class);
        Call<ArrayList<Ticket>> call2= repo2.getAllData();
        call2.enqueue(new Callback<ArrayList<Ticket>>(){
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<ArrayList<Ticket>> call2, Response<ArrayList<Ticket>> response) {
                Log.e("Hridoy","onResponse: code :"+response.code());
                ArrayList<Ticket> tempDtList=new ArrayList<>();
                ArrayList<Ticket> tempDtList2=response.body();

                for(int i=0;i<tempDtList2.size();i++){

                    if(tempDtList2.get(i).getUsercode().trim().equals(AppConst.getUser().getRescode().trim())){
                        Log.e("Testing", "Got here");
                        tempDtList.add(tempDtList2.get(i));
                    }
                }
                AppConst.setUserTickets(tempDtList);
                DataAdapter adapter = new DataAdapter(MyTickets.this,R.layout.list_row,AppConst.getUserTickets());
                dataListView.setAdapter(adapter);
            }
            @Override
            public void onFailure(Call<ArrayList<Ticket>> call, Throwable t) {
                Log.e("Hridoy",t.getMessage());
            }
        });

    }
}