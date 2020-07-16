package com.example.sahana.gasagency;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sahana.gasagency.Database.DatabaseExtra;

import java.util.Calendar;

public class ExtrarefillActivity extends AppCompatActivity {

    EditText ename,edate,ephone;
    Button btn;

    DatabaseExtra databaseExtra=new DatabaseExtra(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extrarefill);

        ename=findViewById(R.id.name);
        edate=findViewById(R.id.date);
        ephone=findViewById(R.id.phone);
        btn=findViewById(R.id.submit);

        edate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int d, m, y;
                Calendar calendar = Calendar.getInstance();
                d = calendar.get(Calendar.DAY_OF_MONTH);
                m = calendar.get(Calendar.MONTH);
                y = calendar.get(Calendar.YEAR);
                DatePickerDialog pickerDialog = new DatePickerDialog(
                        ExtrarefillActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int yyyy, int mm, int dd) {
                                mm += 1;
                                edate.setText(dd +"/"+ mm +"/"+ yyyy );
                            }
                        },
                        y, m, d);
                pickerDialog.show();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean res = databaseExtra.User_Data(ename.getText().toString(),
                        edate.getText().toString(), ephone.getText().toString());
                if (res) {

                    Toast.makeText(ExtrarefillActivity.this, "Submitted Successfully",
                            Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(ExtrarefillActivity.this, "Try Again",
                            Toast.LENGTH_LONG).show();
                }

                ename.setText("");
                edate.setText("");
                ephone.setText("");
            }
        });




    }
}
