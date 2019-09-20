package com.app.discoverytrails.jpc.fragments;

import android.os.Bundle;
import android.view.View;

import com.app.discoverytrails.R;
import com.app.discoverytrails.jpc.base.BaseFragment;
import com.app.discoverytrails.jpc.viewmodels.SchedulesUdtViewModel;

public class SchedulesUdtFragment extends BaseFragment {

    private SchedulesUdtViewModel mViewModel;

    public static SchedulesUdtFragment newInstance() {
        return new SchedulesUdtFragment();
    }


    @Override
    public int setContentLayout() {
        return R.layout.schedules_udt_fragment;
    }

    @Override
    public Class setViewModelClass() {
        return SchedulesUdtViewModel.class;
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

        mViewModel = (SchedulesUdtViewModel) getViewModel();
    }
}
