package com.example.rocketgame.di.modules;

<<<<<<< HEAD
import com.example.rocketgame.ui.activities.MainActivity;
import com.example.rocketgame.ui.fragments.BaseFragment;
import com.example.rocketgame.ui.fragments.ClassationFragment;
=======
>>>>>>> ec6c5fa993e6c28f9755a0f3e0c68d0fcc348480
import com.example.rocketgame.ui.fragments.DeathFragment;
import com.example.rocketgame.ui.fragments.GameFragment;
import com.example.rocketgame.ui.fragments.MainMenuFragment;
import com.example.rocketgame.ui.fragments.MultiplayerHostFragment;
import com.example.rocketgame.ui.fragments.PauseMenuFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentsModule {

    @ContributesAndroidInjector
    abstract MainMenuFragment provideMainMenuFragment();

    @ContributesAndroidInjector
    abstract GameFragment provideGameFragment();

    @ContributesAndroidInjector
    abstract MultiplayerHostFragment provideMultiplayerHostFragment();

    @ContributesAndroidInjector
    abstract PauseMenuFragment providePauseMenuFragment();

    @ContributesAndroidInjector
    abstract DeathFragment provideDeathFragment();

    @ContributesAndroidInjector
    abstract ClassationFragment provideClassationFragment();

}
