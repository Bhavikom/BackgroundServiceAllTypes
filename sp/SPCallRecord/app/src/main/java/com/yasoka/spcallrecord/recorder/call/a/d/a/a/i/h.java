package com.yasoka.spcallrecord.recorder.call.a.d.a.a.i;

import b.b.b;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final class h implements b<Executor> {

    /* renamed from: a reason: collision with root package name */
    private static final h f350a = new h();

    public static h a() {
        return f350a;
    }

    public Object get() {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        a.d.a.a.i.s.b.b(newSingleThreadExecutor, "Cannot return null from a non-@Nullable @Provides method");
        return newSingleThreadExecutor;
    }
}
