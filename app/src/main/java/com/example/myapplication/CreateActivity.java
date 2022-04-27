package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateActivity extends AppCompatActivity {
    private Button clickButton ;
    DateTimeFormatter formatter ;

    private Spinner moduleSpinner;
    private Spinner pageSpinner;
    private Spinner categorySpinner;
    private Spinner typeSpinner;
    private Spinner prioritySpinner;
    final Calendar myCalendar= Calendar.getInstance();
    private EditText expectedDate;
    private EditText ticketDesc;
    private Ticket postTicket;
    private  ArrayList<String> arrModules =new ArrayList<>();
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        ticketDesc=findViewById(R.id.TDesc);
        formatter= DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);
        clickButton= (Button) findViewById(R.id.btnSubmit);
        moduleSpinner=(Spinner) findViewById(R.id.Module);
        pageSpinner=(Spinner) findViewById(R.id.Page);
        categorySpinner=(Spinner) findViewById(R.id.Catagory);
        prioritySpinner=(Spinner) findViewById(R.id.Priority);
        typeSpinner=(Spinner) findViewById(R.id.Type);
        expectedDate=findViewById(R.id.EDate);
        loadModules();
        loadCategories();
        loadPriorities();
        //date picker
        DatePickerDialog.OnDateSetListener date =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,day);
                updateLabel();
            }
        };
        expectedDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(CreateActivity.this,date,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        //module spinner listener
        moduleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                String Rescode=AppConst.getModules().get(position).getRescode();
                loadPages(Rescode);
                Log.e("Selected", Rescode );
            }
            public void onNothingSelected(AdapterView<?> parent)
            {
                Log.e("Selected", "nothing selected" );
            }
        });

        //Page spinner listener
        pageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                String selectedItem = parent.getItemAtPosition(position).toString(); //this is your selected item
                Log.e("Selected", selectedItem );
            }
            public void onNothingSelected(AdapterView<?> parent)
            {
                Log.e("Selected", "nothing selected" );
            }
        });

        //category spinner listener
        categorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                String Rescode=AppConst.getCategories().get(position).getRescode();
                loadType( Rescode);
            }
            public void onNothingSelected(AdapterView<?> parent)
            {
                Log.e("Selected", "nothing selected" );
            }
        });

        //button click event
        clickButton.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.e("Clicked", "btnSubmitOnClick: " );
                btnSubmitOnClick();
            }
        });
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    private void btnSubmitOnClick(){
        try{
            DateTimeFormatter formatterDateOnly = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
            postTicket=new Ticket(0);
            postTicket.setTicketid(0);
            LocalDateTime dateTime = LocalDateTime.now();
            postTicket.setBegintime(dateTime.format(formatter));
            postTicket.setStatustime(dateTime.format(formatter));
            postTicket.setFileurl("4231.jpg");
            postTicket.setTicketdes(ticketDesc.getText().toString());
            postTicket.setStatuscode("");
            LocalDate expectedDateTime= LocalDate.parse(expectedDate.getText().toString(),formatterDateOnly);
            String tEdate=expectedDateTime.toString()+"T00:00:00.000Z";
            postTicket.setExpecttime(tEdate);
            postTicket.setUsercode(AppConst.user.getRescode());
            postTicket.setStatusbkp("");
            int pagePosition=pageSpinner.getSelectedItemPosition();
            int pageType=typeSpinner.getSelectedItemPosition();
            int pageCategory=categorySpinner.getSelectedItemPosition();
            int pagePriority=prioritySpinner.getSelectedItemPosition();
            postTicket.setPrjitmcode(AppConst.getPages().get(pagePosition).getRescode());
            postTicket.setTickettype(AppConst.getTypes().get(pageType).getRescode());
            postTicket.setPriority(AppConst.getPriorities().get(pagePriority).getRescode());
            postTicket.setTcatagory(AppConst.getTypes().get(pageType).getRescode());
            submitTicket(postTicket);
        }
        catch (Exception e){
            Toast.makeText(CreateActivity.this, "Ticket Submission Failed",Toast.LENGTH_LONG).show();
            Log.e("btnSubmitOnClickError", e.getMessage());
        }

    }
    private void submitTicket(Ticket t){

        Repository repo2= RetrofitClient.getRetrofitInstance()
                .create(Repository.class);
        Call<Ticket> call2= repo2.postTicket(t);
        call2.enqueue(new Callback<Ticket>(){
            @Override
            public void onResponse(Call<Ticket> call2, Response<Ticket> response) {
                Log.e("Post Succeed","onResponse: code :"+response.code());
                Ticket v= response.body();
                Toast.makeText(CreateActivity.this, "Ticket Created ID:"+response.body().getTicketid(),Toast.LENGTH_LONG).show();
                Intent switchActivityIntent = new Intent(CreateActivity.this, TicketNormalActivity.class);
                switchActivityIntent.putExtra("TicketId",response.body().getTicketid());
                startActivity(switchActivityIntent);
            }
            @Override
            public void onFailure(Call<Ticket> call, Throwable t) {
                Toast.makeText(CreateActivity.this, "Ticket Submission Failed",Toast.LENGTH_LONG).show();
                Log.e("Hridoy",t.getMessage());
            }
        });
    }

    private void updateLabel(){
        String myFormat="dd-MMM-yyyy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
        expectedDate.setText(dateFormat.format(myCalendar.getTime()));
    }

    private void SetSpinner(Spinner spinner,ArrayList<String> data){
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(CreateActivity.this,android.R.layout.simple_spinner_item,data );
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }
    private void loadModules(){
        ArrayList<String> data=new ArrayList<>();
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
                SetSpinner(moduleSpinner,data);
            }
            @Override
            public void onFailure(Call<ArrayList<Resinf>> call, Throwable t) {
                Log.e("Hridoy",t.getMessage());
            }
        });
    }

    private void loadPages(String Rescode){
        ArrayList<String> data=new ArrayList<>();
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
                SetSpinner(pageSpinner,data);
            }
            @Override
            public void onFailure(Call<ArrayList<Resinf>> call, Throwable t) {
                Log.e("Hridoy",t.getMessage());
            }
        });
    }


    private void loadPriorities(){
        ArrayList<String> data= new ArrayList<>();
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
                SetSpinner(prioritySpinner,data);
            }
            @Override
            public void onFailure(Call<ArrayList<Resinf>> call, Throwable t) {
                Log.e("Hridoy",t.getMessage());
            }
        });
    }
    //SUPPORT TYPE
    private  void loadCategories(){
        ArrayList<String> data= new ArrayList<>();
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
                SetSpinner(categorySpinner,data);
            }
            @Override
            public void onFailure(Call<ArrayList<Resinf>> call, Throwable t) {
                Log.e("Hridoy",t.getMessage());
            }
        });
    }


    private void loadType(String Rescode){
        ArrayList<String> data= new ArrayList<>();
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
                SetSpinner(typeSpinner,data);
            }
            @Override
            public void onFailure(Call<ArrayList<Resinf>> call, Throwable t) {
                Log.e("Hridoy",t.getMessage());
            }
        });
    }


}