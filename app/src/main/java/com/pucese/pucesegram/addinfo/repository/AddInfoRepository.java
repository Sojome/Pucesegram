package com.pucese.pucesegram.addinfo.repository;

import com.google.firebase.database.DatabaseReference;

public interface AddInfoRepository {
    void agregarLugares(
            String lugar,
            int tiempo,
            int likes,
            String titulo,
            String descripcion,
            DatabaseReference reference
    );
}
