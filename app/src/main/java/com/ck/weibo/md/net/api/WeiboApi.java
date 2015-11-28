package com.ck.weibo.md.net.api;

/**
 * Created by liqk on 15-11-26.
 */
public class WeiboApi {
    public static final String APP_KEY = "910318253";
    public static final String APP_SECRET = "9cd51adbf6bab3464de1fb1e81936d35";


    public static final String REDIRECT_URI = "https://api.weibo.com/oauth2/default.html";


    public static final String OAUTH_URL = "https://api.weibo.com/oauth2/authorize?client_id="
            + APP_KEY + "&redirect_uri=" + REDIRECT_URI + "&response_type=code&display=default&state=authorize";


    public static final String ACCESS_TAKEN_URL = "https://api.weibo.com/oauth2/access_token";


    /**
     * 返回最新的公共微博
     *
     * source	false	string	采用OAuth授权方式不需要此参数，其他授权方式为必填参数，数值为应用的AppKey。
     * access_token	false	string	采用OAuth授权方式为必填参数，其他授权方式不需要此参数，OAuth授权后获得。
     * count	false	int	单页返回的记录条数，默认为50。
     * page	false	int	返回结果的页码，默认为1。
     * base_app	false	int	是否只获取当前应用的数据。0为否（所有数据），1为是（仅当前应用），默认为0。
     */
    public static final String FRIENDS_TIMELINE_BASE_URL = "https://api.weibo.com/2/statuses/friends_timeline.json";

}
