package com.example.myapplication.base;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.BaseActivity;
import com.example.myapplication.R;

public class JniInvokeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jni_invoke);

        JniInvoke jniInvoke = new JniInvoke();

        // Example of a call to a native method
        TextView tv = findViewById(R.id.sample_text);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText(jniInvoke.stringFromJNI());
            }
        });
    }
}