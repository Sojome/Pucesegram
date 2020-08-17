package com.pucese.pucesegram.view.container.interactor;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public interface ContainerInteractor {
    void logout();
    void showSelectedFragment(Fragment fragment, FragmentManager fm);
}
