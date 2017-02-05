package com.dabe.baddooooo.di.modules;

import com.dabe.baddooooo.app.AppConst;
import com.dabe.baddooooo.mock.MockApiClient;
import com.dabe.baddooooo.model.api.methods.IBadooApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Daniil Belevtsev
 * Project: Baddooooo; Skype: pandamoni1
 */
@Module
public class ModelModule {

    @Provides
    @Singleton
    IBadooApi provideApi() {
        // some actions with mocks
        return new MockApiClient();
    }

    @Provides
    @Singleton
    @Named(AppConst.GSON_SERIALIZER)
    Gson provideSerializeGson() {
        return new GsonBuilder()
                .create();
    }

    @Provides
    @Singleton
    @Named(AppConst.GSON_DESERIALIZER)
    Gson provideDeserializeGson() {
        return new GsonBuilder()
                .create();
    }

    @Provides
    @Singleton
    @Named(AppConst.UI_THREAD)
    Scheduler provideSchedulerUI() {
        return AndroidSchedulers.mainThread();
    }

    @Provides
    @Singleton
    @Named(AppConst.IO_THREAD)
    Scheduler provideSchedulerIO() {
        return Schedulers.io();
    }
}
