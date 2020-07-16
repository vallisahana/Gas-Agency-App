package com.example.sahana.gasagency;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sahana.gasagency.Database.DatabaseVendor;

public class DistributorLoginActivity extends AppCompatActivity {

    private EditText email,password;
    private Button btnlogin;
    private TextView txtregister;
    private CheckBox checkBox;


    DatabaseVendor databaseUser=new DatabaseVendor(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distributor_login);

        email=findViewById( R.id.editemail );
        password=findViewById( R.id.editpassword );
        btnlogin=findViewById( R.id.buttonlogin );
        txtregister=findViewById( R.id.textlogin );
        checkBox=findViewById(R.id.checklogin);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());

                } else {
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });


        txtregister.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( DistributorLoginActivity.this,DistriutorRegisterActivity.class );

                startActivity( intent );
            }
        } );

        btnlogin.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {


                String Email = email.getText().toString().trim();
                String Pass = password.getText().toString().trim();



                Boolean chkemailpass = databaseUser.emailpassword(Email,Pass);

                if (chkemailpass == true) {
                    Toast.makeText(getApplicationContext(), "Successfully login", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(DistributorLoginActivity.this, DistributorHomeActivity.class);
                    startActivity(intent);
                    finish();

                } else {
                    Toast.makeText(getApplicationContext(), "wrong password", Toast.LENGTH_LONG).show();
                }
            }

        });


    }
}
