package com.example.rocketgame.models;

public class Room {
    private String id;
    private MultiPlayerUser player1;
    private MultiPlayerUser player2;
    private String winnerUid;

    public Room(String id, MultiPlayerUser player1) {
        this.id = id;
        this.player1 = player1;
    }

    public String getId() {
        return id;
    }

    public MultiPlayerUser getPlayer1() {
        return player1;
    }

    public MultiPlayerUser getPlayer2() {
        return player2;
    }

    public String getWinnerUid() {
        return winnerUid;
    }
}
