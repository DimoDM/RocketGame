package com.example.rocketgame.core.present;

import com.example.rocketgame.core.contract.GameFragmentContract;
import com.example.rocketgame.core.contract.MultiplayerContract;

public class MultiplayerPresenter implements MultiplayerContract.PresenterListener {

    private MultiplayerContract.ViewListener listener;

    @Override
    public void setViewListener(MultiplayerContract.ViewListener viewListener) {
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
