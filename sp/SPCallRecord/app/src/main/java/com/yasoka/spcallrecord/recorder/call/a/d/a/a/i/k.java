package com.yasoka.spcallrecord.recorder.call.a.d.a.a.i;

import a.d.a.a.b;
import a.d.a.a.e;
import a.d.a.a.f;
import a.d.a.a.g;
import java.util.Set;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
final class k implements g {

    /* renamed from: a reason: collision with root package name */
    private final Set<b> f351a;

    /* renamed from: b reason: collision with root package name */
    private final j f352b;

    /* renamed from: c reason: collision with root package name */
    private final n f353c;

    k(Set<b> set, j jVar, n nVar) {
        this.f351a = set;
        this.f352b = jVar;
        this.f353c = nVar;
    }

    public <T> f<T> a(String str, Class<T> cls, b bVar, e<T, byte[]> eVar) {
        if (this.f351a.contains(bVar)) {
            m mVar = new m(this.f352b, str, bVar, eVar, this.f353c);
            return mVar;
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", new Object[]{bVar, this.f351a}));
    }
}
