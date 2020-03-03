package com.yasoka.spcallrecord.recorder.call.a.c.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/* compiled from: MMSConfig */
public class Y {

    /* renamed from: a reason: collision with root package name */
    private final X f84a;

    /* renamed from: b reason: collision with root package name */
    private SQLiteDatabase f85b;

    public Y(Context context) {
        this.f84a = new X(context, "trackMMS.db", null, 1);
    }

    public synchronized void a() {
        this.f85b.close();
    }

    public synchronized void b() throws SQLException {
        this.f85b = this.f84a.getWritableDatabase();
    }

    public synchronized Cursor c() {
        return this.f85b.query("TABLE_CONFIG_MMS", new String[]{"id", "name", "number", "message", "type", "date", "address", "longitude", "latitude", "accuracy", "subject", "data"}, null, null, null, null, null);
    }

    public synchronized long a(D d2) {
        ContentValues contentValues;
        contentValues = new ContentValues();
        contentValues.put("name", d2.i());
        contentValues.put("number", d2.j());
        contentValues.put("message", d2.h());
        contentValues.put("type", Integer.valueOf(d2.l()));
        contentValues.put("date", d2.d());
        contentValues.put("address", d2.b());
        contentValues.put("longitude", d2.g());
        contentValues.put("latitude", d2.f());
        contentValues.put("accuracy", d2.a());
        contentValues.put("subject", d2.k());
        contentValues.put("data", d2.c());
        return this.f85b.insert("TABLE_CONFIG_MMS", null, contentValues);
    }

    public synchronized boolean a(int i) {
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append("id = ");
        sb.append(i);
        return this.f85b.delete("TABLE_CONFIG_MMS", sb.toString(), null) > 0;
    }
}
