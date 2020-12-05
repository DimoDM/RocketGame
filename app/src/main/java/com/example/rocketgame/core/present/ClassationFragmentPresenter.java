package com.example.rocketgame.core.present;

import com.example.rocketgame.core.contract.ClassationFragmentContract;
import com.example.rocketgame.core.contract.PauseMenuFragmentContract;

public class ClassationFragmentPresenter implements ClassationFragmentContract.PresentListener{

    private ClassationFragmentContract.ViewListener viewListener;

    @Override
    public void setViewListener(ClassationFragmentContract.ViewListener viewListener) {
        this.viewListener = viewListener;
    }

    @Override
    public void onHomeBtnClicked() {
        viewListener.goToMainMenu();
    }
}
