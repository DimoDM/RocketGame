package com.example.rocketgame.di.modules;

import com.example.rocketgame.core.contract.DeathFragmentContract;
import com.example.rocketgame.core.contract.GameFragmentContract;
import com.example.rocketgame.core.contract.MainMenuFragmentContract;
import com.example.rocketgame.core.contract.PauseMenuFragmentContract;
import com.example.rocketgame.core.present.DeathFragmentPresenter;
import com.example.rocketgame.core.present.GameFragmentPresenter;
import com.example.rocketgame.core.present.MainMenuFragmentPresenter;
import com.example.rocketgame.core.present.PauseMenuFragmentPresenter;
import com.example.rocketgame.ui.fragments.PauseMenuFragment;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ContractsModule {

    @Singleton
    @Provides
    public MainMenuFragmentContract.PresentListener provideMainMenuFragmentPresenter() {
        return new MainMenuFragmentPresenter();
    }

    @Singleton
    @Provides
    public GameFragmentContract.PresentListener provideGameFragmentPresenter() {
        return new GameFragmentPresenter();
    }

    @Singleton
    @Provides
    public PauseMenuFragmentContract.PresentListener providePauseMenuFragmentPresenter() {
        return new PauseMenuFragmentPresenter();
    }

    @Singleton
    @Provides
    public DeathFragmentContract.PresentListener provideDeathFragmentPresenter() {
        return new DeathFragmentPresenter();
    }



}
