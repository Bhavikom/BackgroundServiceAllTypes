package com.yasoka.spcallrecord.recorder.call.a.d.a.a.i.t.h;

import a.b.a.a.a;

/* renamed from: a.d.a.a.i.t.h.a reason: case insensitive filesystem */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
final class C0094a extends C0097d {

    /* renamed from: b reason: collision with root package name */
    private final long f402b;

    /* renamed from: c reason: collision with root package name */
    private final int f403c;

    /* renamed from: d reason: collision with root package name */
    private final int f404d;

    /* renamed from: e reason: collision with root package name */
    private final long f405e;

    /* renamed from: a.d.a.a.i.t.h.a$b */
    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    static final class b extends a {

        /* renamed from: a reason: collision with root package name */
        private Long f406a;

        /* renamed from: b reason: collision with root package name */
        private Integer f407b;

        /* renamed from: c reason: collision with root package name */
        private Integer f408c;

        /* renamed from: d reason: collision with root package name */
        private Long f409d;

        b() {
        }

        /* access modifiers changed from: 0000 */
        public a a(int i) {
            this.f408c = Integer.valueOf(i);
            return this;
        }

        /* access modifiers changed from: 0000 */
        public a b(long j) {
            this.f406a = Long.valueOf(j);
            return this;
        }

        /* access modifiers changed from: 0000 */
        public a a(long j) {
            this.f409d = Long.valueOf(j);
            return this;
        }

        /* access modifiers changed from: 0000 */
        public a b(int i) {
            this.f407b = Integer.valueOf(i);
            return this;
        }

        /* access modifiers changed from: 0000 */
        public C0097d a() {
            String str = "";
            if (this.f406a == null) {
                str = a.c(str, " maxStorageSizeInBytes");
            }
            if (this.f407b == null) {
                str = a.c(str, " loadBatchSize");
            }
            if (this.f408c == null) {
                str = a.c(str, " criticalSectionEnterTimeoutMs");
            }
            if (this.f409d == null) {
                str = a.c(str, " eventCleanUpAge");
            }
            if (str.isEmpty()) {
                C0094a aVar = new C0094a(this.f406a.longValue(), this.f407b.intValue(), this.f408c.intValue(), this.f409d.longValue(), null);
                return aVar;
            }
            throw new IllegalStateException(a.c("Missing required properties:", str));
        }
    }

    /* synthetic */ C0094a(long j, int i, int i2, long j2, C0009a aVar) {
        this.f402b = j;
        this.f403c = i;
        this.f404d = i2;
        this.f405e = j2;
    }

    /* access modifiers changed from: 0000 */
    public int a() {
        return this.f404d;
    }

    /* access modifiers changed from: 0000 */
    public long b() {
        return this.f405e;
    }

    /* access modifiers changed from: 0000 */
    public int c() {
        return this.f403c;
    }

    /* access modifiers changed from: 0000 */
    public long d() {
        return this.f402b;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0097d)) {
            return false;
        }
        C0097d dVar = (C0097d) obj;
        if (!(this.f402b == dVar.d() && this.f403c == dVar.c() && this.f404d == dVar.a() && this.f405e == dVar.b())) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        long j = this.f402b;
        int i = (((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.f403c) * 1000003) ^ this.f404d) * 1000003;
        long j2 = this.f405e;
        return ((int) (j2 ^ (j2 >>> 32))) ^ i;
    }

    public String toString() {
        StringBuilder a2 = a.a("EventStoreConfig{maxStorageSizeInBytes=");
        a2.append(this.f402b);
        a2.append(", loadBatchSize=");
        a2.append(this.f403c);
        a2.append(", criticalSectionEnterTimeoutMs=");
        a2.append(this.f404d);
        a2.append(", eventCleanUpAge=");
        a2.append(this.f405e);
        a2.append("}");
        return a2.toString();
    }
}
