package com.example.louis383.servicetest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.telephony.TelephonyManager;
import android.widget.Toast;

import java.util.Date;

public class ExampleBroadcastReceiver extends BroadcastReceiver {

    private static int lastState = TelephonyManager.CALL_STATE_IDLE;
    private static Date callStartTime;
    private static boolean isIncoming;
    private static String savedNumber;
    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, intent.getAction(), Toast.LENGTH_SHORT).show();

        /*if (intent.getAction().equals("android.intent.action.NEW_OUTGOING_CALL")) {
            savedNumber = intent.getExtras().getString("android.intent.extra.PHONE_NUMBER");
        }
        else{
            String stateStr = intent.getExtras().getString(TelephonyManager.EXTRA_STATE);
            String number = intent.getExtras().getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
            int state = 0;
            if(stateStr.equals(TelephonyManager.EXTRA_STATE_IDLE)){
                state = TelephonyManager.CALL_STATE_IDLE;
            }
            else if(stateStr.equals(TelephonyManager.EXTRA_STATE_OFFHOOK)){
                state = TelephonyManager.CALL_STATE_OFFHOOK;
            }
            else if(stateStr.equals(TelephonyManager.EXTRA_STATE_RINGING)){
                state = TelephonyManager.CALL_STATE_RINGING;
            }


            onCallStateChanged(context, state, number);
        }*/

        /*try {
            String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
            if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
                Toast.makeText(context, "Ringing State", Toast.LENGTH_SHORT).show();
            }
            if (state.equals(TelephonyManager.EXTRA_STATE_OFFHOOK)) {
                Toast.makeText(context, "Received State", Toast.LENGTH_SHORT).show();
            }
            if (state.equals(TelephonyManager.EXTRA_STATE_IDLE)) {
                Toast.makeText(context, "Idle State", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }*/
        /*if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            Toast.makeText(context, "Boot completed", Toast.LENGTH_SHORT).show();
        }

        else if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())) {
            Toast.makeText(context, "Connectivity changed", Toast.LENGTH_SHORT).show();
        }*/
    }
    public void onCallStateChanged(Context context, int state, String number) {
        if(lastState == state){
            //No change, debounce extras
            return;
        }
        switch (state) {
            case TelephonyManager.CALL_STATE_RINGING:
                isIncoming = true;
                callStartTime = new Date();
                savedNumber = number;
                Toast.makeText(context," incoming : "+isIncoming+" : "+callStartTime+" : "+savedNumber , Toast.LENGTH_SHORT).show();
                //onIncomingCallStarted(context, number, callStartTime);
                break;
            case TelephonyManager.CALL_STATE_OFFHOOK:
                //Transition of ringing->offhook are pickups of incoming calls.  Nothing done on them
                if(lastState != TelephonyManager.CALL_STATE_RINGING){
                    isIncoming = false;
                    callStartTime = new Date();
                    //onOutgoingCallStarted(context, savedNumber, callStartTime);
                    Toast.makeText(context," call state offhook  : "+isIncoming+" : "+callStartTime+" : " , Toast.LENGTH_SHORT).show();
                }

                break;
            case TelephonyManager.CALL_STATE_IDLE:
                //Went to idle-  this is the end of a call.  What type depends on previous state(s)
                if(lastState == TelephonyManager.CALL_STATE_RINGING){
                    //Ring but no pickup-  a miss
                    //onMissedCall(context, savedNumber, callStartTime);
                    Toast.makeText(context," missed call   : " , Toast.LENGTH_SHORT).show();
                }
                else if(isIncoming){
                    //onIncomingCallEnded(context, savedNumber, callStartTime, new Date());
                    Toast.makeText(context," Incoming : " , Toast.LENGTH_SHORT).show();
                }
                else{
                    //onOutgoingCallEnded(context, savedNumber, callStartTime, new Date());
                    Toast.makeText(context," outgoing " , Toast.LENGTH_SHORT).show();
                }
                break;
        }
        lastState = state;
    }
}
