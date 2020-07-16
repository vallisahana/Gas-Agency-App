package com.example.sahana.gasagency;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import com.example.sahana.gasagency.Adapter.Feedback_ListAdapter;
import com.example.sahana.gasagency.Adapter.Vendor_ListAdapter;
import com.example.sahana.gasagency.Database.DatabaseFeedback;
import com.example.sahana.gasagency.Database.DatabaseVendor;
import com.example.sahana.gasagency.Model.Dataprovider_Feedback;
import com.example.sahana.gasagency.Model.Dataprovider_Vendor;

public class FeedbackdetailsActivity extends AppCompatActivity {

    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    DatabaseFeedback dbh;
    Cursor res;
    Feedback_ListAdapter la;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedbackdetails);

        listView = findViewById(R.id.feedback);

        dbh = new DatabaseFeedback(getApplicationContext());
        sqLiteDatabase = dbh.getReadableDatabase();
        res = dbh.UserData();
        la = new Feedback_ListAdapter(getApplicationContext(), R.layout.feedback_row);
        listView.setAdapter(la);

        if (res.moveToFirst()) {
            do {
                String name, email;

                name = res.getString(0);
                email = res.getString(1);

               Dataprovider_Feedback DPC = new Dataprovider_Feedback(name, email);
                la.add(DPC);
            } while (res.moveToNext());
        }

    }
}
