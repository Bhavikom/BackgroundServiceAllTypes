package com.yasoka.spcallrecord.recorder.call.a.d.a.b.a.e;

import a.d.a.a.i.s.b;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.C0126c;
import com.google.android.gms.common.api.internal.C0127d;
import com.google.android.gms.location.C0352g;

final class t extends j {

    /* renamed from: a reason: collision with root package name */
    private C0127d<C0352g> f492a;

    public t(C0127d<C0352g> dVar) {
        b.a(dVar != null, (Object) "listener can't be null.");
        this.f492a = dVar;
    }

    public final void a(C0352g gVar) throws RemoteException {
        ((C0126c) this.f492a).a((Object) gVar);
        this.f492a = null;
    }
}
