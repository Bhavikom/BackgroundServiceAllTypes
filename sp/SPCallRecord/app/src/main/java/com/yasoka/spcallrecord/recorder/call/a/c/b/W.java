package com.yasoka.spcallrecord.recorder.call.a.c.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/* compiled from: LogsConfig */
public class W {

    /* renamed from: a reason: collision with root package name */
    private final V f82a;

    /* renamed from: b reason: collision with root package name */
    private SQLiteDatabase f83b;

    public W(Context context) {
        this.f82a = new V(context, "logsdata.db", null, 1);
    }

    public synchronized void a() {
        this.f83b.close();
    }

    public synchronized void b() throws SQLException {
        this.f83b = this.f82a.getWritableDatabase();
    }

    public Cursor c() {
        return this.f83b.query("TABLE_LOGS", new String[]{"id", "idPhone", "dateConnexion", "type", "idLog", "data"}, null, null, null, null, null);
    }

    public void d() {
        this.f83b.execSQL("DROP TABLE IF EXISTS TABLE_LOGS");
    }

    public long a(C c2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("idPhone", Integer.valueOf(c2.e()));
        contentValues.put("dateConnexion", c2.b());
        contentValues.put("type", c2.f());
        contentValues.put("idLog", Integer.valueOf(c2.d()));
        contentValues.put("data", c2.a());
        return this.f83b.insert("TABLE_LOGS", null, contentValues);
    }

    public boolean a(int i) {
        SQLiteDatabase sQLiteDatabase = this.f83b;
        StringBuilder sb = new StringBuilder();
        sb.append("id = ");
        sb.append(i);
        return sQLiteDatabase.delete("TABLE_LOGS", sb.toString(), null) > 0;
    }
}
