package com.pucese.pucesegram.login.presenter;

import com.pucese.pucesegram.login.interactors.LoginInteractor;
import com.pucese.pucesegram.login.interactors.LoginInteractorImpl;
import com.pucese.pucesegram.login.view.LoginView;

public class LoginPresenterImpl implements LoginPresenter {

    private LoginView loginView;
    private LoginInteractor interactor;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        interactor = new LoginInteractorImpl(this);
    }

    @Override
    public void singIn(String username, String password) {
        loginView.disableInputs();
        loginView.showProgressBar();
        interactor.singIn(username,password);
    }

    @Override
    public void loginSucces() {
        loginView.goHome();
        loginView.hideProgressBar();
    }

    @Override
    public void loginError(String error) {
        loginView.enableInputs();
        loginView.hideProgressBar();
        loginView.loginError(error);
    }

    @Override
    public void register() {
        loginView.Registrarse();
        loginView.hideProgressBar();
    }
}
