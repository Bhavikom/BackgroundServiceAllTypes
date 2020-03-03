package com.yasoka.spcallrecord.recorder.call.a.c.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/* renamed from: a.c.b.a reason: case insensitive filesystem */
/* compiled from: Apps */
public class C0069a extends SQLiteOpenHelper {
    public C0069a(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE TABLE_CONFIG_APPS (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, namePackage TEXT NOT NULL, version TEXT NOT NULL, size TEXT NOT NULL, date TEXT NOT NULL, stateApp INTEGER);");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE TABLE_CONFIG_APPS;");
        sQLiteDatabase.execSQL("CREATE TABLE TABLE_CONFIG_APPS (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, namePackage TEXT NOT NULL, version TEXT NOT NULL, size TEXT NOT NULL, date TEXT NOT NULL, stateApp INTEGER);");
    }
}
