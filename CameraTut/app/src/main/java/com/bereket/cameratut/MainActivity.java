package com.bereket.cameratut;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    static final int REQUEST_IMAGE_CAPTURE = 1;

    ImageView imageView= null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.take_picture);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY)==true){
                    dispatchTakeCameraIntent();
                }

            }
        });
        imageView = findViewById(R.id.image_placeholder);

    }

    private  void dispatchTakeCameraIntent (){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(takePictureIntent.resolveActivity(getPackageManager())!=null){
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==REQUEST_IMAGE_CAPTURE && resultCode==RESULT_OK){

            Bundle extras = data.getExtras();
            if(extras.containsKey("data")){
                startTumbnailActivity(extras);
            }
            //Bitmap imageBitmap= (Bitmap)extras.get("data");
            //imageView.setImageBitmap(imageBitmap);

        }

       // super.onActivityResult(requestCode, resultCode, data);
    }

    public void startTumbnailActivity(Bundle extras ){
        Intent intent = new Intent(getApplicationContext(), ImgeTumbilActivity.class);
        intent.putExtra("data", extras);
        startActivity(intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
    public void uploadFile(){
        File file;
        String content
    }
    private String getMimeType(String string){

    }
}
