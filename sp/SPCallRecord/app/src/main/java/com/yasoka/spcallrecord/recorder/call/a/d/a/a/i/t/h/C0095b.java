package com.yasoka.spcallrecord.recorder.call.a.d.a.a.i.t.h;

import a.b.a.a.a;
import a.d.a.a.i.g;
import a.d.a.a.i.j;

/* renamed from: a.d.a.a.i.t.h.b reason: case insensitive filesystem */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
final class C0095b extends g {

    /* renamed from: a reason: collision with root package name */
    private final long f410a;

    /* renamed from: b reason: collision with root package name */
    private final j f411b;

    /* renamed from: c reason: collision with root package name */
    private final g f412c;

    C0095b(long j, j jVar, g gVar) {
        this.f410a = j;
        if (jVar != null) {
            this.f411b = jVar;
            if (gVar != null) {
                this.f412c = gVar;
                return;
            }
            throw new NullPointerException("Null event");
        }
        throw new NullPointerException("Null transportContext");
    }

    public g a() {
        return this.f412c;
    }

    public long b() {
        return this.f410a;
    }

    public j c() {
        return this.f411b;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (this.f410a != ((C0095b) gVar).f410a || !this.f411b.equals(gVar.c()) || !this.f412c.equals(((C0095b) gVar).f412c)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        long j = this.f410a;
        return this.f412c.hashCode() ^ ((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.f411b.hashCode()) * 1000003);
    }

    public String toString() {
        StringBuilder a2 = a.a("PersistedEvent{id=");
        a2.append(this.f410a);
        a2.append(", transportContext=");
        a2.append(this.f411b);
        a2.append(", event=");
        a2.append(this.f412c);
        a2.append("}");
        return a2.toString();
    }
}
