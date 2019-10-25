package com.example.vaccinate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
        emailEditText = findViewById(R.id.emailEditText);
        passEditText = findViewById(R.id.passEditText);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(parentSignupActivity.this,parentRegisterActivity.class);
                String email = emailEditText.getText().toString().trim();
                String pass =  passEditText.getText().toString().trim();
                intent.putExtra("email",email);
                intent.putExtra("pass",pass);
                startActivity(intent);
                finish();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(parentSignupActivity.this,homeActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
