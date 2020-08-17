package com.pucese.pucesegram.view.container.presenter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public interface ContainerPresenter {
    void logout();
    void logoutsuccess();
    void showSelectedFragment(Fragment fragment, FragmentManager fm);
}
