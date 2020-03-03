package com.yasoka.spcallrecord.recorder.call.a.d.a.b.b;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class h implements Creator<a> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        String str = null;
        byte[] bArr = null;
        int i = 0;
        while (parcel.dataPosition() < b2) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 2) {
                str = SafeParcelReader.c(parcel, readInt);
            } else if (i2 == 3) {
                bArr = SafeParcelReader.b(parcel, readInt);
            } else if (i2 != 4) {
                SafeParcelReader.q(parcel, readInt);
            } else {
                i = SafeParcelReader.m(parcel, readInt);
            }
        }
        SafeParcelReader.e(parcel, b2);
        return new a(str, bArr, i);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new a[i];
    }
}
