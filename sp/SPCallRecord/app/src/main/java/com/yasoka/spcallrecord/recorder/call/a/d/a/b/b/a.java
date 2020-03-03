package com.yasoka.spcallrecord.recorder.call.a.d.a.b.b;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public class a extends com.google.android.gms.common.internal.safeparcel.a {
    public static final Creator<a> CREATOR = new h();

    /* renamed from: a reason: collision with root package name */
    public final String f508a;

    /* renamed from: b reason: collision with root package name */
    public final byte[] f509b;

    /* renamed from: c reason: collision with root package name */
    public final int f510c;

    public a(String str, byte[] bArr, int i) {
        this.f508a = str;
        this.f509b = bArr;
        this.f510c = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelReader.a(parcel);
        SafeParcelReader.a(parcel, 2, this.f508a, false);
        SafeParcelReader.a(parcel, 3, this.f509b, false);
        SafeParcelReader.a(parcel, 4, this.f510c);
        SafeParcelReader.f(parcel, a2);
    }
}
