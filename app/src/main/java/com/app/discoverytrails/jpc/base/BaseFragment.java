package com.app.discoverytrails.jpc.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

public abstract class BaseFragment extends Fragment {

    private ViewModel viewModel;
    private ViewModel parentViewModel;

    private ViewDataBinding viewDataBinding;


    public BaseFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (setViewModelClass() != null) {
            viewModel = ViewModelProviders.of(getActivity()).get(setViewModelClass());
        }

        if (setParentViewModelClass() != null) {
            parentViewModel = ViewModelProviders.of(this.getActivity()).get(setParentViewModelClass());
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        viewDataBinding = DataBindingUtil.inflate(inflater, setContentLayout(), container, false);

        return viewDataBinding.getRoot();

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }


    public abstract int setContentLayout();

    public abstract Class setViewModelClass();

    public abstract Class setParentViewModelClass();

    public abstract void setObservers();

    public abstract void removeObservers();


    public ViewModel getViewModel() {
        return viewModel;
    }

    public ViewModel getParentViewModel() {
        return parentViewModel;
    }


    public ViewDataBinding getBinding() {
        return viewDataBinding;
    }

}
