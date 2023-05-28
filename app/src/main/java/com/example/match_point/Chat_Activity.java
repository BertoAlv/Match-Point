package com.example.match_point;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.Calendar;

import de.hdodenhof.circleimageview.CircleImageView;

public class Chat_Activity extends AppCompatActivity {

    private CircleImageView circleImageView;
    private TextView tvNombreUsuario;
    private RecyclerView recyclerView;
    private EditText etMensaje;
    private Button btnEnviar;
    private AdaptadorMensajes adaptadorMensajes;

    private FirebaseDatabase database;
    private DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        inicializar();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String username = user.getDisplayName();

        tvNombreUsuario.setText(username);

        adaptadorMensajes = new AdaptadorMensajes(this);
        LinearLayoutManager l = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(l);
        recyclerView.setAdapter(adaptadorMensajes);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.push().setValue(new Mensaje(etMensaje.getText().toString(),
                        tvNombreUsuario.getText().toString(),"","1",Calendar.getInstance().getTime().toString().substring(10,16)));
                etMensaje.setText("");
            }
        });

        adaptadorMensajes.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onItemRangeInserted(int positionStart, int itemCount) {
                super.onItemRangeInserted(positionStart, itemCount);
                setScrollbar();
            }
        });

        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("chat_room");

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Mensaje m = snapshot.getValue(Mensaje.class);
                adaptadorMensajes.addMensaje(m);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    public void inicializar(){
        circleImageView = findViewById(R.id.civFotoPerfil);
        tvNombreUsuario = findViewById(R.id.tvNombreUsuario);
        recyclerView = findViewById(R.id.rvMensajes);
        etMensaje = findViewById(R.id.etMensaje);
        btnEnviar = findViewById(R.id.btnEnviar);

    }

    private void setScrollbar(){
        recyclerView.scrollToPosition(adaptadorMensajes.getItemCount()-1);
    }
}