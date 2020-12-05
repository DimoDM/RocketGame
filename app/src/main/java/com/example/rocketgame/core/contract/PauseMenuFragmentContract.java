package com.example.rocketgame.core.contract;

public interface PauseMenuFragmentContract {

    interface ViewListener{
        void goToMainMenu();
        void goToGameFragment();
        void RestartGame();
    }

    interface PresentListener {
        void setViewListener(PauseMenuFragmentContract.ViewListener viewListener);

        void onContinueBtnClicked();
        void onRestartBtnClicked();
        void onMenuBtnClicked();
    }
}
