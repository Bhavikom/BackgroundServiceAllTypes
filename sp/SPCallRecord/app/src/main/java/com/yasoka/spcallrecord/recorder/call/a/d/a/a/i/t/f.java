package com.yasoka.spcallrecord.recorder.call.a.d.a.a.i.t;

import a.d.a.a.d;
import b.b.b;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.g;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.g.c;
import d.a.a;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final class f implements b<g> {

    /* renamed from: a reason: collision with root package name */
    private final a<a.d.a.a.i.u.a> f387a;

    public f(a<a.d.a.a.i.u.a> aVar) {
        this.f387a = aVar;
    }

    public Object get() {
        a.d.a.a.i.u.a aVar = (a.d.a.a.i.u.a) this.f387a.get();
        g.a aVar2 = new g.a();
        d dVar = d.DEFAULT;
        g.b.a d2 = g.b.d();
        d2.a(30000);
        d2.b(86400000);
        aVar2.a(dVar, d2.a());
        d dVar2 = d.HIGHEST;
        g.b.a d3 = g.b.d();
        d3.a(1000);
        d3.b(86400000);
        aVar2.a(dVar2, d3.a());
        d dVar3 = d.VERY_LOW;
        g.b.a d4 = g.b.d();
        d4.a(86400000);
        d4.b(86400000);
        d4.a(Collections.unmodifiableSet(new HashSet(Arrays.asList(new c[]{c.NETWORK_UNMETERED, c.DEVICE_IDLE}))));
        aVar2.a(dVar3, d4.a());
        aVar2.a(aVar);
        g a2 = aVar2.a();
        a.d.a.a.i.s.b.b(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }
}
