package com.yasoka.spcallrecord.recorder.call.a.d.a.b.a.e;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: a.d.a.b.a.e.a reason: case insensitive filesystem */
public class C0099a implements IInterface {

    /* renamed from: a reason: collision with root package name */
    private final IBinder f479a;

    /* renamed from: b reason: collision with root package name */
    private final String f480b;

    protected C0099a(IBinder iBinder, String str) {
        this.f479a = iBinder;
        this.f480b = str;
    }

    /* access modifiers changed from: protected */
    public final void a(int i, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            this.f479a.transact(i, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f479a;
    }

    /* access modifiers changed from: protected */
    public final Parcel e() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f480b);
        return obtain;
    }
}
