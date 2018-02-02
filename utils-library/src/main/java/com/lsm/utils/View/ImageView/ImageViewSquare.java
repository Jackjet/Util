package com.lsm.utils.View.ImageView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

/**
 * 正方形的ImageView
 * 高度和宽度一样
 * Created by lsm on 2018/1/4.
 */
public class ImageViewSquare extends AppCompatImageView {

    public ImageViewSquare(@NonNull Context context) {
        super(context);
    }

    public ImageViewSquare(@NonNull Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ImageViewSquare(@NonNull Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(getDefaultSize(0, widthMeasureSpec), getDefaultSize(0, heightMeasureSpec));
        int childWidthSize = getMeasuredWidth();
        //高度和宽度一样
        heightMeasureSpec = widthMeasureSpec = MeasureSpec.makeMeasureSpec(childWidthSize, MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}