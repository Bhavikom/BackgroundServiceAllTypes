package com.yasoka.spcallrecord.recorder.call.a.c.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/* renamed from: a.c.b.p reason: case insensitive filesystem */
/* compiled from: CallConfig */
public class C0084p {

    /* renamed from: a reason: collision with root package name */
    private final C0083o f116a;

    /* renamed from: b reason: collision with root package name */
    private SQLiteDatabase f117b;

    public C0084p(Context context) {
        this.f116a = new C0083o(context, "trackCall.db", null, 2);
    }

    public synchronized void a() {
        this.f117b.close();
    }

    public synchronized void b() throws SQLException {
        this.f117b = this.f116a.getWritableDatabase();
    }

    public Cursor c() {
        return this.f117b.query("TABLE_CONFIG_CALLS", new String[]{"id", "name", "number", "type", "duration", "date", "address", "longitude", "latitude", "accuracy", "pathfile"}, null, null, null, null, null);
    }

    public long a(C0091x xVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", xVar.h());
        contentValues.put("number", xVar.i());
        contentValues.put("type", xVar.k());
        contentValues.put("duration", xVar.d());
        contentValues.put("date", xVar.c());
        contentValues.put("address", xVar.b());
        contentValues.put("longitude", xVar.g());
        contentValues.put("latitude", xVar.f());
        contentValues.put("accuracy", xVar.a());
        contentValues.put("pathfile", xVar.j());
        return this.f117b.insert("TABLE_CONFIG_CALLS", null, contentValues);
    }

    public boolean a(int i) {
        SQLiteDatabase sQLiteDatabase = this.f117b;
        StringBuilder sb = new StringBuilder();
        sb.append("id = ");
        sb.append(i);
        return sQLiteDatabase.delete("TABLE_CONFIG_CALLS", sb.toString(), null) > 0;
    }
}
