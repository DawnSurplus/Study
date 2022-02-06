package com.example.a28_videoview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    private VideoView videoView; // 비디오를 실행할 수 있게 도와주는 뷰
    private MediaController mediaController; // 재생이나 정지와 같은 미디어 제어 버튼부를 담당
    private String videoURL = "https://t.pimg.jp/mp4/070/458/112/1/70458112.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Uri uri = Uri.parse(videoURL);

        videoView = findViewById(R.id.videoView); // 비디오 뷰 아이디 연결

        mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);

        videoView.setMediaController(mediaController); // 미디어 제어 버튼부 세팅
        videoView.setVideoURI(uri); // 비디오 뷰의 주소를 설정
        videoView.start(); // 비디오 실행 !
    }
}