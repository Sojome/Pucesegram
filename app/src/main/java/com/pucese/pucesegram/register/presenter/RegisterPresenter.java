package com.pucese.pucesegram.register.presenter;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.FirebaseFirestore;

public interface RegisterPresenter {
    void registerUsuario(
            String nombre,
            String correo,
            String usuario,
            String contrasena,
            String Confircontrasena,
            FirebaseAuth btnAuth,
            DatabaseReference mDatabase,
            FirebaseFirestore myDB
    ); //Interactor

    void registerSucces();

    void registerError(String error);
}
