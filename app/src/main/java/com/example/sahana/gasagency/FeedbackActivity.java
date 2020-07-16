package com.example.sahana.gasagency;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sahana.gasagency.Database.DatabaseFeedback;

public class FeedbackActivity extends AppCompatActivity {

    EditText title,message;
    Button submit;

    DatabaseFeedback databaseFeedback=new DatabaseFeedback(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        title=findViewById(R.id.title);
        message=findViewById(R.id.msg);
        submit=findViewById(R.id.btnSubmitFeedback);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean res =databaseFeedback.User_Data(title.getText().toString(),
                        message.getText().toString());
                if (res) {

                    Toast.makeText(FeedbackActivity.this, "Feedback Submitted Successfully",
                            Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(FeedbackActivity.this,UserHomeActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(FeedbackActivity.this, "Try Again",
                            Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    public void goBackHome(View view) {
        Intent home = new Intent(FeedbackActivity.this,UserHomeActivity.class);
        startActivity(home);
    }
}
