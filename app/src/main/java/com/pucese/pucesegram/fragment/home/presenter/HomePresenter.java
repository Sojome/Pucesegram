package com.pucese.pucesegram.fragment.home.presenter;

import com.google.firebase.database.DatabaseReference;
import com.pucese.pucesegram.model.Picture;

import java.util.ArrayList;

public interface HomePresenter {
    ArrayList<Picture> buidPictures(DatabaseReference reference);
}
