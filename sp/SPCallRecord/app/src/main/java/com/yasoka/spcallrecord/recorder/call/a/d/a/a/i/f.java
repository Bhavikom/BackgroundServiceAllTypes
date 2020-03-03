package com.yasoka.spcallrecord.recorder.call.a.d.a.a.i;

import a.b.a.a.a;
import a.d.a.a.b;
import androidx.annotation.NonNull;
import java.util.Arrays;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final class f {

    /* renamed from: a reason: collision with root package name */
    private final b f348a;

    /* renamed from: b reason: collision with root package name */
    private final byte[] f349b;

    public f(@NonNull b bVar, @NonNull byte[] bArr) {
        if (bVar == null) {
            throw new NullPointerException("encoding is null");
        } else if (bArr != null) {
            this.f348a = bVar;
            this.f349b = bArr;
        } else {
            throw new NullPointerException("bytes is null");
        }
    }

    public byte[] a() {
        return this.f349b;
    }

    public b b() {
        return this.f348a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (!this.f348a.equals(fVar.f348a)) {
            return false;
        }
        return Arrays.equals(this.f349b, fVar.f349b);
    }

    public int hashCode() {
        return ((this.f348a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f349b);
    }

    public String toString() {
        StringBuilder a2 = a.a("EncodedPayload{encoding=");
        a2.append(this.f348a);
        a2.append(", bytes=[...]}");
        return a2.toString();
    }
}
