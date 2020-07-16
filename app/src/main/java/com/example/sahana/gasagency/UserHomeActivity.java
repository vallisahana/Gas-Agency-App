package com.example.sahana.gasagency;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class UserHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);
    }

    public void logout(View view){
        Intent intent=new Intent(UserHomeActivity.this,HomepageActivity.class);
        startActivity(intent);
        finish();
    }

    public void viewprofile(View view){
        Intent intent=new Intent(UserHomeActivity.this,UserProfileActivity.class);
        startActivity(intent);

    }

    public void connect(View view){
        Intent intent=new Intent(UserHomeActivity.this,ConnhomeActivity.class);
        startActivity(intent);

    }
    public void booking(View view){
        Intent intent=new Intent(UserHomeActivity.this,BookingActivity.class);
        startActivity(intent);

    }

    public void feedback(View view){
        Intent intent=new Intent(UserHomeActivity.this,FeedbackActivity.class);
        startActivity(intent);

    }


}
