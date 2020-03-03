package com.yasoka.spcallrecord.recorder.call.a.d.a.a.i;

import a.d.a.a.b;
import a.d.a.a.g;
import a.d.a.a.h;
import a.d.a.a.i.t.c;
import a.d.a.a.i.t.e;
import a.d.a.a.i.u.a;
import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo.Scope;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.m;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.q;
import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public class o implements n {

    /* renamed from: e reason: collision with root package name */
    private static volatile p f360e;

    /* renamed from: a reason: collision with root package name */
    private final a f361a;

    /* renamed from: b reason: collision with root package name */
    private final a f362b;

    /* renamed from: c reason: collision with root package name */
    private final e f363c;

    /* renamed from: d reason: collision with root package name */
    private final m f364d;

    o(a aVar, a aVar2, e eVar, m mVar, q qVar) {
        this.f361a = aVar;
        this.f362b = aVar2;
        this.f363c = eVar;
        this.f364d = mVar;
        qVar.a();
    }

    public static void a(Context context) {
        if (f360e == null) {
            synchronized (o.class) {
                if (f360e == null) {
                    b bVar = (b) d.n();
                    bVar.a(context);
                    f360e = bVar.a();
                }
            }
        }
    }

    public static o b() {
        p pVar = f360e;
        if (pVar != null) {
            return pVar.m();
        }
        throw new IllegalStateException("Not initialized!");
    }

    public g a(e eVar) {
        Set set;
        if (eVar instanceof e) {
            set = Collections.unmodifiableSet(((com.google.android.datatransport.cct.a) eVar).e());
        } else {
            set = Collections.singleton(b.a("proto"));
        }
        j.a d2 = j.d();
        com.google.android.datatransport.cct.a aVar = (com.google.android.datatransport.cct.a) eVar;
        aVar.d();
        d2.a("cct");
        d2.a(aVar.c());
        return new k(set, d2.a(), this);
    }

    @RestrictTo({Scope.LIBRARY})
    public m a() {
        return this.f364d;
    }

    public void a(i iVar, h hVar) {
        e eVar = this.f363c;
        j a2 = iVar.d().a(iVar.b().c());
        g.a i = g.i();
        i.a(this.f361a.a());
        i.b(this.f362b.a());
        i.a(iVar.e());
        i.a(new f(iVar.a(), (byte[]) iVar.c().apply(iVar.b().b())));
        i.a(iVar.b().a());
        ((c) eVar).a(a2, i.a(), hVar);
    }
}
