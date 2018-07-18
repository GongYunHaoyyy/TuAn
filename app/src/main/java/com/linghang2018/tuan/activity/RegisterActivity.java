package com.linghang2018.tuan.activity;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.linghang2018.tuan.base.BaseActivity;
import com.linghang2018.tuan.R;

public class RegisterActivity extends BaseActivity implements View.OnClickListener{

    private ImageButton imageButtonBackToLogin;
    private CheckBox agreeCheckBox;
    private EditText phoneEditText, captureEditText, passWordEditText;
    private ValueAnimator valueAnimator;
    private Button getCaptureButton, registerButton;
    private String tempPhone, tempCapture, tempPassWord;

    @Override
    public void setContentView() {
        setContentView(R.layout.activity_register);
    }

    @Override
    public void initListener() {
        imageButtonBackToLogin.setOnClickListener(this);
        getCaptureButton.setOnClickListener(this);
        registerButton.setOnClickListener(this);
        passWordEditText.addTextChangedListener( new TextWatcher( ) {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                checkRegisterEnable();
            }
        } );
        captureEditText.addTextChangedListener( new TextWatcher( ) {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                checkRegisterEnable();
            }
        } );
        phoneEditText.addTextChangedListener( new TextWatcher( ) {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void afterTextChanged(Editable editable) {
                checkRegisterEnable();
            }
        } );
    }

    @Override
    public void findViewById() {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        imageButtonBackToLogin = (ImageButton) findViewById(R.id.back_to_login);
        getCaptureButton = (Button)findViewById(R.id.get_capture);
        phoneEditText = (EditText)findViewById(R.id.phone);
        captureEditText = (EditText)findViewById(R.id.capture);
        passWordEditText = (EditText)findViewById(R.id.password);
        registerButton = (Button)findViewById(R.id.register_button);
        agreeCheckBox = (CheckBox)findViewById(R.id.agree_checkBox);
    }

    @Override
    public void initDate() {
        valueAnimator = ValueAnimator.ofInt(0, 60);
        valueAnimator.setDuration(60000);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int currentValue = 60 - (int)animation.getAnimatedValue();
                if (currentValue == 0){
                    getCaptureButton.setTextColor(getResources().getColor(R.color.colorCaptureEnable));
                    getCaptureButton.setText("获取验证码");
                    getCaptureButton.setEnabled(true);
                }else {
                    getCaptureButton.setText(currentValue+"秒后重试");
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back_to_login:
                finish();
                break;
            case R.id.get_capture:
                tempPhone = phoneEditText.getText().toString();
                if (tempPhone.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "请填入电话号码", Toast.LENGTH_SHORT).show();
                }else {
                    valueAnimator.start();
                    getCaptureButton.setTextColor(getResources().getColor(R.color.colorCaptureDisable));
                    getCaptureButton.setEnabled(false);
                }

                break;
            case R.id.register_button:

                tempPhone = phoneEditText.getText().toString();
                tempCapture = captureEditText.getText().toString();
                tempPassWord = passWordEditText.getText().toString();
                if (!tempPhone.isEmpty()&&!tempCapture.isEmpty()&&!tempPassWord.isEmpty()){
                }else {
                    Toast.makeText(RegisterActivity.this, "把信息填取完整", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;

        }
    }

    private void checkRegisterEnable(){
        if (!TextUtils.isEmpty( phoneEditText.getText().toString()) && !TextUtils.isEmpty(captureEditText.getText().toString()) && !TextUtils.isEmpty(passWordEditText.getText().toString())){
            registerButton.setEnabled( true );
        }else {
            registerButton.setEnabled( false );
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        valueAnimator.cancel();
    }
}
