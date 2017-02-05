package com.dabe.baddooooo.di.modules;

import com.dabe.baddooooo.model.DataManager;
import com.dabe.baddooooo.model.IDataManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Daniil Belevtsev
 * Project: Baddooooo; Skype: pandamoni1
 */

@Module
public class PresenterModule {
    @Provides
    @Singleton
    IDataManager provideDataManager() {
        return new DataManager();
    }

    @Provides
    CompositeSubscription provideCompositeSubscription() {
        return new CompositeSubscription();
    }

}
