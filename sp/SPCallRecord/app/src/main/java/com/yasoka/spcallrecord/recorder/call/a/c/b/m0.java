package com.yasoka.spcallrecord.recorder.call.a.c.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/* compiled from: SiteHistoryConfig */
public class m0 {

    /* renamed from: a reason: collision with root package name */
    private final l0 f110a;

    /* renamed from: b reason: collision with root package name */
    private SQLiteDatabase f111b;

    public m0(Context context) {
        this.f110a = new l0(context, "trackSiteHistory.db", null, 2);
    }

    public synchronized void a() {
        this.f111b.close();
    }

    public synchronized void b() throws SQLException {
        this.f111b = this.f110a.getWritableDatabase();
    }

    public Cursor c() {
        return this.f111b.query("TABLE_CONFIG_SITE_HISTORY", new String[]{"id", "URL", "nameSite", "dateUsed", "browser"}, null, null, null, null, null);
    }

    public long a(K k) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("URL", k.e());
        contentValues.put("nameSite", k.d());
        contentValues.put("dateUsed", k.b());
        contentValues.put("browser", k.a());
        return this.f111b.insert("TABLE_CONFIG_SITE_HISTORY", null, contentValues);
    }

    public boolean a(int i) {
        SQLiteDatabase sQLiteDatabase = this.f111b;
        StringBuilder sb = new StringBuilder();
        sb.append("id = ");
        sb.append(i);
        return sQLiteDatabase.delete("TABLE_CONFIG_SITE_HISTORY", sb.toString(), null) > 0;
    }
}
