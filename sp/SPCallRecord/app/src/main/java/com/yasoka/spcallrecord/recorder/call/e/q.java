package com.yasoka.spcallrecord.recorder.call.e;

/* compiled from: SegmentPool */
final class q {

    /* renamed from: a reason: collision with root package name */
    static p f3435a;

    /* renamed from: b reason: collision with root package name */
    static long f3436b;

    private q() {
    }

    static p a() {
        synchronized (q.class) {
            if (f3435a == null) {
                return new p();
            }
            p pVar = f3435a;
            f3435a = pVar.f;
            pVar.f = null;
            f3436b -= 8192;
            return pVar;
        }
    }

    static void a(p pVar) {
        if (pVar.f != null || pVar.g != null) {
            throw new IllegalArgumentException();
        } else if (!pVar.f3433d) {
            synchronized (q.class) {
                if (f3436b + 8192 <= 65536) {
                    f3436b += 8192;
                    pVar.f = f3435a;
                    pVar.f3432c = 0;
                    pVar.f3431b = 0;
                    f3435a = pVar;
                }
            }
        }
    }
}
