package com.pucese.pucesegram.login.repository;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.pucese.pucesegram.login.presenter.LoginPresenter;
import com.pucese.pucesegram.model.User;

public class LoginRepositoryImpl implements LoginRepository {

    private LoginPresenter presenter;

    public LoginRepositoryImpl(LoginPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void singIn(final String username, final String password, final FirebaseAuth btnAuth, DatabaseReference reference) {
        if(!username.isEmpty() && !password.isEmpty()) {

            reference.child("Users").orderByChild("correo").equalTo(username).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for(DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        User listado = snapshot.getValue(User.class);

                        final Boolean admin = listado.isAdmin();

                        btnAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful())
                                {
                                    if(!admin) {
                                        presenter.loginSucces();
                                    } else {
                                        presenter.adminSucces();
                                    }
                                }else{
                                    presenter.loginError("No es posible iniciar sesión, compruebe sus datos");
                                }
                            }
                        });

                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });


            //presenter.loginSucces();
        }
        else {
            presenter.loginError("Complete todos los campos");
        }

    }
}
