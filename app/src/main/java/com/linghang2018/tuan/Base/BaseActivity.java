package com.linghang2018.tuan.Base;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

/**
 * @author: Gong Yunhao
 * @version: V1.0
 * @date: 2018/7/14
 * @github https://github.com/GongYunHaoyyy
 * @blog https://www.jianshu.com/u/52a8fa1f29fb
 */
public abstract class BaseActivity extends AppCompatActivity{

    private ActivityManager mActivityManager = ActivityManager.getActivityManager();
    private Activity mthis;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        mthis=this;
        setFullScreen();
        setContentView();
        findViewById();
        initDate();
        initListener();
        if(null != mActivityManager) {
            mActivityManager.putActivity(this);
        }
    }

    public abstract void setContentView();

    public abstract void initListener();

    public abstract void findViewById();

    public abstract void initDate();

    private void setFullScreen() {
        View view = getWindow().getDecorView();
        int options = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
        view.setSystemUiVisibility(options);
        getWindow().setStatusBarColor( Color.TRANSPARENT);
    }

    @Override
    protected void onDestroy() {
        if(null != mActivityManager) {
            mActivityManager.removeActivity(this);
        }
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume( );
    }

    @Override
    protected void onStop() {
        super.onStop( );
    }

    @Override
    protected void onPause() {
        super.onPause( );
    }

    @Override
    protected void onStart() {
        super.onStart( );
    }

    public Toast toast;
    public void showToast(String text) {
        if (toast == null) {
            toast = Toast.makeText(mthis, text, Toast.LENGTH_SHORT);
        } else {
            toast.setText(text);
        }
        toast.show();
    }
    public void showToast(int textId) {
        showToast(getString(textId));
    }

}
