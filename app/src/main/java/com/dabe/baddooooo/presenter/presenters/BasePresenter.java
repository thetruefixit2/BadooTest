package com.dabe.baddooooo.presenter.presenters;

import android.content.Context;

import com.dabe.baddooooo.model.IDataManager;
import com.dabe.baddooooo.presenter.interfaces.IBasePresenter;
import com.dabe.baddooooo.view.views.IBaseView;

import javax.inject.Inject;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;


/**
 * Created by Daniil Belevtsev on 25.01.2017 22:36.
 * Project: SkyApp; Skype: pandamoni1
 */

public abstract class BasePresenter<T extends IBaseView> implements IBasePresenter {

    protected T view;

    @Inject
    protected Context appContext;

    @Inject
    protected IDataManager dataManager;

    @Inject
    protected CompositeSubscription compositeSubscription; // this is for clear rxJava subscribers.

    public BasePresenter() {
    }

    protected void addSubscription(Subscription sub) {
        compositeSubscription.add(sub);
    }

    protected void processError() {
        if (getView() != null) {
            getView().onError(getClass().getSimpleName() + " return ERROR");
        }
    }

    protected void hideLoading() {
        if (getView() != null) {
            getView().onHideLoading();
        }
    }

    protected void showLoading() {
        if (getView() != null) {
            getView().onShowLoading();
        }
    }

    protected void setView(T view) {
        this.view = view;
    }

    protected T getView() {
        return view;
    }

    protected Context getAppContext() {
        return appContext;
    }

    @Override
    public void onStop() {
        if (compositeSubscription != null) {
            compositeSubscription.clear();
        }
    }


}
