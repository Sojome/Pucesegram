package com.pucese.pucesegram.reset.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.pucese.pucesegram.R;
import com.pucese.pucesegram.login.view.LoginActivity;
import com.pucese.pucesegram.reset.presenter.ResetPresenter;
import com.pucese.pucesegram.reset.presenter.ResetPresenterImpl;

public class ResetPasswordActivity extends AppCompatActivity implements ResetPasswordView {

    private TextInputEditText mEditTextEmail;
    private Button mButtonResertPassword;
    private ProgressBar progressBarReset;
    private FirebaseAuth mAuth;
    private ResetPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        showToolbar(getResources().getString(R.string.Reset_Password), true);

        mAuth = FirebaseAuth.getInstance();
        mEditTextEmail = findViewById(R.id.editTextEmail);
        mButtonResertPassword = findViewById(R.id.resetPassword);
        progressBarReset= findViewById((R.id.progressbarReset));
        hideProgressBar();
        presenter = new ResetPresenterImpl(this);
        mButtonResertPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEditTextEmail.getText().toString();
                presenter.resetPassword(email, mAuth);
            }
        });
    }

    public void showToolbar(String tittle, boolean upButton)
    {
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

    @Override
    public void resetError(String error) {
        Toast.makeText(this,getString(R.string.login_error)+error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void resetHecho() {
        Toast.makeText(this,getString(R.string.reset_finish), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void login() {
        Intent i = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(i);
    }

    @Override
    public void showProgressBar() {
        progressBarReset.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBarReset.setVisibility(View.GONE);
    }
}
