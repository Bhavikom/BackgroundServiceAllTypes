package com.yasoka.spcallrecord.recorder.call.e;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* compiled from: Buffer */
public final class c implements e, d, Cloneable, ByteChannel {

    /* renamed from: c reason: collision with root package name */
    private static final byte[] f3392c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: a reason: collision with root package name */
    p f3393a;

    /* renamed from: b reason: collision with root package name */
    long f3394b;

    /* compiled from: Buffer */
    class a extends OutputStream {
        a() {
        }

        public void close() {
        }

        public void flush() {
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(c.this);
            sb.append(".outputStream()");
            return sb.toString();
        }

        public void write(int i) {
            c.this.writeByte((int) (byte) i);
        }

        public void write(byte[] bArr, int i, int i2) {
            c.this.write(bArr, i, i2);
        }
    }

    /* compiled from: Buffer */
    class b extends InputStream {
        b() {
        }

        public int available() {
            return (int) Math.min(c.this.f3394b, 2147483647L);
        }

        public void close() {
        }

        public int read() {
            c cVar = c.this;
            if (cVar.f3394b > 0) {
                return cVar.readByte() & 255;
            }
            return -1;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(c.this);
            sb.append(".inputStream()");
            return sb.toString();
        }

        public int read(byte[] bArr, int i, int i2) {
            return c.this.a(bArr, i, i2);
        }
    }

    /* renamed from: e.c$c reason: collision with other inner class name */
    /* compiled from: Buffer */
    public static final class C0046c implements Closeable {

        /* renamed from: a reason: collision with root package name */
        public c f3397a;

        /* renamed from: b reason: collision with root package name */
        public boolean f3398b;

        /* renamed from: c reason: collision with root package name */
        private p f3399c;

        /* renamed from: d reason: collision with root package name */
        public long f3400d = -1;

        /* renamed from: e reason: collision with root package name */
        public byte[] f3401e;
        public int f = -1;
        public int g = -1;

        public final int a() {
            long j = this.f3400d;
            if (j == this.f3397a.f3394b) {
                throw new IllegalStateException();
            } else if (j == -1) {
                return h(0);
            } else {
                return h(j + ((long) (this.g - this.f)));
            }
        }

        public void close() {
            if (this.f3397a != null) {
                this.f3397a = null;
                this.f3399c = null;
                this.f3400d = -1;
                this.f3401e = null;
                this.f = -1;
                this.g = -1;
                return;
            }
            throw new IllegalStateException("not attached to a buffer");
        }

        public final int h(long j) {
            p pVar;
            long j2;
            p pVar2;
            if (j >= -1) {
                c cVar = this.f3397a;
                long j3 = cVar.f3394b;
                if (j <= j3) {
                    if (j == -1 || j == j3) {
                        this.f3399c = null;
                        this.f3400d = j;
                        this.f3401e = null;
                        this.f = -1;
                        this.g = -1;
                        return -1;
                    }
                    long j4 = 0;
                    p pVar3 = cVar.f3393a;
                    p pVar4 = this.f3399c;
                    if (pVar4 != null) {
                        long j5 = this.f3400d - ((long) (this.f - pVar4.f3431b));
                        if (j5 > j) {
                            j3 = j5;
                            p pVar5 = pVar4;
                            pVar4 = pVar3;
                            pVar3 = pVar5;
                        } else {
                            j4 = j5;
                        }
                    } else {
                        pVar4 = pVar3;
                    }
                    if (j3 - j > j - j4) {
                        while (true) {
                            int i = pVar.f3432c;
                            int i2 = pVar.f3431b;
                            if (j < ((long) (i - i2)) + j2) {
                                break;
                            }
                            j4 = j2 + ((long) (i - i2));
                            pVar4 = pVar.f;
                        }
                    } else {
                        pVar = pVar3;
                        j2 = j3;
                        while (j2 > j) {
                            pVar = pVar.g;
                            j2 -= (long) (pVar.f3432c - pVar.f3431b);
                        }
                    }
                    if (!this.f3398b || !pVar.f3433d) {
                        pVar2 = pVar;
                    } else {
                        pVar2 = new p((byte[]) pVar.f3430a.clone(), pVar.f3431b, pVar.f3432c, false, true);
                        c cVar2 = this.f3397a;
                        if (cVar2.f3393a == pVar) {
                            cVar2.f3393a = pVar2;
                        }
                        pVar.a(pVar2);
                        pVar2.g.a();
                    }
                    this.f3399c = pVar2;
                    this.f3400d = j;
                    this.f3401e = pVar2.f3430a;
                    this.f = pVar2.f3431b + ((int) (j - j2));
                    this.g = pVar2.f3432c;
                    return this.g - this.f;
                }
            }
            throw new ArrayIndexOutOfBoundsException(String.format("offset=%s > size=%s", new Object[]{Long.valueOf(j), Long.valueOf(this.f3397a.f3394b)}));
        }
    }

    public c b() {
        return this;
    }

    public d c() {
        return this;
    }

    public f c(long j) throws EOFException {
        return new f(e(j));
    }

    public void close() {
    }

    public d d() throws IOException {
        return this;
    }

    public boolean d(long j) {
        return this.f3394b >= j;
    }

    public String e() throws EOFException {
        return f(Long.MAX_VALUE);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        long j = this.f3394b;
        if (j != cVar.f3394b) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        p pVar = this.f3393a;
        p pVar2 = cVar.f3393a;
        int i = pVar.f3431b;
        int i2 = pVar2.f3431b;
        while (j2 < this.f3394b) {
            long min = (long) Math.min(pVar.f3432c - i, pVar2.f3432c - i2);
            int i3 = i2;
            int i4 = i;
            int i5 = 0;
            while (((long) i5) < min) {
                int i6 = i4 + 1;
                int i7 = i3 + 1;
                if (pVar.f3430a[i4] != pVar2.f3430a[i3]) {
                    return false;
                }
                i5++;
                i4 = i6;
                i3 = i7;
            }
            if (i4 == pVar.f3432c) {
                pVar = pVar.f;
                i = pVar.f3431b;
            } else {
                i = i4;
            }
            if (i3 == pVar2.f3432c) {
                pVar2 = pVar2.f;
                i2 = pVar2.f3431b;
            } else {
                i2 = i3;
            }
            j2 += min;
        }
        return true;
    }

    public String f(long j) throws EOFException {
        if (j >= 0) {
            long j2 = Long.MAX_VALUE;
            if (j != Long.MAX_VALUE) {
                j2 = j + 1;
            }
            long a2 = a(10, 0, j2);
            if (a2 != -1) {
                return j(a2);
            }
            if (j2 < this.f3394b && h(j2 - 1) == 13 && h(j2) == 10) {
                return j(j2);
            }
            c cVar = new c();
            a(cVar, 0, Math.min(32, this.f3394b));
            StringBuilder a3 = a.b.a.a.a.a("\\n not found: limit=");
            a3.append(Math.min(this.f3394b, j));
            a3.append(" content=");
            a3.append(cVar.o().b());
            a3.append(8230);
            throw new EOFException(a3.toString());
        }
        throw new IllegalArgumentException(a.b.a.a.a.a("limit < 0: ", j));
    }

    public void flush() {
    }

    public void g(long j) throws EOFException {
        if (this.f3394b < j) {
            throw new EOFException();
        }
    }

    public boolean h() {
        return this.f3394b == 0;
    }

    public int hashCode() {
        p pVar = this.f3393a;
        if (pVar == null) {
            return 0;
        }
        int i = 1;
        do {
            for (int i2 = pVar.f3431b; i2 < pVar.f3432c; i2++) {
                i = (i * 31) + pVar.f3430a[i2];
            }
            pVar = pVar.f;
        } while (pVar != this.f3393a);
        return i;
    }

    public short i() {
        return v.a(readShort());
    }

    public boolean isOpen() {
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0049, code lost:
        if (r6 != false) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004b, code lost:
        r1.readByte();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004e, code lost:
        r3 = a.b.a.a.a.a("Number too large: ");
        r3.append(r1.p());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0064, code lost:
        throw new java.lang.NumberFormatException(r3.toString());
     */
    public long j() {
        long j = 0;
        if (this.f3394b != 0) {
            long j2 = -7;
            int i = 0;
            boolean z = false;
            boolean z2 = false;
            loop0:
            do {
                p pVar = this.f3393a;
                byte[] bArr = pVar.f3430a;
                int i2 = pVar.f3431b;
                int i3 = pVar.f3432c;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    byte b2 = bArr[i2];
                    if (b2 >= 48 && b2 <= 57) {
                        int i4 = 48 - b2;
                        if (j < -922337203685477580L || (j == -922337203685477580L && ((long) i4) < j2)) {
                            c cVar = new c();
                            cVar.b(j);
                            cVar.writeByte((int) b2);
                        } else {
                            j = (j * 10) + ((long) i4);
                        }
                    } else if (b2 == 45 && i == 0) {
                        j2--;
                        z = true;
                    } else if (i != 0) {
                        z2 = true;
                    } else {
                        StringBuilder a2 = a.b.a.a.a.a("Expected leading [0-9] or '-' character but was 0x");
                        a2.append(Integer.toHexString(b2));
                        throw new NumberFormatException(a2.toString());
                    }
                    i2++;
                    i++;
                }
                if (i2 == i3) {
                    this.f3393a = pVar.a();
                    q.a(pVar);
                } else {
                    pVar.f3431b = i2;
                }
                if (z2) {
                    break;
                }
            } while (this.f3393a != null);
            this.f3394b -= (long) i;
            return z ? j : -j;
        }
        throw new IllegalStateException("size == 0");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0086, code lost:
        if (r8 != r9) goto L_0x0092;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0088, code lost:
        r15.f3393a = r6.a();
        e.q.a(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0092, code lost:
        r6.f3431b = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0094, code lost:
        if (r0 != false) goto L_0x009a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x006f A[SYNTHETIC] */
    public long k() {
        int i;
        int i2;
        if (this.f3394b != 0) {
            boolean z = false;
            int i3 = 0;
            long j = 0;
            do {
                p pVar = this.f3393a;
                byte[] bArr = pVar.f3430a;
                int i4 = pVar.f3431b;
                int i5 = pVar.f3432c;
                while (true) {
                    if (i4 >= i5) {
                        break;
                    }
                    byte b2 = bArr[i4];
                    if (b2 < 48 || b2 > 57) {
                        if (b2 >= 97 && b2 <= 102) {
                            i2 = b2 - 97;
                        } else if (b2 >= 65 && b2 <= 70) {
                            i2 = b2 - 65;
                        } else if (i3 == 0) {
                            z = true;
                        } else {
                            StringBuilder a2 = a.b.a.a.a.a("Expected leading [0-9a-fA-F] character but was 0x");
                            a2.append(Integer.toHexString(b2));
                            throw new NumberFormatException(a2.toString());
                        }
                        i = i2 + 10;
                    } else {
                        i = b2 - 48;
                    }
                    if ((-1152921504606846976L & j) == 0) {
                        j = (j << 4) | ((long) i);
                        i4++;
                        i3++;
                    } else {
                        c cVar = new c();
                        cVar.a(j);
                        cVar.writeByte((int) b2);
                        StringBuilder a3 = a.b.a.a.a.a("Number too large: ");
                        a3.append(cVar.p());
                        throw new NumberFormatException(a3.toString());
                    }
                }
                if (i3 == 0) {
                }
            } while (this.f3393a != null);
            this.f3394b -= (long) i3;
            return j;
        }
        throw new IllegalStateException("size == 0");
    }

    public InputStream l() {
        return new b();
    }

    public final long m() {
        long j = this.f3394b;
        if (j == 0) {
            return 0;
        }
        p pVar = this.f3393a.g;
        int i = pVar.f3432c;
        if (i < 8192 && pVar.f3434e) {
            j -= (long) (i - pVar.f3431b);
        }
        return j;
    }

    public OutputStream n() {
        return new a();
    }

    public f o() {
        return new f(f());
    }

    public String p() {
        try {
            return a(this.f3394b, v.f3437a);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public int q() throws EOFException {
        byte b2;
        int i;
        byte b3;
        if (this.f3394b != 0) {
            byte h = h(0);
            int i2 = 1;
            if ((h & 128) == 0) {
                b3 = h & Byte.MAX_VALUE;
                i = 1;
                b2 = 0;
            } else if ((h & 224) == 192) {
                b3 = h & 31;
                i = 2;
                b2 = 128;
            } else if ((h & 240) == 224) {
                b3 = h & 15;
                i = 3;
                b2 = 2048;
            } else if ((h & 248) == 240) {
                b3 = h & 7;
                i = 4;
                b2 = 65536;
            } else {
                skip(1);
                return 65533;
            }
            long j = (long) i;
            if (this.f3394b >= j) {
                while (i2 < i) {
                    long j2 = (long) i2;
                    byte h2 = h(j2);
                    if ((h2 & 192) == 128) {
                        b3 = (b3 << 6) | (h2 & 63);
                        i2++;
                    } else {
                        skip(j2);
                        return 65533;
                    }
                }
                skip(j);
                if (b3 > 1114111) {
                    return 65533;
                }
                if ((b3 < 55296 || b3 > 57343) && b3 >= b2) {
                    return b3;
                }
                return 65533;
            }
            StringBuilder a2 = a.b.a.a.a.a("size < ", i, ": ");
            a2.append(this.f3394b);
            a2.append(" (to read code point prefixed 0x");
            a2.append(Integer.toHexString(h));
            a2.append(")");
            throw new EOFException(a2.toString());
        }
        throw new EOFException();
    }

    public final long r() {
        return this.f3394b;
    }

    public int read(ByteBuffer byteBuffer) throws IOException {
        p pVar = this.f3393a;
        if (pVar == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), pVar.f3432c - pVar.f3431b);
        byteBuffer.put(pVar.f3430a, pVar.f3431b, min);
        pVar.f3431b += min;
        this.f3394b -= (long) min;
        if (pVar.f3431b == pVar.f3432c) {
            this.f3393a = pVar.a();
            q.a(pVar);
        }
        return min;
    }

    public byte readByte() {
        long j = this.f3394b;
        if (j != 0) {
            p pVar = this.f3393a;
            int i = pVar.f3431b;
            int i2 = pVar.f3432c;
            int i3 = i + 1;
            byte b2 = pVar.f3430a[i];
            this.f3394b = j - 1;
            if (i3 == i2) {
                this.f3393a = pVar.a();
                q.a(pVar);
            } else {
                pVar.f3431b = i3;
            }
            return b2;
        }
        throw new IllegalStateException("size == 0");
    }

    public void readFully(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int a2 = a(bArr, i, bArr.length - i);
            if (a2 != -1) {
                i += a2;
            } else {
                throw new EOFException();
            }
        }
    }

    public int readInt() {
        long j = this.f3394b;
        if (j >= 4) {
            p pVar = this.f3393a;
            int i = pVar.f3431b;
            int i2 = pVar.f3432c;
            if (i2 - i < 4) {
                return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
            }
            byte[] bArr = pVar.f3430a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            byte b2 = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
            int i5 = i4 + 1;
            byte b3 = b2 | ((bArr[i4] & 255) << 8);
            int i6 = i5 + 1;
            byte b4 = b3 | (bArr[i5] & 255);
            this.f3394b = j - 4;
            if (i6 == i2) {
                this.f3393a = pVar.a();
                q.a(pVar);
            } else {
                pVar.f3431b = i6;
            }
            return b4;
        }
        StringBuilder a2 = a.b.a.a.a.a("size < 4: ");
        a2.append(this.f3394b);
        throw new IllegalStateException(a2.toString());
    }

    public long readLong() {
        long j = this.f3394b;
        if (j >= 8) {
            p pVar = this.f3393a;
            int i = pVar.f3431b;
            int i2 = pVar.f3432c;
            if (i2 - i < 8) {
                return ((((long) readInt()) & 4294967295L) << 32) | (4294967295L & ((long) readInt()));
            }
            byte[] bArr = pVar.f3430a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            int i5 = i4 + 1;
            int i6 = i5 + 1;
            int i7 = i6 + 1;
            int i8 = i7 + 1;
            long j2 = ((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i3]) & 255) << 48) | ((((long) bArr[i4]) & 255) << 40) | ((((long) bArr[i5]) & 255) << 32) | ((((long) bArr[i6]) & 255) << 24) | ((((long) bArr[i7]) & 255) << 16);
            int i9 = i8 + 1;
            long j3 = ((((long) bArr[i8]) & 255) << 8) | j2;
            int i10 = i9 + 1;
            long j4 = (((long) bArr[i9]) & 255) | j3;
            this.f3394b = j - 8;
            if (i10 == i2) {
                this.f3393a = pVar.a();
                q.a(pVar);
            } else {
                pVar.f3431b = i10;
            }
            return j4;
        }
        StringBuilder a2 = a.b.a.a.a.a("size < 8: ");
        a2.append(this.f3394b);
        throw new IllegalStateException(a2.toString());
    }

    public short readShort() {
        long j = this.f3394b;
        if (j >= 2) {
            p pVar = this.f3393a;
            int i = pVar.f3431b;
            int i2 = pVar.f3432c;
            if (i2 - i < 2) {
                return (short) (((readByte() & 255) << 8) | (readByte() & 255));
            }
            byte[] bArr = pVar.f3430a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            byte b2 = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
            this.f3394b = j - 2;
            if (i4 == i2) {
                this.f3393a = pVar.a();
                q.a(pVar);
            } else {
                pVar.f3431b = i4;
            }
            return (short) b2;
        }
        StringBuilder a2 = a.b.a.a.a.a("size < 2: ");
        a2.append(this.f3394b);
        throw new IllegalStateException(a2.toString());
    }

    public void skip(long j) throws EOFException {
        while (j > 0) {
            p pVar = this.f3393a;
            if (pVar != null) {
                int min = (int) Math.min(j, (long) (pVar.f3432c - pVar.f3431b));
                long j2 = (long) min;
                this.f3394b -= j2;
                j -= j2;
                p pVar2 = this.f3393a;
                pVar2.f3431b += min;
                if (pVar2.f3431b == pVar2.f3432c) {
                    this.f3393a = pVar2.a();
                    q.a(pVar2);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    public u timeout() {
        return u.NONE;
    }

    public String toString() {
        f fVar;
        long j = this.f3394b;
        if (j <= 2147483647L) {
            int i = (int) j;
            if (i == 0) {
                fVar = f.f3403e;
            } else {
                fVar = new r(this, i);
            }
            return fVar.toString();
        }
        StringBuilder a2 = a.b.a.a.a.a("size > Integer.MAX_VALUE: ");
        a2.append(this.f3394b);
        throw new IllegalArgumentException(a2.toString());
    }

    public c b(int i) {
        if (i < 128) {
            writeByte(i);
        } else if (i < 2048) {
            writeByte((i >> 6) | 192);
            writeByte((i & 63) | 128);
        } else if (i < 65536) {
            if (i < 55296 || i > 57343) {
                writeByte((i >> 12) | 224);
                writeByte(((i >> 6) & 63) | 128);
                writeByte((i & 63) | 128);
            } else {
                writeByte(63);
            }
        } else if (i <= 1114111) {
            writeByte((i >> 18) | 240);
            writeByte(((i >> 12) & 63) | 128);
            writeByte(((i >> 6) & 63) | 128);
            writeByte((i & 63) | 128);
        } else {
            StringBuilder a2 = a.b.a.a.a.a("Unexpected code point: ");
            a2.append(Integer.toHexString(i));
            throw new IllegalArgumentException(a2.toString());
        }
        return this;
    }

    public c clone() {
        c cVar = new c();
        if (this.f3394b == 0) {
            return cVar;
        }
        cVar.f3393a = this.f3393a.b();
        p pVar = cVar.f3393a;
        pVar.g = pVar;
        pVar.f = pVar;
        p pVar2 = this.f3393a;
        while (true) {
            pVar2 = pVar2.f;
            if (pVar2 != this.f3393a) {
                cVar.f3393a.g.a(pVar2.b());
            } else {
                cVar.f3394b = this.f3394b;
                return cVar;
            }
        }
    }

    public byte[] e(long j) throws EOFException {
        v.a(this.f3394b, 0, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[((int) j)];
            readFully(bArr);
            return bArr;
        }
        throw new IllegalArgumentException(a.b.a.a.a.a("byteCount > Integer.MAX_VALUE: ", j));
    }

    public int g() {
        return v.a(readInt());
    }

    public final byte h(long j) {
        int i;
        v.a(this.f3394b, j, 1);
        long j2 = this.f3394b;
        if (j2 - j > j) {
            p pVar = this.f3393a;
            while (true) {
                int i2 = pVar.f3432c;
                int i3 = pVar.f3431b;
                long j3 = (long) (i2 - i3);
                if (j < j3) {
                    return pVar.f3430a[i3 + ((int) j)];
                }
                j -= j3;
                pVar = pVar.f;
            }
        } else {
            long j4 = j - j2;
            p pVar2 = this.f3393a;
            do {
                pVar2 = pVar2.g;
                int i4 = pVar2.f3432c;
                i = pVar2.f3431b;
                j4 += (long) (i4 - i);
            } while (j4 < 0);
            return pVar2.f3430a[i + ((int) j4)];
        }
    }

    public String i(long j) throws EOFException {
        return a(j, v.f3437a);
    }

    public c writeByte(int i) {
        p a2 = a(1);
        byte[] bArr = a2.f3430a;
        int i2 = a2.f3432c;
        a2.f3432c = i2 + 1;
        bArr[i2] = (byte) i;
        this.f3394b++;
        return this;
    }

    public c writeInt(int i) {
        p a2 = a(4);
        byte[] bArr = a2.f3430a;
        int i2 = a2.f3432c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) (i & 255);
        a2.f3432c = i6;
        this.f3394b += 4;
        return this;
    }

    public c writeShort(int i) {
        p a2 = a(2);
        byte[] bArr = a2.f3430a;
        int i2 = a2.f3432c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) (i & 255);
        a2.f3432c = i4;
        this.f3394b += 2;
        return this;
    }

    public c write(byte[] bArr) {
        if (bArr != null) {
            write(bArr, 0, bArr.length);
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public final c a(c cVar, long j, long j2) {
        if (cVar != null) {
            v.a(this.f3394b, j, j2);
            if (j2 == 0) {
                return this;
            }
            cVar.f3394b += j2;
            p pVar = this.f3393a;
            while (true) {
                int i = pVar.f3432c;
                int i2 = pVar.f3431b;
                if (j < ((long) (i - i2))) {
                    break;
                }
                j -= (long) (i - i2);
                pVar = pVar.f;
            }
            while (j2 > 0) {
                p b2 = pVar.b();
                b2.f3431b = (int) (((long) b2.f3431b) + j);
                b2.f3432c = Math.min(b2.f3431b + ((int) j2), b2.f3432c);
                p pVar2 = cVar.f3393a;
                if (pVar2 == null) {
                    b2.g = b2;
                    b2.f = b2;
                    cVar.f3393a = b2;
                } else {
                    pVar2.g.a(b2);
                }
                j2 -= (long) (b2.f3432c - b2.f3431b);
                pVar = pVar.f;
                j = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    public c write(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            long j = (long) i2;
            v.a((long) bArr.length, (long) i, j);
            int i3 = i2 + i;
            while (i < i3) {
                p a2 = a(1);
                int min = Math.min(i3 - i, 8192 - a2.f3432c);
                System.arraycopy(bArr, i, a2.f3430a, a2.f3432c, min);
                i += min;
                a2.f3432c += min;
            }
            this.f3394b += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public long read(c cVar, long j) {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j >= 0) {
            long j2 = this.f3394b;
            if (j2 == 0) {
                return -1;
            }
            if (j > j2) {
                j = j2;
            }
            cVar.write(this, j);
            return j;
        } else {
            throw new IllegalArgumentException(a.b.a.a.a.a("byteCount < 0: ", j));
        }
    }

    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer != null) {
            int remaining = byteBuffer.remaining();
            int i = remaining;
            while (i > 0) {
                p a2 = a(1);
                int min = Math.min(i, 8192 - a2.f3432c);
                byteBuffer.get(a2.f3430a, a2.f3432c, min);
                i -= min;
                a2.f3432c += min;
            }
            this.f3394b += (long) remaining;
            return remaining;
        }
        throw new IllegalArgumentException("source == null");
    }

    public byte[] f() {
        try {
            return e(this.f3394b);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public c b(long j) {
        if (j == 0) {
            writeByte(48);
            return this;
        }
        boolean z = false;
        int i = 1;
        if (j < 0) {
            j = -j;
            if (j < 0) {
                a("-9223372036854775808");
                return this;
            }
            z = true;
        }
        if (j >= 100000000) {
            i = j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= 10000) {
            i = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i = 2;
        }
        if (z) {
            i++;
        }
        p a2 = a(i);
        byte[] bArr = a2.f3430a;
        int i2 = a2.f3432c + i;
        while (j != 0) {
            i2--;
            bArr[i2] = f3392c[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i2 - 1] = 45;
        }
        a2.f3432c += i;
        this.f3394b += (long) i;
        return this;
    }

    public void a(c cVar, long j) throws EOFException {
        long j2 = this.f3394b;
        if (j2 >= j) {
            cVar.write(this, j);
        } else {
            cVar.write(this, j2);
            throw new EOFException();
        }
    }

    public c k(long j) {
        p a2 = a(8);
        byte[] bArr = a2.f3430a;
        int i = a2.f3432c;
        int i2 = i + 1;
        bArr[i] = (byte) ((int) ((j >>> 56) & 255));
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((int) ((j >>> 48) & 255));
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((int) ((j >>> 40) & 255));
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((int) ((j >>> 32) & 255));
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((int) ((j >>> 24) & 255));
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((int) ((j >>> 16) & 255));
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((int) ((j >>> 8) & 255));
        int i9 = i8 + 1;
        bArr[i8] = (byte) ((int) (j & 255));
        a2.f3432c = i9;
        this.f3394b += 8;
        return this;
    }

    /* access modifiers changed from: 0000 */
    public String j(long j) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (h(j2) == 13) {
                String i = i(j2);
                skip(2);
                return i;
            }
        }
        String i2 = i(j);
        skip(1);
        return i2;
    }

    public void write(c cVar, long j) {
        int i;
        if (cVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (cVar != this) {
            v.a(cVar.f3394b, 0, j);
            while (j > 0) {
                p pVar = cVar.f3393a;
                int i2 = 0;
                if (j < ((long) (pVar.f3432c - pVar.f3431b))) {
                    p pVar2 = this.f3393a;
                    p pVar3 = pVar2 != null ? pVar2.g : null;
                    if (pVar3 != null && pVar3.f3434e) {
                        long j2 = ((long) pVar3.f3432c) + j;
                        if (pVar3.f3433d) {
                            i = 0;
                        } else {
                            i = pVar3.f3431b;
                        }
                        if (j2 - ((long) i) <= 8192) {
                            cVar.f3393a.a(pVar3, (int) j);
                            cVar.f3394b -= j;
                            this.f3394b += j;
                            return;
                        }
                    }
                    cVar.f3393a = cVar.f3393a.a((int) j);
                }
                p pVar4 = cVar.f3393a;
                long j3 = (long) (pVar4.f3432c - pVar4.f3431b);
                cVar.f3393a = pVar4.a();
                p pVar5 = this.f3393a;
                if (pVar5 == null) {
                    this.f3393a = pVar4;
                    p pVar6 = this.f3393a;
                    pVar6.g = pVar6;
                    pVar6.f = pVar6;
                } else {
                    pVar5.g.a(pVar4);
                    p pVar7 = pVar4.g;
                    if (pVar7 == pVar4) {
                        throw new IllegalStateException();
                    } else if (pVar7.f3434e) {
                        int i3 = pVar4.f3432c - pVar4.f3431b;
                        int i4 = 8192 - pVar7.f3432c;
                        if (!pVar7.f3433d) {
                            i2 = pVar7.f3431b;
                        }
                        if (i3 <= i4 + i2) {
                            pVar4.a(pVar4.g, i3);
                            pVar4.a();
                            q.a(pVar4);
                        }
                    }
                }
                cVar.f3394b -= j3;
                this.f3394b += j3;
                j -= j3;
            }
        } else {
            throw new IllegalArgumentException("source == this");
        }
    }

    public long a(s sVar) throws IOException {
        long j = this.f3394b;
        if (j > 0) {
            sVar.write(this, j);
        }
        return j;
    }

    public String a(Charset charset) {
        try {
            return a(this.f3394b, charset);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public String a(long j, Charset charset) throws EOFException {
        v.a(this.f3394b, 0, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (j > 2147483647L) {
            throw new IllegalArgumentException(a.b.a.a.a.a("byteCount > Integer.MAX_VALUE: ", j));
        } else if (j == 0) {
            return "";
        } else {
            p pVar = this.f3393a;
            int i = pVar.f3431b;
            if (((long) i) + j > ((long) pVar.f3432c)) {
                return new String(e(j), charset);
            }
            String str = new String(pVar.f3430a, i, (int) j, charset);
            pVar.f3431b = (int) (((long) pVar.f3431b) + j);
            this.f3394b -= j;
            if (pVar.f3431b == pVar.f3432c) {
                this.f3393a = pVar.a();
                q.a(pVar);
            }
            return str;
        }
    }

    public long b(f fVar) {
        long j;
        int i;
        int i2;
        p pVar = this.f3393a;
        if (pVar == null) {
            return -1;
        }
        long j2 = this.f3394b;
        long j3 = 0;
        if (j2 - 0 >= 0) {
            j = 0;
            while (true) {
                long j4 = ((long) (pVar.f3432c - pVar.f3431b)) + j;
                if (j4 >= 0) {
                    break;
                }
                pVar = pVar.f;
                j = j4;
            }
        } else {
            while (j > 0) {
                pVar = pVar.g;
                j2 = j - ((long) (pVar.f3432c - pVar.f3431b));
            }
        }
        if (fVar.g() == 2) {
            byte a2 = fVar.a(0);
            byte a3 = fVar.a(1);
            while (j < this.f3394b) {
                byte[] bArr = pVar.f3430a;
                i2 = (int) ((((long) pVar.f3431b) + j3) - j);
                int i3 = pVar.f3432c;
                while (i2 < i3) {
                    byte b2 = bArr[i2];
                    if (b2 == a2 || b2 == a3) {
                        i = pVar.f3431b;
                    } else {
                        i2++;
                    }
                }
                j3 = ((long) (pVar.f3432c - pVar.f3431b)) + j;
                pVar = pVar.f;
                j = j3;
            }
            return -1;
        }
        byte[] c2 = fVar.c();
        while (j < this.f3394b) {
            byte[] bArr2 = pVar.f3430a;
            int i4 = (int) ((((long) pVar.f3431b) + j3) - j);
            int i5 = pVar.f3432c;
            while (i2 < i5) {
                byte b3 = bArr2[i2];
                int length = c2.length;
                int i6 = 0;
                while (i6 < length) {
                    if (b3 == c2[i6]) {
                        i = pVar.f3431b;
                    } else {
                        i6++;
                    }
                }
                i4 = i2 + 1;
            }
            j3 = ((long) (pVar.f3432c - pVar.f3431b)) + j;
            pVar = pVar.f;
            j = j3;
        }
        return -1;
        return ((long) (i2 - i)) + j;
    }

    public int a(byte[] bArr, int i, int i2) {
        v.a((long) bArr.length, (long) i, (long) i2);
        p pVar = this.f3393a;
        if (pVar == null) {
            return -1;
        }
        int min = Math.min(i2, pVar.f3432c - pVar.f3431b);
        System.arraycopy(pVar.f3430a, pVar.f3431b, bArr, i, min);
        pVar.f3431b += min;
        this.f3394b -= (long) min;
        if (pVar.f3431b == pVar.f3432c) {
            this.f3393a = pVar.a();
            q.a(pVar);
        }
        return min;
    }

    public final void a() {
        try {
            skip(this.f3394b);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public c a(f fVar) {
        if (fVar != null) {
            fVar.a(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    public c a(String str) {
        a(str, 0, str.length());
        return this;
    }

    public c a(String str, int i, int i2) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            throw new IllegalArgumentException(a.b.a.a.a.b("beginIndex < 0: ", i));
        } else if (i2 < i) {
            StringBuilder sb = new StringBuilder();
            sb.append("endIndex < beginIndex: ");
            sb.append(i2);
            sb.append(" < ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        } else if (i2 <= str.length()) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt < 128) {
                    p a2 = a(1);
                    byte[] bArr = a2.f3430a;
                    int i3 = a2.f3432c - i;
                    int min = Math.min(i2, 8192 - i3);
                    int i4 = i + 1;
                    bArr[i + i3] = (byte) charAt;
                    while (true) {
                        i = i4;
                        if (i >= min) {
                            break;
                        }
                        char charAt2 = str.charAt(i);
                        if (charAt2 >= 128) {
                            break;
                        }
                        i4 = i + 1;
                        bArr[i + i3] = (byte) charAt2;
                    }
                    int i5 = i3 + i;
                    int i6 = a2.f3432c;
                    int i7 = i5 - i6;
                    a2.f3432c = i6 + i7;
                    this.f3394b += (long) i7;
                } else {
                    if (charAt < 2048) {
                        writeByte((charAt >> 6) | 192);
                        writeByte((int) (charAt & '?') | 128);
                    } else if (charAt < 55296 || charAt > 57343) {
                        writeByte((charAt >> 12) | 224);
                        writeByte(((charAt >> 6) & 63) | 128);
                        writeByte((int) (charAt & '?') | 128);
                    } else {
                        int i8 = i + 1;
                        char charAt3 = i8 < i2 ? str.charAt(i8) : 0;
                        if (charAt > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                            writeByte(63);
                            i = i8;
                        } else {
                            int i9 = (((charAt & 10239) << 10) | (9215 & charAt3)) + 0;
                            writeByte((i9 >> 18) | 240);
                            writeByte(((i9 >> 12) & 63) | 128);
                            writeByte(((i9 >> 6) & 63) | 128);
                            writeByte((i9 & 63) | 128);
                            i += 2;
                        }
                    }
                    i++;
                }
            }
            return this;
        } else {
            StringBuilder a3 = a.b.a.a.a.a("endIndex > string.length: ", i2, " > ");
            a3.append(str.length());
            throw new IllegalArgumentException(a3.toString());
        }
    }

    public c a(String str, int i, int i2, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            throw new IllegalAccessError(a.b.a.a.a.b("beginIndex < 0: ", i));
        } else if (i2 < i) {
            StringBuilder sb = new StringBuilder();
            sb.append("endIndex < beginIndex: ");
            sb.append(i2);
            sb.append(" < ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        } else if (i2 > str.length()) {
            StringBuilder a2 = a.b.a.a.a.a("endIndex > string.length: ", i2, " > ");
            a2.append(str.length());
            throw new IllegalArgumentException(a2.toString());
        } else if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (charset.equals(v.f3437a)) {
            a(str, i, i2);
            return this;
        } else {
            byte[] bytes = str.substring(i, i2).getBytes(charset);
            write(bytes, 0, bytes.length);
            return this;
        }
    }

    public long a(t tVar) throws IOException {
        if (tVar != null) {
            long j = 0;
            while (true) {
                long read = tVar.read(this, 8192);
                if (read == -1) {
                    return j;
                }
                j += read;
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    public c a(long j) {
        if (j == 0) {
            writeByte(48);
            return this;
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        p a2 = a(numberOfTrailingZeros);
        byte[] bArr = a2.f3430a;
        int i = a2.f3432c;
        for (int i2 = (i + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = f3392c[(int) (15 & j)];
            j >>>= 4;
        }
        a2.f3432c += numberOfTrailingZeros;
        this.f3394b += (long) numberOfTrailingZeros;
        return this;
    }

    /* access modifiers changed from: 0000 */
    public p a(int i) {
        p pVar;
        if (i < 1 || i > 8192) {
            throw new IllegalArgumentException();
        }
        p pVar2 = this.f3393a;
        if (pVar2 == null) {
            this.f3393a = q.a();
            p pVar3 = this.f3393a;
            pVar3.g = pVar3;
            pVar3.f = pVar3;
            return pVar3;
        }
        p pVar4 = pVar2.g;
        if (pVar4.f3432c + i > 8192 || !pVar4.f3434e) {
            pVar = q.a();
            pVar4.a(pVar);
        } else {
            pVar = pVar4;
        }
        return pVar;
    }

    public long a(byte b2) {
        return a(b2, 0, Long.MAX_VALUE);
    }

    public long a(byte b2, long j, long j2) {
        long j3 = 0;
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(this.f3394b), Long.valueOf(j), Long.valueOf(j2)}));
        }
        long j4 = this.f3394b;
        if (j2 <= j4) {
            j4 = j2;
        }
        if (j == j4) {
            return -1;
        }
        p pVar = this.f3393a;
        if (pVar == null) {
            return -1;
        }
        long j5 = this.f3394b;
        if (j5 - j >= j) {
            while (true) {
                j5 = j3;
                j3 = ((long) (pVar.f3432c - pVar.f3431b)) + j5;
                if (j3 >= j) {
                    break;
                }
                pVar = pVar.f;
            }
        } else {
            while (j5 > j) {
                pVar = pVar.g;
                j5 -= (long) (pVar.f3432c - pVar.f3431b);
            }
        }
        long j6 = j;
        while (j5 < j4) {
            byte[] bArr = pVar.f3430a;
            int min = (int) Math.min((long) pVar.f3432c, (((long) pVar.f3431b) + j4) - j5);
            for (int i = (int) ((((long) pVar.f3431b) + j6) - j5); i < min; i++) {
                if (bArr[i] == b2) {
                    return ((long) (i - pVar.f3431b)) + j5;
                }
            }
            byte b3 = b2;
            j6 = ((long) (pVar.f3432c - pVar.f3431b)) + j5;
            pVar = pVar.f;
            j5 = j6;
        }
        return -1;
    }

    public boolean a(long j, f fVar) {
        int g = fVar.g();
        if (j < 0 || g < 0 || this.f3394b - j < ((long) g) || fVar.g() - 0 < g) {
            return false;
        }
        for (int i = 0; i < g; i++) {
            if (h(((long) i) + j) != fVar.a(0 + i)) {
                return false;
            }
        }
        return true;
    }

    public final C0046c a(C0046c cVar) {
        if (cVar.f3397a == null) {
            cVar.f3397a = this;
            cVar.f3398b = true;
            return cVar;
        }
        throw new IllegalStateException("already attached to a buffer");
    }
}
