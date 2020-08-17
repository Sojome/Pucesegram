package com.pucese.pucesegram.view.fragment.home.presenter;

import com.pucese.pucesegram.model.Picture;
import com.pucese.pucesegram.view.fragment.home.interactor.HomeInteractor;
import com.pucese.pucesegram.view.fragment.home.interactor.HomeInteractorImpl;
import com.pucese.pucesegram.view.fragment.home.view.HomeView;

import java.util.ArrayList;

public class HomePresenterImpl implements HomePresenter {

    private HomeView home;
    private HomeInteractor interactor;

    public HomePresenterImpl(HomeView home) {
        this.home = home;
        interactor = new HomeInteractorImpl(this);
    }

    @Override
    public ArrayList<Picture> buidPictures(ArrayList<Picture> pictures) {
        return interactor.buidPictures(pictures);
    }
}
