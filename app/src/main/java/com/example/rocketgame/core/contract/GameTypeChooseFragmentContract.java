package com.example.rocketgame.core.contract;

public interface GameTypeChooseFragmentContract {

    interface ViewListener{
        void goToSinglePlayerFragment();
        void goToMultiplayerPlayerFragment();
    }

    interface PresentListener {

        void setViewListener(GameTypeChooseFragmentContract.ViewListener viewListener);
        void onSinglePlayerBtnClicked();
        void onMultiplayerPlayerBtnClicked();
    }
}
