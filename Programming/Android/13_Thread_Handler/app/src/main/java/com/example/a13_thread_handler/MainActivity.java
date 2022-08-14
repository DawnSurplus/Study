package com.example.a13_thread_handler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * @ Thread를 사용하면 백그라운드에서 동작가능
 */
public class MainActivity extends AppCompatActivity {
    Button startBtn, stopBtn;
    Thread thread;
    boolean isThread = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Thread 시작
        startBtn = findViewById(R.id.startBtn);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isThread = true;

                thread = new Thread(){
                    public void run(){
                        while(isThread){
                            try {
                                sleep(5000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            handler.sendEmptyMessage(0);
                        }
                    }
                };
                thread.start();
            }
        });

        // Thread 시작
        stopBtn = findViewById(R.id.stopBtn);
        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isThread = false;
            }
        });
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            Toast.makeText(getApplicationContext(), "DawnSurplus - Thread is Running", Toast.LENGTH_SHORT).show();
        }
    };
}