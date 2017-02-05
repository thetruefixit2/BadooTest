package com.dabe.baddooooo.model.data.local;

import com.dabe.baddooooo.app.AppConfig;
import com.dabe.baddooooo.app.Currency;
import com.dabe.baddooooo.utils.CurrencyUtils;

import java.math.BigDecimal;

/**
 * Created by Daniil Belevtsev
 * Project: Baddooooo; Skype: pandamoni1
 */

public class Transaction {
    private String sku;
    private String currency;
    private BigDecimal price;
    private BigDecimal gbpPrice;

    public Transaction(String sku, String currency, BigDecimal price, BigDecimal gbpPrice) {
        this.sku = sku;
        this.currency = currency;
        this.price = price;
        this.gbpPrice = gbpPrice;
    }

    public String getSku() {
        return sku;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getGbpPrice() {
        return gbpPrice;
    }

    public void setGbpPrice(BigDecimal gbpPrice) {
        this.gbpPrice = gbpPrice;
    }

    /**
     * @return rounded price in string, if price is null then return default
     */
    public String getFormattedPrice() {
        if (price != null && currency != null) {
            return CurrencyUtils.getCurrencySymbol(currency) + price.setScale(AppConfig.SCALE_DIGITS, AppConfig.SCALE_MODE).toPlainString();
        } else {
            return CurrencyUtils.getCurrencySymbol(currency) + AppConfig.DEFAULT_STRING_PRICE;
        }
    }

    /**
     * @return rounded price in string, if price is null then return default
     */
    public String getFormattedGbpPrice() {
        if (gbpPrice != null) {
            return CurrencyUtils.getCurrencySymbol(Currency.GBP) + gbpPrice.setScale(AppConfig.SCALE_DIGITS, AppConfig.SCALE_MODE).toPlainString();
        } else {
            return CurrencyUtils.getCurrencySymbol(Currency.GBP) + AppConfig.DEFAULT_STRING_PRICE;
        }
    }

}
