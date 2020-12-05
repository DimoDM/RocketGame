package com.example.rocketgame.core.contract;

public interface DeathFragmentContract {

    interface ViewListener{
        void goToMainMenu();
        void RestartGame();
    }

    interface PresentListener {
        void setViewListener(DeathFragmentContract.ViewListener viewListener);

        void onRestartBtnClicked();
        void onMenuBtnClicked();
    }
}
