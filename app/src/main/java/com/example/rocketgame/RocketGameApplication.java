package com.example.rocketgame;

import android.app.Application;

import com.example.rocketgame.di.DaggerApplicationComponent;

import javax.inject.Inject;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;

public class RocketGameApplication  extends Application implements HasAndroidInjector {

    @Inject
    DispatchingAndroidInjector<Object> activityDispatchingAndroidInjector;

    public static RocketGameApplication APP;
    public static final String LASTSCORE = "lastScore";
    public static final String MYPREFERENCE = "myprf";

    @Override
    public void onCreate() {
        super.onCreate();
        APP = this;
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