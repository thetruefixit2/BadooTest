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
import com.dabe.baddooooo.model.data.local.Transaction;
import com.dabe.baddooooo.view.views.ITransactionView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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

    private TransactionAdapter adapter;

    public static TransactionsListFragment newInstance(String sku) {
        Bundle args = new Bundle();
        TransactionsListFragment fragment = new TransactionsListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_transaction_list, container, false);
        ButterKnife.bind(this, view);
        initUI(view);
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

    }

    private void initData() {
        onTransactionUpdate(mockTransactions());
    }

    @Override
    public void onTransactionUpdate(List<Transaction> transactions) {
        adapter.updateData(transactions);
    }

    @Override
    public void onSkuUpdated(String sku) {

    }

    public List<Transaction> mockTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            transactions.add(new Transaction("SKU" + i, "USD", new BigDecimal(10d), new BigDecimal(11.355d)));
        }
        return transactions;
    }
}
