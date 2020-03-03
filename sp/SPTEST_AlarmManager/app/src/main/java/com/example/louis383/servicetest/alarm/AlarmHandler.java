package com.example.louis383.servicetest.alarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

public class AlarmHandler {

    private Context context;

    public AlarmHandler(Context context){
        this.context = context;
    }
    public void setAlarmManager(){
        Intent intent = new Intent(context,ExecutableService.class);
        PendingIntent sender = PendingIntent.getBroadcast(context, 2, intent,0);
        AlarmManager am = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        if(am != null){
            long triggerAfter = 60* 60 * 1000;
            long triggerEvery = 60* 60 * 1000;

            //am.setRepeating(AlarmManager.RTC_WAKEUP, triggerAfter, triggerEvery, sender);
            // 60,000 millisecon == 60 seconds
            am.setRepeating(AlarmManager.RTC_WAKEUP, 0, 60000, sender);
        }
    }
    public void cancelAlarmManager(){
        Intent intent = new Intent(context,ExecutableService.class);
        PendingIntent sender = PendingIntent.getBroadcast(context, 2,intent,0);
        AlarmManager am = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        if(am != null) {
            am.cancel(sender);
        }

    }



}
