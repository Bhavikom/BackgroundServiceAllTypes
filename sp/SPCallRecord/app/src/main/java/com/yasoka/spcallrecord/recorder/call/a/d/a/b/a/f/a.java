package com.yasoka.spcallrecord.recorder.call.a.d.a.b.a.f;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class a implements IInterface {

    /* renamed from: a reason: collision with root package name */
    private final IBinder f503a;

    /* renamed from: b reason: collision with root package name */
    private final String f504b;

    protected a(IBinder iBinder, String str) {
        this.f503a = iBinder;
        this.f504b = str;
    }

    /* access modifiers changed from: protected */
    public final void a(int i, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            this.f503a.transact(i, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f503a;
    }

    /* access modifiers changed from: protected */
    public final Parcel e() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f504b);
        return obtain;
    }
}
