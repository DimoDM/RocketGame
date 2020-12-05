package com.example.rocketgame.repository;

import com.example.rocketgame.generators.RoomIdGenerator;
import com.example.rocketgame.models.MultiPlayerUser;
import com.example.rocketgame.models.Room;
import com.example.rocketgame.models.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseRepository {

    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseUser mAuthUser = mAuth.getCurrentUser();
    private FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mUserRef = mDatabase.getReference("users");
    private DatabaseReference mRoomRef = mDatabase.getReference("rooms");
    private static FirebaseRepository instance;

    public static FirebaseRepository getInstance() {
        if (instance == null)
            instance = new FirebaseRepository();
        return instance;
    }

    public void createNewPlayer(User newUser) {
        mUserRef.child(mAuthUser.getUid()).setValue(newUser);
    }

    public void updateHighScore(int newHighScore) {
        mUserRef.child(mAuthUser.getUid()).child("highScore").setValue(newHighScore);
    }

    public void updateWins(int wins) {
        mUserRef.child(mAuthUser.getUid()).child("wins").setValue(wins);
    }

    public void createRoom(MultiPlayerUser player1) {
        String roomId = RoomIdGenerator.generateCode();
        player1.setRoomId(roomId);
        Room room = new Room(roomId, player1);
        mRoomRef.child(roomId).setValue(room);
    }

    public void player2ConnectToRoom(String roomId, MultiPlayerUser player2) {
        mRoomRef.child(roomId).child("player2").setValue(player2);
    }

}
