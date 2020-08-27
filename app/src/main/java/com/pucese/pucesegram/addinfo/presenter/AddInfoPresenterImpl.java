package com.pucese.pucesegram.addinfo.presenter;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.storage.StorageReference;
import com.pucese.pucesegram.addinfo.interactor.AddInfoInteractor;
import com.pucese.pucesegram.addinfo.interactor.AddInfoInteractorImpl;
import com.pucese.pucesegram.addinfo.view.AddInfoView;

public class AddInfoPresenterImpl implements AddInfoPresenter {

    private AddInfoView view;
    private AddInfoInteractor interactor;

    public AddInfoPresenterImpl(AddInfoView view) {
        this.view = view;
        interactor = new AddInfoInteractorImpl(this);
    }

    @Override
    public void agregarLugares(String lugar, int tiempo, int likes, String titulo, String descripcion, DatabaseReference reference, StorageReference storageReference) {
        interactor.agregarLugares(lugar, tiempo, likes, titulo, descripcion, reference, storageReference);
    }

    @Override
    public void agregarSuccess() {
        view.hideProgressBar(); view.limpiar();
    }

    @Override
    public void agregarError(String error) {
        view.hideProgressBar();
        view.agregarError(error);
    }

    @Override
    public void logoutsuccess() {
        view.logout();
    }
}
