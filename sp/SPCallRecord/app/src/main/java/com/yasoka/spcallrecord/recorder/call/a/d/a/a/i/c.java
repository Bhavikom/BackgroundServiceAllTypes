package com.yasoka.spcallrecord.recorder.call.a.d.a.a.i;

import a.d.a.a.d;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo.Scope;
import java.util.Arrays;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
final class c extends j {

    /* renamed from: a reason: collision with root package name */
    private final String f336a;

    /* renamed from: b reason: collision with root package name */
    private final byte[] f337b;

    /* renamed from: c reason: collision with root package name */
    private final d f338c;

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    static final class b extends a.d.a.a.i.j.a {

        /* renamed from: a reason: collision with root package name */
        private String f339a;

        /* renamed from: b reason: collision with root package name */
        private byte[] f340b;

        /* renamed from: c reason: collision with root package name */
        private d f341c;

        b() {
        }

        public a.d.a.a.i.j.a a(String str) {
            if (str != null) {
                this.f339a = str;
                return this;
            }
            throw new NullPointerException("Null backendName");
        }

        public a.d.a.a.i.j.a a(@Nullable byte[] bArr) {
            this.f340b = bArr;
            return this;
        }

        public a.d.a.a.i.j.a a(d dVar) {
            if (dVar != null) {
                this.f341c = dVar;
                return this;
            }
            throw new NullPointerException("Null priority");
        }

        public j a() {
            String str = "";
            if (this.f339a == null) {
                str = a.b.a.a.a.c(str, " backendName");
            }
            if (this.f341c == null) {
                str = a.b.a.a.a.c(str, " priority");
            }
            if (str.isEmpty()) {
                return new c(this.f339a, this.f340b, this.f341c, null);
            }
            throw new IllegalStateException(a.b.a.a.a.c("Missing required properties:", str));
        }
    }

    /* synthetic */ c(String str, byte[] bArr, d dVar, a aVar) {
        this.f336a = str;
        this.f337b = bArr;
        this.f338c = dVar;
    }

    public String a() {
        return this.f336a;
    }

    @Nullable
    public byte[] b() {
        return this.f337b;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public d c() {
        return this.f338c;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0039, code lost:
        if (r4.f338c.equals(((a.d.a.a.i.c) r5).f338c) != false) goto L_0x003d;
     */
    public boolean equals(Object obj) {
        byte[] bArr;
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        if (this.f336a.equals(((c) jVar).f336a)) {
            byte[] bArr2 = this.f337b;
            if (jVar instanceof c) {
                bArr = ((c) jVar).f337b;
            } else {
                bArr = ((c) jVar).f337b;
            }
            if (Arrays.equals(bArr2, bArr)) {
            }
        }
        z = false;
        return z;
    }

    public int hashCode() {
        return ((((this.f336a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f337b)) * 1000003) ^ this.f338c.hashCode();
    }
}
