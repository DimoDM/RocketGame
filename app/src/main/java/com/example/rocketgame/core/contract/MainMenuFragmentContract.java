package com.example.rocketgame.core.contract;

public interface MainMenuFragmentContract {

    interface ViewListener{

    }

    interface PresentListener {

        void setViewListener(ViewListener viewListener);
    }
}
