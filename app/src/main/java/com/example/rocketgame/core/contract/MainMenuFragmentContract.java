package com.example.rocketgame.core.contract;

public interface MainMenuFragmentContract {

    interface ViewListener{
        void goToGameScreen();
        void goToClassationFragment();
        void goToShopFragment();
    }

    interface PresentListener {

        void setViewListener(ViewListener viewListener);
        void onPlayBtnClicked();
        void onClassationBtnClicked();
        void onShopBtnClicked();
    }
}
