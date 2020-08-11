package com.pucese.pucesegram.register.presenter;

import com.pucese.pucesegram.register.interactors.RegisterInteractor;
import com.pucese.pucesegram.register.interactors.RegisterInteractorImpl;
import com.pucese.pucesegram.register.view.RegisterView;

public class RegisterPresenterImpl implements RegisterPresenter {

    private RegisterView view;
    private RegisterInteractor interactor;

    public RegisterPresenterImpl(RegisterView view) {
        this.view = view;
        interactor = new RegisterInteractorImpl(this);
    }

    @Override
    public void registerUsuario(String nombre, String correo, String usuario, String contrasena, String Confircontrasena) {
        view.showProgressBar();
        interactor.registerUsuario(nombre, correo, usuario, contrasena, Confircontrasena);
    }

    @Override
    public void registerSucces() {
        view.hideProgressBar();
        view.registerHecho();
    }

    @Override
    public void registerError(String error) {
        view.hideProgressBar();
        view.registerError(error);
    }
}
