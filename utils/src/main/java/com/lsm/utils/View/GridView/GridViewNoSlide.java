package com.lsm.utils.View.GridView;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 *  不可滑动的GridView
 *  用于ListView、GridView、RecyclerView中嵌套GridView时使用
 *  Created by lsm on 2018/1/4.
 */
public class GridViewNoSlide extends GridView {

    public GridViewNoSlide(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GridViewNoSlide(Context context) {
        super(context);
    }

    public GridViewNoSlide(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int expandSpec = MeasureSpec.makeMeasureSpec(
                Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}