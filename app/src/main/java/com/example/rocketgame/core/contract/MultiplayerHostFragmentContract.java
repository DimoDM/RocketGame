package com.example.rocketgame.core.contract;

public interface MultiplayerHostFragmentContract {
    interface ViewListener{

    }

    interface PresentListener{
        void setViewListener(MultiplayerHostFragmentContract.ViewListener viewListener);

    }
}
