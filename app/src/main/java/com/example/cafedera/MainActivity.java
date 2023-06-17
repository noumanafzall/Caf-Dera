package com.example.cafedera;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database g = new database(this);
        SQLiteDatabase db = g.getReadableDatabase();

        Button btnStaffIn = findViewById(R.id.btnStaff);
        Button btnCustIn = findViewById(R.id.btnCustomer);

        btnStaffIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to Enter the Staff activity
                Intent intent = new Intent(MainActivity.this, Staff_Login.class);
                startActivity(intent);
            }
        });
        btnCustIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to Enter the Customer activity
                Intent intent = new Intent(MainActivity.this, customer_tab.class);
                startActivity(intent);
            }
        });

    }
}
