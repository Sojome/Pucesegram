package com.pucese.pucesegram.fragment.home.interactor;

import com.google.firebase.database.DatabaseReference;
import com.pucese.pucesegram.model.Picture;

import java.util.ArrayList;

public interface HomeInteractor {
    ArrayList<Picture> buidPictures(DatabaseReference reference);
}
