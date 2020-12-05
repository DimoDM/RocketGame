package com.example.rocketgame.core.contract;

import com.example.rocketgame.ui.fragments.JoinMultiplayerFragment;

public class JoinMultiplayerFragmentContract {

    public interface ViewListener{
        void joinMultiplayerWithQRCode();
        void joinMultiplayerWithManualCode();
        void goToMainScreen();

    }

    public interface PresentListener{
        void setViewListener(JoinMultiplayerFragmentContract.ViewListener viewListener);
        void onHomeButtonClicked();
        void onEnterCodeButtonClicked();
        void onScanQRCodeClicked();
    }
}
