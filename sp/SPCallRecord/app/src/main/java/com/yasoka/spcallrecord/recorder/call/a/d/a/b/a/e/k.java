package com.yasoka.spcallrecord.recorder.call.a.d.a.b.a.e;

import a.d.a.a.i.s.b;
import android.content.Context;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.C0132i;
import com.google.android.gms.common.api.internal.C0132i.a;
import com.google.android.gms.location.C0347b;
import com.google.android.gms.location.C0348c;
import java.util.HashMap;
import java.util.Map;

public final class k {

    /* renamed from: a reason: collision with root package name */
    private final y<C0105g> f482a;

    /* renamed from: b reason: collision with root package name */
    private boolean f483b = false;

    /* renamed from: c reason: collision with root package name */
    private final Map<a<C0348c>, p> f484c = new HashMap();

    /* renamed from: d reason: collision with root package name */
    private final Map<a<Object>, o> f485d = new HashMap();

    /* renamed from: e reason: collision with root package name */
    private final Map<a<C0347b>, l> f486e = new HashMap();

    public k(Context context, y<C0105g> yVar) {
        this.f482a = yVar;
    }

    private final l a(C0132i<C0347b> iVar) {
        l lVar;
        synchronized (this.f486e) {
            lVar = (l) this.f486e.get(iVar.b());
            if (lVar == null) {
                lVar = new l(iVar);
            }
            this.f486e.put(iVar.b(), lVar);
        }
        return lVar;
    }

    public final void a() throws RemoteException {
        synchronized (this.f484c) {
            for (p pVar : this.f484c.values()) {
                if (pVar != null) {
                    C0105g gVar = (C0105g) ((D) this.f482a).b();
                    w wVar = new w(2, null, pVar.asBinder(), null, null, null);
                    C0106h hVar = (C0106h) gVar;
                    Parcel e2 = hVar.e();
                    B.a(e2, (Parcelable) wVar);
                    hVar.a(59, e2);
                }
            }
            this.f484c.clear();
        }
        synchronized (this.f486e) {
            for (l lVar : this.f486e.values()) {
                if (lVar != null) {
                    C0105g gVar2 = (C0105g) ((D) this.f482a).b();
                    w a2 = w.a(lVar, null);
                    C0106h hVar2 = (C0106h) gVar2;
                    Parcel e3 = hVar2.e();
                    B.a(e3, (Parcelable) a2);
                    hVar2.a(59, e3);
                }
            }
            this.f486e.clear();
        }
        synchronized (this.f485d) {
            for (o oVar : this.f485d.values()) {
                if (oVar != null) {
                    C0105g gVar3 = (C0105g) ((D) this.f482a).b();
                    G g = new G(2, null, oVar.asBinder(), null);
                    C0106h hVar3 = (C0106h) gVar3;
                    Parcel e4 = hVar3.e();
                    B.a(e4, (Parcelable) g);
                    hVar3.a(75, e4);
                }
            }
            this.f485d.clear();
        }
    }

    public final void b() throws RemoteException {
        if (this.f483b) {
            ((D) this.f482a).a();
            C0106h hVar = (C0106h) ((D) this.f482a).b();
            Parcel e2 = hVar.e();
            B.a(e2, false);
            hVar.a(12, e2);
            this.f483b = false;
        }
    }

    public final void a(u uVar, C0132i<C0347b> iVar, C0102d dVar) throws RemoteException {
        ((D) this.f482a).a();
        l a2 = a(iVar);
        IInterface b2 = ((D) this.f482a).b();
        w wVar = new w(1, uVar, null, null, a2.asBinder(), dVar != null ? dVar.asBinder() : null);
        C0106h hVar = (C0106h) b2;
        Parcel e2 = hVar.e();
        B.a(e2, (Parcelable) wVar);
        hVar.a(59, e2);
    }

    public final void a(a<C0347b> aVar, C0102d dVar) throws RemoteException {
        ((D) this.f482a).a();
        b.a(aVar, (Object) "Invalid null listener key");
        synchronized (this.f486e) {
            l lVar = (l) this.f486e.remove(aVar);
            if (lVar != null) {
                lVar.e();
                C0105g gVar = (C0105g) ((D) this.f482a).b();
                w a2 = w.a(lVar, dVar);
                C0106h hVar = (C0106h) gVar;
                Parcel e2 = hVar.e();
                B.a(e2, (Parcelable) a2);
                hVar.a(59, e2);
            }
        }
    }
}
