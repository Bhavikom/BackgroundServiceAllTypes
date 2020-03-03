package com.yasoka.spcallrecord.recorder.call.a.d.a.a.i;

import a.d.a.a.i.t.c;
import a.d.a.a.i.t.h.C0096c;
import a.d.a.a.i.t.h.C0098e;
import a.d.a.a.i.t.h.E;
import a.d.a.a.i.t.h.f;
import a.d.a.a.i.t.h.y;
import a.d.a.a.i.t.h.z;
import android.content.Context;
import com.google.android.datatransport.runtime.backends.j;
import com.google.android.datatransport.runtime.backends.l;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.g;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.m;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.n;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.q;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.r;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.s;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
final class d extends p {

    /* renamed from: a reason: collision with root package name */
    private d.a.a<Executor> f342a = b.b.a.a(h.a());

    /* renamed from: b reason: collision with root package name */
    private d.a.a<Context> f343b;

    /* renamed from: c reason: collision with root package name */
    private d.a.a f344c;

    /* renamed from: d reason: collision with root package name */
    private d.a.a f345d;

    /* renamed from: e reason: collision with root package name */
    private d.a.a f346e;
    private d.a.a<y> f;
    private d.a.a<g> g;
    private d.a.a<s> h;
    private d.a.a<c> i;
    private d.a.a<m> j;
    private d.a.a<q> k;
    private d.a.a<o> l;

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    private static final class b implements a {

        /* renamed from: a reason: collision with root package name */
        private Context f347a;

        private b() {
        }

        public a a(Context context) {
            a.d.a.a.i.s.b.c(context);
            this.f347a = context;
            return this;
        }

        /* synthetic */ b(a aVar) {
        }

        public p a() {
            Context context = this.f347a;
            Class<Context> cls = Context.class;
            if (context != null) {
                return new d(context, null);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(cls.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }
    }

    /* synthetic */ d(Context context, a aVar) {
        this.f343b = b.b.c.a(context);
        this.f344c = new j(this.f343b, a.d.a.a.i.u.b.a(), a.d.a.a.i.u.c.a());
        this.f345d = b.b.a.a(new l(this.f343b, this.f344c));
        this.f346e = new E(this.f343b, C0098e.a());
        this.f = b.b.a.a(new z(a.d.a.a.i.u.b.a(), a.d.a.a.i.u.c.a(), f.a(), this.f346e));
        this.g = new a.d.a.a.i.t.f(a.d.a.a.i.u.b.a());
        this.h = new a.d.a.a.i.t.g(this.f343b, this.f, this.g, a.d.a.a.i.u.c.a());
        d.a.a<Executor> aVar2 = this.f342a;
        d.a.a aVar3 = this.f345d;
        d.a.a<s> aVar4 = this.h;
        d.a.a<y> aVar5 = this.f;
        a.d.a.a.i.t.d dVar = new a.d.a.a.i.t.d(aVar2, aVar3, aVar4, aVar5, aVar5);
        this.i = dVar;
        d.a.a<Context> aVar6 = this.f343b;
        d.a.a aVar7 = this.f345d;
        d.a.a<y> aVar8 = this.f;
        d.a.a<s> aVar9 = this.h;
        n nVar = new n(aVar6, aVar7, aVar8, aVar9, this.f342a, aVar8, a.d.a.a.i.u.b.a());
        this.j = nVar;
        d.a.a<Executor> aVar10 = this.f342a;
        d.a.a<y> aVar11 = this.f;
        this.k = new r(aVar10, aVar11, this.h, aVar11);
        q qVar = new q(a.d.a.a.i.u.b.a(), a.d.a.a.i.u.c.a(), this.i, this.j, this.k);
        this.l = b.b.a.a(qVar);
    }

    public static a n() {
        return new b(null);
    }

    /* access modifiers changed from: 0000 */
    public C0096c a() {
        return (C0096c) this.f.get();
    }

    /* access modifiers changed from: 0000 */
    public o m() {
        return (o) this.l.get();
    }
}
