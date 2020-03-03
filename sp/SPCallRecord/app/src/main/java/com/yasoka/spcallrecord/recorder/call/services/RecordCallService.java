package com.yasoka.spcallrecord.recorder.call.services;

/*import a.c.e.e;
import a.e.a.a.a.f;*/
import android.annotation.SuppressLint;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences.Editor;
import android.media.AudioManager;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Process;
import android.telephony.TelephonyManager;
import androidx.core.app.NotificationManagerCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
//import androidx.localbroadcastmanager.content.LocalBroadcastManager;
//import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.Crashlytics;
import com.yasoka.spcallrecord.recorder.call.a.c.e.e;
import com.yasoka.spcallrecord.recorder.call.a.e.a.a.a.f;

import org.webrtc.MediaStreamTrack;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//import org.webrtc.MediaStreamTrack;

public class RecordCallService extends Service {
    public static boolean q;

    /* renamed from: a reason: collision with root package name */
    private boolean f1192a;
    /* access modifiers changed from: private */

    /* renamed from: b reason: collision with root package name */
    public MediaRecorder f1193b = null;

    /* renamed from: c reason: collision with root package name */
    private AudioManager f1194c = null;
    /* access modifiers changed from: private */

    /* renamed from: d reason: collision with root package name */
    public int f1195d = 60000;
    /* access modifiers changed from: private */

    /* renamed from: e reason: collision with root package name */
    public Handler f1196e;
    private int f = 40000;
    private int g = 35000;
    private int h = 1000;
    private boolean i;
    private ExecutorService j;
    private String k;
    private String l;
    /* access modifiers changed from: private */
    public com.yasoka.spcallrecord.recorder.call.a.e.a.a.a.f m;
    /* access modifiers changed from: private */
    public BroadcastReceiver n;
    private WakeLock o;
    /* access modifiers changed from: private */
    public Runnable p;

    class a implements Runnable {
        a() {
        }

        public void run() {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) RecordCallService.this.getSystemService(Context.TELEPHONY_SERVICE);
                if (telephonyManager == null || telephonyManager.getCallState() != 0) {
                    RecordCallService.this.f1196e.postDelayed(this, (long) RecordCallService.this.f1195d);
                } else {
                    RecordCallService.this.stopSelf();
                }
            } catch (Throwable th) {
                th.getStackTrace();
            }
        }
    }

    class b extends BroadcastReceiver {
        b() {
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(5:(2:23|24)|(2:28|29)|(2:35|36)|42|43) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0089 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:42:0x009d */
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                try {
                    if (intent.getAction() != null && intent.getAction().equals("telephony_status_action_stop_record")) {
                        try {
                            LocalBroadcastManager.getInstance(RecordCallService.this.getApplicationContext()).unregisterReceiver(RecordCallService.this.n);
                        } catch (Exception e2) {
                            e2.getStackTrace();
                        }
                        try {
                            if (RecordCallService.this.f1196e != null) {
                                RecordCallService.this.f1196e.removeCallbacks(RecordCallService.this.p);
                            }
                        } catch (Exception e3) {
                            e3.getStackTrace();
                        }
                        if (RecordCallService.this.m != null) {
                            RecordCallService.this.m.a();
                            RecordCallService.this.m = null;
                        }
                        if (RecordCallService.this.f1193b != null) {
                            try {
                                RecordCallService.this.f1193b.stop();
                            } catch (Exception e4) {
                                e4.getStackTrace();
                            }
                            try {
                                RecordCallService.this.f1193b.reset();
                            } catch (Exception e5) {
                                e5.getStackTrace();
                                e5.getStackTrace();
                                Crashlytics.logException(e5);
                            }
                            try {
                                RecordCallService.this.f1193b.release();
                            } catch (Exception e6) {
                                e6.getStackTrace();
                                e6.getStackTrace();
                                Crashlytics.logException(e6);
                            }
                            RecordCallService.this.f1193b = null;
                        }
                        RecordCallService.this.stopSelf();
                    }
                } catch (Exception e7) {
                    try {
                        RecordCallService.this.stopSelf();
                    } catch (Exception e8) {
                        e8.getStackTrace();
                        try {
                            e8.getStackTrace();
                            Crashlytics.logException(e8);
                        } catch (Exception unused) {
                        }
                    }
                    e7.getStackTrace();
                    try {
                        e7.getStackTrace();
                        Crashlytics.logException(e7);
                    } catch (Exception unused2) {
                    }
                }
            }
        }
    }

    class c implements Runnable {
        c() {
        }

        public void run() {
            RecordCallService.this.c();
        }
    }

    public RecordCallService() {
        String str = "";
        this.k = str;
        this.l = str;
        this.p = new a();
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:0|(5:1|2|(1:6)|7|(4:9|10|11|(1:13)))|21|22|(1:24)|25|32) */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a0, code lost:
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
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0066 */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0081 A[Catch:{ all -> 0x00a0 }] */
    @SuppressLint({"InvalidWakeLockTag"})
    public void onCreate() {
        super.onCreate();
        String str = "onCreate : ";
        StringBuilder a2 = a.b.a.a.a.a(str);
        a2.append(q);
        a2.toString();
        q = true;
        StringBuilder a3 = a.b.a.a.a.a(str);
        a3.append(q);
        a3.toString();
        try {
            if (VERSION.SDK_INT >= 26 || !NotificationManagerCompat.from(this).areNotificationsEnabled()) {
                startForeground(16050, a.c.j.c.a((Context) this));
            }
            if (VERSION.SDK_INT < 26) {
                try {
                    PowerManager powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
                    if (powerManager != null) {
                        this.o = powerManager.newWakeLock(1, "MyWakeLockRecordCall");
                        this.o.acquire(10000);
                    }
                } catch (Exception e2) {
                    e2.getStackTrace();
                }
            }
        } catch (Exception e3) {
            e3.getStackTrace();
            e3.getStackTrace();
            Crashlytics.logException(e3);
        }
        this.j = Executors.newSingleThreadExecutor();
        this.f1196e = new Handler();
        this.f1196e.postDelayed(this.p, (long) this.f1195d);
        if (this.n == null) {
            this.n = new b();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("telephony_status_action_stop_record");
        LocalBroadcastManager.getInstance(getApplicationContext()).registerReceiver(this.n, intentFilter);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(18:0|(3:1|2|(1:4))|(2:10|11)|(3:15|16|(1:18))|24|(3:26|27|(5:29|(1:31)|32|(1:34)|35))|42|43|(1:45)|51|52|(8:54|55|61|62|68|69|75|76)|82|83|(1:87)|(3:91|92|(1:94))|101|103) */
    /* JADX WARNING: Can't wrap try/catch for region: R(23:0|(3:1|2|(1:4))|10|11|15|16|(1:18)|24|(3:26|27|(5:29|(1:31)|32|(1:34)|35))|42|43|(1:45)|51|52|(8:54|55|61|62|68|69|75|76)|82|83|(1:87)|91|92|(1:94)|101|103) */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0091, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        r0.getStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        r0.getStackTrace();
        com.crashlytics.android.Crashlytics.logException(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x00d2, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:?, code lost:
        r0.getStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:?, code lost:
        r0.getStackTrace();
        com.crashlytics.android.Crashlytics.logException(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x00f0, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:?, code lost:
        r0.getStackTrace();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0019 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:42:0x0085 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x009b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:61:0x00af */
    /* JADX WARNING: Missing exception handler attribute for start block: B:68:0x00bf */
    /* JADX WARNING: Missing exception handler attribute for start block: B:75:0x00cf */
    /* JADX WARNING: Missing exception handler attribute for start block: B:82:0x00dc */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0031 A[Catch:{ Exception -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0044 A[Catch:{ Exception -> 0x007b }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0089 A[Catch:{ Exception -> 0x0091 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x009f A[SYNTHETIC, Splitter:B:54:0x009f] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x00f8 A[Catch:{ Exception -> 0x00fe }] */
    public void onDestroy() {
        String str = "user";
        try {
            if (this.f1196e != null) {
                this.f1196e.removeCallbacks(this.p);
            }
        } catch (Exception e2) {
            e2.getStackTrace();
            e2.getStackTrace();
            Crashlytics.logException(e2);
        } catch (Throwable th) {
            th.getStackTrace();
            try {
                th.getStackTrace();
                Crashlytics.logException(th);
            } catch (Exception unused) {
            }
        }
        try {
            LocalBroadcastManager.getInstance(getApplicationContext()).unregisterReceiver(this.n);
        } catch (Exception e3) {
            e3.getStackTrace();
        }
        try {
            if (d()) {
                b();
            }
        } catch (Exception e4) {
            e4.getStackTrace();
            try {
                e4.getStackTrace();
                Crashlytics.logException(e4);
            } catch (Exception unused2) {
            }
        }
        try {
            if (this.f1194c != null) {
                if (getSharedPreferences(str, 0).getInt("modeRecordCalls", 0) == 1) {
                    this.f1194c.setSpeakerphoneOn(false);
                }
                if (getSharedPreferences(str, 0).getInt("increaseSoundRecordCalls", 1) == 1) {
                    this.f1194c.setStreamVolume(0, getApplicationContext().getSharedPreferences(str, 0).getInt("deviceCallVol", 0), 0);
                }
                this.f1194c = null;
            }
        } catch (Exception e5) {
            e5.getStackTrace();
            e5.getStackTrace();
            Crashlytics.logException(e5);
        }
        if (this.m != null) {
            this.m.a();
            this.m = null;
        }
        if (this.f1193b != null) {
            try {
                this.f1193b.stop();
            } catch (Exception e6) {
                e6.getStackTrace();
                e6.getStackTrace();
                Crashlytics.logException(e6);
            }
            try {
                this.f1193b.reset();
            } catch (Exception e7) {
                e7.getStackTrace();
                e7.getStackTrace();
                Crashlytics.logException(e7);
            }
            try {
                this.f1193b.release();
            } catch (Exception e8) {
                e8.getStackTrace();
                e8.getStackTrace();
                Crashlytics.logException(e8);
            }
            this.f1193b = null;
        }
        if (this.o != null && this.o.isHeld()) {
            this.o.release();
            this.o = null;
        }
        try {
            if (this.j != null) {
                this.j.shutdown();
            }
        } catch (Exception e9) {
            e9.getStackTrace();
        }
        q = false;
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        StringBuilder a2 = a.b.a.a.a.a("onStartCommand : ");
        a2.append(this.f1192a);
        a2.toString();
        if (!this.f1192a) {
            this.f1192a = true;
            if (!(intent == null || intent.getExtras() == null)) {
                this.i = intent.getExtras().getBoolean("outgoing");
                this.k = intent.getExtras().getString("callType");
                this.l = intent.getExtras().getString("callNumber");
            }
            this.j.execute(new c());
        }
        return 2;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(21:0|1|2|3|4|5|6|(1:(3:13|9|8))(1:(2:18|14))|(3:26|27|(1:29)(2:30|122))|31|(2:32|33)|37|38|(2:40|(4:44|45|46|51))|(3:59|60|(2:62|(2:64|65)))|74|75|(1:77)|78|79|(6:99|(1:101)(1:(1:103)(1:104))|105|(1:107)|108|123)(2:83|(7:85|86|87|96|97|98|121)(1:120))) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x0102 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:74:0x0153 */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0272 A[Catch:{ Exception -> 0x0095, all -> 0x02a6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0274 A[Catch:{ Exception -> 0x0095, all -> 0x02a6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0280 A[Catch:{ Exception -> 0x0095, all -> 0x02a6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x010e A[Catch:{ Exception -> 0x0149 }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0157 A[Catch:{ Exception -> 0x0095, all -> 0x02a6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x016a A[ADDED_TO_REGION] */
    @SuppressLint("WrongConstant")
    public void c() {
        String str;
        String str2 = "typeConfigRecordCalls";
        String str3 = "user";
        String str4 = MediaStreamTrack.AUDIO_TRACK_KIND;
        StringBuilder sb = new StringBuilder();
        sb.append("getFormatAudioRecordCalls : ");
        sb.append(a.c.e.a.a((Context) this));
        sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getTypeConfigRecordCalls : ");
        sb2.append(getSharedPreferences(str3, 0).getInt(str2, 1));
        sb2.toString();
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        try {
            String str5 = "STATE : ";
            if (this.i) {
                while (telephonyManager.getCallState() != 2 && this.g > this.h) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(str5);
                    sb3.append(telephonyManager.getCallState());
                    sb3.toString();
                    Thread.sleep(150);
                    this.h += 150;
                }
            } else {
                while (telephonyManager.getCallState() != 2 && this.f > this.h) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(str5);
                    sb4.append(telephonyManager.getCallState());
                    sb4.toString();
                    Thread.sleep(150);
                    this.h += 150;
                }
            }
        } catch (Exception e2) {
            e2.getStackTrace();
            try {
                e2.getStackTrace();
                Crashlytics.logException(e2);
            } catch (Exception unused) {
            }
        } catch (Throwable th) {
            th.getStackTrace();
            try {
                th.getStackTrace();
                Crashlytics.logException(th);
                return;
            } catch (Exception unused2) {
                return;
            }
        }
        if (telephonyManager != null) {
            if (telephonyManager.getCallState() == 0) {
                stopSelf();
                return;
            }
        }
        try {
            Process.setThreadPriority(-19);
        } catch (Exception e3) {
            e3.getStackTrace();
        }
        try {
            if (getSharedPreferences(str3, 0).getInt("modeRecordCalls", 0) == 1) {
                this.f1194c = (AudioManager) getApplicationContext().getSystemService(str4);
                if (this.f1194c != null && !this.f1194c.isSpeakerphoneOn()) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e4) {
                        try {
                            e4.getStackTrace();
                        } catch (Exception e5) {
                            e5.getStackTrace();
                        }
                    }
                    this.f1194c.setMode(2);
                    this.f1194c.setSpeakerphoneOn(true);
                }
            }
        } catch (Exception e6) {
            e6.getStackTrace();
            e6.getStackTrace();
            Crashlytics.logException(e6);
        }
        try {
            if (getSharedPreferences(str3, 0).getInt("increaseSoundRecordCalls", 1) == 1) {
                this.f1194c = (AudioManager) getApplicationContext().getSystemService(str4);
                if (this.f1194c != null) {
                    try {
                        Context applicationContext = getApplicationContext();
                        int streamVolume = this.f1194c.getStreamVolume(0);
                        Editor edit = applicationContext.getSharedPreferences(str3, 0).edit();
                        edit.putInt("deviceCallVol", streamVolume);
                        edit.apply();
                        this.f1194c.setStreamVolume(0, this.f1194c.getStreamMaxVolume(0), 0);
                    } catch (Exception e7) {
                        e7.getStackTrace();
                    }
                }
            }
        } catch (Exception e8) {
            e8.getStackTrace();
            e8.getStackTrace();
            Crashlytics.logException(e8);
        }
        if (!this.i) {
            e.a((Context) this, this.k, 1);
        }
        int i2 = getSharedPreferences(str3, 0).getInt(str2, 1);
        String str6 = "sourceAudioRecordCalls";
        if (i2 != 1 || i2 == 2 || i2 == 3) {
            a.e.a.a.b.a b2 = a.e.a.a.b.a.b(a.c.e.a.a((Context) this));
            Context applicationContext2 = getApplicationContext();
            String str7 = this.l;
            StringBuilder sb5 = new StringBuilder(String.valueOf(e.e(this)));
            sb5.append(System.currentTimeMillis());
            e.a(applicationContext2, str7, a(sb5.toString(), b2.a()));
            int i3 = i2 == 1 ? 6 : i2 == 3 ? 8 : a.e.a.a.b.a.a(getSharedPreferences(str3, 0).getInt(str6, 1));
            if (d()) {
                a();
                i3 = 1;
            }
            this.m = new f(this);
            this.m.a(b2, i3, this.l);
            this.m.a(a(i3, this.i));
            f fVar = this.m;
            getApplicationContext();
            fVar.b();
        } else if (i2 == 4) {
            this.f1193b = new MediaRecorder();
            this.f1193b.setAudioSource(a.e.a.a.b.a.a(getSharedPreferences(str3, 0).getInt(str6, 1)));
            switch (a.c.e.a.a((Context) this)) {
                case 1:
                    this.f1193b.setOutputFormat(4);
                    this.f1193b.setAudioEncoder(2);
                    break;
                case 2:
                    this.f1193b.setOutputFormat(1);
                    this.f1193b.setAudioEncoder(1);
                    str = ".3gp";
                    break;
                case 3:
                    this.f1193b.setOutputFormat(2);
                    this.f1193b.setAudioEncoder(4);
                    str = ".mp4";
                    break;
                case 4:
                    this.f1193b.setOutputFormat(6);
                    this.f1193b.setAudioEncoder(3);
                    str = ".aac";
                    break;
                case 5:
                    this.f1193b.setOutputFormat(4);
                    this.f1193b.setAudioEncoder(2);
                    break;
                case 6:
                    this.f1193b.setOutputFormat(4);
                    this.f1193b.setAudioEncoder(2);
                    break;
                default:
                    this.f1193b.setOutputFormat(4);
                    this.f1193b.setAudioEncoder(2);
                    break;
            }
            str = ".amr";
            Context applicationContext3 = getApplicationContext();
            String str8 = this.l;
            StringBuilder sb6 = new StringBuilder(String.valueOf(e.e(this)));
            sb6.append(System.currentTimeMillis());
            e.a(applicationContext3, str8, a(sb6.toString(), str));
            this.f1193b.setMaxDuration(0);
            this.f1193b.setMaxFileSize(0);
            this.f1193b.setOutputFile(e.b(getApplicationContext(), this.l));
            this.f1193b.prepare();
            this.f1193b.start();
        }
    }

    private boolean d() {
        return VERSION.SDK_INT >= 19 && Build.DEVICE.toLowerCase().contains("htc_m8") && !Build.MODEL.toLowerCase().contains("htc6525lvw");
    }

    public void b() {
        String str = MediaStreamTrack.AUDIO_TRACK_KIND;
        try {
            @SuppressLint("WrongConstant") AudioManager audioManager = (AudioManager) getSystemService(str);
            if (audioManager != null) {
                audioManager.setParameters("INCALL_RECORDING_MODE=OFF");
            }
        } catch (Exception e2) {
            e2.getStackTrace();
        }
        try {
            @SuppressLint("WrongConstant") AudioManager audioManager2 = (AudioManager) getSystemService(str);
            if (audioManager2 != null) {
                audioManager2.setParameters("VOICE_RECORDING_MODE=OFF");
            }
        } catch (Exception e3) {
            e3.getStackTrace();
        }
    }

    public int a(int i2, boolean z) {
        int b2;
        if (i2 == 6 || i2 == 8) {
            return 1000;
        }
        if (z) {
            b2 = a.c.e.a.c(this);
        } else {
            b2 = a.c.e.a.b((Context) this);
        }
        return b2 * 1000;
    }

    private String a(String str, String str2) throws Throwable {
        File file = new File(new ContextWrapper(this).getFilesDir().getPath(), ".temp");
        if (!file.exists()) {
            file.mkdirs();
        }
        Context applicationContext = getApplicationContext();
        StringBuilder sb = new StringBuilder(String.valueOf(str));
        sb.append(str2);
        String sb2 = sb.toString();
        Editor edit = applicationContext.getSharedPreferences("user", 0).edit();
        edit.putString("mFileName", sb2);
        edit.apply();
        StringBuilder sb3 = new StringBuilder(String.valueOf(file.getAbsolutePath()));
        sb3.append("/");
        sb3.append(str);
        sb3.append(str2);
        return sb3.toString();
    }

    public void a() {
        String str = MediaStreamTrack.AUDIO_TRACK_KIND;
        try {
            @SuppressLint("WrongConstant") AudioManager audioManager = (AudioManager) getSystemService(str);
            if (audioManager != null) {
                audioManager.setParameters("INCALL_RECORDING_MODE=ON");
            }
        } catch (Exception e2) {
            e2.getStackTrace();
        }
        try {
            @SuppressLint("WrongConstant") AudioManager audioManager2 = (AudioManager) getSystemService(str);
            if (audioManager2 != null) {
                audioManager2.setParameters("VOICE_RECORDING_MODE=ON");
            }
        } catch (Exception e3) {
            e3.getStackTrace();
        }
    }
}
