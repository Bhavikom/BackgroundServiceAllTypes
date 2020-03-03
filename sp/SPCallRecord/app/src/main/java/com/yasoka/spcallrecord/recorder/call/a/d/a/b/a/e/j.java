package com.yasoka.spcallrecord.recorder.call.a.d.a.b.a.e;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.C0352g;

public abstract class j extends s implements i {
    public j() {
        super("com.google.android.gms.location.internal.ISettingsCallbacks");
    }

    /* access modifiers changed from: protected */
    public final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        ((t) this).a((C0352g) B.a(parcel, C0352g.CREATOR));
        return true;
    }
}
