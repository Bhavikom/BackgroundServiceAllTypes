package com.yasoka.spcallrecord.recorder.call.a.d.a.a.i;

import a.d.a.a.d;
import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo.Scope;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public abstract class j {

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    public static abstract class a {
        @RestrictTo({Scope.LIBRARY})
        public abstract a a(d dVar);

        public abstract a a(String str);

        public abstract a a(@Nullable byte[] bArr);

        public abstract j a();
    }

    public static a d() {
        b bVar = new b();
        bVar.a(d.DEFAULT);
        return bVar;
    }

    @RestrictTo({Scope.LIBRARY})
    public j a(d dVar) {
        a d2 = d();
        d2.a(a());
        d2.a(dVar);
        d2.a(b());
        return d2.a();
    }

    public abstract String a();

    @Nullable
    public abstract byte[] b();

    @RestrictTo({Scope.LIBRARY_GROUP})
    public abstract d c();

    public final String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = a();
        objArr[1] = c();
        objArr[2] = b() == null ? "" : Base64.encodeToString(b(), 2);
        return String.format("TransportContext(%s, %s, %s)", objArr);
    }
}
