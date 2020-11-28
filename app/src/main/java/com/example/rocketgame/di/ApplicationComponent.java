package com.example.rocketgame.di;

import com.example.rocketgame.RocketGameApplication;
import com.example.rocketgame.di.modules.ActivityModule;
import com.example.rocketgame.di.modules.ContractsModule;
import com.example.rocketgame.di.modules.DataModule;
import com.example.rocketgame.di.modules.FragmentsModule;

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
        ContractsModule.class
})


public interface ApplicationComponent {

    void inject(RocketGameApplication rocketGameApplication);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder applicationBind(RocketGameApplication rocketGameApplication);

        ApplicationComponent build();
    }
}

