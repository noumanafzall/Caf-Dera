package com.example.cafedera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Staff_Login extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private RadioGroup radioGroup;
    private RadioButton rbChef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_login);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        radioGroup = findViewById(R.id.radioGroup);
        rbChef = findViewById(R.id.rbChef);

        Button btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                // Check if the chef radio button is selected
                if (rbChef.isChecked()) {
                    // Perform your username and password validation here
                    if (isValidCredentials(username, password)) {
                        // Open the ActivityChefCat activity
                        Intent intent = new Intent(Staff_Login.this, chef_cat.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(Staff_Login.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Staff_Login.this, "Please select the Chef option", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button btnSignUp = findViewById(R.id.btnSignup);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the StaffRegistration activity
                Intent intent = new Intent(Staff_Login.this, staffRegistration.class);
                startActivity(intent);
            }
        });

    }



    // Example method to validate the username and password
    private boolean isValidCredentials(String username, String password) {
        // Perform your validation logic here
        // Replace this example condition with your own validation logic
        return username.equals("admin") && password.equals("123456");
    }
}


