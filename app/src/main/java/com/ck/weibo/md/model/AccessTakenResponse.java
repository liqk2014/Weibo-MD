package com.ck.weibo.md.model;

/**
 * Created by liqk on 15-11-26.
 */
public class AccessTakenResponse {


    /**
     * access_token : ACCESS_TOKEN
     * expires_in : 1234
     * remind_in : 798114
     * uid : 12341234
     */

    private String access_token;
    private int expires_in;
    private String remind_in;
    private String uid;

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public void setRemind_in(String remind_in) {
        this.remind_in = remind_in;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getAccess_token() {
        return access_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public String getRemind_in() {
        return remind_in;
    }

    public String getUid() {
        return uid;
    }
}
