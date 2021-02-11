package com.example.ndk.jni;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.ndk.BaseActivity;
import com.example.ndk.R;

public class JniBasicTypeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jni_basic_type);
    }
}