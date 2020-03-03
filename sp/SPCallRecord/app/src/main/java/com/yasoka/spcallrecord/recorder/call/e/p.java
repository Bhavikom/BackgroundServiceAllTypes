package com.yasoka.spcallrecord.recorder.call.e;

/* compiled from: Segment */
final class p {

    /* renamed from: a reason: collision with root package name */
    final byte[] f3430a;

    /* renamed from: b reason: collision with root package name */
    int f3431b;

    /* renamed from: c reason: collision with root package name */
    int f3432c;

    /* renamed from: d reason: collision with root package name */
    boolean f3433d;

    /* renamed from: e reason: collision with root package name */
    boolean f3434e;
    p f;
    p g;

    p() {
        this.f3430a = new byte[8192];
        this.f3434e = true;
        this.f3433d = false;
    }

    public final p a() {
        p pVar = this.f;
        if (pVar == this) {
            pVar = null;
        }
        p pVar2 = this.g;
        pVar2.f = this.f;
        this.f.g = pVar2;
        this.f = null;
        this.g = null;
        return pVar;
    }

    /* access modifiers changed from: 0000 */
    public final p b() {
        this.f3433d = true;
        p pVar = new p(this.f3430a, this.f3431b, this.f3432c, true, false);
        return pVar;
    }

    p(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.f3430a = bArr;
        this.f3431b = i;
        this.f3432c = i2;
        this.f3433d = z;
        this.f3434e = z2;
    }

    public final p a(p pVar) {
        pVar.g = this;
        pVar.f = this.f;
        this.f.g = pVar;
        this.f = pVar;
        return pVar;
    }

    public final p a(int i) {
        p pVar;
        if (i <= 0 || i > this.f3432c - this.f3431b) {
            throw new IllegalArgumentException();
        }
        if (i >= 1024) {
            pVar = b();
        } else {
            pVar = q.a();
            System.arraycopy(this.f3430a, this.f3431b, pVar.f3430a, 0, i);
        }
        pVar.f3432c = pVar.f3431b + i;
        this.f3431b += i;
        this.g.a(pVar);
        return pVar;
    }

    public final void a(p pVar, int i) {
        if (pVar.f3434e) {
            int i2 = pVar.f3432c;
            if (i2 + i > 8192) {
                if (!pVar.f3433d) {
                    int i3 = i2 + i;
                    int i4 = pVar.f3431b;
                    if (i3 - i4 <= 8192) {
                        byte[] bArr = pVar.f3430a;
                        System.arraycopy(bArr, i4, bArr, 0, i2 - i4);
                        pVar.f3432c -= pVar.f3431b;
                        pVar.f3431b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.f3430a, this.f3431b, pVar.f3430a, pVar.f3432c, i);
            pVar.f3432c += i;
            this.f3431b += i;
            return;
        }
        throw new IllegalArgumentException();
    }
}
