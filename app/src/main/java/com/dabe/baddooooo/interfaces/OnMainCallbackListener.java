package com.dabe.baddooooo.interfaces;

import com.dabe.baddooooo.view.views.IBaseView;

/**
 * Created by Daniil Belevtsev
 * Project: Baddooooo; Skype: pandamoni1
 */

public interface OnMainCallbackListener extends IBaseView {

    void onProductSelected(String sku);

    void onTitleUpdate(String title);

}
