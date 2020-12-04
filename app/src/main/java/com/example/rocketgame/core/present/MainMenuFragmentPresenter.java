package com.example.rocketgame.core.present;

import com.example.rocketgame.core.contract.MainMenuFragmentContract;

public class MainMenuFragmentPresenter implements MainMenuFragmentContract.PresentListener {

    private MainMenuFragmentContract.ViewListener viewListener;

    @Override
    public void setViewListener(MainMenuFragmentContract.ViewListener viewListener) {
        this.viewListener = viewListener;
    }

    @Override
    public void onPlayBtnClicked() {
        viewListener.goToGameScreen();
    }
}
