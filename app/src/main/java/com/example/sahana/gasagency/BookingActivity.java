package com.example.sahana.gasagency;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Parcelable;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.sahana.gasagency.Database.DatabaseBooking;
import com.example.sahana.gasagency.Database.DatabaseConnection;
import com.example.sahana.gasagency.Model.Dataprovider_Collection;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Random;

import io.paperdb.Paper;

public class BookingActivity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {

  EditText id, date,time,address,price,phone;
  RadioGroup radioGroup;
    private String format;
    private RadioButton radioButton;
    String mobile;
    Spinner spinner;
    int random,max=1,min=1;

    private void selectedTimeFormat(int hr) {
        if(hr == 0){
            format = "AM";
        } else if(hr == 12){
            format = "PM";
        } else if(hr > 12){
            format = "PM";
        } else {
            format = "AM";
        }
    }

    DatabaseBooking databaseConnection=new DatabaseBooking(this);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        id=findViewById(R.id.gasid);
        date = findViewById(R.id.homeDatePicker);
        phone=findViewById(R.id.phone);
        time = findViewById(R.id.homeTimePicker);
        address=findViewById(R.id.address);
        radioGroup = findViewById(R.id.radioGroup);
        price = findViewById(R.id.Price);
        spinner=findViewById(R.id.spinArea);

        final ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.pay,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        Random r=new Random();
        random=r.nextInt(100);


        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int d, m, y;
                Calendar calendar = Calendar.getInstance();
                d = calendar.get(Calendar.DAY_OF_MONTH);
                m = calendar.get(Calendar.MONTH);
                y = calendar.get(Calendar.YEAR);
                DatePickerDialog pickerDialog = new DatePickerDialog(
                        BookingActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int yyyy, int mm, int dd) {
                                mm += 1;
                                date.setText(dd +"/"+ mm +"/"+ yyyy );
                            }
                        },
                        y, m, d);
                pickerDialog.show();
            }
        });

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int hr, min;
                Calendar calendar = Calendar.getInstance();
                hr = calendar.get(Calendar.HOUR_OF_DAY);
                min = calendar.get(Calendar.MINUTE);

                selectedTimeFormat(hr);

                TimePickerDialog pickerDialog = new TimePickerDialog(
                        BookingActivity.this,
                        new TimePickerDialog.OnTimeSetListener(){
                            @Override
                            public void onTimeSet(TimePicker view, int hr, int min) {
                                selectedTimeFormat(hr);
                                time.setText(hr +":"+ min +" "+ format);
                            }
                        },
                        hr, min, false);
                pickerDialog.show();
            }
        });


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mobile=phone.getText().toString();

                int selectedid=radioGroup.getCheckedRadioButtonId();
                radioButton=findViewById(selectedid);

                boolean res = databaseConnection.Book_Data(id.getText().toString(),date.getText().toString(),time.getText().toString(),
                        address.getText().toString(),price.getText().toString(),
                        phone.getText().toString(), radioButton.getText().toString());
                if (res) {

                    MyMessage();
                    Toast.makeText(BookingActivity.this, "Booking Successfully",
                            Toast.LENGTH_LONG).show();

                    Intent intent=new Intent(BookingActivity.this,ThankyouActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(BookingActivity.this, "Try Again",
                            Toast.LENGTH_LONG).show();
                }

            }

            });

    }

    private void MyMessage() {


        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(mobile, null, "Gas Agency 'Booking successfully done we will send it within 15days' Thank you ", null, null);

        Toast.makeText(this, "Message sent", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode){
            case 0:
                if(grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
                    MyMessage();
                }
                else {
                    Toast.makeText(this, "you dont have persmission", Toast.LENGTH_SHORT).show();
                }
        }

    }

    @Override
    protected void onStart() {

        int permissioncheck= ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS);

        if(permissioncheck== PackageManager.PERMISSION_GRANTED){

        }else {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},0);


        }
        super.onStart();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
