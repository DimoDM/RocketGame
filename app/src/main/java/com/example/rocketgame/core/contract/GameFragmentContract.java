package com.example.rocketgame.core.contract;

public interface GameFragmentContract {

    interface ViewListener{
        void goToPauseScreen();
    }

    interface PresentListener {

        void setViewListener(GameFragmentContract.ViewListener viewListener);
        void onPauseClicked();
    }
}
