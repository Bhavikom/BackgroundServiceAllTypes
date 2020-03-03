package com.yasoka.spcallrecord.recorder.call.a.d.a.a.i.t;

import a.d.a.a.h;
import a.d.a.a.i.g;
import a.d.a.a.i.j;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
final /* synthetic */ class a implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final c f370a;

    /* renamed from: b reason: collision with root package name */
    private final j f371b;

    /* renamed from: c reason: collision with root package name */
    private final h f372c;

    /* renamed from: d reason: collision with root package name */
    private final g f373d;

    private a(c cVar, j jVar, h hVar, g gVar) {
        this.f370a = cVar;
        this.f371b = jVar;
        this.f372c = hVar;
        this.f373d = gVar;
    }

    public static Runnable a(c cVar, j jVar, h hVar, g gVar) {
        return new a(cVar, jVar, hVar, gVar);
    }

    public void run() {
        c.a(this.f370a, this.f371b, this.f372c, this.f373d);
    }
}
