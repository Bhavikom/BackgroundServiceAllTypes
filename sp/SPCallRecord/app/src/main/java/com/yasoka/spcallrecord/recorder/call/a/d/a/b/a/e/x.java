package com.yasoka.spcallrecord.recorder.call.a.d.a.b.a.e;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class x implements Creator<w> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        u uVar = null;
        IBinder iBinder = null;
        PendingIntent pendingIntent = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        int i = 1;
        while (parcel.dataPosition() < b2) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = SafeParcelReader.m(parcel, readInt);
                    break;
                case 2:
                    uVar = (u) SafeParcelReader.a(parcel, readInt, u.CREATOR);
                    break;
                case 3:
                    iBinder = SafeParcelReader.l(parcel, readInt);
                    break;
                case 4:
                    pendingIntent = (PendingIntent) SafeParcelReader.a(parcel, readInt, PendingIntent.CREATOR);
                    break;
                case 5:
                    iBinder2 = SafeParcelReader.l(parcel, readInt);
                    break;
                case 6:
                    iBinder3 = SafeParcelReader.l(parcel, readInt);
                    break;
                default:
                    SafeParcelReader.q(parcel, readInt);
                    break;
            }
        }
        SafeParcelReader.e(parcel, b2);
        w wVar = new w(i, uVar, iBinder, pendingIntent, iBinder2, iBinder3);
        return wVar;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new w[i];
    }
}
