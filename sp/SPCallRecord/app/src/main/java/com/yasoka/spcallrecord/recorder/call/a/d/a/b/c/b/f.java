package com.yasoka.spcallrecord.recorder.call.a.d.a.b.c.b;

import a.d.a.b.a.b.b;
import a.d.a.b.a.b.c;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;

public abstract class f extends b implements e {
    public f() {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    /* access modifiers changed from: protected */
    public boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 3) {
            com.google.android.gms.common.b bVar = (com.google.android.gms.common.b) c.a(parcel, com.google.android.gms.common.b.CREATOR);
            b bVar2 = (b) c.a(parcel, b.CREATOR);
            d dVar = (d) this;
        } else if (i == 4) {
            Status status = (Status) c.a(parcel, Status.CREATOR);
            d dVar2 = (d) this;
        } else if (i == 6) {
            Status status2 = (Status) c.a(parcel, Status.CREATOR);
            d dVar3 = (d) this;
        } else if (i == 7) {
            Status status3 = (Status) c.a(parcel, Status.CREATOR);
            GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) c.a(parcel, GoogleSignInAccount.CREATOR);
            d dVar4 = (d) this;
        } else if (i != 8) {
            return false;
        } else {
            a((k) c.a(parcel, k.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
