package com.dabe.baddooooo.model.cache;

import com.dabe.baddooooo.model.data.local.Product;
import com.dabe.baddooooo.model.data.local.Transaction;

import java.util.List;

import rx.Observable;

/**
 * Created by Daniil Belevtsev
 * Project: Baddooooo; Skype: pandamoni1
 * Decide to play with architecture :)
 */

public class MockCacheClient implements IBadooCache {

    @Override
    public boolean isProductsExists() {
        return false;
    }

    @Override
    public boolean isTransactionsExists(String sku) {
        return false;
    }

    @Override
    public void saveProducts(List<Product> products) {

    }

    @Override
    public void saveTransactions(List<Product> transactions) {

    }

    @Override
    public Observable<List<Product>> loadProducts() {
        return null;
    }

    @Override
    public Observable<List<Transaction>> loadTransactions(String sku) {
        return null;
    }
}
