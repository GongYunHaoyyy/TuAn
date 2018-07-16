package com.linghang2018.tuan.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.launcher.ARouter;
import com.linghang2018.tuan.Base.BaseActivity;
import com.linghang2018.tuan.Provider.LoginProvider;
import com.linghang2018.tuan.Provider.RegisterProvider;
import com.linghang2018.tuan.R;
import com.linghang2018.tuan.RouterPath;
import com.linghang2018.tuan.Utils.LogUtil;

public class LoginActivity extends BaseActivity implements View.OnClickListener{
    @Autowired(name = RouterPath.ROUTE_PATH_REGISTER_SERVICE)
    RegisterProvider registerService;

    private Button register;
    private final String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

    }

    @Override
    public void setContentView() {
        setContentView( R.layout.activity_login );
    }

    @Override
    public void initListener() {
        register.setOnClickListener( this );
    }

    @Override
    public void findViewById() {
        register=findViewById( R.id.test_register );
    }

    @Override
    public void initDate() {
        registerService =(RegisterProvider) ARouter.getInstance().build( RouterPath.ROUTE_PATH_REGISTER_SERVICE ).navigation();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.test_register:
                LogUtil.d( TAG, "--------->点击了按钮" );
                registerService.goToRegister( LoginActivity.this );
                LogUtil.d( TAG, "--------->调用了registerService" );
                break;
                default:
        }
    }
}
