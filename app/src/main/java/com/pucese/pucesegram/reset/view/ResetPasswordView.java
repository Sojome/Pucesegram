package com.pucese.pucesegram.reset.view;

public interface ResetPasswordView {
    void resetError(String error);

    void resetHecho();

    void login();

    void showProgressBar();
    void hideProgressBar();
}
