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
import com.example.sahana.gasagency.Adapter.Feedback_ListAdapter;
import com.example.sahana.gasagency.Database.DatabaseConnection;
import com.example.sahana.gasagency.Database.DatabaseFeedback;
import com.example.sahana.gasagency.Model.Dataprovider_Booking;
import com.example.sahana.gasagency.Model.Dataprovider_Collection;
import com.example.sahana.gasagency.Model.Dataprovider_Feedback;

public class ConnectiondetailsActivity extends AppCompatActivity {

    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    DatabaseConnection dbh;
    Cursor res;
    Connection_ListAdapter la;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connectiondetails);

        listView = findViewById(R.id.connection);

        dbh = new DatabaseConnection(getApplicationContext());
        sqLiteDatabase = dbh.getReadableDatabase();
        res = dbh.UserData();
        la = new Connection_ListAdapter(getApplicationContext(), R.layout.connection_row);
        listView.setAdapter(la);

        if (res.moveToFirst()) {
            do {
                String name, email,pss,phone;

                name = res.getString(0);
                email = res.getString(1);
                pss= res.getString(2);
                phone = res.getString(3);

                Dataprovider_Collection DPC = new Dataprovider_Collection(name, email,pss,phone);
                la.add(DPC);
            } while (res.moveToNext());
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

               Dataprovider_Collection dpc=(Dataprovider_Collection) parent.getAdapter().getItem(position);


                dpc.getName();
                dpc.getEmail();
                dpc.getAddress();
                dpc.getPhone();





                Intent intent=new Intent(ConnectiondetailsActivity.this,ReportActivity.class);
                intent.putExtra("bundle", dpc);
                startActivity(intent);
            }
        });
    }
}
