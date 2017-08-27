package io.dong.httprequestproxy.inf;

import java.util.Map;
import java.util.Objects;

/**
 * Created by Dong on 2017/8/26.
 */

public interface IHttpClient {

    void get(String url, Map<String, Objects> param, ICallBack callBack);

    void post(String url, Map<String, Objects> param, ICallBack callBack);
}
