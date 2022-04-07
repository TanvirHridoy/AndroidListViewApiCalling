package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ResninfDataAdapter extends ArrayAdapter<TicketModel.Resinf> {
    private Context mContext;
    private int mResources;
    public ResninfDataAdapter(@NonNull Context context, int resource, @NonNull ArrayList<TicketModel.Resinf> objects) {
         super(context, resource, objects);
        this.mContext=context;
        this.mResources=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater= LayoutInflater.from(mContext);

        convertView=layoutInflater.inflate(mResources,parent,false);
//        ImageView imageView = convertView.findViewById(R.id.image);
//        Picasso.get().load(getItem(position).getAvatar()).into(imageView);
        //imageView.setImageURI(Uri.parse(getItem(position).getAvatar()) );
        TextView txtTicketID = convertView.findViewById(R.id.ticketId);
        txtTicketID.setText(getItem(position).getRescode());
        TextView txtTicketDes = convertView.findViewById(R.id.ticketDes);
        txtTicketDes.setText(getItem(position).getResdesc());

        return convertView;
    }
}
