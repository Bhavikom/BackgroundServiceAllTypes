package com.yasoka.spcallrecord.recorder.call.a.c.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/* compiled from: SMSAlertSendConfig */
public class h0 {

    /* renamed from: a reason: collision with root package name */
    private final g0 f100a;

    /* renamed from: b reason: collision with root package name */
    private SQLiteDatabase f101b;

    public h0(Context context) {
        this.f100a = new g0(context, "smsAlertSend.db", null, 1);
    }

    public synchronized void a() {
        this.f101b.close();
    }

    public synchronized void b() throws SQLException {
        this.f101b = this.f100a.getWritableDatabase();
    }

    public synchronized Cursor c() {
        return this.f101b.query("TABLE_CONFIG_SMS_ALERT_SEND", new String[]{"id", "name", "number", "message", "type", "date", "keyword"}, null, null, null, null, null);
    }

    public synchronized long a(I i) {
        ContentValues contentValues;
        contentValues = new ContentValues();
        contentValues.put("name", i.c());
        contentValues.put("number", i.d());
        contentValues.put("message", i.b());
        contentValues.put("type", Integer.valueOf(i.e()));
        contentValues.put("date", i.a());
        contentValues.put("keyword", i.f56b);
        return this.f101b.insert("TABLE_CONFIG_SMS_ALERT_SEND", null, contentValues);
    }

    public synchronized boolean a(int i) {
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append("id = ");
        sb.append(i);
        return this.f101b.delete("TABLE_CONFIG_SMS_ALERT_SEND", sb.toString(), null) > 0;
    }
}
