package com.example.a3_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {
    private TextView testTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        testTextView = findViewById(R.id.testTextView);

        Intent intent = getIntent();
        String str = intent.getStringExtra("str");  // "str" 변수명으로 똑같이 보내야 함

        testTextView.setText(str);
    }
}