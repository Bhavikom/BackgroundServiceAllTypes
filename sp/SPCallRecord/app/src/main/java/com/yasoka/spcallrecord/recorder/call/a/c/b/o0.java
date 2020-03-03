package com.yasoka.spcallrecord.recorder.call.a.c.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/* compiled from: SocialNetworkConfig */
public class o0 {

    /* renamed from: a reason: collision with root package name */
    private final n0 f114a;

    /* renamed from: b reason: collision with root package name */
    private SQLiteDatabase f115b;

    public o0(Context context) {
        this.f114a = new n0(context, "trackSocialNetwork.db", null, 1);
    }

    public synchronized void a() {
        this.f115b.close();
    }

    public synchronized void b() throws SQLException {
        this.f115b = this.f114a.getWritableDatabase();
    }

    public Cursor c() {
        return this.f115b.query("TABLE_CONFIG_SOCIAL_NETWORK", new String[]{"id", "fullName", "message", "type", "date", "urlScript"}, null, null, null, null, null);
    }

    public long a(L l) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("fullName", l.b());
        contentValues.put("message", l.d());
        contentValues.put("type", l.e());
        contentValues.put("date", l.a());
        contentValues.put("urlScript", l.f());
        return this.f115b.insert("TABLE_CONFIG_SOCIAL_NETWORK", null, contentValues);
    }

    public boolean a(int i) {
        SQLiteDatabase sQLiteDatabase = this.f115b;
        StringBuilder sb = new StringBuilder();
        sb.append("id = ");
        sb.append(i);
        return sQLiteDatabase.delete("TABLE_CONFIG_SOCIAL_NETWORK", sb.toString(), null) > 0;
    }
}
