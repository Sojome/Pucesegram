package com.pucese.pucesegram.addinfo.repository;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.StorageReference;
import com.pucese.pucesegram.addinfo.presenter.AddInfoPresenter;

import java.util.HashMap;
import java.util.Map;

public class AddInfoRepositoryImpl implements AddInfoRepository {

    private AddInfoPresenter presenter;

    public AddInfoRepositoryImpl(AddInfoPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void agregarLugares(String lugar, int tiempo, int likes, String titulo, String descripcion, DatabaseReference reference, StorageReference storageReference) {
        try {
            if(!lugar.isEmpty() && !titulo.isEmpty() && !descripcion.isEmpty() && tiempo >=0 && likes >=0) {
                Map<String, Object> dPlaces = new HashMap<>();
                dPlaces.put("place", lugar);
                dPlaces.put("time", tiempo);
                dPlaces.put("likes", likes);
                dPlaces.put("title", titulo);
                dPlaces.put("description", descripcion);

                reference.child("Places").push().setValue(dPlaces);
                //storageReference.child("Places");

                presenter.agregarSuccess();
            } else {
                presenter.agregarError("Llene todos los campos");
            }
        } catch (Exception e) {
            presenter.agregarError("Ingrese los campos con el tipo de dato correcto");
        }
    }

}
