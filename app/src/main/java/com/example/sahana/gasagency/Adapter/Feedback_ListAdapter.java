package com.example.sahana.gasagency.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.sahana.gasagency.Model.Dataprovider_Feedback;
import com.example.sahana.gasagency.Model.Dataprovider_User;
import com.example.sahana.gasagency.R;

import java.util.ArrayList;
import java.util.List;

public class Feedback_ListAdapter extends ArrayAdapter {

    List list=new ArrayList();
    public Feedback_ListAdapter
            (Context context, int resource){
        super(context, resource);
    }
    static class LayoutHandler
    {
        TextView NAME,EMAIL;
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
        Feedback_ListAdapter.LayoutHandler layoutHandler;
        if(row==null)
        {
            LayoutInflater layoutInflater=(LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.feedback_row,parent,false);
            layoutHandler=new Feedback_ListAdapter.LayoutHandler();
            layoutHandler.NAME=(TextView)row.findViewById(R.id.txttilte);
            layoutHandler.EMAIL=(TextView)row.findViewById(R.id.txtmessage);
            row.setTag(layoutHandler);
        }
        else{
            layoutHandler=(Feedback_ListAdapter.LayoutHandler)row.getTag();
        }
       Dataprovider_Feedback DPC = (Dataprovider_Feedback) this.getItem(position);
        layoutHandler.NAME.setText(DPC.getUser_name());
        layoutHandler.EMAIL.setText(DPC.getUser_email());
        return row;
    }

}
