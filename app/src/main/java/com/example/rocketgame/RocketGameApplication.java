package com.example.rocketgame;

import android.app.Application;

import javax.inject.Inject;
import  com.example.rocketgame.di.DaggerApplicationComponent;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;

public class RocketGameApplication  extends Application implements HasAndroidInjector {

    @Inject
    DispatchingAndroidInjector<Object> activityDispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();

        DaggerApplicationComponent.builder()
                .applicationBind(this)
                .build()
                .inject(this);
    }

    @Override
    public AndroidInjector<Object> androidInjector() {
        return activityDispatchingAndroidInjector;
    }
}