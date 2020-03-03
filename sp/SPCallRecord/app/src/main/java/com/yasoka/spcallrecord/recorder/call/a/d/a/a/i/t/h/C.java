package com.yasoka.spcallrecord.recorder.call.a.d.a.a.i.t.h;

import a.d.a.a.i.t.h.D.a;
import android.database.sqlite.SQLiteDatabase;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
final /* synthetic */ class C implements a {

    /* renamed from: a reason: collision with root package name */
    private static final C f394a = new C();

    private C() {
    }

    public static a a() {
        return f394a;
    }

    public void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN payload_encoding TEXT");
    }
}
