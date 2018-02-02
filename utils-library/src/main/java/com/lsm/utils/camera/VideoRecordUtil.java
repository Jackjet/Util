package com.lsm.utils.camera;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 调用系统相机拍摄视频
 *
 * 使用前应先根据 sdk 版本进行权限申请
 * setTime(int time) 和 setRequestCode(int requestCode) 方法必须调用
 * 调用之后要在调用的 activity 的 onActivityResult 处理回调
 * resultCode == RESULT_OK 时才拍摄成功
 * Created by lsm on 2018/1/5.
 */
public class VideoRecordUtil {
   private static VideoRecordUtil videoRecordUtil;
    public static VideoRecordUtil with(){
        if (videoRecordUtil == null){
            videoRecordUtil = new VideoRecordUtil();
        }
        return videoRecordUtil;
    }
    private Activity activity;
    public VideoRecordUtil setContext(Activity activity){
        this.activity = activity;
        return videoRecordUtil;
    }

    /**
     * 录制最大时长
     * 单位：秒
     */
    private int time;
    public VideoRecordUtil setTime(int time){
        this.time = time;
        return videoRecordUtil;
    }

    /**
     * 照片质量
     */
    private int quality ;
    public VideoRecordUtil setQuality (int quality ){
        this.quality  = quality ;
        return videoRecordUtil;
    }

    /**
     * 设置是否全屏拍摄，默认全屏
     */
    private boolean screen = true;
    public VideoRecordUtil setScreen (boolean screen ){
        this.screen  = screen ;
        return videoRecordUtil;
    }

    /**
     * 设置activity回调码
     */
    private int requestCode;
    public VideoRecordUtil setRequestCode (int requestCode ){
        this.requestCode  = requestCode ;
        return videoRecordUtil;
    }

    /**
     * 获取视频文件
     */
    public File getFile(){
        return file;
    }

    /**
     * 获取视频Uri
     */
    public Uri getUri(){
        return fileUri;
    }
    /**
     * 启用系统相机录制
     */
    File file;
    Uri fileUri;
    public void Builder() {
        file = getOutputMediaFile();
        fileUri = Uri.fromFile(file);
        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
        intent.putExtra(MediaStore.EXTRA_DURATION_LIMIT, time);     //限制的录制时长 以秒为单位
//        intent.putExtra(MediaStore.EXTRA_SIZE_LIMIT, 1024*2);        //限制视频文件大小 以字节为单位
        if (quality != -1){
            intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, quality);      //设置拍摄的质量0~1
        }
        intent.putExtra(MediaStore.EXTRA_FULL_SCREEN, screen);        // 全屏设置
        activity.startActivityForResult(intent, requestCode);
    }
    /**
     * Create a File for saving an video
     * 创建一个保存视频的文件
     */
    private File getOutputMediaFile() {
        if (!Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            Toast.makeText(activity, "请检查SD卡！", Toast.LENGTH_SHORT).show();
            return null;
        }
        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), "Video");
        if (!mediaStorageDir.exists()) {
            mediaStorageDir.mkdirs();
        }
        // Create a media file name  创建一个媒体文件名
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File mediaFile = new File(mediaStorageDir.getPath() + File.separator + "VID_" + timeStamp + ".mp4");
        return mediaFile;
    }
}
