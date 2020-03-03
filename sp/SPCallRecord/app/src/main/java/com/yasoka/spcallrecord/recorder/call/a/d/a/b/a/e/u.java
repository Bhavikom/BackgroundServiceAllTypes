package com.yasoka.spcallrecord.recorder.call.a.d.a.b.a.e;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.C0151c;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;

public final class u extends a {
    public static final Creator<u> CREATOR = new v();
    static final List<C0151c> h = Collections.emptyList();

    /* renamed from: a reason: collision with root package name */
    private LocationRequest f493a;

    /* renamed from: b reason: collision with root package name */
    private List<C0151c> f494b;
    @Nullable

    /* renamed from: c reason: collision with root package name */
    private String f495c;

    /* renamed from: d reason: collision with root package name */
    private boolean f496d;

    /* renamed from: e reason: collision with root package name */
    private boolean f497e;
    private boolean f;
    @Nullable
    private String g;

    u(LocationRequest locationRequest, List<C0151c> list, @Nullable String str, boolean z, boolean z2, boolean z3, String str2) {
        this.f493a = locationRequest;
        this.f494b = list;
        this.f495c = str;
        this.f496d = z;
        this.f497e = z2;
        this.f = z3;
        this.g = str2;
    }

    @Deprecated
    public static u a(LocationRequest locationRequest) {
        u uVar = new u(locationRequest, h, null, false, false, false, null);
        return uVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return r.a(this.f493a, uVar.f493a) && r.a(this.f494b, uVar.f494b) && r.a(this.f495c, uVar.f495c) && this.f496d == uVar.f496d && this.f497e == uVar.f497e && this.f == uVar.f && r.a(this.g, uVar.g);
    }

    public final int hashCode() {
        return this.f493a.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f493a);
        if (this.f495c != null) {
            sb.append(" tag=");
            sb.append(this.f495c);
        }
        if (this.g != null) {
            sb.append(" moduleId=");
            sb.append(this.g);
        }
        sb.append(" hideAppOps=");
        sb.append(this.f496d);
        sb.append(" clients=");
        sb.append(this.f494b);
        sb.append(" forceCoarseLocation=");
        sb.append(this.f497e);
        if (this.f) {
            sb.append(" exemptFromBackgroundThrottle");
        }
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelReader.a(parcel);
        SafeParcelReader.a(parcel, 1, (Parcelable) this.f493a, i, false);
        SafeParcelReader.b(parcel, 5, this.f494b, false);
        SafeParcelReader.a(parcel, 6, this.f495c, false);
        SafeParcelReader.a(parcel, 7, this.f496d);
        SafeParcelReader.a(parcel, 8, this.f497e);
        SafeParcelReader.a(parcel, 9, this.f);
        SafeParcelReader.a(parcel, 10, this.g, false);
        SafeParcelReader.f(parcel, a2);
    }
}
