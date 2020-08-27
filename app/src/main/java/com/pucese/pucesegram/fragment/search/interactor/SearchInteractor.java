package com.pucese.pucesegram.fragment.search.interactor;

import com.google.firebase.database.DatabaseReference;
import com.pucese.pucesegram.adapter.PictureAdapterRecyclerView;
import com.pucese.pucesegram.model.Picture;

import java.util.ArrayList;

public interface SearchInteractor {
    void filtrar(
            String texto,
            PictureAdapterRecyclerView pictureAdapterRecyclerView,
            ArrayList<Picture> pictures
    );

    ArrayList<Picture> buidPictures(DatabaseReference reference);
}
