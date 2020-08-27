package com.pucese.pucesegram.addinfo.repository;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.storage.StorageReference;

public interface AddInfoRepository {
    void agregarLugares(
            String lugar,
            int tiempo,
            int likes,
            String titulo,
            String descripcion,
            DatabaseReference reference,
            StorageReference storageReference
    );
}
