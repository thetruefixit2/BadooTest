package com.dabe.baddooooo.model;

import android.content.Context;

import com.dabe.baddooooo.app.AppConst;
import com.dabe.baddooooo.app.TheApp;
import com.dabe.baddooooo.model.api.methods.IBadooApi;
import com.dabe.baddooooo.model.cache.IBadooCache;
import com.dabe.baddooooo.model.cache.IGraphCache;
import com.dabe.baddooooo.model.data.algh.Graph;
import com.dabe.baddooooo.model.data.local.Product;
import com.dabe.baddooooo.model.data.local.Transaction;
import com.dabe.baddooooo.utils.converters.ProductConverter;
import com.dabe.baddooooo.utils.converters.TransactionConverter;

import java.util.List;
import java.util.NoSuchElementException;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.Scheduler;

/**
 * Created by Daniil Belevtsev
 * Project: Baddooooo; Skype: pandamoni1
 */
public class DataManager implements IDataManager {
    private final Observable.Transformer shedulersTransformer;

    /**
     * The Context.
     */
    @Inject
    protected Context context;

    /**
     * The Badoo api.
     */
    @Inject
    protected IBadooApi badooApi;

    /**
     * The Badoo cache.
     */
    @Inject
    protected IBadooCache badooCache;

    /**
     * The Graph cache.
     */
    @Inject
    protected IGraphCache graphCache;

    /**
     * The Product converter.
     */
    @Inject
    protected ProductConverter productConverter;

    /**
     * The Ui thread.
     */
    @Inject
    @Named(AppConst.UI_THREAD)
    protected Scheduler uiThread;

    /**
     * The Io thread.
     */
    @Inject
    @Named(AppConst.IO_THREAD)
    protected Scheduler ioThread;

    /**
     * Instantiates a new Data manager.
     */
    public DataManager() {
        TheApp.getComponent().inject(this);
        shedulersTransformer = observable -> ((Observable) observable).subscribeOn(ioThread)
                .observeOn(uiThread)
                .unsubscribeOn(ioThread);
    }


    @Override
    public Observable<Boolean> getRates() {
        if (graphCache.isGraphBuilt()) {
            return Observable.just(true)
                    .compose(applyShedulers());
        } else {
            return badooApi.getRates()
                    .map(rateDTOs -> {
                        if (rateDTOs != null) {
                            graphCache.buildGraph(rateDTOs);
                            return true;
                        } else {
                            return false;
                        }
                    })
                    .compose(applyShedulers());
        }
    }

    @Override
    public Observable<List<Product>> getProducts() {
        if (badooCache.isProductsExists()) {
            return badooCache.loadProducts()
                    .compose(applyShedulers());
        } else {
            return badooApi.getTransactions()
                    .flatMap(productConverter)
                    .compose(applyShedulers());
        }
    }

    @Override
    public Observable<List<Transaction>> getTransactions(String sku) {
        if (badooCache.isTransactionsExists(sku)) {
            return badooCache.loadTransactions(sku)
                    .compose(applyShedulers());
        } else {
            return badooApi.getTransactions()
                    .flatMap(new TransactionConverter(sku)) // im so lazy to do it in dagger:(
                    .compose(applyShedulers());
        }
    }

    @Override
    public Graph getGraph() {
        if (graphCache.isGraphBuilt()) {
            return graphCache.getGraph();
        } else {
            throw new NoSuchElementException();
        }
    }


    @SuppressWarnings("unchecked")
    private <T> Observable.Transformer<T, T> applyShedulers() {
        return (Observable.Transformer<T, T>) shedulersTransformer;
    }
}
