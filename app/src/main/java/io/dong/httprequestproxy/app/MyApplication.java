package io.dong.httprequestproxy.app;

import android.app.Application;

import io.dong.httprequestproxy.http.HttpClient.VolleyClient;
import io.dong.httprequestproxy.http.HttpProxy;

/**
 * Created by Dong on 2017/8/26.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        HttpProxy.obtain().init(new VolleyClient(this));
    }
}
