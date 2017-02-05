package com.dabe.baddooooo.view.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dabe.baddooooo.R;
import com.dabe.baddooooo.adapters.ProductAdapter;
import com.dabe.baddooooo.app.TheApp;
import com.dabe.baddooooo.model.data.local.Product;
import com.dabe.baddooooo.presenter.presenters.ProductListPresenter;
import com.dabe.baddooooo.view.views.IProductView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Daniil Belevtsev
 * Project: Baddooooo; Skype: pandamoni1
 */

public class ProductListFragment extends BaseFragment implements IProductView {

    @BindView(R.id.product_list)
    protected RecyclerView productList;

    @Inject
    protected ProductListPresenter presenter;

    private ProductAdapter adapter;

    public static ProductListFragment newInstance() {
        Bundle args = new Bundle();
        ProductListFragment fragment = new ProductListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        TheApp.getComponent().inject(this);
        super.onCreate(savedInstanceState);
        presenter.init(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_products_list, container, false);
        ButterKnife.bind(this, view);
        initUI(view);
        initListeners();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.initTitle();
    }

    private void initUI(View view) {
        productList.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new ProductAdapter(new ArrayList<Product>(), this);
        productList.setAdapter(adapter);
    }

    private void initListeners() {
        //none
    }

    private void initData() {
        presenter.initData();
    }

    @Override
    public void onProductSelected(String sku) {
        if (getActivityCallback() != null) {
            getActivityCallback().onProductSelected(sku);
        }
    }

    @Override
    public void onTitleUpdate(String title) {
        if (getActivityCallback() != null) {
            getActivityCallback().onTitleUpdate(title);
        }
    }

    @Override
    public void onProductUpdate(List<Product> products) {
        if (adapter != null) {
            adapter.updateProducts(products);
        } else {
            adapter = new ProductAdapter(products, this);
        }
    }

    @Override
    public void onError(String error) {
        if (getActivityCallback() != null) {
            getActivityCallback().onError(error);
        }
    }

    @Override
    public void onShowLoading() {
        if (getActivityCallback() != null) {
            getActivityCallback().onShowLoading();
        }
    }

    @Override
    public void onHideLoading() {
        if (getActivityCallback() != null) {
            getActivityCallback().onHideLoading();
        }
    }
}
