package com.example.rocketgame.core.present;

import com.example.rocketgame.core.contract.MainMenuFragmentContract;
import com.example.rocketgame.core.contract.PauseMenuFragmentContract;

public class PauseMenuFragmentPresenter implements PauseMenuFragmentContract.PresentListener{

    private PauseMenuFragmentContract.ViewListener viewListener;


    @Override
    public void setViewListener(PauseMenuFragmentContract.ViewListener viewListener) {
        this.viewListener = viewListener;
    }

    @Override
    public void onContinueBtnClicked() {
        viewListener.goToGameFragment();
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
