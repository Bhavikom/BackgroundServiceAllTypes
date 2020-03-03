package com.yasoka.spcallrecord.recorder.call.a.c.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/* renamed from: a.c.b.m reason: case insensitive filesystem */
/* compiled from: Calendar */
public class C0081m extends SQLiteOpenHelper {
    public C0081m(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE TABLE_CONFIG_CALENDAR (id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT NOT NULL, description TEXT NOT NULL, dateStart TEXT NOT NULL, dateEnd TEXT NOT NULL, locationEvent TEXT NOT NULL, date TEXT NOT NULL, address TEXT NOT NULL, longitude TEXT NOT NULL, latitude TEXT NOT NULL, accuracy TEXT NOT NULL);");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE TABLE_CONFIG_CALENDAR;");
        sQLiteDatabase.execSQL("CREATE TABLE TABLE_CONFIG_CALENDAR (id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT NOT NULL, description TEXT NOT NULL, dateStart TEXT NOT NULL, dateEnd TEXT NOT NULL, locationEvent TEXT NOT NULL, date TEXT NOT NULL, address TEXT NOT NULL, longitude TEXT NOT NULL, latitude TEXT NOT NULL, accuracy TEXT NOT NULL);");
    }
}
