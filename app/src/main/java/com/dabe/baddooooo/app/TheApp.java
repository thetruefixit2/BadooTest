package com.dabe.baddooooo.app;

import android.app.Application;

import com.dabe.baddooooo.di.AppComponent;
import com.dabe.baddooooo.di.DaggerAppComponent;
import com.dabe.baddooooo.di.modules.AppModule;
import com.dabe.baddooooo.di.modules.ModelModule;
import com.dabe.baddooooo.di.modules.PresenterModule;
import com.dabe.baddooooo.di.modules.ViewModule;

/**
 * Created by Daniil Belevtsev
 * Project: Baddooooo; Skype: pandamoni1
 */

public class TheApp extends Application {

    private static AppComponent component;

    public static AppComponent getComponent() {
        return component;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = buildComponent();
    }

    /**
     * Build dagger2 component
     */
    private AppComponent buildComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(getApplicationContext()))
                .modelModule(new ModelModule())
                .presenterModule(new PresenterModule())
                .viewModule(new ViewModule())
                .build();
    }
}
