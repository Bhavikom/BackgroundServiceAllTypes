package com.yasoka.spcallrecord.recorder.call.a.d.a.a.i.s;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.h;
import com.google.android.gms.common.k.c;
import com.google.android.gms.internal.measurement.C0264n0;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.KotlinVersion;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final class b {
    public static int a(int i) {
        if (i >= 200 && i <= 299) {
            return 0;
        }
        if (i >= 300 && i <= 399) {
            return 1;
        }
        if (i >= 400 && i <= 499) {
            return 0;
        }
        if (i >= 500) {
        }
        return 1;
    }

    public static void a(String str) {
        if (!(Looper.getMainLooper() == Looper.myLooper())) {
            throw new IllegalStateException(str);
        }
    }

    public static String b(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException("Given String is empty or null");
    }

    public static void c(String str) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IllegalStateException(str);
        }
    }

    public static boolean d() {
        return VERSION.SDK_INT >= 21;
    }

    public static String e(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8").replace("+", "%20").replace("%21", "!").replace("%27", "'").replace("%28", "(").replace("%29", ")").replace("%7E", "~");
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static boolean f() {
        return VERSION.SDK_INT >= 28;
    }

    public static String d(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static <V> V a(C0264n0<V> n0Var) {
        long clearCallingIdentity;
        try {
            return n0Var.a();
        } catch (SecurityException unused) {
            clearCallingIdentity = Binder.clearCallingIdentity();
            V a2 = n0Var.a();
            Binder.restoreCallingIdentity(clearCallingIdentity);
            return a2;
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(clearCallingIdentity);
            throw th;
        }
    }

    public static boolean b() {
        return VERSION.SDK_INT >= 18;
    }

    public static boolean c() {
        return VERSION.SDK_INT >= 20;
    }

    public static void b(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void c(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static <T> T b(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    public static <T> T c(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    public static void b(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static <T> T b(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static void a(@NonNull Bundle bundle, @NonNull Object obj) {
        String str = "value";
        if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
        } else {
            bundle.putString(str, obj.toString());
        }
    }

    public static boolean e() {
        return VERSION.SDK_INT >= 26;
    }

    @NonNull
    public static <T> T a(@Nullable T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException("null reference");
    }

    public static String a(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    public static <T> T a(@NonNull Bundle bundle, String str, Class<T> cls, T t) {
        T t2 = bundle.get(str);
        if (t2 == null) {
            return t;
        }
        if (cls.isAssignableFrom(t2.getClass())) {
            return t2;
        }
        throw new IllegalStateException(String.format("Invalid conditional user property field type. '%s' expected [%s] but was [%s]", new Object[]{str, cls.getCanonicalName(), t2.getClass().getCanonicalName()}));
    }

    @NonNull
    public static <T> T a(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static String a(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        for (Entry entry : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(e((String) entry.getKey()));
            sb.append("=");
            sb.append(e((String) entry.getValue()));
        }
        return sb.toString();
    }

    public static boolean a(Context context, int i) {
        String str = "com.google.android.gms";
        if (!c.a(context).a(i, str)) {
            return false;
        }
        try {
            return h.a(context).a(context.getPackageManager().getPackageInfo(str, 64));
        } catch (NameNotFoundException unused) {
            Log.isLoggable("UidVerifier", 3);
            return false;
        }
    }

    @Nullable
    public static String a(String str, String[] strArr, String[] strArr2) {
        a((T) strArr);
        a((T) strArr2);
        int min = Math.min(strArr.length, strArr2.length);
        for (int i = 0; i < min; i++) {
            String str2 = strArr[i];
            boolean z = (str == null && str2 == null) ? true : str == null ? false : str.equals(str2);
            if (z) {
                return strArr2[i];
            }
        }
        return null;
    }

    @Nullable
    public static String a() {
        try {
            return KotlinVersion.CURRENT.toString();
        } catch (NoClassDefFoundError unused) {
            return null;
        }
    }

    public static <T> T a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static void a(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void a(Handler handler) {
        if (Looper.myLooper() != handler.getLooper()) {
            throw new IllegalStateException("Must be called on the handler thread");
        }
    }
}
