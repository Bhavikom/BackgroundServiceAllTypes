package com.yasoka.spcallrecord.recorder.call.e;

import a.b.a.a.a;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: RealBufferedSink */
final class n implements d {

    /* renamed from: a reason: collision with root package name */
    public final c f3423a = new c();

    /* renamed from: b reason: collision with root package name */
    public final s f3424b;

    /* renamed from: c reason: collision with root package name */
    boolean f3425c;

    n(s sVar) {
        if (sVar != null) {
            this.f3424b = sVar;
            return;
        }
        throw new NullPointerException("sink == null");
    }

    public d a(f fVar) throws IOException {
        if (!this.f3425c) {
            this.f3423a.a(fVar);
            d();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public c b() {
        return this.f3423a;
    }

    public d c() throws IOException {
        if (!this.f3425c) {
            c cVar = this.f3423a;
            long j = cVar.f3394b;
            if (j > 0) {
                this.f3424b.write(cVar, j);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public void close() throws IOException {
        if (!this.f3425c) {
            try {
                if (this.f3423a.f3394b > 0) {
                    this.f3424b.write(this.f3423a, this.f3423a.f3394b);
                }
                th = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                this.f3424b.close();
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                }
            }
            this.f3425c = true;
            if (th != null) {
                v.a(th);
                throw null;
            }
        }
    }

    public d d() throws IOException {
        if (!this.f3425c) {
            long m = this.f3423a.m();
            if (m > 0) {
                this.f3424b.write(this.f3423a, m);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public void flush() throws IOException {
        if (!this.f3425c) {
            c cVar = this.f3423a;
            long j = cVar.f3394b;
            if (j > 0) {
                this.f3424b.write(cVar, j);
            }
            this.f3424b.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    public boolean isOpen() {
        return !this.f3425c;
    }

    public u timeout() {
        return this.f3424b.timeout();
    }

    public String toString() {
        StringBuilder a2 = a.a("buffer(");
        a2.append(this.f3424b);
        a2.append(")");
        return a2.toString();
    }

    public void write(c cVar, long j) throws IOException {
        if (!this.f3425c) {
            this.f3423a.write(cVar, j);
            d();
            return;
        }
        throw new IllegalStateException("closed");
    }

    public d writeByte(int i) throws IOException {
        if (!this.f3425c) {
            this.f3423a.writeByte(i);
            d();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public d writeInt(int i) throws IOException {
        if (!this.f3425c) {
            this.f3423a.writeInt(i);
            return d();
        }
        throw new IllegalStateException("closed");
    }

    public d writeShort(int i) throws IOException {
        if (!this.f3425c) {
            this.f3423a.writeShort(i);
            d();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public d b(long j) throws IOException {
        if (!this.f3425c) {
            this.f3423a.b(j);
            d();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public d a(String str) throws IOException {
        if (!this.f3425c) {
            this.f3423a.a(str);
            return d();
        }
        throw new IllegalStateException("closed");
    }

    public d write(byte[] bArr) throws IOException {
        if (!this.f3425c) {
            this.f3423a.write(bArr);
            d();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public long a(t tVar) throws IOException {
        if (tVar != null) {
            long j = 0;
            while (true) {
                long read = tVar.read(this.f3423a, 8192);
                if (read == -1) {
                    return j;
                }
                j += read;
                d();
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    public d write(byte[] bArr, int i, int i2) throws IOException {
        if (!this.f3425c) {
            this.f3423a.write(bArr, i, i2);
            d();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public d a(long j) throws IOException {
        if (!this.f3425c) {
            this.f3423a.a(j);
            return d();
        }
        throw new IllegalStateException("closed");
    }

    public int write(ByteBuffer byteBuffer) throws IOException {
        if (!this.f3425c) {
            int write = this.f3423a.write(byteBuffer);
            d();
            return write;
        }
        throw new IllegalStateException("closed");
    }
}
