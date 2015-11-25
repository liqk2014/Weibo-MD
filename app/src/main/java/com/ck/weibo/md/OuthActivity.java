package com.ck.weibo.md;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.ck.weibo.md.utils.Logger;

import butterknife.Bind;
import butterknife.ButterKnife;

public class OuthActivity extends AppCompatActivity {

    private static final String OauthURL = "https://open.weibo.cn/oauth2/authorize?client_id=910318253&redirect_uri=https://api.weibo.com/oauth2/default.html&response_type=code&display=mobile&state=authorize";
    @Bind(R.id.oauth_page)
    WebView oauthPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outh);
        ButterKnife.bind(this);
        oauthPage.getSettings().setJavaScriptEnabled(true);
        oauthPage.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                Logger.getLogger().d(url+"");

                return true;


            }
        });
        oauthPage.loadUrl(OauthURL);




    }

}
