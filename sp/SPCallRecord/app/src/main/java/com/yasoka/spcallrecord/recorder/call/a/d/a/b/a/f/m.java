package com.yasoka.spcallrecord.recorder.call.a.d.a.b.a.f;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.c.a;
import com.google.android.gms.common.api.c.b;
import com.google.android.gms.common.internal.C0152d;
import com.google.android.gms.common.internal.C0156h;

public final class m extends C0156h<h> {
    public m(Context context, Looper looper, C0152d dVar, a aVar, b bVar) {
        super(context, looper, 45, dVar, aVar, bVar);
    }

    public final int a() {
        return 12200000;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ IInterface a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.safetynet.internal.ISafetyNetService");
        return queryLocalInterface instanceof h ? (h) queryLocalInterface : new i(iBinder);
    }

    /* access modifiers changed from: protected */
    public final String o() {
        return "com.google.android.gms.safetynet.internal.ISafetyNetService";
    }

    /* access modifiers changed from: protected */
    public final String p() {
        return "com.google.android.gms.safetynet.service.START";
    }
}
