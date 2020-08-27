package com.pucese.pucesegram.fragment.profile.interactor;

import com.google.firebase.database.DatabaseReference;
import com.pucese.pucesegram.model.Picture;

import java.util.ArrayList;

public interface ProfileInteractor {
    ArrayList<Picture> buidPictures(DatabaseReference reference);
}
