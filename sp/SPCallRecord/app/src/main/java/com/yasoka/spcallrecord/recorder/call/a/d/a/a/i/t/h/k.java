package com.yasoka.spcallrecord.recorder.call.a.d.a.a.i.t.h;

import android.database.sqlite.SQLiteDatabase;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
final /* synthetic */ class k implements b {

    /* renamed from: a reason: collision with root package name */
    private final long f421a;

    private k(long j) {
        this.f421a = j;
    }

    public static b a(long j) {
        return new k(j);
    }

    public Object apply(Object obj) {
        return Integer.valueOf(((SQLiteDatabase) obj).delete("events", "timestamp_ms < ?", new String[]{String.valueOf(this.f421a)}));
    }
}
