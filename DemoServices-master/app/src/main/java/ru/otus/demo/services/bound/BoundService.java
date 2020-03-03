package ru.otus.demo.services.bound;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import androidx.annotation.NonNull;

public class BoundService extends Service {

    private final IBinder mBinder = new DemoBinder();

    @NonNull
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    class DemoBinder extends Binder {
        BoundService getService() {
            return BoundService.this;
        }
    }

    public long getTime() {
        return System.currentTimeMillis();
    }



}
