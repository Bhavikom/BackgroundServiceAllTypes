package com.yasoka.spcallrecord.recorder.call.e;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* compiled from: AsyncTimeout */
public class a extends u {
    private static final long IDLE_TIMEOUT_MILLIS = TimeUnit.SECONDS.toMillis(60);
    private static final long IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(IDLE_TIMEOUT_MILLIS);
    private static final int TIMEOUT_WRITE_SIZE = 65536;
    static a head;
    private boolean inQueue;
    private a next;
    private long timeoutAt;

    /* renamed from: e.a$a reason: collision with other inner class name */
    /* compiled from: AsyncTimeout */
    class C0045a implements s {

        /* renamed from: a reason: collision with root package name */
        final /* synthetic */ s f3387a;

        C0045a(s sVar) {
            this.f3387a = sVar;
        }

        public void close() throws IOException {
            a.this.enter();
            try {
                this.f3387a.close();
                a.this.exit(true);
            } catch (IOException e2) {
                throw a.this.exit(e2);
            } catch (Throwable th) {
                a.this.exit(false);
                throw th;
            }
        }

        public void flush() throws IOException {
            a.this.enter();
            try {
                this.f3387a.flush();
                a.this.exit(true);
            } catch (IOException e2) {
                throw a.this.exit(e2);
            } catch (Throwable th) {
                a.this.exit(false);
                throw th;
            }
        }

        public u timeout() {
            return a.this;
        }

        public String toString() {
            StringBuilder a2 = b.a.a.a.a("AsyncTimeout.sink(");
            a2.append(this.f3387a);
            a2.append(")");
            return a2.toString();
        }

        public void write(c cVar, long j) throws IOException {
            v.a(cVar.f3394b, 0, j);
            while (true) {
                long j2 = 0;
                if (j > 0) {
                    p pVar = cVar.f3393a;
                    while (true) {
                        if (j2 >= 65536) {
                            break;
                        }
                        j2 += (long) (pVar.f3432c - pVar.f3431b);
                        if (j2 >= j) {
                            j2 = j;
                            break;
                        }
                        pVar = pVar.f;
                    }
                    a.this.enter();
                    try {
                        this.f3387a.write(cVar, j2);
                        j -= j2;
                        a.this.exit(true);
                    } catch (IOException e2) {
                        throw a.this.exit(e2);
                    } catch (Throwable th) {
                        a.this.exit(false);
                        throw th;
                    }
                } else {
                    return;
                }
            }
        }
    }

    /* compiled from: AsyncTimeout */
    class b implements t {

        /* renamed from: a reason: collision with root package name */
        final /* synthetic */ t f3389a;

        b(t tVar) {
            this.f3389a = tVar;
        }

        public void close() throws IOException {
            try {
                this.f3389a.close();
                a.this.exit(true);
            } catch (IOException e2) {
                throw a.this.exit(e2);
            } catch (Throwable th) {
                a.this.exit(false);
                throw th;
            }
        }

        public long read(c cVar, long j) throws IOException {
            a.this.enter();
            try {
                long read = this.f3389a.read(cVar, j);
                a.this.exit(true);
                return read;
            } catch (IOException e2) {
                throw a.this.exit(e2);
            } catch (Throwable th) {
                a.this.exit(false);
                throw th;
            }
        }

        public u timeout() {
            return a.this;
        }

        public String toString() {
            StringBuilder a2 = b.a.a.a.a("AsyncTimeout.source(");
            a2.append(this.f3389a);
            a2.append(")");
            return a2.toString();
        }
    }

    /* compiled from: AsyncTimeout */
    private static final class c extends Thread {
        c() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            r1.timedOut();
         */
        public void run() {
            while (true) {
                try {
                    synchronized (a.class) {
                        a awaitTimeout = a.awaitTimeout();
                        if (awaitTimeout != null) {
                            if (awaitTimeout == a.head) {
                                a.head = null;
                                return;
                            }
                        }
                    }
                } catch (InterruptedException unused) {
                }
            }
            while (true) {
            }
        }
    }

    static a awaitTimeout() throws InterruptedException {
        Class<a> cls = a.class;
        a aVar = head.next;
        a aVar2 = null;
        if (aVar == null) {
            long nanoTime = System.nanoTime();
            cls.wait(IDLE_TIMEOUT_MILLIS);
            if (head.next == null && System.nanoTime() - nanoTime >= IDLE_TIMEOUT_NANOS) {
                aVar2 = head;
            }
            return aVar2;
        }
        long remainingNanos = aVar.remainingNanos(System.nanoTime());
        if (remainingNanos > 0) {
            long j = remainingNanos / 1000000;
            cls.wait(j, (int) (remainingNanos - (1000000 * j)));
            return null;
        }
        head.next = aVar.next;
        aVar.next = null;
        return aVar;
    }

    private static synchronized boolean cancelScheduledTimeout(a aVar) {
        synchronized (a.class) {
            a aVar2 = head;
            while (aVar2 != null) {
                a aVar3 = aVar2.next;
                if (aVar3 == aVar) {
                    aVar2.next = aVar.next;
                    aVar.next = null;
                    return false;
                }
                aVar2 = aVar3;
            }
            return true;
        }
    }

    private long remainingNanos(long j) {
        return this.timeoutAt - j;
    }

    private static synchronized void scheduleTimeout(a aVar, long j, boolean z) {
        Class<a> cls = a.class;
        synchronized (cls) {
            if (head == null) {
                head = new a();
                new c().start();
            }
            long nanoTime = System.nanoTime();
            if (j != 0 && z) {
                aVar.timeoutAt = Math.min(j, aVar.deadlineNanoTime() - nanoTime) + nanoTime;
            } else if (j != 0) {
                aVar.timeoutAt = j + nanoTime;
            } else if (z) {
                aVar.timeoutAt = aVar.deadlineNanoTime();
            } else {
                throw new AssertionError();
            }
            long remainingNanos = aVar.remainingNanos(nanoTime);
            a aVar2 = head;
            while (true) {
                if (aVar2.next == null) {
                    break;
                } else if (remainingNanos < aVar2.next.remainingNanos(nanoTime)) {
                    break;
                } else {
                    aVar2 = aVar2.next;
                }
            }
            aVar.next = aVar2.next;
            aVar2.next = aVar;
            if (aVar2 == head) {
                cls.notify();
            }
        }
    }

    public final void enter() {
        if (!this.inQueue) {
            long timeoutNanos = timeoutNanos();
            boolean hasDeadline = hasDeadline();
            if (timeoutNanos != 0 || hasDeadline) {
                this.inQueue = true;
                scheduleTimeout(this, timeoutNanos, hasDeadline);
                return;
            }
            return;
        }
        throw new IllegalStateException("Unbalanced enter/exit");
    }

    public final boolean exit() {
        if (!this.inQueue) {
            return false;
        }
        this.inQueue = false;
        return cancelScheduledTimeout(this);
    }

    /* access modifiers changed from: protected */
    public IOException newTimeoutException(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final s sink(s sVar) {
        return new C0045a(sVar);
    }

    public final t source(t tVar) {
        return new b(tVar);
    }

    /* access modifiers changed from: protected */
    public void timedOut() {
    }

    /* access modifiers changed from: 0000 */
    public final void exit(boolean z) throws IOException {
        if (exit() && z) {
            throw newTimeoutException(null);
        }
    }

    /* access modifiers changed from: 0000 */
    public final IOException exit(IOException iOException) throws IOException {
        if (!exit()) {
            return iOException;
        }
        return newTimeoutException(iOException);
    }
}
