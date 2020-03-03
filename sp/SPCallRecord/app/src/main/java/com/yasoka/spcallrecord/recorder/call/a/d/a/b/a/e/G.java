package com.yasoka.spcallrecord.recorder.call.a.d.a.b.a.e;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.location.A;
import com.google.android.gms.location.z;

public final class G extends a {
    public static final Creator<G> CREATOR = new H();

    /* renamed from: a reason: collision with root package name */
    private int f475a;

    /* renamed from: b reason: collision with root package name */
    private E f476b;

    /* renamed from: c reason: collision with root package name */
    private z f477c;

    /* renamed from: d reason: collision with root package name */
    private C0102d f478d;

    G(int i, E e2, IBinder iBinder, IBinder iBinder2) {
        this.f475a = i;
        this.f476b = e2;
        C0102d dVar = null;
        this.f477c = iBinder == null ? null : A.a(iBinder);
        if (iBinder2 != null) {
            IInterface queryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            dVar = queryLocalInterface instanceof C0102d ? (C0102d) queryLocalInterface : new C0104f(iBinder2);
        }
        this.f478d = dVar;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelReader.a(parcel);
        SafeParcelReader.a(parcel, 1, this.f475a);
        SafeParcelReader.a(parcel, 2, (Parcelable) this.f476b, i, false);
        z zVar = this.f477c;
        IBinder iBinder = null;
        SafeParcelReader.a(parcel, 3, zVar == null ? null : zVar.asBinder(), false);
        C0102d dVar = this.f478d;
        if (dVar != null) {
            iBinder = dVar.asBinder();
        }
        SafeParcelReader.a(parcel, 4, iBinder, false);
        SafeParcelReader.f(parcel, a2);
    }
}
