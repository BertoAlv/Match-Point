package com.example.match_point;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.match_point.databinding.ActivityHomePageBinding;
import com.google.firebase.auth.FirebaseAuth;

public class Home_page extends AppCompatActivity {
    ActivityHomePageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHomePageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFragment(new Home_fragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){

                case R.id.navigation_home:
                    replaceFragment(new Home_fragment());
                    this.getSupportActionBar().show();
                    break;
                case R.id.navigation_explore:
                    replaceFragment(new Explore_fragment());
                    break;
                case R.id.navigation_profile:
                    replaceFragment(new Profile_fragment());
                    break;
            }

            return true;
        });

    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        //Intent i = new Intent(Home_page.this,MainActivity.class);
        Intent chat = new Intent(Home_page.this,Chat_Activity.class);

        switch (item.getItemId()){

            case R.id.chat: startActivity(chat);
                            return true;

            case R.id.config: return true;

            case R.id.logout: FirebaseAuth.getInstance().signOut();
                            finish();
                            return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.flFragment,fragment);
        fragmentTransaction.commit();

    }

}