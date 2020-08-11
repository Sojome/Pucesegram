package com.pucese.pucesegram.login.view;

public interface LoginView {
    void enableInputs();
    void disableInputs();

    void showProgressBar();
    void hideProgressBar();

    void loginError(String error);

    void Registrarse();
    void goHome();
}
