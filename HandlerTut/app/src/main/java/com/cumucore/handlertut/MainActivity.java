package com.cumucore.handlertut;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    Thread thread;
    TextView textView;
    Handler handler;
    final static int START_SHOW_MSG= 1000;
    final static int UPDATE_COUNT=2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.my_textview);

        thread = new Thread(new Runnable() {
            int counter = 0;

            @Override
            public void run() {
                while ( counter < 20){
                    try{
                        Thread.sleep(1000);
                    }catch (Exception ex){
                        ex.printStackTrace();
                    }
                    Message message = new Message();
                    message.what=UPDATE_COUNT;
                    message.arg1= counter;
                    message.obj = "counter"+counter;
                    handler.sendMessage(message);
                    counter++;

                }


            }
        });
        Button button = findViewById(R.id.start_msg_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(handler.hasMessages(START_SHOW_MSG)){
                    return;
                }
                handler.sendEmptyMessage(START_SHOW_MSG);

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        handler = new Handler( ){
            @Override
            public void handleMessage(Message msg) {
                if(msg.what==START_SHOW_MSG){
                    thread.start();
                }else if(msg.what==UPDATE_COUNT){
                    textView.setText("arg1"+ msg.arg1+ " Obj"+ msg.obj);
                }
            }
        };
        handler.sendEmptyMessage(START_SHOW_MSG);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(thread);
    }
}
