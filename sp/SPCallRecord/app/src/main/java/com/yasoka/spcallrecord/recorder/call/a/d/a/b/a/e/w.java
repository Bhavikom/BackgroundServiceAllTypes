package com.yasoka.spcallrecord.recorder.call.a.d.a.b.a.e;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.location.C;
import com.google.android.gms.location.D;
import com.google.android.gms.location.F;
import com.google.android.gms.location.G;

public final class w extends a {
    public static final Creator<w> CREATOR = new x();

    /* renamed from: a reason: collision with root package name */
    private int f498a;

    /* renamed from: b reason: collision with root package name */
    private u f499b;

    /* renamed from: c reason: collision with root package name */
    private F f500c;

    /* renamed from: d reason: collision with root package name */
    private PendingIntent f501d;

    /* renamed from: e reason: collision with root package name */
    private C f502e;
    private C0102d f;

    w(int i, u uVar, IBinder iBinder, PendingIntent pendingIntent, IBinder iBinder2, IBinder iBinder3) {
        this.f498a = i;
        this.f499b = uVar;
        C0102d dVar = null;
        this.f500c = iBinder == null ? null : G.a(iBinder);
        this.f501d = pendingIntent;
        this.f502e = iBinder2 == null ? null : D.a(iBinder2);
        if (iBinder3 != null) {
            IInterface queryLocalInterface = iBinder3.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            dVar = queryLocalInterface instanceof C0102d ? (C0102d) queryLocalInterface : new C0104f(iBinder3);
        }
        this.f = dVar;
    }

    public static w a(C c2, @Nullable C0102d dVar) {
        w wVar = new w(2, null, null, null, c2.asBinder(), dVar != null ? dVar.asBinder() : null);
        return wVar;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelReader.a(parcel);
        SafeParcelReader.a(parcel, 1, this.f498a);
        SafeParcelReader.a(parcel, 2, (Parcelable) this.f499b, i, false);
        F f2 = this.f500c;
        IBinder iBinder = null;
        SafeParcelReader.a(parcel, 3, f2 == null ? null : f2.asBinder(), false);
        SafeParcelReader.a(parcel, 4, (Parcelable) this.f501d, i, false);
        C c2 = this.f502e;
        SafeParcelReader.a(parcel, 5, c2 == null ? null : c2.asBinder(), false);
        C0102d dVar = this.f;
        if (dVar != null) {
            iBinder = dVar.asBinder();
        }
        SafeParcelReader.a(parcel, 6, iBinder, false);
        SafeParcelReader.f(parcel, a2);
    }
}
