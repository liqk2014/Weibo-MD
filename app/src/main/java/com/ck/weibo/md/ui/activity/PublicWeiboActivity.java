package com.ck.weibo.md.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.ck.weibo.md.Constants;
import com.ck.weibo.md.R;
import com.ck.weibo.md.net.api.WeiboApi;
import com.ck.weibo.md.net.http.okhttp.OkHttpUtil;
import com.ck.weibo.md.utils.Logger;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class PublicWeiboActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_public_weibo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Request request = new Request.Builder().url(WeiboApi.FRIENDS_TIMELINE_BASE_URL+"?source="+WeiboApi.APP_KEY+"&access_token="
        + Constants.access_token+"&count=10").build();
        OkHttpUtil.enqueue(request, new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {

                Logger.getLogger().d(response.body().string() + "");







            }
        });


    }

}
