package com.yasoka.spcallrecord.recorder.call.a.d.a.b.d;

import a.d.a.a.i.s.b;
import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.WorkSource;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.util.g;
import com.google.android.gms.common.util.h;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class a {
    private static ScheduledExecutorService l;

    /* renamed from: a reason: collision with root package name */
    private final Object f545a;

    /* renamed from: b reason: collision with root package name */
    private final WakeLock f546b;

    /* renamed from: c reason: collision with root package name */
    private WorkSource f547c;

    /* renamed from: d reason: collision with root package name */
    private final int f548d;

    /* renamed from: e reason: collision with root package name */
    private final String f549e;
    private final String f;
    private final Context g;
    private boolean h;
    private final Map<String, Integer[]> i;
    private int j;
    private AtomicInteger k;

    public a(@NonNull Context context, int i2, @NonNull String str) {
        String packageName = context == null ? null : context.getPackageName();
        this.f545a = this;
        this.h = true;
        this.i = new HashMap();
        Collections.synchronizedSet(new HashSet());
        this.k = new AtomicInteger(0);
        b.a(context, (Object) "WakeLock: context must not be null");
        b.a(str, (Object) "WakeLock: wakeLockName must not be empty");
        this.f548d = i2;
        this.f = null;
        this.g = context.getApplicationContext();
        if (!"com.google.android.gms".equals(context.getPackageName())) {
            String str2 = "*gcore*:";
            String valueOf = String.valueOf(str);
            this.f549e = valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2);
        } else {
            this.f549e = str;
        }
        this.f546b = ((PowerManager) context.getSystemService("power")).newWakeLock(i2, str);
        if (h.a(context)) {
            if (g.a(packageName)) {
                packageName = context.getPackageName();
            }
            this.f547c = h.a(context, packageName);
            WorkSource workSource = this.f547c;
            if (workSource != null && h.a(this.g)) {
                WorkSource workSource2 = this.f547c;
                if (workSource2 != null) {
                    workSource2.add(workSource);
                } else {
                    this.f547c = workSource;
                }
                try {
                    this.f546b.setWorkSource(this.f547c);
                } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e2) {
                    e2.toString();
                }
            }
        }
        if (l == null) {
            l = com.google.android.gms.common.j.a.a().a();
        }
    }

    /* access modifiers changed from: private */
    public final void b() {
        if (this.f546b.isHeld()) {
            try {
                this.f546b.release();
            } catch (RuntimeException e2) {
                if (e2.getClass().equals(RuntimeException.class)) {
                    String.valueOf(this.f549e).concat(" was already released!");
                } else {
                    throw e2;
                }
            }
            this.f546b.isHeld();
        }
    }

    /* JADX INFO: used method not loaded: com.google.android.gms.common.util.h.a(android.os.WorkSource):null, types can be incorrect */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0063, code lost:
        if (r2 == false) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x006b, code lost:
        if (r1.j == 0) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006d, code lost:
        com.google.android.gms.common.stats.d.a().a(r1.g, com.google.android.gms.common.stats.c.a(r1.f546b, r7), 7, r1.f549e, r7, null, r1.f548d, com.google.android.gms.common.util.h.a(r1.f547c), r17);
        r1.j++;
     */
    public void a(long j2) {
        long j3 = j2;
        this.k.incrementAndGet();
        String str = (!this.h || TextUtils.isEmpty(null)) ? this.f : null;
        synchronized (this.f545a) {
            try {
                boolean z = false;
                if ((!this.i.isEmpty() || this.j > 0) && !this.f546b.isHeld()) {
                    this.i.clear();
                    this.j = 0;
                }
                if (this.h) {
                    Integer[] numArr = (Integer[]) this.i.get(str);
                    if (numArr == null) {
                        this.i.put(str, new Integer[]{Integer.valueOf(1)});
                        z = true;
                    } else {
                        numArr[0] = Integer.valueOf(numArr[0].intValue() + 1);
                    }
                }
                if (!this.h) {
                }
            } finally {
                while (true) {
                }
            }
        }
        this.f546b.acquire();
        if (j3 > 0) {
            l.schedule(new b(this), j3, TimeUnit.MILLISECONDS);
        }
    }

    /* JADX INFO: used method not loaded: com.google.android.gms.common.util.h.a(android.os.WorkSource):null, types can be incorrect */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0052, code lost:
        if (r2 == false) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005a, code lost:
        if (r13.j == 1) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005c, code lost:
        com.google.android.gms.common.stats.d.a().a(r13.g, com.google.android.gms.common.stats.c.a(r13.f546b, r6), 8, r13.f549e, r6, null, r13.f548d, com.google.android.gms.common.util.h.a(r13.f547c), 0);
        r13.j--;
     */
    public void a() {
        if (this.k.decrementAndGet() < 0) {
            String.valueOf(this.f549e).concat(" release without a matched acquire!");
        }
        String str = null;
        if (!this.h || TextUtils.isEmpty(null)) {
            str = this.f;
        }
        String str2 = str;
        synchronized (this.f545a) {
            try {
                if (this.h) {
                    Integer[] numArr = (Integer[]) this.i.get(str2);
                    boolean z = false;
                    if (numArr != null) {
                        if (numArr[0].intValue() == 1) {
                            this.i.remove(str2);
                            z = true;
                        } else {
                            numArr[0] = Integer.valueOf(numArr[0].intValue() - 1);
                        }
                    }
                }
                if (!this.h) {
                }
            } finally {
                while (true) {
                }
            }
        }
        b();
    }

    public void a(boolean z) {
        this.f546b.setReferenceCounted(z);
        this.h = z;
    }
}
