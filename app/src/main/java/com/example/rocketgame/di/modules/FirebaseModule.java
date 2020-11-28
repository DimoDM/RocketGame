package com.example.rocketgame.di.modules;

import com.google.firebase.database.FirebaseDatabase;

import dagger.Module;
import dagger.Provides;

@Module
public class FirebaseModule {
    FirebaseDatabase instance;

    public FirebaseModule() {
        instance = FirebaseDatabase.getInstance();
    }

    @Provides
    public FirebaseDatabase providesFirebaseDatabase(){
        return instance;
    }
}
