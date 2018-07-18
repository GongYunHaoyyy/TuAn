package com.linghang2018.tuan.rservice;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.linghang2018.tuan.activity.MainActivity;
import com.linghang2018.tuan.provider.MainProvider;
import com.linghang2018.tuan.RouterPath;

/**
 * @author: Gong Yunhao
 * @version: V1.0
 * @date: 2018/7/16
 * @github https://github.com/GongYunHaoyyy
 * @blog https://www.jianshu.com/u/52a8fa1f29fb
 */

@Route( path = RouterPath.ROUTE_PATH_MAIN_SERVICE, name = "主界面")
public class MainService implements MainProvider{
    @Override
    public void goToMain(Activity activity) {
        Intent intentMain = new Intent( activity, MainActivity.class );
        activity.startActivity( intentMain );
        activity.finish();
    }

    @Override
    public void init(Context context) {

    }
}
