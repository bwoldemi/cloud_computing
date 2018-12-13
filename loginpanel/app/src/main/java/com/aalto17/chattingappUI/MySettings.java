package com.aalto17.chattingappUI;

import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class MySettings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getSupportFragmentManager().beginTransaction().replace(R.id.container_settings,new Setting()).commit();

    }

    public static class Setting extends PreferenceFragmentCompat{

        @Override
        public void onCreatePreferences(Bundle bundle, String s) {

        }
    }

}
