package com.yasoka.spcallrecord.recorder.call.a.c.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/* renamed from: a.c.b.g reason: case insensitive filesystem */
/* compiled from: BlockApps */
public class C0075g extends SQLiteOpenHelper {
    public C0075g(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE TABLE_CONFIG_BLOCK_APPS (id INTEGER PRIMARY KEY AUTOINCREMENT, name_package TEXT NOT NULL, timeStart TEXT NOT NULL, timeEnd TEXT NOT NULL, listDays TEXT NOT NULL, message TEXT NOT NULL);");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE TABLE_CONFIG_BLOCK_APPS;");
        sQLiteDatabase.execSQL("CREATE TABLE TABLE_CONFIG_BLOCK_APPS (id INTEGER PRIMARY KEY AUTOINCREMENT, name_package TEXT NOT NULL, timeStart TEXT NOT NULL, timeEnd TEXT NOT NULL, listDays TEXT NOT NULL, message TEXT NOT NULL);");
    }
}
