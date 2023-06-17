package com.example.cafedera;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class customer_tab extends AppCompatActivity {

    private TextView tvTable1Status;
    private EditText etName, etTableNumber;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_tab);

        tvTable1Status = findViewById(R.id.tvTable1Status);
        etName = findViewById(R.id.cstName);
        etTableNumber = findViewById(R.id.TableNumber);
        btnSubmit = findViewById(R.id.btnSubmit);

        // Set an onClickListener for the submit button
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String tableNumber = etTableNumber.getText().toString();

                // Check if the table is occupied
                if (isTableOccupied(tableNumber)) {
                    String message = "Table " + tableNumber + " is already occupied.";
                    // Display the message to the user
                    displayMessage(message);
                } else {
                    // Table is available, perform further actions here
                    // For example, proceed to the next activity
                    // Intent intent = new Intent(CustomerTabActivity.this, NextActivity.class);
                    // startActivity(intent);
                }
            }
        });
    }

    // Method to check if the table is occupied
    private boolean isTableOccupied(String tableNumber) {
        // Perform your logic here to check if the table is occupied
        // You can use your own implementation, e.g., checking a database or array

        // Example: Assume Table 1 is occupied
        return tableNumber.equals("1");
    }

    // Method to display a message to the user
    private void displayMessage(String message) {
        // Set the message to the TextView
        tvTable1Status.setText(message);
    }
}
