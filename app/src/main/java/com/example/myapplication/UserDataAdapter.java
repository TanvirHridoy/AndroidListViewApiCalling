package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class UserDataAdapter extends ArrayAdapter<Userinfo> {
    private Context mContext;
    private int mResources;
    public UserDataAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Userinfo> objects) {
        super(context, resource, objects);
        this.mContext=context;
        this.mResources=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater= LayoutInflater.from(mContext);
        convertView=layoutInflater.inflate(mResources,parent,false);
        ImageView imageView = convertView.findViewById(R.id.UserImage);
        Picasso.get().load(getItem(position).getImageurl()).into(imageView);
        TextView AppUserName = convertView.findViewById(R.id.AppUserName);
        AppUserName.setText("Name: "+getItem(position).getUserdata().getFullname());
        TextView IsActive= convertView.findViewById(R.id.IsActive);
        IsActive.setText("Status: "+(getItem(position).getIsactive()?"Active":"InActive"));
        return convertView;
    }

}
