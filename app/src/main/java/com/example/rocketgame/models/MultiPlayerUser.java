package com.example.rocketgame.models;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MultiPlayerUser {
    private String uid;
    private String name;
    private int currentScore;
    private boolean isReady;
    private boolean isWinner;
    private boolean isDead;
    private FirebaseUser mFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();
    private static MultiPlayerUser instance;
    private String roomId;

    private MultiPlayerUser() {
        this.uid = mFirebaseUser.getUid();
        this.name = mFirebaseUser.getDisplayName();
        currentScore = 0;
        isReady = false;
        isDead = false;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public static MultiPlayerUser getInstance() {
        if(instance == null)
            instance = new MultiPlayerUser();
        return instance;
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

    public void setReady( ) {
        isReady = !isReady;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public boolean isDead() {
        return isDead;
    }
}
