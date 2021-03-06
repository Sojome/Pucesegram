package com.pucese.pucesegram.login.presenter;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.pucese.pucesegram.login.interactor.LoginInteractor;
import com.pucese.pucesegram.login.interactor.LoginInteractorImpl;
import com.pucese.pucesegram.login.view.LoginView;

public class LoginPresenterImpl implements LoginPresenter {

    private LoginView view;
    private LoginInteractor interactor;

    public LoginPresenterImpl(LoginView view) {
        this.view = view;
        interactor = new LoginInteractorImpl(this);
    }

    @Override
    public void singIn(String username, String password, FirebaseAuth btnAuth, DatabaseReference reference) {
        view.disableInputs();
        view.showProgressBar();
        interactor.singIn(username, password, btnAuth, reference);
    }

    @Override
    public void loginSucces() {
        view.goHome();
        view.hideProgressBar();
    }

    @Override
    public void loginError(String error) {
        view.enableInputs();
        view.hideProgressBar();
        view.loginError(error);
    }

    @Override
    public void register() {
        view.Registrarse();
        view.hideProgressBar();
    }

    @Override
    public void reset() {
        view.goReset();
        view.hideProgressBar();
    }

    @Override
    public void adminSucces() {
        view.goAdmin();
        view.hideProgressBar();
    }
}
