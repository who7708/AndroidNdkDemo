package com.example.ndk.jni;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.ndk.BaseActivity;
import com.example.ndk.R;
import com.example.ndk.utils.LogUtils;

public class JniExceptionActivity extends BaseActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jni_exception);

        textView = findViewById(R.id.sample_text);

        final JniException jniException = new JniException();

        findViewById(R.id.jni_exception).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int ret = jniException.nativeInvokeJavaException();
                textView.setText(String.valueOf(ret));
                try {
                    jniException.nativeThrowException();
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                    LogUtils.i(e.getMessage());
                }
            }
        });
    }
}