package com.pucese.pucesegram.fragment.search.interactor;

import com.pucese.pucesegram.adapter.PictureAdapterRecyclerView;
import com.pucese.pucesegram.model.AddData;
import com.pucese.pucesegram.model.Picture;
import com.pucese.pucesegram.fragment.search.presenter.SearchPresenter;

import java.util.ArrayList;

public class SearchInteractorImpl implements SearchInteractor{

    private SearchPresenter presenter;

    public SearchInteractorImpl(SearchPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void filtrar(String texto, PictureAdapterRecyclerView pictureAdapterRecyclerView, ArrayList<Picture> pictures) {
        ArrayList<Picture> filtrarLista = new ArrayList<>();

        for(Picture usuario : pictures) {
            if(usuario.getUsername().toLowerCase().contains(texto.toLowerCase())) {
                filtrarLista.add(usuario);
            }
        }

        pictureAdapterRecyclerView.filtrar(filtrarLista);
    }

    @Override
    public ArrayList<Picture> buidPictures() {
        //AddData data = new AddData();
        //return data.buidPictures();
        return null;
    }
}
