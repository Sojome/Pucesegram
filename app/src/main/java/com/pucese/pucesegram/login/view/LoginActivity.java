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
import com.pucese.pucesegram.*;
import com.pucese.pucesegram.login.presenter.LoginPresenter;
import com.pucese.pucesegram.login.presenter.LoginPresenterImpl;
import com.pucese.pucesegram.register.view.RegisterActivity;
import com.pucese.pucesegram.view.container.view.ContainerActivity;

public class LoginActivity extends AppCompatActivity implements LoginView {

    //Variables globales
    private TextInputEditText username, password;
    private Button login;
    private TextView register;
    private ProgressBar progressBarLogin;
    private LoginPresenter presenter;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username= findViewById(R.id.username);
        password= findViewById(R.id.password);
        login= findViewById(R.id.login);
        register= findViewById(R.id.createHere);
        progressBarLogin= findViewById((R.id.progressbarLogin));
        hideProgressBar();

        presenter = new LoginPresenterImpl(this);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth = FirebaseAuth.getInstance();
                presenter.singIn(username.getText().toString(), password.getText().toString(), mAuth);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.register();
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
}