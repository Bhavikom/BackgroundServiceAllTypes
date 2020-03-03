package com.yasoka.spcallrecord.recorder.call.a.c.b;

import a.b.a.a.a;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/* renamed from: a.c.b.h reason: case insensitive filesystem */
/* compiled from: BlockAppsConfig */
public class C0076h {

    /* renamed from: a reason: collision with root package name */
    private final C0075g f98a;

    /* renamed from: b reason: collision with root package name */
    private SQLiteDatabase f99b;

    public C0076h(Context context) {
        this.f98a = new C0075g(context, "blockapplications.db", null, 2);
    }

    public synchronized void a() {
        this.f99b.close();
    }

    public synchronized void b() throws SQLException {
        this.f99b = this.f98a.getWritableDatabase();
    }

    public long a(C0087t tVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name_package", tVar.f129a);
        contentValues.put("timeStart", tVar.d());
        contentValues.put("timeEnd", tVar.c());
        contentValues.put("listDays", tVar.a());
        contentValues.put("message", tVar.b());
        return this.f99b.insert("TABLE_CONFIG_BLOCK_APPS", null, contentValues);
    }

    public boolean a(int i) {
        SQLiteDatabase sQLiteDatabase = this.f99b;
        StringBuilder sb = new StringBuilder();
        sb.append("id = ");
        sb.append(i);
        return sQLiteDatabase.delete("TABLE_CONFIG_BLOCK_APPS", sb.toString(), null) > 0;
    }

    public Cursor a(String str) {
        return this.f99b.query("TABLE_CONFIG_BLOCK_APPS", new String[]{"id", "name_package", "timeStart", "timeEnd", "listDays", "message"}, a.a("name_package LIKE \"", str, "\""), null, null, null, null);
    }
}
