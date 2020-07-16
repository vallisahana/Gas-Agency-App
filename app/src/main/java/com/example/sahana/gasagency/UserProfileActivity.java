package com.example.sahana.gasagency;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sahana.gasagency.Database.DatabaseCustomer;

public class UserProfileActivity extends AppCompatActivity {

    EditText edtname,edtemail,edtpass,edtphone;

    SQLiteDatabase sqLiteDatabase;
    DatabaseCustomer dbh;
    Cursor res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        edtname=findViewById(R.id.name);
        edtemail=findViewById(R.id.email);
        edtpass=findViewById(R.id.password);

        edtphone=findViewById(R.id.phone);

        Button btn=findViewById(R.id.btnteacherupdate);




        dbh = new DatabaseCustomer(getApplicationContext());
        sqLiteDatabase=dbh.getReadableDatabase();
        res=dbh.UserData();

        if(res.moveToFirst())
        {
            do{
                String name,email,password,confirm,phone,branch,subject;

                name= res.getString(0);
                email=res.getString(1);
                password=res.getString(2);
                phone=res.getString(3);



                edtname.setText(name);
                edtemail.setText(email);
                edtpass.setText(password);
                edtphone.setText(phone);



            }while(res.moveToNext());
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    String name=  edtname.getText().toString().trim();
                    String email=  edtemail.getText().toString().trim();
                    String password= edtpass.getText().toString().trim();
                    String phone =edtphone.getText().toString().trim();




                    //Save into DBS
                    dbh.updateuser(name,email,password,phone);

                    Toast.makeText(UserProfileActivity.this, "Modified Successfully", Toast.LENGTH_SHORT).show();
                    dbh.close();
                    startActivity(new Intent(UserProfileActivity.this, UserHomeActivity.class));
                    finish();

                }catch (Exception e){

                    e.printStackTrace();
                }

            }
        });
    }
}
