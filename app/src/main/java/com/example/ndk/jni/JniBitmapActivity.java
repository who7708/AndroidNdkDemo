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
                // Bitmap mirrorBitmap = jniBitmap.callNativeMirrorBitmap(bitmap);
                Bitmap mirrorBitmap = jniBitmap.callNativeMirrorBitmap2(bitmap);
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

    Bitmap mirrorBitmap2(Bitmap bitmap, int width, int height) {
        int w = bitmap.getWidth();
        int h = bitmap.getHeight();
        // 创建一个新的和SRC长度宽度一样的位图
        // Bitmap newBitmap = Bitmap.createBitmap(ww, wh, Bitmap.Config.ARGB_8888);
        Bitmap newBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        return newBitmap;
    }
}