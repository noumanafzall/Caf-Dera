package com.example.cafedera;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class staffRegistration extends AppCompatActivity {

    EditText etName , etEmail , etPassword;
    Button btnSignUp;
    RadioButton rbCashier , rbChef;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_registration);

        rbCashier = findViewById(R.id.rbCashier);
        rbChef = findViewById(R.id.rbChef);
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnSignUp = findViewById(R.id.btnSignUp);
        radioGroup = findViewById(R.id.radioGroup);

        database g = new database(this);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                if(name.equals("") || email.equals("") || password.equals("") || radioGroup.getCheckedRadioButtonId() == -1){
                    Toast.makeText(staffRegistration.this, "Enter All Fields ", Toast.LENGTH_SHORT).show();
                }
                else{
                    // Inserting into database
                    Boolean i =g.insert_data(name , email , password);
                    if(i == true){
                        Toast.makeText(staffRegistration.this, "Successful", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(staffRegistration.this, "Not Successful", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}