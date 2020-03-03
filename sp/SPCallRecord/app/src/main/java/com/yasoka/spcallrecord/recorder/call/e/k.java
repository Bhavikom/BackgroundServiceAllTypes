package com.yasoka.spcallrecord.recorder.call.e;

import a.b.a.a.a;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* compiled from: InflaterSource */
public final class k implements t {

    /* renamed from: a reason: collision with root package name */
    private final e f3413a;

    /* renamed from: b reason: collision with root package name */
    private final Inflater f3414b;

    /* renamed from: c reason: collision with root package name */
    private int f3415c;

    /* renamed from: d reason: collision with root package name */
    private boolean f3416d;

    k(e eVar, Inflater inflater) {
        if (eVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (inflater != null) {
            this.f3413a = eVar;
            this.f3414b = inflater;
        } else {
            throw new IllegalArgumentException("inflater == null");
        }
    }

    private void a() throws IOException {
        int i = this.f3415c;
        if (i != 0) {
            int remaining = i - this.f3414b.getRemaining();
            this.f3415c -= remaining;
            this.f3413a.skip((long) remaining);
        }
    }

    public void close() throws IOException {
        if (!this.f3416d) {
            this.f3414b.end();
            this.f3416d = true;
            this.f3413a.close();
        }
    }

    public long read(c cVar, long j) throws IOException {
        p a2;
        if (j < 0) {
            throw new IllegalArgumentException(a.a("byteCount < 0: ", j));
        } else if (this.f3416d) {
            throw new IllegalStateException("closed");
        } else if (j == 0) {
            return 0;
        } else {
            while (true) {
                boolean z = false;
                if (this.f3414b.needsInput()) {
                    a();
                    if (this.f3414b.getRemaining() != 0) {
                        throw new IllegalStateException("?");
                    } else if (this.f3413a.h()) {
                        z = true;
                    } else {
                        p pVar = this.f3413a.b().f3393a;
                        int i = pVar.f3432c;
                        int i2 = pVar.f3431b;
                        this.f3415c = i - i2;
                        this.f3414b.setInput(pVar.f3430a, i2, this.f3415c);
                    }
                }
                try {
                    a2 = cVar.a(1);
                    int inflate = this.f3414b.inflate(a2.f3430a, a2.f3432c, (int) Math.min(j, (long) (8192 - a2.f3432c)));
                    if (inflate > 0) {
                        a2.f3432c += inflate;
                        long j2 = (long) inflate;
                        cVar.f3394b += j2;
                        return j2;
                    } else if (this.f3414b.finished()) {
                        break;
                    } else if (this.f3414b.needsDictionary()) {
                        break;
                    } else if (z) {
                        throw new EOFException("source exhausted prematurely");
                    }
                } catch (DataFormatException e2) {
                    throw new IOException(e2);
                }
            }
            a();
            if (a2.f3431b == a2.f3432c) {
                cVar.f3393a = a2.a();
                q.a(a2);
            }
            return -1;
        }
    }

    public u timeout() {
        return this.f3413a.timeout();
    }
}
