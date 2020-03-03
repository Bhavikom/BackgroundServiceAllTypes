package com.yasoka.spcallrecord.recorder.call.a.c.g;

import a.b.a.a.a;
import a.c.e.e;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.location.Location;
import android.provider.CallLog.Calls;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.app.received.LocationReceived;
import com.app.service.RecordCallService;
import com.app.service.UploadCallService;
import com.crashlytics.android.Crashlytics;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import mob.protect.children.R;
import okhttp3.MediaType;
import okhttp3.MultipartBody.Part;
import okhttp3.RequestBody;

/* compiled from: Call */
public class c implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private Context f214a;

    /* renamed from: b reason: collision with root package name */
    private String f215b;

    /* renamed from: c reason: collision with root package name */
    private String f216c;

    /* renamed from: d reason: collision with root package name */
    private String f217d;

    /* renamed from: e reason: collision with root package name */
    private int f218e;
    private int f;
    private long g;
    private int h;

    public c(Context context, String str, String str2, String str3, long j, int i) {
        this.f214a = context;
        this.f215b = str;
        this.f216c = str2;
        this.f217d = str3;
        this.f218e = i;
        this.g = j;
    }

    private void a(String str, String str2, int i, long j, String str3, String str4, double d2, double d3, double d4, File file) {
        String str5 = "";
        String c2 = a.c(str5, str);
        String c3 = a.c(str5, str2);
        String b2 = a.b(str5, i);
        String a2 = a.a(str5, j);
        String c4 = a.c(str5, str3);
        String c5 = a.c(str5, str4);
        StringBuilder sb = new StringBuilder();
        sb.append(str5);
        sb.append(d2);
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str5);
        sb3.append(d3);
        String sb4 = sb3.toString();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str5);
        sb5.append(d4);
        String sb6 = sb5.toString();
        StringBuilder a3 = a.a(str5);
        a3.append(file.getAbsolutePath());
        a.a.b(c2, c3, b2, a2, c4, c5, sb2, sb4, sb6, a3.toString(), this.f214a);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(12:179|180|190|191|192|193|194|195|(0)(0)|207|208|(0)(0)) */
    /* JADX WARNING: Can't wrap try/catch for region: R(17:0|(3:1|2|(6:4|(2:9|5)|10|11|15|(2:20|16)))|25|(4:27|28|(1:33)(1:32)|34)|41|(5:42|43|(1:45)|46|47)|54|(3:56|57|58)|65|(6:66|67|(5:69|70|71|72|73)(1:76)|77|78|(3:80|81|82))|90|(1:96)|97|(6:98|99|(3:101|102|(9:104|105|106|107|(2:109|(4:111|112|113|114)(1:115))(2:116|(1:118)(2:119|(1:121)(1:122)))|123|207|208|(2:210|221)(1:220)))|130|(12:131|132|133|134|135|136|137|138|139|140|141|142)|(21:143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|(1:164)))|207|208|(0)(0)) */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x0671, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x0672, code lost:
        r9 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x0673, code lost:
        r9.getStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:?, code lost:
        r0.getStackTrace();
        com.crashlytics.android.Crashlytics.logException(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x06a4, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x06a5, code lost:
        r0.getStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:?, code lost:
        r0.getStackTrace();
        com.crashlytics.android.Crashlytics.logException(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:194:0x0525 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:207:0x067c */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x01b2 A[SYNTHETIC, Splitter:B:101:0x01b2] */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x049b A[Catch:{ Exception -> 0x04a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x0529 A[Catch:{ Exception -> 0x0671 }] */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x05d8  */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x0695 A[Catch:{ all -> 0x06a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:220:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x013b A[Catch:{ Exception -> 0x0188 }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0151 A[Catch:{ Exception -> 0x0180 }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0160 A[SYNTHETIC, Splitter:B:80:0x0160] */
    public void run() {
        String str;
        long j;
        long j2;
        String str2;
        double d2;
        double d3;
        String str3;
        double d4;
        double d5;
        c cVar;
        double d6;
        double d7;
        double d8;
        long j3;
        String str4;
        String str5;
        String str6;
        Exception exc;
        double d9;
        double d10;
        double d11;
        String str7;
        String str8;
        long j4;
        String str9;
        String str10;
        double d12;
        String str11;
        HashMap hashMap;
        double d13;
        double d14;
        String str12;
        String str13;
        long j5;
        String str14;
        String str15;
        double d15;
        double d16;
        double d17;
        double d18;
        Location a2;
        long j6;
        String str16;
        StringBuilder a3 = a.a("mPathFile Thread : ");
        a3.append(this.f216c);
        a3.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("mFileName Thread : ");
        sb.append(this.f215b);
        sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("dateStartCall Thread : ");
        sb2.append(this.g);
        sb2.toString();
        try {
            if (RecordCallService.q) {
                LocalBroadcastManager.getInstance(this.f214a.getApplicationContext()).sendBroadcast(new Intent("telephony_status_action_stop_record"));
                while (RecordCallService.q && this.h < 600) {
                    Thread.sleep(100);
                    this.h++;
                }
                this.f214a.stopService(new Intent(this.f214a, RecordCallService.class));
                this.h = 1;
                while (RecordCallService.q && this.h < 200) {
                    Thread.sleep(100);
                    this.h++;
                }
            }
        } catch (Exception e2) {
            e2.getStackTrace();
        } catch (Throwable th) {
            th.getStackTrace();
            try {
                th.getStackTrace();
                Crashlytics.logException(th);
            } catch (Exception unused) {
            }
        }
        String str17 = "";
        SimpleDateFormat d19 = a.c.j.c.d();
        String str18 = this.f217d;
        String b2 = a.c.j.c.b();
        try {
            if (this.f217d == null || this.f217d.equals(this.f214a.getString(R.string.inconnu))) {
                str16 = this.f214a.getResources().getString(R.string.inconnu);
            } else {
                str16 = a.c.j.c.a(this.f214a, this.f217d);
            }
            str = str16;
        } catch (Exception e3) {
            e3.getStackTrace();
            try {
                e3.getStackTrace();
                Crashlytics.logException(e3);
            } catch (Exception unused2) {
            }
            str = str18;
        }
        try {
            j = a();
            if (j == -1) {
                Calendar instance = Calendar.getInstance();
                instance.setTimeInMillis(this.g);
                j = TimeUnit.MILLISECONDS.toSeconds(Calendar.getInstance().getTimeInMillis() - instance.getTimeInMillis());
            }
            try {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("duration : ");
                sb3.append(j);
                sb3.toString();
            } catch (Exception e4) {
                e = e4;
            }
        } catch (Exception e5) {
            e = e5;
            j = 0;
            e.getStackTrace();
            try {
                e.getStackTrace();
                Crashlytics.logException(e);
            } catch (Exception unused3) {
            }
            j2 = j;
            str2 = d19.format(Long.valueOf(this.g));
            d2 = 0.0d;
            a2 = LocationReceived.a();
            if (a2 == null) {
            }
            str3 = LocationReceived.a(this.f214a);
            if (j6 != 0) {
            }
            d5 = d3;
            int i = this.f;
            this.f218e = this.f;
            StringBuilder a4 = a.a("mPathFile : ");
            a4.append(this.f216c);
            a4.toString();
            if (this.f216c != null) {
            }
            d9 = d2;
            d10 = d5;
            d11 = d4;
            str7 = str2;
            str8 = str3;
            j4 = j2;
            str9 = str17;
            str10 = str;
            hashMap = new HashMap();
            String str19 = "idPhone";
            StringBuilder sb4 = new StringBuilder();
            str6 = str9;
            try {
                sb4.append(str6);
                cVar = this;
                try {
                    sb4.append(e.e(cVar.f214a));
                    hashMap.put(str19, sb4.toString());
                    String str20 = "name";
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(str6);
                    str5 = str10;
                    try {
                        sb5.append(str5);
                        hashMap.put(str20, sb5.toString());
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append(str6);
                        sb6.append(cVar.f217d);
                        hashMap.put("number", sb6.toString());
                        StringBuilder sb7 = new StringBuilder();
                        sb7.append(str6);
                        sb7.append(cVar.f218e);
                        hashMap.put("type", sb7.toString());
                        String str21 = "duration";
                        StringBuilder sb8 = new StringBuilder();
                        sb8.append(str6);
                        j3 = j4;
                        sb8.append(j3);
                        hashMap.put(str21, sb8.toString());
                        String str22 = "date";
                        StringBuilder sb9 = new StringBuilder();
                        sb9.append(str6);
                        str4 = str7;
                    } catch (Exception e6) {
                        e = e6;
                        d7 = d9;
                        d8 = d10;
                        d6 = d11;
                        str3 = str8;
                        str4 = str7;
                        j3 = j4;
                        exc = e;
                        exc.getStackTrace();
                        exc.getStackTrace();
                        Crashlytics.logException(exc);
                        if (cVar.f216c == null) {
                        }
                        UploadCallService.b();
                        StringBuilder sb10 = new StringBuilder();
                        sb10.append("UploadCallService.nbTask : ");
                        sb10.append(UploadCallService.f1263b);
                        sb10.toString();
                        if (UploadCallService.f1263b > 0) {
                        }
                    }
                } catch (Exception e7) {
                    e = e7;
                    d7 = d9;
                    d8 = d10;
                    d12 = d11;
                    str11 = str8;
                    str4 = str7;
                    j3 = j4;
                    str5 = str10;
                    exc = e;
                    exc.getStackTrace();
                    exc.getStackTrace();
                    Crashlytics.logException(exc);
                    if (cVar.f216c == null) {
                    }
                    UploadCallService.b();
                    StringBuilder sb102 = new StringBuilder();
                    sb102.append("UploadCallService.nbTask : ");
                    sb102.append(UploadCallService.f1263b);
                    sb102.toString();
                    if (UploadCallService.f1263b > 0) {
                    }
                }
            } catch (Exception e8) {
                e = e8;
                cVar = this;
                d7 = d9;
                d8 = d10;
                d12 = d11;
                str11 = str8;
                str4 = str7;
                j3 = j4;
                str5 = str10;
                exc = e;
                exc.getStackTrace();
                exc.getStackTrace();
                Crashlytics.logException(exc);
                if (cVar.f216c == null) {
                }
                UploadCallService.b();
                StringBuilder sb1022 = new StringBuilder();
                sb1022.append("UploadCallService.nbTask : ");
                sb1022.append(UploadCallService.f1263b);
                sb1022.toString();
                if (UploadCallService.f1263b > 0) {
                }
            }
            try {
                sb9.append(str4);
                hashMap.put(str22, sb9.toString());
                String str23 = "address";
                StringBuilder sb11 = new StringBuilder();
                sb11.append(str6);
                str3 = str8;
                try {
                    sb11.append(str3);
                    hashMap.put(str23, sb11.toString());
                    String str24 = "longitude";
                    StringBuilder sb12 = new StringBuilder();
                    sb12.append(str6);
                    d13 = d11;
                } catch (Exception e9) {
                    e = e9;
                    d7 = d9;
                    d8 = d10;
                    d6 = d11;
                    exc = e;
                    exc.getStackTrace();
                    exc.getStackTrace();
                    Crashlytics.logException(exc);
                    if (cVar.f216c == null) {
                    }
                    UploadCallService.b();
                    StringBuilder sb10222 = new StringBuilder();
                    sb10222.append("UploadCallService.nbTask : ");
                    sb10222.append(UploadCallService.f1263b);
                    sb10222.toString();
                    if (UploadCallService.f1263b > 0) {
                    }
                }
            } catch (Exception e10) {
                e = e10;
                d7 = d9;
                d8 = d10;
                d6 = d11;
                str3 = str8;
                exc = e;
                exc.getStackTrace();
                exc.getStackTrace();
                Crashlytics.logException(exc);
                if (cVar.f216c == null) {
                }
                UploadCallService.b();
                StringBuilder sb102222 = new StringBuilder();
                sb102222.append("UploadCallService.nbTask : ");
                sb102222.append(UploadCallService.f1263b);
                sb102222.toString();
                if (UploadCallService.f1263b > 0) {
                }
            }
            try {
                sb12.append(d13);
                hashMap.put(str24, sb12.toString());
                String str25 = "latitude";
                StringBuilder sb13 = new StringBuilder();
                sb13.append(str6);
                d14 = d10;
                try {
                    sb13.append(d14);
                    hashMap.put(str25, sb13.toString());
                    String str26 = "accuracy";
                    StringBuilder sb14 = new StringBuilder();
                    sb14.append(str6);
                    d10 = d14;
                    d7 = d9;
                    try {
                        sb14.append(d7);
                        hashMap.put(str26, sb14.toString());
                        StringBuilder sb15 = new StringBuilder();
                        sb15.append(str6);
                        sb15.append(str5);
                        String sb16 = sb15.toString();
                        StringBuilder sb17 = new StringBuilder();
                        sb17.append(str6);
                        sb17.append(cVar.f217d);
                        String sb18 = sb17.toString();
                        StringBuilder sb19 = new StringBuilder();
                        sb19.append(str6);
                        sb19.append(cVar.f218e);
                        String sb20 = sb19.toString();
                        StringBuilder sb21 = new StringBuilder();
                        sb21.append(str6);
                        sb21.append(j3);
                        String sb22 = sb21.toString();
                        StringBuilder sb23 = new StringBuilder();
                        sb23.append(str6);
                        sb23.append(str4);
                        String sb24 = sb23.toString();
                        StringBuilder sb25 = new StringBuilder();
                        sb25.append(str6);
                        sb25.append(str3);
                        String sb26 = sb25.toString();
                        StringBuilder sb27 = new StringBuilder();
                        sb27.append(str6);
                        sb27.append(d13);
                        String sb28 = sb27.toString();
                        StringBuilder sb29 = new StringBuilder();
                        sb29.append(str6);
                        d6 = d13;
                        d8 = d10;
                        try {
                            sb29.append(d8);
                            String sb30 = sb29.toString();
                            StringBuilder sb31 = new StringBuilder();
                            sb31.append(str6);
                            sb31.append(d7);
                            long b3 = a.a.b(sb16, sb18, sb20, sb22, sb24, sb26, sb28, sb30, sb31.toString(), "", cVar.f214a);
                            if (a.c.e.a.b("calls/insertCall.php", (Map<String, String>) hashMap)) {
                            }
                        } catch (Exception e11) {
                            e = e11;
                            exc = e;
                            exc.getStackTrace();
                            exc.getStackTrace();
                            Crashlytics.logException(exc);
                            if (cVar.f216c == null) {
                            }
                            UploadCallService.b();
                            StringBuilder sb1022222 = new StringBuilder();
                            sb1022222.append("UploadCallService.nbTask : ");
                            sb1022222.append(UploadCallService.f1263b);
                            sb1022222.toString();
                            if (UploadCallService.f1263b > 0) {
                            }
                        }
                    } catch (Exception e12) {
                        e = e12;
                        d6 = d13;
                        d8 = d10;
                        exc = e;
                        exc.getStackTrace();
                        exc.getStackTrace();
                        Crashlytics.logException(exc);
                        if (cVar.f216c == null) {
                        }
                        UploadCallService.b();
                        StringBuilder sb10222222 = new StringBuilder();
                        sb10222222.append("UploadCallService.nbTask : ");
                        sb10222222.append(UploadCallService.f1263b);
                        sb10222222.toString();
                        if (UploadCallService.f1263b > 0) {
                        }
                    }
                } catch (Exception e13) {
                    e = e13;
                    d6 = d13;
                    d8 = d14;
                    d7 = d9;
                    exc = e;
                    exc.getStackTrace();
                    exc.getStackTrace();
                    Crashlytics.logException(exc);
                    if (cVar.f216c == null) {
                    }
                    UploadCallService.b();
                    StringBuilder sb102222222 = new StringBuilder();
                    sb102222222.append("UploadCallService.nbTask : ");
                    sb102222222.append(UploadCallService.f1263b);
                    sb102222222.toString();
                    if (UploadCallService.f1263b > 0) {
                    }
                }
            } catch (Exception e14) {
                e = e14;
                d6 = d13;
                d7 = d9;
                d8 = d10;
                exc = e;
                exc.getStackTrace();
                exc.getStackTrace();
                Crashlytics.logException(exc);
                if (cVar.f216c == null) {
                }
                UploadCallService.b();
                StringBuilder sb1022222222 = new StringBuilder();
                sb1022222222.append("UploadCallService.nbTask : ");
                sb1022222222.append(UploadCallService.f1263b);
                sb1022222222.toString();
                if (UploadCallService.f1263b > 0) {
                }
            }
            UploadCallService.b();
            StringBuilder sb10222222222 = new StringBuilder();
            sb10222222222.append("UploadCallService.nbTask : ");
            sb10222222222.append(UploadCallService.f1263b);
            sb10222222222.toString();
            if (UploadCallService.f1263b > 0) {
            }
        }
        j2 = j;
        try {
            str2 = d19.format(Long.valueOf(this.g));
        } catch (Exception e15) {
            e15.getStackTrace();
            try {
                e15.getStackTrace();
                Crashlytics.logException(e15);
            } catch (Exception unused4) {
            }
            str2 = b2;
        }
        d2 = 0.0d;
        try {
            a2 = LocationReceived.a();
            if (a2 == null) {
                d4 = a2.getLongitude();
                try {
                    d3 = a2.getLatitude();
                } catch (Exception e16) {
                    e = e16;
                    d18 = 0.0d;
                    str3 = str17;
                    e.getStackTrace();
                    d5 = d3;
                    int i2 = this.f;
                    this.f218e = this.f;
                    StringBuilder a42 = a.a("mPathFile : ");
                    a42.append(this.f216c);
                    a42.toString();
                    if (this.f216c != null) {
                    }
                    d9 = d2;
                    d10 = d5;
                    d11 = d4;
                    str7 = str2;
                    str8 = str3;
                    j4 = j2;
                    str9 = str17;
                    str10 = str;
                    hashMap = new HashMap();
                    String str192 = "idPhone";
                    StringBuilder sb42 = new StringBuilder();
                    str6 = str9;
                    sb42.append(str6);
                    cVar = this;
                    sb42.append(e.e(cVar.f214a));
                    hashMap.put(str192, sb42.toString());
                    String str202 = "name";
                    StringBuilder sb52 = new StringBuilder();
                    sb52.append(str6);
                    str5 = str10;
                    sb52.append(str5);
                    hashMap.put(str202, sb52.toString());
                    StringBuilder sb62 = new StringBuilder();
                    sb62.append(str6);
                    sb62.append(cVar.f217d);
                    hashMap.put("number", sb62.toString());
                    StringBuilder sb72 = new StringBuilder();
                    sb72.append(str6);
                    sb72.append(cVar.f218e);
                    hashMap.put("type", sb72.toString());
                    String str212 = "duration";
                    StringBuilder sb82 = new StringBuilder();
                    sb82.append(str6);
                    j3 = j4;
                    sb82.append(j3);
                    hashMap.put(str212, sb82.toString());
                    String str222 = "date";
                    StringBuilder sb92 = new StringBuilder();
                    sb92.append(str6);
                    str4 = str7;
                    sb92.append(str4);
                    hashMap.put(str222, sb92.toString());
                    String str232 = "address";
                    StringBuilder sb112 = new StringBuilder();
                    sb112.append(str6);
                    str3 = str8;
                    sb112.append(str3);
                    hashMap.put(str232, sb112.toString());
                    String str242 = "longitude";
                    StringBuilder sb122 = new StringBuilder();
                    sb122.append(str6);
                    d13 = d11;
                    sb122.append(d13);
                    hashMap.put(str242, sb122.toString());
                    String str252 = "latitude";
                    StringBuilder sb132 = new StringBuilder();
                    sb132.append(str6);
                    d14 = d10;
                    sb132.append(d14);
                    hashMap.put(str252, sb132.toString());
                    String str262 = "accuracy";
                    StringBuilder sb142 = new StringBuilder();
                    sb142.append(str6);
                    d10 = d14;
                    d7 = d9;
                    sb142.append(d7);
                    hashMap.put(str262, sb142.toString());
                    StringBuilder sb152 = new StringBuilder();
                    sb152.append(str6);
                    sb152.append(str5);
                    String sb162 = sb152.toString();
                    StringBuilder sb172 = new StringBuilder();
                    sb172.append(str6);
                    sb172.append(cVar.f217d);
                    String sb182 = sb172.toString();
                    StringBuilder sb192 = new StringBuilder();
                    sb192.append(str6);
                    sb192.append(cVar.f218e);
                    String sb202 = sb192.toString();
                    StringBuilder sb212 = new StringBuilder();
                    sb212.append(str6);
                    sb212.append(j3);
                    String sb222 = sb212.toString();
                    StringBuilder sb232 = new StringBuilder();
                    sb232.append(str6);
                    sb232.append(str4);
                    String sb242 = sb232.toString();
                    StringBuilder sb252 = new StringBuilder();
                    sb252.append(str6);
                    sb252.append(str3);
                    String sb262 = sb252.toString();
                    StringBuilder sb272 = new StringBuilder();
                    sb272.append(str6);
                    sb272.append(d13);
                    String sb282 = sb272.toString();
                    StringBuilder sb292 = new StringBuilder();
                    sb292.append(str6);
                    d6 = d13;
                    d8 = d10;
                    sb292.append(d8);
                    String sb302 = sb292.toString();
                    StringBuilder sb312 = new StringBuilder();
                    sb312.append(str6);
                    sb312.append(d7);
                    long b32 = a.a.b(sb162, sb182, sb202, sb222, sb242, sb262, sb282, sb302, sb312.toString(), "", cVar.f214a);
                    if (a.c.e.a.b("calls/insertCall.php", (Map<String, String>) hashMap)) {
                    }
                    UploadCallService.b();
                    StringBuilder sb102222222222 = new StringBuilder();
                    sb102222222222.append("UploadCallService.nbTask : ");
                    sb102222222222.append(UploadCallService.f1263b);
                    sb102222222222.toString();
                    if (UploadCallService.f1263b > 0) {
                    }
                }
                try {
                    d2 = (double) a2.getAccuracy();
                    j6 = a2.getTime();
                } catch (Exception e17) {
                    e = e17;
                    d18 = d3;
                    d2 = 0.0d;
                    str3 = str17;
                    e.getStackTrace();
                    d5 = d3;
                    int i22 = this.f;
                    this.f218e = this.f;
                    StringBuilder a422 = a.a("mPathFile : ");
                    a422.append(this.f216c);
                    a422.toString();
                    if (this.f216c != null) {
                    }
                    d9 = d2;
                    d10 = d5;
                    d11 = d4;
                    str7 = str2;
                    str8 = str3;
                    j4 = j2;
                    str9 = str17;
                    str10 = str;
                    hashMap = new HashMap();
                    String str1922 = "idPhone";
                    StringBuilder sb422 = new StringBuilder();
                    str6 = str9;
                    sb422.append(str6);
                    cVar = this;
                    sb422.append(e.e(cVar.f214a));
                    hashMap.put(str1922, sb422.toString());
                    String str2022 = "name";
                    StringBuilder sb522 = new StringBuilder();
                    sb522.append(str6);
                    str5 = str10;
                    sb522.append(str5);
                    hashMap.put(str2022, sb522.toString());
                    StringBuilder sb622 = new StringBuilder();
                    sb622.append(str6);
                    sb622.append(cVar.f217d);
                    hashMap.put("number", sb622.toString());
                    StringBuilder sb722 = new StringBuilder();
                    sb722.append(str6);
                    sb722.append(cVar.f218e);
                    hashMap.put("type", sb722.toString());
                    String str2122 = "duration";
                    StringBuilder sb822 = new StringBuilder();
                    sb822.append(str6);
                    j3 = j4;
                    sb822.append(j3);
                    hashMap.put(str2122, sb822.toString());
                    String str2222 = "date";
                    StringBuilder sb922 = new StringBuilder();
                    sb922.append(str6);
                    str4 = str7;
                    sb922.append(str4);
                    hashMap.put(str2222, sb922.toString());
                    String str2322 = "address";
                    StringBuilder sb1122 = new StringBuilder();
                    sb1122.append(str6);
                    str3 = str8;
                    sb1122.append(str3);
                    hashMap.put(str2322, sb1122.toString());
                    String str2422 = "longitude";
                    StringBuilder sb1222 = new StringBuilder();
                    sb1222.append(str6);
                    d13 = d11;
                    sb1222.append(d13);
                    hashMap.put(str2422, sb1222.toString());
                    String str2522 = "latitude";
                    StringBuilder sb1322 = new StringBuilder();
                    sb1322.append(str6);
                    d14 = d10;
                    sb1322.append(d14);
                    hashMap.put(str2522, sb1322.toString());
                    String str2622 = "accuracy";
                    StringBuilder sb1422 = new StringBuilder();
                    sb1422.append(str6);
                    d10 = d14;
                    d7 = d9;
                    sb1422.append(d7);
                    hashMap.put(str2622, sb1422.toString());
                    StringBuilder sb1522 = new StringBuilder();
                    sb1522.append(str6);
                    sb1522.append(str5);
                    String sb1622 = sb1522.toString();
                    StringBuilder sb1722 = new StringBuilder();
                    sb1722.append(str6);
                    sb1722.append(cVar.f217d);
                    String sb1822 = sb1722.toString();
                    StringBuilder sb1922 = new StringBuilder();
                    sb1922.append(str6);
                    sb1922.append(cVar.f218e);
                    String sb2022 = sb1922.toString();
                    StringBuilder sb2122 = new StringBuilder();
                    sb2122.append(str6);
                    sb2122.append(j3);
                    String sb2222 = sb2122.toString();
                    StringBuilder sb2322 = new StringBuilder();
                    sb2322.append(str6);
                    sb2322.append(str4);
                    String sb2422 = sb2322.toString();
                    StringBuilder sb2522 = new StringBuilder();
                    sb2522.append(str6);
                    sb2522.append(str3);
                    String sb2622 = sb2522.toString();
                    StringBuilder sb2722 = new StringBuilder();
                    sb2722.append(str6);
                    sb2722.append(d13);
                    String sb2822 = sb2722.toString();
                    StringBuilder sb2922 = new StringBuilder();
                    sb2922.append(str6);
                    d6 = d13;
                    d8 = d10;
                    sb2922.append(d8);
                    String sb3022 = sb2922.toString();
                    StringBuilder sb3122 = new StringBuilder();
                    sb3122.append(str6);
                    sb3122.append(d7);
                    long b322 = a.a.b(sb1622, sb1822, sb2022, sb2222, sb2422, sb2622, sb2822, sb3022, sb3122.toString(), "", cVar.f214a);
                    if (a.c.e.a.b("calls/insertCall.php", (Map<String, String>) hashMap)) {
                    }
                    UploadCallService.b();
                    StringBuilder sb1022222222222 = new StringBuilder();
                    sb1022222222222.append("UploadCallService.nbTask : ");
                    sb1022222222222.append(UploadCallService.f1263b);
                    sb1022222222222.toString();
                    if (UploadCallService.f1263b > 0) {
                    }
                }
            } else {
                d4 = 0.0d;
                d3 = 0.0d;
                j6 = 0;
            }
            str3 = LocationReceived.a(this.f214a);
            if (j6 != 0) {
                try {
                    String format = d19.format(Long.valueOf(j6));
                    StringBuilder sb32 = new StringBuilder();
                    sb32.append(str3);
                    sb32.append("###DATELOC###");
                    sb32.append(format);
                    str3 = sb32.toString();
                } catch (Exception e18) {
                    e = e18;
                    e.getStackTrace();
                    d5 = d3;
                    int i222 = this.f;
                    this.f218e = this.f;
                    StringBuilder a4222 = a.a("mPathFile : ");
                    a4222.append(this.f216c);
                    a4222.toString();
                    if (this.f216c != null) {
                    }
                    d9 = d2;
                    d10 = d5;
                    d11 = d4;
                    str7 = str2;
                    str8 = str3;
                    j4 = j2;
                    str9 = str17;
                    str10 = str;
                    hashMap = new HashMap();
                    String str19222 = "idPhone";
                    StringBuilder sb4222 = new StringBuilder();
                    str6 = str9;
                    sb4222.append(str6);
                    cVar = this;
                    sb4222.append(e.e(cVar.f214a));
                    hashMap.put(str19222, sb4222.toString());
                    String str20222 = "name";
                    StringBuilder sb5222 = new StringBuilder();
                    sb5222.append(str6);
                    str5 = str10;
                    sb5222.append(str5);
                    hashMap.put(str20222, sb5222.toString());
                    StringBuilder sb6222 = new StringBuilder();
                    sb6222.append(str6);
                    sb6222.append(cVar.f217d);
                    hashMap.put("number", sb6222.toString());
                    StringBuilder sb7222 = new StringBuilder();
                    sb7222.append(str6);
                    sb7222.append(cVar.f218e);
                    hashMap.put("type", sb7222.toString());
                    String str21222 = "duration";
                    StringBuilder sb8222 = new StringBuilder();
                    sb8222.append(str6);
                    j3 = j4;
                    sb8222.append(j3);
                    hashMap.put(str21222, sb8222.toString());
                    String str22222 = "date";
                    StringBuilder sb9222 = new StringBuilder();
                    sb9222.append(str6);
                    str4 = str7;
                    sb9222.append(str4);
                    hashMap.put(str22222, sb9222.toString());
                    String str23222 = "address";
                    StringBuilder sb11222 = new StringBuilder();
                    sb11222.append(str6);
                    str3 = str8;
                    sb11222.append(str3);
                    hashMap.put(str23222, sb11222.toString());
                    String str24222 = "longitude";
                    StringBuilder sb12222 = new StringBuilder();
                    sb12222.append(str6);
                    d13 = d11;
                    sb12222.append(d13);
                    hashMap.put(str24222, sb12222.toString());
                    String str25222 = "latitude";
                    StringBuilder sb13222 = new StringBuilder();
                    sb13222.append(str6);
                    d14 = d10;
                    sb13222.append(d14);
                    hashMap.put(str25222, sb13222.toString());
                    String str26222 = "accuracy";
                    StringBuilder sb14222 = new StringBuilder();
                    sb14222.append(str6);
                    d10 = d14;
                    d7 = d9;
                    sb14222.append(d7);
                    hashMap.put(str26222, sb14222.toString());
                    StringBuilder sb15222 = new StringBuilder();
                    sb15222.append(str6);
                    sb15222.append(str5);
                    String sb16222 = sb15222.toString();
                    StringBuilder sb17222 = new StringBuilder();
                    sb17222.append(str6);
                    sb17222.append(cVar.f217d);
                    String sb18222 = sb17222.toString();
                    StringBuilder sb19222 = new StringBuilder();
                    sb19222.append(str6);
                    sb19222.append(cVar.f218e);
                    String sb20222 = sb19222.toString();
                    StringBuilder sb21222 = new StringBuilder();
                    sb21222.append(str6);
                    sb21222.append(j3);
                    String sb22222 = sb21222.toString();
                    StringBuilder sb23222 = new StringBuilder();
                    sb23222.append(str6);
                    sb23222.append(str4);
                    String sb24222 = sb23222.toString();
                    StringBuilder sb25222 = new StringBuilder();
                    sb25222.append(str6);
                    sb25222.append(str3);
                    String sb26222 = sb25222.toString();
                    StringBuilder sb27222 = new StringBuilder();
                    sb27222.append(str6);
                    sb27222.append(d13);
                    String sb28222 = sb27222.toString();
                    StringBuilder sb29222 = new StringBuilder();
                    sb29222.append(str6);
                    d6 = d13;
                    d8 = d10;
                    sb29222.append(d8);
                    String sb30222 = sb29222.toString();
                    StringBuilder sb31222 = new StringBuilder();
                    sb31222.append(str6);
                    sb31222.append(d7);
                    long b3222 = a.a.b(sb16222, sb18222, sb20222, sb22222, sb24222, sb26222, sb28222, sb30222, sb31222.toString(), "", cVar.f214a);
                    if (a.c.e.a.b("calls/insertCall.php", (Map<String, String>) hashMap)) {
                    }
                    UploadCallService.b();
                    StringBuilder sb10222222222222 = new StringBuilder();
                    sb10222222222222.append("UploadCallService.nbTask : ");
                    sb10222222222222.append(UploadCallService.f1263b);
                    sb10222222222222.toString();
                    if (UploadCallService.f1263b > 0) {
                    }
                }
            }
        } catch (Exception e19) {
            e = e19;
            d4 = 0.0d;
            d18 = 0.0d;
            str3 = str17;
            e.getStackTrace();
            d5 = d3;
            int i2222 = this.f;
            this.f218e = this.f;
            StringBuilder a42222 = a.a("mPathFile : ");
            a42222.append(this.f216c);
            a42222.toString();
            if (this.f216c != null) {
            }
            d9 = d2;
            d10 = d5;
            d11 = d4;
            str7 = str2;
            str8 = str3;
            j4 = j2;
            str9 = str17;
            str10 = str;
            hashMap = new HashMap();
            String str192222 = "idPhone";
            StringBuilder sb42222 = new StringBuilder();
            str6 = str9;
            sb42222.append(str6);
            cVar = this;
            sb42222.append(e.e(cVar.f214a));
            hashMap.put(str192222, sb42222.toString());
            String str202222 = "name";
            StringBuilder sb52222 = new StringBuilder();
            sb52222.append(str6);
            str5 = str10;
            sb52222.append(str5);
            hashMap.put(str202222, sb52222.toString());
            StringBuilder sb62222 = new StringBuilder();
            sb62222.append(str6);
            sb62222.append(cVar.f217d);
            hashMap.put("number", sb62222.toString());
            StringBuilder sb72222 = new StringBuilder();
            sb72222.append(str6);
            sb72222.append(cVar.f218e);
            hashMap.put("type", sb72222.toString());
            String str212222 = "duration";
            StringBuilder sb82222 = new StringBuilder();
            sb82222.append(str6);
            j3 = j4;
            sb82222.append(j3);
            hashMap.put(str212222, sb82222.toString());
            String str222222 = "date";
            StringBuilder sb92222 = new StringBuilder();
            sb92222.append(str6);
            str4 = str7;
            sb92222.append(str4);
            hashMap.put(str222222, sb92222.toString());
            String str232222 = "address";
            StringBuilder sb112222 = new StringBuilder();
            sb112222.append(str6);
            str3 = str8;
            sb112222.append(str3);
            hashMap.put(str232222, sb112222.toString());
            String str242222 = "longitude";
            StringBuilder sb122222 = new StringBuilder();
            sb122222.append(str6);
            d13 = d11;
            sb122222.append(d13);
            hashMap.put(str242222, sb122222.toString());
            String str252222 = "latitude";
            StringBuilder sb132222 = new StringBuilder();
            sb132222.append(str6);
            d14 = d10;
            sb132222.append(d14);
            hashMap.put(str252222, sb132222.toString());
            String str262222 = "accuracy";
            StringBuilder sb142222 = new StringBuilder();
            sb142222.append(str6);
            d10 = d14;
            d7 = d9;
            sb142222.append(d7);
            hashMap.put(str262222, sb142222.toString());
            StringBuilder sb152222 = new StringBuilder();
            sb152222.append(str6);
            sb152222.append(str5);
            String sb162222 = sb152222.toString();
            StringBuilder sb172222 = new StringBuilder();
            sb172222.append(str6);
            sb172222.append(cVar.f217d);
            String sb182222 = sb172222.toString();
            StringBuilder sb192222 = new StringBuilder();
            sb192222.append(str6);
            sb192222.append(cVar.f218e);
            String sb202222 = sb192222.toString();
            StringBuilder sb212222 = new StringBuilder();
            sb212222.append(str6);
            sb212222.append(j3);
            String sb222222 = sb212222.toString();
            StringBuilder sb232222 = new StringBuilder();
            sb232222.append(str6);
            sb232222.append(str4);
            String sb242222 = sb232222.toString();
            StringBuilder sb252222 = new StringBuilder();
            sb252222.append(str6);
            sb252222.append(str3);
            String sb262222 = sb252222.toString();
            StringBuilder sb272222 = new StringBuilder();
            sb272222.append(str6);
            sb272222.append(d13);
            String sb282222 = sb272222.toString();
            StringBuilder sb292222 = new StringBuilder();
            sb292222.append(str6);
            d6 = d13;
            d8 = d10;
            sb292222.append(d8);
            String sb302222 = sb292222.toString();
            StringBuilder sb312222 = new StringBuilder();
            sb312222.append(str6);
            sb312222.append(d7);
            long b32222 = a.a.b(sb162222, sb182222, sb202222, sb222222, sb242222, sb262222, sb282222, sb302222, sb312222.toString(), "", cVar.f214a);
            if (a.c.e.a.b("calls/insertCall.php", (Map<String, String>) hashMap)) {
            }
            UploadCallService.b();
            StringBuilder sb102222222222222 = new StringBuilder();
            sb102222222222222.append("UploadCallService.nbTask : ");
            sb102222222222222.append(UploadCallService.f1263b);
            sb102222222222222.toString();
            if (UploadCallService.f1263b > 0) {
            }
        }
        d5 = d3;
        int i22222 = this.f;
        if (i22222 == 1 || i22222 == 2 || i22222 == 3) {
            this.f218e = this.f;
        }
        StringBuilder a422222 = a.a("mPathFile : ");
        a422222.append(this.f216c);
        a422222.toString();
        try {
            if (this.f216c != null) {
                try {
                    if (new File(this.f216c).exists()) {
                        File file = new File(this.f216c);
                        double d20 = d2;
                        try {
                            if (!this.f214a.getSharedPreferences("user", 0).getBoolean("sizeCallsLimitWIFI", false)) {
                                double d21 = d5;
                                double d22 = d4;
                                String str27 = str2;
                                String str28 = str3;
                                long j7 = j2;
                                String str29 = str17;
                                String str30 = str;
                                double d23 = d20;
                                if (a.c.j.c.l(this.f214a)) {
                                    a(str30, this.f217d, this.f218e, j7, str27, str28, d22, d21, d23, this.f215b, this.f216c, file);
                                } else if (a.c.j.c.a(file, this.f214a)) {
                                    a(str30, this.f217d, this.f218e, j7, str27, str28, d22, d21, d23, this.f215b, this.f216c, file);
                                } else {
                                    a(str30, this.f217d, this.f218e, j7, str27, str28, d22, d21, d23, file);
                                }
                            } else if (a.c.j.c.l(this.f214a)) {
                                String str31 = this.f217d;
                                int i3 = this.f218e;
                                String str32 = this.f216c;
                                d17 = d20;
                                d16 = d5;
                                d15 = d4;
                                str14 = str2;
                                str15 = str3;
                                j5 = j2;
                                str13 = str17;
                                str12 = str;
                                try {
                                    a(str, str31, i3, j2, str2, str3, d15, d16, d17, this.f215b, str32, file);
                                } catch (Exception e20) {
                                    e = e20;
                                    cVar = this;
                                    exc = e;
                                    d7 = d17;
                                    d8 = d16;
                                    d6 = d15;
                                    str3 = str15;
                                    str4 = str14;
                                    j3 = j5;
                                    str6 = str13;
                                    str5 = str12;
                                    exc.getStackTrace();
                                    exc.getStackTrace();
                                    Crashlytics.logException(exc);
                                    if (cVar.f216c == null) {
                                    }
                                    UploadCallService.b();
                                    StringBuilder sb1022222222222222 = new StringBuilder();
                                    sb1022222222222222.append("UploadCallService.nbTask : ");
                                    sb1022222222222222.append(UploadCallService.f1263b);
                                    sb1022222222222222.toString();
                                    if (UploadCallService.f1263b > 0) {
                                    }
                                }
                            } else {
                                double d24 = d4;
                                String str33 = str2;
                                String str34 = str3;
                                long j8 = j2;
                                String str35 = str17;
                                String str36 = str;
                                a(str36, this.f217d, this.f218e, j8, str33, str34, d24, d5, d20, file);
                            }
                            cVar = this;
                        } catch (Exception e21) {
                            e = e21;
                            d16 = d5;
                            d15 = d4;
                            str14 = str2;
                            str15 = str3;
                            j5 = j2;
                            str13 = str17;
                            str12 = str;
                            d17 = d20;
                            cVar = this;
                            exc = e;
                            d7 = d17;
                            d8 = d16;
                            d6 = d15;
                            str3 = str15;
                            str4 = str14;
                            j3 = j5;
                            str6 = str13;
                            str5 = str12;
                            exc.getStackTrace();
                            exc.getStackTrace();
                            Crashlytics.logException(exc);
                            if (cVar.f216c == null) {
                            }
                            UploadCallService.b();
                            StringBuilder sb10222222222222222 = new StringBuilder();
                            sb10222222222222222.append("UploadCallService.nbTask : ");
                            sb10222222222222222.append(UploadCallService.f1263b);
                            sb10222222222222222.toString();
                            if (UploadCallService.f1263b > 0) {
                            }
                        }
                        UploadCallService.b();
                        StringBuilder sb102222222222222222 = new StringBuilder();
                        sb102222222222222222.append("UploadCallService.nbTask : ");
                        sb102222222222222222.append(UploadCallService.f1263b);
                        sb102222222222222222.toString();
                        if (UploadCallService.f1263b > 0) {
                            cVar.f214a.stopService(new Intent(cVar.f214a, UploadCallService.class));
                            return;
                        }
                        return;
                    }
                } catch (Exception e22) {
                    e = e22;
                    d17 = d2;
                    d16 = d5;
                    d15 = d4;
                    str14 = str2;
                    str15 = str3;
                    j5 = j2;
                    str13 = str17;
                    str12 = str;
                    cVar = this;
                    exc = e;
                    d7 = d17;
                    d8 = d16;
                    d6 = d15;
                    str3 = str15;
                    str4 = str14;
                    j3 = j5;
                    str6 = str13;
                    str5 = str12;
                    exc.getStackTrace();
                    exc.getStackTrace();
                    Crashlytics.logException(exc);
                    if (cVar.f216c == null) {
                    }
                    UploadCallService.b();
                    StringBuilder sb1022222222222222222 = new StringBuilder();
                    sb1022222222222222222.append("UploadCallService.nbTask : ");
                    sb1022222222222222222.append(UploadCallService.f1263b);
                    sb1022222222222222222.toString();
                    if (UploadCallService.f1263b > 0) {
                    }
                }
            }
            d9 = d2;
            d10 = d5;
            d11 = d4;
            str7 = str2;
            str8 = str3;
            j4 = j2;
            str9 = str17;
            str10 = str;
            try {
                hashMap = new HashMap();
                String str1922222 = "idPhone";
                StringBuilder sb422222 = new StringBuilder();
                str6 = str9;
                sb422222.append(str6);
                cVar = this;
                sb422222.append(e.e(cVar.f214a));
                hashMap.put(str1922222, sb422222.toString());
                String str2022222 = "name";
                StringBuilder sb522222 = new StringBuilder();
                sb522222.append(str6);
                str5 = str10;
                sb522222.append(str5);
                hashMap.put(str2022222, sb522222.toString());
                StringBuilder sb622222 = new StringBuilder();
                sb622222.append(str6);
                sb622222.append(cVar.f217d);
                hashMap.put("number", sb622222.toString());
                StringBuilder sb722222 = new StringBuilder();
                sb722222.append(str6);
                sb722222.append(cVar.f218e);
                hashMap.put("type", sb722222.toString());
                String str2122222 = "duration";
                StringBuilder sb822222 = new StringBuilder();
                sb822222.append(str6);
                j3 = j4;
            } catch (Exception e23) {
                e = e23;
                cVar = this;
                d7 = d9;
                d8 = d10;
                d12 = d11;
                str11 = str8;
                str4 = str7;
                j3 = j4;
                str6 = str9;
                str5 = str10;
                exc = e;
                exc.getStackTrace();
                exc.getStackTrace();
                Crashlytics.logException(exc);
                if (cVar.f216c == null) {
                }
                UploadCallService.b();
                StringBuilder sb10222222222222222222 = new StringBuilder();
                sb10222222222222222222.append("UploadCallService.nbTask : ");
                sb10222222222222222222.append(UploadCallService.f1263b);
                sb10222222222222222222.toString();
                if (UploadCallService.f1263b > 0) {
                }
            }
            try {
                sb822222.append(j3);
                hashMap.put(str2122222, sb822222.toString());
                String str2222222 = "date";
                StringBuilder sb922222 = new StringBuilder();
                sb922222.append(str6);
                str4 = str7;
                sb922222.append(str4);
                hashMap.put(str2222222, sb922222.toString());
                String str2322222 = "address";
                StringBuilder sb1122222 = new StringBuilder();
                sb1122222.append(str6);
                str3 = str8;
                sb1122222.append(str3);
                hashMap.put(str2322222, sb1122222.toString());
                String str2422222 = "longitude";
                StringBuilder sb1222222 = new StringBuilder();
                sb1222222.append(str6);
                d13 = d11;
                sb1222222.append(d13);
                hashMap.put(str2422222, sb1222222.toString());
                String str2522222 = "latitude";
                StringBuilder sb1322222 = new StringBuilder();
                sb1322222.append(str6);
                d14 = d10;
                sb1322222.append(d14);
                hashMap.put(str2522222, sb1322222.toString());
                String str2622222 = "accuracy";
                StringBuilder sb1422222 = new StringBuilder();
                sb1422222.append(str6);
                d10 = d14;
                d7 = d9;
                sb1422222.append(d7);
                hashMap.put(str2622222, sb1422222.toString());
                StringBuilder sb1522222 = new StringBuilder();
                sb1522222.append(str6);
                sb1522222.append(str5);
                String sb1622222 = sb1522222.toString();
                StringBuilder sb1722222 = new StringBuilder();
                sb1722222.append(str6);
                sb1722222.append(cVar.f217d);
                String sb1822222 = sb1722222.toString();
                StringBuilder sb1922222 = new StringBuilder();
                sb1922222.append(str6);
                sb1922222.append(cVar.f218e);
                String sb2022222 = sb1922222.toString();
                StringBuilder sb2122222 = new StringBuilder();
                sb2122222.append(str6);
                sb2122222.append(j3);
                String sb2222222 = sb2122222.toString();
                StringBuilder sb2322222 = new StringBuilder();
                sb2322222.append(str6);
                sb2322222.append(str4);
                String sb2422222 = sb2322222.toString();
                StringBuilder sb2522222 = new StringBuilder();
                sb2522222.append(str6);
                sb2522222.append(str3);
                String sb2622222 = sb2522222.toString();
                StringBuilder sb2722222 = new StringBuilder();
                sb2722222.append(str6);
                sb2722222.append(d13);
                String sb2822222 = sb2722222.toString();
                StringBuilder sb2922222 = new StringBuilder();
                sb2922222.append(str6);
                d6 = d13;
                d8 = d10;
                sb2922222.append(d8);
                String sb3022222 = sb2922222.toString();
                StringBuilder sb3122222 = new StringBuilder();
                sb3122222.append(str6);
                sb3122222.append(d7);
                long b322222 = a.a.b(sb1622222, sb1822222, sb2022222, sb2222222, sb2422222, sb2622222, sb2822222, sb3022222, sb3122222.toString(), "", cVar.f214a);
                if (a.c.e.a.b("calls/insertCall.php", (Map<String, String>) hashMap)) {
                    a.a.a((int) b322222, cVar.f214a);
                }
            } catch (Exception e24) {
                e = e24;
                d7 = d9;
                d8 = d10;
                d6 = d11;
                str3 = str8;
                str4 = str7;
                exc = e;
                exc.getStackTrace();
                exc.getStackTrace();
                Crashlytics.logException(exc);
                if (cVar.f216c == null) {
                }
                UploadCallService.b();
                StringBuilder sb102222222222222222222 = new StringBuilder();
                sb102222222222222222222.append("UploadCallService.nbTask : ");
                sb102222222222222222222.append(UploadCallService.f1263b);
                sb102222222222222222222.toString();
                if (UploadCallService.f1263b > 0) {
                }
            }
        } catch (Exception e25) {
            e = e25;
            double d25 = d5;
            str4 = str2;
            str5 = str;
            double d26 = d2;
            str6 = str17;
            d7 = d26;
            cVar = this;
            d6 = d4;
            j3 = j2;
            d8 = d25;
            exc = e;
            exc.getStackTrace();
            exc.getStackTrace();
            Crashlytics.logException(exc);
            if (cVar.f216c == null) {
                File file2 = new File(cVar.f216c);
                StringBuilder sb33 = new StringBuilder();
                sb33.append(str6);
                sb33.append(str5);
                String sb34 = sb33.toString();
                StringBuilder sb35 = new StringBuilder();
                sb35.append(str6);
                sb35.append(cVar.f217d);
                String sb36 = sb35.toString();
                StringBuilder sb37 = new StringBuilder();
                sb37.append(str6);
                sb37.append(cVar.f218e);
                String sb38 = sb37.toString();
                StringBuilder sb39 = new StringBuilder();
                sb39.append(str6);
                sb39.append(j3);
                String sb40 = sb39.toString();
                StringBuilder sb41 = new StringBuilder();
                sb41.append(str6);
                sb41.append(str4);
                String sb43 = sb41.toString();
                StringBuilder sb44 = new StringBuilder();
                sb44.append(str6);
                sb44.append(str3);
                String sb45 = sb44.toString();
                StringBuilder sb46 = new StringBuilder();
                sb46.append(str6);
                sb46.append(d6);
                String sb47 = sb46.toString();
                StringBuilder sb48 = new StringBuilder();
                sb48.append(str6);
                sb48.append(d8);
                String sb49 = sb48.toString();
                StringBuilder sb50 = new StringBuilder();
                sb50.append(str6);
                sb50.append(d7);
                String sb51 = sb50.toString();
                StringBuilder sb53 = new StringBuilder();
                sb53.append(str6);
                sb53.append(file2.getAbsolutePath());
                a.a.b(sb34, sb36, sb38, sb40, sb43, sb45, sb47, sb49, sb51, sb53.toString(), cVar.f214a);
            } else {
                Exception exc2 = exc;
                double d27 = d6;
                try {
                    StringBuilder sb54 = new StringBuilder();
                    sb54.append(str6);
                    sb54.append(str5);
                    String sb55 = sb54.toString();
                    StringBuilder sb56 = new StringBuilder();
                    sb56.append(str6);
                    sb56.append(cVar.f217d);
                    String sb57 = sb56.toString();
                    StringBuilder sb58 = new StringBuilder();
                    sb58.append(str6);
                    sb58.append(cVar.f218e);
                    String sb59 = sb58.toString();
                    StringBuilder sb60 = new StringBuilder();
                    sb60.append(str6);
                    sb60.append(j3);
                    String sb61 = sb60.toString();
                    StringBuilder sb63 = new StringBuilder();
                    sb63.append(str6);
                    sb63.append(str4);
                    String sb64 = sb63.toString();
                    StringBuilder sb65 = new StringBuilder();
                    sb65.append(str6);
                    sb65.append(str3);
                    String sb66 = sb65.toString();
                    StringBuilder sb67 = new StringBuilder();
                    sb67.append(str6);
                    sb67.append(d27);
                    String sb68 = sb67.toString();
                    StringBuilder sb69 = new StringBuilder();
                    sb69.append(str6);
                    sb69.append(d8);
                    String sb70 = sb69.toString();
                    StringBuilder sb71 = new StringBuilder();
                    sb71.append(str6);
                    sb71.append(d7);
                    a.a.b(sb55, sb57, sb59, sb61, sb64, sb66, sb68, sb70, sb71.toString(), "", cVar.f214a);
                } catch (Exception e26) {
                    e = e26;
                }
            }
            UploadCallService.b();
            StringBuilder sb1022222222222222222222 = new StringBuilder();
            sb1022222222222222222222.append("UploadCallService.nbTask : ");
            sb1022222222222222222222.append(UploadCallService.f1263b);
            sb1022222222222222222222.toString();
            if (UploadCallService.f1263b > 0) {
            }
        }
        UploadCallService.b();
        StringBuilder sb10222222222222222222222 = new StringBuilder();
        sb10222222222222222222222.append("UploadCallService.nbTask : ");
        sb10222222222222222222222.append(UploadCallService.f1263b);
        sb10222222222222222222222.toString();
        if (UploadCallService.f1263b > 0) {
        }
    }

    private void a(String str, String str2, int i, long j, String str3, String str4, double d2, double d3, double d4, String str5, String str6, File file) {
        int i2 = i;
        long j2 = j;
        double d5 = d2;
        double d6 = d3;
        double d7 = d4;
        String str7 = "";
        try {
            HashMap hashMap = new HashMap();
            StringBuilder sb = new StringBuilder();
            sb.append(str7);
            sb.append(e.e(this.f214a));
            hashMap.put("idPhone", com.app.retrofit.a.a(sb.toString()));
            hashMap.put("name", com.app.retrofit.a.a(str));
            hashMap.put("number", com.app.retrofit.a.a(str2));
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str7);
            sb2.append(i2);
            hashMap.put("type", com.app.retrofit.a.a(sb2.toString()));
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str7);
            sb3.append(j2);
            hashMap.put("duration", com.app.retrofit.a.a(sb3.toString()));
            hashMap.put("date", com.app.retrofit.a.a(str3));
            hashMap.put("address", com.app.retrofit.a.a(str4));
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str7);
            sb4.append(d5);
            hashMap.put("longitude", com.app.retrofit.a.a(sb4.toString()));
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str7);
            sb5.append(d6);
            hashMap.put("latitude", com.app.retrofit.a.a(sb5.toString()));
            StringBuilder sb6 = new StringBuilder();
            sb6.append(str7);
            sb6.append(d7);
            hashMap.put("accuracy", com.app.retrofit.a.a(sb6.toString()));
            hashMap.put("pathFile", com.app.retrofit.a.a(str5));
            StringBuilder sb7 = new StringBuilder();
            sb7.append(str7);
            sb7.append(str);
            String sb8 = sb7.toString();
            StringBuilder sb9 = new StringBuilder();
            sb9.append(str7);
            sb9.append(str2);
            String sb10 = sb9.toString();
            StringBuilder sb11 = new StringBuilder();
            sb11.append(str7);
            sb11.append(i2);
            String sb12 = sb11.toString();
            StringBuilder sb13 = new StringBuilder();
            sb13.append(str7);
            sb13.append(j2);
            String sb14 = sb13.toString();
            StringBuilder sb15 = new StringBuilder();
            sb15.append(str7);
            sb15.append(str3);
            String sb16 = sb15.toString();
            StringBuilder sb17 = new StringBuilder();
            sb17.append(str7);
            sb17.append(str4);
            String sb18 = sb17.toString();
            StringBuilder sb19 = new StringBuilder();
            sb19.append(str7);
            sb19.append(d5);
            String sb20 = sb19.toString();
            StringBuilder sb21 = new StringBuilder();
            sb21.append(str7);
            sb21.append(d6);
            String sb22 = sb21.toString();
            StringBuilder sb23 = new StringBuilder();
            sb23.append(str7);
            sb23.append(d7);
            String sb24 = sb23.toString();
            StringBuilder sb25 = new StringBuilder();
            sb25.append(str7);
            sb25.append(str6);
            long b2 = a.a.b(sb8, sb10, sb12, sb14, sb16, sb18, sb20, sb22, sb24, sb25.toString(), this.f214a);
            if (a.c.e.a.a("calls/insertCallRecord.php", hashMap, Part.createFormData("uploadedfile", file.getName(), RequestBody.create(MediaType.parse(ShareTarget.ENCODING_TYPE_MULTIPART), file))) && a.a.a((int) b2, this.f214a)) {
                file.delete();
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

    /* JADX WARNING: Removed duplicated region for block: B:67:0x01f2  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0207  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x022b A[Catch:{ Exception -> 0x022f }] */
    @SuppressLint({"MissingPermission"})
    private long a() {
        long j;
        Cursor cursor;
        int i;
        Cursor query;
        try {
            Thread.sleep(500);
            int i2 = 0;
            if (this.f217d == null || !this.f217d.equals(this.f214a.getString(R.string.inconnu))) {
                Calendar instance = Calendar.getInstance();
                instance.setTimeInMillis(this.g);
                instance.add(13, 1);
                Calendar instance2 = Calendar.getInstance();
                instance2.setTimeInMillis(this.g);
                instance2.add(13, -1);
                cursor = this.f214a.getContentResolver().query(Calls.CONTENT_URI, null, "number LIKE ? AND date <= ? AND date >= ?", new String[]{this.f217d, String.valueOf(instance.getTimeInMillis()), String.valueOf(instance2.getTimeInMillis())}, "date DESC");
                if (cursor == null || cursor.getCount() == 0) {
                    Thread.sleep(500);
                    query = this.f214a.getContentResolver().query(Calls.CONTENT_URI, null, "number LIKE ? AND date <= ? AND date >= ?", new String[]{this.f217d, String.valueOf(instance.getTimeInMillis()), String.valueOf(instance2.getTimeInMillis())}, "date DESC");
                    if (query == null || query.getCount() == 0) {
                        Calendar instance3 = Calendar.getInstance();
                        instance3.setTimeInMillis(this.g);
                        instance3.add(13, 10);
                        Calendar instance4 = Calendar.getInstance();
                        instance4.setTimeInMillis(this.g);
                        instance4.add(13, -10);
                        Cursor query2 = this.f214a.getContentResolver().query(Calls.CONTENT_URI, null, "number LIKE ? AND date <= ? AND date >= ?", new String[]{this.f217d, String.valueOf(instance3.getTimeInMillis()), String.valueOf(instance4.getTimeInMillis())}, "date DESC");
                        if (query2 == null || query2.getCount() == 0) {
                            Thread.sleep(500);
                            query = this.f214a.getContentResolver().query(Calls.CONTENT_URI, null, "number LIKE ? AND date <= ? AND date >= ?", new String[]{this.f217d, String.valueOf(instance3.getTimeInMillis()), String.valueOf(instance4.getTimeInMillis())}, "date DESC");
                            if (!(query == null || query.getCount() == 0 || query.moveToFirst())) {
                                Thread.sleep(500);
                                if (!query.moveToFirst()) {
                                    Thread.sleep(500);
                                    if (!query.moveToFirst()) {
                                        query.moveToFirst();
                                    }
                                }
                            }
                        } else {
                            if (!query2.moveToFirst()) {
                                Thread.sleep(500);
                                if (!query2.moveToFirst()) {
                                    Thread.sleep(500);
                                    if (!query2.moveToFirst()) {
                                        query2.moveToFirst();
                                    }
                                }
                            }
                            cursor = query2;
                            if (cursor != null) {
                                try {
                                    i = cursor.getColumnIndexOrThrow("duration");
                                    try {
                                        i2 = cursor.getColumnIndexOrThrow("type");
                                    } catch (Exception e2) {
                                        e = e2;
                                        e.getStackTrace();
                                        j = cursor.getLong(i);
                                        this.f = cursor.getInt(i2);
                                        if (cursor != null) {
                                        }
                                        return j;
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    i = 0;
                                    e.getStackTrace();
                                    j = cursor.getLong(i);
                                    this.f = cursor.getInt(i2);
                                    if (cursor != null) {
                                    }
                                    return j;
                                }
                            } else {
                                i = 0;
                            }
                            if (cursor != null && i > 0) {
                                j = cursor.getLong(i);
                                if (cursor != null && i2 > 0) {
                                    this.f = cursor.getInt(i2);
                                }
                                if (cursor != null) {
                                    cursor.close();
                                }
                                return j;
                            }
                            j = -1;
                            this.f = cursor.getInt(i2);
                            if (cursor != null) {
                            }
                            return j;
                        }
                    } else if (!query.moveToFirst()) {
                        Thread.sleep(500);
                        if (!query.moveToFirst()) {
                            Thread.sleep(500);
                            if (!query.moveToFirst()) {
                                query.moveToFirst();
                            }
                        }
                    }
                } else {
                    if (!cursor.moveToFirst()) {
                        Thread.sleep(500);
                        if (!cursor.moveToFirst()) {
                            Thread.sleep(500);
                            if (!cursor.moveToFirst()) {
                                cursor.moveToFirst();
                            }
                        }
                    }
                    if (cursor != null) {
                    }
                    j = cursor.getLong(i);
                    this.f = cursor.getInt(i2);
                    if (cursor != null) {
                    }
                    return j;
                }
            } else {
                query = this.f214a.getContentResolver().query(Calls.CONTENT_URI, null, null, null, "date DESC");
                if (query == null || query.getCount() == 0) {
                    Thread.sleep(1000);
                    query = this.f214a.getContentResolver().query(Calls.CONTENT_URI, null, null, null, "date DESC");
                    if (!(query == null || query.getCount() == 0 || query.moveToFirst())) {
                        Thread.sleep(1000);
                        query.moveToFirst();
                    }
                } else if (!query.moveToFirst()) {
                    Thread.sleep(500);
                    query.moveToFirst();
                }
            }
            cursor = query;
            if (cursor != null) {
            }
            try {
                j = cursor.getLong(i);
            } catch (Exception e4) {
                e4.getStackTrace();
            }
            try {
                this.f = cursor.getInt(i2);
            } catch (Exception e5) {
                try {
                    e5.getStackTrace();
                } catch (Exception e6) {
                    e = e6;
                    e.getStackTrace();
                    try {
                        e.getStackTrace();
                        Crashlytics.logException(e);
                    } catch (Exception unused) {
                    }
                    return j;
                }
            }
            if (cursor != null) {
            }
        } catch (Exception e7) {
            e = e7;
            j = -1;
        }
        return j;
    }
}
