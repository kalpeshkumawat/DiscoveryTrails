package com.app.discoverytrails.jpc.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.app.discoverytrails.R;
import com.app.discoverytrails.jpc.base.BaseFragment;
import com.app.discoverytrails.jpc.viewmodels.FavoritesUdtViewModel;

public class FavoritesUdtFragment extends BaseFragment {

    private FavoritesUdtViewModel mViewModel;

    public static FavoritesUdtFragment newInstance() {
        return new FavoritesUdtFragment();
    }


    @Override
    public int setContentLayout() {
        return R.layout.favorites_udt_fragment;
    }

    @Override
    public Class setViewModelClass() {
        return FavoritesUdtViewModel.class;
    }


    @Override
    public Class setParentViewModelClass() {
        return null;
    }

    @Override
    public void setObservers() {

    }

    @Override
    public void removeObservers() {

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mViewModel = (FavoritesUdtViewModel) getViewModel();
    }
}
