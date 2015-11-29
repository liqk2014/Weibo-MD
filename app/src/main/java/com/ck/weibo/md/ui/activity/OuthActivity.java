package com.ck.weibo.md.ui.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.UrlQuerySanitizer;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.ck.weibo.md.Constants;
import com.ck.weibo.md.R;
import com.ck.weibo.md.model.AccessTakenResponse;
import com.ck.weibo.md.net.api.WeiboApi;
import com.ck.weibo.md.net.http.okhttp.OkHttpUtil;
import com.ck.weibo.md.utils.Logger;
import com.google.gson.Gson;
import com.rey.material.widget.ProgressView;
import com.sk.android.lib.ui.BaseActivity;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;

public class OuthActivity extends BaseActivity {


    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.toolbar_title)
    TextView toolbarTitle;
    @Bind(R.id.oauth_page)
    WebView oauthPage;


    MaterialDialog loadDialog;
    @Bind(R.id.material_progress_bar)
    ProgressView materialProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outh);
        ButterKnife.bind(this);
        initView();

    }

    @Override
    protected void initView() {
        initToolBar(toolbar, toolbarTitle, getString(R.string.oauth_title));

        oauthPage.getSettings().setJavaScriptEnabled(true);


        oauthPage.setWebViewClient(new WebViewClient() {


            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);



            }

            @Override
            public void onPageCommitVisible(WebView view, String url) {
                super.onPageCommitVisible(view, url);
                Logger.getLogger().d(url + "");


                final String oauthURL = WeiboApi.OAUTH_URL;

                Logger.getLogger().d(WeiboApi.OAUTH_URL);
                Logger.getLogger().d(oauthURL);


                if (url.trim().equals(oauthURL.trim())) {

                    materialProgressBar.setVisibility(View.GONE);

                }


            }

            @Override
            public void onPageFinished(WebView view, String url) {


            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Logger.getLogger().d(url + "123 ");


                if (url.startsWith(WeiboApi.REDIRECT_URI)) {
                    Logger.getLogger().d(url + "");

                    materialProgressBar.setVisibility(View.VISIBLE);

                    UrlQuerySanitizer sanitizer = new UrlQuerySanitizer(url);
                    sanitizer.setAllowUnregisteredParamaters(true);
                    String code = sanitizer.getValue("code");


//                    AccessTakenRequest accessTakenRequest = new AccessTakenRequest();
//                    accessTakenRequest.setClient_id(WeiboApi.APP_KEY);
//                    accessTakenRequest.setClient_secret(WeiboApi.APP_SECRET);
//                    accessTakenRequest.setCode(code);
//                    accessTakenRequest.setGrant_type("authorization_code");
//                    accessTakenRequest.setRedirect_uri(WeiboApi.REDIRECT_URI);
//
//                    String json =new Gson().toJson(accessTakenRequest);

//                    MediaType JSON = MediaType.parse("application/json;charset=utf-8");
//                    RequestBody body = RequestBody.create(JSON, json);


                    RequestBody body = new FormEncodingBuilder()
                            .add("client_id", WeiboApi.APP_KEY)
                            .add("client_secret", WeiboApi.APP_SECRET)
                            .add("grant_type", "authorization_code")
                            .add("code", code)
                            .add("redirect_uri", WeiboApi.REDIRECT_URI)
                            .build();

                    Request request = new Request.Builder().post(body).url(WeiboApi.ACCESS_TAKEN_URL).build();
                    OkHttpUtil.enqueue(request, new Callback() {
                        @Override
                        public void onFailure(Request request, IOException e) {

                        }

                        @Override
                        public void onResponse(Response response) throws IOException {


                           String accessTokenJson = response.body().string();

                            Logger.getLogger().d(accessTokenJson + "");

                            AccessTakenResponse accessTakenResponse = new Gson().fromJson(accessTokenJson, AccessTakenResponse.class);
                            Constants.access_token = accessTakenResponse.getAccess_token();


                            OuthActivity.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    materialProgressBar.setVisibility(View.GONE);

                                }
                            });

                            startActivity(new Intent(OuthActivity.this, PublicWeiboActivity.class));

                            finish();

                        }
                    });

                } else {
                    materialProgressBar.setVisibility(View.GONE);


                }

                return true;


            }
        });
        oauthPage.loadUrl(WeiboApi.OAUTH_URL);
        materialProgressBar.setVisibility(View.VISIBLE);
    }


    @Override
    protected void initField() {

    }

    @Override
    protected void loadData() {

    }

}
