package com.yasoka.spcallrecord.recorder.call.c.a.f;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.logging.Logger;

/* compiled from: EventThread */
public class a extends Thread {
    /* access modifiers changed from: private */

    /* renamed from: a reason: collision with root package name */
    public static final Logger f695a = Logger.getLogger(a.class.getName());

    /* renamed from: b reason: collision with root package name */
    private static final ThreadFactory f696b = new C0016a();
    /* access modifiers changed from: private */

    /* renamed from: c reason: collision with root package name */
    public static a f697c;
    /* access modifiers changed from: private */

    /* renamed from: d reason: collision with root package name */
    public static ExecutorService f698d;
    /* access modifiers changed from: private */

    /* renamed from: e reason: collision with root package name */
    public static int f699e = 0;

    /* renamed from: c.a.f.a$a reason: collision with other inner class name */
    /* compiled from: EventThread */
    static class C0016a implements ThreadFactory {
        C0016a() {
        }

        public Thread newThread(Runnable runnable) {
            a.f697c = new a(runnable, null);
            a.f697c.setName("EventThread");
            a.f697c.setDaemon(Thread.currentThread().isDaemon());
            return a.f697c;
        }
    }

    /* compiled from: EventThread */
    static class b implements Runnable {

        /* renamed from: a reason: collision with root package name */
        final /* synthetic */ Runnable f700a;

        b(Runnable runnable) {
            this.f700a = runnable;
        }

        public void run() {
            try {
                this.f700a.run();
                synchronized (a.class) {
                    a.d();
                    if (a.f699e == 0) {
                        a.f698d.shutdown();
                        a.f698d = null;
                        a.f697c = null;
                    }
                }
            } catch (Throwable th) {
                synchronized (a.class) {
                    a.d();
                    if (a.f699e == 0) {
                        a.f698d.shutdown();
                        a.f698d = null;
                        a.f697c = null;
                    }
                    throw th;
                }
            }
        }
    }

    /* synthetic */ a(Runnable runnable, C0016a aVar) {
        super(runnable);
    }

    static /* synthetic */ int d() {
        int i = f699e;
        f699e = i - 1;
        return i;
    }

    public static void b(Runnable runnable) {
        ExecutorService executorService;
        synchronized (a.class) {
            f699e++;
            if (f698d == null) {
                f698d = Executors.newSingleThreadExecutor(f696b);
            }
            executorService = f698d;
        }
        executorService.execute(new b(runnable));
    }

    public static void a(Runnable runnable) {
        if (Thread.currentThread() == f697c) {
            runnable.run();
        } else {
            b(runnable);
        }
    }
}
