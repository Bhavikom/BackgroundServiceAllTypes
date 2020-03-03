package com.yasoka.spcallrecord.recorder.call.a.d.a.b.a.e;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C0151c;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.location.u;
import java.util.List;

public final class F implements Creator<E> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        u uVar = E.f471e;
        List<C0151c> list = E.f470d;
        String str = null;
        while (parcel.dataPosition() < b2) {
            int readInt = parcel.readInt();
            int i = 65535 & readInt;
            if (i == 1) {
                uVar = (u) SafeParcelReader.a(parcel, readInt, u.CREATOR);
            } else if (i == 2) {
                list = SafeParcelReader.c(parcel, readInt, C0151c.CREATOR);
            } else if (i != 3) {
                SafeParcelReader.q(parcel, readInt);
            } else {
                str = SafeParcelReader.c(parcel, readInt);
            }
        }
        SafeParcelReader.e(parcel, b2);
        return new E(uVar, list, str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new E[i];
    }
}
