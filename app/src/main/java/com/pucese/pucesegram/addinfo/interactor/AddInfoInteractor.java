package com.pucese.pucesegram.addinfo.interactor;

import com.google.firebase.database.DatabaseReference;

public interface AddInfoInteractor {
    void agregarLugares(
            String lugar,
            int tiempo,
            int likes,
            String titulo,
            String descripcion,
            DatabaseReference reference
    );
}
