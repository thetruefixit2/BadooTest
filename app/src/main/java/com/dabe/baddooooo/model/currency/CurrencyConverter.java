package com.dabe.baddooooo.model.currency;

/**
 * Created by Daniil Belevtsev
 * Project: Baddooooo; Skype: pandamoni1
 */

public class CurrencyConverter {

    private static CurrencyConverter instance;

    public static CurrencyConverter getInstance() {
        if (instance == null) {
            instance = new CurrencyConverter();
        }
        return instance;
    }


}
