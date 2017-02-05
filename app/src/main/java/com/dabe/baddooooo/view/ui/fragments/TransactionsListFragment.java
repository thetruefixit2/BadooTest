package com.dabe.baddooooo.view.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dabe.baddooooo.R;
import com.dabe.baddooooo.adapters.TransactionAdapter;
import com.dabe.baddooooo.app.AppConst;
import com.dabe.baddooooo.app.TheApp;
import com.dabe.baddooooo.model.data.local.Transaction;
import com.dabe.baddooooo.presenter.presenters.TransactionListPresenter;
import com.dabe.baddooooo.view.views.ITransactionView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Daniil Belevtsev
 * Project: Baddooooo; Skype: pandamoni1
 */

public class TransactionsListFragment extends BaseFragment implements ITransactionView {

    @BindView(R.id.total_value)
    TextView totalValue;
    @BindView(R.id.transaction_list)
    RecyclerView transactionList;

    @Inject
    TransactionListPresenter presenter;

    private TransactionAdapter adapter;

    public static TransactionsListFragment newInstance(String sku) {
        Bundle args = new Bundle();
        args.putString(AppConst.EXTRA_SKU, sku);
        TransactionsListFragment fragment = new TransactionsListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        TheApp.getComponent().inject(this);
        super.onCreate(savedInstanceState);
        presenter.init(this, getArguments());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_transaction_list, container, false);
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
        transactionList.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new TransactionAdapter();
        transactionList.setAdapter(adapter);
    }

    private void initListeners() {
        //none
    }

    private void initData() {
        presenter.initData();
    }

    @Override
    public void onTransactionUpdate(List<Transaction> transactions) {
        adapter.updateData(transactions);
    }

    @Override
    public void onTitleUpdated(String sku) {
        if (getActivityCallback() != null) {
            getActivityCallback().onTitleUpdate(sku);
        }
    }

    @Override
    public void onTotalUpdate(String total) {
        totalValue.setText(total);
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
