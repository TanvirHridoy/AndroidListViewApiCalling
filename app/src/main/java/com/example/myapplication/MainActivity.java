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
private Button getData;
private ListView dataListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getData= findViewById(R.id.getData);
        dataListView= findViewById(R.id.dataListView);
        getData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Repository repo= RetrofitClient.getRetrofitInstance()
//                       .create(Repository.class);
//                Call<ArrayList<TicketModel.Resinf>> call= repo.getModules();
//                call.enqueue(new Callback<ArrayList<TicketModel.Resinf>>() {
//                    @Override
//                    public void onResponse(Call<ArrayList<TicketModel.Resinf>> call, Response<ArrayList<TicketModel.Resinf>> response) {
//                        Log.e("Hridoy","onResponse: code :"+response.code());
//                        ArrayList<TicketModel.Resinf> dataLst= response.body();
//
//                        Log.e("resp","onResponse: code :"+dataLst.get(0).getRescode());
//                        ResninfDataAdapter adapter = new ResninfDataAdapter(MainActivity.this,R.layout.list_row,dataLst);
//                        dataListView.setAdapter(adapter);
////                        ArrayList<String> emailList= new ArrayList<String>();
////
////                        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,emailList);
////
//                    }
//
//                    @Override
//                    public void onFailure(Call<ArrayList<TicketModel.Resinf>> call, Throwable t) {
//                        Log.e("Hridoy",t.getMessage());
//                    }
//                });

                Repository repo2= RetrofitClient.getRetrofitInstance()
                        .create(Repository.class);
                Call<ArrayList<TicketModel.Ticket>> call2= repo2.getAllData();
                try{
                    call2.enqueue(new Callback<ArrayList<TicketModel.Ticket>>() {
                        @Override
                        public void onResponse(Call<ArrayList<TicketModel.Ticket>> call2, Response<ArrayList<TicketModel.Ticket>> response) {
                            Log.e("Hridoy","onResponse: code :"+response.code());
                            ArrayList<TicketModel.Ticket> dataLst= response.body();

                            Log.e("resp","onResponse: code :"+dataLst.get(0).getTicketdes());
                            DataAdapter adapter = new DataAdapter(MainActivity.this,R.layout.list_row,dataLst);
                            dataListView.setAdapter(adapter);
//                        ArrayList<String> emailList= new ArrayList<String>();
//
//                        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,emailList);
//
                        }

                        @Override
                        public void onFailure(Call<ArrayList<TicketModel.Ticket>> call, Throwable t) {
                            Log.e("Hridoy",t.getMessage());
                        }
                    });
                }
                catch (Exception ex){

                    Log.e("Hridoy",ex.getMessage());
                }

            }
        });
    }
}