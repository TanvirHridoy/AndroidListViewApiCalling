package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Ticket_Edit_View extends AppCompatActivity {
    private TextView IssuedBy;
    private TextView IssueDate;
    private TextView PModule;
    private TextView PPage;
    private EditText PDesc;
    private EditText SDesc;
    private Spinner PStatus;
    private TextView PPriority;
    private ImageView PImage;
    private Button BtnCancel;
    private Button BtnUpdate;
    ArrayList<String> data=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_edit_view);

        IssuedBy=findViewById(R.id.IssuedBy2);
        IssueDate=findViewById(R.id.IssueDate2);
        PModule=findViewById(R.id.PModule2);
        PPage=findViewById(R.id.PPage2);
        PDesc=findViewById(R.id.PDesc2);
        SDesc=findViewById(R.id.SDesc2);
        PStatus=findViewById(R.id.PStatus2);
        PPriority=findViewById(R.id.PPriority2);
        PImage=findViewById(R.id.PImage2);

        BtnCancel=findViewById(R.id.btnCancel);
        BtnUpdate=findViewById(R.id.btnUpdate);
        loadStatus();
        Intent intent = getIntent();
        int TicketId=intent.getIntExtra("TicketId",0);
        populateTicketinfo(TicketId);


        BtnCancel.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.e("Clicked", "BtnCancel: " );
                GotoList();
            }
        });

        BtnUpdate.setOnClickListener( new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                Log.e("Clicked", "BtnUpdate: " );
                updateTicket();
            }
        });
    }

    public void GotoList(){
        Intent switchActivityIntent = new Intent(Ticket_Edit_View.this, MainActivity.class);
        startActivity(switchActivityIntent);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void updateTicket(){

        Repository repo2= RetrofitClient.getRetrofitInstance()
                .create(Repository.class);
        Ticket t= AppConst.getCurrentEditTicket();
        t.setStatuscode(AppConst.getStatus().get(PStatus.getSelectedItemPosition()).getRescode());
        t.setStatusdesc(SDesc.getText().toString());
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);
        LocalDateTime dateTime = LocalDateTime.now();
        t.setStatustime(dateTime.format(formatter));
        Call<Boolean> call2= repo2.putTicket(t);
        call2.enqueue(new Callback<Boolean>(){
            @Override
            public void onResponse(Call<Boolean> call2, Response<Boolean> response) {
                Log.e("Post Succeed","onResponse: code :"+response.code());
                if(response.body().equals(true)){
                    Toast.makeText(Ticket_Edit_View.this, "Ticket Updated ID:"+t.getTicketid(),Toast.LENGTH_LONG).show();
                    Intent switchActivityIntent = new Intent(Ticket_Edit_View.this, MainActivity.class);
                    startActivity(switchActivityIntent);
                }
                else{
                    Toast.makeText(Ticket_Edit_View.this, "Ticket Update Failed",Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                Toast.makeText(Ticket_Edit_View.this, "Ticket Update Failed",Toast.LENGTH_LONG).show();
                Log.e("Hridoy",t.getMessage());
            }
        });
    }

    private void SetSpinner(Spinner spinner,ArrayList<String> data,String StatusDescriptionText){
        String compareValue = "TOKEN STATUS -"+StatusDescriptionText;
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Ticket_Edit_View.this,android.R.layout.simple_spinner_item,data );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        if (compareValue != null) {
            int spinnerPosition = adapter.getPosition(compareValue);
            Log.e("TAG", "SetSpinner: "+spinnerPosition );
            spinner.setSelection(spinnerPosition);
        }
    }

    private void loadStatus(){

        Repository repo2= RetrofitClient.getRetrofitInstance()
                .create(Repository.class);
        Call<ArrayList<Resinf>> call2= repo2.getModules("","STATUS");
        call2.enqueue(new Callback<ArrayList<Resinf>>(){
            @Override
            public void onResponse(Call<ArrayList<Resinf>> call2, Response<ArrayList<Resinf>> response) {
                Log.e("Module get","onResponse: code :"+response.code());
                AppConst.setStatus(response.body());
                for (Resinf x:AppConst.getStatus()) {
                    data.add(x.getResdesc());
                }

            }
            @Override
            public void onFailure(Call<ArrayList<Resinf>> call, Throwable t) {
                Log.e("Hridoy",t.getMessage());
            }
        });
    }

    public void populateTicketinfo(int tId){
        Repository repo2= RetrofitClient.getRetrofitInstance()
                .create(Repository.class);
        Call<Ticket> call2= repo2.getTicketById(tId);
        call2.enqueue(new Callback<Ticket>(){
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onResponse(Call<Ticket> call2, Response<Ticket> response) {
                Log.e("Hridoy","onResponse: code :"+response.code());

                Ticket t= response.body();
                AppConst.setCurrentEditTicket(t);
                InitJinfo ud=t.getUserinfo().getUserdata();
                IssuedBy.setText(t.getUserinfo().getUserdata().getFullname()+" " +t.getUserinfo().getLoginid()+","+t.getUserinfo().getUserdata().getDesignation());
                IssueDate.setText(t.getBegintime());
                PModule.setText(t.getModule());
                PPage.setText(t.getPage());
                PDesc.setText(t.getTicketdes());
                SDesc.setText(t.getStatusdesc());
                SetSpinner(PStatus,data,t.getStatuscodeD());

                PPriority.setText(t.getPriorityD());
                Log.e("fileur", t.getFileurlD() );
                Picasso.get().load(t.getFileurlD()).into(PImage);
            }
            @Override
            public void onFailure(Call<Ticket> call, Throwable t) {
                Log.e("Hridoy",t.getMessage());
            }
        });
    }
}