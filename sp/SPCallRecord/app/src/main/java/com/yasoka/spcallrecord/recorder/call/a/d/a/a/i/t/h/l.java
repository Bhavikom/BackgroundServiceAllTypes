package com.yasoka.spcallrecord.recorder.call.a.d.a.a.i.t.h;

import a.d.a.a.i.j;
import android.database.Cursor;
import java.util.List;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
final /* synthetic */ class l implements b {

    /* renamed from: a reason: collision with root package name */
    private final List f422a;

    /* renamed from: b reason: collision with root package name */
    private final j f423b;

    private l(List list, j jVar) {
        this.f422a = list;
        this.f423b = jVar;
    }

    public static b a(List list, j jVar) {
        return new l(list, jVar);
    }

    public Object apply(Object obj) {
        y.a(this.f422a, this.f423b, (Cursor) obj);
        return null;
    }
}
