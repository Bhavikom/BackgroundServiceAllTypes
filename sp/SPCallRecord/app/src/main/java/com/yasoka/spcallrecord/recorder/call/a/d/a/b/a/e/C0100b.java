package com.yasoka.spcallrecord.recorder.call.a.d.a.b.a.e;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.a;

/* renamed from: a.d.a.b.a.e.b reason: case insensitive filesystem */
public final class C0100b extends a implements g {
    public static final Creator<C0100b> CREATOR = new C0101c();

    /* renamed from: a reason: collision with root package name */
    private final Status f481a;

    static {
        new C0100b(Status.f1493e);
    }

    public C0100b(Status status) {
        this.f481a = status;
    }

    public final Status o() {
        return this.f481a;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelReader.a(parcel);
        SafeParcelReader.a(parcel, 1, (Parcelable) this.f481a, i, false);
        SafeParcelReader.f(parcel, a2);
    }
}
