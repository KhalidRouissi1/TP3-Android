package com.example.tps;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DisplayActivity extends AppCompatActivity {

    private TextView tvDisplay;
    private Button btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        tvDisplay = findViewById(R.id.tvDisplay);
        btnReturn = findViewById(R.id.btnReturn);

        // Retrieve and display data from Intent
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String age = intent.getStringExtra("age");
        String website = intent.getStringExtra("website");
        String phone = intent.getStringExtra("phone");

        String displayText = "Name: " + name + "\nAge: " + age + "\nWebsite: " + website + "\nPhone: " + phone;
        tvDisplay.setText(displayText);

        // Return button to go back to MainActivity
        btnReturn.setOnClickListener(view -> finish());
    }
}
