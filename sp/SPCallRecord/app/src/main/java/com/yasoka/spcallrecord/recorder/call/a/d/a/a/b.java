package com.yasoka.spcallrecord.recorder.call.a.d.a.a;

import a.b.a.a.a;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.datatransport:transport-api@@2.2.0 */
public final class b {

    /* renamed from: a reason: collision with root package name */
    private final String f311a;

    private b(@NonNull String str) {
        if (str != null) {
            this.f311a = str;
            return;
        }
        throw new NullPointerException("name is null");
    }

    public static b a(@NonNull String str) {
        return new b(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        return this.f311a.equals(((b) obj).f311a);
    }

    public int hashCode() {
        return this.f311a.hashCode() ^ 1000003;
    }

    @NonNull
    public String toString() {
        return a.b(a.a("Encoding{name=\""), this.f311a, "\"}");
    }

    public String a() {
        return this.f311a;
    }
}
