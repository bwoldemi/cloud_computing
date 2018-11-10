package com.bereket.cameratut;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class ImgeTumbilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_imge_tumbil);
       // Bundle extras= getIntent().getExtras();
       // Bitmap bitmap = (Bitmap) extras.get("data");
       // ImageView imageView = findViewById(R.id.img_thumbnail);
       // imageView.setImageBitmap(bitmap);
    }
}
