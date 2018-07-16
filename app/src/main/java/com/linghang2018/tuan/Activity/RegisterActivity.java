package com.linghang2018.tuan.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.linghang2018.tuan.Base.BaseActivity;
import com.linghang2018.tuan.R;

public class RegisterActivity extends BaseActivity {

    public static Intent newIntent(Context context){
        Intent intent = new Intent(context,RegisterActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
    }

    @Override
    public void setContentView() {
        setContentView( R.layout.activity_register );
    }

    @Override
    public void initListener() {

    }

    @Override
    public void findViewById() {

    }

    @Override
    public void initDate() {

    }
}
