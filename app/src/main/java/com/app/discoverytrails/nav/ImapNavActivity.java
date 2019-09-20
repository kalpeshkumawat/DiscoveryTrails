package com.app.discoverytrails.nav;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.FragmentNavigator;
import androidx.navigation.ui.NavigationUI;

import com.app.discoverytrails.DashFragmentDirections;
import com.app.discoverytrails.R;

public class ImapNavActivity extends AppCompatActivity {


    private static NavController navController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imap_nav);



        navController = Navigation.findNavController(this,R.id.my_nav_host_fragment);

    }

    public static void change(){

        navController.popBackStack();
    }

    public static NavOptions getNavOptions() {

        NavOptions navOptions = new NavOptions.Builder()
                .setEnterAnim(R.anim.slide_in_right)
                .setExitAnim(R.anim.slide_out_left)
                .setPopEnterAnim(R.anim.slide_in_left)
                .setPopExitAnim(R.anim.slide_out_right)
                .build();

        return navOptions;
    }

    public static void replace(View view1, int code) {

        if (code == 1) {


            Bundle bundle = new Bundle();
            bundle.putString("app_name","UBER");
            bundle.putString("des","2378");

            navController.navigate(R.id.action_dashFragment_to_oneFragment,bundle);



        } else if (code == 2) {

            navController.navigate(R.id.action_dashFragment_to_twoFragment,null,getNavOptions());



        } else if (code == 3) {


            DashFragmentDirections.ActionDashFragmentToThreeFragment fragment = DashFragmentDirections.actionDashFragmentToThreeFragment();



            fragment.setUserId(200);
            fragment.setUserName("update rey");




            navController.navigate(fragment);
//




        }

    }




}
