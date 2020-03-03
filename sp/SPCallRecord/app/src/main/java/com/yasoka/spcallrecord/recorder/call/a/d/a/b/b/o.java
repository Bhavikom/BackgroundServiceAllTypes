package com.yasoka.spcallrecord.recorder.call.a.d.a.b.b;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class o implements Creator<b> {
    static void a(b bVar, Parcel parcel, int i) {
        int a2 = SafeParcelReader.a(parcel);
        SafeParcelReader.a(parcel, 2, bVar.t(), false);
        SafeParcelReader.a(parcel, 3, (Parcelable) bVar.q(), i, false);
        SafeParcelReader.a(parcel, 4, (Parcelable) bVar.r(), i, false);
        SafeParcelReader.a(parcel, 5, bVar.s());
        SafeParcelReader.a(parcel, 6, bVar.u(), false);
        SafeParcelReader.f(parcel, a2);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        String str = null;
        DataHolder dataHolder = null;
        ParcelFileDescriptor parcelFileDescriptor = null;
        byte[] bArr = null;
        long j = 0;
        while (parcel.dataPosition() < b2) {
            int readInt = parcel.readInt();
            int i = 65535 & readInt;
            if (i == 2) {
                str = SafeParcelReader.c(parcel, readInt);
            } else if (i == 3) {
                dataHolder = (DataHolder) SafeParcelReader.a(parcel, readInt, DataHolder.CREATOR);
            } else if (i == 4) {
                parcelFileDescriptor = (ParcelFileDescriptor) SafeParcelReader.a(parcel, readInt, ParcelFileDescriptor.CREATOR);
            } else if (i == 5) {
                j = SafeParcelReader.n(parcel, readInt);
            } else if (i != 6) {
                SafeParcelReader.q(parcel, readInt);
            } else {
                bArr = SafeParcelReader.b(parcel, readInt);
            }
        }
        SafeParcelReader.e(parcel, b2);
        b bVar = new b(str, dataHolder, parcelFileDescriptor, j, bArr);
        return bVar;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new b[i];
    }
}
