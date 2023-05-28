package com.example.match_point;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import de.hdodenhof.circleimageview.CircleImageView;

public class HolderMensaje extends RecyclerView.ViewHolder {

    private TextView nombre;
    private TextView hora;
    private TextView mensaje;
    private CircleImageView fotoUsuario;

    public HolderMensaje(@NonNull View itemView) {
        super(itemView);
        nombre = (TextView) itemView.findViewById(R.id.tvNombreUsuarioMensaje);
        hora = (TextView) itemView.findViewById(R.id.tvHoraMensaje);
        mensaje = (TextView) itemView.findViewById(R.id.tvMensaje);
        fotoUsuario = (CircleImageView) itemView.findViewById(R.id.civFotoPerfilMensaje);
    }

    public TextView getNombre() {
        return nombre;
    }

    public void setNombre(TextView nombre) {
        this.nombre = nombre;
    }

    public TextView getHora() {
        return hora;
    }

    public void setHora(TextView hora) {
        this.hora = hora;
    }

    public TextView getMensaje() {
        return mensaje;
    }

    public void setMensaje(TextView mensaje) {
        this.mensaje = mensaje;
    }

    public CircleImageView getFotoUsuario() {
        return fotoUsuario;
    }

    public void setFotoUsuario(CircleImageView fotoUsuario) {
        this.fotoUsuario = fotoUsuario;
    }
}
