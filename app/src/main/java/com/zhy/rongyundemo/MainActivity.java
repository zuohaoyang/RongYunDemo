package com.zhy.rongyundemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;

public class MainActivity extends AppCompatActivity {
    private String tokenZhangSan ="ExlfdTvTkey0CxCAeVD/+6vYZ79sSWzRtohOTHpEkJQJ81wxq9GUDmiC68XxBlY3ffhCwlIi3iCdn2f5rJm2OQ==";
    private String tokenLiSi ="oCseWHu6TflPqU2vxkjFF6vYZ79sSWzRtohOTHpEkJQJ81wxq9GUDtv8AGawXrhUPTvzWJQj+HaTrayHYq2kVQ==";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        login(tokenZhangSan);
        login(tokenLiSi);
        findViewById(R.id.m_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (RongIM.getInstance() != null){
                    RongIM.getInstance().startPrivateChat(MainActivity.this, "1111", "");
//                    RongIM.getInstance().startPrivateChat(MainActivity.this, "2222", "");
                }
            }
        });
    }

    /*
* 登录融入
* */
    private void login(String token) {
        RongIM.connect(token, new RongIMClient.ConnectCallback() {
            @Override
            public void onTokenIncorrect() {
                Log.e("融云登录：", "Token过期");
            }
            @Override
            public void onSuccess(String s) {
                Log.e("融云登录：", "登录成功");
            }
            @Override
            public void onError(RongIMClient.ErrorCode errorCode) {
                Log.e("融云登录：", "登录失败：" + errorCode);
            }
        });

    }
}
