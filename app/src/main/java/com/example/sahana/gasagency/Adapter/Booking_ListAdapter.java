package com.example.sahana.gasagency.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.sahana.gasagency.Model.Dataprovider_Booking;
import com.example.sahana.gasagency.Model.Dataprovider_Collection;
import com.example.sahana.gasagency.R;

import java.util.ArrayList;
import java.util.List;

public class Booking_ListAdapter extends ArrayAdapter {

    List list=new ArrayList();
    public Booking_ListAdapter
            (Context context, int resource){
        super(context, resource);
    }
    static class LayoutHandler
    {
        TextView id,date,time,address,price,phone,radio;
    }
    public  void add(Object object){
        super.add(object);
        list.add(object);
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row=convertView;
        Booking_ListAdapter.LayoutHandler layoutHandler;
        if(row==null)
        {
            LayoutInflater layoutInflater=(LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.book_row,parent,false);
            layoutHandler=new Booking_ListAdapter.LayoutHandler();
            layoutHandler.id=(TextView)row.findViewById(R.id.txtgasid);
            layoutHandler.date=(TextView)row.findViewById(R.id.txtdate);
            layoutHandler.time=(TextView)row.findViewById(R.id.txttime);
            layoutHandler.address=(TextView)row.findViewById(R.id.txtaddress);
            layoutHandler.price=(TextView)row.findViewById(R.id.txtprice);
            layoutHandler.phone=(TextView)row.findViewById(R.id.txtphone);
            layoutHandler.radio=(TextView)row.findViewById(R.id.txtdelivary);
            row.setTag(layoutHandler);
        }
        else{
            layoutHandler=(Booking_ListAdapter.LayoutHandler)row.getTag();
        }
     Dataprovider_Booking DPC = (Dataprovider_Booking) this.getItem(position);
        layoutHandler.id.setText(DPC.getId());
        layoutHandler.date.setText(DPC.getDate());
        layoutHandler.time.setText(DPC.getTime());
        layoutHandler.address.setText(DPC.getAddress());
        layoutHandler.price.setText(DPC.getPrice());
        layoutHandler.phone.setText(DPC.getPhone());
        layoutHandler.radio.setText(DPC.getRadio());
        return row;
    }
}
