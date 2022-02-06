package com.example.a27_networkcheck_broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class NetworkReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, @NonNull Intent intent) {
        // 네트워크 상태값 받아오기
        if(WifiManager.NETWORK_STATE_CHANGED_ACTION.equals(intent.getAction())){
            NetworkInfo info = intent.getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO);
            NetworkInfo.DetailedState state = info.getDetailedState();

            // 네트워크 연결
            if(state == NetworkInfo.DetailedState.CONNECTED){
                Toast.makeText(context.getApplicationContext(), "네트워크 연결", Toast.LENGTH_SHORT).show();
            }
            // 네트워크 끊김
            else if(state == NetworkInfo.DetailedState.DISCONNECTED){
                Toast.makeText(context.getApplicationContext(), "네트워크 해제", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
