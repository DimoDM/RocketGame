package com.example.rocketgame.core.contract;

public interface MultiplayerHostFragmentContract {
    interface ViewListener{
        void goToMainMenu();
        void setReady();
    }

    interface PresentListener{
        void setViewListener(MultiplayerHostFragmentContract.ViewListener viewListener);
        void onReadyUnradyButtonClicked();
        void onHomeButtonClicked();
    }
}
