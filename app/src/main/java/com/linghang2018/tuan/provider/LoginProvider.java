package com.linghang2018.tuan.provider;

import android.app.Activity;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * 登录界面功能接口定义
 * @author: Gong Yunhao
 * @version: V1.0
 * @date: 2018/7/15
 * @github https://github.com/GongYunHaoyyy
 * @blog https://www.jianshu.com/u/52a8fa1f29fb
 */
public interface LoginProvider extends IProvider{
    void goToLogin(Activity activity);
    void doLogin(Activity activity);
}
