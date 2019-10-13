package com.example.vaccinate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class parentRegisterActivity extends AppCompatActivity {

    EditText aadharEditText,firstNameEditText,lastNameEditText,phoneEditText;
    Button submitButton, cancelButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_register);
        aadharEditText = findViewById(R.id.aadharEditText);
        firstNameEditText = findViewById(R.id.firstNameEditText);
        lastNameEditText = findViewById(R.id.lastNameEditText);
        phoneEditText = findViewById(R.id.phoneEditText);
        submitButton =  findViewById(R.id.submitButton);
        cancelButton = findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(parentRegisterActivity.this,homeActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
