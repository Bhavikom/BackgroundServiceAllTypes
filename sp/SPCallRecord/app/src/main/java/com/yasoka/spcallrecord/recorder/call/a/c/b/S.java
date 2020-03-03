package com.yasoka.spcallrecord.recorder.call.a.c.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/* compiled from: FileExplorerConfig */
public class S {

    /* renamed from: a reason: collision with root package name */
    private final Q f78a;

    /* renamed from: b reason: collision with root package name */
    private SQLiteDatabase f79b;

    public S(Context context) {
        this.f78a = new Q(context, "fileExplorer.db", null, 2);
    }

    public synchronized void a() {
        this.f79b.close();
    }

    public synchronized void b() throws SQLException {
        this.f79b = this.f78a.getWritableDatabase();
    }

    public synchronized Cursor c() {
        return this.f79b.query("TABLE_CONFIG_FILE_EXPLORER", new String[]{"id", "nameFile", "pathFile", "pathFileSave", "date"}, null, null, null, null, null);
    }

    public synchronized long a(A a2) {
        ContentValues contentValues;
        contentValues = new ContentValues();
        contentValues.put("nameFile", a2.c());
        contentValues.put("pathFile", a2.d());
        contentValues.put("pathFileSave", a2.e());
        contentValues.put("date", a2.a());
        return this.f79b.insert("TABLE_CONFIG_FILE_EXPLORER", null, contentValues);
    }

    public synchronized boolean a(int i) {
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append("id = ");
        sb.append(i);
        return this.f79b.delete("TABLE_CONFIG_FILE_EXPLORER", sb.toString(), null) > 0;
    }

    public synchronized void a(int i, A a2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("nameFile", a2.c());
        contentValues.put("pathFile", a2.d());
        contentValues.put("pathFileSave", a2.e());
        contentValues.put("date", "");
        StringBuilder sb = new StringBuilder();
        sb.append("id = ");
        sb.append(i);
        this.f79b.update("TABLE_CONFIG_FILE_EXPLORER", contentValues, sb.toString(), null);
    }
}
