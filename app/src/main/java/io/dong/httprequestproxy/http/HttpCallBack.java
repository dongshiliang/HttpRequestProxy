package io.dong.httprequestproxy.http;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import io.dong.httprequestproxy.inf.ICallBack;

/**
 * Created by Dong on 2017/8/26.
 * Result 为对应待解析的bean对象
 */

public abstract class HttpCallBack<Result> implements ICallBack {


    @Override
    public void onSuccess(String respons) {
        Gson gson = new Gson();
        Class<?> cls = analysisClazzInfo(this);

        Result obj = (Result) gson.fromJson(respons, cls);
        onSuccess(obj);
    }

    private Class<?> analysisClazzInfo(Object object) {
        Type genType = object.getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType)genType).getActualTypeArguments();
        return (Class<?>) params[0];
    }

    public abstract void onSuccess(Result result);

}
