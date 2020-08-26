package com.pucese.pucesegram.fragment.home.interactor;

import com.pucese.pucesegram.model.AddData;
import com.pucese.pucesegram.model.Picture;
import com.pucese.pucesegram.fragment.home.presenter.HomePresenter;

import java.util.ArrayList;

public class HomeInteractorImpl implements HomeInteractor {

    private HomePresenter presenter;

    public HomeInteractorImpl(HomePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public ArrayList<Picture> buidPictures() {
        AddData data = new AddData();
        return data.buidPictures();
    }
}
