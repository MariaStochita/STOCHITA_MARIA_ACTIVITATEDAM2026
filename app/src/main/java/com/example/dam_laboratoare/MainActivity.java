package com.example.dam_laboratoare;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityLifecycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate apelat");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart apelat");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG, "onResume apelat");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.w(TAG, "onPause apelat");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop apelat");
    }
}