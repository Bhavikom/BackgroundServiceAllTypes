package com.yasoka.jobintentservicedemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.JobIntentService;

public class SimpleJobIntentService extends JobIntentService {

    static  final int JOB_ID = 1000;
    @Override
    protected void onHandleWork(@NonNull Intent intent) {
        Log.e(" handle work  ", " Executing work : "+ intent);
        if(intent.getAction() != null) {
            switch (intent.getAction()) {
                case MainActivity.ACTION_DO_STUFF:
                    int stuffToDO = 100;
                    for (int i = 0; i < stuffToDO; i++) {
                        Log.e(" in loop ", " Executing work : " + (i + 1) + " / 5 @ " + SystemClock.elapsedRealtime());
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Bundle bundle = new Bundle();
                        bundle.putInt("status", i);
                        sendBroadcast(new Intent().setAction(MainActivity.ACTION_CHECK_STATUS).putExtras(bundle));
                    }
                break;
            }
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        toast("All Work completed ");
    }

    static void enqueueWork(Context context, Intent work){
        enqueueWork(context, SimpleJobIntentService.class, JOB_ID, work);
    }
    final Handler mHandler = new Handler();
    void toast(final CharSequence text){
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(SimpleJobIntentService.this, text, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
