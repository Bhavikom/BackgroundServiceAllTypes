package com.yasoka.spcallrecord.recorder.call.a.d.a.b.a.e;

import com.google.android.gms.common.api.internal.C0132i;
import com.google.android.gms.location.C0347b;
import com.google.android.gms.location.D;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;

final class l extends D {

    /* renamed from: a reason: collision with root package name */
    private final C0132i<C0347b> f487a;

    l(C0132i<C0347b> iVar) {
        this.f487a = iVar;
    }

    public final void a(LocationAvailability locationAvailability) {
        this.f487a.a(new n(locationAvailability));
    }

    public final void a(LocationResult locationResult) {
        this.f487a.a(new m(locationResult));
    }

    public final synchronized void e() {
        this.f487a.a();
    }
}
