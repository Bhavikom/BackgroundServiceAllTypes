package ru.otus.demo.services;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;

import androidx.annotation.NonNull;

public class DemoService extends Service {

    private final static String TAG = DemoService.class.getSimpleName();

    private Looper mServiceLooper;
    private ServiceHandler mServiceHandler;

    // Handler that receives messages from the thread
    private final class ServiceHandler extends Handler {
        ServiceHandler(Looper looper) {
            super(looper);
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            Log.d(TAG, "handleMessage, msg.arg1:[" + msg.arg1 + "]");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Stop the service using the startId, so that we don't stop
            // the service in the middle of handling another job
            stopSelf(msg.arg1);
        }
    }

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate()");
        // Start up the thread running the service.  Note that we create a
        // separate thread because the service normally runs in the process's
        // main thread, which we don't want to block.  We also make it
        // background priority so CPU-intensive work will not disrupt our UI.
        HandlerThread thread = new HandlerThread(TAG,
                Process.THREAD_PRIORITY_BACKGROUND){
            @Override
            public void run() {
                Log.d(TAG, "run()");
                super.run();
                Log.d(TAG, "super.run()");

            }
        };
        thread.start();

        // Get the HandlerThread's Looper and use it for our Handler
        mServiceLooper = thread.getLooper();
        mServiceHandler = new ServiceHandler(mServiceLooper);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand()");

        // For each start request, send a message to start a job and deliver the
        // start ID so we know which request we're stopping when we finish the job
        Message msg = mServiceHandler.obtainMessage();
        msg.arg1 = startId;
        mServiceHandler.sendMessage(msg);

        // If we get killed, after returning from here, restart
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind()");
        // We don't provide binding, so return null
        return null;
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy()");
    }


}
