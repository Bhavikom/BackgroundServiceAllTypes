package com.yasoka.spcallrecord.recorder.call.a.c.b;

import a.b.a.a.a;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/* renamed from: a.c.b.c reason: case insensitive filesystem */
/* compiled from: AppsBlockStateConfig */
public class C0071c {

    /* renamed from: a reason: collision with root package name */
    private final C0070b f88a;

    /* renamed from: b reason: collision with root package name */
    private SQLiteDatabase f89b;

    public C0071c(Context context) {
        this.f88a = new C0070b(context, "trackAppsBlockState.db", null, 1);
    }

    public synchronized void a() {
        this.f89b.close();
    }

    public synchronized void b() throws SQLException {
        this.f89b = this.f88a.getWritableDatabase();
    }

    public Cursor c() {
        return this.f89b.query("TABLE_CONFIG_APPS_BLOCK_STATE", new String[]{"id", "idBBD", "idBDDPhone", "scriptWS"}, null, null, null, null, null);
    }

    public long a(r rVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("idBBD", Integer.valueOf(rVar.b()));
        contentValues.put("idBDDPhone", Long.valueOf(rVar.c()));
        contentValues.put("scriptWS", rVar.d());
        return this.f89b.insert("TABLE_CONFIG_APPS_BLOCK_STATE", null, contentValues);
    }

    public boolean a(long j) {
        return this.f89b.delete("TABLE_CONFIG_APPS_BLOCK_STATE", a.a("id = ", j), null) > 0;
    }
}
