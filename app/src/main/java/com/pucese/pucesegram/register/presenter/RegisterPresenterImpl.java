package com.pucese.pucesegram.register.presenter;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.pucese.pucesegram.register.interactor.RegisterInteractor;
import com.pucese.pucesegram.register.interactor.RegisterInteractorImpl;
import com.pucese.pucesegram.register.view.RegisterView;

public class RegisterPresenterImpl implements RegisterPresenter {

    private RegisterView view;
    private RegisterInteractor interactor;

    public RegisterPresenterImpl(RegisterView view) {
        this.view = view;
        interactor = new RegisterInteractorImpl(this);
    }

    @Override
    public void registerUsuario(String nombre, String correo, String usuario, String contrasena, String Confircontrasena, FirebaseAuth btnAuth, DatabaseReference mDatabase, FirebaseFirestore myDB) {
        view.showProgressBar();
        interactor.registerUsuario(nombre, correo, usuario, contrasena, Confircontrasena, btnAuth, mDatabase, myDB);
    }

    @Override
    public void registerSucces() {
        view.login();
        view.hideProgressBar();
        view.registerHecho();
    }

    @Override
    public void registerError(String error) {
        view.hideProgressBar();
        view.registerError(error);
    }
}
