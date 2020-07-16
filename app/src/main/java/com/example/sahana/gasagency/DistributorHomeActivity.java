package com.example.sahana.gasagency;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DistributorHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distributor_home);
    }

    public void logout(View view){
        Intent intent=new Intent(DistributorHomeActivity.this,HomepageActivity.class);
        startActivity(intent);
        finish();
    }

    public void profile(View view){
        Intent intent=new Intent(DistributorHomeActivity.this,DisProfileActivity.class);
        startActivity(intent);

    }

    public void request(View view){
        Intent intent=new Intent(DistributorHomeActivity.this,RequestPageActivity.class);
        startActivity(intent);

    }

    public void feedback(View view){
        Intent intent=new Intent(DistributorHomeActivity.this,FeedbackdetailsActivity.class);
        startActivity(intent);

    }

    public void report(View view){
        Intent intent=new Intent(DistributorHomeActivity.this,ReportdetailsActivity.class);
        startActivity(intent);

    }
}
