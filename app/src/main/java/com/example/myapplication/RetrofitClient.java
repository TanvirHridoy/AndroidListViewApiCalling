package com.example.myapplication;

import android.content.Context;
import android.content.res.Resources;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static OkHttpClient  okHttpClient = UnsafeOkHttpClient.getUnsafeOkHttpClient();
    private static Retrofit retrofit;
    private static String BaseURL=AppConst.rootUrl;//"http://erp1.bepza.gov.bd:82/api/";
    public static Retrofit getRetrofitInstance(){
        if(retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(BaseURL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
