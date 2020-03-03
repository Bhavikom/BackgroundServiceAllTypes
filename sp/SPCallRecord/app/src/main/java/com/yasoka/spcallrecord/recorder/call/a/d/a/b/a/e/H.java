package com.yasoka.spcallrecord.recorder.call.a.d.a.b.a.e;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class H implements Creator<G> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        E e2 = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        int i = 1;
        while (parcel.dataPosition() < b2) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                i = SafeParcelReader.m(parcel, readInt);
            } else if (i2 == 2) {
                e2 = (E) SafeParcelReader.a(parcel, readInt, E.CREATOR);
            } else if (i2 == 3) {
                iBinder = SafeParcelReader.l(parcel, readInt);
            } else if (i2 != 4) {
                SafeParcelReader.q(parcel, readInt);
            } else {
                iBinder2 = SafeParcelReader.l(parcel, readInt);
            }
        }
        SafeParcelReader.e(parcel, b2);
        return new G(i, e2, iBinder, iBinder2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new G[i];
    }
}
