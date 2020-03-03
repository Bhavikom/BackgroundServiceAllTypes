package com.yasoka.spcallrecord.recorder.call.b.b;

import a.d.a.a.i.s.b;
import b.a;

/* compiled from: InstanceFactory */
public final class c<T> implements b<T>, a<T> {

    /* renamed from: a reason: collision with root package name */
    private final T f660a;

    static {
        new c(null);
    }

    private c(T t) {
        this.f660a = t;
    }

    public static <T> b<T> a(T t) {
        b.b(t, "instance cannot be null");
        return new c(t);
    }

    public T get() {
        return this.f660a;
    }
}
