package com.dabe.baddooooo.utils.converters;

import com.dabe.baddooooo.model.data.local.Transaction;
import com.dabe.baddooooo.model.data.remote.dto.TransactionDTO;

import java.util.List;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Daniil Belevtsev
 * Project: Baddooooo; Skype: pandamoni1
 */

public class TransactionConverter implements Func1<List<TransactionDTO>, Observable<List<Transaction>>> {

    private String sku;

    public TransactionConverter(String sku) {
        this.sku = sku;
    }

    @Override
    public Observable<List<Transaction>> call(List<TransactionDTO> transactionDTOs) {
        return Observable.from(transactionDTOs)
                .filter(transactionDTO -> transactionDTO.getSku().equals(sku))
                .map(transactionDTO -> new Transaction(transactionDTO.getSku(),
                        transactionDTO.getCurrency(),
                        transactionDTO.getAmount(),
                        transactionDTO.getAmount())) // still no GBP PRICE
                .toList();
    }
}
