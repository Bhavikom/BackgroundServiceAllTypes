package com.yasoka.spcallrecord.recorder.call.a.e.a.a.a;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.AudioRecord;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.IBinder;
import com.crashlytics.android.Crashlytics;
import com.recorder.call.services.INService;
import com.recorder.call.services.INService.Stub;
import com.recorder.call.services.NService;

/* compiled from: AudioRecorder */
public class a {
    private static int[] n = {8000};

    /* renamed from: a reason: collision with root package name */
    private AudioRecord f551a;

    /* renamed from: b reason: collision with root package name */
    private int f552b;

    /* renamed from: c reason: collision with root package name */
    private int f553c;

    /* renamed from: d reason: collision with root package name */
    private int f554d;

    /* renamed from: e reason: collision with root package name */
    private int f555e;
    private int f;
    private int g;
    private Context h;
    /* access modifiers changed from: private */
    public final Object i = new Object();
    private boolean j;
    private boolean k;
    /* access modifiers changed from: private */
    public INService l;
    private ServiceConnection m = new C0010a();

    /* renamed from: a.e.a.a.a.a$a reason: collision with other inner class name */
    /* compiled from: AudioRecorder */
    class C0010a implements ServiceConnection {
        C0010a() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            a.this.l = Stub.asInterface(iBinder);
            if (a.this.l != null) {
                try {
                    a.this.l.x(0, 0);
                } catch (Exception e2) {
                    e2.getMessage();
                }
            }
            synchronized (a.this.i) {
                a.this.i.notifyAll();
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            a.this.l = null;
        }
    }

    /* compiled from: AudioRecorder */
    class b implements Runnable {

        /* renamed from: a reason: collision with root package name */
        final /* synthetic */ Object f557a;

        b(Object obj) {
            this.f557a = obj;
        }

        public void run() {
            try {
                synchronized (this.f557a) {
                    this.f557a.notify();
                }
                a.this.l.x(5, 0);
            } catch (Exception e2) {
                e2.getStackTrace();
                try {
                    e2.getStackTrace();
                    Crashlytics.logException(e2);
                } catch (Exception unused) {
                }
            }
        }
    }

    public a(int i2, Context context) {
        if (i2 == 6 || i2 == 8 || i2 == 10) {
            i2 = 1;
        }
        this.g = -1;
        this.f553c = i2;
        this.j = false;
        this.h = context;
    }

    private void g() throws Exception {
        try {
            this.f551a = j();
            if (this.f551a != null) {
                this.j = true;
                return;
            }
            throw new Exception("Cannot initialize the AudioRecord object.");
        } catch (Exception e2) {
            throw new Exception(e2.getMessage());
        }
    }

    @TargetApi(16)
    private void h() throws Exception {
        if (this.l != null) {
            int audioSessionId = this.f551a.getAudioSessionId();
            StringBuilder sb = new StringBuilder();
            sb.append("Got session: ");
            sb.append(audioSessionId);
            sb.toString();
            this.l.x(2, audioSessionId);
            Thread.sleep(2000);
            this.l.x(1, 0);
            this.f551a.startRecording();
            int i2 = this.f552b;
            this.f551a.read(new byte[i2], 0, i2);
            return;
        }
        a(this.g);
        h();
    }

    @TargetApi(16)
    private void i() throws Exception {
        if (this.l != null) {
            if (l() && VERSION.SDK_INT < 26) {
                Thread.sleep(300);
                int audioSessionId = this.f551a.getAudioSessionId();
                StringBuilder sb = new StringBuilder();
                sb.append("Got session: ");
                sb.append(audioSessionId);
                sb.toString();
                this.l.x(2, audioSessionId);
                Thread.sleep(3000);
            }
            Object obj = new Object();
            Thread thread = new Thread(new b(obj));
            synchronized (obj) {
                thread.start();
                obj.wait(3000);
                Thread.sleep(33);
                this.f551a.startRecording();
            }
            int i2 = this.f552b;
            this.f551a.read(new byte[i2], 0, i2);
            return;
        }
        a(this.g);
        i();
    }

    private AudioRecord j() throws Exception {
        String str = "=";
        String str2 = str;
        for (int i2 : n) {
            this.f = i2;
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(this.f));
            sb.append("hz");
            StringBuilder a2 = b.a.a.a.a(str2, "> Testing sampleRateInHz: ", sb.toString(), ", audioFormat: ", "ENCODING_PCM_16BIT");
            a2.append(", channelConfig: ");
            a2.append("CHANNEL_IN_MONO");
            a2.toString();
            this.f552b = AudioRecord.getMinBufferSize(this.f, this.f554d, this.f555e);
            StringBuilder a3 = b.a.a.a.a("audioMinBufferSize = ");
            a3.append(this.f552b);
            a3.toString();
            boolean z = this.f552b < 0;
            if (!z) {
                int i3 = (this.f * 100) / 1000;
                int i4 = this.f554d == 16 ? 1 : 2;
                int i5 = (((i3 * 2) * i4) * 16) / 8;
                int i6 = this.f552b;
                if (i5 < i6) {
                    int i7 = i6 / ((i4 * 32) / 8);
                    this.f552b = i6;
                    StringBuilder a4 = b.a.a.a.a("Increasing buffer size to ");
                    a4.append(Integer.toString(i6));
                    a4.toString();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Period size set to: ");
                    sb2.append(Integer.toString(i7));
                    sb2.toString();
                } else {
                    this.f552b = i5;
                }
                if (a.e.a.a.b.a.b(a.c.e.a.a(this.h)) == a.e.a.a.b.a.AMR) {
                    int i8 = this.f552b;
                    if (i8 % 320 != 0) {
                        this.f552b += Math.abs((i8 % 320) - 320);
                        StringBuilder a5 = b.a.a.a.a("Setting buffer size to modulus of AMR_FRAMES_SIZE = ");
                        a5.append(this.f552b);
                        a5.toString();
                    }
                }
            }
            if (z) {
                String str3 = this.f552b == -1 ? "ERROR (Unable to query hardware)" : "ERROR_BAD_VALUE (Parameters not supported by hardware)";
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str2);
                sb3.append("> Get buffer size returned: ");
                sb3.append(str3);
                sb3.toString();
                StringBuilder sb4 = new StringBuilder();
                sb4.append(str2);
                sb4.append(str);
                str2 = sb4.toString();
            } else {
                try {
                    AudioRecord audioRecord = new AudioRecord(this.f553c, this.f, this.f554d, this.f555e, this.f552b);
                    this.f551a = audioRecord;
                    if (this.f551a.getState() == 1) {
                        return this.f551a;
                    }
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(str2);
                    sb5.append("> Failed to initialise AudioRecord with these settings...");
                    sb5.toString();
                    this.f551a.release();
                    this.f551a = null;
                    str2 = b.a.a.a.c(str2, str);
                } catch (Exception e2) {
                    try {
                        if (this.f551a != null) {
                            this.f551a.release();
                            this.f551a = null;
                        }
                    } catch (Exception unused) {
                    }
                    throw new Exception(e2.getMessage());
                }
            }
        }
        return null;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001e */
    private void k() {
        this.h.bindService(new Intent(this.h, NService.class), this.m, 1);
        synchronized (this.i) {
            this.i.wait(5000);
        }
        StringBuilder a2 = b.a.a.a.a("KmService instance = ");
        a2.append(this.l);
        a2.toString();
    }

    public static boolean l() {
        return Build.MANUFACTURER.toLowerCase().contains("huawei");
    }

    public static boolean m() {
        return Build.MODEL.toLowerCase().contains("sm-g960f") || Build.MODEL.toLowerCase().contains("sm-g965f") || Build.MODEL.toLowerCase().contains("sm-g960n") || Build.MODEL.toLowerCase().contains("sm-g965n");
    }

    public AudioRecord c() {
        return this.f551a;
    }

    public boolean d() {
        return this.k;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0030, code lost:
        if (r0 != false) goto L_0x0032;
     */
    public void e() throws Exception {
        boolean z = true;
        this.k = true;
        try {
            if (this.g <= -1 || this.l == null) {
                this.f551a.startRecording();
                int i2 = this.f552b;
                this.f551a.read(new byte[i2], 0, i2);
                return;
            }
            int i3 = VERSION.SDK_INT;
            if (!l()) {
                if (this.g != 2) {
                    if (VERSION.SDK_INT > 25 || !Build.MODEL.toLowerCase().contains("sm-n950")) {
                        z = false;
                    }
                }
                h();
                return;
            }
            i();
        } catch (Exception e2) {
            this.k = false;
            throw new Exception(e2.getMessage());
        }
    }

    public void f() throws Exception {
        this.k = false;
        AudioRecord audioRecord = this.f551a;
        if (audioRecord != null) {
            try {
                audioRecord.stop();
                this.f551a.release();
                this.f551a = null;
            } catch (Exception e2) {
                throw new Exception(e2.getMessage());
            }
        }
    }

    public int b() {
        return this.f552b;
    }

    public void a(int i2) throws Exception {
        this.g = i2;
        this.f554d = 16;
        this.f555e = 2;
        if (m()) {
            if (this.g > -1) {
                this.f553c = 4;
            } else if (this.f553c == 4) {
                this.g = 1;
            }
        }
        if (this.g <= -1) {
            g();
        } else {
            k();
            Thread.sleep(500);
            g();
        }
        if (m() && this.f553c == 4) {
            this.g = -1;
        }
    }

    public void a() {
        if (this.j) {
            AudioRecord audioRecord = this.f551a;
            if (audioRecord != null) {
                try {
                    audioRecord.release();
                    this.f551a = null;
                } catch (Exception e2) {
                    e2.getMessage();
                }
            }
        }
        if (this.l != null) {
            this.h.unbindService(this.m);
            this.l = null;
        }
    }
}
