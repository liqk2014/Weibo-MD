package com.ck.weibo.md.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.ck.weibo.md.Constants;
import com.ck.weibo.md.R;
import com.ck.weibo.md.model.WeiboModel;
import com.ck.weibo.md.net.api.WeiboApi;
import com.ck.weibo.md.net.http.okhttp.OkHttpUtil;
import com.ck.weibo.md.utils.Logger;
import com.google.gson.Gson;
import com.sk.android.lib.ui.BaseActivity;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import in.srain.cube.util.LocalDisplay;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import in.srain.cube.views.ptr.header.MaterialHeader;

public class PublicWeiboActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.toolbar_title)
    TextView toolbarTitle;
    @Bind(R.id.public_timeline_list)
    RecyclerView publicTimelineList;
    @Bind(R.id.material_style_ptr_frame)
    PtrFrameLayout materialStylePtrFrame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_public_weibo);
        ButterKnife.bind(this);

        initView();


        Request request = new Request.Builder().url(WeiboApi.FRIENDS_TIMELINE_BASE_URL + "?source=" + WeiboApi.APP_KEY + "&access_token="
                + Constants.access_token + "&count=10").build();
        OkHttpUtil.enqueue(request, new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {

//                Logger.getLogger().d(response.body().string() + "");

                WeiboModel weiboModel = new Gson().fromJson(response.body().string(), WeiboModel.class);


                Logger.getLogger().d(response.body().string() + "");


            }
        });


    }

    @Override
    protected void initView() {


        // header
        final MaterialHeader header = new MaterialHeader(this);
        int[] colors = getResources().getIntArray(R.array.refresh_colors);
        header.setColorSchemeColors(colors);
        header.setLayoutParams(new PtrFrameLayout.LayoutParams(-1, -2));
        header.setPadding(0, LocalDisplay.dp2px(15), 0, LocalDisplay.dp2px(10));
        header.setPtrFrameLayout(materialStylePtrFrame);

        materialStylePtrFrame.setLoadingMinTime(1000);
        materialStylePtrFrame.setDurationToCloseHeader(1500);
        materialStylePtrFrame.setHeaderView(header);
        materialStylePtrFrame.addPtrUIHandler(header);
        materialStylePtrFrame.postDelayed(new Runnable() {
            @Override
            public void run() {
                materialStylePtrFrame.autoRefresh(false);
            }
        }, 100);

        materialStylePtrFrame.setPtrHandler(new PtrHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return true;
            }

            @Override
            public void onRefreshBegin(final PtrFrameLayout frame) {

            }
        });

    }

    @Override
    protected void initField() {

    }

    @Override
    protected void loadData() {

    }

}
