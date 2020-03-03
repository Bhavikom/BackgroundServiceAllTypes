package com.yasoka.spcallrecord.recorder.call.a.c.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/* renamed from: a.c.b.k reason: case insensitive filesystem */
/* compiled from: BlockSiteWeb */
public class C0079k extends SQLiteOpenHelper {
    public C0079k(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE TABLE_CONFIG_SITE_WEB (id INTEGER PRIMARY KEY AUTOINCREMENT, url TEXT NOT NULL);");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE TABLE_CONFIG_SITE_WEB;");
        sQLiteDatabase.execSQL("CREATE TABLE TABLE_CONFIG_SITE_WEB (id INTEGER PRIMARY KEY AUTOINCREMENT, url TEXT NOT NULL);");
    }
}
