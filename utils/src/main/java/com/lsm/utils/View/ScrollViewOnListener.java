package com.lsm.utils.View;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * 带滚动监听的scrollview
 * Created by lsm on 2018/1/4.
 */
public class ScrollViewOnListener extends ScrollView {

	public interface ScrollViewListener {
		void onScrollChanged(ScrollViewOnListener scrollView, int x, int y, int oldx, int oldy);
	}

	@Nullable
    private ScrollViewListener scrollViewListener = null;

	public ScrollViewOnListener(Context context) {
		super(context);
	}

	public ScrollViewOnListener(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public ScrollViewOnListener(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public void setScrollViewListener(ScrollViewListener scrollViewListener) {
		this.scrollViewListener = scrollViewListener;
	}

	@Override
	protected void onScrollChanged(int x, int y, int oldx, int oldy) {
		super.onScrollChanged(x, y, oldx, oldy);
		if (scrollViewListener != null) {
			scrollViewListener.onScrollChanged(this, x, y, oldx, oldy);
		}
	}

}