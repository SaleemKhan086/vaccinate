package com.example.vaccinate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class homeActivity extends AppCompatActivity {

    login_db myDb = new login_db(this);
    Button registerButton;
    EditText uNameEditText,passEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        registerButton = findViewById(R.id.registerButton);
        uNameEditText = findViewById(R.id.uNameEditText);
        passEditText  = findViewById(R.id.passEditText);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homeActivity.this, parentSignupActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
