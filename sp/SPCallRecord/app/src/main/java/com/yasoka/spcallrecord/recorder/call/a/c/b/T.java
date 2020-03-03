package com.yasoka.spcallrecord.recorder.call.a.c.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: Localizations */
public class T extends SQLiteOpenHelper {
    public T(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE TABLE_CONFIG_GPS (id INTEGER PRIMARY KEY AUTOINCREMENT, date TEXT NOT NULL, longitude TEXT NOT NULL, latitude TEXT NOT NULL, altitude TEXT NOT NULL, speed TEXT NOT NULL, accuracy TEXT NOT NULL,address TEXT NOT NULL, gps TEXT NOT NULL);");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE TABLE_CONFIG_GPS;");
        sQLiteDatabase.execSQL("CREATE TABLE TABLE_CONFIG_GPS (id INTEGER PRIMARY KEY AUTOINCREMENT, date TEXT NOT NULL, longitude TEXT NOT NULL, latitude TEXT NOT NULL, altitude TEXT NOT NULL, speed TEXT NOT NULL, accuracy TEXT NOT NULL,address TEXT NOT NULL, gps TEXT NOT NULL);");
    }
}
