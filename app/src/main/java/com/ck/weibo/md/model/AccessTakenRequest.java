package com.ck.weibo.md.model;

/**
 * Created by liqk on 15-11-26.
 */
public class AccessTakenRequest {
    /**
     * client_id : AppKey
     * client_secret : AppSecret
     * grant_type : authorization_code
     * code : authorization_code
     * redirect_uri : redirect_uri
     */

    private String client_id;
    private String client_secret;
    private String grant_type;
    private String code;
    private String redirect_uri;

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

    public void setGrant_type(String grant_type) {
        this.grant_type = grant_type;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setRedirect_uri(String redirect_uri) {
        this.redirect_uri = redirect_uri;
    }

    public String getClient_id() {
        return client_id;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public String getGrant_type() {
        return grant_type;
    }

    public String getCode() {
        return code;
    }

    public String getRedirect_uri() {
        return redirect_uri;
    }
}
