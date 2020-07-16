package com.example.sahana.gasagency;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sahana.gasagency.Database.DatabaseConnection;

public class ConnectionActivity extends AppCompatActivity {

    EditText editname,editemail,editaddress,editphone;
    Button btn;

    DatabaseConnection databaseConnection=new DatabaseConnection(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection);

        editname=findViewById(R.id.name);
        editemail=findViewById(R.id.email);
        editaddress=findViewById(R.id.address);
        editphone=findViewById(R.id.phone);
        btn=findViewById(R.id.submit);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean res = databaseConnection.User_Data(editname.getText().toString(),
                        editemail.getText().toString(),
                        editaddress.getText().toString(), editphone.getText().toString());
                if (res) {

                    Toast.makeText(ConnectionActivity.this, "Submitted Successfully",
                            Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(ConnectionActivity.this,UserHomeActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(ConnectionActivity.this, "Try Again",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
