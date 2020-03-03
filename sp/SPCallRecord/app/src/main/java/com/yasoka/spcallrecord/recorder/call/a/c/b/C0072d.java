package com.yasoka.spcallrecord.recorder.call.a.c.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/* renamed from: a.c.b.d reason: case insensitive filesystem */
/* compiled from: AppsConfig */
public class C0072d {

    /* renamed from: a reason: collision with root package name */
    private final C0069a f92a;

    /* renamed from: b reason: collision with root package name */
    private SQLiteDatabase f93b;

    public C0072d(Context context) {
        this.f92a = new C0069a(context, "applications.db", null, 1);
    }

    public synchronized void a() {
        this.f93b.close();
    }

    public synchronized void b() throws SQLException {
        this.f93b = this.f92a.getWritableDatabase();
    }

    public Cursor c() {
        return this.f93b.query("TABLE_CONFIG_APPS", new String[]{"id", "name", "namePackage", "version", "size", "date", "stateApp"}, null, null, null, null, null);
    }

    public long a(C0085q qVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", qVar.c());
        contentValues.put("namePackage", qVar.d());
        contentValues.put("version", qVar.g());
        contentValues.put("size", qVar.e());
        contentValues.put("date", qVar.a());
        contentValues.put("stateApp", Integer.valueOf(qVar.f()));
        return this.f93b.insert("TABLE_CONFIG_APPS", null, contentValues);
    }

    public boolean a(int i) {
        SQLiteDatabase sQLiteDatabase = this.f93b;
        StringBuilder sb = new StringBuilder();
        sb.append("id = ");
        sb.append(i);
        return sQLiteDatabase.delete("TABLE_CONFIG_APPS", sb.toString(), null) > 0;
    }
}
