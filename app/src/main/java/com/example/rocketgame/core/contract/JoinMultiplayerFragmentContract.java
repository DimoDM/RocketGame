package com.example.rocketgame.core.contract;

import com.example.rocketgame.ui.fragments.JoinMultiplayerFragment;

public interface JoinMultiplayerFragmentContract {

    interface ViewListener{
        void joinMultiplayerWithQRCode();
        void joinMultiplayerWithManualCode();
        void goToMainScreen();

    }

    interface PresentListener{
        void setViewListener(JoinMultiplayerFragmentContract.ViewListener viewListener);
        void onHomeButtonClicked();
        void onEnterCodeButtonClicked();
        void onScanQRCodeClicked();
    }
}
