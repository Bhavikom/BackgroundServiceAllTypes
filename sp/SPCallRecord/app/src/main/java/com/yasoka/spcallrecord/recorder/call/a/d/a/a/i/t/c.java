package com.yasoka.spcallrecord.recorder.call.a.d.a.a.i.t;

import a.d.a.a.h;
import a.d.a.a.i.g;
import a.d.a.a.i.j;
import a.d.a.a.i.o;
import a.d.a.a.i.t.h.C0096c;
import a.d.a.a.i.t.h.y;
import com.google.android.datatransport.runtime.backends.e;
import com.google.android.datatransport.runtime.backends.m;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.s;
import com.google.android.datatransport.runtime.synchronization.a;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public class c implements e {
    private static final Logger f = Logger.getLogger(o.class.getName());

    /* renamed from: a reason: collision with root package name */
    private final s f377a;

    /* renamed from: b reason: collision with root package name */
    private final Executor f378b;

    /* renamed from: c reason: collision with root package name */
    private final e f379c;

    /* renamed from: d reason: collision with root package name */
    private final C0096c f380d;

    /* renamed from: e reason: collision with root package name */
    private final a f381e;

    public c(Executor executor, e eVar, s sVar, C0096c cVar, a aVar) {
        this.f378b = executor;
        this.f379c = eVar;
        this.f377a = sVar;
        this.f380d = cVar;
        this.f381e = aVar;
    }

    public void a(j jVar, g gVar, h hVar) {
        this.f378b.execute(a.a(this, jVar, hVar, gVar));
    }

    static /* synthetic */ void a(c cVar, j jVar, h hVar, g gVar) {
        try {
            m a2 = cVar.f379c.a(jVar.a());
            if (a2 == null) {
                String format = String.format("Transport backend '%s' is not registered", new Object[]{jVar.a()});
                f.warning(format);
                hVar.a(new IllegalArgumentException(format));
                return;
            }
            g a3 = a2.a(gVar);
            ((y) cVar.f381e).a(b.a(cVar, jVar, a3));
            hVar.a(null);
        } catch (Exception e2) {
            Logger logger = f;
            StringBuilder a4 = a.b.a.a.a.a("Error scheduling event ");
            a4.append(e2.getMessage());
            logger.warning(a4.toString());
            hVar.a(e2);
        }
    }

    static /* synthetic */ Object a(c cVar, j jVar, g gVar) {
        ((y) cVar.f380d).a(jVar, gVar);
        cVar.f377a.a(jVar, 1);
        return null;
    }
}
