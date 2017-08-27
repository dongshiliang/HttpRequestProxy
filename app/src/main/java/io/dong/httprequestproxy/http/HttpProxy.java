package io.dong.httprequestproxy.http;

import java.util.Map;
import java.util.Objects;

import io.dong.httprequestproxy.inf.ICallBack;
import io.dong.httprequestproxy.inf.IHttpClient;

/**
 * Created by Dong on 2017/8/26.
 */

public class HttpProxy implements IHttpClient {

    private IHttpClient iHttpClient;
    private static HttpProxy _instance;

    public static HttpProxy obtain() {
        synchronized (HttpProxy.class) {
            if (null == _instance) {
                _instance = new HttpProxy();
            }
        }
        return _instance;
    }

    public void init(IHttpClient iHttpClient){
        this.iHttpClient = iHttpClient;
    }

    @Override
    public void get(String url, Map<String, Objects> param, ICallBack callBack) {
        iHttpClient.get(url, param, callBack);
    }

    @Override
    public void post(String url, Map<String, Objects> param, ICallBack callBack) {
        iHttpClient.post(url, param, callBack);
    }
}
