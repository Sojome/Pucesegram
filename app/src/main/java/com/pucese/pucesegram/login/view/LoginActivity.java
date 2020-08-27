package com.pucese.pucesegram.login.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.pucese.pucesegram.*;
import com.pucese.pucesegram.addinfo.view.AddInfoActivity;
import com.pucese.pucesegram.login.presenter.LoginPresenter;
import com.pucese.pucesegram.login.presenter.LoginPresenterImpl;
import com.pucese.pucesegram.register.view.RegisterActivity;
import com.pucese.pucesegram.reset.view.ResetPasswordActivity;
import com.pucese.pucesegram.container.view.ContainerActivity;

public class LoginActivity extends AppCompatActivity implements LoginView {

    //Variables globales
    private TextInputEditText username, password;
    private Button login;
    private TextView register, reset;
    private ProgressBar progressBarLogin;
    private LoginPresenter presenter;
    private FirebaseAuth mAuth;

    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        register = findViewById(R.id.createHere);
        reset = findViewById(R.id.Resetpass);
        progressBarLogin= findViewById((R.id.progressbarLogin));
        hideProgressBar();

        reference = FirebaseDatabase.getInstance().getReference();

        /*reference.child("Users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(final DataSnapshot snapshot : dataSnapshot.getChildren()){

                    reference.child("Users").child(snapshot.getKey()).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            User listado = snapshot.getValue(User.class);

                            Boolean admin = listado.isAdmin();
                            String correo = listado.getCorreo();
                            String nombre = listado.getNombre();
                            String usuario = listado.getUsuario();

                            if(usuario.equals("aaron")) {
                                Log.e("usuario", ""+usuario);
                                Log.e("correo", ""+correo);
                                Log.e("nombre", ""+nombre);
                                Log.e("boolean", ""+admin);
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        */

        presenter = new LoginPresenterImpl(this);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth = FirebaseAuth.getInstance();
                presenter.singIn(username.getText().toString(), password.getText().toString(), mAuth, reference);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.register();
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.reset();
            }
        });
    }

    @Override
    public void enableInputs() {
        username.setEnabled(true);
        password.setEnabled(true);
    }

    @Override
    public void disableInputs() {
        username.setEnabled(false);
        password.setEnabled(false);
    }

    @Override
    public void showProgressBar() {
        progressBarLogin.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBarLogin.setVisibility(View.GONE);
    }

    @Override
    public void loginError(String error) {
        Toast.makeText(this,getString(R.string.login_error)+error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void Registrarse() {
        Intent i = new Intent(this, RegisterActivity.class);
        startActivity(i);
    }

    @Override
    public void goHome() {
        Intent i = new Intent(this, ContainerActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public void goReset() {
        Intent i = new Intent(this, ResetPasswordActivity.class);
        startActivity(i);
    }

    @Override
    public void goAdmin() {
        Intent i = new Intent(this, AddInfoActivity.class);
        startActivity(i);
        finish();
    }
}