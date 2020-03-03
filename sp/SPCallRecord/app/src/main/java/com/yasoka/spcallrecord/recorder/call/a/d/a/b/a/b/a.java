package com.yasoka.spcallrecord.recorder.call.a.d.a.b.a.b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class a implements IInterface {

    /* renamed from: a reason: collision with root package name */
    private final IBinder f456a;

    /* renamed from: b reason: collision with root package name */
    private final String f457b;

    protected a(IBinder iBinder, String str) {
        this.f456a = iBinder;
        this.f457b = str;
    }

    /* access modifiers changed from: protected */
    public final void a(int i, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            this.f456a.transact(i, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f456a;
    }

    /* access modifiers changed from: protected */
    public final Parcel e() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f457b);
        return obtain;
    }
}
