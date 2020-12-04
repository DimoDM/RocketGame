package com.example.rocketgame.models;

public class MultiPlayerUser {
    private String uid;
    private String name;
    private int currentScore;
    private boolean isReady;
    private boolean isWinner;
    private boolean isDead;

    private MultiPlayerUser() {
    }

    public MultiPlayerUser(String uid, String name) {
        this.uid = uid;
        this.name = name;
        currentScore = 0;
        isReady = false;
        isDead = false;
    }

    public String getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public boolean isReady() {
        return isReady;
    }

    public boolean isDead() {
        return isDead;
    }
}
