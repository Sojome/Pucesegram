package com.pucese.pucesegram.register.repository;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.FirebaseFirestore;

public interface RegisterRepository {

    void registerUsuario(
            String nombre,
            String correo,
            String usuario,
            String contrasena,
            String Confircontrasena,
            FirebaseAuth btnAuth,
            DatabaseReference mDatabase,
            FirebaseFirestore myDB
    );

}
