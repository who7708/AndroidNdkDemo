package com.example.ndk.jni;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.ndk.BaseActivity;
import com.example.ndk.R;

public class JniThreadActivity extends BaseActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jni_thread);

        textView = findViewById(R.id.sample_text);

        final JniThread jniThread = new JniThread();

        findViewById(R.id.jni_create_thread).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ret = jniThread.createNativeThread();
                textView.setText(ret);
            }
        });

        findViewById(R.id.jni_create_thread_with_args).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ret = jniThread.createNativeThreadWithArgs();
                textView.setText(ret);
            }
        });

        findViewById(R.id.jni_join_thread).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ret = jniThread.joinNativeThread();
                textView.setText(ret);
            }
        });
    }
}