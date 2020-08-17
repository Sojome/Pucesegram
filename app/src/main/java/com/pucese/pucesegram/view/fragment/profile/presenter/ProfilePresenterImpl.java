package com.pucese.pucesegram.view.fragment.profile.presenter;

import com.pucese.pucesegram.model.Picture;
import com.pucese.pucesegram.view.fragment.profile.interactor.ProfileInteractor;
import com.pucese.pucesegram.view.fragment.profile.interactor.ProfileInteractorImpl;
import com.pucese.pucesegram.view.fragment.profile.view.ProfileView;

import java.util.ArrayList;

public class ProfilePresenterImpl implements ProfilePresenter{

    private ProfileView view;
    private ProfileInteractor interactor;

    public ProfilePresenterImpl(ProfileView view) {
        this.view = view;
        interactor = new ProfileInteractorImpl(this);
    }

    @Override
    public ArrayList<Picture> buidPictures(ArrayList<Picture> pictures) {
        return interactor.buidPictures(pictures);
    }
}
