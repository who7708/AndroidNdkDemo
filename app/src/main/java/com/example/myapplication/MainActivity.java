package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.base.JniInvokeActivity;
import com.example.myapplication.load.JNIDynamicLoadActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void jniInvoke(View view) {
        Intent starter = new Intent(MainActivity.this, JniInvokeActivity.class);
        startActivity(starter);
    }

    public void dynamicRegister(View view) {
        Intent starter = new Intent(MainActivity.this, JNIDynamicLoadActivity.class);
        startActivity(starter);
    }

}