package com.app.discoverytrails.menus;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.app.discoverytrails.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MenuActivity extends AppCompatActivity {

    private BottomNavigationView bottom_navigation;

    private NavController navigationController;


    @Override
    public boolean onSupportNavigateUp() {
        return super.onSupportNavigateUp();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);



        navigationController = Navigation.findNavController(this,R.id.demo_nav_host_fragment);

        NavigationUI.setupActionBarWithNavController(this, navigationController);


        bottom_navigation = findViewById(R.id.bottom_navigation);


        bottom_navigation.setOnNavigationItemSelectedListener(menuItem -> {


            switch (menuItem.getItemId()) {
                case R.id.action_favorites:

                    navigationController.navigate(R.id.favoritesFragment);

                    break;
                case R.id.action_schedules:
                    navigationController.navigate(R.id.schedulesFragment);
                    break;
                case R.id.action_music:
                    navigationController.navigate(R.id.musicFragment);
                    break;
                default:

                    break;
            }

            return true;
        });

    }

}
