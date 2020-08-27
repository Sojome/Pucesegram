package com.pucese.pucesegram.addinfo.view;

public interface AddInfoView {
    void showProgressBar();
    void hideProgressBar();
    void logout();
    void agregarError(String error);
    void limpiar();
}
