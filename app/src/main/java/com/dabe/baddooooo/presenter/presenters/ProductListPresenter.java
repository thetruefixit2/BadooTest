package com.dabe.baddooooo.presenter.presenters;

import com.dabe.baddooooo.R;
import com.dabe.baddooooo.app.TheApp;
import com.dabe.baddooooo.model.data.local.Product;
import com.dabe.baddooooo.view.views.IProductView;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by Daniil Belevtsev
 * Project: Baddooooo; Skype: pandamoni1
 */

public class ProductListPresenter extends BasePresenter<IProductView> {

    public void init(IProductView view) {
        TheApp.getComponent().inject(this);
        setView(view);
        initTitle();
    }


    public void initData() {
        showLoading();
        Subscription sub = dataManager.getProducts()
                .subscribe(new Subscriber<List<Product>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (getView() != null) {
                            getView().onError(e.getMessage());
                        }
                    }

                    @Override
                    public void onNext(List<Product> products) {
                        if (getView() != null) {
                            getView().onProductUpdate(products);
                            hideLoading();
                        }
                    }
                });
        addSubscription(sub);
    }

    private void initTitle() {
        String title = appContext.getString(R.string.products);
        if (getView() != null) {
            getView().onTitleUpdate(title);
        }
    }

    private List<Product> mockProducts() {
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            productList.add(new Product("SKU" + i, 512));
        }
        return productList;
    }

}
