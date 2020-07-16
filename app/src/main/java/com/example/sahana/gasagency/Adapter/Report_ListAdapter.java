package com.example.sahana.gasagency.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.sahana.gasagency.Model.Dataprovider_Report;
import com.example.sahana.gasagency.Model.Dataprovider_User;
import com.example.sahana.gasagency.R;

import java.util.ArrayList;
import java.util.List;

public class Report_ListAdapter extends ArrayAdapter {

    List list=new ArrayList();
    public Report_ListAdapter
            (Context context, int resource){
        super(context, resource);
    }
    static class LayoutHandler
    {
        TextView NAME,EMAIL,PASSWORD,PHONE,status;
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
        Report_ListAdapter.LayoutHandler layoutHandler;
        if(row==null)
        {
            LayoutInflater layoutInflater=(LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.report_row,parent,false);
            layoutHandler=new Report_ListAdapter.LayoutHandler();
            layoutHandler.NAME=(TextView)row.findViewById(R.id.txtusername);
            layoutHandler.EMAIL=(TextView)row.findViewById(R.id.txtuseremail);
            layoutHandler.PASSWORD=(TextView)row.findViewById(R.id.txtuaddress);
            layoutHandler.PHONE=(TextView)row.findViewById(R.id.txtuserphone);
            layoutHandler.status=(TextView)row.findViewById(R.id.txtstatus);
            row.setTag(layoutHandler);
        }
        else{
            layoutHandler=(Report_ListAdapter.LayoutHandler)row.getTag();
        }
       Dataprovider_Report DPC = (Dataprovider_Report) this.getItem(position);
        layoutHandler.NAME.setText(DPC.getName());
        layoutHandler.EMAIL.setText(DPC.getEmail());
        layoutHandler.PASSWORD.setText(DPC.getAddress());
        layoutHandler.PHONE.setText(DPC.getPhone());
        layoutHandler.status.setText(DPC.getStatus());
        return row;
    }

}
