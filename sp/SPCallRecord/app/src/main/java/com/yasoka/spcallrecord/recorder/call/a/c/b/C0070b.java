package com.yasoka.spcallrecord.recorder.call.a.c.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/* renamed from: a.c.b.b reason: case insensitive filesystem */
/* compiled from: AppsBlockState */
public class C0070b extends SQLiteOpenHelper {
    public C0070b(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE TABLE_CONFIG_APPS_BLOCK_STATE (id INTEGER PRIMARY KEY AUTOINCREMENT, idBBD INTEGER NOT NULL, idBDDPhone INTEGER NOT NULL, scriptWS TEXT NOT NULL);");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE TABLE_CONFIG_APPS_BLOCK_STATE;");
        sQLiteDatabase.execSQL("CREATE TABLE TABLE_CONFIG_APPS_BLOCK_STATE (id INTEGER PRIMARY KEY AUTOINCREMENT, idBBD INTEGER NOT NULL, idBDDPhone INTEGER NOT NULL, scriptWS TEXT NOT NULL);");
    }
}
