package com.example.rocketgame.models;

public class Room {
    private int id;
    private MultiPlayerUser player1;
    private MultiPlayerUser player2;
    private String winnerUid;

    public Room(int id, MultiPlayerUser player1) {
        this.id = id;
        this.player1 = player1;
    }

    public int getId() {
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
