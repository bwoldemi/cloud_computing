package com.cumucore.servicetutorial;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.net.sip.SipException;
import android.net.sip.SipManager;
import android.net.sip.SipProfile;
import android.net.sip.SipRegistrationListener;
import android.os.IBinder;
import android.util.Log;

import java.text.ParseException;


public class MyService extends Service implements Runnable {

   private int counter = 0;
   public static SipManager mSipManager;
   public static SipProfile mSipProfile;
   private PendingIntent pendingIntent;

   public final static String IP_ADDRESS="192.168.1.2";
   public final static String USERNAME = "7001";
   public final static String PASSWORD="123";



   public static SipRegistrationListener registrationListener= new SipRegistrationListener() {
       @Override
       public void onRegistering(String localProfileUri) {
           Log.d("SERVICE123", "IBinder()***");
       }

       @Override
       public void onRegistrationDone(String localProfileUri, long expiryTime) {
           Log.d("SERVICE123", "IBinder()***");
       }

       @Override
       public void onRegistrationFailed(String localProfileUri, int errorCode, String errorMessage) {
           Log.d("SERVICE123", "IBinder()***");
       }
   };



    //@androidx.annotation.Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("SERVICE123", "IBinder()***");
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        try {
            SipProfile.Builder builder = new SipProfile.Builder(USERNAME, IP_ADDRESS);
            builder.setPassword(PASSWORD);
            mSipProfile = builder.build();

        }catch (ParseException pe){
            pe.printStackTrace();
        }

        intent.setAction("android.SipDemo.INCOMING_CALL");
        pendingIntent = PendingIntent.getBroadcast(this, 0, intent, Intent.FILL_IN_DATA);
        run();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d("SERVICE123", "IBinder()***");
       closeLocalProfile();
        super.onDestroy();
    }

    @Override
    public void onRebind(Intent intent) {
        try {
            SipProfile.Builder builder = new SipProfile.Builder(USERNAME, IP_ADDRESS);
            builder.setPassword(PASSWORD);
            mSipProfile = builder.build();

        }catch (ParseException pe){
            pe.printStackTrace();
        }
        run();

        super.onRebind(intent);
    }



    @Override
    public void run() {
        try{
            mSipManager.open(mSipProfile, pendingIntent, registrationListener);
        }catch (SipException sipex){
            sipex.printStackTrace();
        }

    }

    public static void closeLocalProfile() {
        if (mSipManager == null) {
            return;
        }
        try {
            if (mSipProfile != null) {
                mSipManager.close(mSipProfile.getUriString());
            }
        } catch (Exception ee) {
           ee.printStackTrace();
        }
    }
}
