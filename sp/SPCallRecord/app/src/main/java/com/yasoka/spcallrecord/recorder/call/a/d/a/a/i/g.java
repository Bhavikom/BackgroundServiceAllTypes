package com.yasoka.spcallrecord.recorder.call.a.d.a.a.i;

import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public abstract class g {

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    public static abstract class a {
        public abstract a a(long j);

        public abstract a a(f fVar);

        public abstract a a(Integer num);

        public abstract a a(String str);

        public final a a(String str, String str2) {
            b().put(str, str2);
            return this;
        }

        /* access modifiers changed from: protected */
        public abstract a a(Map<String, String> map);

        public abstract g a();

        public abstract a b(long j);

        /* access modifiers changed from: protected */
        public abstract Map<String, String> b();

        public final a a(String str, long j) {
            b().put(str, String.valueOf(j));
            return this;
        }

        public final a a(String str, int i) {
            b().put(str, String.valueOf(i));
            return this;
        }
    }

    public static a i() {
        b bVar = new b();
        bVar.a((Map<String, String>) new HashMap<String,String>());
        return bVar;
    }

    public final String a(String str) {
        String str2 = (String) a().get(str);
        return str2 == null ? "" : str2;
    }

    /* access modifiers changed from: protected */
    public abstract Map<String, String> a();

    public final int b(String str) {
        String str2 = (String) a().get(str);
        if (str2 == null) {
            return 0;
        }
        return Integer.valueOf(str2).intValue();
    }

    @Nullable
    public abstract Integer b();

    public final long c(String str) {
        String str2 = (String) a().get(str);
        if (str2 == null) {
            return 0;
        }
        return Long.valueOf(str2).longValue();
    }

    public abstract f c();

    public abstract long d();

    public final Map<String, String> e() {
        return Collections.unmodifiableMap(a());
    }

    public abstract String f();

    public abstract long g();

    public a h() {
        b bVar = new b();
        bVar.a(f());
        bVar.a(b());
        bVar.a(c());
        bVar.a(d());
        bVar.b(g());
        bVar.a((Map<String, String>) new HashMap<String,String>(a()));
        return bVar;
    }
}
