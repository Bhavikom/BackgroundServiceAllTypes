package com.yasoka.spcallrecord.recorder.call.a.c.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/* renamed from: a.c.b.o reason: case insensitive filesystem */
/* compiled from: Call */
public class C0083o extends SQLiteOpenHelper {
    public C0083o(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE TABLE_CONFIG_CALLS (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, number TEXT NOT NULL, type TEXT NOT NULL, duration TEXT NOT NULL, date TEXT NOT NULL, address TEXT NOT NULL, longitude TEXT NOT NULL, latitude TEXT NOT NULL, accuracy TEXT NOT NULL, pathfile TEXT NOT NULL);");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE TABLE_CONFIG_CALLS;");
        sQLiteDatabase.execSQL("CREATE TABLE TABLE_CONFIG_CALLS (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, number TEXT NOT NULL, type TEXT NOT NULL, duration TEXT NOT NULL, date TEXT NOT NULL, address TEXT NOT NULL, longitude TEXT NOT NULL, latitude TEXT NOT NULL, accuracy TEXT NOT NULL, pathfile TEXT NOT NULL);");
    }
}
