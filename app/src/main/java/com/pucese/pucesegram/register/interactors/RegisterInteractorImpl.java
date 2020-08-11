package com.pucese.pucesegram.register.interactors;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.pucese.pucesegram.register.presenter.RegisterPresenter;
import com.pucese.pucesegram.register.repository.RegisterRepository;
import com.pucese.pucesegram.register.repository.RegisterRepositoryImpl;

public class RegisterInteractorImpl implements RegisterInteractor {

    private RegisterPresenter presenter;
    private RegisterRepository repository;

    public RegisterInteractorImpl(RegisterPresenter registerPresenter) {
        this.presenter = registerPresenter;
        repository = new RegisterRepositoryImpl(presenter);
    }

    @Override
    public void registerUsuario(String nombre, String correo, String usuario, String contrasena, String Confircontrasena, FirebaseAuth btnAuth, DatabaseReference mDatabase, FirebaseFirestore myDB) {
        repository.registerUsuario(nombre, correo, usuario, contrasena, Confircontrasena, btnAuth, mDatabase, myDB);
    }
}
