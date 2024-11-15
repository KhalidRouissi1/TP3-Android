package com.example.tps;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainButton_EX1 extends AppCompatActivity {
    Button button;
    View mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EdgeToEdge.enable(this);
        super.onCreate(savedInstanceState);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setContentView(R.layout.activity_main_button_ex1);

        mainLayout = findViewById(R.id.main);
        button = findViewById(R.id.button2);

        button.setOnClickListener(view -> {
            Intent intent = new Intent(MainButton_EX1.this, ListeView_View.class);
            startActivityForResult(intent, 1);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            if (data != null) {
                String selectedColor = data.getStringExtra("selectedColor");
                if (selectedColor != null) {
                    int colorId = getColorFromName(selectedColor);
                    mainLayout.setBackgroundColor(colorId);
                }
            }
        }
    }

    private int getColorFromName(String colorName) {
        switch (colorName) {
            case "black":
                return Color.BLACK; // Use predefined Color constants
            case "blue":
                return Color.parseColor("#1F51FF");
            case "yellow":
                return Color.YELLOW; // Use predefined Color constants
            case "green":
                return Color.GREEN; // Use predefined Color constants
            case "red":
                return Color.RED; // Use predefined Color constants
            default:
                return Color.WHITE;
        }
    }
}
