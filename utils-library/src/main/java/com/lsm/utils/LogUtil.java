package com.lsm.utils;

import android.util.Log;

import com.lsm.utils.Activity.ActivityManager;

/**
 * 系统日志输出工具类
 * Created by lsm on 2018/1/12.
 */
public class LogUtil {
    //是否输出
    private static boolean isDebug = true;

    /**
     * 设置debug模式(true:打印日志  false：不打印)
     */
    public static void setIsDebug(boolean isDebug){
        LogUtil.isDebug = isDebug;
    }
    
    public static void i(String tag,String msg){
        if(isDebug){
            Log.i(tag, msg != null ? msg : "");
        }
    }
    public static void i(Object object,String msg){
        if(isDebug){
            Log.i(object.getClass().getSimpleName(), msg != null ? msg : "");
        }
    }

    public static void i(String msg){
        if(isDebug){
            Log.i(ActivityManager.getInstance().getCurrentActivityName(), msg != null ? msg : "");
        }
    }

    public static void d(String tag,String msg){
        if(isDebug){
            Log.d(tag, msg != null ? msg : "");
        }
    }

    public static void d(Object object,String msg){
        if(isDebug){
            Log.d(object.getClass().getSimpleName(), msg != null ? msg : "");
        }
    }

    public static void d(String msg){
        if(isDebug){
            Log.d(ActivityManager.getInstance().getCurrentActivityName(), msg != null ? msg : "");
        }
    }

    public static void w(String tag,String msg){
        if(isDebug){
            Log.w(tag, msg != null ? msg : "");
        }
    }

    public static void w(Object object,String msg){
        if(isDebug){
            Log.w(object.getClass().getSimpleName(), msg != null ? msg : "");
        }
    }

    public static void w(String msg){
        if(isDebug){
            Log.w(ActivityManager.getInstance().getCurrentActivityName(), msg != null ? msg : "");
        }
    }

    public static void e(String tag,String msg){
        if(isDebug){
            Log.e(tag, msg !=null ? msg : "");
        }
    }

    public static void e(Object object,String msg){
        if(isDebug){
            Log.e(object.getClass().getSimpleName(), msg !=null ? msg : "");
        }
    }

    public static void e(String msg){
        if(isDebug){
            Log.e(ActivityManager.getInstance().getCurrentActivityName(), msg !=null ? msg : "");
        }
    }

    public static void v(String tag, String msg){
        if(isDebug){
            Log.v(tag, msg != null ? msg : "");
        }
    }

    public static void v(Object object, String msg){
        if(isDebug){
            Log.v(object.getClass().getSimpleName(), msg != null ? msg : "");
        }
    }

    public static void v( String msg){
        if(isDebug){
            Log.v(ActivityManager.getInstance().getCurrentActivityName(), msg != null ? msg : "");
        }
    }
}