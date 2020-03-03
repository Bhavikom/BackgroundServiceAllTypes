package com.yasoka.spcallrecord.recorder.call.a.c.a;

import a.c.e.e;
import a.c.j.c;
import android.content.Context;
import com.app.action.a;
import com.app.activity.MyApp;
import java.util.HashMap;
import java.util.Map;

/* compiled from: GetListHistory */
public class d {

    /* renamed from: a reason: collision with root package name */
    private int f10a;

    /* renamed from: b reason: collision with root package name */
    private int f11b;

    /* renamed from: c reason: collision with root package name */
    private String f12c;

    public d(int i, int i2, String str) {
        this.f10a = i;
        this.f11b = i2;
        this.f12c = str;
        String str2 = "";
        try {
            Context applicationContext = MyApp.b().getApplicationContext();
            String b2 = a.b(applicationContext, this.f10a, a.c.j.a.f295a);
            String b3 = c.b();
            HashMap hashMap = new HashMap();
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(e.e(applicationContext));
            hashMap.put("idPhone", sb.toString());
            hashMap.put("dateConnexion", b3);
            hashMap.put("type", this.f12c);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append(this.f11b);
            hashMap.put("idLog", sb2.toString());
            hashMap.put("data", b2);
            long a2 = a.a.a(e.e(applicationContext), b3, this.f12c, this.f11b, b2, applicationContext);
            if (a.c.e.a.b("remoteControl/setLog.php", (Map<String, String>) hashMap)) {
                a.a.d((int) a2, applicationContext);
            }
        } catch (Exception e2) {
            e2.getStackTrace();
        }
    }
}
