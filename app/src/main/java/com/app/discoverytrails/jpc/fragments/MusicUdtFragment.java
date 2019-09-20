package com.app.discoverytrails.jpc.fragments;

import android.os.Bundle;
import android.view.View;

import com.app.discoverytrails.R;
import com.app.discoverytrails.jpc.base.BaseFragment;
import com.app.discoverytrails.jpc.viewmodels.MusicUdtViewModel;

public class MusicUdtFragment extends BaseFragment {

    private MusicUdtViewModel mViewModel;

    public static MusicUdtFragment newInstance() {
        return new MusicUdtFragment();
    }


    @Override
    public int setContentLayout() {
        return R.layout.music_udt_fragment;
    }

    @Override
    public Class setViewModelClass() {
        return MusicUdtViewModel.class;
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
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mViewModel = (MusicUdtViewModel) getViewModel();
    }
}
