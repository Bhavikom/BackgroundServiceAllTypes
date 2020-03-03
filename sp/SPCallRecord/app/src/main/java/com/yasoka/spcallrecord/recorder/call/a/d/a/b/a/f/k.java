package com.yasoka.spcallrecord.recorder.call.a.d.a.b.a.f;

import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.c;

final class k extends a {
    k(c cVar) {
        super(cVar);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void a(b bVar) throws RemoteException {
        m mVar = (m) bVar;
        f fVar = this.n;
        i iVar = (i) mVar.n();
        Parcel e2 = iVar.e();
        c.a(e2, (IInterface) fVar);
        iVar.a(14, e2);
    }
}
