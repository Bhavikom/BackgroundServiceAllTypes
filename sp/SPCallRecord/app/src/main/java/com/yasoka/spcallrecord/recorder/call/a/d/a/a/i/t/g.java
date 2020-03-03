package com.yasoka.spcallrecord.recorder.call.a.d.a.a.i.t;

import a.d.a.a.i.t.h.C0096c;
import android.content.Context;
import android.os.Build.VERSION;
import b.b.b;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.e;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.s;
import d.a.a;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final class g implements b<s> {

    /* renamed from: a reason: collision with root package name */
    private final a<Context> f388a;

    /* renamed from: b reason: collision with root package name */
    private final a<C0096c> f389b;

    /* renamed from: c reason: collision with root package name */
    private final a<com.google.android.datatransport.runtime.scheduling.jobscheduling.g> f390c;

    /* renamed from: d reason: collision with root package name */
    private final a<a.d.a.a.i.u.a> f391d;

    public g(a<Context> aVar, a<C0096c> aVar2, a<com.google.android.datatransport.runtime.scheduling.jobscheduling.g> aVar3, a<a.d.a.a.i.u.a> aVar4) {
        this.f388a = aVar;
        this.f389b = aVar2;
        this.f390c = aVar3;
        this.f391d = aVar4;
    }

    public Object get() {
        Object obj;
        Context context = (Context) this.f388a.get();
        C0096c cVar = (C0096c) this.f389b.get();
        com.google.android.datatransport.runtime.scheduling.jobscheduling.g gVar = (com.google.android.datatransport.runtime.scheduling.jobscheduling.g) this.f390c.get();
        a.d.a.a.i.u.a aVar = (a.d.a.a.i.u.a) this.f391d.get();
        if (VERSION.SDK_INT >= 21) {
            obj = new e(context, cVar, gVar);
        } else {
            obj = new com.google.android.datatransport.runtime.scheduling.jobscheduling.a(context, cVar, aVar, gVar);
        }
        a.d.a.a.i.s.b.b(obj, "Cannot return null from a non-@Nullable @Provides method");
        return obj;
    }
}
