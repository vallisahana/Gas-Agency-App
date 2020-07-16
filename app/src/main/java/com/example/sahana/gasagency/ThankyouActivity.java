package com.example.sahana.gasagency;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sahana.gasagency.Database.DatabaseBooking;
import com.example.sahana.gasagency.Database.DatabaseConnection;
import com.example.sahana.gasagency.Database.DatabaseCustomer;

public class ThankyouActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thankyou);


    }

    public void payment(View view) {
        Intent intent=new Intent(ThankyouActivity.this,PaymentActivity.class);
        startActivity(intent);

    }
}
