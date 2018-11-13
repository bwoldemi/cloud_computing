package com.cumucore.fileuploder;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ImageButton;

import java.io.File;


public class MainActivity extends AppCompatActivity {

    private final int REQUEST_IMAGE_CAPTURE= 0;
    private final int REQUEST_VIDEO_CAPTURE=1;
    private static final int READ_REQUEST_CODE = 42;
    private static final int READ_PERMISSION = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageButton cameraButton = findViewById(R.id.camera_button);
        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchTakePictureIntent();
            }
        });

        ImageButton videoButton= findViewById(R.id.video_button);
        videoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        ImageButton fileButton= findViewById(R.id.file_button);
        fileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performFileSearch();

            }
        });

    }
    private void dispatchTakePictureIntent() {

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }



    /**
     * Fires an intent to spin up the "file chooser" UI and select an image.
     */
    public void performFileSearch() {
        if(ActivityCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.READ_EXTERNAL_STORAGE)!=
                PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions
                    (this,
                            new String[]{Manifest.
                                    permission.READ_EXTERNAL_STORAGE},
                            READ_PERMISSION);
        }else {

        }

        // ACTION_OPEN_DOCUMENT is the intent to choose a file via the system's file
        // browser.
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);

        // Filter to only show results that can be "opened", such as a
        // file (as opposed to a list of contacts or timezones)
       // intent.addCategory(Intent.CATEGORY_OPENABLE);

        // Filter to show only images, using the image MIME data type.
        // If one wanted to search for ogg vorbis files, the type would be "audio/ogg".
        // To search for all documents available via installed storage providers,
        // it would be "*/*".
        //intent.setType("image/*");

        startActivityForResult(intent, READ_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Intent intent = new Intent(getBaseContext(), ImageHandlerActivity.class);
            intent.putExtras(extras);
            startActivity(intent);
        }else if (requestCode==REQUEST_VIDEO_CAPTURE && resultCode == RESULT_OK){
            Log.d("VIDEOCAPture"," capturing ");

        }else if (requestCode==READ_REQUEST_CODE && resultCode == RESULT_OK){
            Uri uri = null;
            if(data !=null){
                uri = data.getData();
             //   String path = uri.getPath();

                File file = new File(uri.getPath());
                String mimeType = getMimeType(file.getPath());
                if(mimeType !=null){
                    Log.d("TAG", mimeType);
                } else {
                    Log.d("TAG", "is Null");
                }


            }
        }
    }
    private String getMimeType(String path) {
        String extension = MimeTypeMap.getFileExtensionFromUrl(path);
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);

    }

}
