package com.yasoka.spcallrecord.recorder.call.a.c.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/* compiled from: ScreenshotConfig */
public class k0 {

    /* renamed from: a reason: collision with root package name */
    private final j0 f106a;

    /* renamed from: b reason: collision with root package name */
    private SQLiteDatabase f107b;

    public k0(Context context) {
        this.f106a = new j0(context, "screenshot.db", null, 1);
    }

    public synchronized void a() {
        this.f107b.close();
    }

    public synchronized void b() throws SQLException {
        this.f107b = this.f106a.getWritableDatabase();
    }

    public Cursor c() {
        return this.f107b.query("TABLE_CONFIG_SCREENSHOT", new String[]{"id", "picture", "uploadedfile", "date"}, null, null, null, null, null);
    }

    public long a(J j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("picture", j.c());
        contentValues.put("uploadedfile", j.d());
        contentValues.put("date", j.a());
        return this.f107b.insert("TABLE_CONFIG_SCREENSHOT", null, contentValues);
    }

    public boolean a(int i) {
        SQLiteDatabase sQLiteDatabase = this.f107b;
        StringBuilder sb = new StringBuilder();
        sb.append("id = ");
        sb.append(i);
        return sQLiteDatabase.delete("TABLE_CONFIG_SCREENSHOT", sb.toString(), null) > 0;
    }
}
