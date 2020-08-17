package com.pucese.pucesegram.reset.interactor;

import com.google.firebase.auth.FirebaseAuth;

public interface ResetPasswordInteractor {
    void resetPassword(String email, FirebaseAuth mAuth);
}
