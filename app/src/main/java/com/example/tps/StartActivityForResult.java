package com.example.tps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class StartActivityForResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_start_for_result);

        Button btnRed = findViewById(R.id.btnRed);
        Button btnYellow = findViewById(R.id.btnYellow);
        Button btnBlue = findViewById(R.id.btnBlue);
        Button btnGreen = findViewById(R.id.btnGreen);

        btnRed.setOnClickListener(view -> returnColor("#FF0000"));
        btnYellow.setOnClickListener(view -> returnColor("#FFFF00"));
        btnBlue.setOnClickListener(view -> returnColor("#0000FF"));
        btnGreen.setOnClickListener(view -> returnColor("#00FF00"));
    }

    private void returnColor(String color) {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("color", color);
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}
