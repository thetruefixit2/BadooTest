package com.dabe.baddooooo.view.ui.activities;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;


/**
 * Created by Daniil Belevtsev on 25.01.2017 22:36.
 * Project: SkyApp; Skype: pandamoni1
 */

public class FragmentActivity extends AppCompatActivity {

    private int container;

    protected void replaceFragment(Fragment fragment, boolean isAddBackstack) {
        String tag = fragment.getClass().getSimpleName();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(container, fragment, tag);
        if (isAddBackstack) {
            transaction.addToBackStack(tag);
        }
        transaction.commitAllowingStateLoss();
    }

    protected void replaceFragment(@IdRes int customContainer, Fragment fragment, boolean isAddBackstack) {
        String tag = fragment.getClass().getSimpleName();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(customContainer, fragment, tag);
        if (isAddBackstack) {
            transaction.addToBackStack(tag);
        }
        transaction.commitAllowingStateLoss();
    }

    protected void addFragment(Fragment fragment, boolean isAddBackstack) {
        String tag = fragment.getClass().getSimpleName();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(container, fragment, tag);
        if (isAddBackstack) {
            transaction.addToBackStack(tag);
        }
        transaction.commitAllowingStateLoss();
    }

    @SuppressWarnings("unchecked")
    protected <T extends Fragment> T findAddedFragment(Class<T> clazz) {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(clazz.getSimpleName());
        if (fragment != null && fragment.isAdded()) {
            return (((T) fragment));
        } else {
            return null;
        }
    }

    /**
     * Container setter for fragment control.
     * All activities should set container in onCreate after layout
     *
     * @param container
     */
    public void setContainer(int container) {
        this.container = container;
    }


}
