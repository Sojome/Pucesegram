package com.pucese.pucesegram.view.container.presenter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.pucese.pucesegram.view.container.interactor.ContainerInteractor;
import com.pucese.pucesegram.view.container.interactor.ContainerInteractorImpl;
import com.pucese.pucesegram.view.container.view.ContainerView;

public class ContainerPresenterImpl implements ContainerPresenter {
    private ContainerView view;
    private ContainerInteractor interactor;

    public ContainerPresenterImpl(ContainerView view) {
        this.view = view;
        interactor = new ContainerInteractorImpl(this);
    }

    @Override
    public void logout() {
        interactor.logout();
    }

    @Override
    public void logoutsuccess() {
        view.logout();
    }

    @Override
    public void showSelectedFragment(Fragment fragment, FragmentManager fm) {
        interactor.showSelectedFragment(fragment, fm);
    }
}
