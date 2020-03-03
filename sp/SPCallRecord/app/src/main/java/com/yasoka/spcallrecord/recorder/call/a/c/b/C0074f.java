package com.yasoka.spcallrecord.recorder.call.a.c.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/* renamed from: a.c.b.f reason: case insensitive filesystem */
/* compiled from: AppsUsageConfig */
public class C0074f {

    /* renamed from: a reason: collision with root package name */
    private final C0073e f94a;

    /* renamed from: b reason: collision with root package name */
    private SQLiteDatabase f95b;

    public C0074f(Context context) {
        this.f94a = new C0073e(context, "trackAppsUsage.db", null, 1);
    }

    public synchronized void a() {
        this.f95b.close();
    }

    public synchronized void b() throws SQLException {
        this.f95b = this.f94a.getWritableDatabase();
    }

    public Cursor c() {
        return this.f95b.query("TABLE_CONFIG_APPS_USAGE", new String[]{"id", "dataUsage"}, null, null, null, null, null);
    }

    public long a(C0086s sVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("dataUsage", sVar.a());
        return this.f95b.insert("TABLE_CONFIG_APPS_USAGE", null, contentValues);
    }

    public boolean a(int i) {
        SQLiteDatabase sQLiteDatabase = this.f95b;
        StringBuilder sb = new StringBuilder();
        sb.append("id = ");
        sb.append(i);
        return sQLiteDatabase.delete("TABLE_CONFIG_APPS_USAGE", sb.toString(), null) > 0;
    }
}
