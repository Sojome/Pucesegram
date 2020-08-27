package com.pucese.pucesegram.addinfo.interactor;

import com.google.firebase.database.DatabaseReference;
import com.pucese.pucesegram.addinfo.presenter.AddInfoPresenter;
import com.pucese.pucesegram.addinfo.repository.AddInfoRepository;
import com.pucese.pucesegram.addinfo.repository.AddInfoRepositoryImpl;

public class AddInfoInteractorImpl implements AddInfoInteractor {

    private AddInfoPresenter presenter;
    private AddInfoRepository repository;

    public AddInfoInteractorImpl(AddInfoPresenter presenter) {
        this.presenter = presenter;
        repository = new AddInfoRepositoryImpl(presenter);
    }

    @Override
    public void agregarLugares(String lugar, int tiempo, int likes, String titulo, String descripcion, DatabaseReference reference) {
        repository.agregarLugares(lugar, tiempo, likes, titulo, descripcion, reference);
    }
}
