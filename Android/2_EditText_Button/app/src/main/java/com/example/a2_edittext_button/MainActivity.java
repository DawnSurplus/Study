package com.example.a2_edittext_button;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText idEditText;
    Button testBtn;

    @Override
    // 어플을 처음 실행할 때 실행
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Resource의 id로 activity_main.xml에서 설정한 컴포넌트의 id를 찾음
        idEditText = findViewById(R.id.idEditText);
        testBtn = findViewById(R.id.testBtn);

        // 버튼 클릭 이벤트 함수
        testBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                idEditText.setText("DawnSurplus");
            }
        });
    }
}