package com.ck.weibo.md.ui.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.ck.weibo.md.R;
import com.sk.android.lib.ui.BaseActivity;


public class SplashActivity extends BaseActivity {


    private static final int SHOW_TIME_MIN = 2000;// 最小显示时间

    private long mStartTime;// 开始时间



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mStartTime = System.currentTimeMillis();//记录开始时间，


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(SplashActivity.this,OuthActivity.class));
            }
        },2000);


    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initField() {

    }



    @Override
    protected void loadData() {

    }

    @Override
    public void onStart() {
        super.onStart();


    }

//    @TargetApi(Build.VERSION_CODES.KITKAT_WATCH)

    @TargetApi(20)
    @Override
    public void onStop() {
        super.onStop();


    }


    @Override
    public void onDestroy() {
        super.onDestroy();

    }



    public void postMessage(String Action) {




    }
}
