package com.yasoka.spcallrecord.recorder.call.a.d.a.b.a.d;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* compiled from: com.google.firebase:firebase-iid@@20.0.2 */
final class n extends WeakReference<Throwable> {

    /* renamed from: a reason: collision with root package name */
    private final int f468a;

    public n(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        if (th != null) {
            this.f468a = System.identityHashCode(th);
            return;
        }
        throw new NullPointerException("The referent cannot be null");
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == n.class) {
            if (this == obj) {
                return true;
            }
            n nVar = (n) obj;
            return this.f468a == nVar.f468a && get() == nVar.get();
        }
    }

    public final int hashCode() {
        return this.f468a;
    }
}
