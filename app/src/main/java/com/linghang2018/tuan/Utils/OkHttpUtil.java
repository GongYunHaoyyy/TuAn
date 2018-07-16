package com.linghang2018.tuan.Utils;

import okhttp3.OkHttpClient;

/**
 * @author: Gong Yunhao
 * @version: V1.0
 * @date: 2018/7/16
 * @github https://github.com/GongYunHaoyyy
 * @blog https://www.jianshu.com/u/52a8fa1f29fb
 */
public class OkHttpUtil {
    private static OkHttpUtil mOkHttpUtil;
    private OkHttpClient mClient;

    private OkHttpUtil(){
        mClient = new OkHttpClient();
    }

    public synchronized static OkHttpUtil getInstance() {
        if ( mOkHttpUtil== null) {
            mOkHttpUtil = new OkHttpUtil();
        }
        return mOkHttpUtil;
    }



}
