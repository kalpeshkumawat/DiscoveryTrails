package com.app.discoverytrails;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.app.discoverytrails.nav.ImapNavActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class DashFragment extends Fragment {


    private Button btn1,btn2,btn3;


    public DashFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dash, container, false);


        btn1 = view.findViewById(R.id.btn_onn);
        btn2 = view.findViewById(R.id.btn_two);
        btn3 = view.findViewById(R.id.btn_three);

        btn1.setOnClickListener(view1 -> ImapNavActivity.replace(view1,1));

        btn2.setOnClickListener(view12 -> ImapNavActivity.replace(view12, 2));


        btn3.setOnClickListener(view13 -> ImapNavActivity.replace(view13, 3));

        return view;
    }

}
