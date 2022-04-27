package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateTicketActivity extends AppCompatActivity {
private Spinner moduleSpinner;
private Spinner pageSpinner;
private Spinner categorySpinner;
private Spinner typeSpinner;
private Spinner prioritySpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_ticket);
        moduleSpinner=(Spinner) findViewById(R.id.Module);
       // pageSpinner=findViewById(R.id.Page);


        List<String> lstModules= loadModules();
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,lstModules );
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        moduleSpinner.setAdapter(dataAdapter);
        moduleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                String selectedItem = parent.getItemAtPosition(position).toString(); //this is your selected item
                Log.e("Selected", selectedItem );
            }
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });


//        moduleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
//               Log.e("Checking", "onItemSelected: " );
////                Resinf SelectedModule = AppConst.getModules().get(position);//This will be the student id.
////                List<String>lstPages= loadPages(SelectedModule.getRescode());
////                // Creating adapter for spinner
////                ArrayAdapter<String> pagedataAdapter = new ArrayAdapter<String>(CreateTicketActivity.this,android.R.layout.simple_spinner_item,lstPages );
////                // Drop down layout style - list view with radio button
////                pagedataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
////                // attaching data adapter to spinner
////                pageSpinner.setAdapter(pagedataAdapter);
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parentView) {
//                Log.e("Checking", "onItemSelected: " );
//            }
//
//        });

    }



    private List<String> loadModules(){
        List<String> data= new ArrayList<>();
        Repository repo2= RetrofitClient.getRetrofitInstance()
                .create(Repository.class);
        Call<ArrayList<Resinf>> call2= repo2.getModules("","Module");
        call2.enqueue(new Callback<ArrayList<Resinf>>(){
            @Override
            public void onResponse(Call<ArrayList<Resinf>> call2, Response<ArrayList<Resinf>> response) {
                Log.e("Module get","onResponse: code :"+response.code());
                AppConst.setModules(response.body());

                for (Resinf x:AppConst.getModules()) {
                    data.add(x.getResdesc());
                }
            }
            @Override
            public void onFailure(Call<ArrayList<Resinf>> call, Throwable t) {
                Log.e("Hridoy",t.getMessage());
            }
        });
        return data;
    }

    private List<String> loadPriorities(){
        List<String> data= new ArrayList<>();
        Repository repo2= RetrofitClient.getRetrofitInstance()
                .create(Repository.class);
        Call<ArrayList<Resinf>> call2= repo2.getModules("","PRIORITY TYPE");
        call2.enqueue(new Callback<ArrayList<Resinf>>(){
            @Override
            public void onResponse(Call<ArrayList<Resinf>> call2, Response<ArrayList<Resinf>> response) {
                Log.e("Module get","onResponse: code :"+response.code());
                AppConst.setPriorities(response.body());

                for (Resinf x:AppConst.getPriorities()) {
                    data.add(x.getResdesc());
                }
            }
            @Override
            public void onFailure(Call<ArrayList<Resinf>> call, Throwable t) {
                Log.e("Hridoy",t.getMessage());
            }
        });
        return data;
    }
    //SUPPORT TYPE
    private List<String> loadCategories(){
        List<String> data= new ArrayList<>();
        Repository repo2= RetrofitClient.getRetrofitInstance()
                .create(Repository.class);
        Call<ArrayList<Resinf>> call2= repo2.getModules("","SUPPORT TYPE");
        call2.enqueue(new Callback<ArrayList<Resinf>>(){
            @Override
            public void onResponse(Call<ArrayList<Resinf>> call2, Response<ArrayList<Resinf>> response) {
                Log.e("Module get","onResponse: code :"+response.code());
                AppConst.setCategories(response.body());

                for (Resinf x:AppConst.getCategories()) {
                    data.add(x.getResdesc());
                }
            }
            @Override
            public void onFailure(Call<ArrayList<Resinf>> call, Throwable t) {
                Log.e("Hridoy",t.getMessage());
            }
        });
        return data;
    }


    private List<String> loadType(String Rescode){
        List<String> data= new ArrayList<>();
        Repository repo2= RetrofitClient.getRetrofitInstance()
                .create(Repository.class);
        Call<ArrayList<Resinf>> call2= repo2.getModules(Rescode,"SUPPORT OPTIONS");
        call2.enqueue(new Callback<ArrayList<Resinf>>(){
            @Override
            public void onResponse(Call<ArrayList<Resinf>> call2, Response<ArrayList<Resinf>> response) {
                Log.e("Module get","onResponse: code :"+response.code());
                AppConst.setTypes(response.body());

                for (Resinf x:AppConst.getTypes()) {
                    data.add(x.getResdesc());
                }
            }
            @Override
            public void onFailure(Call<ArrayList<Resinf>> call, Throwable t) {
                Log.e("Hridoy",t.getMessage());
            }
        });
        return data;
    }

    private List<String> loadPages(String Rescode){
        List<String> data= new ArrayList<>();
        Repository repo2= RetrofitClient.getRetrofitInstance()
                .create(Repository.class);
        Call<ArrayList<Resinf>> call2= repo2.getModules(Rescode,"IssuePage");
        call2.enqueue(new Callback<ArrayList<Resinf>>(){
            @Override
            public void onResponse(Call<ArrayList<Resinf>> call2, Response<ArrayList<Resinf>> response) {
                Log.e("Module get","onResponse: code :"+response.code());
                AppConst.setPages(response.body());

                for (Resinf x:AppConst.getPages()) {
                    data.add(x.getResdesc());
                }
            }
            @Override
            public void onFailure(Call<ArrayList<Resinf>> call, Throwable t) {
                Log.e("Hridoy",t.getMessage());
            }
        });
        return data;
    }
}