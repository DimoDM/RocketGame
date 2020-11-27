package com.example.rocketgame.di.modules;

import com.example.rocketgame.ui.activities.BaseActivity;
import com.example.rocketgame.ui.activities.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector
    abstract BaseActivity bindBaseActivity();

}
