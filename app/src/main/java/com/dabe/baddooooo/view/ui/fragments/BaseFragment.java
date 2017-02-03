package com.dabe.baddooooo.view.ui.fragments;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.dabe.baddooooo.interfaces.OnMainCallbackListener;

/**
 * Created by Daniil Belevtsev
 * Project: Baddooooo; Skype: pandamoni1
 */

public class BaseFragment extends Fragment {

    private OnMainCallbackListener activityCallback;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnMainCallbackListener) {
            activityCallback = (OnMainCallbackListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnMainCallbackListener");
        }
    }

    public OnMainCallbackListener getActivityCallback() {
        return activityCallback;
    }
}
