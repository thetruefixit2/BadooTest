package com.dabe.baddooooo.di.modules;

import com.dabe.baddooooo.model.cache.GraphCacheClient;
import com.dabe.baddooooo.model.cache.IBadooCache;
import com.dabe.baddooooo.model.cache.IGraphCache;
import com.dabe.baddooooo.model.cache.MockCacheClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Daniil Belevtsev
 * Project: Baddooooo; Skype: pandamoni1
 */

@Module
public class CacheModule {

    @Singleton
    @Provides
    IBadooCache provideRemoteCache() {
        return new MockCacheClient();
    }

    @Singleton
    @Provides
    IGraphCache provideGraphCache() {
        return new GraphCacheClient();
    }
}
