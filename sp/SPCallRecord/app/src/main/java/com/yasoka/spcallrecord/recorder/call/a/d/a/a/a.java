package com.yasoka.spcallrecord.recorder.call.a.d.a.a;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.datatransport:transport-api@@2.2.0 */
final class a<T> extends c<T> {

    /* renamed from: a reason: collision with root package name */
    private final Integer f308a;

    /* renamed from: b reason: collision with root package name */
    private final T f309b;

    /* renamed from: c reason: collision with root package name */
    private final d f310c;

    a(@Nullable Integer num, T t, d dVar) {
        this.f308a = num;
        if (t != null) {
            this.f309b = t;
            if (dVar != null) {
                this.f310c = dVar;
                return;
            }
            throw new NullPointerException("Null priority");
        }
        throw new NullPointerException("Null payload");
    }

    @Nullable
    public Integer a() {
        return this.f308a;
    }

    public T b() {
        return this.f309b;
    }

    public d c() {
        return this.f310c;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0038, code lost:
        if (r4.f310c.equals(r5.c()) != false) goto L_0x003c;
     */
    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        Integer num = this.f308a;
        if (num != null ? num.equals(((a) cVar).f308a) : ((a) cVar).f308a == null) {
            if (this.f309b.equals(cVar.b())) {
            }
        }
        z = false;
        return z;
    }

    public int hashCode() {
        Integer num = this.f308a;
        return (((((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003) ^ this.f309b.hashCode()) * 1000003) ^ this.f310c.hashCode();
    }

    public String toString() {
        StringBuilder a2 = a.b.a.a.a.a("Event{code=");
        a2.append(this.f308a);
        a2.append(", payload=");
        a2.append(this.f309b);
        a2.append(", priority=");
        a2.append(this.f310c);
        a2.append("}");
        return a2.toString();
    }
}
