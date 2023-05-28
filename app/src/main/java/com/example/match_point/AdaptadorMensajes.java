package com.example.match_point;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorMensajes extends RecyclerView.Adapter<HolderMensaje> {

    private List<Mensaje> listamensajes = new ArrayList<>();
    private Context c;

    public AdaptadorMensajes(Context c) {
        this.c = c;
    }

    public void addMensaje(Mensaje m){
        listamensajes.add(m);
        notifyItemInserted(listamensajes.size());
    }

    @NonNull
    @Override
    public HolderMensaje onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(c).inflate(R.layout.card_view_mensajes,parent,false);
        return new HolderMensaje(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderMensaje holder, int position) {
        holder.getNombre().setText(listamensajes.get(position).getNombre());
        holder.getMensaje().setText(listamensajes.get(position).getMensaje());
        holder.getHora().setText(listamensajes.get(position).getHora());
    }

    @Override
    public int getItemCount() {
        return listamensajes.size();
    }
}
