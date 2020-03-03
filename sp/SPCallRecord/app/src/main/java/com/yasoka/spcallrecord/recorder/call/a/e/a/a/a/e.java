package com.yasoka.spcallrecord.recorder.call.a.e.a.a.a;

import a.b.a.a.a;
import android.media.AudioRecord;
import com.crashlytics.android.Crashlytics;
import com.recorder.call.encoder.AMREncoder;
import com.recorder.call.encoder.AMREncoder.Mode;
import com.recorder.call.encoder.LameEncoder;
import com.recorder.call.encoder.WavEncoder;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/* compiled from: StandardRecorder */
class e implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ f f565a;

    e(f fVar) {
        this.f565a = fVar;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:152|153|156) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:43|44|(3:45|46|(1:48))|54|55|(0)(0)) */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:166|167|168|169|170|171|172) */
    /* JADX WARNING: Code restructure failed: missing block: B:112:?, code lost:
        r12.f565a.f568c.f();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:?, code lost:
        r12.f565a.f568c.f();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x03b1, code lost:
        if (r6 != -3) goto L_0x03b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x03b3, code lost:
        r0 = "ERROR_INVALID_OPERATION";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:?, code lost:
        r12.f565a.f568c.f();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x03bf, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:?, code lost:
        r1.getMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:?, code lost:
        r12.f565a.f568c.f();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x03e7, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x03e8, code lost:
        r0.getStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x03eb, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:?, code lost:
        r12.f565a.f568c.f();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x03f6, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x03f7, code lost:
        r0.getStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x03fa, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x0405, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x0418, code lost:
        r0.getStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x041c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:?, code lost:
        r12.f565a.f568c.f();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x0427, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x0428, code lost:
        r1.getStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x042b, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x01a8, code lost:
        if (r4 != 1) goto L_0x01aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x01aa, code lost:
        if (r4 == 3) goto L_0x01ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x01ac, code lost:
        r12.f565a.h = new com.recorder.call.encoder.LameEncoder();
        r12.f565a.h.setBitRate(128);
        r12.f565a.h.setQuality(5);
        r12.f565a.h.init();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x01d8, code lost:
        throw new java.lang.Exception(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x01e3, code lost:
        if (r12.f565a.f570e.d() != 10) goto L_0x01e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x01e5, code lost:
        r12.f565a.h = new com.recorder.call.encoder.WavEncoder(r12.f565a.g, r12.f565a.f570e.b());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0200, code lost:
        r12.f565a.h = new com.recorder.call.encoder.WavEncoder(r12.f565a.g, r12.f565a.f570e.c());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x021a, code lost:
        r12.f565a.h.init();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0224, code lost:
        r12.f565a.h = new com.recorder.call.encoder.AMREncoder(r12.f565a.g);
        r12.f565a.h.setProfile(com.recorder.call.encoder.AMREncoder.Mode.MR122.ordinal());
        r12.f565a.h.init();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:162:0x03fb, B:167:0x0408] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:152:0x03dd */
    /* JADX WARNING: Missing exception handler attribute for start block: B:157:0x03ec */
    /* JADX WARNING: Missing exception handler attribute for start block: B:171:0x0411 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:54:0x0198 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:86:0x02a2 */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01a8 A[Catch:{ Exception -> 0x016d, Exception -> 0x024d }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0224 A[Catch:{ Exception -> 0x016d, Exception -> 0x024d }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x02aa A[Catch:{ Exception -> 0x030d, all -> 0x0407 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:171:0x0411=Splitter:B:171:0x0411, B:162:0x03fb=Splitter:B:162:0x03fb} */
    public void run() {
        a g;
        String str;
        String str2;
        String str3 = "Unknown media format";
        String str4 = "StandardRecorder : ";
        if (!this.f565a.c()) {
            StringBuilder a2 = a.a("StandardRecorder-init : ");
            a2.append(this.f565a.f569d);
            a2.toString();
            return;
        }
        if (this.f565a.f570e.d() != 10) {
            if (this.f565a.i > 0) {
                try {
                    Thread.sleep((long) this.f565a.i);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            f fVar = this.f565a;
            fVar.f = fVar.f570e.b();
        } else {
            f fVar2 = this.f565a;
            fVar2.f = fVar2.f570e.c();
        }
        StringBuilder a3 = a.a("--- recordFile ---");
        a3.append(this.f565a.f.getAbsolutePath());
        a3.toString();
        try {
            this.f565a.g = new FileOutputStream(this.f565a.f);
            if (this.f565a.h != null) {
                try {
                    this.f565a.h.close();
                    this.f565a.h = null;
                } catch (Exception e3) {
                    e3.getStackTrace();
                    try {
                        e3.getStackTrace();
                        Crashlytics.logException(e3);
                    } catch (Exception unused) {
                    }
                }
            }
            if (this.f565a.h == null) {
                try {
                    int ordinal = this.f565a.f570e.a().ordinal();
                    if (ordinal == 0) {
                        this.f565a.h = new AMREncoder(this.f565a.g);
                        this.f565a.h.setProfile(Mode.MR122.ordinal());
                        this.f565a.h.init();
                    } else if (ordinal == 1) {
                        if (this.f565a.f570e.d() != 10) {
                            this.f565a.h = new WavEncoder(this.f565a.g, this.f565a.f570e.b());
                        } else {
                            this.f565a.h = new WavEncoder(this.f565a.g, this.f565a.f570e.c());
                        }
                        this.f565a.h.init();
                    } else if (ordinal == 3) {
                        this.f565a.h = new LameEncoder();
                        this.f565a.h.setBitRate(128);
                        this.f565a.h.setQuality(5);
                        this.f565a.h.init();
                    } else {
                        throw new Exception(str3);
                    }
                } catch (Exception e4) {
                    this.f565a.f569d = e4.getMessage();
                    try {
                        if (this.f565a.h != null) {
                            this.f565a.h.close();
                            this.f565a.h = null;
                        }
                    } catch (Exception e5) {
                        e4.getStackTrace();
                        e5.getStackTrace();
                        Crashlytics.logException(e5);
                    }
                    int ordinal2 = this.f565a.f570e.a().ordinal();
                    if (ordinal2 == 0) {
                    }
                } catch (Exception e6) {
                    e6.getStackTrace();
                    try {
                        e6.getStackTrace();
                        Crashlytics.logException(e6);
                    } catch (Exception unused2) {
                    }
                    return;
                }
            }
            try {
                if (this.f565a.f568c != null) {
                    this.f565a.f568c.e();
                } else {
                    this.f565a.c();
                    this.f565a.f568c.e();
                }
            } catch (Exception e7) {
                try {
                    this.f565a.f569d = e7.getMessage();
                    StringBuilder sb = new StringBuilder();
                    sb.append(str4);
                    sb.append(this.f565a.f569d);
                    sb.toString();
                    e7.getStackTrace();
                    Crashlytics.logException(e7);
                } catch (Exception e8) {
                    e8.getStackTrace();
                }
            }
            try {
                if (this.f565a.f568c != null) {
                    AudioRecord c2 = this.f565a.f568c.c();
                    boolean z = false;
                    int i = 0;
                    while (true) {
                        if (!z && this.f565a.f568c != null && c2 != null) {
                            if (this.f565a.f568c == null || this.f565a.f568c.d()) {
                                if (this.f565a.f570e.d() != 10 && this.f565a.f566a.getCallState() == 0) {
                                    z = true;
                                }
                                if (z) {
                                    break;
                                }
                                int b2 = this.f565a.f568c.b();
                                byte[] bArr = new byte[b2];
                                int read = c2.read(bArr, 0, b2);
                                str = "StandardRecorder-lastError : ";
                                if (i < 2) {
                                    i++;
                                    if (i == 1 && read == 0) {
                                        try {
                                            break;
                                        } catch (Exception e9) {
                                            e9.getMessage();
                                        }
                                    } else {
                                        StringBuilder sb2 = new StringBuilder();
                                        sb2.append("Skipping buffer (");
                                        sb2.append(i);
                                        sb2.append("): Read = ");
                                        sb2.append(read);
                                        sb2.toString();
                                    }
                                } else if (read == -2 || read == -3) {
                                    str2 = "ERROR_BAD_VALUE";
                                } else {
                                    try {
                                        f.a(this.f565a, bArr, read);
                                    } catch (Exception e10) {
                                        this.f565a.f569d = e10.getMessage();
                                        StringBuilder sb3 = new StringBuilder();
                                        sb3.append("StandardRecorder-lastErroraa : ");
                                        sb3.append(this.f565a.f569d);
                                        sb3.toString();
                                    }
                                }
                            } else {
                                try {
                                    this.f565a.f568c.f();
                                } catch (Throwable th) {
                                    th.getStackTrace();
                                }
                                return;
                            }
                        }
                    }
                    g.f();
                    return;
                }
                g = this.f565a.f568c;
                break;
            } catch (Exception e11) {
                e11.getStackTrace();
            } catch (Throwable th2) {
                th2.getStackTrace();
                th2.getStackTrace();
                Crashlytics.logException(th2);
                g = this.f565a.f568c;
            }
            g.f();
            return;
        } catch (FileNotFoundException e12) {
            this.f565a.f569d = e12.getMessage();
            StringBuilder a4 = a.a(str4);
            a4.append(this.f565a.f569d);
            a4.toString();
            return;
        }
        this.f565a.f569d = str2;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(str);
        sb4.append(this.f565a.f569d);
        sb4.toString();
        g = this.f565a.f568c;
        g.f();
        return;
        this.f565a.f569d = "PreRead(1) was 0 bytes";
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        sb5.append(this.f565a.f569d);
        sb5.toString();
        g = this.f565a.f568c;
        g.f();
        return;
        try {
            this.f565a.f568c.f();
        } catch (Throwable th3) {
            th3.getStackTrace();
        }
    }
}
