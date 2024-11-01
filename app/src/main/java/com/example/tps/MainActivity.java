package com.example.tps;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final int COLOR_REQUEST_CODE = 1;

    private EditText etName, etAge, etWebsite, etPhone;
    private Button btnValidate, btnChangeColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        etWebsite = findViewById(R.id.etWebsite);
        etPhone = findViewById(R.id.etPhone);
        btnValidate = findViewById(R.id.btnValidate);
        btnChangeColor = findViewById(R.id.btnChangeColor);

        // Validate button logic
        btnValidate.setOnClickListener(view -> {
            validateField(etName);
            validateField(etAge);
            validateField(etWebsite);
            validateField(etPhone);

            // Passing data to DisplayActivity
            Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
            intent.putExtra("name", etName.getText().toString());
            intent.putExtra("age", etAge.getText().toString());
            intent.putExtra("website", etWebsite.getText().toString());
            intent.putExtra("phone", etPhone.getText().toString());
            startActivity(intent);
        });

        // Change color button logic
        btnChangeColor.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ColorPickerActivity.class);
            startActivityForResult(intent, COLOR_REQUEST_CODE);
        });
    }

    private void validateField(EditText editText) {
        if (editText.getText().toString().isEmpty()) {
            editText.setBackgroundColor(Color.RED);
        } else {
            editText.setBackgroundColor(Color.GREEN);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == COLOR_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            int color = data.getIntExtra("color", Color.WHITE);
            findViewById(R.id.rootView).setBackgroundColor(color);
        }
    }
}
