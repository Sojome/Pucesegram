package com.pucese.pucesegram.register.repository;

public interface RegisterRepository {

    void registerUsuario(String name,
                         String email,
                         String username,
                         String password,
                         String confpassword);

}
