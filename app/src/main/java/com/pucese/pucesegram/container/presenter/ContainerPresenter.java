package com.pucese.pucesegram.container.presenter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public interface ContainerPresenter {
    void logout();
    void logoutsuccess();
    void showSelectedFragment(Fragment fragment, FragmentManager fm);
}
