package com.pucese.pucesegram.register.interactors;

public interface RegisterInteractor {
    void registerUsuario(
            String nombre,
            String correo,
            String usuario,
            String contrasena,
            String Confircontrasena);
}
