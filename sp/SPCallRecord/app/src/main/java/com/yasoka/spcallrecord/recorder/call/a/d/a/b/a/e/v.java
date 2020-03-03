package com.yasoka.spcallrecord.recorder.call.a.d.a.b.a.e;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C0151c;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.location.LocationRequest;
import java.util.List;

public final class v implements Creator<u> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        List<C0151c> list = u.h;
        LocationRequest locationRequest = null;
        String str = null;
        String str2 = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < b2) {
            int readInt = parcel.readInt();
            int i = 65535 & readInt;
            if (i != 1) {
                switch (i) {
                    case 5:
                        list = SafeParcelReader.c(parcel, readInt, C0151c.CREATOR);
                        break;
                    case 6:
                        str = SafeParcelReader.c(parcel, readInt);
                        break;
                    case 7:
                        z = SafeParcelReader.g(parcel, readInt);
                        break;
                    case 8:
                        z2 = SafeParcelReader.g(parcel, readInt);
                        break;
                    case 9:
                        z3 = SafeParcelReader.g(parcel, readInt);
                        break;
                    case 10:
                        str2 = SafeParcelReader.c(parcel, readInt);
                        break;
                    default:
                        SafeParcelReader.q(parcel, readInt);
                        break;
                }
            } else {
                locationRequest = (LocationRequest) SafeParcelReader.a(parcel, readInt, LocationRequest.CREATOR);
            }
        }
        SafeParcelReader.e(parcel, b2);
        u uVar = new u(locationRequest, list, str, z, z2, z3, str2);
        return uVar;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new u[i];
    }
}
