package com.app.discoverytrails.nav;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.app.discoverytrails.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ThreeFragment extends Fragment {


    public ThreeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_three, container, false);

        Button btn_click = view.findViewById(R.id.btn_click);


        ThreeFragmentArgs threeFragmentArgs = ThreeFragmentArgs.fromBundle(getArguments());

        String userName = threeFragmentArgs.getUserName();

        int userId = threeFragmentArgs.getUserId();


        String ss = "User Id : "+userId+"\n"+
                "User Name : "+userName;


        Toast.makeText(getActivity(), ""+ss, Toast.LENGTH_SHORT).show();


        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ImapNavActivity.change();
            }
        });

        return view;
    }

}
