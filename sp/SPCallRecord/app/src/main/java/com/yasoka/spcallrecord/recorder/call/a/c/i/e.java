package com.yasoka.spcallrecord.recorder.call.a.c.i;

import a.c.b.C0084p;
import a.c.b.C0091x;
import a.c.j.c;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import androidx.browser.trusted.sharing.ShareTarget;
import com.app.retrofit.a;
import com.app.service.UploadDataService;
import com.crashlytics.android.Crashlytics;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.MultipartBody.Part;
import okhttp3.RequestBody;

/* compiled from: SendCalls */
public class e implements Runnable {

    /* renamed from: b reason: collision with root package name */
    public static boolean f268b;

    /* renamed from: a reason: collision with root package name */
    private final Context f269a;

    public e(Context context) {
        this.f269a = context;
    }

    private void a() {
        try {
            UploadDataService.b();
            StringBuilder sb = new StringBuilder();
            sb.append("UploadDataService.getmNbTask() : ");
            sb.append(UploadDataService.f1272b);
            sb.toString();
            if (UploadDataService.f1272b <= 0) {
                this.f269a.stopService(new Intent(this.f269a, UploadDataService.class));
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
        Cursor cursor;
        C0084p pVar;
        String str;
        String str2 = "accuracy";
        String str3 = "latitude";
        String str4 = "longitude";
        String str5 = "address";
        String str6 = "date";
        String str7 = "duration";
        String str8 = "type";
        String str9 = "number";
        String str10 = "name";
        String str11 = "idPhone";
        String str12 = "";
        if (f268b) {
            a();
            return;
        }
        f268b = true;
        int i = 0;
        try {
            C0084p pVar2 = new C0084p(this.f269a);
            pVar2.b();
            Cursor c2 = pVar2.c();
            if (c2 == null || c2.getCount() <= 0 || !c2.moveToFirst()) {
                pVar = pVar2;
                cursor = c2;
            } else {
                while (true) {
                    C0091x xVar = new C0091x();
                    C0084p pVar3 = pVar2;
                    xVar.a(c2.getInt(i));
                    xVar.g(c2.getString(1));
                    xVar.h(c2.getString(2));
                    xVar.j(c2.getString(3));
                    xVar.d(c2.getString(4));
                    xVar.c(c2.getString(5));
                    xVar.b(c2.getString(6));
                    xVar.f(c2.getString(7));
                    xVar.e(c2.getString(8));
                    xVar.a(c2.getString(9));
                    xVar.i(c2.getString(10));
                    HashMap hashMap = new HashMap();
                    StringBuilder sb = new StringBuilder();
                    sb.append(str12);
                    cursor = c2;
                    sb.append(a.c.e.e.e(this.f269a));
                    hashMap.put(str11, sb.toString());
                    hashMap.put(str10, xVar.h());
                    hashMap.put(str9, xVar.i());
                    hashMap.put(str8, xVar.k());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str12);
                    sb2.append(xVar.d());
                    hashMap.put(str7, sb2.toString());
                    hashMap.put(str6, xVar.c());
                    hashMap.put(str5, xVar.b());
                    hashMap.put(str4, xVar.g());
                    hashMap.put(str3, xVar.f());
                    hashMap.put(str2, xVar.a());
                    if (xVar.j() == null || xVar.j().equals(str12)) {
                        str = str3;
                        pVar = pVar3;
                        a(hashMap, pVar, xVar);
                    } else {
                        File file = new File(xVar.j());
                        if (file.exists()) {
                            HashMap hashMap2 = new HashMap();
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(str12);
                            File file2 = file;
                            sb3.append(a.c.e.e.e(this.f269a));
                            hashMap2.put(str11, a.a(sb3.toString()));
                            hashMap2.put(str10, a.a(xVar.h()));
                            hashMap2.put(str9, a.a(xVar.i()));
                            hashMap2.put(str8, a.a(xVar.k()));
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append(str12);
                            sb4.append(xVar.d());
                            hashMap2.put(str7, a.a(sb4.toString()));
                            hashMap2.put(str6, a.a(xVar.c()));
                            hashMap2.put(str5, a.a(xVar.b()));
                            hashMap2.put(str4, a.a(xVar.g()));
                            hashMap2.put(str3, a.a(xVar.f()));
                            hashMap2.put(str2, a.a(xVar.a()));
                            hashMap2.put("pathFile", a.a(file2.getName()));
                            str = str3;
                            if (!this.f269a.getSharedPreferences("user", 0).getBoolean("sizeCallsLimitWIFI", false)) {
                                pVar = pVar3;
                                File file3 = file2;
                                if (c.l(this.f269a)) {
                                    a(hashMap2, pVar, xVar, file3);
                                } else if (c.a(file3, this.f269a)) {
                                    a(hashMap2, pVar, xVar, file3);
                                }
                            } else if (c.l(this.f269a)) {
                                pVar = pVar3;
                                a(hashMap2, pVar, xVar, file2);
                            } else {
                                pVar = pVar3;
                            }
                        } else {
                            str = str3;
                            pVar = pVar3;
                            a(hashMap, pVar, xVar);
                        }
                    }
                    if (!cursor.moveToNext()) {
                        break;
                    }
                    pVar2 = pVar;
                    c2 = cursor;
                    str3 = str;
                    i = 0;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            pVar.a();
        } catch (Throwable th) {
            th.getStackTrace();
            try {
                th.getStackTrace();
                Crashlytics.logException(th);
            } catch (Exception unused) {
            }
        }
        f268b = false;
        a();
    }

    private void a(HashMap<String, RequestBody> hashMap, C0084p pVar, C0091x xVar, File file) {
        try {
            if (a.c.e.a.a("calls/insertCallRecord.php", hashMap, Part.createFormData("uploadedfile", file.getName(), RequestBody.create(MediaType.parse(ShareTarget.ENCODING_TYPE_MULTIPART), file))) && pVar.a(xVar.e())) {
                file.delete();
            }
        } catch (Throwable th) {
            th.getStackTrace();
            try {
                th.getStackTrace();
                Crashlytics.logException(th);
            } catch (Exception unused) {
            }
        }
    }

    private void a(HashMap<String, String> hashMap, C0084p pVar, C0091x xVar) {
        try {
            if (a.c.e.a.b("calls/insertCall.php", (Map<String, String>) hashMap)) {
                pVar.a(xVar.e());
            }
        } catch (Exception e2) {
            e2.getStackTrace();
        }
    }
}
