package com.example.vaccinate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class parentSignupActivity extends AppCompatActivity {

    login_db myDb = new login_db(this);
    Button nextButton,backButton;
    EditText emailEditText,passEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_signup);
        nextButton  = findViewById(R.id.nextButton);
        backButton = findViewById(R.id.backButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(parentSignupActivity.this,parentRegisterActivity.class);
                startActivity(intent);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(parentSignupActivity.this,homeActivity.class);
                String email = emailEditText.getText().toString();
                String pass =  passEditText.getText().toString();
                myDb.insertData(email,pass);
                startActivity(intent);
                finish();
            }
        });
    }
}
