package com.dabe.baddooooo.model.cache;

import com.dabe.baddooooo.model.data.local.Product;
import com.dabe.baddooooo.model.data.local.Transaction;

import java.util.List;

import rx.Observable;

/**
 * Created by Daniil Belevtsev
 * Project: Baddooooo; Skype: pandamoni1
 */

public interface IBadooCache {
    boolean isProductsExists();

    boolean isTransactionsExists(String sku);

    void saveProducts(List<Product> products);

    void saveTransactions(List<Product> transactions);

    Observable<List<Product>> loadProducts();

    Observable<List<Transaction>> loadTransactions(String sku);
}
