package com.app.discoverytrails;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.app.discoverytrails.details.User;

public class LoginViewModel extends ViewModel {


    public MutableLiveData<User> mUser;

    public LoginNavigator loginNavigator;


    public MutableLiveData<User> getUserInfo() {

        if (mUser == null) {

            mUser = new MutableLiveData<>();
        }

        return mUser;

    }


    public void onSubmitClicked() {

        User user = new User();
        user.setEmail("111111111111");
//        user.setPassword("222222222222");

        mUser.setValue(user);

        loginNavigator.submitSuccess();

    }

}
