package com.pucese.pucesegram.reset.presenter;

import com.google.firebase.auth.FirebaseAuth;
import com.pucese.pucesegram.reset.interactors.ResetPasswordInteractor;
import com.pucese.pucesegram.reset.interactors.ResetPasswordInteractorImpl;
import com.pucese.pucesegram.reset.view.ResetPasswordView;

public class ResetPresenterImpl implements ResetPresenter {
    private ResetPasswordView view;
    private ResetPasswordInteractor interactor;

    public ResetPresenterImpl(ResetPasswordView view) {
        this.view = view;
        interactor = new ResetPasswordInteractorImpl(this);
    }

    @Override
    public void resetPassword(String email, FirebaseAuth mAuth) {
        view.showProgressBar();
        interactor.resetPassword(email, mAuth);
    }

    @Override
    public void resetPasswordSucces() {
        view.login();
        view.hideProgressBar();
        view.resetHecho();

    }

    @Override
    public void resetPasswordError(String error) {
        view.hideProgressBar();
        view.resetError(error);
    }
}
