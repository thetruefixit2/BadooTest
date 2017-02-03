package com.dabe.baddooooo.view.ui.activities;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;

import com.dabe.baddooooo.R;
import com.dabe.baddooooo.interfaces.OnMainCallbackListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends RouteActivity implements OnMainCallbackListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.coordinatorLayout)
    CoordinatorLayout coordinatorLayout;

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
        ;
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


}
