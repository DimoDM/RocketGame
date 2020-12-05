package com.example.rocketgame.core.contract;

public interface MultiplayerFragmentContract {

    interface ViewListener{
        void goToMainScreen();
        void goToEnterGameScreen();
        void createGameAndJoin();
    }

    interface PresenterListener{
        void setViewListener(MultiplayerFragmentContract.ViewListener viewListener);
        void onHomeButtonClicked();
        void onCreateRoomButtonClicked();
        void onJoinGameButtonClicked();
    }

}
