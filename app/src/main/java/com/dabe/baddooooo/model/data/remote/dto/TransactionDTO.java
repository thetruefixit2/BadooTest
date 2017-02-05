package com.dabe.baddooooo.model.data.remote.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

/**
 * Created by Daniil Belevtsev
 * Project: Baddooooo; Skype: pandamoni1
 */

public class TransactionDTO {
    @SerializedName("amount")
    @Expose
    private BigDecimal amount;
    @SerializedName("sku")
    @Expose
    private String sku;
    @SerializedName("currency")
    @Expose
    private String currency;

    private long transCount;

    public TransactionDTO(String sku, String currency, BigDecimal amount) {
        this.amount = amount;
        this.sku = sku;
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getSku() {
        return sku;
    }

    public String getCurrency() {
        return currency;
    }

    public long getTransCount() {
        return transCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionDTO that = (TransactionDTO) o;

        return sku.equals(that.sku);

    }

    @Override
    public int hashCode() {
        return sku.hashCode();
    }
}
