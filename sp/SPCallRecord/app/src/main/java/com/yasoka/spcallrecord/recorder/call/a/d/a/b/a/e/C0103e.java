package com.yasoka.spcallrecord.recorder.call.a.d.a.b.a.e;

import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: a.d.a.b.a.e.e reason: case insensitive filesystem */
public abstract class C0103e extends s implements C0102d {
    public C0103e() {
        super("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        a((C0100b) B.a(parcel, C0100b.CREATOR));
        return true;
    }
}
