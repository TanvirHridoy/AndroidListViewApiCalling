package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
private ListView dataListView;
    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        setTitle("Ticket List");
        dataListView= findViewById(R.id.dataListView);
        getData();

        dataListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e("ListClick", "position"+position+"id"+id);
                Intent switchActivityIntent = new Intent(MainActivity.this, Ticket_Edit_View.class);
                switchActivityIntent.putExtra("TicketId",AppConst.getAdminTickets().get(position).getTicketid());
                startActivity(switchActivityIntent);
            }
        });
    }

    private void getData(){
        Repository repo2= RetrofitClient.getRetrofitInstance()
                .create(Repository.class);
        Call<ArrayList<Ticket>> call2= repo2.getAllData();
        call2.enqueue(new Callback<ArrayList<Ticket>>(){
            @Override
            public void onResponse(Call<ArrayList<Ticket>> call2, Response<ArrayList<Ticket>> response) {
                Log.e("Hridoy","onResponse: code :"+response.code());
                AppConst.setAdminTickets(response.body());
                DataAdapter adapter = new DataAdapter(MainActivity.this,R.layout.list_row,AppConst.getAdminTickets());
                dataListView.setAdapter(adapter);
            }
            @Override
            public void onFailure(Call<ArrayList<Ticket>> call, Throwable t) {
                Log.e("Hridoy",t.getMessage());
            }
        });

    }
}