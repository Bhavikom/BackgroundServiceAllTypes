package com.yasoka.spcallrecord.recorder.call.a.d.a.b.b;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class n implements Creator<m> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        int i = 0;
        boolean z = false;
        while (parcel.dataPosition() < b2) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 2) {
                i = SafeParcelReader.m(parcel, readInt);
            } else if (i2 != 3) {
                SafeParcelReader.q(parcel, readInt);
            } else {
                z = SafeParcelReader.g(parcel, readInt);
            }
        }
        SafeParcelReader.e(parcel, b2);
        return new m(i, z);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new m[i];
    }
}
