package com.yasoka.spcallrecord.recorder.call.a.c.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/* compiled from: ClipboardConfig */
public class N {

    /* renamed from: a reason: collision with root package name */
    private final M f74a;

    /* renamed from: b reason: collision with root package name */
    private SQLiteDatabase f75b;

    public N(Context context) {
        this.f74a = new M(context, "trackClipboards.db", null, 2);
    }

    public synchronized void a() {
        this.f75b.close();
    }

    public synchronized void b() throws SQLException {
        this.f75b = this.f74a.getWritableDatabase();
    }

    public Cursor c() {
        return this.f75b.query("TABLE_CONFIG_CLIPBOARD", new String[]{"id", "textCopied", "date"}, null, null, null, null, null);
    }

    public long a(C0092y yVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("textCopied", yVar.c());
        contentValues.put("date", yVar.a());
        return this.f75b.insert("TABLE_CONFIG_CLIPBOARD", null, contentValues);
    }

    public boolean a(int i) {
        SQLiteDatabase sQLiteDatabase = this.f75b;
        StringBuilder sb = new StringBuilder();
        sb.append("id = ");
        sb.append(i);
        return sQLiteDatabase.delete("TABLE_CONFIG_CLIPBOARD", sb.toString(), null) > 0;
    }
}
