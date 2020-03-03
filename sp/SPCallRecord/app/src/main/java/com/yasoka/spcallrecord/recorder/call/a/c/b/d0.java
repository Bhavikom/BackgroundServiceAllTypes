package com.yasoka.spcallrecord.recorder.call.a.c.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: SMS */
public class d0 extends SQLiteOpenHelper {
    public d0(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE TABLE_CONFIG_SMS (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, number TEXT NOT NULL, message TEXT NOT NULL, type INTEGER, date TEXT NOT NULL, address TEXT NOT NULL, longitude TEXT NOT NULL, latitude TEXT NOT NULL, accuracy TEXT NOT NULL);");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE TABLE_CONFIG_SMS;");
        sQLiteDatabase.execSQL("CREATE TABLE TABLE_CONFIG_SMS (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, number TEXT NOT NULL, message TEXT NOT NULL, type INTEGER, date TEXT NOT NULL, address TEXT NOT NULL, longitude TEXT NOT NULL, latitude TEXT NOT NULL, accuracy TEXT NOT NULL);");
    }
}
