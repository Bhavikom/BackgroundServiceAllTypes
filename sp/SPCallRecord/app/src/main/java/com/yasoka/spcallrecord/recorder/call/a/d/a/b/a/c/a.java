package com.yasoka.spcallrecord.recorder.call.a.d.a.b.a.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class a implements IInterface {

    /* renamed from: a reason: collision with root package name */
    private final IBinder f458a;

    /* renamed from: b reason: collision with root package name */
    private final String f459b;

    protected a(IBinder iBinder, String str) {
        this.f458a = iBinder;
        this.f459b = str;
    }

    /* access modifiers changed from: protected */
    public final Parcel a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f459b);
        return obtain;
    }

    public IBinder asBinder() {
        return this.f458a;
    }

    /* access modifiers changed from: protected */
    public final Parcel a(int i, Parcel parcel) throws RemoteException {
        parcel = Parcel.obtain();
        try {
            this.f458a.transact(i, parcel, parcel, 0);
            parcel.readException();
            return parcel;
        } catch (RuntimeException e2) {
            throw e2;
        } finally {
            parcel.recycle();
        }
    }
}
