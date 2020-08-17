package com.pucese.pucesegram.reset.interactor;

import com.google.firebase.auth.FirebaseAuth;
import com.pucese.pucesegram.reset.presenter.ResetPresenter;
import com.pucese.pucesegram.reset.repository.ResetPasswordRepository;
import com.pucese.pucesegram.reset.repository.ResetPasswordRepositoryImpl;

public class ResetPasswordInteractorImpl implements ResetPasswordInteractor {
    private ResetPresenter presenter;
    private ResetPasswordRepository repository;

    public ResetPasswordInteractorImpl(ResetPresenter resetPresenter) {
        this.presenter = resetPresenter;
        repository = new ResetPasswordRepositoryImpl(presenter);
    }

    @Override
    public void resetPassword(String email, FirebaseAuth mAuth) {
        repository.resetPassword(email, mAuth);
    }
}
