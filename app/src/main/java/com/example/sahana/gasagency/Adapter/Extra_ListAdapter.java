package com.example.sahana.gasagency.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.sahana.gasagency.Model.Dataprovider_Collection;
import com.example.sahana.gasagency.Model.Dataprovider_Extra;
import com.example.sahana.gasagency.R;

import java.util.ArrayList;
import java.util.List;

public class Extra_ListAdapter extends ArrayAdapter {

    List list=new ArrayList();
    public Extra_ListAdapter
            (Context context, int resource){
        super(context, resource);
    }
    static class LayoutHandler
    {
        TextView NAME,EMAIL,PASSWORD;
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
        Extra_ListAdapter.LayoutHandler layoutHandler;
        if(row==null)
        {
            LayoutInflater layoutInflater=(LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.extra_row,parent,false);
            layoutHandler=new Extra_ListAdapter.LayoutHandler();
            layoutHandler.NAME=(TextView)row.findViewById(R.id.txtname);
            layoutHandler.EMAIL=(TextView)row.findViewById(R.id.txtdate);
            layoutHandler.PASSWORD=(TextView)row.findViewById(R.id.txtphone);

            row.setTag(layoutHandler);
        }
        else{
            layoutHandler=(Extra_ListAdapter.LayoutHandler)row.getTag();
        }

      Dataprovider_Extra DPC = (Dataprovider_Extra) this.getItem(position);
        layoutHandler.NAME.setText(DPC.getEname());
        layoutHandler.EMAIL.setText(DPC.getEdate());
        layoutHandler.PASSWORD.setText(DPC.getEphone());

        return row;
    }
}
