package com.yasoka.spcallrecord.recorder.call.a.d.a.b.a.a;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class f extends a implements d {
    f(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
    }

    public final boolean a(boolean z) throws RemoteException {
        Parcel e2 = e();
        c.a(e2);
        Parcel a2 = a(2, e2);
        boolean a3 = c.a(a2);
        a2.recycle();
        return a3;
    }

    public final boolean c() throws RemoteException {
        Parcel a2 = a(6, e());
        boolean a3 = c.a(a2);
        a2.recycle();
        return a3;
    }

    public final String f() throws RemoteException {
        Parcel a2 = a(1, e());
        String readString = a2.readString();
        a2.recycle();
        return readString;
    }
}
