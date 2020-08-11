package com.pucese.pucesegram.login.presenter;

public interface LoginPresenter {
    void singIn(String username, String password); //Interactor
    void loginSucces();
    void loginError(String error);
    void register();
}