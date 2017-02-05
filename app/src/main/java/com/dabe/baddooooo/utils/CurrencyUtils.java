package com.dabe.baddooooo.utils;

import java.util.Currency;
import java.util.Locale;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by Daniil Belevtsev
 * Project: Baddooooo; Skype: pandamoni1
 */

public class CurrencyUtils {
    public static SortedMap<Currency, Locale> currencyLocaleMap;

    static {
        currencyLocaleMap = new TreeMap<>((c1, c2) -> {
            return c1.getCurrencyCode().compareTo(c2.getCurrencyCode());
        });
        for (Locale locale : Locale.getAvailableLocales()) {
            try {
                Currency currency = Currency.getInstance(locale);
                currencyLocaleMap.put(currency, locale);
            } catch (Exception e) {
            }
        }
    }


    public static String getCurrencySymbol(String currencyCode) {
        Currency currency = Currency.getInstance(currencyCode);
        String result;
        if (currency != null && currencyLocaleMap != null) {
            result = currency.getSymbol(currencyLocaleMap.get(currency));
        } else {
            result = currencyCode;
        }
        return result;
    }

}
