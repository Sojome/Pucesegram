package com.pucese.pucesegram.container.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.pucese.pucesegram.R;
import com.pucese.pucesegram.login.view.LoginActivity;
import com.pucese.pucesegram.container.presenter.ContainerPresenter;
import com.pucese.pucesegram.container.presenter.ContainerPresenterImpl;
import com.pucese.pucesegram.fragment.home.view.HomeFragment;
import com.pucese.pucesegram.fragment.profile.view.ProfileFragment;
import com.pucese.pucesegram.fragment.search.view.SearchFragment;

public class ContainerActivity extends AppCompatActivity implements ContainerView{

    //Llamar capa del presentador
    private ContainerPresenter presenter;

    //Barra de navegacion
    BottomNavigationView mbottomNavigation;
    private Button salir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        presenter = new ContainerPresenterImpl(this);

        salir = findViewById(R.id.boton_salir);

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.logout();
            }
        });

        mbottomNavigation = (BottomNavigationView) findViewById(R.id.bottom_navigation_view);
        //Para seleccionar home por defecto
        mbottomNavigation.getMenu().findItem(R.id.thome).setChecked(true); //showSelectedFragment(new HomeFragment());
        presenter.showSelectedFragment(new HomeFragment(), getSupportFragmentManager());

        mbottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if(menuItem.getItemId() == R.id.thome) {
                    presenter.showSelectedFragment(new HomeFragment(), getSupportFragmentManager());
                }

                if(menuItem.getItemId() == R.id.tprofile) {
                    presenter.showSelectedFragment(new ProfileFragment(), getSupportFragmentManager());
                }

                if(menuItem.getItemId() == R.id.tsearch) {
                    presenter.showSelectedFragment(new SearchFragment(), getSupportFragmentManager());
                }

                /*

                if(menuItem.getItemId() == R.id.tcamera) {
                    presenter.showSelectedFragment(new ProfileFragment(), getSupportFragmentManager());
                }

                if(menuItem.getItemId() == R.id.tfavorite) {
                    presenter.showSelectedFragment(new SearchFragment(), getSupportFragmentManager());
                }

                */

                return true;
            }
        });
    }

    @Override
    public void logout() {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
        finish();
    }
}