package com.yasoka.spcallrecord.recorder.call.a.d.a.b.c.b;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C0167t;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class j implements Creator<i> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        int i = 0;
        C0167t tVar = null;
        while (parcel.dataPosition() < b2) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                i = SafeParcelReader.m(parcel, readInt);
            } else if (i2 != 2) {
                SafeParcelReader.q(parcel, readInt);
            } else {
                tVar = (C0167t) SafeParcelReader.a(parcel, readInt, C0167t.CREATOR);
            }
        }
        SafeParcelReader.e(parcel, b2);
        return new i(i, tVar);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new i[i];
    }
}
