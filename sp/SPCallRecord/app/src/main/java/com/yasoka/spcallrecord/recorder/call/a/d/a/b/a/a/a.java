package com.yasoka.spcallrecord.recorder.call.a.d.a.b.a.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class a implements IInterface {

    /* renamed from: a reason: collision with root package name */
    private final IBinder f454a;

    /* renamed from: b reason: collision with root package name */
    private final String f455b;

    protected a(IBinder iBinder, String str) {
        this.f454a = iBinder;
        this.f455b = str;
    }

    /* access modifiers changed from: protected */
    public final Parcel a(int i, Parcel parcel) throws RemoteException {
        parcel = Parcel.obtain();
        try {
            this.f454a.transact(i, parcel, parcel, 0);
            parcel.readException();
            return parcel;
        } catch (RuntimeException e2) {
            throw e2;
        } finally {
            parcel.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f454a;
    }

    /* access modifiers changed from: protected */
    public final Parcel e() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f455b);
        return obtain;
    }
}
