package com.yasoka.spcallrecord.recorder.call.a.d.a.b.c.b;

import a.d.a.b.a.b.a;
import a.d.a.b.a.b.c;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public final class h extends a implements g {
    h(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    public final void a(i iVar, e eVar) throws RemoteException {
        Parcel e2 = e();
        c.a(e2, (Parcelable) iVar);
        if (eVar == null) {
            e2.writeStrongBinder(null);
        } else {
            e2.writeStrongBinder(eVar.asBinder());
        }
        a(12, e2);
    }
}
