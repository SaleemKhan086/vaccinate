package com.example.vaccinate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class parentRegisterActivity extends AppCompatActivity implements TextWatcher {

    login_db mydb = new login_db(this);
    EditText aadharEditText,firstNameEditText,lastNameEditText,phoneEditText;
    Button submitButton, cancelButton;
    String email,pass,aadhar,fname,lname,phone;
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
        aadharEditText.addTextChangedListener(this);
        Intent i  = getIntent();
        email = i.getStringExtra("email");
        pass = i.getStringExtra("pass");
        /*if(i.getExtras() == null)
            submitButton.setText("nnn");
        else submitButton.setText(email);*/
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                aadhar = aadharEditText.getText().toString().trim();
                fname = firstNameEditText.getText().toString().trim();
                lname = lastNameEditText.getText().toString().trim();
                phone = phoneEditText.getText().toString().trim();
                boolean res = mydb.insertData(email,pass,aadhar,fname,lname,phone);
                if(res)
                {
                    Toast.makeText(getApplicationContext(),"Registered Successfully..",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"An error Occured.!!! Try again later.",Toast.LENGTH_LONG).show();
                }
                Intent intent = new Intent(parentRegisterActivity.this,homeActivity.class);
                startActivity(intent);
                finish();
            }
        });
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(parentRegisterActivity.this,homeActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if(s.toString().length() !=12)
            aadharEditText.setError("Invalid Input!");
    }
}
