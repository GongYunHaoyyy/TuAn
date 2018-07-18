package com.linghang2018.tuan.bgservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.linghang2018.tuan.util.LogUtil;
import com.linghang2018.tuan.util.PollingUtils;

public class PollingReceiver extends BroadcastReceiver {

    public static final String TAG = "PollingReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        LogUtil.d(TAG, "调用了onReceive" );
        PollingUtils.startExactAgain(context, 20, PollingReceiver.class, PollingUtils.ACTION);
        Intent i = PollingService.newIntent(context);
        context.startService(i);
    }
}
