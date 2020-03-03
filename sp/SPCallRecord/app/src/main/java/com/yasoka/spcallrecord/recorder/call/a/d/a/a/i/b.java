package com.yasoka.spcallrecord.recorder.call.a.d.a.a.i;

import a.d.a.a.c;
import a.d.a.a.e;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
final class b extends i {

    /* renamed from: a reason: collision with root package name */
    private final j f326a;

    /* renamed from: b reason: collision with root package name */
    private final String f327b;

    /* renamed from: c reason: collision with root package name */
    private final c<?> f328c;

    /* renamed from: d reason: collision with root package name */
    private final e<?, byte[]> f329d;

    /* renamed from: e reason: collision with root package name */
    private final a.d.a.a.b f330e;

    /* renamed from: a.d.a.a.i.b$b reason: collision with other inner class name */
    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    static final class C0008b extends a.d.a.a.i.i.a {

        /* renamed from: a reason: collision with root package name */
        private j f331a;

        /* renamed from: b reason: collision with root package name */
        private String f332b;

        /* renamed from: c reason: collision with root package name */
        private c<?> f333c;

        /* renamed from: d reason: collision with root package name */
        private e<?, byte[]> f334d;

        /* renamed from: e reason: collision with root package name */
        private a.d.a.a.b f335e;

        C0008b() {
        }

        public a.d.a.a.i.i.a a(j jVar) {
            if (jVar != null) {
                this.f331a = jVar;
                return this;
            }
            throw new NullPointerException("Null transportContext");
        }

        public a.d.a.a.i.i.a a(String str) {
            if (str != null) {
                this.f332b = str;
                return this;
            }
            throw new NullPointerException("Null transportName");
        }

        /* access modifiers changed from: 0000 */
        public a.d.a.a.i.i.a a(c<?> cVar) {
            if (cVar != null) {
                this.f333c = cVar;
                return this;
            }
            throw new NullPointerException("Null event");
        }

        /* access modifiers changed from: 0000 */
        public a.d.a.a.i.i.a a(e<?, byte[]> eVar) {
            if (eVar != null) {
                this.f334d = eVar;
                return this;
            }
            throw new NullPointerException("Null transformer");
        }

        /* access modifiers changed from: 0000 */
        public a.d.a.a.i.i.a a(a.d.a.a.b bVar) {
            if (bVar != null) {
                this.f335e = bVar;
                return this;
            }
            throw new NullPointerException("Null encoding");
        }

        public i a() {
            String str = "";
            if (this.f331a == null) {
                str = a.b.a.a.a.c(str, " transportContext");
            }
            if (this.f332b == null) {
                str = a.b.a.a.a.c(str, " transportName");
            }
            if (this.f333c == null) {
                str = a.b.a.a.a.c(str, " event");
            }
            if (this.f334d == null) {
                str = a.b.a.a.a.c(str, " transformer");
            }
            if (this.f335e == null) {
                str = a.b.a.a.a.c(str, " encoding");
            }
            if (str.isEmpty()) {
                b bVar = new b(this.f331a, this.f332b, this.f333c, this.f334d, this.f335e, null);
                return bVar;
            }
            throw new IllegalStateException(a.b.a.a.a.c("Missing required properties:", str));
        }
    }

    /* synthetic */ b(j jVar, String str, c cVar, e eVar, a.d.a.a.b bVar, a aVar) {
        this.f326a = jVar;
        this.f327b = str;
        this.f328c = cVar;
        this.f329d = eVar;
        this.f330e = bVar;
    }

    public a.d.a.a.b a() {
        return this.f330e;
    }

    /* access modifiers changed from: 0000 */
    public c<?> b() {
        return this.f328c;
    }

    /* access modifiers changed from: 0000 */
    public e<?, byte[]> c() {
        return this.f329d;
    }

    public j d() {
        return this.f326a;
    }

    public String e() {
        return this.f327b;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (!this.f326a.equals(iVar.d()) || !this.f327b.equals(iVar.e()) || !this.f328c.equals(((b) iVar).f328c) || !this.f329d.equals(iVar.c()) || !this.f330e.equals(iVar.a())) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return ((((((((this.f326a.hashCode() ^ 1000003) * 1000003) ^ this.f327b.hashCode()) * 1000003) ^ this.f328c.hashCode()) * 1000003) ^ this.f329d.hashCode()) * 1000003) ^ this.f330e.hashCode();
    }

    public String toString() {
        StringBuilder a2 = a.b.a.a.a.a("SendRequest{transportContext=");
        a2.append(this.f326a);
        a2.append(", transportName=");
        a2.append(this.f327b);
        a2.append(", event=");
        a2.append(this.f328c);
        a2.append(", transformer=");
        a2.append(this.f329d);
        a2.append(", encoding=");
        a2.append(this.f330e);
        a2.append("}");
        return a2.toString();
    }
}
