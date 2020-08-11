package com.pucese.pucesegram.login.interactors;

import com.google.firebase.auth.FirebaseAuth;

public interface LoginInteractor {
    void singIn(String username, String password, FirebaseAuth btnAuth);
}
