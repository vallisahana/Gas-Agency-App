package com.example.sahana.gasagency;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sahana.gasagency.Adapter.User_ListAdapter;
import com.example.sahana.gasagency.Database.DatabaseCustomer;
import com.example.sahana.gasagency.Model.Dataprovider_User;

public class ViewuserdetailsActivity extends AppCompatActivity {

    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    DatabaseCustomer dbh;
    Cursor res;
    User_ListAdapter la;
    EditText search;

    Button btndelete, btnsearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewuserdetails);

        listView = findViewById(R.id.userdetailistview);
        btnsearch = findViewById(R.id.search_teacher_btn);
        btndelete = findViewById(R.id.delete_teacher_btn);
        search = findViewById(R.id.search_user_name);

        dbh = new DatabaseCustomer(getApplicationContext());
        sqLiteDatabase = dbh.getReadableDatabase();
        res = dbh.UserData();
        la = new User_ListAdapter(getApplicationContext(), R.layout.user_row);
        listView.setAdapter(la);

        if (res.moveToFirst()) {
            do {
                String name, email, password, confirm, phone, branch, subject;

                name = res.getString(0);
                email = res.getString(1);
                password = res.getString(2);
                phone = res.getString(3);

                Dataprovider_User DPC = new Dataprovider_User(name, email, password, phone);
                la.add(DPC);
            } while (res.moveToNext());
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                dbh = new DatabaseCustomer(getApplicationContext());
                sqLiteDatabase = dbh.getReadableDatabase();
                //String val=la.getItem(position).toString();
                View v = listView.getChildAt(position);
                TextView name = (TextView) v.findViewById(R.id.txtusername);
                Cursor res1 = dbh.UserData();
                if (res1.getCount() > 0) {

                    StringBuffer buffer = new StringBuffer();
                    while (res1.moveToNext()) {
                        buffer.append("NAME :" + res1.getString(0) + "\n\n");
                        buffer.append("EMAIL :" + res1.getString(1) + "\n\n");
                        buffer.append("PASSWORD:" + res1.getString(2) + "\n\n");
                        buffer.append("PHONE :" + res1.getString(3) + "\n\n----------------------------------------------------\n\n");
                    }
                    showMessage("User Details", buffer.toString());
                } else {

                    Toast.makeText(ViewuserdetailsActivity.this, "Not found", Toast.LENGTH_LONG).show();
                    return;

                }
            }


        });

        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(search.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Enter the Name of Respective Teacher...", Toast.LENGTH_LONG).show();
                    return;
                }
                dbh = new DatabaseCustomer(getApplicationContext());
                sqLiteDatabase = dbh.getReadableDatabase();
                Cursor res2 = dbh.searchClient(search.getText().toString());
                la = new User_ListAdapter(getApplicationContext(), R.layout.user_row);
                listView.setAdapter(la);
                if (res2.moveToFirst()) {
                    do {
                        String name, email, password, phone;
                        name = res2.getString(0);
                        email = res2.getString(1);
                        password = res2.getString(2);
                        phone = res2.getString(3);

                        Dataprovider_User DPC = new Dataprovider_User(name, email, password, phone);
                        la.add(DPC);
                    } while (res2.moveToNext());
                } else {
                    Toast.makeText(ViewuserdetailsActivity.this, "Please enter valid Name", Toast.LENGTH_LONG).show();
                    return;
                }

            }
        });

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(search.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Enter the Name of Respective Teacher...", Toast.LENGTH_LONG).show();
                    return;
                }
                dbh = new DatabaseCustomer(getApplicationContext());
                sqLiteDatabase = dbh.getReadableDatabase();
                Cursor res2 = dbh.DeleteClient(search.getText().toString());
                if (res2.getCount() > 0 && !res2.equals(res2)) {
                    Toast.makeText(ViewuserdetailsActivity.this, "Enter vaild Name", Toast.LENGTH_LONG).show();
                    return;
                } else {
                    Toast.makeText(ViewuserdetailsActivity.this, "Successfully Deleted refresh to View", Toast.LENGTH_LONG).show();
                    return;


                }
            }
        });

    }

    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
    }

