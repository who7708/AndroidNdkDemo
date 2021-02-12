package com.example.ndk.jni;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.ndk.BaseActivity;
import com.example.ndk.R;
import com.example.ndk.utils.LogUtils;

public class JniReferenceTypeActivity extends BaseActivity {

    private final String[] strArray = {"apple", "pear", "banana"};

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jni_reference_type);

        textView = findViewById(R.id.sample_text);

        JniReferenceType jniReferenceType = new JniReferenceType();

        findViewById(R.id.click_me).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ret = jniReferenceType.callNativeStringArray(strArray);
                LogUtils.i(ret);
                textView.setText(ret);
            }
        });
    }
}