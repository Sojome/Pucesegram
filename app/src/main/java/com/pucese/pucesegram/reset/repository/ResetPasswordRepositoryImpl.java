package com.pucese.pucesegram.reset.repository;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.pucese.pucesegram.reset.presenter.ResetPresenter;

public class ResetPasswordRepositoryImpl implements ResetPasswordRepository {
    private ResetPresenter presenter;

    public ResetPasswordRepositoryImpl(ResetPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void resetPassword(String email, FirebaseAuth mAuth) {
        if (!email.isEmpty()) {
            mAuth.setLanguageCode("en");;
            mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()){
                        presenter.resetPasswordSucces();
                    }else{
                    presenter.resetPasswordError("No se ha podido restablecer, compruebe sus datos");
                    }
                }
            });
        }else{
            presenter.resetPasswordError("Debe ingresar el correo");
        }
    }
}
