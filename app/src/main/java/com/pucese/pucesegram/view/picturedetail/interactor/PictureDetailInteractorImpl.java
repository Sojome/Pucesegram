package com.pucese.pucesegram.view.picturedetail.interactor;

import android.content.Intent;

import com.pucese.pucesegram.view.picturedetail.presenter.PictureDetailPresenter;

public class PictureDetailInteractorImpl implements PictureDetailInteractor {

    private PictureDetailPresenter presenter;

    public PictureDetailInteractorImpl(PictureDetailPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setInformation(Intent i) {
        //imagen
        String url=i.getStringExtra("picture");
        //nombre
        String name = i.getStringExtra("name");
        //Like
        String like = i.getStringExtra("like");
        //Titulo
        String title = i.getStringExtra("titulo");
        //Descripción
        String comentarios = i.getStringExtra("description");

        presenter.getResult(url, name, like, title, comentarios);
    }
}
