package com.pucese.pucesegram.login.repository;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public interface LoginRepository {
    void singIn(String username, String password, FirebaseAuth btnAuth, DatabaseReference reference);
}
