package com.pucese.pucesegram.fragment.home.interactor;

import com.google.firebase.database.DatabaseReference;
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
    public ArrayList<Picture> buidPictures(DatabaseReference reference) {
        AddData data = new AddData(reference);
        return data.buidPictures();
    }
}
