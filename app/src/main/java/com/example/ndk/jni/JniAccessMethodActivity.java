package com.example.ndk.jni;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.ndk.BaseActivity;
import com.example.ndk.R;
import com.example.ndk.domain.Animal;

public class JniAccessMethodActivity extends BaseActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jni_access_method);

        textView = findViewById(R.id.sample_text);

        final Animal animal = new Animal("dog");
        Animal.setNum(323L);

        JniAccessMethod jniAccessMethod = new JniAccessMethod();

        findViewById(R.id.call_instance_method).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long ret = jniAccessMethod.accessInstanceMethod(animal);
                textView.setText(String.valueOf(ret));
            }
        });

        findViewById(R.id.call_static_method).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ret = jniAccessMethod.accessStaticMethod(animal);
                textView.setText(ret);
            }
        });

        findViewById(R.id.call_static_method2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ret = jniAccessMethod.accessStaticMethod2(animal);
                textView.setText(ret);
            }
        });
    }
}