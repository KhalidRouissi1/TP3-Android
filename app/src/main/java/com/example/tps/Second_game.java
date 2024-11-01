package com.example.tps;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Second_game extends AppCompatActivity {
    private TextView tvCurrentLevel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second_game);
        tvCurrentLevel = findViewById(R.id.tvCurrentLevel);

        Intent intent = getIntent();
        int level = intent.getIntExtra("level", 1);
        tvCurrentLevel.setText("Current Level: " + level);
    }
}