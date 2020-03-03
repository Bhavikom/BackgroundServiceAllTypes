package com.yasoka.spcallrecord.recorder.call.a.d.a.b.b;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.a;

public final class k extends a {
    public static final Creator<k> CREATOR = new l();

    /* renamed from: a reason: collision with root package name */
    private final String f525a;

    public k(String str) {
        this.f525a = str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelReader.a(parcel);
        SafeParcelReader.a(parcel, 2, this.f525a, false);
        SafeParcelReader.f(parcel, a2);
    }
}
