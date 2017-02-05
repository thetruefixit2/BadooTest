package com.dabe.baddooooo.mock;

import com.dabe.baddooooo.app.AppConst;
import com.dabe.baddooooo.app.TheApp;
import com.dabe.baddooooo.model.api.methods.IBadooApi;
import com.dabe.baddooooo.model.data.remote.dto.RateDTO;
import com.dabe.baddooooo.model.data.remote.dto.TransactionDTO;
import com.dabe.baddooooo.utils.loaders.RawLoader;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Daniil Belevtsev
 * Project: Baddooooo; Skype: pandamoni1
 */

public class MockApiClient implements IBadooApi {

    @Inject
    @Named(AppConst.GSON_DESERIALIZER)
    protected Gson gsonDeserializer;

    public MockApiClient() {
        TheApp.getComponent().inject(this);
    }


    @Override
    public Observable<List<TransactionDTO>> getTransactions() {
        return Observable.just(MockConsts.TRANSACTION1)
                .flatMap(new RawLoader())
                .map(new Func1<String, List<TransactionDTO>>() {
                    @Override
                    public List<TransactionDTO> call(String json) {
                        return gsonDeserializer.fromJson(json,
                                new TypeToken<List<TransactionDTO>>() {
                                }.getType());
                    }
                });

    }

    @Override
    public Observable<List<RateDTO>> getRates() {
        return Observable.just(MockConsts.RATE1)
                .flatMap(new RawLoader())
                .map(new Func1<String, List<RateDTO>>() {
                    @Override
                    public List<RateDTO> call(String json) {
                        return gsonDeserializer.fromJson(json,
                                new TypeToken<List<RateDTO>>() {
                                }.getType());
                    }
                });
    }

}
