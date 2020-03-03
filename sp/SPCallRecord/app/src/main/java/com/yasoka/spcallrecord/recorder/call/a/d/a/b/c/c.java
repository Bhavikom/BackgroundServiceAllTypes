package com.yasoka.spcallrecord.recorder.call.a.d.a.b.c;

import a.d.a.b.c.b.a;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a.C0028a;
import com.google.android.gms.common.api.a.g;

public final class c {

    /* renamed from: a reason: collision with root package name */
    private static final g<a> f541a = new g<>();

    /* renamed from: b reason: collision with root package name */
    private static final g<a> f542b = new g<>();

    /* renamed from: c reason: collision with root package name */
    public static final C0028a<a, a> f543c = new d();

    /* renamed from: d reason: collision with root package name */
    private static final C0028a<a, Object> f544d = new e();

    static {
        new Scope("profile");
        new Scope(NotificationCompat.CATEGORY_EMAIL);
        new com.google.android.gms.common.api.a("SignIn.API", f543c, f541a);
        new com.google.android.gms.common.api.a("SignIn.INTERNAL_API", f544d, f542b);
    }
}
