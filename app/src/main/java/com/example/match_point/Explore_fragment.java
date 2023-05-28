package com.example.match_point;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

public class Explore_fragment extends Fragment {
    private ListView lvJugadores;

    public Explore_fragment(){
        // require a empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_explore_layout, container, false);

        lvJugadores = view.findViewById(R.id.lvJugadores);

        lvJugadores.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        Intent clara = new Intent(getContext(),PerfilAmigo.class);
                        clara.putExtra("foto",R.drawable.avatar_anonimo5);
                        clara.putExtra("nombre","Clara López");
                        startActivity(clara);
                        break;
                    case 1:
                        Intent marcos = new Intent(getContext(),PerfilAmigo.class);
                        marcos.putExtra("foto",R.drawable.avatar_anonimo);
                        marcos.putExtra("nombre","Marcos González");
                        startActivity(marcos);
                        break;
                    case 2:
                        Intent anton = new Intent(getContext(),PerfilAmigo.class);
                        anton.putExtra("foto",R.drawable.avatar_anonimo2);
                        anton.putExtra("nombre","Antón Peña");
                        startActivity(anton);
                        break;
                    case 3:
                        Intent marta = new Intent(getContext(),PerfilAmigo.class);
                        marta.putExtra("foto",R.drawable.avatar_anonimo4);
                        marta.putExtra("nombre","Marta Fernández");
                        startActivity(marta);
                        break;
                    case 4:
                        Intent victor = new Intent(getContext(),PerfilAmigo.class);
                        victor.putExtra("foto",R.drawable.avatar_anonimo3);
                        victor.putExtra("nombre","Víctor García");
                        startActivity(victor);
                        break;
                }
            }
        });

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();

    }
}