package com.example.a27_networkcheck_broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private NetworkReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // BroadcastReceiver 등록
        // Intent : 내가 너꺼 사용할거야
        // IntentFilter : 내가 만들었으니 너는 사용해!
        IntentFilter filter = new IntentFilter();
        receiver = new NetworkReceiver();
        filter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION);
        registerReceiver(receiver, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // BroadcastReceiver 해제를 하지 않으면 앱이 종료되어도 계속 실행되어 과부하 발생
        unregisterReceiver(receiver);
    }
}