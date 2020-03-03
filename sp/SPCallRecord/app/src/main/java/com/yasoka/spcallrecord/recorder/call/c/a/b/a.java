package com.yasoka.spcallrecord.recorder.call.c.a.b;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;

/* compiled from: Emitter */
public class a {

    /* renamed from: a reason: collision with root package name */
    private ConcurrentMap<String, ConcurrentLinkedQueue<C0011a>> f666a = new ConcurrentHashMap();

    /* renamed from: c.a.b.a$a reason: collision with other inner class name */
    /* compiled from: Emitter */
    public interface C0011a {
        void a(Object... objArr);
    }

    /* compiled from: Emitter */
    private class b implements C0011a {

        /* renamed from: a reason: collision with root package name */
        public final String f667a;

        /* renamed from: b reason: collision with root package name */
        public final C0011a f668b;

        public b(String str, C0011a aVar) {
            this.f667a = str;
            this.f668b = aVar;
        }

        public void a(Object... objArr) {
            a.this.a(this.f667a, (C0011a) this);
            this.f668b.a(objArr);
        }
    }

    public a a() {
        this.f666a.clear();
        return this;
    }

    public a b(String str, C0011a aVar) {
        ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) this.f666a.get(str);
        if (concurrentLinkedQueue == null) {
            concurrentLinkedQueue = new ConcurrentLinkedQueue();
            ConcurrentLinkedQueue concurrentLinkedQueue2 = (ConcurrentLinkedQueue) this.f666a.putIfAbsent(str, concurrentLinkedQueue);
            if (concurrentLinkedQueue2 != null) {
                concurrentLinkedQueue = concurrentLinkedQueue2;
            }
        }
        concurrentLinkedQueue.add(aVar);
        return this;
    }

    public a c(String str, C0011a aVar) {
        b(str, new b(str, aVar));
        return this;
    }

    public a a(String str) {
        this.f666a.remove(str);
        return this;
    }

    public a a(String str, C0011a aVar) {
        boolean z;
        ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) this.f666a.get(str);
        if (concurrentLinkedQueue != null) {
            Iterator it = concurrentLinkedQueue.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                C0011a aVar2 = (C0011a) it.next();
                if (aVar.equals(aVar2)) {
                    z = true;
                    continue;
                } else if (aVar2 instanceof b) {
                    z = aVar.equals(((b) aVar2).f668b);
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    it.remove();
                    break;
                }
            }
        }
        return this;
    }

    public a a(String str, Object... objArr) {
        ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) this.f666a.get(str);
        if (concurrentLinkedQueue != null) {
            Iterator it = concurrentLinkedQueue.iterator();
            while (it.hasNext()) {
                ((C0011a) it.next()).a(objArr);
            }
        }
        return this;
    }
}
