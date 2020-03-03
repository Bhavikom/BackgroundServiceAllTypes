package com.yasoka.spcallrecord.recorder.call.a.d.a.a.i;

import androidx.annotation.Nullable;
import java.util.Map;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
final class a extends g {

    /* renamed from: a reason: collision with root package name */
    private final String f316a;

    /* renamed from: b reason: collision with root package name */
    private final Integer f317b;

    /* renamed from: c reason: collision with root package name */
    private final f f318c;

    /* renamed from: d reason: collision with root package name */
    private final long f319d;

    /* renamed from: e reason: collision with root package name */
    private final long f320e;
    private final Map<String, String> f;

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    static final class b extends a.d.a.a.i.g.a {

        /* renamed from: a reason: collision with root package name */
        private String f321a;

        /* renamed from: b reason: collision with root package name */
        private Integer f322b;

        /* renamed from: c reason: collision with root package name */
        private f f323c;

        /* renamed from: d reason: collision with root package name */
        private Long f324d;

        /* renamed from: e reason: collision with root package name */
        private Long f325e;
        private Map<String, String> f;

        b() {
        }

        public a.d.a.a.i.g.a a(String str) {
            if (str != null) {
                this.f321a = str;
                return this;
            }
            throw new NullPointerException("Null transportName");
        }

        public a.d.a.a.i.g.a b(long j) {
            this.f325e = Long.valueOf(j);
            return this;
        }

        /* access modifiers changed from: protected */
        public Map<String, String> b() {
            Map<String, String> map = this.f;
            if (map != null) {
                return map;
            }
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }

        public a.d.a.a.i.g.a a(Integer num) {
            this.f322b = num;
            return this;
        }

        public a.d.a.a.i.g.a a(f fVar) {
            if (fVar != null) {
                this.f323c = fVar;
                return this;
            }
            throw new NullPointerException("Null encodedPayload");
        }

        public a.d.a.a.i.g.a a(long j) {
            this.f324d = Long.valueOf(j);
            return this;
        }

        /* access modifiers changed from: protected */
        public a.d.a.a.i.g.a a(Map<String, String> map) {
            if (map != null) {
                this.f = map;
                return this;
            }
            throw new NullPointerException("Null autoMetadata");
        }

        public g a() {
            String str = "";
            if (this.f321a == null) {
                str = b.a.a.a.c(str, " transportName");
            }
            if (this.f323c == null) {
                str = b.a.a.a.c(str, " encodedPayload");
            }
            if (this.f324d == null) {
                str = b.a.a.a.c(str, " eventMillis");
            }
            if (this.f325e == null) {
                str = b.a.a.a.c(str, " uptimeMillis");
            }
            if (this.f == null) {
                str = b.a.a.a.c(str, " autoMetadata");
            }
            if (str.isEmpty()) {
                a aVar = new a(this.f321a, this.f322b, this.f323c, this.f324d.longValue(), this.f325e.longValue(), this.f, null);
                return aVar;
            }
            throw new IllegalStateException(b.a.a.a.c("Missing required properties:", str));
        }
    }

    /* synthetic */ a(String str, Integer num, f fVar, long j, long j2, Map map, C0007a aVar) {
        this.f316a = str;
        this.f317b = num;
        this.f318c = fVar;
        this.f319d = j;
        this.f320e = j2;
        this.f = map;
    }

    /* access modifiers changed from: protected */
    public Map<String, String> a() {
        return this.f;
    }

    @Nullable
    public Integer b() {
        return this.f317b;
    }

    public f c() {
        return this.f318c;
    }

    public long d() {
        return this.f319d;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0053, code lost:
        if (r7.f.equals(r8.f) != false) goto L_0x0057;
     */
    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (this.f316a.equals(((a) gVar).f316a)) {
            Integer num = this.f317b;
            if (num != null ? num.equals(((a) gVar).f317b) : ((a) gVar).f317b == null) {
                a aVar = (a) gVar;
                if (this.f318c.equals(aVar.f318c)) {
                    if (this.f319d == aVar.f319d) {
                        if (this.f320e == aVar.f320e) {
                        }
                    }
                }
            }
        }
        z = false;
        return z;
    }

    public String f() {
        return this.f316a;
    }

    public long g() {
        return this.f320e;
    }

    public int hashCode() {
        int hashCode = (this.f316a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.f317b;
        int hashCode2 = (((hashCode ^ (num == null ? 0 : num.hashCode())) * 1000003) ^ this.f318c.hashCode()) * 1000003;
        long j = this.f319d;
        int i = (hashCode2 ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        long j2 = this.f320e;
        return ((i ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ this.f.hashCode();
    }

    public String toString() {
        StringBuilder a2 = b.a.a.a.a("EventInternal{transportName=");
        a2.append(this.f316a);
        a2.append(", code=");
        a2.append(this.f317b);
        a2.append(", encodedPayload=");
        a2.append(this.f318c);
        a2.append(", eventMillis=");
        a2.append(this.f319d);
        a2.append(", uptimeMillis=");
        a2.append(this.f320e);
        a2.append(", autoMetadata=");
        a2.append(this.f);
        a2.append("}");
        return a2.toString();
    }
}
