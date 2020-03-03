package com.yasoka.spcallrecord.recorder.call.b.b;

/* compiled from: DoubleCheck */
public final class a<T> implements d.a.a<T>, b.a<T> {

    /* renamed from: c reason: collision with root package name */
    private static final Object f657c = new Object();

    /* renamed from: a reason: collision with root package name */
    private volatile d.a.a<T> f658a;

    /* renamed from: b reason: collision with root package name */
    private volatile Object f659b = f657c;

    private a(d.a.a<T> aVar) {
        this.f658a = aVar;
    }

    public static Object a(Object obj, Object obj2) {
        if (!(obj != f657c) || obj == obj2) {
            return obj2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Scoped provider was invoked recursively returning different results: ");
        sb.append(obj);
        sb.append(" & ");
        sb.append(obj2);
        sb.append(". This is likely due to a circular dependency.");
        throw new IllegalStateException(sb.toString());
    }

    public T get() {
        T t = this.f659b;
        if (t == f657c) {
            synchronized (this) {
                t = this.f659b;
                if (t == f657c) {
                    t = this.f658a.get();
                    a(this.f659b, t);
                    this.f659b = t;
                    this.f658a = null;
                }
            }
        }
        return t;
    }

    public static <P extends d.a.a<T>, T> d.a.a<T> a(P p) {
        if (p == null) {
            throw new NullPointerException();
        } else if (p instanceof a) {
            return p;
        } else {
            return new a(p);
        }
    }
}
