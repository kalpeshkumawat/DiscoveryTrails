package com.app.discoverytrails.nav;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.app.discoverytrails.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class OneFragment extends Fragment {


    public OneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_one, container, false);



        Button button = view.findViewById(R.id.btn_99);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_oneFragment_to_threeFragment);

            }
        });

        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getArguments() != null) {


            String app_name = getArguments().getString("app_name");

            Toast.makeText(getActivity(), ""+app_name, Toast.LENGTH_SHORT).show();

        }
    }
}
