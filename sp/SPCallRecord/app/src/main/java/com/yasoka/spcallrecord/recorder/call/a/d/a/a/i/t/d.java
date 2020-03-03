package com.yasoka.spcallrecord.recorder.call.a.d.a.a.i.t;

import a.d.a.a.i.t.h.C0096c;
import b.b.b;
import com.google.android.datatransport.runtime.backends.e;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.s;
import d.a.a;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final class d implements b<c> {

    /* renamed from: a reason: collision with root package name */
    private final a<Executor> f382a;

    /* renamed from: b reason: collision with root package name */
    private final a<e> f383b;

    /* renamed from: c reason: collision with root package name */
    private final a<s> f384c;

    /* renamed from: d reason: collision with root package name */
    private final a<C0096c> f385d;

    /* renamed from: e reason: collision with root package name */
    private final a<com.google.android.datatransport.runtime.synchronization.a> f386e;

    public d(a<Executor> aVar, a<e> aVar2, a<s> aVar3, a<C0096c> aVar4, a<com.google.android.datatransport.runtime.synchronization.a> aVar5) {
        this.f382a = aVar;
        this.f383b = aVar2;
        this.f384c = aVar3;
        this.f385d = aVar4;
        this.f386e = aVar5;
    }

    public Object get() {
        c cVar = new c((Executor) this.f382a.get(), (e) this.f383b.get(), (s) this.f384c.get(), (C0096c) this.f385d.get(), (com.google.android.datatransport.runtime.synchronization.a) this.f386e.get());
        return cVar;
    }
}
