package com.example.sahana.gasagency;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.sahana.gasagency.Database.DatabaseBooking;
import com.example.sahana.gasagency.Database.DatabaseReport;
import com.example.sahana.gasagency.Model.Dataprovider_Booking;
import com.example.sahana.gasagency.Model.Dataprovider_Collection;

public class ReportActivity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener{

    EditText editname,editemail,editaddress,editphone,editreport;
    Button btn;

    DatabaseReport databaseReport=new DatabaseReport(this);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);


        editname=findViewById(R.id.ropname);
        editemail=findViewById(R.id.ropemail);
        editaddress=findViewById(R.id.ropaddress);
        editphone=findViewById(R.id.rophone);
        btn=findViewById(R.id.submit);
        editreport=findViewById(R.id.report);

        Intent intent=getIntent();
        Dataprovider_Collection cust=(Dataprovider_Collection) intent.getSerializableExtra("bundle");
        editname.setText(cust.getName());
        editemail.setText(cust.getEmail());
        editaddress.setText(cust.getAddress());
        editphone.setText(cust.getPhone());



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean res = databaseReport.Report_Data(editname.getText().toString(),
                        editemail.getText().toString(),
                        editaddress.getText().toString(), editphone.getText().toString(),editreport.getText().toString());
                if (res) {

                    Toast.makeText(ReportActivity.this, "Submitted Successfully",
                            Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(ReportActivity.this,DistributorHomeActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(ReportActivity.this, "Try Again",
                            Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
