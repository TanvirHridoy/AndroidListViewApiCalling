package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsersActivity extends AppCompatActivity {
    private ListView dataListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        setTitle("User List");
        dataListView= findViewById(R.id.UserListView);
        getData();

        dataListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e("ListClick", "position"+position+"id"+id);

                Intent switchActivityIntent = new Intent(UsersActivity.this, UserInfoActivity.class);
                switchActivityIntent.putExtra("UserInfoId",position);
                startActivity(switchActivityIntent);
            }
        });
    }

    private void getData(){
        Repository repo2= RetrofitClient.getRetrofitInstance()
                .create(Repository.class);
        Call<ArrayList<Userinfo>> call2= repo2.getUsersList();
        call2.enqueue(new Callback<ArrayList<Userinfo>>(){
            @Override
            public void onResponse(Call<ArrayList<Userinfo>> call2, Response<ArrayList<Userinfo>> response) {
                AppConst.setUserLists(response.body());

                UserDataAdapter adapter = new UserDataAdapter(UsersActivity.this,R.layout.list_user,AppConst.getUserLists());
                dataListView.setAdapter(adapter);
            }
            @Override
            public void onFailure(Call<ArrayList<Userinfo>> call, Throwable t) {
                Log.e("Hridoy",t.getMessage());
            }
        });

    }
}