package com.example.ndk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ndk.base.JniInvokeActivity;
import com.example.ndk.jni.JniAccessFieldActivity;
import com.example.ndk.jni.JniAccessMethodActivity;
import com.example.ndk.jni.JniBasicTypeActivity;
import com.example.ndk.jni.JniConstructorActivity;
import com.example.ndk.jni.JniExceptionActivity;
import com.example.ndk.jni.JniInvokeMethodActivity;
import com.example.ndk.jni.JniReferenceActivity;
import com.example.ndk.jni.JniReferenceTypeActivity;
import com.example.ndk.jni.JniStringActivity;
import com.example.ndk.jni.JniThreadActivity;
import com.example.ndk.jni.JniWaitNotifyActivity;
import com.example.ndk.load.JNIDynamicLoadActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.jni_invoke).setOnClickListener(this);
        findViewById(R.id.dynamic_register).setOnClickListener(this);
        findViewById(R.id.basic_type).setOnClickListener(this);
        findViewById(R.id.string_convert).setOnClickListener(this);
        findViewById(R.id.reference_convert).setOnClickListener(this);
        findViewById(R.id.access_java_field).setOnClickListener(this);
        findViewById(R.id.access_java_method).setOnClickListener(this);
        findViewById(R.id.access_java_method_by_thread).setOnClickListener(this);
        findViewById(R.id.access_java_constructor).setOnClickListener(this);
        findViewById(R.id.reference_manage).setOnClickListener(this);
        findViewById(R.id.exception_manage).setOnClickListener(this);
        findViewById(R.id.create_thread).setOnClickListener(this);
        findViewById(R.id.thread_sync).setOnClickListener(this);
        findViewById(R.id.bitmap_operate).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (R.id.jni_invoke == v.getId()) {
            startActivity(JniInvokeActivity.class);
        } else if (R.id.dynamic_register == v.getId()) {
            startActivity(JNIDynamicLoadActivity.class);
        } else if (R.id.basic_type == v.getId()) {
            startActivity(JniBasicTypeActivity.class);
        } else if (R.id.string_convert == v.getId()) {
            startActivity(JniStringActivity.class);
        } else if (R.id.reference_convert == v.getId()) {
            startActivity(JniReferenceTypeActivity.class);
        } else if (R.id.access_java_field == v.getId()) {
            startActivity(JniAccessFieldActivity.class);
        } else if (R.id.access_java_method == v.getId()) {
            startActivity(JniAccessMethodActivity.class);
        } else if (R.id.access_java_method_by_thread == v.getId()) {
            startActivity(JniInvokeMethodActivity.class);
        } else if (R.id.access_java_constructor == v.getId()) {
            startActivity(JniConstructorActivity.class);
        } else if (R.id.reference_manage == v.getId()) {
            startActivity(JniReferenceActivity.class);
        } else if (R.id.exception_manage == v.getId()) {
            startActivity(JniExceptionActivity.class);
        } else if (R.id.create_thread == v.getId()) {
            startActivity(JniThreadActivity.class);
        } else if (R.id.thread_sync == v.getId()) {
            startActivity(JniWaitNotifyActivity.class);
        } else if (R.id.bitmap_operate == v.getId()) {
            startActivity(JNIDynamicLoadActivity.class);
        }
    }

    private <T extends BaseActivity> void startActivity(Class<T> activityClazz) {
        Intent starter = new Intent(MainActivity.this, activityClazz);
        startActivity(starter);
    }
}