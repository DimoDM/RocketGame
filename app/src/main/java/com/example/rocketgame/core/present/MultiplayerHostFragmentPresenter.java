package com.example.rocketgame.core.present;

import com.example.rocketgame.core.contract.JoinMultiplayerFragmentContract;
import com.example.rocketgame.core.contract.MultiplayerFragmentContract;
import com.example.rocketgame.core.contract.MultiplayerHostFragmentContract;

public class MultiplayerHostFragmentPresenter implements MultiplayerHostFragmentContract.PresentListener {

    MultiplayerHostFragmentContract.ViewListener listener;


    @Override
    public void setViewListener(MultiplayerHostFragmentContract.ViewListener viewListener) {
        listener = viewListener;
    }

    @Override
    public void onReadyUnradyButtonClicked() {
        listener.setReady();
    }

    @Override
    public void onHomeButtonClicked() {
        listener.goToMainMenu();
    }
}
