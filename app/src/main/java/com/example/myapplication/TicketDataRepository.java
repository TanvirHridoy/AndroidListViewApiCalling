package com.example.myapplication;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TicketDataRepository {

    public final static ArrayList<TicketModel.Ticket> GetTicketData(String Rescode){


         ArrayList<TicketModel.Ticket> result= new ArrayList<TicketModel.Ticket>();
        Repository repo2= RetrofitClient.getRetrofitInstance()
                .create(Repository.class);
        Call<ArrayList<TicketModel.Ticket>> call2= repo2.getAllData();
            call2.enqueue(new Callback<ArrayList<TicketModel.Ticket>>() {
                @Override
                public void onResponse(Call<ArrayList<TicketModel.Ticket>> call2, Response<ArrayList<TicketModel.Ticket>> response) {
                    Log.e("Hridoy","onResponse: code :"+response.code());
                    ArrayList<TicketModel.Ticket> dataLst= response.body();
                    if(Rescode.length()==0){
                        result.addAll(dataLst);
                    }
                    else{
                        for (TicketModel.Ticket x:dataLst) {
                            if(x.getUsercode()==Rescode){
                                result.add(x);
                            }
                        }
                    }

                   // Log.e("resp","onResponse: code :"+result.get(0).getTicketdes());

                }

                @Override
                public void onFailure(Call<ArrayList<TicketModel.Ticket>> call, Throwable t) {
                    Log.e("Hridoy",t.getMessage());
                }
            });
        return result;
    }

}
