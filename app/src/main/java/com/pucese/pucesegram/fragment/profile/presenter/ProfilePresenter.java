package com.pucese.pucesegram.fragment.profile.presenter;

import com.google.firebase.database.DatabaseReference;
import com.pucese.pucesegram.model.Picture;

import java.util.ArrayList;

public interface ProfilePresenter {
    ArrayList<Picture> buidPictures(DatabaseReference reference);
}
