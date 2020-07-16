package com.example.sahana.gasagency;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sahana.gasagency.Database.DatabaseCustomer;

import java.util.Random;
import java.util.regex.Pattern;

public class SignupActivity extends AppCompatActivity {

    EditText name,email,phone,password;
    Button btnsingup;
    TextView textView;
    TextView text;

 DatabaseCustomer databaseCustomer=new DatabaseCustomer(this);

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    //"(?=.*[0-9])" +         //at least 1 digit
                    //"(?=.*[a-z])" +         //at least 1 lower case letter
                    //"(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{4,}" +               //at least 4 characters
                    "$");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

      phone = findViewById(R.id.edtPhone);
        name = findViewById(R.id.edtName);
        password = findViewById(R.id.edtPassword);
        email = findViewById(R.id.edtEmail);
        btnsingup=findViewById(R.id.btnSignUp);
        textView=findViewById(R.id.alreadyHaveAcct);

        text=findViewById(R.id.textgen);


        textView.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupActivity.this,MainActivity.class);
                startActivity(intent);
            }
        } );

        btnsingup.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {

                String fullname = name.getText().toString().trim();
                String Email = email.getText().toString().trim();
                String Pass = password.getText().toString().trim();
                String Phone = phone.getText().toString().trim();

                if(TextUtils.isEmpty(fullname)){
                    name.setError( "Name is Required" );
                    name.requestFocus() ;
                    return;
                }
                if(TextUtils.isEmpty(Email)){
                    email.setError( "Email is Required" );
                    email.requestFocus() ;
                    return;
                }

                if(!Patterns.EMAIL_ADDRESS.matcher(Email ).matches()){
                    email.setError( "please enter the vaild email" );
                    email.requestFocus(  );
                    return;
                }
                if(TextUtils.isEmpty(Pass)){
                    password.setError( "password is Required" );
                    password.requestFocus() ;
                    return;
                }

                if(!PASSWORD_PATTERN.matcher(Pass).matches()){
                    password.setError( "please enter 1 uppercase,1 lowercase,1 digit,1 special character " );
                    password.requestFocus(  );
                    return;
                }

                if(Pass.length()<6){
                    password.setError( "minimum length of password should be 6" );
                    password.requestFocus();
                    return;
                }

                if(TextUtils.isEmpty(Phone)){
                    phone.setError( "Number is Required" );
                    phone.requestFocus() ;
                    return;
                }

                if(!isValidPhone(phone.getText().toString())){
                    phone.setError( "length of phone number should be 10" );
                    phone.requestFocus();
                    return;
                }

                boolean res = databaseCustomer.User_Data(name.getText().toString(),email.getText().toString(),
                        password.getText().toString(),
                        phone.getText().toString());
                if (res) {
                    MyMessage();
                    Toast.makeText(SignupActivity.this, "Registered Successfully",
                            Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(SignupActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(SignupActivity.this, "Try Again",
                            Toast.LENGTH_LONG).show();
                }

            }
        });



    }


    private void MyMessage() {

        String phonenumber=phone.getText().toString();

        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(phonenumber, null, "Thank you for Registering to this Application, For Further Queries Contact to infogasagency@gmail.com", null, null);


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


    public boolean isValidPhone(String phone) {

        boolean check=false;
        if(!Pattern.matches("[a-zA-Z]+", phone))
        {
            if(phone.length() <=9 || phone.length() > 10)
            {
                check = false;

            }
            else
            {
                check = true;

            }
        }
        else
        {
            check=false;
        }
        return check;
    }

    }

