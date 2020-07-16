package com.example.sahana.gasagency;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AdminHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
    }

    public void user(View view){
        Intent intent=new Intent(AdminHomeActivity.this,ViewuserdetailsActivity.class);
        startActivity(intent);
        finish();
    }

    public void dis(View view){
        Intent intent=new Intent(AdminHomeActivity.this,ViewdisdetailsActivity.class);
        startActivity(intent);
        finish();
    }

    public void logout(View view){
        Intent intent=new Intent(AdminHomeActivity.this,HomepageActivity.class);
        startActivity(intent);
        finish();
    }

    public void report(View view){
        Intent intent=new Intent(AdminHomeActivity.this,ReportdetailsActivity.class);
        startActivity(intent);
        finish();
    }

    public void extra(View view) {
        Intent intent=new Intent(AdminHomeActivity.this,ViewextraActivity.class);
        startActivity(intent);
        finish();
    }
}
