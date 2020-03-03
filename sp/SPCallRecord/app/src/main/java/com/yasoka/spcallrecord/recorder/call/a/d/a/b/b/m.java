package com.yasoka.spcallrecord.recorder.call.a.d.a.b.b;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.a;

public final class m extends a {
    public static final Creator<m> CREATOR = new n();

    /* renamed from: a reason: collision with root package name */
    private final int f526a;

    /* renamed from: b reason: collision with root package name */
    private final boolean f527b;

    public m(int i, boolean z) {
        this.f526a = i;
        this.f527b = z;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelReader.a(parcel);
        SafeParcelReader.a(parcel, 2, this.f526a);
        SafeParcelReader.a(parcel, 3, this.f527b);
        SafeParcelReader.f(parcel, a2);
    }
}
