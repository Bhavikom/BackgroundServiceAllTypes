package com.yasoka.spcallrecord.recorder.call.e;

import a.b.a.a.a;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* compiled from: GzipSource */
public final class j implements t {

    /* renamed from: a reason: collision with root package name */
    private int f3408a = 0;

    /* renamed from: b reason: collision with root package name */
    private final e f3409b;

    /* renamed from: c reason: collision with root package name */
    private final Inflater f3410c;

    /* renamed from: d reason: collision with root package name */
    private final k f3411d;

    /* renamed from: e reason: collision with root package name */
    private final CRC32 f3412e = new CRC32();

    public j(t tVar) {
        if (tVar != null) {
            this.f3410c = new Inflater(true);
            this.f3409b = l.a(tVar);
            this.f3411d = new k(this.f3409b, this.f3410c);
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    private void a(c cVar, long j, long j2) {
        p pVar = cVar.f3393a;
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
            int i3 = (int) (((long) pVar.f3431b) + j);
            int min = (int) Math.min((long) (pVar.f3432c - i3), j2);
            this.f3412e.update(pVar.f3430a, i3, min);
            j2 -= (long) min;
            pVar = pVar.f;
            j = 0;
        }
    }

    public void close() throws IOException {
        this.f3411d.close();
    }

    public long read(c cVar, long j) throws IOException {
        long j2;
        c cVar2 = cVar;
        long j3 = j;
        if (j3 < 0) {
            throw new IllegalArgumentException(a.a("byteCount < 0: ", j3));
        } else if (j3 == 0) {
            return 0;
        } else {
            if (this.f3408a == 0) {
                this.f3409b.g(10);
                byte h = this.f3409b.b().h(3);
                boolean z = ((h >> 1) & 1) == 1;
                if (z) {
                    a(this.f3409b.b(), 0, 10);
                }
                a("ID1ID2", 8075, (int) this.f3409b.readShort());
                this.f3409b.skip(8);
                if (((h >> 2) & 1) == 1) {
                    this.f3409b.g(2);
                    if (z) {
                        a(this.f3409b.b(), 0, 2);
                    }
                    long i = (long) this.f3409b.b().i();
                    this.f3409b.g(i);
                    if (z) {
                        j2 = i;
                        a(this.f3409b.b(), 0, i);
                    } else {
                        j2 = i;
                    }
                    this.f3409b.skip(j2);
                }
                if (((h >> 3) & 1) == 1) {
                    long a2 = this.f3409b.a(0);
                    if (a2 != -1) {
                        if (z) {
                            a(this.f3409b.b(), 0, a2 + 1);
                        }
                        this.f3409b.skip(a2 + 1);
                    } else {
                        throw new EOFException();
                    }
                }
                if (((h >> 4) & 1) == 1) {
                    long a3 = this.f3409b.a(0);
                    if (a3 != -1) {
                        if (z) {
                            a(this.f3409b.b(), 0, a3 + 1);
                        }
                        this.f3409b.skip(a3 + 1);
                    } else {
                        throw new EOFException();
                    }
                }
                if (z) {
                    a("FHCRC", (int) this.f3409b.i(), (int) (short) ((int) this.f3412e.getValue()));
                    this.f3412e.reset();
                }
                this.f3408a = 1;
            }
            if (this.f3408a == 1) {
                long j4 = cVar2.f3394b;
                long read = this.f3411d.read(cVar2, j3);
                if (read != -1) {
                    a(cVar, j4, read);
                    return read;
                }
                this.f3408a = 2;
            }
            if (this.f3408a == 2) {
                a("CRC", this.f3409b.g(), (int) this.f3412e.getValue());
                a("ISIZE", this.f3409b.g(), (int) this.f3410c.getBytesWritten());
                this.f3408a = 3;
                if (!this.f3409b.h()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1;
        }
    }

    public u timeout() {
        return this.f3409b.timeout();
    }

    private void a(String str, int i, int i2) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i)}));
        }
    }
}
