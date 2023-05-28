package com.example.match_point;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PerfilAmigo extends AppCompatActivity {

    private ImageView ivPerfil;
    private TextView tvNombre;
    private ImageView ivMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getSupportActionBar().hide();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_amigo);

        ivPerfil = findViewById(R.id.ivPerfil);
        tvNombre = findViewById(R.id.tvNombrePerfilAmigo);
        ivMensaje = findViewById(R.id.ivMensaje);

        Intent i = getIntent();

        String username = i.getStringExtra("nombre");
        int foto = i.getIntExtra("foto",-1);

        tvNombre.setText(username);
        ivPerfil.setImageResource(foto);

        Intent chat = new Intent(this,Chat_Activity.class);

        ivMensaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(chat);
            }
        });
    }
}