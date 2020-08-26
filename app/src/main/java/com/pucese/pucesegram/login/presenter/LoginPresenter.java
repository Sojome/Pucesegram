package com.pucese.pucesegram.login.presenter;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public interface LoginPresenter {
    void singIn(String username, String password, FirebaseAuth btnAuth, DatabaseReference reference); //Interactor
    void loginSucces();
    void loginError(String error);
    void register();
    void reset();
    void adminSucces();
}