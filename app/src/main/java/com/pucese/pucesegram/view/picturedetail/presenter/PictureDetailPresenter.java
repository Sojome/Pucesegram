package com.pucese.pucesegram.view.picturedetail.presenter;

import android.content.Intent;

public interface PictureDetailPresenter {
    void setInformation(Intent i);
    void getResult(String url, String name, String like, String title, String comentarios);
}
