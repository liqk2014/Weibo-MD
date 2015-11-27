package com.ck.weibo.md.ui.activity;

import android.net.UrlQuerySanitizer;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.ck.weibo.md.R;
import com.ck.weibo.md.net.api.WeiboApi;
import com.ck.weibo.md.net.http.okhttp.OkHttpUtil;
import com.ck.weibo.md.utils.Logger;
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
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Logger.getLogger().d(url + "");


                if (url.startsWith(WeiboApi.REDIRECT_URI)) {
                    Logger.getLogger().d(url + "");


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
                            .add("grant_type","authorization_code")
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


                            Logger.getLogger().d(response.body().string()+"");
                        }
                    });

                }

                return true;


            }
        });
        oauthPage.loadUrl(WeiboApi.OAUTH_URL);


    }

    @Override
    protected void initField() {

    }

    @Override
    protected void loadData() {

    }

}
