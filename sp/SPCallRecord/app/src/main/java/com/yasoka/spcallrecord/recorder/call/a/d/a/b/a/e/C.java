package com.yasoka.spcallrecord.recorder.call.a.d.a.b.a.e;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.c.a;
import com.google.android.gms.common.api.c.b;
import com.google.android.gms.common.internal.C0152d;
import com.google.android.gms.common.internal.C0156h;

public class C extends C0156h<C0105g> {
    private final String y;
    protected final y<C0105g> z = new D(this);

    public C(Context context, Looper looper, a aVar, b bVar, String str, C0152d dVar) {
        super(context, looper, 23, dVar, aVar, bVar);
        this.y = str;
    }

    public int a() {
        return 11925000;
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ IInterface a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        return queryLocalInterface instanceof C0105g ? (C0105g) queryLocalInterface : new C0106h(iBinder);
    }

    /* access modifiers changed from: protected */
    public Bundle l() {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", this.y);
        return bundle;
    }

    /* access modifiers changed from: protected */
    public String o() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    /* access modifiers changed from: protected */
    public String p() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }
}
