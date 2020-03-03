package com.yasoka.spcallrecord.recorder.call.a.c.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: Restriction */
public class b0 extends SQLiteOpenHelper {
    public b0(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE TABLE_CONFIG_RESTRICTION (id INTEGER PRIMARY KEY AUTOINCREMENT, timeStart TEXT NOT NULL, timeEnd TEXT NOT NULL, listDays TEXT NOT NULL, message TEXT NOT NULL);");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE TABLE_CONFIG_RESTRICTION;");
        sQLiteDatabase.execSQL("CREATE TABLE TABLE_CONFIG_RESTRICTION (id INTEGER PRIMARY KEY AUTOINCREMENT, timeStart TEXT NOT NULL, timeEnd TEXT NOT NULL, listDays TEXT NOT NULL, message TEXT NOT NULL);");
    }
}
