package com.pucese.pucesegram.addinfo.presenter;

import android.net.Uri;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.storage.StorageReference;

public interface AddInfoPresenter {
    void agregarLugares(
            String lugar,
            int tiempo,
            int likes,
            String titulo,
            String descripcion,
            DatabaseReference reference,
            StorageReference storageReference
    );
    void agregarSuccess();
    void agregarError(String error);
    void logoutsuccess();
}
