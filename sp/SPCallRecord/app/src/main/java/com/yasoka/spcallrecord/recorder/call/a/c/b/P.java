package com.yasoka.spcallrecord.recorder.call.a.c.b;

import a.b.a.a.a;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/* compiled from: ContactsConfig */
public class P {

    /* renamed from: a reason: collision with root package name */
    private final O f76a;

    /* renamed from: b reason: collision with root package name */
    private SQLiteDatabase f77b;

    public P(Context context) {
        this.f76a = new O(context, "trackContacts.db", null, 2);
    }

    public synchronized void a() {
        this.f77b.close();
    }

    public synchronized void b() throws SQLException {
        this.f77b = this.f76a.getWritableDatabase();
    }

    public Cursor c() {
        return this.f77b.query("TABLE_CONFIG_CONTACTS", new String[]{"id", "name", "number", "idcontact", "date"}, null, null, null, null, null);
    }

    public long a(C0093z zVar) {
        ContentValues contentValues = new ContentValues();
        String str = "";
        StringBuilder a2 = a.a(str);
        a2.append(zVar.d());
        contentValues.put("name", a2.toString());
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(zVar.e());
        contentValues.put("number", sb.toString());
        contentValues.put("idcontact", zVar.c());
        contentValues.put("date", zVar.a());
        return this.f77b.insert("TABLE_CONFIG_CONTACTS", null, contentValues);
    }

    public boolean a(int i) {
        SQLiteDatabase sQLiteDatabase = this.f77b;
        StringBuilder sb = new StringBuilder();
        sb.append("id = ");
        sb.append(i);
        return sQLiteDatabase.delete("TABLE_CONFIG_CONTACTS", sb.toString(), null) > 0;
    }
}
