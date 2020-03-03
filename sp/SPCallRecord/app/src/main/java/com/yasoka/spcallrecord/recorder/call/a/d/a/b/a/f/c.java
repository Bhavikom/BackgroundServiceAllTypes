package com.yasoka.spcallrecord.recorder.call.a.d.a.b.a.f;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class c {
    static {
        c.class.getClassLoader();
    }

    private c() {
    }

    public static <T extends Parcelable> T a(Parcel parcel, Creator<T> creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return (Parcelable) creator.createFromParcel(parcel);
    }

    public static void a(Parcel parcel, IInterface iInterface) {
        parcel.writeStrongBinder(iInterface == null ? null : iInterface.asBinder());
    }
}
