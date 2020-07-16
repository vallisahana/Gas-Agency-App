package com.example.sahana.gasagency;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sahana.gasagency.Database.DatabaseCustomer;

public class MainActivity extends AppCompatActivity {

    EditText phone,password;

    DatabaseCustomer databaseCustomer=new DatabaseCustomer(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phone = findViewById(R.id.username);
        password = findViewById(R.id.password);
        Button buttonLogin = findViewById(R.id.buttonSignIn);
        Button buttonSignup = findViewById(R.id.buttonSignUp);

        buttonSignup.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this, SignupActivity.class );

                startActivity( intent );
            }
        } );

        buttonLogin.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {


                String Email = phone.getText().toString().trim();
                String Pass = password.getText().toString().trim();



                Boolean chkemailpass = databaseCustomer.emailpassword(Email,Pass);

                if (chkemailpass == true) {
                    Toast.makeText(getApplicationContext(), "Successfully login", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(MainActivity.this, UserHomeActivity.class);
                    startActivity(intent);
                    finish();

                } else {
                    Toast.makeText(getApplicationContext(), "wrong password", Toast.LENGTH_LONG).show();
                }
            }

        });
    }
}
