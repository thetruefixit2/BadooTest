package com.dabe.baddooooo.model.api.methods;

import com.dabe.baddooooo.model.data.remote.dto.RateDTO;
import com.dabe.baddooooo.model.data.remote.dto.TransactionDTO;

import java.util.List;

import rx.Observable;

/**
 * Created by Daniil Belevtsev
 * Project: Baddooooo; Skype: pandamoni1
 */

public class MockApiClient implements IBadooApi {

    @Override
    public Observable<List<TransactionDTO>> getTransactions() {
        return null;
    }

    @Override
    public Observable<List<RateDTO>> getRates() {
        return null;
    }

}
