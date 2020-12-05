package com.example.rocketgame.core.present;

import com.example.rocketgame.core.contract.DeathFragmentContract;

public class DeathFragmentPresenter implements DeathFragmentContract.PresentListener {

    private DeathFragmentContract.ViewListener viewListener;


    @Override
    public void setViewListener(DeathFragmentContract.ViewListener viewListener) {
        this.viewListener = viewListener;
    }


    @Override
    public void onRestartBtnClicked() {
        viewListener.RestartGame();
    }

    @Override
    public void onMenuBtnClicked() {
        viewListener.goToMainMenu();
    }
}
