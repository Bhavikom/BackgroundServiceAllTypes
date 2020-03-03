package com.yasoka.spcallrecord.recorder.call.a.d.a.b.a.e;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class B {
    static {
        B.class.getClassLoader();
    }

    private B() {
    }

    public static <T extends Parcelable> T a(Parcel parcel, Creator<T> creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return (Parcelable) creator.createFromParcel(parcel);
    }

    public static void a(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 0);
    }

    public static void a(Parcel parcel, boolean z) {
        parcel.writeInt(z ? 1 : 0);
    }
}
