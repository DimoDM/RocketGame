package com.example.rocketgame.core.contract;

public interface ClassationFragmentContract {

    interface ViewListener{
        void goToMainMenu();
    }

    interface PresentListener {

        void setViewListener(ClassationFragmentContract.ViewListener viewListener);
        void onHomeBtnClicked();
    }
}
