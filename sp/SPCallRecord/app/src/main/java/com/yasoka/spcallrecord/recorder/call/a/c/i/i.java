package com.yasoka.spcallrecord.recorder.call.a.c.i;

import a.c.b.B;
import a.c.b.U;
import a.c.e.a;
import a.c.e.e;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.app.service.UploadDataService;
import com.crashlytics.android.Crashlytics;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SendLocalizations */
public class i implements Runnable {

    /* renamed from: b reason: collision with root package name */
    public static boolean f276b;

    /* renamed from: a reason: collision with root package name */
    private final Context f277a;

    public i(Context context) {
        this.f277a = context;
    }

    private void a() {
        try {
            UploadDataService.b();
            StringBuilder sb = new StringBuilder();
            sb.append("UploadDataService.getmNbTask() : ");
            sb.append(UploadDataService.f1272b);
            sb.toString();
            if (UploadDataService.f1272b <= 0) {
                this.f277a.stopService(new Intent(this.f277a, UploadDataService.class));
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
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x018e */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0181 A[Catch:{ Exception -> 0x0187 }] */
    public synchronized void run() {
        try {
            if (f276b) {
                a();
                return;
            }
            f276b = true;
            U u = new U(this.f277a);
            u.b();
            Cursor c2 = u.c();
            if (c2 == null || c2.getCount() <= 0 || !c2.moveToFirst()) {
                u.a();
                if (c2 != null) {
                    c2.close();
                }
                f276b = false;
                a();
            }
            do {
                B b2 = new B();
                b2.a(c2.getInt(0));
                b2.d(c2.getString(1));
                b2.g(c2.getString(2));
                b2.f(c2.getString(3));
                b2.c(c2.getString(4));
                b2.h(c2.getString(5));
                b2.a(c2.getString(6));
                b2.b(c2.getString(7));
                b2.e(c2.getString(8));
                HashMap hashMap = new HashMap();
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(e.e(this.f277a));
                hashMap.put("idPhone", sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("");
                sb2.append(b2.d());
                hashMap.put("date", sb2.toString());
                StringBuilder sb3 = new StringBuilder();
                sb3.append("");
                sb3.append(b2.h());
                hashMap.put("longitude", sb3.toString());
                StringBuilder sb4 = new StringBuilder();
                sb4.append("");
                sb4.append(b2.g());
                hashMap.put("latitude", sb4.toString());
                StringBuilder sb5 = new StringBuilder();
                sb5.append("");
                sb5.append(b2.c());
                hashMap.put("altitude", sb5.toString());
                StringBuilder sb6 = new StringBuilder();
                sb6.append("");
                sb6.append(b2.i());
                hashMap.put("speed", sb6.toString());
                StringBuilder sb7 = new StringBuilder();
                sb7.append("");
                sb7.append(b2.a());
                hashMap.put("accuracy", sb7.toString());
                StringBuilder sb8 = new StringBuilder();
                sb8.append("");
                sb8.append(b2.b());
                hashMap.put("address", sb8.toString());
                StringBuilder sb9 = new StringBuilder();
                sb9.append("");
                sb9.append(b2.e());
                hashMap.put("gps", sb9.toString());
                if (a.b("location/insertLocation.php", (Map<String, String>) hashMap)) {
                    u.a(b2.f());
                }
            } while (c2.moveToNext());
            u.a();
            if (c2 != null) {
            }
            f276b = false;
            a();
        } catch (Exception e2) {
            e2.getStackTrace();
            Crashlytics.logException(e2);
        }
    }
}
