package com.pucese.pucesegram.register.repository;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.pucese.pucesegram.register.presenter.RegisterPresenter;

import java.util.HashMap;
import java.util.Map;

public class RegisterRepositoryImpl implements RegisterRepository {

    private RegisterPresenter presenter;

    public RegisterRepositoryImpl(RegisterPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void registerUsuario(String nombre, String correo, String usuario, String contrasena, String Confircontrasena, FirebaseAuth btnAuth, DatabaseReference mDatabase, FirebaseFirestore myDB) {
        if (!nombre.isEmpty() && !correo.isEmpty() && !usuario.isEmpty() && !contrasena.isEmpty() && !Confircontrasena.isEmpty()){
            if (contrasena.length() >=8){
                if (contrasena.matches("(.*[0-9].*)")){
                    if (contrasena.matches("(.*[A-Z].*)")){
                        if (contrasena.matches("^(?=.*[_.*()*#!/$&@]).*$")){
                            if (contrasena.equals(Confircontrasena)) {
                                //Aqui se realiza los procedimientos
                                //presenter.registerSucces();
                                RegisterUsuario(nombre, correo, usuario, contrasena, Confircontrasena, btnAuth, mDatabase, myDB);
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

        //presenter.registerSucces();
    }

    public void RegisterUsuario(final String nombre, final String correo, final String usuario, final String contrasena, final String Confircontrasena, final FirebaseAuth btnAuth, final DatabaseReference mDatabase, final FirebaseFirestore myDB){
        btnAuth.createUserWithEmailAndPassword(correo,contrasena)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        try {
                            if (task.isSuccessful()) {
                                String id= btnAuth.getCurrentUser().getUid();
                                HashMap<String, Object> result = new HashMap<>();
                                result.put("correo", correo);
                                result.put("usuario", usuario);
                                result.put("nombre", nombre);
                                result.put("admin", false);

                                mDatabase.child("Users").child(id).setValue(result).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task2) {
                                        if(task2.isSuccessful())
                                        {
                                            CollectionReference Users = myDB.collection("Users");
                                            Map<String, Object> data1 = new HashMap<>();
                                            data1.put("correo", correo);
                                            data1.put("usuario", usuario);
                                            data1.put("nombre", nombre);
                                            data1.put("admin", false);
                                            Users.document("SF" + btnAuth.getCurrentUser().getUid()).set(data1);

                                            // Sign in success, update UI with the signed-in user's information
                                            FirebaseUser user = btnAuth.getCurrentUser();

                                            presenter.registerSucces();

                                        }
                                        else
                                        {
                                            presenter.registerError(task2.getException().getMessage());
                                        }
                                    }
                                });
                            } else {
                                // If sign in fails, display a message to the user.
                                presenter.registerError("Autenticación fallida");
                                //updateUI(null);
                            }
                        }
                        catch (Exception ex)
                        {
                            presenter.registerError("Error insert:   " + ex.getMessage());
                        }
                    }
                });
    }
}
