package com.example.tps;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MatiereActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matiere);

        // Initialisation de l'AutoCompleteTextView
        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.matiere);

        // Création d'un tableau de matières
        String[] matieres = {"Algoritmique", "Android", "Programmation C", "Programmation OO"};

        // Création d'un adaptateur pour l'AutoCompleteTextView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, matieres);

        // Lier l'adaptateur à l'AutoCompleteTextView
        autoCompleteTextView.setAdapter(adapter);

        // Implémentation de l'événement setOnItemClickListener
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Récupération de la matière sélectionnée
                String selectedMatiere = (String) parent.getItemAtPosition(position);
                // Affichage d'un Toast avec le nom de la matière
                Toast.makeText(MatiereActivity.this, "Matière sélectionnée : " + selectedMatiere, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
