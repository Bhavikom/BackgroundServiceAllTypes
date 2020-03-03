package com.yasoka.spcallrecord.recorder.call.a.d.a.b.c.b;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.C0168u;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.a;

public final class k extends a {
    public static final Creator<k> CREATOR = new l();

    /* renamed from: a reason: collision with root package name */
    private final int f538a;

    /* renamed from: b reason: collision with root package name */
    private final b f539b;

    /* renamed from: c reason: collision with root package name */
    private final C0168u f540c;

    k(int i, b bVar, C0168u uVar) {
        this.f538a = i;
        this.f539b = bVar;
        this.f540c = uVar;
    }

    public final b q() {
        return this.f539b;
    }

    public final C0168u r() {
        return this.f540c;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelReader.a(parcel);
        SafeParcelReader.a(parcel, 1, this.f538a);
        SafeParcelReader.a(parcel, 2, (Parcelable) this.f539b, i, false);
        SafeParcelReader.a(parcel, 3, (Parcelable) this.f540c, i, false);
        SafeParcelReader.f(parcel, a2);
    }

    public k() {
        this(1, new b(8, null, null), null);
    }
}
