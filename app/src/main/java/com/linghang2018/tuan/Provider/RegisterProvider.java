package com.linghang2018.tuan.Provider;

import android.app.Activity;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * @author: Gong Yunhao
 * @version: V1.0
 * @date: 2018/7/15
 * @github https://github.com/GongYunHaoyyy
 * @blog https://www.jianshu.com/u/52a8fa1f29fb
 */
public interface RegisterProvider extends IProvider{
    void goToRegister(Activity activity);
}
