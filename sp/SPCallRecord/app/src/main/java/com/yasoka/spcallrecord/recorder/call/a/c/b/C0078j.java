package com.yasoka.spcallrecord.recorder.call.a.c.b;

import a.b.a.a.a;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/* renamed from: a.c.b.j reason: case insensitive filesystem */
/* compiled from: BlockCallsConfig */
public class C0078j {

    /* renamed from: a reason: collision with root package name */
    private final C0077i f104a;

    /* renamed from: b reason: collision with root package name */
    private SQLiteDatabase f105b;

    public C0078j(Context context) {
        this.f104a = new C0077i(context, "blockCalls.db", null, 1);
    }

    public synchronized void a() {
        this.f105b.close();
    }

    public synchronized void b() throws SQLException {
        this.f105b = this.f104a.getWritableDatabase();
    }

    public Cursor c() {
        return this.f105b.query("TABLE_CONFIG_BLOCK_CALLS", new String[]{"id", "number", "type"}, null, null, null, null, null);
    }

    public long a(C0088u uVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("number", uVar.f134a);
        contentValues.put("type", uVar.f135b);
        return this.f105b.insert("TABLE_CONFIG_BLOCK_CALLS", null, contentValues);
    }

    public int a(int i) {
        SQLiteDatabase sQLiteDatabase = this.f105b;
        StringBuilder sb = new StringBuilder();
        sb.append("id = ");
        sb.append(i);
        return sQLiteDatabase.delete("TABLE_CONFIG_BLOCK_CALLS", sb.toString(), null);
    }

    public Cursor a(String str) {
        return this.f105b.query("TABLE_CONFIG_BLOCK_CALLS", new String[]{"id", "number", "type"}, a.a("type LIKE \"", str, "\""), null, null, null, null);
    }
}
