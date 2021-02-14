package com.example.ndk.jni;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.ndk.BaseActivity;
import com.example.ndk.R;

public class JniReferenceActivity extends BaseActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jni_reference);

        textView = findViewById(R.id.sample_text);

        final JniReference jniReference = new JniReference();

        findViewById(R.id.jni_local_reference).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ret = jniReference.errorCacheLocalReference();
                textView.setText(ret);
            }
        });

        findViewById(R.id.jni_global_reference).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ret = jniReference.cacheWithGlobalReference();
                textView.setText(ret);
            }
        });

        findViewById(R.id.jni_weak_reference).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ret = jniReference.useWeakGlobalReference();
                textView.setText(ret);
            }
        });
    }
}