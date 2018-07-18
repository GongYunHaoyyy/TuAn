package com.linghang2018.tuan.bgservice;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;

import retrofit2.Retrofit;


public class PollingService extends IntentService {
    private static final String TAG = "PollingService";
    private String fileName;
    private boolean isMakeSound;
    private Retrofit retrofit;
//    private PollServiceInterface pollServiceInterface;
    private String baseUrl = "http://47.92.48.100:8099/carHealth/";
//    private Call<StatusBean<DriverStatusBean>> getDriverStatus;
    private AssetManager assetManager;
    private AssetFileDescriptor assetFileDescriptor;

    public PollingService() {
        super( "PollingService" );
    }

    public static Intent newIntent(Context context){
        Intent intent = new Intent(context, PollingService.class);
        return intent;
    }

    @Override
    public void onCreate() {
        super.onCreate( );
    }

    @Override
    protected void onHandleIntent(Intent intent) {

    }

}
