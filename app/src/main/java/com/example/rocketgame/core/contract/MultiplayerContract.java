package com.example.rocketgame.core.contract;

public interface MultiplayerContract {

    interface ViewListener{
        void goToMainScreen();
        void goToEnterGameScreen();
        void createGameAndJoin();
    }

    interface PresenterListener{
        void setViewListener(MultiplayerContract.ViewListener viewListener);
        void onHomeButtonClicked();
        void onCreateRoomButtonClicked();
        void onJoinGameButtonClicked();
    }

}
