package com.linghang2018.tuan.RService;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.linghang2018.tuan.Activity.LoginActivity;
import com.linghang2018.tuan.Provider.LoginProvider;
import com.linghang2018.tuan.RouterPath;

/**
 * @author: Gong Yunhao
 * @version: V1.0
 * @date: 2018/7/15
 * @github https://github.com/GongYunHaoyyy
 * @blog https://www.jianshu.com/u/52a8fa1f29fb
 */
@Route( path = RouterPath.ROUTE_PATH_LOGIN_SERVICE, name = "登录界面")
public class LoginService implements LoginProvider{

    @Override
    public void init(Context context) {

    }

    @Override
    public void goToLogin(Activity activity) {
        Intent intentLogin = new Intent( activity, LoginActivity.class );
        activity.startActivity( intentLogin );
        activity.finish();
    }

    @Override
    public void doLogin(Activity activity) {
        //登录操作实现
    }
}
