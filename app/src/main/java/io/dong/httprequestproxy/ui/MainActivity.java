package io.dong.httprequestproxy.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Time;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import io.dong.httprequestproxy.R;
import io.dong.httprequestproxy.http.HttpClient.bean.PackageMessage;
import io.dong.httprequestproxy.http.api.HttpConfig;
import io.dong.httprequestproxy.http.HttpCallBack;
import io.dong.httprequestproxy.http.HttpProxy;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_request;
    private TextView tv_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btn_request = (Button) findViewById(R.id.btn_request);
        tv_text = (TextView) findViewById(R.id.tv_text);
        btn_request.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_request:
                HttpProxy.obtain().get(HttpConfig.NEWS, null, new HttpCallBack<PackageMessage>() {
                    @Override
                    public void onSuccess(PackageMessage packageMessage) {
                        tv_text.setText(packageMessage.toString());
                        Log.i("onSuccess: ", packageMessage.data.toString());
                        StringBuffer sb = new StringBuffer();
                        Time time = new Time();
                        time.setToNow();
                        sb.append("当前时间：" + time.format("%Y-%m-%d %H:%M:%S")+ "\r\n");
                        if (packageMessage != null) {
                            ArrayList<PackageMessage.DataBean> datas = packageMessage.data;
                            for (PackageMessage.DataBean data : datas) {
                                sb.append("时间：")
                                        .append(data.time + "\r\n")
                                        .append("地点和跟踪进度：")
                                        .append(data.context + "\r\n" + "\r\n");
                                tv_text.setText(sb.toString());
                            }
                        }
                    }

                    @Override
                    public void onError(String error) {
                        Toast.makeText(MainActivity.this, error, Toast.LENGTH_SHORT).show();
                    }
                });
                break;

            default:
                break;
        }
    }
}
