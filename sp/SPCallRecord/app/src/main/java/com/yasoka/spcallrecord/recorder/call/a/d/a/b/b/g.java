package com.yasoka.spcallrecord.recorder.call.a.d.a.b.b;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class g implements Creator<f> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        String str = null;
        while (parcel.dataPosition() < b2) {
            int readInt = parcel.readInt();
            if ((65535 & readInt) != 2) {
                SafeParcelReader.q(parcel, readInt);
            } else {
                str = SafeParcelReader.c(parcel, readInt);
            }
        }
        SafeParcelReader.e(parcel, b2);
        return new f(str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new f[i];
    }
}
