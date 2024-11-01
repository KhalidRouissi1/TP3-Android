package com.example.tps;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Main_Game extends AppCompatActivity {
    private int score = 0;
    private int level = 1;
    private TextView tvScore, tvLevel;
    private Button btnClick, btnReplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        tvScore = findViewById(R.id.tvScore);
        tvLevel = findViewById(R.id.tvLevel);
        btnClick = findViewById(R.id.btnClick);
        btnReplay = findViewById(R.id.btnReplay);

        btnClick.setOnClickListener(view -> incrementScore());

        btnReplay.setOnClickListener(view -> resetGame());
    }
    private void incrementScore(){
        score++;
        tvScore.setText("Score: " + score);

        if (score % 5 == 0) {
            level++;
            tvLevel.setText("Level: " + level);

            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();

            // Launch LevelActivity and pass the current level
            Intent intent = new Intent(Main_Game.this, Second_game.class);
            intent.putExtra("level", level);
            startActivity(intent);
        }

    }

    private void resetGame(){
        score  = 0;
        level = 1;
        tvScore.setText("Score: " + score);
        tvLevel.setText("Level: " + level);
    }
}