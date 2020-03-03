package com.yasoka.spcallrecord.recorder.call.a.d.a.b.c.b;

import a.d.a.b.c.f;
import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.c.b;
import com.google.android.gms.common.g;
import com.google.android.gms.common.internal.C0150b.c;
import com.google.android.gms.common.internal.C0152d;
import com.google.android.gms.common.internal.C0156h;
import com.google.android.gms.common.internal.C0167t;

public class a extends C0156h<g> implements f {
    private final Bundle A;
    private Integer B;
    private final boolean y;
    private final C0152d z;

    public a(Context context, Looper looper, C0152d dVar, com.google.android.gms.common.api.c.a aVar, b bVar) {
        a.d.a.b.c.a h = dVar.h();
        Integer d2 = dVar.d();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", dVar.a());
        if (d2 != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", d2.intValue());
        }
        if (h != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", h.g());
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", h.f());
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", h.d());
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", h.e());
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", h.b());
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", h.h());
            if (h.a() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.authApiSignInModuleVersion", h.a().longValue());
            }
            if (h.c() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.realClientLibraryVersion", h.c().longValue());
            }
        }
        super(context, looper, 44, dVar, aVar, bVar);
        this.y = true;
        this.z = dVar;
        this.A = bundle;
        this.B = dVar.d();
    }

    public int a() {
        return g.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r7.a(new a.d.a.b.c.b.k(1, new com.google.android.gms.common.b(8, null, null), null));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0050, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0041 */
    public final void a(e eVar) {
        a.d.a.a.i.s.b.a(eVar, (Object) "Expecting a valid ISignInCallbacks");
        Account b2 = this.z.b();
        ((h) ((g) n())).a(new i(1, new C0167t(b2, this.B.intValue(), "<<default account>>".equals(b2.name) ? com.google.android.gms.auth.api.signin.a.a.a(j()).a() : null)), eVar);
    }

    public boolean c() {
        return this.y;
    }

    /* access modifiers changed from: protected */
    public Bundle l() {
        if (!j().getPackageName().equals(this.z.f())) {
            this.A.putString("com.google.android.gms.signin.internal.realClientPackageName", this.z.f());
        }
        return this.A;
    }

    /* access modifiers changed from: protected */
    public String o() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    /* access modifiers changed from: protected */
    public String p() {
        return "com.google.android.gms.signin.service.START";
    }

    public final void s() {
        a((c) new d());
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ IInterface a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        if (queryLocalInterface instanceof g) {
            return (g) queryLocalInterface;
        }
        return new h(iBinder);
    }
}
