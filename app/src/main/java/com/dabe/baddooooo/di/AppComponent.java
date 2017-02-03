package com.dabe.baddooooo.di;

import com.dabe.baddooooo.di.modules.AppModule;
import com.dabe.baddooooo.di.modules.ModelModule;
import com.dabe.baddooooo.di.modules.PresenterModule;
import com.dabe.baddooooo.di.modules.ViewModule;
import com.dabe.baddooooo.view.ui.activities.MainActivity;
import com.dabe.baddooooo.view.ui.fragments.ProductListFragment;
import com.dabe.baddooooo.view.ui.fragments.TransactionsListFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Daniil Belevtsev
 * Project: Baddooooo; Skype: pandamoni1
 */

@Singleton
@Component(modules = {AppModule.class, ModelModule.class, ViewModule.class, PresenterModule.class})
public interface AppComponent {
    ///////////////////////////////////////////////////////////////////////////
    // MODEL
    ///////////////////////////////////////////////////////////////////////////

    ///////////////////////////////////////////////////////////////////////////
    // VIEW
    ///////////////////////////////////////////////////////////////////////////
    void inject(MainActivity activity);

    void inject(ProductListFragment fragment);

    void inject(TransactionsListFragment fragment);
    ///////////////////////////////////////////////////////////////////////////
    // PRESENTER
    ///////////////////////////////////////////////////////////////////////////

}
