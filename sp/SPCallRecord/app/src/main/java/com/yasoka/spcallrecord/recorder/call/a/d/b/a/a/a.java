package com.yasoka.spcallrecord.recorder.call.a.d.b.a.a;

import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* compiled from: ListenableFuture */
public interface a<V> extends Future<V> {
    void addListener(Runnable runnable, Executor executor);
}
