package com.dabe.baddooooo.di.modules;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Daniil Belevtsev
 * Project: Baddooooo; Skype: pandamoni1
 */
@Module
public class AppModule {
    private Context appContext;

    public AppModule(Context appContext) {
        this.appContext = appContext;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return appContext;
    }
}
