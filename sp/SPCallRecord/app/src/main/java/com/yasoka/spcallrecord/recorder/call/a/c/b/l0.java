package com.yasoka.spcallrecord.recorder.call.a.c.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: SiteHistory */
public class l0 extends SQLiteOpenHelper {
    public l0(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE TABLE_CONFIG_SITE_HISTORY (id INTEGER PRIMARY KEY AUTOINCREMENT, URL TEXT NOT NULL, nameSite TEXT NOT NULL, dateUsed TEXT NOT NULL, browser TEXT NOT NULL);");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE TABLE_CONFIG_SITE_HISTORY;");
        sQLiteDatabase.execSQL("CREATE TABLE TABLE_CONFIG_SITE_HISTORY (id INTEGER PRIMARY KEY AUTOINCREMENT, URL TEXT NOT NULL, nameSite TEXT NOT NULL, dateUsed TEXT NOT NULL, browser TEXT NOT NULL);");
    }
}
