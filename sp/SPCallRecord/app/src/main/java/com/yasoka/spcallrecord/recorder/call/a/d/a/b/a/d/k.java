package com.yasoka.spcallrecord.recorder.call.a.d.a.b.a.d;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.firebase:firebase-iid@@20.0.2 */
final class k {

    /* renamed from: a reason: collision with root package name */
    private final ConcurrentHashMap<n, List<Throwable>> f465a = new ConcurrentHashMap<>(16, 0.75f, 10);

    /* renamed from: b reason: collision with root package name */
    private final ReferenceQueue<Throwable> f466b = new ReferenceQueue<>();

    k() {
    }

    public final List a(Throwable th) {
        Reference poll = this.f466b.poll();
        while (poll != null) {
            this.f465a.remove(poll);
            poll = this.f466b.poll();
        }
        List list = (List) this.f465a.get(new n(th, null));
        if (list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List list2 = (List) this.f465a.putIfAbsent(new n(th, this.f466b), vector);
        return list2 == null ? vector : list2;
    }
}
