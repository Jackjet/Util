package com.lsm.utils;

import android.app.Activity;
import android.content.Intent;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Activity跳转
 * Created by lsm on 2018/1/2.
 */
public class ActivitySkipUtil {

    public ActivitySkipUtil() {
        throw new UnsupportedOperationException("ActivitySkipUtil不能实例化");
    }

    /**
     * 功能描述:简单地Activity的跳转(不携带任何数据)
     * @param activity 发起跳转的Activity实例
     * @param cls 目标Activity实例
     */
    public static void skipAnotherActivity(Activity activity, Class<? extends Activity> cls) {
        Intent intent = new Intent(activity, cls);
        activity.startActivity(intent);
        activity.finish();
    }

    /**
     * 功能描述：带数据的Activity之间的跳转
     */
    public static void skipAnotherActivity(Activity activity, Class<? extends Activity> cls,
        Map<String, ? extends Object> map) {
        Intent intent = new Intent(activity, cls);
        Iterator<?> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            @SuppressWarnings("unchecked")
            Entry<String, Object> entry = (Entry<String, Object>) iterator
                .next();
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                intent.putExtra(key, (String) value);
            }
            if (value instanceof Boolean) {
                intent.putExtra(key, (boolean) value);
            }
            if (value instanceof Integer) {
                intent.putExtra(key, (int) value);
            }
            if (value instanceof Float) {
                intent.putExtra(key, (float) value);
            }
            if (value instanceof Double) {
                intent.putExtra(key, (double) value);
            }
        }
        activity.startActivity(intent);
    }

}
