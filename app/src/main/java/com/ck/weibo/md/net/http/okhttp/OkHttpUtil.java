package com.ck.weibo.md.net.http.okhttp;

import com.ck.weibo.md.Constants;
import com.facebook.stetho.okhttp.StethoInterceptor;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by liqk on 15-11-26.
 */
public class OkHttpUtil {

    public static final int DEFAULT_TIME_OUT = 30;




    private static final OkHttpClient mOkHttpClient = new OkHttpClient();
    static{
        mOkHttpClient.setConnectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS);
        if (Constants.DEUBG)
        mOkHttpClient.networkInterceptors().add(new StethoInterceptor());
    }
    /**
     * 该不会开启异步线程。
     * @param request
     * @return
     * @throws IOException
     */
    public static Response execute(Request request) throws IOException {


        return mOkHttpClient.newCall(request).execute();
    }
    /**
     * 开启异步线程访问网络
     * @param request
     * @param responseCallback
     */
    public static void enqueue(Request request, Callback responseCallback){
        mOkHttpClient.newCall(request).enqueue(responseCallback);
    }
}
