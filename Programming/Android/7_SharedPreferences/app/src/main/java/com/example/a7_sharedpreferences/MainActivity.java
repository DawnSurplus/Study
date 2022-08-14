package com.example.a7_sharedpreferences;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

import java.util.Map;
import java.util.Set;

/**
 * @ 앱 종료 시 값을 저장하고, 앱 재실행 시 값을 불러옴 (주로 설정에서 많이 사용함)
 */
public class MainActivity extends AppCompatActivity {
    EditText editText;
    String shared = "fild";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);

        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);

        String value = sharedPreferences.getString("Dawn", "");
        editText.setText(value);
    }


    @Override
    // 액티비티를 벗어났을 때(앱 종료 시, 뒤로가기, ...) 호출
    protected void onDestroy() {
        super.onDestroy();

        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit(); // 저장할 때 필요

        // EidtText에 적힌 내용을 String으로 받아 "Dawn"이라는 별명으로 저장 - 불러올 때 별명 똑같이 해줘야 함
        String value = editText.getText().toString();
        editor.putString("Dawn", value);
        editor.commit();
    }
}