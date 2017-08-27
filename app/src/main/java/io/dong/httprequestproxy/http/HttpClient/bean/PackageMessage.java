package io.dong.httprequestproxy.http.HttpClient.bean;

import java.util.ArrayList;

/**
 * Created by Dong on 2017/8/26.
 */

public class PackageMessage {


    private String message;//状态 OK
    private String nu;//快递单号 300008026630
    private String ischeck;//1
    private String condition;//F00
    private String com;//快递名称 quanfengkuaidi
    private String status;//状态码 200
    private String state;//3
    private ArrayList<DataBean> data;

    @Override
    public String toString() {
        return "ExpressBean{" +
                "message='" + message + '\'' +
                ", nu='" + nu + '\'' +
                ", ischeck='" + ischeck + '\'' +
                ", condition='" + condition + '\'' +
                ", com='" + com + '\'' +
                ", status='" + status + '\'' +
                ", state='" + state + '\'' +
                ", data=" + data +
                '}';
    }

    public static class DataBean {
        private String time;//2013-05-27 13:48:37
        private String ftime;//2013-05-27 13:48:37
        private String context;//派件已【签收】,签收人是【秦胜杰】签收网点是【北京人大分部】
        private String location;//

        @Override
        public String toString() {
            return "DataBean{" +
                    "time='" + time + '\'' +
                    ", ftime='" + ftime + '\'' +
                    ", context='" + context + '\'' +
                    ", location='" + location + '\'' +
                    '}';
        }
    }
}
