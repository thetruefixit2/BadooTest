package com.dabe.baddooooo.utils.converters;

import com.dabe.baddooooo.app.Currency;
import com.dabe.baddooooo.model.data.algh.DijkstraAlgorithm;
import com.dabe.baddooooo.model.data.algh.Graph;
import com.dabe.baddooooo.model.data.local.Transaction;

import java.util.List;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Daniil Belevtsev
 * Project: Baddooooo; Skype: pandamoni1
 */

public class GBPConverter implements Func1<List<Transaction>, Observable<List<Transaction>>> {

    private Graph graph;

    public GBPConverter(Graph graph) {
        this.graph = graph;
    }

    @Override
    public Observable<List<Transaction>> call(List<Transaction> transactions) {
        return Observable.from(transactions)
                .map(transaction -> {
                    transaction.setGbpPrice(new DijkstraAlgorithm(graph).convertCurrency(transaction.getCurrency(), Currency.GBP, transaction.getPrice()));
                    return transaction;
                })
                .toList();
    }

}
