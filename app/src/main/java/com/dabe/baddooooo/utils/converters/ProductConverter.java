package com.dabe.baddooooo.utils.converters;

import com.dabe.baddooooo.model.data.local.Product;
import com.dabe.baddooooo.model.data.remote.dto.TransactionDTO;
import com.dabe.baddooooo.utils.TransactionsUtils;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Daniil Belevtsev
 * Project: Baddooooo; Skype: pandamoni1
 */

public class ProductConverter implements Func1<List<TransactionDTO>, Observable<List<Product>>> {

    @Inject
    public ProductConverter() {
    }

    @Override
    public Observable<List<Product>> call(List<TransactionDTO> transactionDTOs) {
        return Observable.from(transactionDTOs)
                .distinct()
                .map(transactionDTO -> new Product(transactionDTO.getSku(), TransactionsUtils.getCountBySku(transactionDTO.getSku(), transactionDTOs)))
                .toList();
    }

}
