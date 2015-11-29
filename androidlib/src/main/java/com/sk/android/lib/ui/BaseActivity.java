package com.sk.android.lib.ui;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.TextView;

import com.sk.android.lib.R;
import com.sk.android.lib.utils.Logger;


public abstract class BaseActivity extends AppCompatActivity {


    Logger logger;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        logger = Logger.getLogger();


        logger.d(this+"");


    }

    @Override
    protected void onStart() {
        super.onStart();
        logger.d(this+"");


    }


    @Override
    protected void onRestart() {
        super.onRestart();
        logger.d(this + "");
    }

    @Override
    protected void onResume() {
        super.onResume();
        logger.d(this + "");

    }

    @Override
    protected void onPause() {
        super.onPause();
        logger.d(this + "");

    }

    @Override
    protected void onStop() {
        super.onStop();
        logger.d(this + "");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        logger.d(this+"");


    }

    protected abstract void initView();

    protected abstract void initField();

    protected abstract void loadData();


    protected void initSubPageToolBar(Toolbar toolbar,TextView toolbarTitle,String title) {
        initToolBar(toolbar,toolbarTitle,title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//显示返回键
        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.btn_back);

    }




    protected void initToolBar(Toolbar toolbar,TextView toolbarTitle,String title) {
        setSupportActionBar(toolbar);
        toolbarTitle.setText(title);
        getSupportActionBar().setDisplayShowTitleEnabled(false);//设置标题是否显示

    }
    protected void onBack() {

    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        Logger.getLogger().d(event + ";" + keyCode);

        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getRepeatCount() == 0) {
            onBack();

            finish();

            return true;
        } else
            return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            //返回键
            case android.R.id.home:
                onBack();
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }


}

