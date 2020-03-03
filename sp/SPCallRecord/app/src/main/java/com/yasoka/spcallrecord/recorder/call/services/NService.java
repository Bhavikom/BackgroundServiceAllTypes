package com.yasoka.spcallrecord.recorder.call.services;

/*import a.c.j.c;
import a.e.a.a.a.a;*/
import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Process;
import androidx.core.app.NotificationManagerCompat;
/*import com.crashlytics.android.Crashlytics;
import com.recorder.call.services.INService.Stub;*/
import com.yasoka.spcallrecord.recorder.call.a.c.j.c;
import com.yasoka.spcallrecord.recorder.call.a.e.a.a.a.a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class NService extends Service {
    private final INService.Stub mBinder = new INService.Stub() {
        public long x(int i, int i2) {
            try {
                return NService.this.c(NService.this.getApplicationContext(), i, NService.this.getCmdBytes(i2));
            } catch (Exception e2) {
                e2.getStackTrace();
                return -1;
            }
        }
    };
    private WakeLock wakeLock;

    static {
        System.loadLibrary("ca");
        System.loadLibrary("cb");
    }

    /* access modifiers changed from: private */
    public native long c(Context context, int i, byte[] bArr);

    /* access modifiers changed from: private */
    public byte[] getCmdBytes(int i) {
        long i2 = i(Process.myPid());
        boolean l = a.l();
        boolean m = a.m();
        ByteBuffer allocate = ByteBuffer.allocate(524);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.putLong(i2);
        allocate.putInt(VERSION.SDK_INT);
        allocate.putInt(i);
        allocate.putInt(l ? 1 : 0);
        allocate.putInt(m ? 1 : 0);
        return allocate.array();
    }

    private native long i(int i);

    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }

    @SuppressLint({"InvalidWakeLockTag"})
    public void onCreate() {
        super.onCreate();
        try {
            if (VERSION.SDK_INT >= 26 || !NotificationManagerCompat.from(this).areNotificationsEnabled()) {
                startForeground(19550, c.a((Context) this));
            }
            if (VERSION.SDK_INT < 26) {
                try {
                    PowerManager powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
                    if (powerManager != null) {
                        this.wakeLock = powerManager.newWakeLock(1, "MyWakeLockRecordCallNService");
                        this.wakeLock.acquire(8000);
                    }
                } catch (Exception e2) {
                    e2.getStackTrace();
                }
            }
        } catch (Exception e3) {
            e3.getStackTrace();
            try {
                e3.getStackTrace();
                //Crashlytics.logException(e3);
            } catch (Exception unused) {
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }
}
