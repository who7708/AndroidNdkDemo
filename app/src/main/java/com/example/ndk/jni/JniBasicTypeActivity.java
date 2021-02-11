package com.example.ndk.jni;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.ndk.BaseActivity;
import com.example.ndk.R;

public class JniBasicTypeActivity extends BaseActivity implements View.OnClickListener {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jni_basic_type);

        findViewById(R.id.primitive_int).setOnClickListener(this);
        findViewById(R.id.primitive_byte).setOnClickListener(this);
        findViewById(R.id.primitive_char).setOnClickListener(this);
        findViewById(R.id.primitive_short).setOnClickListener(this);
        findViewById(R.id.primitive_long).setOnClickListener(this);
        findViewById(R.id.primitive_float).setOnClickListener(this);
        findViewById(R.id.primitive_double).setOnClickListener(this);
        findViewById(R.id.primitive_boolean).setOnClickListener(this);

        textView = findViewById(R.id.sample_text);
    }

    @Override
    public void onClick(View v) {
        JniBasicType jniBasicType = new JniBasicType();
        if (R.id.primitive_int == v.getId()) {
            int ret = jniBasicType.callNativeInt(1);
            textView.setText(String.valueOf(ret));
        } else if (R.id.primitive_byte == v.getId()) {
            byte ret = jniBasicType.callNativeByte((byte) 2);
            textView.setText(String.valueOf(ret));
        } else if (R.id.primitive_char == v.getId()) {
            char ret = jniBasicType.callNativeChar('A');
            textView.setText(String.valueOf(ret));
        } else if (R.id.primitive_short == v.getId()) {
            short ret = jniBasicType.callNativeShort((short) 110);
            textView.setText(String.valueOf(ret));
        } else if (R.id.primitive_long == v.getId()) {
            long ret = jniBasicType.callNativeLong(119L);
            textView.setText(String.valueOf(ret));
        } else if (R.id.primitive_float == v.getId()) {
            float ret = jniBasicType.callNativeFloat(3.1415f);
            textView.setText(String.valueOf(ret));
        } else if (R.id.primitive_double == v.getId()) {
            double ret = jniBasicType.callNativeDouble(3.1415D);
            textView.setText(String.valueOf(ret));
        } else if (R.id.primitive_boolean == v.getId()) {
            boolean ret = jniBasicType.callNativeBoolean(Boolean.TRUE);
            textView.setText(String.valueOf(ret));
        }
    }
}