package com.pucese.pucesegram.login.repository;

import com.pucese.pucesegram.login.presenter.LoginPresenter;

public class LoginRepositoryImpl implements LoginRepository {

    private LoginPresenter presenter;

    public LoginRepositoryImpl(LoginPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void singIn(String username, String password) {
        if(!username.isEmpty() && !password.isEmpty()) {
            presenter.loginSucces();
        }
        else {
            presenter.loginError("Complete todos los campos");
        }
    }
}
