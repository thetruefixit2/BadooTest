package com.dabe.baddooooo.model;

import com.dabe.baddooooo.model.data.algh.Graph;
import com.dabe.baddooooo.model.data.local.Product;
import com.dabe.baddooooo.model.data.local.Transaction;

import java.util.List;

import rx.Observable;

/**
 * Created by Daniil Belevtsev
 * Project: Baddooooo; Skype: pandamoni1
 */

public interface IDataManager {
    /**
     * Method to get currency rates
     *
     * @return true, if currency loaded from internet or local cache. Otherwise return false
     * <p>
     * When rates loaded, creates graph of rates
     */
    Observable<Boolean> getRates();

    /**
     * Method to get products from internet of local cache.
     *
     * @return Observable of Product list or throw error
     */
    Observable<List<Product>> getProducts();

    /**
     * Method to get transactions from internet or local cache.
     *
     * @param sku - id of transactions
     * @return Observable of transations list
     */
    Observable<List<Transaction>> getTransactions(String sku);

    /**
     * Method to get graph from local cache
     *
     * @return built graph of rates
     */
    Graph getGraph();
}
