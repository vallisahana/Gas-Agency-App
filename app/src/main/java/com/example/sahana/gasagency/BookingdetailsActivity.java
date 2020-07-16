package com.example.sahana.gasagency;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sahana.gasagency.Adapter.Booking_ListAdapter;
import com.example.sahana.gasagency.Adapter.Connection_ListAdapter;
import com.example.sahana.gasagency.Database.DatabaseBooking;
import com.example.sahana.gasagency.Database.DatabaseConnection;
import com.example.sahana.gasagency.Database.DatabaseVendor;
import com.example.sahana.gasagency.Model.Dataprovider_Booking;
import com.example.sahana.gasagency.Model.Dataprovider_Collection;

import java.util.ArrayList;
import java.util.List;

public class BookingdetailsActivity extends AppCompatActivity {

    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    DatabaseBooking dbh;
    Cursor res;
    Button btndelete;
    EditText search;
    Booking_ListAdapter la;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookingdetails);

        listView = findViewById(R.id.book);
        btndelete = findViewById(R.id.delete_teacher_btn);
        search = findViewById(R.id.search_user_name);

        dbh = new DatabaseBooking(getApplicationContext());
        sqLiteDatabase = dbh.getReadableDatabase();
        res = dbh.BookData();
        la = new Booking_ListAdapter(getApplicationContext(), R.layout.book_row);
        listView.setAdapter(la);

        if (res.moveToFirst()) {
            do {
                String id,name, email,pss,price,phone,radio;

                id=res.getString(0);
                name = res.getString(1);
                email = res.getString(2);
                pss= res.getString(3);
                price = res.getString(4);
                phone = res.getString(5);
                radio = res.getString(6);

               Dataprovider_Booking DPC = new Dataprovider_Booking(id,name, email,pss,price,phone,radio);
                la.add(DPC);
            } while (res.moveToNext());
        }

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(search.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Enter the Name of Respective Teacher...", Toast.LENGTH_LONG).show();
                    return;
                }
                dbh = new DatabaseBooking(getApplicationContext());
                sqLiteDatabase = dbh.getReadableDatabase();
                Cursor res2 = dbh.DeleteClient(search.getText().toString());
                if (res2.getCount() > 0 && !res2.equals(res2)) {
                    Toast.makeText(BookingdetailsActivity.this, "Enter vaild Name", Toast.LENGTH_LONG).show();
                    return;
                } else {
                    Toast.makeText(BookingdetailsActivity.this, "Successfully Deleted refresh to View", Toast.LENGTH_LONG).show();
                    return;


                }
            }
        });
    }


}
