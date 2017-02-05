package com.dabe.baddooooo.utils;

import com.dabe.baddooooo.model.data.local.Transaction;
import com.dabe.baddooooo.model.data.remote.dto.TransactionDTO;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Daniil Belevtsev
 * Project: Baddooooo; Skype: pandamoni1
 */

public class TransactionsUtils {
    public static long getCountBySku(String sku, List<TransactionDTO> transactions) {
        long result = 0;
        for (int i = 0; i < transactions.size(); i++) {
            if (transactions.get(i).getSku().equals(sku)) {
                result++;
            }
        }
        return result;
    }

    public static BigDecimal getTotal(List<Transaction> transactions) {
        BigDecimal result = new BigDecimal(0); // yeah, i know about create new instance every .add
        for (int i = 0; i < transactions.size(); i++) {
            result = result.add(transactions.get(i).getGbpPrice());
        }
        return result;
    }
}
