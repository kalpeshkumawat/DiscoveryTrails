package com.app.discoverytrails.jpc.base;

import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import javax.inject.Inject;

public abstract class BaseActivity extends AppCompatActivity {

    private ViewModel viewModel;

    private ViewDataBinding viewDataBinding;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (setViewModelClass() != null) {
            viewModel = ViewModelProviders.of(this, viewModelFactory).get(setViewModelClass());
        }

        viewDataBinding = DataBindingUtil.setContentView(this, setContentLayout());


    }

    public abstract @LayoutRes
    int setContentLayout();

    public abstract Class setViewModelClass();

    public ViewModel getViewModel() {
        return viewModel;
    }


    public ViewDataBinding getBinding() {
        return viewDataBinding;
    }

}
