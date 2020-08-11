package com.pucese.pucesegram.register.repository;

import android.widget.Toast;

import com.pucese.pucesegram.register.presenter.RegisterPresenter;

public class RegisterRepositoryImpl implements RegisterRepository {

    private RegisterPresenter presenter;

    public RegisterRepositoryImpl(RegisterPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void registerUsuario(String name, String email, String username, String password, String confpassword) {
        if (!name.isEmpty() && !email.isEmpty() && !username.isEmpty() && !password.isEmpty() && !confpassword.isEmpty()){
            if (password.length() >=8){
                if (password.matches("(.*[0-9].*)")){
                    if (password.matches("(.*[A-Z].*)")){
                        if (password.matches("^(?=.*[_.*()*#!/$&@]).*$")){
                            if (password.equals(confpassword)) {
                                //Aqui se realiza los procedimientos
                                presenter.registerSucces();
                            }else{
                                presenter.registerError("Las contraseñas deben ser iguales");
                            }
                        }else{
                            presenter.registerError("La contraseña requiere al menos un caracter especial");
                        }
                    }else{
                        presenter.registerError("La contraseña requiere mayusculas");
                    }
                }else{
                    presenter.registerError("La contraseña requiere al menos un numero");
                }
            }else{
                presenter.registerError("La contraseña debe tener al menos 8 caracteres");
            }
        }else{
            presenter.registerError("Debe completar todos los campos correctamente");
        }
    }
}
