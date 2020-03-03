package com.yasoka.spcallrecord.recorder.call.a.c.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: Screenshot */
public class j0 extends SQLiteOpenHelper {
    public j0(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE TABLE_CONFIG_SCREENSHOT (id INTEGER PRIMARY KEY AUTOINCREMENT, picture TEXT NOT NULL, uploadedfile TEXT NOT NULL, date TEXT NOT NULL);");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE TABLE_CONFIG_SCREENSHOT;");
        sQLiteDatabase.execSQL("CREATE TABLE TABLE_CONFIG_SCREENSHOT (id INTEGER PRIMARY KEY AUTOINCREMENT, picture TEXT NOT NULL, uploadedfile TEXT NOT NULL, date TEXT NOT NULL);");
    }
}
