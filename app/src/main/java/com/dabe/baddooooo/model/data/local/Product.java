package com.dabe.baddooooo.model.data.local;

import java.util.Locale;

/**
 * Created by Daniil Belevtsev
 * Project: Baddooooo; Skype: pandamoni1
 */

public class Product {
    private String sku;
    private long transactionCount;

    public Product(String sku, long transactionCount) {
        this.sku = sku;
        this.transactionCount = transactionCount;
    }

    public String getSku() {
        return sku;
    }

    public long getTransactionCount() {
        return transactionCount;
    }

    public String getFormattedTransCount() {
        return String.format(Locale.getDefault(), "%d transactions", transactionCount);
    }
}
