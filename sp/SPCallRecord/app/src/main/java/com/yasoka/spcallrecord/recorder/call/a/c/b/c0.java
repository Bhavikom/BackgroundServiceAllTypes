package com.yasoka.spcallrecord.recorder.call.a.c.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/* compiled from: RestrictionConfig */
public class c0 {

    /* renamed from: a reason: collision with root package name */
    private final b0 f90a;

    /* renamed from: b reason: collision with root package name */
    private SQLiteDatabase f91b;

    public c0(Context context) {
        this.f90a = new b0(context, "restriction.db", null, 1);
    }

    public synchronized void a() {
        this.f91b.close();
    }

    public synchronized void b() throws SQLException {
        this.f91b = this.f90a.getWritableDatabase();
    }

    public Cursor c() {
        return this.f91b.query("TABLE_CONFIG_RESTRICTION", new String[]{"id", "timeStart", "timeEnd", "listDays", "message"}, null, null, null, null, null);
    }

    public long a(F f) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("timeStart", f.d());
        contentValues.put("timeEnd", f.c());
        contentValues.put("listDays", f.a());
        contentValues.put("message", f.b());
        return this.f91b.insert("TABLE_CONFIG_RESTRICTION", null, contentValues);
    }

    public boolean a(int i) {
        SQLiteDatabase sQLiteDatabase = this.f91b;
        StringBuilder sb = new StringBuilder();
        sb.append("id = ");
        sb.append(i);
        return sQLiteDatabase.delete("TABLE_CONFIG_RESTRICTION", sb.toString(), null) > 0;
    }
}
