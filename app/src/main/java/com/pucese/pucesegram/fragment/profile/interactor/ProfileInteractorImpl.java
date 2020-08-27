package com.pucese.pucesegram.fragment.profile.interactor;

import com.pucese.pucesegram.model.AddData;
import com.pucese.pucesegram.model.Picture;
import com.pucese.pucesegram.fragment.profile.presenter.ProfilePresenter;

import java.util.ArrayList;

public class ProfileInteractorImpl implements ProfileInteractor {

    private ProfilePresenter presenter;

    public ProfileInteractorImpl(ProfilePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public ArrayList<Picture> buidPictures() {
        //AddData data = new AddData();
        //return data.buidPictures();
        return null;
    }
}
