package com.yasoka.spcallrecord.recorder.call.a.d.a.b.c.b;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.a;

public final class b extends a implements g {
    public static final Creator<b> CREATOR = new c();

    /* renamed from: a reason: collision with root package name */
    private final int f533a;

    /* renamed from: b reason: collision with root package name */
    private int f534b;

    /* renamed from: c reason: collision with root package name */
    private Intent f535c;

    b(int i, int i2, Intent intent) {
        this.f533a = i;
        this.f534b = i2;
        this.f535c = intent;
    }

    public final Status o() {
        if (this.f534b == 0) {
            return Status.f1493e;
        }
        return Status.h;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelReader.a(parcel);
        SafeParcelReader.a(parcel, 1, this.f533a);
        SafeParcelReader.a(parcel, 2, this.f534b);
        SafeParcelReader.a(parcel, 3, (Parcelable) this.f535c, i, false);
        SafeParcelReader.f(parcel, a2);
    }

    public b() {
        this(2, 0, null);
    }
}
