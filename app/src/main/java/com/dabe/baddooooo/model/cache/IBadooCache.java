package com.dabe.baddooooo.model.cache;

import com.dabe.baddooooo.model.data.local.Product;

import java.util.List;

/**
 * Created by Daniil Belevtsev
 * Project: Baddooooo; Skype: pandamoni1
 */

public interface IBadooCache {
    boolean isDataExists();

    void saveProducts(List<Product> products);

    void saveTransactions(List<Product> transactions);

    void loadProducts();

    void loadTransactions(String sku);
}
