package com.pucese.pucesegram.addinfo.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.pucese.pucesegram.R;
import com.pucese.pucesegram.addinfo.presenter.AddInfoPresenter;
import com.pucese.pucesegram.addinfo.presenter.AddInfoPresenterImpl;
import com.pucese.pucesegram.login.view.LoginActivity;
import com.squareup.picasso.Picasso;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import id.zelory.compressor.Compressor;

public class AddInfoActivity extends AppCompatActivity implements AddInfoView {

    private ProgressBar progressBarAgregar;
    private DatabaseReference reference;
    private AddInfoPresenter presenter;

    private ImageView foto;

    private Button mButtonAgregar, salir, seleccionar;

    private TextInputEditText lugar, tiempo, likes, titulo, descripcion;

    private StorageReference storageReference;

    private Bitmap thumb_bitmap = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_info);
        reference = FirebaseDatabase.getInstance().getReference();
        storageReference = FirebaseStorage.getInstance().getReference().child("Places");

        lugar = findViewById(R.id.plugar);
        tiempo = findViewById(R.id.ptime);
        likes = findViewById(R.id.plike_number);
        titulo = findViewById(R.id.ptitle);
        descripcion = findViewById(R.id.pdescription);
        salir = findViewById(R.id.boton_cerrar);
        progressBarAgregar = findViewById((R.id.progressbarAgregar));
        mButtonAgregar = findViewById(R.id.Agregar);
        foto = findViewById(R.id.img_foto);
        seleccionar = findViewById(R.id.btn_selefoto);
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
                        reference,
                        storageReference
                );

            }
        });

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.logoutsuccess();
            }
        });

        foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosePicture();
            }
        });
    }

    private void choosePicture() {
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
        likes.setText("");
        titulo.setText("");
        descripcion.setText("");
    }
}