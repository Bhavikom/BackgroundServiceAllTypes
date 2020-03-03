package com.yasoka.spcallrecord.recorder.call.a.d.a.b.a.e;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.internal.C0127d;
import com.google.android.gms.location.C0349d.a;
import com.google.android.gms.location.C0350e;
import com.google.android.gms.location.C0352g;

final class A extends a<C0352g> {
    private final /* synthetic */ C0350e n;
    private final /* synthetic */ String o = null;

    A(c cVar, C0350e eVar) {
        this.n = eVar;
        super(cVar);
    }

    public final /* synthetic */ g a(Status status) {
        return new C0352g(status, null);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void a(b bVar) throws RemoteException {
        ((r) bVar).a(this.n, (C0127d<C0352g>) this, this.o);
    }
}
