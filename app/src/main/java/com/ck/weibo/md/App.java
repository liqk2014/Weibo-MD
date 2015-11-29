package com.ck.weibo.md;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by liqk on 15-11-26.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Stetho.initialize(Stetho
                .newInitializerBuilder(this)
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                .enableWebKitInspector(
                        Stetho.defaultInspectorModulesProvider(this)).build());
    }
}
