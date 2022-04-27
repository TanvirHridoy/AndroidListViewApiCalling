package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Repository {

    @GET(AppConst.ticket)
    Call<ArrayList<Ticket>> getAllData();

    @GET(AppConst.ticket+"/{id}")
    Call<Ticket> getTicketById(@Path("id") int id);

    @POST(AppConst.ticket)
    Call<Ticket> postTicket(@Body Ticket ticket);

    @PUT(AppConst.ticket)
    Call<Boolean> putTicket(@Body Ticket ticket);

    @GET(AppConst.resinf)
    Call<ArrayList<Resinf>> getModules(@Query("Rescode") String Rescode,@Query("Type") String Type);

    @GET(AppConst.UserInfo+"/{Loginid}/{Password}")
    Call<LoggedInUser> tryLogin(@Path("Loginid") String Loginid,@Path("Password") String Password);

    @GET(AppConst.UserInfo)
    Call<ArrayList<Userinfo>> getUsersList();

    @PUT(AppConst.UserInfo)
    Call<Boolean> updateUserInfo(@Body Userinfo userinfo);

    @DELETE(AppConst.UserInfo+"/{id}")
    Call<Boolean> deleteUserInfo(@Path("id") String resCode);
}
