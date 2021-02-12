package com.example.ndk.jni;

import android.os.Bundle;
import android.view.View;

import com.example.ndk.BaseActivity;
import com.example.ndk.R;
import com.example.ndk.utils.LogUtils;

public class JniInvokeMethodActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jni_invoke_method);

        final JniInvokeMethod jniInvokeMethod = new JniInvokeMethod();

        findViewById(R.id.jni_native_callback).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jniInvokeMethod.nativeCallback(new ICallbackMethod() {
                    @Override
                    public void callback() {
                        // 在主线程中被调用
                        LogUtils.i("thread name is " + Thread.currentThread().getName());
                    }
                });
            }
        });

        findViewById(R.id.jni_thread_callback).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jniInvokeMethod.nativeThreadCallback(new IThreadCallback() {
                    @Override
                    public void callback() {
                        // 在子线程中被调用
                        LogUtils.i("thread name is " + Thread.currentThread().getName());
                    }
                });
            }
        });
    }
}