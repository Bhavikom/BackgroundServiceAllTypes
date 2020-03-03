package com.yasoka.spcallrecord.recorder.call.a.d.a.b.a.f;

import a.d.a.b.b.b;
import a.d.a.b.b.f;
import a.d.a.b.b.i;
import a.d.a.b.b.k;
import a.d.a.b.b.m;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

public abstract class g extends b implements f {
    public g() {
        super("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
    }

    /* access modifiers changed from: protected */
    public final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            Status status = (Status) c.a(parcel, Status.CREATOR);
            f fVar = (f) c.a(parcel, f.CREATOR);
            d dVar = (d) this;
            throw new UnsupportedOperationException();
        } else if (i == 2) {
            parcel.readString();
            d dVar2 = (d) this;
            throw new UnsupportedOperationException();
        } else if (i != 3) {
            boolean z = false;
            if (i == 4) {
                Status status2 = (Status) c.a(parcel, Status.CREATOR);
                if (parcel.readInt() != 0) {
                    z = true;
                }
                a(status2, z);
                return true;
            } else if (i == 6) {
                Status status3 = (Status) c.a(parcel, Status.CREATOR);
                k kVar = (k) c.a(parcel, k.CREATOR);
                d dVar3 = (d) this;
                throw new UnsupportedOperationException();
            } else if (i == 8) {
                Status status4 = (Status) c.a(parcel, Status.CREATOR);
                i iVar = (i) c.a(parcel, i.CREATOR);
                d dVar4 = (d) this;
                throw new UnsupportedOperationException();
            } else if (i == 15) {
                Status status5 = (Status) c.a(parcel, Status.CREATOR);
                m mVar = (m) c.a(parcel, m.CREATOR);
                d dVar5 = (d) this;
                throw new UnsupportedOperationException();
            } else if (i == 10) {
                Status status6 = (Status) c.a(parcel, Status.CREATOR);
                int readInt = parcel.readInt();
                d dVar6 = (d) this;
                throw new UnsupportedOperationException();
            } else if (i != 11) {
                return false;
            } else {
                Status status7 = (Status) c.a(parcel, Status.CREATOR);
                d dVar7 = (d) this;
                throw new UnsupportedOperationException();
            }
        } else {
            Status status8 = (Status) c.a(parcel, Status.CREATOR);
            b bVar = (b) c.a(parcel, b.CREATOR);
            d dVar8 = (d) this;
            throw new UnsupportedOperationException();
        }
    }
}
