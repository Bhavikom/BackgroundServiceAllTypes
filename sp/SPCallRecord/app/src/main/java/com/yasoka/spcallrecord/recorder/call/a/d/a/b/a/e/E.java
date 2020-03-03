package com.yasoka.spcallrecord.recorder.call.a.d.a.b.a.e;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.C0151c;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.location.u;
import java.util.Collections;
import java.util.List;

public final class E extends a {
    public static final Creator<E> CREATOR = new F();

    /* renamed from: d reason: collision with root package name */
    static final List<C0151c> f470d = Collections.emptyList();

    /* renamed from: e reason: collision with root package name */
    static final u f471e = new u();

    /* renamed from: a reason: collision with root package name */
    private u f472a;

    /* renamed from: b reason: collision with root package name */
    private List<C0151c> f473b;
    @Nullable

    /* renamed from: c reason: collision with root package name */
    private String f474c;

    E(u uVar, List<C0151c> list, String str) {
        this.f472a = uVar;
        this.f473b = list;
        this.f474c = str;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof E)) {
            return false;
        }
        E e2 = (E) obj;
        return r.a(this.f472a, e2.f472a) && r.a(this.f473b, e2.f473b) && r.a(this.f474c, e2.f474c);
    }

    public final int hashCode() {
        return this.f472a.hashCode();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelReader.a(parcel);
        SafeParcelReader.a(parcel, 1, (Parcelable) this.f472a, i, false);
        SafeParcelReader.b(parcel, 2, this.f473b, false);
        SafeParcelReader.a(parcel, 3, this.f474c, false);
        SafeParcelReader.f(parcel, a2);
    }
}
