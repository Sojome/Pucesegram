package com.pucese.pucesegram.login.interactor;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public interface LoginInteractor {
    void singIn(String username, String password, FirebaseAuth btnAuth, DatabaseReference reference);
}
