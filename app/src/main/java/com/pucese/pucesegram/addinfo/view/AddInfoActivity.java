package com.pucese.pucesegram.addinfo.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.pucese.pucesegram.R;
import com.pucese.pucesegram.addinfo.presenter.AddInfoPresenter;
import com.pucese.pucesegram.addinfo.presenter.AddInfoPresenterImpl;
import com.pucese.pucesegram.login.view.LoginActivity;

public class AddInfoActivity extends AppCompatActivity implements AddInfoView {

    private ProgressBar progressBarAgregar;
    private DatabaseReference reference;
    private AddInfoPresenter presenter;

    private Button mButtonAgregar, salir;

    private TextInputEditText lugar, tiempo, likes, titulo, descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_info);
        reference = FirebaseDatabase.getInstance().getReference();

        lugar = findViewById(R.id.plugar);
        tiempo = findViewById(R.id.ptime);
        likes = findViewById(R.id.plike_number);
        titulo = findViewById(R.id.ptitle);
        descripcion = findViewById(R.id.pdescription);
        salir = findViewById(R.id.boton_cerrar);
        progressBarAgregar = findViewById((R.id.progressbarAgregar));
        mButtonAgregar = findViewById(R.id.Agregar);
        hideProgressBar();

        presenter = new AddInfoPresenterImpl(this);

        mButtonAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.agregarLugares(
                        lugar.getText().toString(),
                        Integer.parseInt(tiempo.getText().toString()),
                        Integer.parseInt(likes.getText().toString()),
                        titulo.getText().toString(),
                        descripcion.getText().toString(),
                        reference
                );
            }
        });
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.logoutsuccess();
            }
        });
    }

    @Override
    public void showProgressBar() {
        progressBarAgregar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBarAgregar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void logout() {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public void agregarError(String error) {
        Toast.makeText(this,getString(R.string.login_error)+error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void limpiar() {
        lugar.setText("");
        tiempo.setText("");
        tiempo.setText("");
        likes.setText("");
        titulo.setText("");
        descripcion.setText("");
    }
}