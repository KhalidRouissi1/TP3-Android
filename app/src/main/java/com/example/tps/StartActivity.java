package com.example.tps;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class StartActivity extends AppCompatActivity {

    private static final int COLOR_REQUEST_CODE = 1;
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_start);

        textView2 = findViewById(R.id.textView2);
        View btnChangeBg = findViewById(R.id.button);

        btnChangeBg.setOnClickListener(view -> {
            // Create an intent to launch StartActivityForResult
            Intent intent = new Intent(StartActivity.this, StartActivityForResult.class);
            startActivityForResult(intent, COLOR_REQUEST_CODE); // Start with a request code
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Handle the result from StartActivityForResult
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == COLOR_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            // Get the color passed back from StartActivityForResult
            String color = data.getStringExtra("color");
            textView2.setBackgroundColor(Color.parseColor(color)); // Change the background color
        }
    }
}
