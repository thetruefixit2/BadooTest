package com.dabe.baddooooo.view.views;

import com.dabe.baddooooo.model.data.local.Product;

import java.util.List;

/**
 * Created by Daniil Belevtsev
 * Project: Baddooooo; Skype: pandamoni1
 */

public interface IProductView {
    void onProductSelected(String sku);

    void onUpdateData(List<Product> products);

}
