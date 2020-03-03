package com.yasoka.spcallrecord.recorder.call.e;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* compiled from: RealBufferedSource */
final class o implements e {

    /* renamed from: a reason: collision with root package name */
    public final c f3426a = new c();

    /* renamed from: b reason: collision with root package name */
    public final t f3427b;

    /* renamed from: c reason: collision with root package name */
    boolean f3428c;

    /* compiled from: RealBufferedSource */
    class a extends InputStream {
        a() {
        }

        public int available() throws IOException {
            o oVar = o.this;
            if (!oVar.f3428c) {
                return (int) Math.min(oVar.f3426a.f3394b, 2147483647L);
            }
            throw new IOException("closed");
        }

        public void close() throws IOException {
            o.this.close();
        }

        public int read() throws IOException {
            o oVar = o.this;
            if (!oVar.f3428c) {
                c cVar = oVar.f3426a;
                if (cVar.f3394b == 0 && oVar.f3427b.read(cVar, 8192) == -1) {
                    return -1;
                }
                return o.this.f3426a.readByte() & 255;
            }
            throw new IOException("closed");
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(o.this);
            sb.append(".inputStream()");
            return sb.toString();
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            if (!o.this.f3428c) {
                v.a((long) bArr.length, (long) i, (long) i2);
                o oVar = o.this;
                c cVar = oVar.f3426a;
                if (cVar.f3394b == 0 && oVar.f3427b.read(cVar, 8192) == -1) {
                    return -1;
                }
                return o.this.f3426a.a(bArr, i, i2);
            }
            throw new IOException("closed");
        }
    }

    o(t tVar) {
        if (tVar != null) {
            this.f3427b = tVar;
            return;
        }
        throw new NullPointerException("source == null");
    }

    public void a(c cVar, long j) throws IOException {
        try {
            if (d(j)) {
                c cVar2 = this.f3426a;
                long j2 = cVar2.f3394b;
                if (j2 >= j) {
                    cVar.write(cVar2, j);
                } else {
                    cVar.write(cVar2, j2);
                    throw new EOFException();
                }
            } else {
                throw new EOFException();
            }
        } catch (EOFException e2) {
            cVar.a((t) this.f3426a);
            throw e2;
        }
    }

    public c b() {
        return this.f3426a;
    }

    public f c(long j) throws IOException {
        if (d(j)) {
            return this.f3426a.c(j);
        }
        throw new EOFException();
    }

    public void close() throws IOException {
        if (!this.f3428c) {
            this.f3428c = true;
            this.f3427b.close();
            this.f3426a.a();
        }
    }

    public boolean d(long j) throws IOException {
        c cVar;
        if (j < 0) {
            throw new IllegalArgumentException(a.b.a.a.a.a("byteCount < 0: ", j));
        } else if (!this.f3428c) {
            do {
                cVar = this.f3426a;
                if (cVar.f3394b >= j) {
                    return true;
                }
            } while (this.f3427b.read(cVar, 8192) != -1);
            return false;
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public byte[] e(long j) throws IOException {
        if (d(j)) {
            return this.f3426a.e(j);
        }
        throw new EOFException();
    }

    public byte[] f() throws IOException {
        this.f3426a.a(this.f3427b);
        return this.f3426a.f();
    }

    public void g(long j) throws IOException {
        if (!d(j)) {
            throw new EOFException();
        }
    }

    public boolean h() throws IOException {
        if (!this.f3428c) {
            return this.f3426a.h() && this.f3427b.read(this.f3426a, 8192) == -1;
        }
        throw new IllegalStateException("closed");
    }

    public short i() throws IOException {
        g(2);
        return this.f3426a.i();
    }

    public boolean isOpen() {
        return !this.f3428c;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002b  */
    public long j() throws IOException {
        g(1);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!d((long) i2)) {
                break;
            }
            byte h = this.f3426a.h((long) i);
            if ((h >= 48 && h <= 57) || (i == 0 && h == 45)) {
                i = i2;
            } else if (i == 0) {
                throw new NumberFormatException(String.format("Expected leading [0-9] or '-' character but was %#x", new Object[]{Byte.valueOf(h)}));
            }
        }
        if (i == 0) {
        }
        return this.f3426a.j();
    }

    public long k() throws IOException {
        g(1);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!d((long) i2)) {
                break;
            }
            byte h = this.f3426a.h((long) i);
            if ((h >= 48 && h <= 57) || ((h >= 97 && h <= 102) || (h >= 65 && h <= 70))) {
                i = i2;
            } else if (i == 0) {
                throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", new Object[]{Byte.valueOf(h)}));
            }
        }
        return this.f3426a.k();
    }

    public InputStream l() {
        return new a();
    }

    public long read(c cVar, long j) throws IOException {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            throw new IllegalArgumentException(a.b.a.a.a.a("byteCount < 0: ", j));
        } else if (!this.f3428c) {
            c cVar2 = this.f3426a;
            if (cVar2.f3394b == 0 && this.f3427b.read(cVar2, 8192) == -1) {
                return -1;
            }
            return this.f3426a.read(cVar, Math.min(j, this.f3426a.f3394b));
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public byte readByte() throws IOException {
        g(1);
        return this.f3426a.readByte();
    }

    public void readFully(byte[] bArr) throws IOException {
        try {
            g((long) bArr.length);
            this.f3426a.readFully(bArr);
        } catch (EOFException e2) {
            int i = 0;
            while (true) {
                c cVar = this.f3426a;
                long j = cVar.f3394b;
                if (j > 0) {
                    int a2 = cVar.a(bArr, i, (int) j);
                    if (a2 != -1) {
                        i += a2;
                    } else {
                        throw new AssertionError();
                    }
                } else {
                    throw e2;
                }
            }
        }
    }

    public int readInt() throws IOException {
        g(4);
        return this.f3426a.readInt();
    }

    public long readLong() throws IOException {
        g(8);
        return this.f3426a.readLong();
    }

    public short readShort() throws IOException {
        g(2);
        return this.f3426a.readShort();
    }

    public void skip(long j) throws IOException {
        if (!this.f3428c) {
            while (j > 0) {
                c cVar = this.f3426a;
                if (cVar.f3394b == 0 && this.f3427b.read(cVar, 8192) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j, this.f3426a.f3394b);
                this.f3426a.skip(min);
                j -= min;
            }
            return;
        }
        throw new IllegalStateException("closed");
    }

    public u timeout() {
        return this.f3427b.timeout();
    }

    public String toString() {
        StringBuilder a2 = a.b.a.a.a.a("buffer(");
        a2.append(this.f3427b);
        a2.append(")");
        return a2.toString();
    }

    public int g() throws IOException {
        g(4);
        return this.f3426a.g();
    }

    public String f(long j) throws IOException {
        if (j >= 0) {
            long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
            long a2 = a(10, 0, j2);
            if (a2 != -1) {
                return this.f3426a.j(a2);
            }
            if (j2 < Long.MAX_VALUE && d(j2) && this.f3426a.h(j2 - 1) == 13 && d(1 + j2) && this.f3426a.h(j2) == 10) {
                return this.f3426a.j(j2);
            }
            c cVar = new c();
            c cVar2 = this.f3426a;
            cVar2.a(cVar, 0, Math.min(32, cVar2.f3394b));
            StringBuilder a3 = a.b.a.a.a.a("\\n not found: limit=");
            a3.append(Math.min(this.f3426a.f3394b, j));
            a3.append(" content=");
            a3.append(cVar.o().b());
            a3.append(8230);
            throw new EOFException(a3.toString());
        }
        throw new IllegalArgumentException(a.b.a.a.a.a("limit < 0: ", j));
    }

    public String e() throws IOException {
        return f(Long.MAX_VALUE);
    }

    public int read(ByteBuffer byteBuffer) throws IOException {
        c cVar = this.f3426a;
        if (cVar.f3394b == 0 && this.f3427b.read(cVar, 8192) == -1) {
            return -1;
        }
        return this.f3426a.read(byteBuffer);
    }

    public long a(s sVar) throws IOException {
        if (sVar != null) {
            long j = 0;
            while (this.f3427b.read(this.f3426a, 8192) != -1) {
                long m = this.f3426a.m();
                if (m > 0) {
                    j += m;
                    sVar.write(this.f3426a, m);
                }
            }
            c cVar = this.f3426a;
            long j2 = cVar.f3394b;
            if (j2 <= 0) {
                return j;
            }
            long j3 = j + j2;
            sVar.write(cVar, j2);
            return j3;
        }
        throw new IllegalArgumentException("sink == null");
    }

    public String a(Charset charset) throws IOException {
        if (charset != null) {
            this.f3426a.a(this.f3427b);
            return this.f3426a.a(charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    public long a(byte b2) throws IOException {
        return a(b2, 0, Long.MAX_VALUE);
    }

    public long a(byte b2, long j, long j2) throws IOException {
        if (this.f3428c) {
            throw new IllegalStateException("closed");
        } else if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(j), Long.valueOf(j2)}));
        } else {
            while (j < j2) {
                long a2 = this.f3426a.a(b2, j, j2);
                if (a2 == -1) {
                    c cVar = this.f3426a;
                    long j3 = cVar.f3394b;
                    if (j3 >= j2 || this.f3427b.read(cVar, 8192) == -1) {
                        break;
                    }
                    j = Math.max(j, j3);
                } else {
                    return a2;
                }
            }
            return -1;
        }
    }

    public boolean a(long j, f fVar) throws IOException {
        int g = fVar.g();
        if (this.f3428c) {
            throw new IllegalStateException("closed");
        } else if (j < 0 || g < 0 || fVar.g() - 0 < g) {
            return false;
        } else {
            for (int i = 0; i < g; i++) {
                long j2 = ((long) i) + j;
                if (!d(1 + j2) || this.f3426a.h(j2) != fVar.a(0 + i)) {
                    return false;
                }
            }
            return true;
        }
    }
}
