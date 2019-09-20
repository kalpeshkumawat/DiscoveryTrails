package com.app.discoverytrails.base;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.discoverytrails.R;
import com.app.discoverytrails.databinding.RowUserAddressBinding;
import com.app.discoverytrails.details.User;

import java.util.ArrayList;

public class UserAddressActivity extends AppCompatActivity {


    RecyclerView recycler_view;
    BaseAdapter myAdapter;
    ArrayList<User> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_address);


        for (int i = 0; i < 10; i++) {

            User user = new User();
            user.setEmail("Email nu. : " + i + "Kal");
            user.setPassword("Password  nu. : " + i + "pesh");

            users.add(user);
        }


        recycler_view = findViewById(R.id.recycler_view);


        recycler_view.setHasFixedSize(true);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));


        myAdapter = new BaseAdapter(this, R.layout.row_user_address) {
            @Override
            public void onBindViewHold(RecyclerView.ViewHolder viewHolder, Object itemView) {


                RowUserAddressBinding rowUserAddressBinding = (RowUserAddressBinding) getmViewDataBinding();

                rowUserAddressBinding.setUser((User) itemView);

                rowUserAddressBinding.tvUserName.setOnClickListener(view -> {

                    int position = viewHolder.getAdapterPosition();

                    Log.d("44444444444 click", " ---     " + position);

                    myAdapter.remove(itemView);


                });

            }
        };


        myAdapter.setItems(users);


        recycler_view.setAdapter(myAdapter);


    }


}
