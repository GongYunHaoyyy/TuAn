package com.linghang2018.tuan.RService;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.linghang2018.tuan.Activity.RegisterActivity;
import com.linghang2018.tuan.Provider.RegisterProvider;
import com.linghang2018.tuan.RouterPath;

/**
 * @author: Gong Yunhao
 * @version: V1.0
 * @date: 2018/7/15
 * @github https://github.com/GongYunHaoyyy
 * @blog https://www.jianshu.com/u/52a8fa1f29fb
 */
@Route( path = RouterPath.ROUTE_PATH_REGISTER_SERVICE, name = "注册界面")
public class RegisterService implements RegisterProvider{
    @Override
    public void goToRegister(Activity activity) {
        Intent intentRegister = new Intent( activity, RegisterActivity.class );
        activity.startActivity( intentRegister );
//        activity.finish();
    }

    @Override
    public void init(Context context) {

    }
}
