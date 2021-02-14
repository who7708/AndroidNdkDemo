package com.example.ndk.jni;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.ndk.BaseActivity;
import com.example.ndk.R;

public class JniWaitNotifyActivity extends BaseActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jni_wait_notify);

        textView = findViewById(R.id.sample_text);

        final JniWaitNotify jniWaitNotify = new JniWaitNotify();

        findViewById(R.id.jni_thread_wait).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ret = jniWaitNotify.waitNativeThread();
                textView.setText(ret);
            }
        });

        findViewById(R.id.jni_thread_notify).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ret = jniWaitNotify.notifyNativeThread();
                textView.setText(ret);
            }
        });

        findViewById(R.id.jni_product_and_consumer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ret = jniWaitNotify.startProductAndConsumerThread();
                textView.setText(ret);
            }
        });
    }
}