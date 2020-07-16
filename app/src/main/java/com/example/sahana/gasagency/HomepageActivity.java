package com.example.sahana.gasagency;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomepageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
    }

    public void user(View view){
        Intent intent=new Intent(HomepageActivity.this,MainActivity.class);
        startActivity(intent);
    }

    public void vendor(View view){
        Intent intent=new Intent(HomepageActivity.this,DistributorLoginActivity.class);
        startActivity(intent);
    }

    public void admin(View view){
        Intent intent=new Intent(HomepageActivity.this,AdminLoginActivity.class);
        startActivity(intent);
    }
}
