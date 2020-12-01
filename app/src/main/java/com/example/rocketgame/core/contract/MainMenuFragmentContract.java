package com.example.rocketgame.core.contract;

public interface MainMenuFragmentContract {

    interface ViewListener{
        void goToGameScreen();
    }

    interface PresentListener {

        void setViewListener(ViewListener viewListener);
        void onPlayBtnClicked();
    }
}
