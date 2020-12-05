package com.example.rocketgame.core.present;

import com.example.rocketgame.core.contract.JoinMultiplayerFragmentContract;

public class JoinMultiplayerFragmentPresenter implements JoinMultiplayerFragmentContract.PresentListener {

    JoinMultiplayerFragmentContract.ViewListener listener;


    @Override
    public void setViewListener(JoinMultiplayerFragmentContract.ViewListener viewListener) {
        listener = viewListener;
    }

    @Override
    public void onHomeButtonClicked() {
        listener.goToMainScreen();
    }

    @Override
    public void onEnterCodeButtonClicked() {
        listener.joinMultiplayerWithManualCode();
    }

    @Override
    public void onScanQRCodeClicked() {
        listener.joinMultiplayerWithQRCode();
    }
}

