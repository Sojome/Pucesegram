package com.pucese.pucesegram.fragment.search.presenter;

import com.pucese.pucesegram.adapter.PictureAdapterRecyclerView;
import com.pucese.pucesegram.model.Picture;
import com.pucese.pucesegram.fragment.search.interactor.SearchInteractor;
import com.pucese.pucesegram.fragment.search.interactor.SearchInteractorImpl;
import com.pucese.pucesegram.fragment.search.view.SearchView;

import java.util.ArrayList;

public class SearchPresenterImpl implements SearchPresenter {
    private SearchView view;
    private SearchInteractor interactor;

    public SearchPresenterImpl(SearchView view) {
        this.view = view;
        interactor = new SearchInteractorImpl(this);
    }

    @Override
    public void filtrar(String texto, PictureAdapterRecyclerView pictureAdapterRecyclerView, ArrayList<Picture> pictures) {
        interactor.filtrar(texto, pictureAdapterRecyclerView, pictures);
    }

    @Override
    public ArrayList<Picture> buidPictures() {
        return interactor.buidPictures();
    }
}
