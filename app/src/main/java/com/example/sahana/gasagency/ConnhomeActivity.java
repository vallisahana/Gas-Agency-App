package com.example.sahana.gasagency;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ConnhomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connhome);
    }

    public void connect(View view){
        Intent intent=new Intent(ConnhomeActivity.this,ConnectionActivity.class);
        startActivity(intent);
        finish();
    }

    public void refill(View view) {
        Intent intent=new Intent(ConnhomeActivity.this,ExtrarefillActivity.class);
        startActivity(intent);
        finish();

    }
}
