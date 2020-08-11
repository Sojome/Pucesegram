package com.pucese.pucesegram.register.presenter;

public interface RegisterPresenter {
    void registerUsuario(
            String nombre,
            String correo,
            String usuario,
            String contrasena,
            String Confircontrasena); //Interactor

    void registerSucces();

    void registerError(String error);
}
