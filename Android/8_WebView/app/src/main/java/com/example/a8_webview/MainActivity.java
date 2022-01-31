package com.example.a8_webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    private String url = "https://github.com/DawnSurplus?tab=repositories";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView);

        // WebView 인터넷 설정
        webView.getSettings().setJavaScriptEnabled(true);   // javaScript 활성화
        webView.loadUrl(url);                               // 특정 url 이동
        webView.setWebChromeClient(new WebChromeClient());  // Chrome 설정
        webView.setWebViewClient(new WebViewClientClass()); //
    }

    @Override
    // 뒤로가기 이벤트 설정
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack())
        {
            webView.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    private class WebViewClientClass extends WebViewClient {
        @Override
        // 새창 또는 특정 페이지에서 특정 기능 Setting 가능
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(url);

            return true;
        }
    }
}