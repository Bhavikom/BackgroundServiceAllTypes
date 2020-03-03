package com.yasoka.spcallrecord.recorder.call.a.d.a.b.b;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class j implements Creator<i> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        long j = 0;
        a[] aVarArr = null;
        int i = 0;
        boolean z = false;
        while (parcel.dataPosition() < b2) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 2) {
                j = SafeParcelReader.n(parcel, readInt);
            } else if (i2 == 3) {
                aVarArr = (a[]) SafeParcelReader.b(parcel, readInt, a.CREATOR);
            } else if (i2 == 4) {
                i = SafeParcelReader.m(parcel, readInt);
            } else if (i2 != 5) {
                SafeParcelReader.q(parcel, readInt);
            } else {
                z = SafeParcelReader.g(parcel, readInt);
            }
        }
        SafeParcelReader.e(parcel, b2);
        i iVar = new i(j, aVarArr, i, z);
        return iVar;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new i[i];
    }
}
