package com.dabe.baddooooo.view.ui.activities;

import com.dabe.baddooooo.view.ui.fragments.ProductListFragment;
import com.dabe.baddooooo.view.ui.fragments.TransactionsListFragment;

/**
 * Created by Daniil Belevtsev
 * Project: SkyApp; Skype: pandamoni1
 * Activity that control transactions between screens(fragment switching)
 */

public class RouteActivity extends FragmentActivity {

    protected void showProductScreen() {
        replaceFragment(ProductListFragment.newInstance(), false);
    }

    protected void showTransactionsScreen(String sku) {
        replaceFragment(TransactionsListFragment.newInstance(sku), true);
    }
}
