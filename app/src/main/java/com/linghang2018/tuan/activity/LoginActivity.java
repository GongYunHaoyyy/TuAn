package com.linghang2018.tuan.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.linghang2018.tuan.base.BaseActivity;
import com.linghang2018.tuan.provider.MainProvider;
import com.linghang2018.tuan.provider.RegisterProvider;
import com.linghang2018.tuan.R;
import com.linghang2018.tuan.RouterPath;

public class LoginActivity extends BaseActivity implements View.OnClickListener{
//    加上下面这句就会出未知的报错，注意
//    @Autowired(name = RouterPath.ROUTE_PATH_REGISTER_SERVICE)
    private RegisterProvider registerService;
    private MainProvider mainSerivce;

    private Button login;
    private EditText phone,password;
    private TextView register;
    private String strphone=null,strpassword=null;
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
        login.setOnClickListener( this );
        phone.addTextChangedListener( new TextWatcher( ) {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void afterTextChanged(Editable editable) {
                checkLoginEnable();
            }
        } );
        password.addTextChangedListener( new TextWatcher( ) {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void afterTextChanged(Editable editable) {
                checkLoginEnable();
            }
        } );
    }

    @Override
    public void findViewById() {
        register=findViewById( R.id.tv_register );
        login = findViewById( R.id.bt_login );
        phone = findViewById( R.id.account );
        password = findViewById( R.id.password );
    }

    @Override
    public void initDate() {
        registerService =(RegisterProvider) ARouter.getInstance().build( RouterPath.ROUTE_PATH_REGISTER_SERVICE ).navigation();
        mainSerivce = (MainProvider) ARouter.getInstance().build( RouterPath.ROUTE_PATH_MAIN_SERVICE ).navigation();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_register:
                registerService.goToRegister( LoginActivity.this );
                break;
            case R.id.bt_login:
                //登录
                mainSerivce.goToMain( LoginActivity.this );
                break;
                default:
        }
    }

    private void checkLoginEnable(){
        if (!TextUtils.isEmpty( phone.getText().toString()) && !TextUtils.isEmpty( password.getText().toString() )){
            login.setEnabled( true );
        }else {
            login.setEnabled( false );
        }
    }

}
