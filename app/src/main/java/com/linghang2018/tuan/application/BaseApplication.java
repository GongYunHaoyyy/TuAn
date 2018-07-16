package com.linghang2018.tuan.application;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;

import org.litepal.LitePal;

/**
 * @author: Gong Yunhao
 * @version: V1.0
 * @date: 2018/7/14
 * @github https://github.com/GongYunHaoyyy
 * @blog https://www.jianshu.com/u/52a8fa1f29fb
 */
public class BaseApplication extends Application{

    @SuppressLint("StaticFieldLeak")
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate( );
        mContext=this;
        // These two lines must be written before init, otherwise these configurations will be invalid in the init process
        ARouter.openLog();     // Print log
        ARouter.openDebug();   // Turn on debugging mode (If you are running in InstantRun mode, you must turn on debug mode! Online version needs to be closed, otherwise there is a security risk)
        ARouter.init( this );
        //Litepal初始化
//        LitePal.initialize(this);
        //Litepal创建表
//        LitePal.getDatabase();
    }

    public static Context getContext(){
        return mContext;
    }

}
