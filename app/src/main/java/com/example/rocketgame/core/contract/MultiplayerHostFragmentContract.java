package com.example.rocketgame.core.contract;

public interface MultiplayerHostFragmentContract {
    interface ViewListener{
        void goToMainMenu();
        void switchView();
        void setReady();
    }

    interface PresentListener{
        void setViewListener(MultiplayerHostFragmentContract.ViewListener viewListener);
        void onReadyUnradyButtonClicked();
        void onSwitchViewButtonClicked();
        void onHomeButtonClicked();
    }
}
