package ru.otus.demo.services.bound;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DemoServiceConnection implements ServiceConnection {


    @Nullable
    private BoundService mService;

    private boolean attemptingToBind = false;
    private boolean bound = false;

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        mService = ((BoundService.DemoBinder) service).getService();
        attemptingToBind = false;
        bound = true;
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        mService = null;
        bound = false;
    }

    public void bindToService(@NonNull Context ctx) {
        if (!attemptingToBind) {
            attemptingToBind = true;
            ctx.bindService(new Intent(ctx, BoundService.class), this, Context.BIND_AUTO_CREATE);
        }
    }

    public void unbindFromService(@NonNull Context ctx) {
        attemptingToBind = false;
        if (bound) {
            ctx.unbindService(this);
            bound = false;
        }
    }

    @Nullable
    public BoundService getService() {
        return mService;
    }

    public boolean isConnected() {
        return mService != null && bound;
    }

}
