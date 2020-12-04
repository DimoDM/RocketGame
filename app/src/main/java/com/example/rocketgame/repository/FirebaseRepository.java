package com.example.rocketgame.repository;

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

    public void createNewPlayer(User  newUser){
        mUserRef.child(mAuthUser.getUid()).setValue(newUser);
    }

    public void updateHighScore(int newHighScore){
        mUserRef.child(mAuthUser.getUid()).child("highScore").setValue(newHighScore);
    }

    public void updateWins(int wins){
        mUserRef.child(mAuthUser.getUid()).child("wins").setValue(wins);
    }

    public void createRoom(){
        
    }

}
