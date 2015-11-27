package com.ck.weibo.md.net.api;

/**
 * Created by liqk on 15-11-26.
 */
public class WeiboApi {
    public static final String APP_KEY = "910318253";
    public static final String APP_SECRET = "9cd51adbf6bab3464de1fb1e81936d35";


    public static final String REDIRECT_URI = "https://api.weibo.com/oauth2/default.html";


    public static final String OAUTH_URL = "https:/api.weibo.com/oauth2/authorize?client_id="
            + APP_KEY + "&redirect_uri=" + REDIRECT_URI + "&response_type=code&display=default&state=authorize";

    public static final String ACCESS_TAKEN_URL = "https://api.weibo.com/oauth2/access_token";

}
