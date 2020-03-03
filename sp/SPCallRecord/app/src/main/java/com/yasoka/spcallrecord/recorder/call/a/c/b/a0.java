package com.yasoka.spcallrecord.recorder.call.a.c.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/* compiled from: MediaConfig */
public class a0 {

    /* renamed from: a reason: collision with root package name */
    private final Z f86a;

    /* renamed from: b reason: collision with root package name */
    private SQLiteDatabase f87b;

    public a0(Context context) {
        this.f86a = new Z(context, "media.db", null, 2);
    }

    public synchronized void a() {
        this.f87b.close();
    }

    public synchronized void b() throws SQLException {
        this.f87b = this.f86a.getWritableDatabase();
    }

    public Cursor c() {
        return this.f87b.query("TABLE_CONFIG_MEDIA", new String[]{"id", "name", "picture", "size", "date", "address", "longitude", "latitude", "accuracy"}, null, null, null, null, null);
    }

    public long a(E e2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", e2.g());
        contentValues.put("picture", e2.h());
        contentValues.put("size", e2.i());
        contentValues.put("date", e2.c());
        contentValues.put("address", e2.b());
        contentValues.put("longitude", e2.f());
        contentValues.put("latitude", e2.e());
        contentValues.put("accuracy", e2.a());
        return this.f87b.insert("TABLE_CONFIG_MEDIA", null, contentValues);
    }

    public boolean a(int i) {
        SQLiteDatabase sQLiteDatabase = this.f87b;
        StringBuilder sb = new StringBuilder();
        sb.append("id = ");
        sb.append(i);
        return sQLiteDatabase.delete("TABLE_CONFIG_MEDIA", sb.toString(), null) > 0;
    }
}
