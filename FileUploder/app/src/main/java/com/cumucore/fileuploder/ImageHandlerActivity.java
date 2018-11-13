package com.cumucore.fileuploder;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ImageHandlerActivity extends AppCompatActivity {
    final String ServerName = "wwww.homepage.com";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_handler);

        Bundle extras = getIntent().getExtras();
        Bitmap bitmap = (Bitmap) extras.get("data");
        //ImageView imageView = findViewById(R.id.img_upload_button)
        Button uploadButton = findViewById(R.id.img_upload_button);

        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
            }
        });


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 100);
                return;

            }
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

    }
    /*
    public void uplodFile() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                File file = new File();
                String file_path = file.getAbsolutePath();
                String content_type = getMimeType(file.getPath());
                OkHttpClient client = new OkHttpClient();
                RequestBody file_body = RequestBody.create(MediaType.parse(content_type), file);
                RequestBody requestBody = new MultipartBody.Builder().
                        setType(MultipartBody.FORM).
                        addFormDataPart("type", content_type).
                        addFormDataPart("upload_file", file_path.substring("/") + 1).build();

                Request request = new Request.Builder().url("www.googl").post(requestBody).build();.
                try {
                    Response response = client.newCall(request).execute();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }


            }
        });
    }

    private String getMimeType(String path) {
        String extension = MimeTypeMap.getFileExtensionFromUrl(path);
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);

    }
    */
}