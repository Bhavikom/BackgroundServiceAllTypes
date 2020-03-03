package com.yasoka.spcallrecord.recorder.call.a.d.a.a.i;

import a.d.a.a.b;
import a.d.a.a.c;
import a.d.a.a.e;
import a.d.a.a.f;
import a.d.a.a.h;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
final class m<T> implements f<T> {

    /* renamed from: a reason: collision with root package name */
    private final j f355a;

    /* renamed from: b reason: collision with root package name */
    private final String f356b;

    /* renamed from: c reason: collision with root package name */
    private final b f357c;

    /* renamed from: d reason: collision with root package name */
    private final e<T, byte[]> f358d;

    /* renamed from: e reason: collision with root package name */
    private final n f359e;

    m(j jVar, String str, b bVar, e<T, byte[]> eVar, n nVar) {
        this.f355a = jVar;
        this.f356b = str;
        this.f357c = bVar;
        this.f358d = eVar;
        this.f359e = nVar;
    }

    public void a(c<T> cVar) {
        h a2 = l.a();
        n nVar = this.f359e;
        C0008b bVar = new C0008b();
        bVar.a(this.f355a);
        bVar.a(cVar);
        bVar.a(this.f356b);
        bVar.a(this.f358d);
        bVar.a(this.f357c);
        ((o) nVar).a(bVar.a(), a2);
    }
}
