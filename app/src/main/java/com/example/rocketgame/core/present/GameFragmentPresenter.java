package com.example.rocketgame.core.present;

import com.example.rocketgame.core.contract.GameFragmentContract;
import com.example.rocketgame.core.contract.MainMenuFragmentContract;

public class GameFragmentPresenter implements GameFragmentContract.PresentListener {


    private GameFragmentContract.ViewListener viewListener;

    @Override
    public void setViewListener(GameFragmentContract.ViewListener viewListener) {
        this.viewListener = viewListener;
    }

    @Override
    public void onPauseClicked() {
        viewListener.goToPauseScreen();
    }
}
