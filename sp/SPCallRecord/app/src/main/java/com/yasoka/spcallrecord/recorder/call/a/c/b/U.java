package com.yasoka.spcallrecord.recorder.call.a.c.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/* compiled from: LocalizationsConfig */
public class U {

    /* renamed from: a reason: collision with root package name */
    private SQLiteDatabase f80a;

    /* renamed from: b reason: collision with root package name */
    private T f81b;

    public U(Context context) {
        this.f81b = new T(context, "trackGPS.db", null, 1);
    }

    public synchronized void a() {
        this.f80a.close();
    }

    public synchronized void b() throws SQLException {
        this.f80a = this.f81b.getWritableDatabase();
    }

    public Cursor c() {
        return this.f80a.query("TABLE_CONFIG_GPS", new String[]{"id", "date", "longitude", "latitude", "altitude", "speed", "accuracy", "address", "gps"}, null, null, null, null, null);
    }

    public long a(B b2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("date", b2.d());
        contentValues.put("longitude", b2.h());
        contentValues.put("latitude", b2.g());
        contentValues.put("altitude", b2.c());
        contentValues.put("speed", b2.i());
        contentValues.put("accuracy", b2.a());
        contentValues.put("address", b2.b());
        contentValues.put("gps", b2.e());
        return this.f80a.insert("TABLE_CONFIG_GPS", null, contentValues);
    }

    public boolean a(int i) {
        SQLiteDatabase sQLiteDatabase = this.f80a;
        StringBuilder sb = new StringBuilder();
        sb.append("id = ");
        sb.append(i);
        return sQLiteDatabase.delete("TABLE_CONFIG_GPS", sb.toString(), null) > 0;
    }
}
