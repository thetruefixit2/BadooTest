package com.dabe.baddooooo.di;

import com.dabe.baddooooo.di.modules.AppModule;
import com.dabe.baddooooo.di.modules.CacheModule;
import com.dabe.baddooooo.di.modules.ModelModule;
import com.dabe.baddooooo.di.modules.PresenterModule;
import com.dabe.baddooooo.di.modules.ViewModule;
import com.dabe.baddooooo.mock.MockApiClient;
import com.dabe.baddooooo.model.DataManager;
import com.dabe.baddooooo.presenter.presenters.ProductListPresenter;
import com.dabe.baddooooo.presenter.presenters.TransactionListPresenter;
import com.dabe.baddooooo.utils.loaders.RawLoader;
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
@Component(modules = {AppModule.class, ModelModule.class, ViewModule.class, PresenterModule.class, CacheModule.class})
public interface AppComponent {
    ///////////////////////////////////////////////////////////////////////////
    // MODEL
    ///////////////////////////////////////////////////////////////////////////
    void inject(DataManager dataManager);

    void inject(MockApiClient mockApiClient);

    void inject(RawLoader rxRawLoader);
    ///////////////////////////////////////////////////////////////////////////
    // VIEW
    ///////////////////////////////////////////////////////////////////////////
    void inject(MainActivity activity);

    void inject(ProductListFragment fragment);

    void inject(TransactionsListFragment fragment);
    ///////////////////////////////////////////////////////////////////////////
    // PRESENTER
    ///////////////////////////////////////////////////////////////////////////
    void inject(ProductListPresenter presenter);

    void inject(TransactionListPresenter presenter);
}
