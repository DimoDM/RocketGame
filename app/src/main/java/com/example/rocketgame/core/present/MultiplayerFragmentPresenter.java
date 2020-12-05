package com.example.rocketgame.core.present;

import com.example.rocketgame.core.contract.MultiplayerFragmentContract;

public class MultiplayerFragmentPresenter implements MultiplayerFragmentContract.PresenterListener {

    private MultiplayerFragmentContract.ViewListener listener;

    @Override
    public void setViewListener(MultiplayerFragmentContract.ViewListener viewListener) {
        listener = viewListener;
    }

    @Override
    public void onHomeButtonClicked() {
        listener.goToMainScreen();
    }

    @Override
    public void onCreateRoomButtonClicked() {
        listener.createGameAndJoin();
    }

    @Override
    public void onJoinGameButtonClicked() {
        listener.goToEnterGameScreen();
    }
}
