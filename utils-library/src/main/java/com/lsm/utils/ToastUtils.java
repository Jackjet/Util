package com.lsm.utils;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

/**
 * Toast显示
 * Created by lsm on 2018/1/1.
 */
public class ToastUtils {
	private static Toast toast1 = null;
	private static Toast toast2 = null;
	private static Toast toastView = null;

	/**
	 * 短Toast，默认位置
	 * @param context
	 * @param message
	 */
    public static void showShortToast(Context context, String message){
    	if (toast1 == null) {
    		 toast1 = Toast.makeText(context, message, Toast.LENGTH_SHORT);
    	}else {
    		toast1.setText(message);
    	}
    	toast1.show();
    }

	/**
	 * 长Toast，默认位置
	 * @param context
	 * @param message
	 */
    public static void showLongToast(Context context, String message){
    	if (toast1 == null) {
    		 toast1 = Toast.makeText(context, message, Toast.LENGTH_LONG);
    	}else {
    		toast1.setText(message);
    	}
    	toast1.show();
    }

	/**
	 * 短Toast，屏幕中心位置
	 * @param context
	 * @param message
	 */
	public static void showShortCenterToast(Context context, String message) {
		if (context != null) {
			if (toast2 == null) {
				toast2 = Toast.makeText(context, message, Toast.LENGTH_LONG);
			}else {
				toast2.setText(message);
			}
			toast2.setGravity(Gravity.CENTER, 0, 0);
			toast2.show();
		}
	}
	/**
	 * 长Toast，屏幕中心位置
	 * @param context
	 * @param message
	 */
	public static void showLongCenterToast(Context context, String message) {
		if (context != null) {
			if (toast2 == null) {
				toast2 = Toast.makeText(context, message, Toast.LENGTH_LONG);
			}else {
				toast2.setText(message);
			}
			toast2.setGravity(Gravity.CENTER, 0, 0);
			toast2.show();
		}
	}
	public static void showView(Context context, int resource) {
		View view = LayoutInflater.from(context).inflate(resource, null);
		if (toastView == null) {
			toastView = new Toast(context);
		}
		toastView.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
		toastView.setDuration(Toast.LENGTH_SHORT);
		toastView.setView(view);
		toastView.show();
	}
	/**
	 * 取消显示Toast
	 *
	 */
	public static void cancelToast() {
		if (null != toast1) {
			toast1.cancel();
		}
		if (null != toast2) {
			toast2.cancel();
		}
	}
}
