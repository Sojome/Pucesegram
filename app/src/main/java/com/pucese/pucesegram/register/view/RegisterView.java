package com.pucese.pucesegram.register.view;

public interface RegisterView {
    void showProgressBar();
    void hideProgressBar();

    void registerError(String error);

    void registerHecho();

    void login();
}
