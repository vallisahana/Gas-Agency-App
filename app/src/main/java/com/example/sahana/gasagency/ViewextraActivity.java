package com.example.sahana.gasagency;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.sahana.gasagency.Adapter.Connection_ListAdapter;
import com.example.sahana.gasagency.Adapter.Extra_ListAdapter;
import com.example.sahana.gasagency.Database.DatabaseConnection;
import com.example.sahana.gasagency.Database.DatabaseExtra;
import com.example.sahana.gasagency.Model.Dataprovider_Collection;
import com.example.sahana.gasagency.Model.Dataprovider_Extra;

public class ViewextraActivity extends AppCompatActivity {

    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    DatabaseExtra dbh;
    Cursor res;
    Extra_ListAdapter la;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewextra);

        listView = findViewById(R.id.extra);

        dbh = new DatabaseExtra(getApplicationContext());
        sqLiteDatabase = dbh.getReadableDatabase();
        res = dbh.extraData();
        la = new Extra_ListAdapter(getApplicationContext(), R.layout.extra_row);
        listView.setAdapter(la);

        if (res.moveToFirst()) {
            do {
                String name, email,pss;

                name = res.getString(0);
                email = res.getString(1);
                pss= res.getString(2);

               Dataprovider_Extra DPC = new Dataprovider_Extra(name, email,pss);
                la.add(DPC);
            } while (res.moveToNext());
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

               Dataprovider_Extra dpc=(Dataprovider_Extra) parent.getAdapter().getItem(position);

               dpc.getEphone();

               Intent intent=new Intent(ViewextraActivity.this,ApprovedActivity.class);
               intent.putExtra("bundle", dpc);
               startActivity(intent);
            }
        });
    }
}
