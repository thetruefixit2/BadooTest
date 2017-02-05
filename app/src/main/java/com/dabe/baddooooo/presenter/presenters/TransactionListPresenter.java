package com.dabe.baddooooo.presenter.presenters;

import android.os.Bundle;

import com.dabe.baddooooo.R;
import com.dabe.baddooooo.app.AppConfig;
import com.dabe.baddooooo.app.AppConst;
import com.dabe.baddooooo.app.Currency;
import com.dabe.baddooooo.app.TheApp;
import com.dabe.baddooooo.model.data.local.Transaction;
import com.dabe.baddooooo.utils.CurrencyUtils;
import com.dabe.baddooooo.utils.TransactionsUtils;
import com.dabe.baddooooo.utils.converters.GBPConverter;
import com.dabe.baddooooo.view.views.ITransactionView;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by Daniil Belevtsev
 * Project: Baddooooo; Skype: pandamoni1
 */

public class TransactionListPresenter extends BasePresenter<ITransactionView> {

    private String sku;

    public void init(ITransactionView view, Bundle arguments) {
        TheApp.getComponent().inject(this);
        setView(view);
        initBundle(arguments);
        initTitle();
    }

    private void initTitle() {
        String title;
        if (sku != null) {
            title = String.format(Locale.getDefault(), getAppContext().getString(R.string.transactions_for), sku);
        } else {
            title = getAppContext().getString(R.string.transactions);
        }

        if (getView() != null) {
            getView().onTitleUpdated(title);
        }
    }

    private void initBundle(Bundle bundle) {
        if (bundle != null) {
            this.sku = bundle.getString(AppConst.EXTRA_SKU);
        } else {
            processError();
        }
    }

    public void initData() {
        showLoading();
        if (sku != null) {
            Subscription sub = dataManager.getRates()
                    .subscribe(new Subscriber<Boolean>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {
                            processError();
                        }

                        @Override
                        public void onNext(Boolean aBoolean) {
                            if (aBoolean) {
                                initTransactions();
                            } else {
                                processError();
                            }
                        }
                    });
            addSubscription(sub);
        } else {
            processError();
        }
    }


    private void initTransactions() {
        Subscription sub = dataManager.getTransactions(sku)
                .flatMap(new GBPConverter(dataManager.getGraph()))
                .subscribe(new Subscriber<List<Transaction>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        processError();
                    }

                    @Override
                    public void onNext(List<Transaction> transactions) {
                        updateTotal(transactions);
                        updateTransactions(transactions);
                        hideLoading();
                    }
                });
        addSubscription(sub);
    }

    private void updateTotal(List<Transaction> transactions) {
        BigDecimal subTotal = TransactionsUtils.getTotal(transactions);
        String total = CurrencyUtils.getCurrencySymbol(Currency.GBP) + subTotal.setScale(AppConfig.SCALE_DIGITS, AppConfig.SCALE_MODE).toPlainString();
        String result = String.format(Locale.getDefault(), getAppContext().getString(R.string.total_value), total);
        if (getView() != null) {
            getView().onTotalUpdate(result);
        } else {
            processError();
        }
    }

    private void updateTransactions(List<Transaction> transactions) {
        if (getView() != null && transactions != null) {
            getView().onTransactionUpdate(transactions);
        } else {
            processError();
        }
    }
}
