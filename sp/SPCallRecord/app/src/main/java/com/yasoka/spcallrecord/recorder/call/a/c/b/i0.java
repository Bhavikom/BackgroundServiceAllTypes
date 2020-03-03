package com.yasoka.spcallrecord.recorder.call.a.c.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/* compiled from: SMSConfig */
public class i0 {

    /* renamed from: a reason: collision with root package name */
    private final d0 f102a;

    /* renamed from: b reason: collision with root package name */
    private SQLiteDatabase f103b;

    public i0(Context context) {
        this.f102a = new d0(context, "trackSMS.db", null, 1);
    }

    public synchronized void a() {
        this.f103b.close();
    }

    public synchronized void b() throws SQLException {
        this.f103b = this.f102a.getWritableDatabase();
    }

    public synchronized Cursor c() {
        return this.f103b.query("TABLE_CONFIG_SMS", new String[]{"id", "name", "number", "message", "type", "date", "address", "longitude", "latitude", "accuracy"}, null, null, null, null, null);
    }

    public synchronized long a(G g) {
        ContentValues contentValues;
        contentValues = new ContentValues();
        contentValues.put("name", g.h());
        contentValues.put("number", g.i());
        contentValues.put("message", g.g());
        contentValues.put("type", Integer.valueOf(g.j()));
        contentValues.put("date", g.c());
        contentValues.put("address", g.b());
        contentValues.put("longitude", g.f());
        contentValues.put("latitude", g.e());
        contentValues.put("accuracy", g.a());
        return this.f103b.insert("TABLE_CONFIG_SMS", null, contentValues);
    }

    public synchronized boolean a(int i) {
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append("id = ");
        sb.append(i);
        return this.f103b.delete("TABLE_CONFIG_SMS", sb.toString(), null) > 0;
    }
}
