package com.yasoka.spcallrecord.recorder.call.a.d.a.b.a.d;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.firebase:firebase-messaging@@20.1.0 */
final class i extends FilterInputStream {

    /* renamed from: a reason: collision with root package name */
    private long f462a;

    /* renamed from: b reason: collision with root package name */
    private long f463b = -1;

    i(InputStream inputStream) {
        super(inputStream);
        if (inputStream != null) {
            this.f462a = 1048577;
            return;
        }
        throw new NullPointerException();
    }

    public final int available() throws IOException {
        return (int) Math.min((long) this.in.available(), this.f462a);
    }

    public final synchronized void mark(int i) {
        this.in.mark(i);
        this.f463b = this.f462a;
    }

    public final int read() throws IOException {
        if (this.f462a == 0) {
            return -1;
        }
        int read = this.in.read();
        if (read != -1) {
            this.f462a--;
        }
        return read;
    }

    public final synchronized void reset() throws IOException {
        if (!this.in.markSupported()) {
            throw new IOException("Mark not supported");
        } else if (this.f463b != -1) {
            this.in.reset();
            this.f462a = this.f463b;
        } else {
            throw new IOException("Mark not set");
        }
    }

    public final long skip(long j) throws IOException {
        long skip = this.in.skip(Math.min(j, this.f462a));
        this.f462a -= skip;
        return skip;
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        long j = this.f462a;
        if (j == 0) {
            return -1;
        }
        int read = this.in.read(bArr, i, (int) Math.min((long) i2, j));
        if (read != -1) {
            this.f462a -= (long) read;
        }
        return read;
    }
}
