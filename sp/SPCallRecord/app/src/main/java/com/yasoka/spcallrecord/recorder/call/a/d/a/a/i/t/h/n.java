package com.yasoka.spcallrecord.recorder.call.a.d.a.a.i.t.h;

import android.database.sqlite.SQLiteDatabase;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
final /* synthetic */ class n implements d {

    /* renamed from: a reason: collision with root package name */
    private final SQLiteDatabase f425a;

    private n(SQLiteDatabase sQLiteDatabase) {
        this.f425a = sQLiteDatabase;
    }

    public static d a(SQLiteDatabase sQLiteDatabase) {
        return new n(sQLiteDatabase);
    }

    public Object a() {
        this.f425a.beginTransaction();
        return null;
    }
}
