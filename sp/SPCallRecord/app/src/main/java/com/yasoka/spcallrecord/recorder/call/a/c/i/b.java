package com.yasoka.spcallrecord.recorder.call.a.c.i;

import a.c.b.C0071c;
import a.c.b.r;
import a.c.e.a;
import a.c.e.e;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.app.service.UploadDataService;
import com.crashlytics.android.Crashlytics;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SendAppsBlockState */
public class b implements Runnable {

    /* renamed from: b reason: collision with root package name */
    public static boolean f262b;

    /* renamed from: a reason: collision with root package name */
    private final Context f263a;

    public b(Context context) {
        this.f263a = context;
    }

    private void a() {
        try {
            UploadDataService.b();
            StringBuilder sb = new StringBuilder();
            sb.append("UploadDataService.getmNbTask() : ");
            sb.append(UploadDataService.f1272b);
            sb.toString();
            if (UploadDataService.f1272b <= 0) {
                this.f263a.stopService(new Intent(this.f263a, UploadDataService.class));
            }
        } catch (Throwable th) {
            try {
                th.getStackTrace();
                Crashlytics.logException(th);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:8|9|10|(2:(6:16|(1:18)|19|(2:21|40)(1:39)|37|14)|38)|22|(1:24)|31|32|33|34) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00d5 */
    public synchronized void run() {
        try {
            if (f262b) {
                a();
                return;
            }
            f262b = true;
            C0071c cVar = new C0071c(this.f263a);
            cVar.b();
            Cursor c2 = cVar.c();
            if (c2 != null && c2.getCount() > 0) {
                while (c2.moveToNext()) {
                    r rVar = new r();
                    rVar.a(c2.getInt(0));
                    rVar.b(c2.getInt(1));
                    rVar.a(c2.getLong(2));
                    rVar.a(c2.getString(3));
                    HashMap hashMap = new HashMap();
                    StringBuilder sb = new StringBuilder();
                    sb.append("");
                    sb.append(e.e(this.f263a));
                    hashMap.put("idPhone", sb.toString());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("");
                    sb2.append(rVar.b());
                    hashMap.put("id", sb2.toString());
                    if (rVar.c() != -1) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("");
                        sb3.append(rVar.c());
                        hashMap.put("idBDDPhone", sb3.toString());
                    }
                    if (a.b(rVar.d(), (Map<String, String>) hashMap)) {
                        cVar.a((long) rVar.a());
                    }
                }
            }
            cVar.a();
            if (c2 != null) {
                c2.close();
            }
            f262b = false;
            a();
        } catch (Exception e2) {
            e2.getStackTrace();
            e2.getStackTrace();
            Crashlytics.logException(e2);
        }
    }
}
