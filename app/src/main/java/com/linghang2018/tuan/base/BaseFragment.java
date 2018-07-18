package com.linghang2018.tuan.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment {

    private View mView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (mView==null){
            mView = inflaterView(inflater,container,savedInstanceState);
        }
        ViewGroup mViewParent = (ViewGroup)mView.getParent();
        if (mViewParent!=null){
            mViewParent.removeView(mView);
        }

        initView(mView);
        setListener();
        return mView;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
        initData();
    }

    protected abstract View inflaterView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    protected abstract void initData();

    protected abstract void setListener();

    protected abstract void initView(View view);

}
