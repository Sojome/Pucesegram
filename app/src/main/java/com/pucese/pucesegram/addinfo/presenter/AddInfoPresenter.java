package com.pucese.pucesegram.addinfo.presenter;

import com.google.firebase.database.DatabaseReference;

public interface AddInfoPresenter {
    void agregarLugares(
            String lugar,
            int tiempo,
            int likes,
            String titulo,
            String descripcion,
            DatabaseReference reference
    );
    void agregarSuccess();
    void agregarError(String error);
    void logoutsuccess();
}
