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

    public final static ArrayList<Ticket> GetTicketData(String Rescode){


         ArrayList<Ticket> result= new ArrayList<Ticket>();
        Repository repo2= RetrofitClient.getRetrofitInstance()
                .create(Repository.class);
        Call<ArrayList<Ticket>> call2= repo2.getAllData();
            call2.enqueue(new Callback<ArrayList<Ticket>>() {
                @Override
                public void onResponse(Call<ArrayList<Ticket>> call2, Response<ArrayList<Ticket>> response) {
                    Log.e("Hridoy","onResponse: code :"+response.code());
                    ArrayList<Ticket> dataLst= response.body();
                    if(Rescode.length()==0){
                        result.addAll(dataLst);
                    }
                    else{
                        for (Ticket x:dataLst) {
                            if(x.getUsercode()==Rescode){
                                result.add(x);
                            }
                        }
                    }

                   // Log.e("resp","onResponse: code :"+result.get(0).getTicketdes());

                }

                @Override
                public void onFailure(Call<ArrayList<Ticket>> call, Throwable t) {
                    Log.e("Hridoy",t.getMessage());
                }
            });
        return result;
    }

}
