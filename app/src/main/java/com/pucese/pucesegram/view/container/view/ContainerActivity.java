package com.pucese.pucesegram.view.container.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.pucese.pucesegram.R;
import com.pucese.pucesegram.login.view.LoginActivity;
import com.pucese.pucesegram.view.container.presenter.ContainerPresenter;
import com.pucese.pucesegram.view.fragment.home.view.HomeFragment;
import com.pucese.pucesegram.view.fragment.profile.view.ProfileFragment;
import com.pucese.pucesegram.view.fragment.search.view.SearchFragment;

public class ContainerActivity extends AppCompatActivity implements ContainerView{

    //Llamar capa del presentador
    private ContainerPresenter presenter;

    //Barra de navegacion
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

    public void logout(final View view) {
        FirebaseAuth.getInstance().signOut();
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
        finish();
        /*GoogleSignIn.getClient(this, new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .build()).signOut().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                startActivity(new Intent(view.getContext(), LoginActivity.class));
                Toast.makeText(ContainerActivity.this, "Finalizó sesión", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(ContainerActivity.this, "Ha fallado el cierre de sesión", Toast.LENGTH_SHORT).show();
            }
        });*/
    }

}