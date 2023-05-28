package com.example.match_point;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class Registro_2 extends AppCompatActivity {

    private Button btnCrear;
    private EditText etMail;
    private EditText etPass;
    private String email;
    private String password;
    private String usuario;
    private CheckBox chkAceptar;
    private EditText etUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro2);

        btnCrear = findViewById(R.id.btnCrear);
        etMail = findViewById(R.id.etMail);
        etPass = findViewById(R.id.etPass);
        chkAceptar = findViewById(R.id.chkAceptar);
        etUsuario = findViewById(R.id.etUsuario);

        Intent login = new Intent(this,Home_page.class);

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                password = etPass.getText().toString();
                email = etMail.getText().toString();
                usuario = etUsuario.getText().toString();

                if(chkAceptar.isChecked()) {
                    if(etPass.length()<5)
                        Toast.makeText(Registro_2.this, "Contraseña mínimo 5 caracteres", Toast.LENGTH_SHORT).show();
                    FirebaseAuth.getInstance()
                            .createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // User registered successfully
                                        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                                        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                                .setDisplayName(usuario)
                                                //.setPhotoUri(Uri.parse("https://example.com/jane-q-user/profile.jpg"))
                                                .build();

                                        user.updateProfile(profileUpdates)
                                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<Void> task) {
                                                        if (task.isSuccessful()) {
                                                            Toast.makeText(Registro_2.this, "Se actualizó usuario", Toast.LENGTH_SHORT).show();
                                                        }
                                                    }
                                                });
                                        startActivity(login);

                                    }
                                }
                            });


                }
                else{
                    Toast.makeText(Registro_2.this, "Debes aceptar los términos y condiciones " +
                            "para crear una cuenta", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}