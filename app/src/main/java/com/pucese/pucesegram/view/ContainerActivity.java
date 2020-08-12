package com.pucese.pucesegram.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.pucese.pucesegram.R;
import com.pucese.pucesegram.view.fragment.HomeFragment;
import com.pucese.pucesegram.view.fragment.ProfileFragment;
import com.pucese.pucesegram.view.fragment.SearchFragment;

public class ContainerActivity extends AppCompatActivity {

    BottomNavigationView mbottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        mbottomNavigation = (BottomNavigationView) findViewById(R.id.bottom_navigation_view);
        //Para seleccionar home por defecto
        mbottomNavigation.getMenu().findItem(R.id.thome).setChecked(true); showSelectedFragment(new HomeFragment());

        mbottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if(menuItem.getItemId() == R.id.thome) {
                    showSelectedFragment(new HomeFragment());
                }

                if(menuItem.getItemId() == R.id.tprofile) {
                    showSelectedFragment(new ProfileFragment());
                }

                if(menuItem.getItemId() == R.id.tsearch) {
                    showSelectedFragment(new SearchFragment());
                }

                if(menuItem.getItemId() == R.id.tcamera) {
                    showSelectedFragment(new ProfileFragment());
                }

                if(menuItem.getItemId() == R.id.tfavorite) {
                    showSelectedFragment(new SearchFragment());
                }

                return true;
            }
        });
    }

    private void showSelectedFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }
}