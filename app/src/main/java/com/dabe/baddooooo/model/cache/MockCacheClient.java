package com.dabe.baddooooo.model.cache;

import com.dabe.baddooooo.model.data.local.Product;

import java.util.List;

/**
 * Created by Daniil Belevtsev
 * Project: Baddooooo; Skype: pandamoni1
 */

public class MockCacheClient implements IBadooCache {
    @Override
    public boolean isDataExists() {
        return false; // always false in my mock!
    }

    @Override
    public void saveProducts(List<Product> products) {

    }

    @Override
    public void saveTransactions(List<Product> transactions) {

    }

    @Override
    public void loadProducts() {

    }

    @Override
    public void loadTransactions(String sku) {

    }
}
