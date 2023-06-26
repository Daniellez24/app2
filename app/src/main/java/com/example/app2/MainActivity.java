package com.example.app2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.app2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    NavController navController;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.main_navhost);
        navController = navHostFragment.getNavController();
        NavigationUI.setupActionBarWithNavController(this, navController);

        NavigationUI.setupWithNavController(binding.mainBottomNavigationView, navController);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            navController.popBackStack();
        }

        return super.onOptionsItemSelected(item);
    }
}