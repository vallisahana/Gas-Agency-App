package com.example.sahana.gasagency;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RequestPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_page);


    }

    public void Booking(View view){
        Intent intent=new Intent(RequestPageActivity.this,BookingdetailsActivity.class);
        startActivity(intent);
    }

    public void connection(View view){
        Intent intent=new Intent(RequestPageActivity.this,ConnectiondetailsActivity.class);
        startActivity(intent);
    }
}
