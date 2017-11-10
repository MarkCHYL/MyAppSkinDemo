package com.view.mark.myskinviewdemo2;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

/**
 * Created by mark on 2017/11/10.
 * $desc$
 * Mail: 2285581945@qq.com
 */

public class MyApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        // 默认设置为日间模式
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        /*
         *  1、MODE_NIGHT_NO： 使用亮色(light)主题，不使用夜间模式；
         *
         *  2、MODE_NIGHT_YES：使用暗色(dark)主题，使用夜间模式；
         *
         *  3、MODE_NIGHT_AUTO：根据当前时间自动切换 亮色(light)/暗色(dark)主题；
         *
         *  4、MODE_NIGHT_FOLLOW_SYSTEM(默认选项)：设置为跟随系统，通常为 MODE_NIGHT_NO
         * */

    }
}
