package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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

        setTitle("Ticket List");
        dataListView= findViewById(R.id.dataListView);
        getData();
    }

    private void getData(){
        Repository repo2= RetrofitClient.getRetrofitInstance()
                .create(Repository.class);
        Call<ArrayList<TicketModel.Ticket>> call2= repo2.getAllData();
        call2.enqueue(new Callback<ArrayList<TicketModel.Ticket>>(){
            @Override
            public void onResponse(Call<ArrayList<TicketModel.Ticket>> call2, Response<ArrayList<TicketModel.Ticket>> response) {
                Log.e("Hridoy","onResponse: code :"+response.code());
                ArrayList<TicketModel.Ticket> dataLst= response.body();
                DataAdapter adapter = new DataAdapter(MainActivity.this,R.layout.list_row,dataLst);
                dataListView.setAdapter(adapter);
            }
            @Override
            public void onFailure(Call<ArrayList<TicketModel.Ticket>> call, Throwable t) {
                Log.e("Hridoy",t.getMessage());
            }
        });

    }
}