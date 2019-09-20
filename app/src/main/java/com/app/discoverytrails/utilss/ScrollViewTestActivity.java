package com.app.discoverytrails.utilss;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;
import android.widget.Toast;

import com.app.discoverytrails.R;

public class ScrollViewTestActivity extends AppCompatActivity {

    ScrollView scroll_view;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view_test);


        scroll_view = findViewById(R.id.scroll_view);


        scroll_view.getViewTreeObserver()
                .addOnScrollChangedListener(() -> {
                    if (!scroll_view.canScrollVertically(1)) {
                        // bottom of scroll view


                        Toast.makeText(ScrollViewTestActivity.this, "Bottom", Toast.LENGTH_SHORT).show();

                    }
                    if (!scroll_view.canScrollVertically(-1)) {
                        // top of scroll view
                        Toast.makeText(ScrollViewTestActivity.this, "Top", Toast.LENGTH_SHORT).show();

                    }
                });
    }
}
