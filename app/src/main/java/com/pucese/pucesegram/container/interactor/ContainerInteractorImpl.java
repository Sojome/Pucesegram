package com.pucese.pucesegram.container.interactor;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.firebase.auth.FirebaseAuth;
import com.pucese.pucesegram.R;
import com.pucese.pucesegram.container.presenter.ContainerPresenter;

public class ContainerInteractorImpl implements ContainerInteractor {
    private ContainerPresenter presenter;

    public ContainerInteractorImpl(ContainerPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void logout() {
        FirebaseAuth.getInstance().signOut();
        presenter.logoutsuccess();
    }

    @Override
    public void showSelectedFragment(Fragment fragment, FragmentManager fm) {
        fm.beginTransaction().replace(R.id.container, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }
}
