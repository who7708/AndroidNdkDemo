package com.example.myapplication.load;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.BaseActivity;
import com.example.myapplication.R;

public class JNIDynamicLoadActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jni_dynamic_load);

        final JNIDynamicLoad jniDynamicLoad = new JNIDynamicLoad();

        final TextView textView = findViewById(R.id.sample_text);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(jniDynamicLoad.getNativeString());
            }
        });
    }
}