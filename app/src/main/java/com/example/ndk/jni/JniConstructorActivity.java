package com.example.ndk.jni;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.ndk.BaseActivity;
import com.example.ndk.R;
import com.example.ndk.domain.Animal;
import com.example.ndk.utils.LogUtils;

public class JniConstructorActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jni_constructor);

        final JniConstructorClass jniConstructorClass = new JniConstructorClass();

        final TextView textView1 = findViewById(R.id.sample_text);
        final TextView textView2 = findViewById(R.id.sample_text2);

        findViewById(R.id.jni_constructor).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animal animal1 = jniConstructorClass.invokeAnimalConstructors();
                LogUtils.i("name1 is " + animal1.getName());
                textView1.setText(animal1.getName());

                Animal animal2 = jniConstructorClass.allocObjectConstructor();
                LogUtils.i("name2 is " + animal2.getName());
                textView2.setText(animal2.getName());
            }
        });

    }
}