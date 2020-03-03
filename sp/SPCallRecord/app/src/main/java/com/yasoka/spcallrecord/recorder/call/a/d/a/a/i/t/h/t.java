package com.yasoka.spcallrecord.recorder.call.a.d.a.a.i.t.h;

import a.d.a.a.i.g;
import a.d.a.a.i.j;
import android.database.sqlite.SQLiteDatabase;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
final /* synthetic */ class t implements b {

    /* renamed from: a reason: collision with root package name */
    private final y f431a;

    /* renamed from: b reason: collision with root package name */
    private final j f432b;

    /* renamed from: c reason: collision with root package name */
    private final g f433c;

    private t(y yVar, j jVar, g gVar) {
        this.f431a = yVar;
        this.f432b = jVar;
        this.f433c = gVar;
    }

    public static b a(y yVar, j jVar, g gVar) {
        return new t(yVar, jVar, gVar);
    }

    public Object apply(Object obj) {
        return y.a(this.f431a, this.f432b, this.f433c, (SQLiteDatabase) obj);
    }
}
