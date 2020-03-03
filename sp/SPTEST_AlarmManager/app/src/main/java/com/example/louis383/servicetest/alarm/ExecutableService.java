package com.example.louis383.servicetest.alarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.louis383.servicetest.jobintent.MyJobIntentService;

public class ExecutableService extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, " SPTEST AlarmFired ", Toast.LENGTH_LONG ).show();

        Intent mIntent = new Intent(context, MyJobIntentService.class);
        mIntent.putExtra("maxCountValue", 1000);
        MyJobIntentService.enqueueWork(context, mIntent);

    }
}
