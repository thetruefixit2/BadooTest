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
import com.dabe.baddooooo.model.data.local.Product;
import com.dabe.baddooooo.view.views.IProductView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Daniil Belevtsev
 * Project: Baddooooo; Skype: pandamoni1
 */

public class ProductListFragment extends BaseFragment implements IProductView {

    @BindView(R.id.product_list)
    RecyclerView productList;

    private ProductAdapter adapter;

    public static ProductListFragment newInstance() {
        Bundle args = new Bundle();
        ProductListFragment fragment = new ProductListFragment();
        fragment.setArguments(args);
        return fragment;
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

    private void initUI(View view) {
        productList.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new ProductAdapter(new ArrayList<Product>(), this);
        productList.setAdapter(adapter);
    }

    private void initListeners() {

    }

    private void initData() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            onUpdateData(mockProducts());
        }
    }

    private List<Product> mockProducts() {
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            productList.add(new Product("SKU" + i, 512));
        }
        return productList;
    }

    @Override
    public void onProductSelected(String sku) {
        if (getActivityCallback() != null) {
            getActivityCallback().onProductSelected(sku);
        }
    }

    @Override
    public void onUpdateData(List<Product> products) {
        if (adapter != null) {
            adapter.updateProducts(products);
        } else {
            adapter = new ProductAdapter(products, this);
        }
    }
}
