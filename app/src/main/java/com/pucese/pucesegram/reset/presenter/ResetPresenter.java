package com.pucese.pucesegram.reset.presenter;

import com.google.firebase.auth.FirebaseAuth;

public interface ResetPresenter {
    void resetPassword(String email, FirebaseAuth mAuth);
    void resetPasswordSucces();
    void resetPasswordError(String error);
}
