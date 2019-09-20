package com.app.discoverytrails.cart;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.app.discoverytrails.R;

import java.util.List;

public class LifeActivity extends AppCompatActivity {


    public static final String TAG = "123456789 ---  ";


    LifeViewModel mViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life);

        mViewModel = ViewModelProviders.of(this).get(LifeViewModel.class);


        mViewModel.getStaticList().observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> strings) {


                Toast.makeText(LifeActivity.this, "" + strings.toString(), Toast.LENGTH_SHORT).show();

                Log.d(TAG, "onChanged: 333333333" + strings.toString());
            }
        });


    }


}
