package com.yasoka.spcallrecord.recorder.call.a.c.i;

import a.c.b.C0074f;
import a.c.b.C0086s;
import a.c.e.a;
import a.c.e.e;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.app.service.UploadDataService;
import com.crashlytics.android.Crashlytics;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SendAppsUsage */
public class c implements Runnable {

    /* renamed from: b reason: collision with root package name */
    public static boolean f264b;

    /* renamed from: a reason: collision with root package name */
    private final Context f265a;

    public c(Context context) {
        this.f265a = context;
    }

    private void a() {
        try {
            UploadDataService.b();
            StringBuilder sb = new StringBuilder();
            sb.append("UploadDataService.getmNbTask() : ");
            sb.append(UploadDataService.f1272b);
            sb.toString();
            if (UploadDataService.f1272b <= 0) {
                this.f265a.stopService(new Intent(this.f265a, UploadDataService.class));
            }
        } catch (Throwable th) {
            try {
                th.getStackTrace();
                Crashlytics.logException(th);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:8|9|10|(2:(4:16|(2:18|37)(1:36)|34|14)|35)|19|(1:21)|28|29|30|31) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x008c */
    public synchronized void run() {
        try {
            if (f264b) {
                a();
                return;
            }
            f264b = true;
            C0074f fVar = new C0074f(this.f265a);
            fVar.b();
            Cursor c2 = fVar.c();
            if (c2 != null && c2.getCount() > 0) {
                while (c2.moveToNext()) {
                    C0086s sVar = new C0086s();
                    sVar.a(c2.getInt(0));
                    sVar.a(c2.getString(1));
                    HashMap hashMap = new HashMap();
                    StringBuilder sb = new StringBuilder();
                    sb.append("");
                    sb.append(e.e(this.f265a));
                    hashMap.put("idPhone", sb.toString());
                    hashMap.put("dataUsage", sVar.a());
                    if (a.b("applications/insertApplicationsUsage.php", (Map<String, String>) hashMap)) {
                        fVar.a(sVar.b());
                    }
                }
            }
            fVar.a();
            if (c2 != null) {
                c2.close();
            }
            f264b = false;
            a();
        } catch (Exception e2) {
            e2.getStackTrace();
            e2.getStackTrace();
            Crashlytics.logException(e2);
        }
    }
}
