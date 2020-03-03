package com.yasoka.spcallrecord.recorder.call.a.e.a.a.a;

import a.b.a.a.a;
import android.content.Context;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.crashlytics.android.Crashlytics;
import com.recorder.call.encoder.AudioEncoderBase;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* compiled from: StandardRecorder */
public class f implements d {
    /* access modifiers changed from: private */

    /* renamed from: a reason: collision with root package name */
    public final TelephonyManager f566a;

    /* renamed from: b reason: collision with root package name */
    private Context f567b;
    /* access modifiers changed from: private */

    /* renamed from: c reason: collision with root package name */
    public a f568c;
    /* access modifiers changed from: private */

    /* renamed from: d reason: collision with root package name */
    public String f569d = "Unknown error";
    /* access modifiers changed from: private */

    /* renamed from: e reason: collision with root package name */
    public c f570e;
    /* access modifiers changed from: private */
    public File f;
    /* access modifiers changed from: private */
    public FileOutputStream g;
    /* access modifiers changed from: private */
    public AudioEncoderBase h;
    /* access modifiers changed from: private */
    public int i;

    public f(Context context) {
        this.f566a = (TelephonyManager) context.getSystemService("phone");
        this.f567b = context;
        this.g = null;
        this.f568c = null;
        this.f = null;
        this.i = 0;
    }

    public void b() {
        new Thread(new e(this)).start();
    }

    public boolean c() {
        int i2;
        try {
            this.f568c = new a(this.f570e.d(), this.f567b);
            StringBuilder sb = new StringBuilder();
            sb.append("recordItem.getSource()");
            sb.append(this.f570e.d());
            sb.toString();
            if (this.f570e.d() == 6 || this.f570e.d() == 8) {
                int i3 = VERSION.SDK_INT;
                int d2 = this.f570e.d();
                if (d2 == 6) {
                    i2 = 1;
                } else if (d2 == 8) {
                    i2 = 2;
                }
                this.f568c.a(i2);
                return true;
            }
            i2 = -1;
            this.f568c.a(i2);
            return true;
        } catch (Exception e2) {
            this.f569d = e2.getMessage();
            try {
                e2.getStackTrace();
                Crashlytics.logException(e2);
            } catch (Exception unused) {
            }
            return false;
        }
    }

    static /* synthetic */ void a(f fVar, byte[] bArr, int i2) throws Exception {
        if (!(fVar.h == null || fVar.g == null)) {
            byte[] bArr2 = new byte[i2];
            if (bArr.length > i2) {
                StringBuilder a2 = a.a("Warn: pcm buffer size = ");
                a2.append(bArr.length);
                a2.append(", actual read pcm = ");
                a2.append(i2);
                a2.toString();
            }
            int encode = fVar.h.encode(bArr, bArr2);
            if (encode > 0) {
                fVar.g.write(bArr2, 0, encode);
            }
        }
        if (fVar.h == null) {
            StringBuilder a3 = a.a("Unknown encoder format: ");
            a3.append(fVar.f570e.a());
            throw new Exception(a3.toString());
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x00b2 */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b6 A[Catch:{ Exception -> 0x00be }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
    public void a() {
        AudioEncoderBase audioEncoderBase;
        a aVar = this.f568c;
        if (aVar != null && aVar.d()) {
            try {
                this.f568c.f();
            } catch (Exception e2) {
                e2.getMessage();
                try {
                    e2.getStackTrace();
                    Crashlytics.logException(e2);
                } catch (Exception unused) {
                }
            }
        }
        StringBuilder a2 = a.a("Finalizing encoding, fileOutputStream = ");
        a2.append(this.g);
        a2.toString();
        try {
            if (!(this.h == null || this.g == null || !this.h.canFlush())) {
                byte[] bArr = new byte[8192];
                int flush = this.h.flush(bArr);
                if (flush > 0) {
                    this.g.write(bArr, 0, flush);
                }
                try {
                    if (this.h.hasSpecialHeader()) {
                        byte[] bArr2 = new byte[1024];
                        int specialHeader = this.h.getSpecialHeader(bArr2);
                        if (specialHeader != -1) {
                            this.g.flush();
                            int specialAudioStartPos = this.h.getSpecialAudioStartPos();
                            FileChannel channel = this.g.getChannel();
                            channel.position((long) specialAudioStartPos);
                            channel.write(ByteBuffer.wrap(bArr2, 0, specialHeader));
                        }
                    }
                } catch (Exception e3) {
                    e3.getStackTrace();
                }
            }
            try {
                if (this.h != null) {
                    audioEncoderBase = this.h;
                    audioEncoderBase.close();
                    this.h = null;
                }
            } catch (Exception e4) {
                e4.getStackTrace();
            }
        } catch (Exception e5) {
            e5.getMessage();
            if (this.h != null) {
                audioEncoderBase = this.h;
            }
        } catch (Throwable th) {
            try {
                if (this.h != null) {
                    this.h.close();
                    this.h = null;
                }
            } catch (Exception e6) {
                e6.getStackTrace();
            }
            throw th;
        }
        FileOutputStream fileOutputStream = this.g;
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException e7) {
                e7.getMessage();
                e7.getStackTrace();
                Crashlytics.logException(e7);
            }
        }
        try {
            if (this.f568c == null) {
                this.f568c.a();
                this.f568c = null;
            }
        } catch (Exception e8) {
            e8.getMessage();
            try {
                e8.getStackTrace();
                Crashlytics.logException(e8);
            } catch (Exception unused2) {
            }
        }
    }

    public void a(int i2) {
        this.i = i2;
    }

    public void a(a.e.a.a.b.a aVar, int i2, String str) {
        if (this.f570e == null) {
            this.f570e = new c();
        }
        this.f570e.a(aVar);
        this.f570e.a(i2);
        this.f570e.a(str);
    }
}
