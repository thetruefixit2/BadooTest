package com.dabe.baddooooo.view.views;

import com.dabe.baddooooo.model.data.local.Transaction;

import java.util.List;

/**
 * Created by Daniil Belevtsev
 * Project: Baddooooo; Skype: pandamoni1
 */

public interface ITransactionView {
    void onTransactionUpdate(List<Transaction> transactions);

    void onSkuUpdated(String sku);
}
