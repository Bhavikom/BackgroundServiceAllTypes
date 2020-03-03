package com.yasoka.spcallrecord.recorder.call.a.d.a.b.b;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.a;

public final class i extends a {
    public static final Creator<i> CREATOR = new j();

    /* renamed from: a reason: collision with root package name */
    public final long f521a;

    /* renamed from: b reason: collision with root package name */
    public final a[] f522b;

    /* renamed from: c reason: collision with root package name */
    public final int f523c;

    /* renamed from: d reason: collision with root package name */
    private final boolean f524d;

    public i(long j, a[] aVarArr, int i, boolean z) {
        this.f521a = j;
        this.f522b = aVarArr;
        this.f524d = z;
        if (z) {
            this.f523c = i;
        } else {
            this.f523c = -1;
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelReader.a(parcel);
        SafeParcelReader.a(parcel, 2, this.f521a);
        SafeParcelReader.a(parcel, 3, (T[]) this.f522b, i, false);
        SafeParcelReader.a(parcel, 4, this.f523c);
        SafeParcelReader.a(parcel, 5, this.f524d);
        SafeParcelReader.f(parcel, a2);
    }
}
