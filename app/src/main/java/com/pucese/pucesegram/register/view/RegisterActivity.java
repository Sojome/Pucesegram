package com.pucese.pucesegram.register.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.pucese.pucesegram.R;
import com.pucese.pucesegram.register.presenter.RegisterPresenter;
import com.pucese.pucesegram.register.presenter.RegisterPresenterImpl;

public class RegisterActivity extends AppCompatActivity implements RegisterView {

    //Variables para los componentes
    private TextInputEditText correo, contrasena, nombre, usuario, Confircontrasena;
    private Button mButtonRegister;
    private ProgressBar progressBarRegister;
    private RegisterPresenter presenter;

    //----- Variables para firebase
    private DatabaseReference mDatabase;
    private FirebaseFirestore myDB ;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        showToolbar(getResources().getString(R.string.toolbar_createaccount),true);

        //Conexion a firebase
        mAuth = FirebaseAuth.getInstance();
        try {
            mDatabase = FirebaseDatabase.getInstance().getReference();
            myDB = FirebaseFirestore.getInstance();
        }
        catch ( Exception ex)
        {
            Toast.makeText(getApplicationContext(),"Inicializado: " + ex.getMessage(),Toast.LENGTH_LONG).show();
        }

        //Ingresando
        correo= findViewById(R.id.correo);
        contrasena = findViewById(R.id.contrasena);
        usuario= findViewById(R.id.user);
        nombre = findViewById(R.id.name);
        Confircontrasena = findViewById(R.id.contrasenaConfirm);
        mButtonRegister = findViewById(R.id.Registrarse);
        progressBarRegister= findViewById((R.id.progressbarRegister));
        hideProgressBar();

        presenter = new RegisterPresenterImpl(this);
        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.registerUsuario(
                        nombre.getText().toString(),
                        correo.getText().toString(),
                        usuario.getText().toString(),
                        contrasena.getText().toString(),
                        Confircontrasena.getText().toString()
                );
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
    public void showProgressBar() {
        progressBarRegister.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBarRegister.setVisibility(View.INVISIBLE);
    }

    @Override
    public void registerError(String error) {
        Toast.makeText(this,getString(R.string.login_error)+error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void registerHecho() {
        Toast.makeText(this,getString(R.string.user_created), Toast.LENGTH_SHORT).show();
    }
}