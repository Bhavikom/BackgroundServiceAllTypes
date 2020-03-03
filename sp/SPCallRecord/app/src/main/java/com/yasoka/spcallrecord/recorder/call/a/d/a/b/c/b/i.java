package com.yasoka.spcallrecord.recorder.call.a.d.a.b.c.b;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C0167t;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.a;

public final class i extends a {
    public static final Creator<i> CREATOR = new j();

    /* renamed from: a reason: collision with root package name */
    private final int f536a;

    /* renamed from: b reason: collision with root package name */
    private final C0167t f537b;

    i(int i, C0167t tVar) {
        this.f536a = i;
        this.f537b = tVar;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelReader.a(parcel);
        SafeParcelReader.a(parcel, 1, this.f536a);
        SafeParcelReader.a(parcel, 2, (Parcelable) this.f537b, i, false);
        SafeParcelReader.f(parcel, a2);
    }
}
