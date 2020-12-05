package com.example.rocketgame.di.modules;

import com.example.rocketgame.core.contract.GameFragmentContract;
import com.example.rocketgame.core.contract.MainMenuFragmentContract;
import com.example.rocketgame.core.contract.MultiplayerFragmentContract;
import com.example.rocketgame.core.contract.MultiplayerHostFragmentContract;
import com.example.rocketgame.core.present.GameFragmentPresenter;
import com.example.rocketgame.core.present.MainMenuFragmentPresenter;
import com.example.rocketgame.core.present.MultiplayerFragmentPresenter;
import com.example.rocketgame.core.present.MultiplayerHostFragmentPresenter;

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
    public MultiplayerFragmentContract.PresenterListener provideMultiplayerPresenter() {
        return new MultiplayerFragmentPresenter();
    }

    @Singleton
    @Provides
    public MultiplayerHostFragmentContract.PresentListener provideMultiplayerHostPresent() {
        return new MultiplayerHostFragmentPresenter();
    }



}
