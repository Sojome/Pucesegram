package com.pucese.pucesegram.reset.repository;

import com.google.firebase.auth.FirebaseAuth;

public interface ResetPasswordRepository {

    void resetPassword(String email, FirebaseAuth mAuth);

}
