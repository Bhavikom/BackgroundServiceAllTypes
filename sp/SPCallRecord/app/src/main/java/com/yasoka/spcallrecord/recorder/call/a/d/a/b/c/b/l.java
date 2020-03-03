package com.yasoka.spcallrecord.recorder.call.a.d.a.b.c.b;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.C0168u;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class l implements Creator<k> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        b bVar = null;
        int i = 0;
        C0168u uVar = null;
        while (parcel.dataPosition() < b2) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                i = SafeParcelReader.m(parcel, readInt);
            } else if (i2 == 2) {
                bVar = (b) SafeParcelReader.a(parcel, readInt, b.CREATOR);
            } else if (i2 != 3) {
                SafeParcelReader.q(parcel, readInt);
            } else {
                uVar = (C0168u) SafeParcelReader.a(parcel, readInt, C0168u.CREATOR);
            }
        }
        SafeParcelReader.e(parcel, b2);
        return new k(i, bVar, uVar);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new k[i];
    }
}
