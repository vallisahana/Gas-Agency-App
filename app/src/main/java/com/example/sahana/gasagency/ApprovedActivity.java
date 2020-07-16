package com.example.sahana.gasagency;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sahana.gasagency.Model.Dataprovider_Extra;

public class ApprovedActivity extends AppCompatActivity {

    EditText ephone, emessage;
    Button btnNotify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_approved);

        ephone = (EditText) findViewById(R.id.phonenumber);
        emessage = (EditText) findViewById(R.id.message);
        btnNotify = (Button) findViewById(R.id.send);


        Intent intent=getIntent();
        Dataprovider_Extra cust=(Dataprovider_Extra) intent.getSerializableExtra("bundle");
        ephone.setText(cust.getEphone());

    }

    private void MyMessage() {

        String phonenumber = ephone.getText().toString().trim();
        String message = emessage.getText().toString().trim();

        if (!ephone.getText().toString().equals("") || !emessage.getText().toString().equals("")) {

            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phonenumber, null, message, null, null);

            Toast.makeText(this, "Message sent", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "please enter number or message", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case 0:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    MyMessage();
                } else {
                    Toast.makeText(this, "you dont have persmission", Toast.LENGTH_SHORT).show();
                }
        }

    }

    public void btn_click(View view) {

        int permissioncheck = ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS);

        if (permissioncheck == PackageManager.PERMISSION_GRANTED) {
            MyMessage();

        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 0);

        }
    }
}
