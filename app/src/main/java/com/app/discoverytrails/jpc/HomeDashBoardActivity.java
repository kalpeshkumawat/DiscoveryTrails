package com.app.discoverytrails.jpc;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.app.discoverytrails.R;
import com.app.discoverytrails.jpc.base.BaseActivity;
import com.app.discoverytrails.jpc.fragments.FavoritesUdtFragment;
import com.app.discoverytrails.jpc.fragments.MusicUdtFragment;
import com.app.discoverytrails.jpc.fragments.SchedulesUdtFragment;
import com.app.discoverytrails.jpc.viewmodels.HomeDashboardModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeDashBoardActivity extends BaseActivity {


    private HomeDashboardModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = (HomeDashboardModel) getViewModel();

        setFragment(new FavoritesUdtFragment());
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        Fragment fragment;
        switch (item.getItemId()) {
            case R.id.action_favorites:

                fragment = new FavoritesUdtFragment();

                setFragment(fragment);
                return true;
            case R.id.action_schedules:

                fragment = new SchedulesUdtFragment();
                setFragment(fragment);

                return true;
            case R.id.action_music:

                fragment = new MusicUdtFragment();
                setFragment(fragment);

                return true;



        }
        return false;
    };

    protected void setFragment(Fragment fragment) {
        FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        t.replace(R.id.frame_container, fragment);
        t.commit();
    }

    @Override
    public int setContentLayout() {
        return R.layout.activity_home_dash_board;
    }

    @Override
    public Class setViewModelClass() {
        return HomeDashboardModel.class;
    }


}
