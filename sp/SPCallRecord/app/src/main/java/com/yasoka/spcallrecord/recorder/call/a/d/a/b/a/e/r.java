package com.yasoka.spcallrecord.recorder.call.a.d.a.b.a.e;

import android.content.Context;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.api.c.a;
import com.google.android.gms.common.api.c.b;
import com.google.android.gms.common.api.internal.C0127d;
import com.google.android.gms.common.api.internal.C0132i;
import com.google.android.gms.common.internal.C0152d;
import com.google.android.gms.location.C0347b;
import com.google.android.gms.location.C0350e;
import com.google.android.gms.location.C0352g;

public final class r extends C {
    private final k A;

    public r(Context context, Looper looper, a aVar, b bVar, String str, C0152d dVar) {
        super(context, looper, aVar, bVar, str, dVar);
        this.A = new k(context, this.z);
    }

    public final void a(u uVar, C0132i<C0347b> iVar, C0102d dVar) throws RemoteException {
        synchronized (this.A) {
            this.A.a(uVar, iVar, dVar);
        }
    }

    public final void a(C0132i.a<C0347b> aVar, C0102d dVar) throws RemoteException {
        this.A.a(aVar, dVar);
    }

    public final void a(C0350e eVar, C0127d<C0352g> dVar, String str) throws RemoteException {
        e();
        boolean z = true;
        a.d.a.a.i.s.b.a(eVar != null, (Object) "locationSettingsRequest can't be null nor empty.");
        if (dVar == null) {
            z = false;
        }
        a.d.a.a.i.s.b.a(z, (Object) "listener can't be null.");
        t tVar = new t(dVar);
        C0106h hVar = (C0106h) n();
        Parcel e2 = hVar.e();
        B.a(e2, (Parcelable) eVar);
        e2.writeStrongBinder(tVar.asBinder());
        e2.writeString(str);
        hVar.a(63, e2);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:2|3|(2:5|6)|7|8|9) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0013 */
    public final void b() {
        synchronized (this.A) {
            if (q()) {
                this.A.a();
                this.A.b();
            }
            super.b();
        }
    }
}
