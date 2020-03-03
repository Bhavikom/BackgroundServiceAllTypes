package com.yasoka.spcallrecord.recorder.call.a.c.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/* renamed from: a.c.b.n reason: case insensitive filesystem */
/* compiled from: CalendarConfig */
public class C0082n {

    /* renamed from: a reason: collision with root package name */
    private final C0081m f112a;

    /* renamed from: b reason: collision with root package name */
    private SQLiteDatabase f113b;

    public C0082n(Context context) {
        this.f112a = new C0081m(context, "trackCalendar.db", null, 2);
    }

    public synchronized void a() {
        this.f113b.close();
    }

    public synchronized void b() throws SQLException {
        this.f113b = this.f112a.getWritableDatabase();
    }

    public Cursor c() {
        return this.f113b.query("TABLE_CONFIG_CALENDAR", new String[]{"id", "title", "description", "dateStart", "dateEnd", "locationEvent", "date", "address", "longitude", "latitude", "accuracy"}, null, null, null, null, null);
    }

    public long a(C0090w wVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", wVar.k());
        contentValues.put("description", wVar.f());
        contentValues.put("dateStart", wVar.e());
        contentValues.put("dateEnd", wVar.d());
        contentValues.put("locationEvent", wVar.i());
        contentValues.put("date", wVar.c());
        contentValues.put("address", wVar.b());
        contentValues.put("longitude", wVar.j());
        contentValues.put("latitude", wVar.h());
        contentValues.put("accuracy", wVar.a());
        return this.f113b.insert("TABLE_CONFIG_CALENDAR", null, contentValues);
    }

    public boolean a(int i) {
        SQLiteDatabase sQLiteDatabase = this.f113b;
        StringBuilder sb = new StringBuilder();
        sb.append("id = ");
        sb.append(i);
        return sQLiteDatabase.delete("TABLE_CONFIG_CALENDAR", sb.toString(), null) > 0;
    }
}
