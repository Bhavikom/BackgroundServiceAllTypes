package com.yasoka.spcallrecord.recorder.call.a.d.a.b.a.e;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* renamed from: a.d.a.b.a.e.c reason: case insensitive filesystem */
public final class C0101c implements Creator<C0100b> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        Status status = null;
        while (parcel.dataPosition() < b2) {
            int readInt = parcel.readInt();
            if ((65535 & readInt) != 1) {
                SafeParcelReader.q(parcel, readInt);
            } else {
                status = (Status) SafeParcelReader.a(parcel, readInt, Status.CREATOR);
            }
        }
        SafeParcelReader.e(parcel, b2);
        return new C0100b(status);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C0100b[i];
    }
}
