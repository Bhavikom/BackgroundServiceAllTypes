package com.yasoka.spcallrecord.recorder.call.a.c.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: Media */
public class Z extends SQLiteOpenHelper {
    public Z(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE TABLE_CONFIG_MEDIA (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, picture TEXT NOT NULL, size TEXT NOT NULL, date TEXT NOT NULL, address TEXT NOT NULL,longitude TEXT NOT NULL, latitude TEXT NOT NULL, accuracy TEXT NOT NULL);");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE TABLE_CONFIG_MEDIA;");
        sQLiteDatabase.execSQL("CREATE TABLE TABLE_CONFIG_MEDIA (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, picture TEXT NOT NULL, size TEXT NOT NULL, date TEXT NOT NULL, address TEXT NOT NULL,longitude TEXT NOT NULL, latitude TEXT NOT NULL, accuracy TEXT NOT NULL);");
    }
}
