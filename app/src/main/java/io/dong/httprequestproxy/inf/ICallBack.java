package io.dong.httprequestproxy.inf;

/**
 * Created by Dong on 2017/8/26.
 */

public interface ICallBack {

    void onSuccess(String respons);

    void onError(String error);
}
