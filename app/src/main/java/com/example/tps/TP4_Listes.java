package com.example.tps;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TP4_Listes extends AppCompatActivity {
    ArrayAdapter<String> arrayAdapter;
    View mainLayout; // Reference to the main layout

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tp4_listes);

        mainLayout = findViewById(R.id.main); // Initialize the main layout

        ViewCompat.setOnApplyWindowInsetsListener(mainLayout, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Assuming these are valid numeric values as strings
        String[] tab = getResources().getStringArray(R.array.notes); // Ensure this array is defined correctly in strings.xml

        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tab);

        ListView listView = findViewById(R.id.activity_noteslist);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String selectedItem = arrayAdapter.getItem(position);
                if (selectedItem != null) {
                    Toast.makeText(TP4_Listes.this, "Bonjour " + selectedItem, Toast.LENGTH_SHORT).show();

                    // Parse the selected item to an integer
                    try {
                        int selectedValue = Integer.parseInt(selectedItem.trim()); // Trim spaces

                        // Change the background color of the main layout based on the value
                        if (selectedValue < 10) {
                            mainLayout.setBackgroundColor(Color.RED); // Background color red
                        } else if (selectedValue >= 10 && selectedValue <= 15) {
                            mainLayout.setBackgroundColor(Color.YELLOW); // Background color yellow
                        } else {
                            mainLayout.setBackgroundColor(Color.GREEN); // Background color green
                        }
                    } catch (NumberFormatException e) {
                        Toast.makeText(TP4_Listes.this, "Invalid number format", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
