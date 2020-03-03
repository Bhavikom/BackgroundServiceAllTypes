package com.yasoka.spcallrecord.recorder.call.e;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* compiled from: ForwardingTimeout */
public class i extends u {

    /* renamed from: a reason: collision with root package name */
    private u f3407a;

    public i(u uVar) {
        if (uVar != null) {
            this.f3407a = uVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public final u a() {
        return this.f3407a;
    }

    public u clearDeadline() {
        return this.f3407a.clearDeadline();
    }

    public u clearTimeout() {
        return this.f3407a.clearTimeout();
    }

    public long deadlineNanoTime() {
        return this.f3407a.deadlineNanoTime();
    }

    public boolean hasDeadline() {
        return this.f3407a.hasDeadline();
    }

    public void throwIfReached() throws IOException {
        this.f3407a.throwIfReached();
    }

    public u timeout(long j, TimeUnit timeUnit) {
        return this.f3407a.timeout(j, timeUnit);
    }

    public long timeoutNanos() {
        return this.f3407a.timeoutNanos();
    }

    public final i a(u uVar) {
        if (uVar != null) {
            this.f3407a = uVar;
            return this;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public u deadlineNanoTime(long j) {
        return this.f3407a.deadlineNanoTime(j);
    }
}
