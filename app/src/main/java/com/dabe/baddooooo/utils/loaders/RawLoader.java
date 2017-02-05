package com.dabe.baddooooo.utils.loaders;

import android.content.Context;

import com.dabe.baddooooo.app.TheApp;
import com.dabe.baddooooo.mock.MockException;
import com.dabe.baddooooo.model.data.enums.ErrorType;

import java.io.IOException;
import java.io.InputStream;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * Created by Daniil Belevtsev
 * Project: BadooProject; Skype: pandamoni1
 */

public class RawLoader implements Func1<String, Observable<String>> {

    @Inject
    protected Context appContext;

    public RawLoader() {
        TheApp.getComponent().inject(this);
    }

    @Override
    public Observable<String> call(String filename) {
        return loadResources(filename);
    }

    private Observable<String> loadResources(String filename) {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                InputStream inputStream = appContext.getResources().openRawResource(appContext.getResources().getIdentifier(filename, "raw", appContext.getPackageName()));
                try {

                    byte[] buffer = new byte[inputStream.available()];
                    while (inputStream.read(buffer) != -1) ; // carefull
                    String jsontext = new String(buffer);
                    subscriber.onNext(jsontext);

                } catch (IOException e) {
                    subscriber.onError(new MockException(ErrorType.DATA_ERROR));
                }
                subscriber.onCompleted();
            }
        });
    }
}
