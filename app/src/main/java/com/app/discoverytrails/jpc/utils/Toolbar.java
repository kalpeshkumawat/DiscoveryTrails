package com.app.discoverytrails.jpc.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.discoverytrails.R;

public class Toolbar extends androidx.appcompat.widget.Toolbar implements View.OnClickListener {


    private ImageView imgBack, imgRight;
    private TextView tvtitle;

    private View.OnClickListener backClickListener, rightImageClickListener;

    private boolean hasBack = true;
    private boolean hasRight = true;


    public Toolbar(final Context context) {
        this(context, null);
    }

    public Toolbar(final Context context, final AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Toolbar(final Context context, final AttributeSet attrs, final int defStyle) {
        super(context, attrs, defStyle);

        if (!isInEditMode()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                setLayerType(View.LAYER_TYPE_HARDWARE, null);
            }
        }

        setId(R.id.toolbar);
        setFocusable(true);
        setFocusableInTouchMode(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setElevation(0);
        }

        LayoutInflater.from(getContext()).inflate(R.layout.custom_toolbar, this, true);

        imgBack = findViewById(R.id.iv_back);
        imgRight = findViewById(R.id.iv_right_img);
        tvtitle = findViewById(R.id.tv_header);


        final TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.toolbar);

        if (array != null) {

            String textTitle = array.getString(R.styleable.toolbar_toolbar_title);

            boolean hasBack = array.getBoolean(R.styleable.toolbar_toolbar_hasBack, true);
            boolean hasRight = array.getBoolean(R.styleable.toolbar_toolbar_hasRight, false);

            array.recycle();

            setTitle(textTitle);
            setHasBack(hasBack);
            setHasRight(hasRight);


        }

        imgBack.setOnClickListener(this);
        imgRight.setOnClickListener(this);

    }


    public void setTitle(String textTitle) {
        if (textTitle == null)
            textTitle = "";
        tvtitle.setText(textTitle);
    }


    public void performBack() {
        imgBack.performClick();
    }

    public void setHasBack(boolean hasBack) {
        if (hasBack)
            imgBack.setVisibility(View.VISIBLE);
        else
            imgBack.setVisibility(View.GONE);
    }

    public void setHasRight(boolean hasRight) {
        if (hasRight)
            imgRight.setVisibility(View.VISIBLE);
        else
            imgRight.setVisibility(View.GONE);
    }


    public void setBackClickListener(View.OnClickListener onClickListener) {
        this.backClickListener = onClickListener;
    }


    public void setRighClickListener(View.OnClickListener onClickListener) {
        this.rightImageClickListener = onClickListener;
    }

    @Override
    public void onClick(View view) {
        if (view == imgBack) {
            if (backClickListener != null) {
                backClickListener.onClick(view);
            }
        } else if (view == imgRight) {
            if (rightImageClickListener != null) {
                rightImageClickListener.onClick(view);
            }
        }
    }


}
