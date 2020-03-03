package com.yasoka.spcallrecord.recorder.call.a.d.a.b.c.b;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class c implements Creator<b> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        int i = 0;
        Intent intent = null;
        int i2 = 0;
        while (parcel.dataPosition() < b2) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i = SafeParcelReader.m(parcel, readInt);
            } else if (i3 == 2) {
                i2 = SafeParcelReader.m(parcel, readInt);
            } else if (i3 != 3) {
                SafeParcelReader.q(parcel, readInt);
            } else {
                intent = (Intent) SafeParcelReader.a(parcel, readInt, Intent.CREATOR);
            }
        }
        SafeParcelReader.e(parcel, b2);
        return new b(i, i2, intent);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new b[i];
    }
}
