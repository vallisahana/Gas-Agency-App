package com.example.sahana.gasagency;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import com.example.sahana.gasagency.Adapter.Connection_ListAdapter;
import com.example.sahana.gasagency.Adapter.Report_ListAdapter;
import com.example.sahana.gasagency.Database.DatabaseConnection;
import com.example.sahana.gasagency.Database.DatabaseReport;
import com.example.sahana.gasagency.Model.Dataprovider_Collection;
import com.example.sahana.gasagency.Model.Dataprovider_Report;

public class ReportdetailsActivity extends AppCompatActivity {

    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    DatabaseReport dbh;
    Cursor res;
    Report_ListAdapter la;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportdetails);

        listView = findViewById(R.id.report);

        dbh = new DatabaseReport(getApplicationContext());
        sqLiteDatabase = dbh.getReadableDatabase();
        res = dbh.UserData();
        la = new Report_ListAdapter(getApplicationContext(), R.layout.report_row);
        listView.setAdapter(la);

        if (res.moveToFirst()) {
            do {
                String name, email,pss,phone,status;

                name = res.getString(0);
                email = res.getString(1);
                pss= res.getString(2);
                phone = res.getString(3);
                status=res.getString(4);

                Dataprovider_Report DPC = new Dataprovider_Report(name, email,pss,phone,status);
                la.add(DPC);
            } while (res.moveToNext());
        }
    }
}
