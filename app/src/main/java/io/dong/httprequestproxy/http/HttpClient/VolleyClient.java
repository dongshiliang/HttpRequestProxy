package io.dong.httprequestproxy.http.HttpClient;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Map;
import java.util.Objects;

import io.dong.httprequestproxy.inf.ICallBack;
import io.dong.httprequestproxy.inf.IHttpClient;

/**
 * Created by Dong on 2017/8/26.
 */

public class VolleyClient implements IHttpClient {

    public static final String TAG = "VolleyClient";
    private static RequestQueue mQueue = null;

    public VolleyClient(Context context) {
        mQueue = Volley.newRequestQueue(context);
    }

    @Override
    public void get(String url, Map<String, Objects> param, final ICallBack callBack) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callBack.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.onError(error.toString());
            }
        });
        mQueue.add(stringRequest);
    }

    @Override
    public void post(String url, Map<String, Objects> param, final ICallBack callBack) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callBack.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.onError(error.toString());
            }
        });
        mQueue.add(stringRequest);
    }
}
