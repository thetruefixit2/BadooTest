package com.dabe.baddooooo.di.modules;

import com.dabe.baddooooo.presenter.presenters.ProductListPresenter;
import com.dabe.baddooooo.presenter.presenters.TransactionListPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Daniil Belevtsev
 * Project: Baddooooo; Skype: pandamoni1
 */

@Module
public class ViewModule {

    @Provides
    ProductListPresenter provideProductPresenter() {
        return new ProductListPresenter();
    }

    @Provides
    TransactionListPresenter provideTransactionsPresenter() {
        return new TransactionListPresenter();
    }

}
