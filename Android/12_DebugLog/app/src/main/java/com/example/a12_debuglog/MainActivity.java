package com.example.a12_debuglog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String log = "DawnSurplus";

        Log.v("MainActivity", log); // Verbose
        Log.e("MainActivity", log); // Error
        Log.d("MainActivity", log); // Debug
        Log.i("MainActivity", log); // Info
        Log.w("MainActivity", log); // Warn
    }
}