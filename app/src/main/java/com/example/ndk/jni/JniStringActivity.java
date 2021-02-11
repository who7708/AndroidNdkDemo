package com.example.ndk.jni;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.ndk.BaseActivity;
import com.example.ndk.R;
import com.example.ndk.utils.LogUtils;

public class JniStringActivity extends BaseActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jni_string);

        textView = findViewById(R.id.sample_text);

        JniString jniString = new JniString();

        findViewById(R.id.java_jni_string).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ret = jniString.callNativeString("我是字符串");
                LogUtils.i(ret);
                textView.setText(ret);
            }
        });

        findViewById(R.id.java_jni_string_method).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // jniString.stringMethod("我也是字符串");
                String ret = jniString.stringMethod("hello world");
                textView.setText(ret);
            }
        });
    }
}