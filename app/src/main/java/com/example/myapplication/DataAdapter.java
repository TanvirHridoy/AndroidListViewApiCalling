package com.example.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DataAdapter extends ArrayAdapter<Ticket> {
    private Context mContext;
    private int mResources;
    public DataAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Ticket> objects) {
         super(context, resource, objects);
        this.mContext=context;
        this.mResources=resource;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater= LayoutInflater.from(mContext);

        convertView=layoutInflater.inflate(mResources,parent,false);
//        ImageView imageView = convertView.findViewById(R.id.image);
//        Picasso.get().load(getItem(position).getAvatar()).into(imageView);
        //imageView.setImageURI(Uri.parse(getItem(position).getAvatar()) );
        TextView txtTicketID = convertView.findViewById(R.id.ticketId);
        TextView txtIssuedate = convertView.findViewById(R.id.issuedate);
        txtTicketID.setText("ID# "+getItem(position).getTicketid());
        txtIssuedate.setText("Issued On: "+getItem(position).getBegintime());
        TextView txtTicketDes = convertView.findViewById(R.id.ticketDes);
        txtTicketDes.setText("Page: "+getItem(position).getPage());

        return convertView;
    }
}
