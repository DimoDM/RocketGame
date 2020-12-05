package com.example.rocketgame.core.present;

import com.example.rocketgame.core.contract.GameFragmentContract;
import com.example.rocketgame.core.contract.GameTypeChooseFragmentContract;

public class GameTypeChooseFragmentPresenter implements GameTypeChooseFragmentContract.PresentListener {


    private GameTypeChooseFragmentContract.ViewListener viewListener;

    @Override
    public void setViewListener(GameTypeChooseFragmentContract.ViewListener viewListener) {
        this.viewListener = viewListener;
    }

    @Override
    public void onSinglePlayerBtnClicked() {
        viewListener.goToSinglePlayerFragment();
    }

    @Override
    public void onMultiplayerPlayerBtnClicked() {
        viewListener.goToMultiplayerPlayerFragment();
    }

}
