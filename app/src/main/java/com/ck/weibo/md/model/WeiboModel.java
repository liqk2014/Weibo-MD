package com.ck.weibo.md.model;

/**
 * Created by liqk on 15-11-28.
 */
public class WeiboModel {
    /**
     * created_at : null
     * id : 0
     * mid : 0
     * idstr : null
     * text : null
     * source : null
     * favorited : false
     * truncated : false
     * in_reply_to_status_id : null
     * in_reply_to_user_id : null
     * in_reply_to_screen_name : null
     * thumbnail_pic : null
     * bmiddle_pic : null
     * original_pic : null
     * geo : object
     * user : object
     * retweeted_status : object
     * reposts_count : 0
     * comments_count : 0
     * attitudes_count : 0
     * mlevel : 0
     * visible : object
     * pic_ids : object
     * ad : object
     */

    private String created_at;
    private long id;
    private long mid;
    private String idstr;
    private String text;
    private String source;
    private boolean favorited;
    private boolean truncated;
    private String in_reply_to_status_id;
    private String in_reply_to_user_id;
    private String in_reply_to_screen_name;
    private String thumbnail_pic;
    private String bmiddle_pic;
    private String original_pic;
    private String geo;
    private String user;
    private String retweeted_status;
    private int reposts_count;
    private int comments_count;
    private int attitudes_count;
    private int mlevel;
    private String visible;
    private String pic_ids;
    private String ad;

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public void setIdstr(String idstr) {
        this.idstr = idstr;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setFavorited(boolean favorited) {
        this.favorited = favorited;
    }

    public void setTruncated(boolean truncated) {
        this.truncated = truncated;
    }

    public void setIn_reply_to_status_id(String in_reply_to_status_id) {
        this.in_reply_to_status_id = in_reply_to_status_id;
    }

    public void setIn_reply_to_user_id(String in_reply_to_user_id) {
        this.in_reply_to_user_id = in_reply_to_user_id;
    }

    public void setIn_reply_to_screen_name(String in_reply_to_screen_name) {
        this.in_reply_to_screen_name = in_reply_to_screen_name;
    }

    public void setThumbnail_pic(String thumbnail_pic) {
        this.thumbnail_pic = thumbnail_pic;
    }

    public void setBmiddle_pic(String bmiddle_pic) {
        this.bmiddle_pic = bmiddle_pic;
    }

    public void setOriginal_pic(String original_pic) {
        this.original_pic = original_pic;
    }

    public void setGeo(String geo) {
        this.geo = geo;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setRetweeted_status(String retweeted_status) {
        this.retweeted_status = retweeted_status;
    }

    public void setReposts_count(int reposts_count) {
        this.reposts_count = reposts_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public void setAttitudes_count(int attitudes_count) {
        this.attitudes_count = attitudes_count;
    }

    public void setMlevel(int mlevel) {
        this.mlevel = mlevel;
    }

    public void setVisible(String visible) {
        this.visible = visible;
    }

    public void setPic_ids(String pic_ids) {
        this.pic_ids = pic_ids;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getCreated_at() {
        return created_at;
    }

    public long getId() {
        return id;
    }

    public long getMid() {
        return mid;
    }

    public String getIdstr() {
        return idstr;
    }

    public String getText() {
        return text;
    }

    public String getSource() {
        return source;
    }

    public boolean isFavorited() {
        return favorited;
    }

    public boolean isTruncated() {
        return truncated;
    }

    public String getIn_reply_to_status_id() {
        return in_reply_to_status_id;
    }

    public String getIn_reply_to_user_id() {
        return in_reply_to_user_id;
    }

    public String getIn_reply_to_screen_name() {
        return in_reply_to_screen_name;
    }

    public String getThumbnail_pic() {
        return thumbnail_pic;
    }

    public String getBmiddle_pic() {
        return bmiddle_pic;
    }

    public String getOriginal_pic() {
        return original_pic;
    }

    public String getGeo() {
        return geo;
    }

    public String getUser() {
        return user;
    }

    public String getRetweeted_status() {
        return retweeted_status;
    }

    public int getReposts_count() {
        return reposts_count;
    }

    public int getComments_count() {
        return comments_count;
    }

    public int getAttitudes_count() {
        return attitudes_count;
    }

    public int getMlevel() {
        return mlevel;
    }

    public String getVisible() {
        return visible;
    }

    public String getPic_ids() {
        return pic_ids;
    }

    public String getAd() {
        return ad;
    }
}
