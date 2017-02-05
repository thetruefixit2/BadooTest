package com.dabe.baddooooo.view.ui.activities;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;

import com.dabe.baddooooo.R;
import com.dabe.baddooooo.interfaces.OnMainCallbackListener;
import com.dabe.baddooooo.view.ui.custom.LoadingView;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends RouteActivity implements OnMainCallbackListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.coordinatorLayout)
    CoordinatorLayout coordinatorLayout;
    @BindView(R.id.loading_view)
    LoadingView loadingView;
    @BindView(R.id.container)
    FrameLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setContainer(R.id.container);
        initUI();
        initData();

    }

    private void initUI() {
        toolbar.setTitle(getString(R.string.app_name));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
    }

    private void initData() {
        showProductScreen();
    }

    @Override
    public void onProductSelected(String sku) {
        showTransactionsScreen(sku);
    }

    @Override
    public void onTitleUpdate(String title) {
        toolbar.setTitle(title);
    }


    @Override
    public void onError(String error) {
        String errorMsg = String.format(Locale.getDefault(), getString(R.string.error_message), error);
        Snackbar.make(coordinatorLayout, errorMsg, Snackbar.LENGTH_LONG).show();
        onHideLoading();
    }

    @Override
    public void onShowLoading() {
        container.setVisibility(View.GONE);
        loadingView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onHideLoading() {
        loadingView.setVisibility(View.GONE);
        container.setVisibility(View.VISIBLE);
    }
}
