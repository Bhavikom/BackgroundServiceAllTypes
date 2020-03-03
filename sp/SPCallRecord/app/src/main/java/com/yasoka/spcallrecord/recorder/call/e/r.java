package com.yasoka.spcallrecord.recorder.call.e;

import java.util.Arrays;

/* compiled from: SegmentedByteString */
final class r extends f {
    final transient byte[][] f;
    final transient int[] g;

    r(c cVar, int i) {
        super(null);
        v.a(cVar.f3394b, 0, (long) i);
        int i2 = 0;
        p pVar = cVar.f3393a;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            int i5 = pVar.f3432c;
            int i6 = pVar.f3431b;
            if (i5 != i6) {
                i3 += i5 - i6;
                i4++;
                pVar = pVar.f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.f = new byte[i4][];
        this.g = new int[(i4 * 2)];
        p pVar2 = cVar.f3393a;
        int i7 = 0;
        while (i2 < i) {
            this.f[i7] = pVar2.f3430a;
            i2 += pVar2.f3432c - pVar2.f3431b;
            if (i2 > i) {
                i2 = i;
            }
            int[] iArr = this.g;
            iArr[i7] = i2;
            iArr[this.f.length + i7] = pVar2.f3431b;
            pVar2.f3433d = true;
            i7++;
            pVar2 = pVar2.f;
        }
    }

    private f k() {
        return new f(i());
    }

    public String a() {
        return k().a();
    }

    public String b() {
        return k().b();
    }

    /* access modifiers changed from: 0000 */
    public byte[] c() {
        return i();
    }

    public f d() {
        return k().d();
    }

    public f e() {
        return k().e();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
        if (a(0, r5, 0, g()) != false) goto L_0x0021;
     */
    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (fVar.g() == g()) {
            }
        }
        z = false;
        return z;
    }

    public f f() {
        return k().f();
    }

    public int g() {
        return this.g[this.f.length - 1];
    }

    public f h() {
        return k().h();
    }

    public int hashCode() {
        int i = this.f3405b;
        if (i != 0) {
            return i;
        }
        int length = this.f.length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            byte[] bArr = this.f[i2];
            int[] iArr = this.g;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            int i7 = (i6 - i4) + i5;
            while (i5 < i7) {
                i3 = (i3 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i4 = i6;
        }
        this.f3405b = i3;
        return i3;
    }

    public byte[] i() {
        int[] iArr = this.g;
        byte[][] bArr = this.f;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.g;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.f[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    public String j() {
        return k().j();
    }

    public String toString() {
        return k().toString();
    }

    private int b(int i) {
        int binarySearch = Arrays.binarySearch(this.g, 0, this.f.length, i + 1);
        return binarySearch >= 0 ? binarySearch : binarySearch ^ -1;
    }

    public f a(int i, int i2) {
        return k().a(i, i2);
    }

    public byte a(int i) {
        int i2;
        v.a((long) this.g[this.f.length - 1], (long) i, 1);
        int b2 = b(i);
        if (b2 == 0) {
            i2 = 0;
        } else {
            i2 = this.g[b2 - 1];
        }
        int[] iArr = this.g;
        byte[][] bArr = this.f;
        return bArr[b2][(i - i2) + iArr[bArr.length + b2]];
    }

    /* access modifiers changed from: 0000 */
    public void a(c cVar) {
        int length = this.f.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.g;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            p pVar = new p(this.f[i], i3, (i3 + i4) - i2, true, false);
            p pVar2 = cVar.f3393a;
            if (pVar2 == null) {
                pVar.g = pVar;
                pVar.f = pVar;
                cVar.f3393a = pVar;
            } else {
                pVar2.g.a(pVar);
            }
            i++;
            i2 = i4;
        }
        cVar.f3394b += (long) i2;
    }

    public boolean a(int i, f fVar, int i2, int i3) {
        int i4;
        if (i < 0 || i > g() - i3) {
            return false;
        }
        int b2 = b(i);
        while (i3 > 0) {
            if (b2 == 0) {
                i4 = 0;
            } else {
                i4 = this.g[b2 - 1];
            }
            int min = Math.min(i3, ((this.g[b2] - i4) + i4) - i);
            int[] iArr = this.g;
            byte[][] bArr = this.f;
            if (!fVar.a(i2, bArr[b2], (i - i4) + iArr[bArr.length + b2], min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            b2++;
        }
        return true;
    }

    public boolean a(int i, byte[] bArr, int i2, int i3) {
        int i4;
        if (i < 0 || i > g() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int b2 = b(i);
        while (i3 > 0) {
            if (b2 == 0) {
                i4 = 0;
            } else {
                i4 = this.g[b2 - 1];
            }
            int min = Math.min(i3, ((this.g[b2] - i4) + i4) - i);
            int[] iArr = this.g;
            byte[][] bArr2 = this.f;
            if (!v.a(bArr2[b2], (i - i4) + iArr[bArr2.length + b2], bArr, i2, min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            b2++;
        }
        return true;
    }
}
