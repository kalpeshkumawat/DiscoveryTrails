package com.app.discoverytrails;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.app.discoverytrails.databinding.ActivityMainBinding;
import com.blankj.utilcode.util.FragmentUtils;
import com.demo.mylibs.CalC;

public class MainActivity extends AppCompatActivity {



    private ActivityMainBinding mBinding;

    static {
        System.loadLibrary("native-lib");
    }
//
    private native String invokeNativeFunction();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);


        FragmentUtils.add(getSupportFragmentManager(), LoginFragment.newInstance(), R.id.frame_layout);

        Context mContext = getApplicationContext();

        // Some super API call using that key
        Log.i("eeeeeeeeeeeeeeeeeee", "key: " + invokeNativeFunction());


        TextView textView = null;


        textView.setText("Teachedf");
    }


}
