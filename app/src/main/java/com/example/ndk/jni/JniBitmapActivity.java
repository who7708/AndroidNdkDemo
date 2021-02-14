package com.example.ndk.jni;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.ndk.BaseActivity;
import com.example.ndk.R;

public class JniBitmapActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jni_bitmap);

        final ImageView imageView = findViewById(R.id.imageView);

        // final Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.t01dd2d7af7849b06d0);

        final JniBitmap jniBitmap = new JniBitmap();

        findViewById(R.id.imageView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
                Bitmap mirrorBitmap = jniBitmap.callNativeMirrorBitmap(bitmap);
                // Bitmap mirrorBitmap = mirrorBitmap(bitmap);
                imageView.setImageBitmap(mirrorBitmap);
            }
        });
    }

    private Bitmap mirrorBitmap(Bitmap bitmap) {
        Matrix m = new Matrix();
        //水平翻转
        m.setScale(-1, 1);
        //垂直翻转
        // m.setScale(1, -1);
        int w = bitmap.getWidth();
        int h = bitmap.getHeight();

        //生成的翻转后的bitmap
        return Bitmap.createBitmap(bitmap, 0, 0, w, h, m, true);
    }
}