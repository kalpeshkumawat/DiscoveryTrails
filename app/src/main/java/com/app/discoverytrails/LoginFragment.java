package com.app.discoverytrails;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.app.discoverytrails.databinding.LoginFragmentBinding;
import com.app.discoverytrails.details.User;

public class LoginFragment extends Fragment implements LoginNavigator{

    private LoginViewModel mViewModel;


    private LoginFragmentBinding mBinding;


    private User user;


    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        Toast.makeText(getActivity(), "Login Fragment", Toast.LENGTH_SHORT).show();


        View inflate = inflater.inflate(R.layout.login_fragment, container, false);

        mBinding = DataBindingUtil.bind(inflate);



        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);


        mBinding.setLoginViewModel(mViewModel);

        mViewModel.loginNavigator = this;


        mViewModel.getUserInfo().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User usersss) {

                user = usersss;
            }
        });

    }



    @Override
    public void submitSuccess() {

        Toast.makeText(getActivity(), "Hello - "+user.getEmail(), Toast.LENGTH_SHORT).show();

    }
}
