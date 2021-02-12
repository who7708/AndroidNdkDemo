package com.example.ndk.jni;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.ndk.BaseActivity;
import com.example.ndk.R;
import com.example.ndk.domain.Animal;
import com.example.ndk.utils.LogUtils;

public class JniAccessFieldActivity extends BaseActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jni_access_field);

        textView = findViewById(R.id.sample_text);

        final JniAccessField jniAccessField = new JniAccessField();
        final Animal animal = new Animal("dog");

        findViewById(R.id.access_static_field).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ret = jniAccessField.accessStaticField(animal);
                LogUtils.i("animal name is " + animal.getName());
                textView.setText(ret);
            }
        });

        findViewById(R.id.access_instance_field).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long ret = jniAccessField.accessInstanceField(animal);
                LogUtils.i("animal num is " + Animal.getNum());
                textView.setText(String.valueOf(ret));
            }
        });
    }
}