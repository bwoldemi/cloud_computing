package com.bereket.screenmode;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.media.VolumeShaper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

     TextView prTv=null;
     TextView landTv=null;
    Switch swithch=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        prTv= findViewById(R.id.textPortrait);
        landTv= findViewById(R.id.textLandscape);

        swithch = (Switch)findViewById(R.id.scrChange);

        if(Configuration.ORIENTATION_LANDSCAPE ==
                this.getResources().getConfiguration().orientation){
            prTv.setText("");
            landTv.setText("Screen mode is set to landscape");

        }else if (Configuration.ORIENTATION_PORTRAIT ==
                this.getResources().getConfiguration().orientation){
            prTv.setText("Screen mode is set to portrait");
            landTv.setText("");

        }

        swithch.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if(isChecked==true){
                            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

                        }else{
                            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

                        }
                    }
                }
        );
    }

}
