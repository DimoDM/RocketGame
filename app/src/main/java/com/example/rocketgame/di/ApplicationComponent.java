package com.example.rocketgame.di;

import com.example.rocketgame.RocketGameApplication;
import com.example.rocketgame.di.modules.ActivityModule;
import com.example.rocketgame.di.modules.ContractsModule;
import com.example.rocketgame.di.modules.DataModule;
import com.example.rocketgame.di.modules.FirebaseModule;
import com.example.rocketgame.di.modules.FragmentsModule;
import com.example.rocketgame.ui.activities.MainActivity;
import com.google.firebase.database.FirebaseDatabase;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;


@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        AndroidInjectionModule.class,
        DataModule.class,
        ActivityModule.class,
        FragmentsModule.class,
        ContractsModule.class,
        FirebaseModule.class
})


public interface ApplicationComponent {

    void inject(RocketGameApplication rocketGameApplication);
    void inject(MainActivity mainActivity);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder applicationBind(RocketGameApplication rocketGameApplication);

        ApplicationComponent build();
    }
}

