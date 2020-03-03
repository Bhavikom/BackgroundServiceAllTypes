package com.yasoka.spcallrecord.recorder.call.a.c.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/* renamed from: a.c.b.l reason: case insensitive filesystem */
/* compiled from: BlockSiteWebConfig */
public class C0080l {

    /* renamed from: a reason: collision with root package name */
    private final C0079k f108a;

    /* renamed from: b reason: collision with root package name */
    private SQLiteDatabase f109b;

    public C0080l(Context context) {
        this.f108a = new C0079k(context, "blockURL.db", null, 1);
    }

    public synchronized void a() {
        this.f109b.close();
    }

    public synchronized void b() throws SQLException {
        this.f109b = this.f108a.getWritableDatabase();
    }

    public Cursor c() {
        return this.f109b.query("TABLE_CONFIG_SITE_WEB", new String[]{"id", "url"}, null, null, null, null, null);
    }

    public long a(C0089v vVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("url", vVar.f136a);
        return this.f109b.insert("TABLE_CONFIG_SITE_WEB", null, contentValues);
    }

    public int a(int i) {
        SQLiteDatabase sQLiteDatabase = this.f109b;
        StringBuilder sb = new StringBuilder();
        sb.append("id = ");
        sb.append(i);
        return sQLiteDatabase.delete("TABLE_CONFIG_SITE_WEB", sb.toString(), null);
    }
}
