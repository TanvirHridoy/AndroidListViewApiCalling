package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Repository {

    @GET(AppConst.ticket)
    Call<ArrayList<TicketModel.Ticket>> getAllData();

    @GET(AppConst.resinf)
    Call<ArrayList<TicketModel.Resinf>> getModules();

}
