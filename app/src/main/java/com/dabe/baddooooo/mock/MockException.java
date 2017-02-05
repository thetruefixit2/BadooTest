package com.dabe.baddooooo.mock;

import android.annotation.TargetApi;
import android.os.Build;

import com.dabe.baddooooo.model.data.enums.ErrorType;


/**
 * Created by Daniil Belevtsev
 * Project: BadooProject; Skype: pandamoni1
 */

public class MockException extends RuntimeException {
    private ErrorType errorType;

    public MockException(ErrorType errorType) {
        this.errorType = errorType;
    }

    public MockException(String message, ErrorType errorType) {
        super(message);
        this.errorType = errorType;
    }

    public MockException(String message, Throwable cause, ErrorType errorType) {
        super(message, cause);
        this.errorType = errorType;
    }

    public MockException(Throwable cause, ErrorType errorType) {
        super(cause);
        this.errorType = errorType;
    }

    @TargetApi(Build.VERSION_CODES.N)
    public MockException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, ErrorType errorType) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorType = errorType;
    }
}
