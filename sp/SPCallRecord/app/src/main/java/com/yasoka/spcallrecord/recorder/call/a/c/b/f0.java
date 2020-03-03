package com.yasoka.spcallrecord.recorder.call.a.c.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/* compiled from: SMSAlertKeywordConfig */
public class f0 {

    /* renamed from: a reason: collision with root package name */
    private final e0 f96a;

    /* renamed from: b reason: collision with root package name */
    private SQLiteDatabase f97b;

    public f0(Context context) {
        this.f96a = new e0(context, "smsAlertKeyword.db", null, 1);
    }

    public synchronized void a() {
        this.f97b.close();
    }

    public synchronized void b() throws SQLException {
        this.f97b = this.f96a.getWritableDatabase();
    }

    public Cursor c() {
        return this.f97b.query("TABLE_CONFIG_SMS_ALERT", new String[]{"id", "keyword"}, null, null, null, null, null);
    }

    public long a(H h) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("keyword", h.f54a);
        return this.f97b.insert("TABLE_CONFIG_SMS_ALERT", null, contentValues);
    }

    public int a(int i) {
        SQLiteDatabase sQLiteDatabase = this.f97b;
        StringBuilder sb = new StringBuilder();
        sb.append("id = ");
        sb.append(i);
        return sQLiteDatabase.delete("TABLE_CONFIG_SMS_ALERT", sb.toString(), null);
    }
}
