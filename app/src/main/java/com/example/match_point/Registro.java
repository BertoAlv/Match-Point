package com.example.match_point;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;

public class Registro extends AppCompatActivity {

    private Spinner spPaises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        spPaises = findViewById(R.id.spPaises);

        spPaises.setPrompt("Pais");
    }
}