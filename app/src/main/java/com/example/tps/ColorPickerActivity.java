package com.example.tps;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class ColorPickerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_picker);

        Button btnRed = findViewById(R.id.btnRed);
        Button btnYellow = findViewById(R.id.btnYellow);
        Button btnBlue = findViewById(R.id.btnBlue);
        Button btnGreen = findViewById(R.id.btnGreen);

        // Set color on click and return to MainActivity
        btnRed.setOnClickListener(view -> returnColor(Color.RED));
        btnYellow.setOnClickListener(view -> returnColor(Color.YELLOW));
        btnBlue.setOnClickListener(view -> returnColor(Color.BLUE));
        btnGreen.setOnClickListener(view -> returnColor(Color.GREEN));
    }

    private void returnColor(int color) {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("color", color);
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}
